package requirements2Z3.consistency;

import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabParser.RequirementContext;
import requirements2Z3.rqt.RQTable;
import requirements2Z3.rqt.Requirement;
import requirements2Z3.rqt.Variable;
import requirements2Z3.visitors.GetOutputVariablesVisitor;
import requirements2Z3.visitors.GetRequirementsVariableVisitor;
import requirements2Z3.visitors.translators.BoundedVisitor;
import requirements2Z3.z3formulae.Z3Formula;

public class BoundedConsistencyTranslator implements Functionality<BoundedVisitor> {

	@Override
	public String printPositiveResult() {
		return "\t print('Requirements Table Consistent (unsat)')\n";
	}

	@Override
	public String printNegativeResult() {
		return "\t\t print('Requirements Table Not Consistent (sat)')\n";
	}

	public Z3Formula getEncodingActivity(BoundedVisitor z3visitor, RQTable tree) {

		Set<Variable> outputVariables = tree.accept(new GetOutputVariablesVisitor());

		Z3Formula encodingRequirements = Z3Formula.getFalse();

		for (Variable outputVariable : outputVariables) {
			encodingRequirements = Z3Formula.getOr(encodingRequirements,
					getEncodingOutputVariable(z3visitor, tree, outputVariable));

		}

		String outputVariablesString = "";
		boolean firstVariable = true;
		for (Variable outputVariable : outputVariables) {
			if (firstVariable == true) {
				outputVariablesString = outputVariable.getName();
				firstVariable = false;
			} else {
				outputVariablesString = outputVariablesString + "," + outputVariable.getName();
			}
		}

		return Z3Formula.getForAll("[" + outputVariablesString + "]", encodingRequirements);

	}

	protected Z3Formula getEncodingOutputVariable(BoundedVisitor z3visitor, RQTable tree, Variable outputVariable) {
		Z3Formula encodingRequirements = Z3Formula.getFalse();

		for (int currentIndexI = 0; currentIndexI < z3visitor.getBound(); currentIndexI++) {

			for (Requirement requirement : tree.accept(new GetRequirementsVariableVisitor(outputVariable))) {

				encodingRequirements = Z3Formula.getOr(encodingRequirements,
						Z3Formula.getNot(requirement.accept(z3visitor)));
			}
			z3visitor.increaseIndex();
		}
		
		z3visitor.resetIndex();
		return encodingRequirements;
	}
}
