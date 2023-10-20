package requirements2Z3.visitors;

import org.antlr.v4.runtime.tree.RuleNode;

import generated.matlabBaseVisitor;
import generated.matlabParser.VariabledefinitionContext;

/**
 * This visitor is used to define the variables of the Z3 files based on the
 * variables used in the Requirements Table
 */
public class ContainsVariableVisitor extends matlabBaseVisitor<Boolean> {

	

	@Override
	public Boolean visitChildren(RuleNode node) {
		if (node instanceof VariabledefinitionContext) {
			return this.visitVariabledefinition((VariabledefinitionContext) node);
		} else {
			return super.visitChildren(node);
		}
	}

	

	protected Boolean aggregateResult(Boolean aggregate, Boolean nextResult) {
		return aggregate || nextResult;
	}

}
