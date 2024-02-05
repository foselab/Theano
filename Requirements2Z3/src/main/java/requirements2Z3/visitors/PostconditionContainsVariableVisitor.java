package requirements2Z3.visitors;

import java.util.Set;

import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabBaseVisitor;
import generated.matlabLexer;

/**
 * This visitor is used to define the variables of the Z3 files based on the
 * variables used in the Requirements Table
 */
public class PostconditionContainsVariableVisitor extends matlabBaseVisitor<Boolean> {

	private Set<String> variables;

	public PostconditionContainsVariableVisitor(Set<String> variables) {
		this.variables = variables;
	}

	@Override
	public Boolean visitChildren(RuleNode node) {
		Boolean ret = false;
		for (int i = 0; i < node.getChildCount(); i++) {
			ret = ret | (node.getChild(i).accept(this));
		}
		return ret;
	}

	protected Boolean aggregateResult(Boolean aggregate, Boolean nextResult) {
		return aggregate || nextResult;
	}

	@Override
	public Boolean visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() == matlabLexer.IDENTIFIER) {

			return this.variables.contains(node.getSymbol().getText());
		}
		return false;
	}

}
