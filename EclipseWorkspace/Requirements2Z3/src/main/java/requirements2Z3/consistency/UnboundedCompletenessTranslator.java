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
		return "\t\t print('Requirements Table Incomplete (sat)')\n";
	}

	private String getEncodingOutputVariable(UnboundedVisitor z3visitor, ParseTree tree) {

		StringBuilder encodingOutpuVariables = new StringBuilder();
		boolean firstOutputVariables = true;

		encodingOutpuVariables.append("Or(");
		for (String outputVariable : tree.accept(new GetOutputVariablesVisitor())) {

			boolean firstPrecondition = true;

			String encodingForAnOutputVariable = "And(";

			for (PreconditionContext precondition : tree.accept(new GetPreconditionsVariableVisitor(outputVariable))) {
				if (firstPrecondition) {
					encodingForAnOutputVariable = encodingForAnOutputVariable + "Not(" + precondition.accept(z3visitor)
							+ ")";

					firstPrecondition = false;
				} else {
					encodingForAnOutputVariable = encodingForAnOutputVariable + ",Not("
							+ precondition.accept(z3visitor) + ")";
				}
			}
			encodingForAnOutputVariable=encodingForAnOutputVariable+")";

			// if a precondition related to that output variable is found
			if (!firstPrecondition) {
				if (firstOutputVariables) {
					encodingOutpuVariables.append(encodingForAnOutputVariable);
					firstOutputVariables = false;
				} else {
					encodingOutpuVariables.append("," + encodingForAnOutputVariable);
				}
			}
		}
		encodingOutpuVariables.append(")");
		// if no constraint it found for any output variable
		if (firstOutputVariables) {
			return "True";
		}
		return encodingOutpuVariables.toString();
	}

	public String getEncodingActivity(UnboundedVisitor z3visitor, ParseTree tree) {

		return getEncodingOutputVariable(z3visitor, tree);

	}
}
