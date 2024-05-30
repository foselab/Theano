package requirements2Z3.consistency;

import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabParser.PreconditionContext;
import requirements2Z3.visitors.GetOutputVariablesVisitor;
import requirements2Z3.visitors.GetPreconditionsVariableVisitor;
import requirements2Z3.visitors.translators.BoundedVisitor;
import requirements2Z3.z3formulae.Z3Formula;

public class BoundedCompletenessTranslator implements Functionality<BoundedVisitor> {

	public Z3Formula getEncodingActivity(BoundedVisitor z3visitor, ParseTree tree) {
		Z3Formula encodingOutpuVariables = Z3Formula.getFalse();

		Set<String> outputVariables = tree.accept(new GetOutputVariablesVisitor());

		for (int currentIndexI = 0; currentIndexI <= z3visitor.getBound(); currentIndexI++) {
			for (String outputVariable : outputVariables) {

				Z3Formula encodingForAnOutputVariable = Z3Formula.getTrue();
				
				for (PreconditionContext precondition : tree
						.accept(new GetPreconditionsVariableVisitor(outputVariable))) {
					encodingForAnOutputVariable=Z3Formula.getAnd(encodingForAnOutputVariable, Z3Formula.getNot(precondition.accept(z3visitor)));
				}
				encodingOutpuVariables = Z3Formula.getOr(encodingOutpuVariables, encodingForAnOutputVariable);
			}
			z3visitor.increaseIndex();
		}
		return encodingOutpuVariables;
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
