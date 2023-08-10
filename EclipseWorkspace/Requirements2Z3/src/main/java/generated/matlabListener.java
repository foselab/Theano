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
	 * Enter a parse tree produced by {@link matlabParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void enterArray_expression(matlabParser.Array_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void exitArray_expression(matlabParser.Array_expressionContext ctx);
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
	 * Enter a parse tree produced by {@link matlabParser#identifier_list}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_list(matlabParser.Identifier_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#identifier_list}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_list(matlabParser.Identifier_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#global_statement}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_statement(matlabParser.Global_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#global_statement}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_statement(matlabParser.Global_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#clear_statement}.
	 * @param ctx the parse tree
	 */
	void enterClear_statement(matlabParser.Clear_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#clear_statement}.
	 * @param ctx the parse tree
	 */
	void exitClear_statement(matlabParser.Clear_statementContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link matlabParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_statement(matlabParser.Assignment_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_statement(matlabParser.Assignment_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#array_element}.
	 * @param ctx the parse tree
	 */
	void enterArray_element(matlabParser.Array_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#array_element}.
	 * @param ctx the parse tree
	 */
	void exitArray_element(matlabParser.Array_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#array_list}.
	 * @param ctx the parse tree
	 */
	void enterArray_list(matlabParser.Array_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#array_list}.
	 * @param ctx the parse tree
	 */
	void exitArray_list(matlabParser.Array_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#selection_statement}.
	 * @param ctx the parse tree
	 */
	void enterSelection_statement(matlabParser.Selection_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#selection_statement}.
	 * @param ctx the parse tree
	 */
	void exitSelection_statement(matlabParser.Selection_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#elseif_clause}.
	 * @param ctx the parse tree
	 */
	void enterElseif_clause(matlabParser.Elseif_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#elseif_clause}.
	 * @param ctx the parse tree
	 */
	void exitElseif_clause(matlabParser.Elseif_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void enterIteration_statement(matlabParser.Iteration_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void exitIteration_statement(matlabParser.Iteration_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void enterJump_statement(matlabParser.Jump_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void exitJump_statement(matlabParser.Jump_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#translation_unit}.
	 * @param ctx the parse tree
	 */
	void enterTranslation_unit(matlabParser.Translation_unitContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#translation_unit}.
	 * @param ctx the parse tree
	 */
	void exitTranslation_unit(matlabParser.Translation_unitContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#func_ident_list}.
	 * @param ctx the parse tree
	 */
	void enterFunc_ident_list(matlabParser.Func_ident_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#func_ident_list}.
	 * @param ctx the parse tree
	 */
	void exitFunc_ident_list(matlabParser.Func_ident_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#func_return_list}.
	 * @param ctx the parse tree
	 */
	void enterFunc_return_list(matlabParser.Func_return_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#func_return_list}.
	 * @param ctx the parse tree
	 */
	void exitFunc_return_list(matlabParser.Func_return_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#function_declare_lhs}.
	 * @param ctx the parse tree
	 */
	void enterFunction_declare_lhs(matlabParser.Function_declare_lhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#function_declare_lhs}.
	 * @param ctx the parse tree
	 */
	void exitFunction_declare_lhs(matlabParser.Function_declare_lhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link matlabParser#function_declare}.
	 * @param ctx the parse tree
	 */
	void enterFunction_declare(matlabParser.Function_declareContext ctx);
	/**
	 * Exit a parse tree produced by {@link matlabParser#function_declare}.
	 * @param ctx the parse tree
	 */
	void exitFunction_declare(matlabParser.Function_declareContext ctx);
}