package requirements2Z3;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabParser.Additive_expressionContext;
import generated.matlabParser.And_expressionContext;
import generated.matlabParser.Array_elementContext;
import generated.matlabParser.Array_expressionContext;
import generated.matlabParser.Array_listContext;
import generated.matlabParser.Assignment_expressionContext;
import generated.matlabParser.Assignment_statementContext;
import generated.matlabParser.Clear_statementContext;
import generated.matlabParser.Elseif_clauseContext;
import generated.matlabParser.EostmtContext;
import generated.matlabParser.Equality_expressionContext;
import generated.matlabParser.ExpressionContext;
import generated.matlabParser.Expression_statementContext;
import generated.matlabParser.File_Context;
import generated.matlabParser.Func_ident_listContext;
import generated.matlabParser.Func_return_listContext;
import generated.matlabParser.Function_declareContext;
import generated.matlabParser.Function_declare_lhsContext;
import generated.matlabParser.Global_statementContext;
import generated.matlabParser.Identifier_listContext;
import generated.matlabParser.Index_expressionContext;
import generated.matlabParser.Index_expression_listContext;
import generated.matlabParser.Iteration_statementContext;
import generated.matlabParser.Jump_statementContext;
import generated.matlabParser.Multiplicative_expressionContext;
import generated.matlabParser.Or_expressionContext;
import generated.matlabParser.Postfix_expressionContext;
import generated.matlabParser.Primary_expressionContext;
import generated.matlabParser.Relational_expressionContext;
import generated.matlabParser.Selection_statementContext;
import generated.matlabParser.StatementContext;
import generated.matlabParser.Statement_listContext;
import generated.matlabParser.Translation_unitContext;
import generated.matlabParser.Unary_expressionContext;
import generated.matlabParser.Unary_operatorContext;
import generated.matlabVisitor;

public class Matlab2Z3Visitor implements matlabVisitor<String> {

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
	public String visitTerminal(TerminalNode node) {
		return node.getText();
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
	public String visitArray_expression(Array_expressionContext ctx) {
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
	public String visitIdentifier_list(Identifier_listContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitGlobal_statement(Global_statementContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitClear_statement(Clear_statementContext ctx) {
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
	public String visitAssignment_statement(Assignment_statementContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitArray_element(Array_elementContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitArray_list(Array_listContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitSelection_statement(Selection_statementContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitElseif_clause(Elseif_clauseContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitIteration_statement(Iteration_statementContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitJump_statement(Jump_statementContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitTranslation_unit(Translation_unitContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitFunc_ident_list(Func_ident_listContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitFunc_return_list(Func_return_listContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitFunction_declare_lhs(Function_declare_lhsContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

	@Override
	public String visitFunction_declare(Function_declareContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this) );
		}

		return b.toString();
	}

}
