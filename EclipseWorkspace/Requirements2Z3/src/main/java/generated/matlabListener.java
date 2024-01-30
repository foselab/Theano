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
	 * Enter a parse tree produced by {@link matlabParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(matlabParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(matlabParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#variablesdefinitions}.
	 * @param ctx the parse tree
	 */
	void enterVariablesdefinitions(matlabParser.VariablesdefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#variablesdefinitions}.
	 * @param ctx the parse tree
	 */
	void exitVariablesdefinitions(matlabParser.VariablesdefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#requirementsdefinitions}.
	 * @param ctx the parse tree
	 */
	void enterRequirementsdefinitions(matlabParser.RequirementsdefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#requirementsdefinitions}.
	 * @param ctx the parse tree
	 */
	void exitRequirementsdefinitions(matlabParser.RequirementsdefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#requirement}.
	 * @param ctx the parse tree
	 */
	void enterRequirement(matlabParser.RequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#requirement}.
	 * @param ctx the parse tree
	 */
	void exitRequirement(matlabParser.RequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#precondition}.
	 * @param ctx the parse tree
	 */
	void enterPrecondition(matlabParser.PreconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#precondition}.
	 * @param ctx the parse tree
	 */
	void exitPrecondition(matlabParser.PreconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#postcondition}.
	 * @param ctx the parse tree
	 */
	void enterPostcondition(matlabParser.PostconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#postcondition}.
	 * @param ctx the parse tree
	 */
	void exitPostcondition(matlabParser.PostconditionContext ctx);
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
	 * Enter a parse tree produced by {@link matlabParser#dur_expression}.
	 * @param ctx the parse tree
	 */
	void enterDur_expression(matlabParser.Dur_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#dur_expression}.
	 * @param ctx the parse tree
	 */
	void exitDur_expression(matlabParser.Dur_expressionContext ctx);
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
	 * Enter a parse tree produced by {@link matlabParser#is_startup}.
	 * @param ctx the parse tree
	 */
	void enterIs_startup(matlabParser.Is_startupContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#is_startup}.
	 * @param ctx the parse tree
	 */
	void exitIs_startup(matlabParser.Is_startupContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#is_not_startup}.
	 * @param ctx the parse tree
	 */
	void enterIs_not_startup(matlabParser.Is_not_startupContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#is_not_startup}.
	 * @param ctx the parse tree
	 */
	void exitIs_not_startup(matlabParser.Is_not_startupContext ctx);
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
	 * Enter a parse tree produced by {@link matlabParser#variabledefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariabledefinition(matlabParser.VariabledefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#variabledefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariabledefinition(matlabParser.VariabledefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(matlabParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(matlabParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(matlabParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(matlabParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#io}.
	 * @param ctx the parse tree
	 */
	void enterIo(matlabParser.IoContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#io}.
	 * @param ctx the parse tree
	 */
	void exitIo(matlabParser.IoContext ctx);
}