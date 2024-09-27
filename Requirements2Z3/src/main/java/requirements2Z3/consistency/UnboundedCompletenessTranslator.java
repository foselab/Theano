package requirements2Z3.consistency;

import requirements2Z3.rqt.PFormula;
import requirements2Z3.rqt.RT;
import requirements2Z3.rqt.Variable;
import requirements2Z3.visitors.GetOutputVariablesVisitor;
import requirements2Z3.visitors.GetPreconditionsVariableVisitor;
import requirements2Z3.visitors.translators.UnboundedVisitor;
import requirements2Z3.z3formulae.Z3Formula;

public class UnboundedCompletenessTranslator implements Functionality<UnboundedVisitor> {

	@Override
	public String printPositiveResult() {
		return "\t print('Requirements Table Complete (unsat)')\n";
	}

	@Override
	public String printNegativeResult() {
		return "\t\t print('Requirements Table Incomplete (sat)')\n";
	}

	private Z3Formula getEncodingOutputVariable(UnboundedVisitor z3visitor, RT tree) {

		Z3Formula encodingOutputVariables = Z3Formula.getFalse();

		
		for (Variable outputVariable : tree.accept(new GetOutputVariablesVisitor())) {

			Z3Formula encodingForAnOutputVariable = Z3Formula.getTrue();

			for (PFormula precondition : tree.accept(new GetPreconditionsVariableVisitor(outputVariable))) {
					encodingForAnOutputVariable = Z3Formula.getAnd(encodingForAnOutputVariable,
							Z3Formula.getNot(precondition.accept(z3visitor)));
			}
			encodingOutputVariables=Z3Formula.getOr(encodingOutputVariables, encodingForAnOutputVariable);
		}

		return encodingOutputVariables;
	}

	public Z3Formula getEncodingActivity(UnboundedVisitor z3visitor, RT tree) {

		return getEncodingOutputVariable(z3visitor, tree);

	}
}
