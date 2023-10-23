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
		String encodingOutpuVariables = "Or(";
		
		Set<String> outputVariables = tree.accept(new GetOutputVariablesVisitor());

		for (int currentIndexI = 0; currentIndexI <= z3visitor.getBound(); currentIndexI++) {
			for (String outputVariable : outputVariables) {

				String encodingForAnOutputVariable = "And(";
				boolean firstPrecondition = true;

				for (PreconditionContext precondition : tree
						.accept(new GetPreconditionsVariableVisitor(outputVariable))) {
					if (firstPrecondition) {
						encodingForAnOutputVariable = encodingForAnOutputVariable+"Not(" + precondition.accept(z3visitor) + ")";
						firstPrecondition = false;
					} else {
						encodingForAnOutputVariable = encodingForAnOutputVariable + ",Not("
								+ precondition.accept(z3visitor) + ")";
					}
				}
				if(firstPrecondition) {
					encodingForAnOutputVariable=encodingForAnOutputVariable+"True";
				}
				encodingForAnOutputVariable=encodingForAnOutputVariable+")";
				
				// if a precondition related to that output variable is found
				if (!firstPrecondition) {
					if (firstOutputVariables) {
						encodingOutpuVariables = encodingOutpuVariables+encodingForAnOutputVariable;
						firstOutputVariables = false;
					} else {
						encodingOutpuVariables = encodingOutpuVariables + "," + encodingForAnOutputVariable;
					}
				}

			}
			z3visitor.increaseIndex();
		}
		// if no constraint it found for any output variable
		if (firstOutputVariables) {
			return "True";
		}
		return encodingOutpuVariables + ")";
	}

	@Override
	public String printPositiveResult() {
		return "\t print('Requirements Table Complete (unsat)')\n";
	}

	@Override
	public String printNegativeResult() {
		return "\t\t print('Requirements Table Incomplete (sat)')\n";
	}
}
