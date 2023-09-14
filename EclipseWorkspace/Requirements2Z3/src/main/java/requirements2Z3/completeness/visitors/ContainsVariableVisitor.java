package requirements2Z3.completeness.visitors;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabParser.Additive_expressionContext;
import generated.matlabParser.And_expressionContext;
import generated.matlabParser.Assignment_expressionContext;
import generated.matlabParser.Dur_expressionContext;
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

public class ContainsVariableVisitor implements matlabVisitor<Boolean> {

	// contains the variable to be analyzed
	private final String variable;

	public ContainsVariableVisitor(String variable) {
		this.variable = variable;
	}

	@Override
	public Boolean visit(ParseTree tree) {
		boolean result = false;

		for (int i = 0; i < tree.getChildCount(); i++) {
			result = result || tree.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitChildren(RuleNode node) {
		boolean result = false;

		for (int i = 0; i < node.getChildCount(); i++) {
			result = result || node.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitErrorNode(ErrorNode node) {
		return false;
	}

	@Override
	public Boolean visitFile_(File_Context ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitPrimary_expression(Primary_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitPostfix_expression(Postfix_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitIndex_expression(Index_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitIndex_expression_list(Index_expression_listContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitUnary_expression(Unary_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitUnary_operator(Unary_operatorContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitMultiplicative_expression(Multiplicative_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitAdditive_expression(Additive_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitRelational_expression(Relational_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitEquality_expression(Equality_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitAnd_expression(And_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitOr_expression(Or_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitExpression(ExpressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitAssignment_expression(Assignment_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitEostmt(EostmtContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitStatement(StatementContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitStatement_list(Statement_listContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitExpression_statement(Expression_statementContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() == matlabLexer.IDENTIFIER) {
			return node.getText().equals(this.variable);
		}
		return false;
	}

	@Override
	public Boolean visitPrev_expression(Prev_expressionContext ctx) {

		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}

	@Override
	public Boolean visitDur_expression(Dur_expressionContext ctx) {
		boolean result = false;

		for (int i = 0; i < ctx.getChildCount(); i++) {
			result = result || ctx.getChild(i).accept(this);
		}

		return result;
	}
}
