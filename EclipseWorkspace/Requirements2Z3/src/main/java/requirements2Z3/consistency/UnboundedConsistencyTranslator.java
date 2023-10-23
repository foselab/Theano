package requirements2Z3.consistency;

import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;

import requirements2Z3.visitors.GetOutputVariablesVisitor;
import requirements2Z3.visitors.translators.UnboundedVisitor;

public class UnboundedConsistencyTranslator implements Functionality<UnboundedVisitor>  {

	@Override
	public String printPositiveResult() {
		return "\t print('Requirements Table Consistent (unsat)')\n";
	}

	@Override
	public String printNegativeResult() {
		return "\t\t print('Requirements Table Not Consistent (sat)')\n";
	}

	@Override
	public String getEncodingActivity(UnboundedVisitor z3visitor, ParseTree tree) {

		String encodingRequirements = getEncodingRequirements(z3visitor, tree);

		String outputVariables = "";

		Set<String> outputVariablesSet = tree.accept(new GetOutputVariablesVisitor());

		boolean firstVariable = true;
		for (String outputVariable : outputVariablesSet) {
			if (firstVariable == true) {
				outputVariables = outputVariable;
				firstVariable = false;
			} else {
				outputVariables = outputVariables + "," + outputVariable;
			}
		}

		return "ForAll([" + outputVariables + "] , " + encodingRequirements + ")";

	}

	private String getEncodingRequirements(UnboundedVisitor z3visitor, ParseTree tree) {
		String encodingRequirements = tree.accept(z3visitor);
		encodingRequirements = "Exists(i,Not(" + encodingRequirements + "))";
		return encodingRequirements;
	}
}
