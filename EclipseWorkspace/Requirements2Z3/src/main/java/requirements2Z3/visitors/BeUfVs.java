package requirements2Z3.visitors;

import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabParser.Dur_expressionContext;
import generated.matlabParser.Is_not_startupContext;
import generated.matlabParser.Is_startupContext;
import generated.matlabParser.Prev_expressionContext;
import generated.matlabVisitor;

public class BeUfVs extends Z3Visitor implements matlabVisitor<String> {

	private int index;


	public BeUfVs(int index) {
		this.index = index;
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

			innerAnd = innerAnd + "tau(" + index + ")-tau(" + j + ")>=" + constant + ",";
			String nAnd = "And(";
			for (int n = j; n <= index; n++) {
				nAnd = nAnd + ctx.getChild(2).accept(new BeUfVs(n));
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
	
	@Override
	public String visitIs_startup(Is_startupContext ctx) {
		if(index==0) {
			return "True";
		}
		else {
			return "False";
		}
	}

	@Override
	public String visitIs_not_startup(Is_not_startupContext ctx) {
		if(index==0) {
			return "False";
		}
		else {
			return "True";
		}
	}
}
