package requirements2Z3.visitors;

import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabParser.Dur_expressionContext;
import generated.matlabParser.Is_not_startupContext;
import generated.matlabParser.Is_startupContext;
import generated.matlabParser.Prev_expressionContext;
import generated.matlabVisitor;


/**
* This class represents the Bounded Encoding  based on arrays, finite step
* 
* @author  Claudio Menghi
* @version 1.0
* @since   2023-10-03
*/
public class BeArFs extends Z3Visitor implements matlabVisitor<String> {

	private int index;

	private float ts;

	/*
	 * 
	 */
	public BeArFs(int index, float ts) {
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

		String part1 = "tau[i]>=" + constant;
		String part2 = constant + ">=Ts";

		String part3 = "And(";

		int lb = (int) (index - Float.parseFloat(constant) / this.ts);

		for (int n = lb; n <= index; n++) {
			part3 = part3 + ctx.getChild(2).accept(new BeArFs(n, this.ts));
			if (n != index) {
				part3 = part3 + ",";
			}
		}
		part3 = part3 + ")";

		return "And(" + part1 + "," + part2 + "," + part3 + ")";
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
