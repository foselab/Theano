package requirements2Z3.visitors;

import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabParser.Dur_expressionContext;
import generated.matlabParser.Prev_expressionContext;
import generated.matlabVisitor;

public class UeArVs extends Z3Visitor implements matlabVisitor<String> {

	@Override
	public String visitTerminal(TerminalNode node) {
		if(node.getSymbol().getType()==matlabLexer.IDENTIFIER) {
			return node.getText()+"[i]";
		}
		if(node.getSymbol().getType()==matlabLexer.CONSTANT) {
			return node.getText();
		}
		if(node.getSymbol().getType()==matlabLexer.NE_OP) {
			return "!=";
		}
		if(node.getSymbol().getType()==matlabLexer.CR) {
			return "";
		}
		return node.getText();
	}

	@Override
	public String visitPrev_expression(Prev_expressionContext ctx) {

		StringBuilder b = new StringBuilder();
		b.append("((i==0)*("+ctx.getChild(2).getText()+"[i])+(i>0)*("+ctx.getChild(2).getText()+"[i-1]"+"))" );
		return b.toString();
	}

	@Override
	public String visitDur_expression(Dur_expressionContext ctx) {
		String constant=ctx.getChild(5).getText();
		return "Exists(j,And(j<=i,tau[i]-tau[j]>="+constant+",ForAll(k,Implies(And(j<=k,k<=i),"+ctx.getChild(2).accept(this)+"))))";
	}
}
