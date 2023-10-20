package requirements2Z3.consistency;

import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabParser.PreconditionContext;
import requirements2Z3.visitors.GetOutputVariablesVisitor;
import requirements2Z3.visitors.GetPreconditionsVariableVisitor;
import requirements2Z3.visitors.translators.BoundedVisitor;

public class BoundedCompletenessTranslator implements Functionality<BoundedVisitor> {

	public String getEncodingActivity(BoundedVisitor z3visitor, ParseTree tree) {
		boolean firstOutputVariables = true;
		String encodingOutpuVariables = "";

		String encodingIndex = "Or(";

		Set<String> outputVariables = tree.accept(new GetOutputVariablesVisitor());

		for (int currentIndexI = 0; currentIndexI <= z3visitor.getBound(); currentIndexI++) {
			for (String outputVariable : outputVariables) {

				String encodingForAnOutputVariable = "";
				boolean firstPrecondition = true;

				for (PreconditionContext precondition : tree
						.accept(new GetPreconditionsVariableVisitor(outputVariable))) {
					if (firstPrecondition) {
						encodingForAnOutputVariable = "Not(" + precondition.accept(z3visitor) + ")";

						firstPrecondition = false;
					} else {
						encodingForAnOutputVariable = "And(" + encodingForAnOutputVariable + ",Not("
								+ precondition.accept(z3visitor) + "))";
					}
				}

				if (firstOutputVariables) {
					encodingOutpuVariables = encodingForAnOutputVariable;
					firstOutputVariables = false;
				} else {
					encodingOutpuVariables = "Or(" + encodingOutpuVariables + "," + encodingForAnOutputVariable + ")";
				}
				if (currentIndexI < z3visitor.getBound()) {
					encodingOutpuVariables = encodingOutpuVariables + ",";
				}

			}
			z3visitor.increaseIndex();
			encodingIndex = encodingIndex + encodingOutpuVariables;

		}
		return encodingIndex + ")";
	}

	@Override
	public String printPositiveResult() {
		return "\t print('Requirements Table Complete (unsat)')\n";
	}

	@Override
	public String printNegativeResult() {
		return "\t\t print('Requirements Table InComplete (sat)')\n";
	}
}
