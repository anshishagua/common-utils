// Generated from /Users/xiaoli/IdeaProjects/common-utils/src/main/resources/Expression.g4 by ANTLR 4.7
package com.anshishagua.parser.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ExpressionParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(ExpressionParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#numeric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric(ExpressionParser.NumericContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(ExpressionParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#decimal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(ExpressionParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ExpressionParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#intNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntNumber(ExpressionParser.IntNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#longNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongNumber(ExpressionParser.LongNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ExpressionParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(ExpressionParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ExpressionParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#andCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCondition(ExpressionParser.AndConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#conditionRightHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionRightHandSide(ExpressionParser.ConditionRightHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ExpressionParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(ExpressionParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(ExpressionParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#columnRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnRef(ExpressionParser.ColumnRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(ExpressionParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#summand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSummand(ExpressionParser.SummandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#plusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinus(ExpressionParser.PlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(ExpressionParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#mulDivMod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(ExpressionParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ExpressionParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ExpressionParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#caseWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseWhen(ExpressionParser.CaseWhenContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#agg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgg(ExpressionParser.AggContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#timeunit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeunit(ExpressionParser.TimeunitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#aggregation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregation(ExpressionParser.AggregationContext ctx);
}