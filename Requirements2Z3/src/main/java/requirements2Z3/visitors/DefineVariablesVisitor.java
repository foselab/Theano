package requirements2Z3.visitors;

import org.antlr.v4.runtime.tree.RuleNode;

import generated.matlabBaseVisitor;
import generated.matlabParser;
import generated.matlabParser.VariabledefinitionContext;

/**
 * This visitor is used to define the variables of the Z3 files based on the
 * variables used in the Requirements Table
 */
public class DefineVariablesVisitor extends matlabBaseVisitor<String> {

	@Override
	public String visitChildren(RuleNode node) {
		if (node instanceof VariabledefinitionContext) {
			return this.visitVariabledefinition((VariabledefinitionContext) node);
		} else {
			return super.visitChildren(node);
		}
	}

	protected String aggregateResult(String aggregate, String nextResult) {

		String res = null;
		if (aggregate == null) {
			res = nextResult;
		} else {
			if (nextResult == null) {
				res = aggregate;
			} else {
				res = aggregate + nextResult;
			}
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String visitVariabledefinition(matlabParser.VariabledefinitionContext ctx) {

		String id = ctx.getChild(0).getText();
		if (ctx.getChild(2).getText().equals("Int")) {
			return id + "=Array('" + id + "',I,I)\n";
		}
		return id + "=Array('" + id + "',I,R)\n";

	}

}
