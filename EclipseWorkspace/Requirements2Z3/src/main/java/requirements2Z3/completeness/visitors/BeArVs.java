package requirements2Z3.completeness.visitors;

import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabParser.Dur_expressionContext;
import generated.matlabParser.Prev_expressionContext;
import generated.matlabVisitor;

public class BeArVs extends CompletenessVisitor implements matlabVisitor<String> {

	private int index;

	private float ts;

	public BeArVs(int index, float ts) {
		this.index = index;
		this.ts = ts;
	}

	@Override
	public String visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() == matlabLexer.IDENTIFIER) {
			return node.getText() + "[" + index + "]";
		}
		if (node.getSymbol().getType() == matlabLexer.CONSTANT) {
			return node.getText();
		}
		if (node.getSymbol().getType() == matlabLexer.NE_OP) {
			return "!=";
		}
		if (node.getSymbol().getType() == matlabLexer.CR) {
			return "";
		}
		return node.getText();
	}

	@Override
	public String visitPrev_expression(Prev_expressionContext ctx) {

		StringBuilder b = new StringBuilder();
		if (index == 0) {
			b.append(ctx.getChild(2).getText() + "[" + (index) + "]");
		} else {
			b.append(ctx.getChild(2).getText() + "[" + (index - 1) + "]");
		}
		return b.toString();
	}

	@Override
	public String visitDur_expression(Dur_expressionContext ctx) {

		String constant = ctx.getChild(5).getText();

		String part3 = "And(";
		for (int j = 0; j <= index; j++) {

			String innerAnd = "And(";

			innerAnd = innerAnd + "tau[" + index + "]-tau[" + j + "]>=" + constant + ",";
			String nAnd = "And(";
			for (int n = j; n <= index; n++) {
				nAnd = nAnd + ctx.getChild(2).accept(new BeArVs(n,this.ts));
				if (n != index) {
					nAnd = nAnd + ",";
				}
			}
			nAnd = nAnd + ")";

			innerAnd = nAnd + ")";
			part3 = part3 + innerAnd;
			if (j != index) {
				part3 = part3 + ",";
			}
		}
		part3 = part3 + ")";

		return part3;
	}
}
