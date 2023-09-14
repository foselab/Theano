package requirements2Z3.completeness.visitors;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabParser.Additive_expressionContext;
import generated.matlabParser.And_expressionContext;
import generated.matlabParser.Assignment_expressionContext;
import generated.matlabParser.EostmtContext;
import generated.matlabParser.Equality_expressionContext;
import generated.matlabParser.ExpressionContext;
import generated.matlabParser.Expression_statementContext;
import generated.matlabParser.File_Context;
import generated.matlabParser.Index_expressionContext;
import generated.matlabParser.Index_expression_listContext;
import generated.matlabParser.Multiplicative_expressionContext;
import generated.matlabParser.Or_expressionContext;
import generated.matlabParser.Postfix_expressionContext;
import generated.matlabParser.Prev_expressionContext;
import generated.matlabParser.Primary_expressionContext;
import generated.matlabParser.Relational_expressionContext;
import generated.matlabParser.StatementContext;
import generated.matlabParser.Statement_listContext;
import generated.matlabParser.Unary_expressionContext;
import generated.matlabParser.Unary_operatorContext;
import generated.matlabVisitor;

public class UeUfFs implements matlabVisitor<String> {

	@Override
	public String visit(ParseTree tree) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < tree.getChildCount(); i++) {
			b.append(tree.getChild(i).accept(this) + "\n");
		}

		return b.toString();
	}

	@Override
	public String visitChildren(RuleNode node) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < node.getChildCount(); i++) {
			b.append(node.getChild(i).accept(this) );
		}

		return b.toString();
	}


	@Override
	public String visitErrorNode(ErrorNode node) {
		return node.getText();
	}

	@Override
	public String visitFile_(File_Context ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitPrimary_expression(Primary_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}
		

		return b.toString();
	}

	@Override
	public String visitPostfix_expression(Postfix_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitIndex_expression(Index_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitIndex_expression_list(Index_expression_listContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitUnary_expression(Unary_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitUnary_operator(Unary_operatorContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitMultiplicative_expression(Multiplicative_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitAdditive_expression(Additive_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitRelational_expression(Relational_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitEquality_expression(Equality_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitAnd_expression(And_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitOr_expression(Or_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitExpression(ExpressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitAssignment_expression(Assignment_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitEostmt(EostmtContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitStatement(StatementContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitStatement_list(Statement_listContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}
	
	@Override
	public String visitExpression_statement(Expression_statementContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

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
		b.append("And(Implies((i==0),("+ctx.getChild(2).accept(this)+")),Implies((i>0),("+ctx.getChild(2).getText()+"[i-1]"+")))" );
		return b.toString();
	}
}