package requirements2Z3.completeness.visitors;

import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabParser.Dur_expressionContext;
import generated.matlabParser.Prev_expressionContext;
import generated.matlabVisitor;

public class BeUfFs extends CompletenessVisitor implements matlabVisitor<String> {

	private int index;

	private float ts;

	public BeUfFs(int index, float ts) {
		this.index = index;
		this.ts = ts;
	}

	@Override
	public String visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() == matlabLexer.IDENTIFIER) {
			return node.getText() + "(" + index + ")";
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
			b.append(ctx.getChild(2).getText() + "(" + (index) + ")");
		} else {
			b.append(ctx.getChild(2).getText() + "(" + (index - 1) + ")");
		}
		return b.toString();
	}

	@Override
	public String visitDur_expression(Dur_expressionContext ctx) {

		String constant = ctx.getChild(5).getText();

		String part1 = "tau[i]>=" + constant;
		String part2 = constant + ">=Ts";

		String part3 = "And(";

		int lb = (int) (index - Float.parseFloat(constant) / this.ts);

		for (int n = lb; n <= index; n++) {
			part3 = part3 + ctx.getChild(2).accept(new BeUfFs(n, this.ts));
			if (n != index) {
				part3 = part3 + ",";
			}
		}
		part3 = part3 + ")";

		return "And(" + part1 + "," + part2 + "," + part3 + ")";
	}
}
