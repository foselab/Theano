package requirements2Z3.consistency;

import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabParser.RequirementContext;
import requirements2Z3.visitors.GetOutputVariablesVisitor;
import requirements2Z3.visitors.GetRequirementsVariableVisitor;
import requirements2Z3.visitors.translators.BoundedVisitor;

public class BoundedConsistencyTranslator implements Functionality<BoundedVisitor> {

	@Override
	public String printPositiveResult() {
		return "\t print('Requirements Table Consistent (unsat)')\n";
	}

	@Override
	public String printNegativeResult() {
		return "\t\t print('Requirements Table Not Consistent (sat)')\n";
	}

	public String getEncodingActivity(BoundedVisitor z3visitor, ParseTree tree) {

		Set<String> outputVariables = tree.accept(new GetOutputVariablesVisitor());

		String encodingRequirements = "And(";

		boolean firstVariable = true;
		for (String outputVariable : outputVariables) {
			if (firstVariable == true) {
				encodingRequirements = encodingRequirements
						+ getEncodingOutputVariable(z3visitor, tree, outputVariable);
			} else {
				encodingRequirements = encodingRequirements + ","
						+ getEncodingOutputVariable(z3visitor, tree, outputVariable);
			}
		}
		encodingRequirements = encodingRequirements + ")";

		String outputVariablesString = "";

		firstVariable = true;
		for (String outputVariable : outputVariables) {
			if (firstVariable == true) {
				outputVariablesString = outputVariable;
				firstVariable = false;
			} else {
				outputVariablesString = outputVariablesString + "," + outputVariable;
			}
		}

		return "ForAll([" + outputVariablesString + "] , " + encodingRequirements + ")";

	}

	protected String getEncodingOutputVariable(BoundedVisitor z3visitor, ParseTree tree, String outputVariable) {
		boolean firstRequirement = true;
		String encodingRequirements = "Or(";

		for (int currentIndexI = 0; currentIndexI < z3visitor.getBound(); currentIndexI++) {

			for (RequirementContext requirement : tree.accept(new GetRequirementsVariableVisitor(outputVariable))) {

				if (firstRequirement) {

					encodingRequirements = "Not(" + requirement.accept(z3visitor) + ")";
					firstRequirement = false;
				} else {
					encodingRequirements = encodingRequirements + ",Not(" + requirement.accept(z3visitor) + ")";

				}
			}
			z3visitor.increaseIndex();

		}
		z3visitor.resetIndex();
		return encodingRequirements + ")";

	}
}
