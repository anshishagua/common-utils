// Generated from /Users/lixiao/code/common-utils/src/main/resources/Expression.g4 by ANTLR 4.7
package com.anshishagua.parser.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExpressionParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExpressionParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompare(ExpressionParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompare(ExpressionParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#numeric}.
	 * @param ctx the parse tree
	 */
	void enterNumeric(ExpressionParser.NumericContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#numeric}.
	 * @param ctx the parse tree
	 */
	void exitNumeric(ExpressionParser.NumericContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(ExpressionParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(ExpressionParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#decimal}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(ExpressionParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#decimal}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(ExpressionParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(ExpressionParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(ExpressionParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#intNumber}.
	 * @param ctx the parse tree
	 */
	void enterIntNumber(ExpressionParser.IntNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#intNumber}.
	 * @param ctx the parse tree
	 */
	void exitIntNumber(ExpressionParser.IntNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#longNumber}.
	 * @param ctx the parse tree
	 */
	void enterLongNumber(ExpressionParser.LongNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#longNumber}.
	 * @param ctx the parse tree
	 */
	void exitLongNumber(ExpressionParser.LongNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ExpressionParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ExpressionParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(ExpressionParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(ExpressionParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExpressionParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExpressionParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#andCondition}.
	 * @param ctx the parse tree
	 */
	void enterAndCondition(ExpressionParser.AndConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#andCondition}.
	 * @param ctx the parse tree
	 */
	void exitAndCondition(ExpressionParser.AndConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#conditionRightHandSide}.
	 * @param ctx the parse tree
	 */
	void enterConditionRightHandSide(ExpressionParser.ConditionRightHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#conditionRightHandSide}.
	 * @param ctx the parse tree
	 */
	void exitConditionRightHandSide(ExpressionParser.ConditionRightHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ExpressionParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ExpressionParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(ExpressionParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(ExpressionParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(ExpressionParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(ExpressionParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void enterColumnRef(ExpressionParser.ColumnRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void exitColumnRef(ExpressionParser.ColumnRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(ExpressionParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(ExpressionParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#summand}.
	 * @param ctx the parse tree
	 */
	void enterSummand(ExpressionParser.SummandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#summand}.
	 * @param ctx the parse tree
	 */
	void exitSummand(ExpressionParser.SummandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#plusMinus}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinus(ExpressionParser.PlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#plusMinus}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinus(ExpressionParser.PlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ExpressionParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ExpressionParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#mulDivMod}.
	 * @param ctx the parse tree
	 */
	void enterMulDivMod(ExpressionParser.MulDivModContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#mulDivMod}.
	 * @param ctx the parse tree
	 */
	void exitMulDivMod(ExpressionParser.MulDivModContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ExpressionParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ExpressionParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ExpressionParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ExpressionParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#caseWhen}.
	 * @param ctx the parse tree
	 */
	void enterCaseWhen(ExpressionParser.CaseWhenContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#caseWhen}.
	 * @param ctx the parse tree
	 */
	void exitCaseWhen(ExpressionParser.CaseWhenContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#aggregationType}.
	 * @param ctx the parse tree
	 */
	void enterAggregationType(ExpressionParser.AggregationTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#aggregationType}.
	 * @param ctx the parse tree
	 */
	void exitAggregationType(ExpressionParser.AggregationTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#timeUnit}.
	 * @param ctx the parse tree
	 */
	void enterTimeUnit(ExpressionParser.TimeUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#timeUnit}.
	 * @param ctx the parse tree
	 */
	void exitTimeUnit(ExpressionParser.TimeUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#aggregation}.
	 * @param ctx the parse tree
	 */
	void enterAggregation(ExpressionParser.AggregationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#aggregation}.
	 * @param ctx the parse tree
	 */
	void exitAggregation(ExpressionParser.AggregationContext ctx);
}