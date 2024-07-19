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
	 * Visit a parse tree produced by {@link matlabParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(matlabParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#variablesdefinitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariablesdefinitions(matlabParser.VariablesdefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#requirementsdefinitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirementsdefinitions(matlabParser.RequirementsdefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirement(matlabParser.RequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#precondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecondition(matlabParser.PreconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#postcondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostcondition(matlabParser.PostconditionContext ctx);
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
	 * Visit a parse tree produced by {@link matlabParser#is_startup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_startup(matlabParser.Is_startupContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#is_not_startup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_not_startup(matlabParser.Is_not_startupContext ctx);
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
	 * Visit a parse tree produced by {@link matlabParser#variabledefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariabledefinition(matlabParser.VariabledefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(matlabParser.VariableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(matlabParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link matlabParser#io}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIo(matlabParser.IoContext ctx);
}