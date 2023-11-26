// Generated from matlab.g4 by ANTLR 4.4

package generated;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link matlabParser}.
 */
public interface matlabListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link matlabParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEquality_expression(@NotNull matlabParser.Equality_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEquality_expression(@NotNull matlabParser.Equality_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#requirementsdefinitions}.
	 * @param ctx the parse tree
	 */
	void enterRequirementsdefinitions(@NotNull matlabParser.RequirementsdefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#requirementsdefinitions}.
	 * @param ctx the parse tree
	 */
	void exitRequirementsdefinitions(@NotNull matlabParser.RequirementsdefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expression(@NotNull matlabParser.Postfix_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expression(@NotNull matlabParser.Postfix_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#prev_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrev_expression(@NotNull matlabParser.Prev_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#prev_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrev_expression(@NotNull matlabParser.Prev_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(@NotNull matlabParser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(@NotNull matlabParser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#variablesdefinitions}.
	 * @param ctx the parse tree
	 */
	void enterVariablesdefinitions(@NotNull matlabParser.VariablesdefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#variablesdefinitions}.
	 * @param ctx the parse tree
	 */
	void exitVariablesdefinitions(@NotNull matlabParser.VariablesdefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expression(@NotNull matlabParser.And_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#and_expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expression(@NotNull matlabParser.And_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expression(@NotNull matlabParser.Additive_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expression(@NotNull matlabParser.Additive_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull matlabParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull matlabParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_expression(@NotNull matlabParser.Multiplicative_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_expression(@NotNull matlabParser.Multiplicative_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expression(@NotNull matlabParser.Primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expression(@NotNull matlabParser.Primary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void enterStatement_list(@NotNull matlabParser.Statement_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void exitStatement_list(@NotNull matlabParser.Statement_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(@NotNull matlabParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(@NotNull matlabParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(@NotNull matlabParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(@NotNull matlabParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull matlabParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull matlabParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(@NotNull matlabParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(@NotNull matlabParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#is_not_startup}.
	 * @param ctx the parse tree
	 */
	void enterIs_not_startup(@NotNull matlabParser.Is_not_startupContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#is_not_startup}.
	 * @param ctx the parse tree
	 */
	void exitIs_not_startup(@NotNull matlabParser.Is_not_startupContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#io}.
	 * @param ctx the parse tree
	 */
	void enterIo(@NotNull matlabParser.IoContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#io}.
	 * @param ctx the parse tree
	 */
	void exitIo(@NotNull matlabParser.IoContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#index_expression}.
	 * @param ctx the parse tree
	 */
	void enterIndex_expression(@NotNull matlabParser.Index_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#index_expression}.
	 * @param ctx the parse tree
	 */
	void exitIndex_expression(@NotNull matlabParser.Index_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_expression(@NotNull matlabParser.Assignment_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_expression(@NotNull matlabParser.Assignment_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(@NotNull matlabParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(@NotNull matlabParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#requirement}.
	 * @param ctx the parse tree
	 */
	void enterRequirement(@NotNull matlabParser.RequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#requirement}.
	 * @param ctx the parse tree
	 */
	void exitRequirement(@NotNull matlabParser.RequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#precondition}.
	 * @param ctx the parse tree
	 */
	void enterPrecondition(@NotNull matlabParser.PreconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#precondition}.
	 * @param ctx the parse tree
	 */
	void exitPrecondition(@NotNull matlabParser.PreconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#dur_expression}.
	 * @param ctx the parse tree
	 */
	void enterDur_expression(@NotNull matlabParser.Dur_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#dur_expression}.
	 * @param ctx the parse tree
	 */
	void exitDur_expression(@NotNull matlabParser.Dur_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#is_startup}.
	 * @param ctx the parse tree
	 */
	void enterIs_startup(@NotNull matlabParser.Is_startupContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#is_startup}.
	 * @param ctx the parse tree
	 */
	void exitIs_startup(@NotNull matlabParser.Is_startupContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#or_expression}.
	 * @param ctx the parse tree
	 */
	void enterOr_expression(@NotNull matlabParser.Or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#or_expression}.
	 * @param ctx the parse tree
	 */
	void exitOr_expression(@NotNull matlabParser.Or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#variabledefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariabledefinition(@NotNull matlabParser.VariabledefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#variabledefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariabledefinition(@NotNull matlabParser.VariabledefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational_expression(@NotNull matlabParser.Relational_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational_expression(@NotNull matlabParser.Relational_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#postcondition}.
	 * @param ctx the parse tree
	 */
	void enterPostcondition(@NotNull matlabParser.PostconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#postcondition}.
	 * @param ctx the parse tree
	 */
	void exitPostcondition(@NotNull matlabParser.PostconditionContext ctx);
}