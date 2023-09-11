// Generated from matlab.g4 by ANTLR 4.5

package generated;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link matlabParser}.
 */
public interface matlabListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link matlabParser#file_}.
	 * @param ctx the parse tree
	 */
	void enterFile_(matlabParser.File_Context ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#file_}.
	 * @param ctx the parse tree
	 */
	void exitFile_(matlabParser.File_Context ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expression(matlabParser.Primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expression(matlabParser.Primary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#prev_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrev_expression(matlabParser.Prev_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#prev_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrev_expression(matlabParser.Prev_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expression(matlabParser.Postfix_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expression(matlabParser.Postfix_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#index_expression}.
	 * @param ctx the parse tree
	 */
	void enterIndex_expression(matlabParser.Index_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#index_expression}.
	 * @param ctx the parse tree
	 */
	void exitIndex_expression(matlabParser.Index_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#index_expression_list}.
	 * @param ctx the parse tree
	 */
	void enterIndex_expression_list(matlabParser.Index_expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#index_expression_list}.
	 * @param ctx the parse tree
	 */
	void exitIndex_expression_list(matlabParser.Index_expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(matlabParser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(matlabParser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(matlabParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(matlabParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_expression(matlabParser.Multiplicative_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_expression(matlabParser.Multiplicative_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expression(matlabParser.Additive_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expression(matlabParser.Additive_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational_expression(matlabParser.Relational_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational_expression(matlabParser.Relational_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEquality_expression(matlabParser.Equality_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEquality_expression(matlabParser.Equality_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expression(matlabParser.And_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expression(matlabParser.And_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#or_expression}.
	 * @param ctx the parse tree
	 */
	void enterOr_expression(matlabParser.Or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#or_expression}.
	 * @param ctx the parse tree
	 */
	void exitOr_expression(matlabParser.Or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(matlabParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(matlabParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_expression(matlabParser.Assignment_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_expression(matlabParser.Assignment_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#eostmt}.
	 * @param ctx the parse tree
	 */
	void enterEostmt(matlabParser.EostmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#eostmt}.
	 * @param ctx the parse tree
	 */
	void exitEostmt(matlabParser.EostmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(matlabParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(matlabParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void enterStatement_list(matlabParser.Statement_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void exitStatement_list(matlabParser.Statement_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpression_statement(matlabParser.Expression_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpression_statement(matlabParser.Expression_statementContext ctx);
}