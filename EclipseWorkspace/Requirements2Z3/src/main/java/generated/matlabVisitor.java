// Generated from matlab.g4 by ANTLR 4.5

package generated;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link matlabParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface matlabVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link matlabParser#file_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_(matlabParser.File_Context ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_expression(matlabParser.Primary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#prev_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrev_expression(matlabParser.Prev_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#dur_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDur_expression(matlabParser.Dur_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix_expression(matlabParser.Postfix_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#index_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_expression(matlabParser.Index_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#index_expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_expression_list(matlabParser.Index_expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expression(matlabParser.Unary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_operator(matlabParser.Unary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative_expression(matlabParser.Multiplicative_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive_expression(matlabParser.Additive_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_expression(matlabParser.Relational_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_expression(matlabParser.Equality_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expression(matlabParser.And_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_expression(matlabParser.Or_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(matlabParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#assignment_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_expression(matlabParser.Assignment_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#eostmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEostmt(matlabParser.EostmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(matlabParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#statement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_list(matlabParser.Statement_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#expression_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_statement(matlabParser.Expression_statementContext ctx);
}