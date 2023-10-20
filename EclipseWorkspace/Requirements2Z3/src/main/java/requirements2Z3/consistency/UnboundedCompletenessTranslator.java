package requirements2Z3.consistency;

import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabParser.PreconditionContext;
import requirements2Z3.visitors.GetInputVariablesVisitor;
import requirements2Z3.visitors.GetOutputVariablesVisitor;
import requirements2Z3.visitors.GetPreconditionsVariableVisitor;
import requirements2Z3.visitors.translators.UnboundedVisitor;

public class UnboundedCompletenessTranslator implements Functionality<UnboundedVisitor> {

	@Override
	public String printPositiveResult() {
		return "\t print('Requirements Table Complete (unsat)')\n";
	}

	@Override
	public String printNegativeResult() {
		return "\t\t print('Requirements Table InComplete (sat)')\n";
	}

	private String getEncodingOutputVariable(UnboundedVisitor z3visitor, ParseTree tree) {

		StringBuilder encodingOutpuVariables = new StringBuilder();
		boolean firstOutputVariables = true;

		for (String outputVariable : tree.accept(new GetOutputVariablesVisitor())) {

			String encodingForAnOutputVariable = "";
			boolean firstPrecondition = true;

			for (PreconditionContext precondition : tree.accept(new GetPreconditionsVariableVisitor(outputVariable))) {
				if (firstPrecondition) {
					encodingForAnOutputVariable = "Not(" + precondition.accept(z3visitor) + ")";

					firstPrecondition = false;
				} else {
					encodingForAnOutputVariable = "And(" + encodingForAnOutputVariable + ",Not("
							+ precondition.accept(z3visitor) + "))";
				}
			}

			if (firstOutputVariables) {
				encodingOutpuVariables.append(encodingForAnOutputVariable);
				firstOutputVariables = false;
			} else {
				encodingOutpuVariables.append("Or(" + encodingOutpuVariables + "," + encodingForAnOutputVariable + ")");
			}
		}
		return encodingOutpuVariables.toString();
	}

	public String getEncodingActivity(UnboundedVisitor z3visitor, ParseTree tree) {

		String encodingOutpuVariables = getEncodingOutputVariable(z3visitor, tree);

		String inputVariableStrings = "";

		boolean first = true;

		for (String inputVariable : tree.accept(new GetInputVariablesVisitor())) {
			if (first == true) {
				inputVariableStrings = inputVariable;
				first = false;
			} else {
				inputVariableStrings = inputVariableStrings + ", " + inputVariable;
			}
		}

		return "ForAll([" + inputVariableStrings + "]," + encodingOutpuVariables + ")";
	}
}
