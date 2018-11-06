package com.anshishagua.parser;

import com.anshishagua.constants.AggregationType;
import com.anshishagua.constants.ArithmeticCompareType;
import com.anshishagua.constants.ArithmeticType;
import com.anshishagua.constants.LiteralType;
import com.anshishagua.object.TimeCondition;
import com.anshishagua.object.TimeUnit;
import com.anshishagua.object.nodes.Aggregation;
import com.anshishagua.object.nodes.ArithmeticCompare;
import com.anshishagua.object.nodes.Expression;
import com.anshishagua.object.nodes.FieldRef;
import com.anshishagua.object.nodes.Literal;
import com.anshishagua.parser.generated.ExpressionBaseVisitor;
import com.anshishagua.parser.generated.ExpressionParser;

public class Parser extends ExpressionBaseVisitor<Expression> {
    @Override
    public Expression visitStart(ExpressionParser.StartContext context) {
        return visit(context.expression());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitCompare(ExpressionParser.CompareContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitNumeric(ExpressionParser.NumericContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitSign(ExpressionParser.SignContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitDecimal(ExpressionParser.DecimalContext ctx) { return visitChildren(ctx); }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Expression visitString(ExpressionParser.StringContext context) {
        return new Literal(LiteralType.STRING, context.getText());
    }

    @Override
    public Expression visitIntNumber(ExpressionParser.IntNumberContext context) {
        return new Literal(LiteralType.INTEGER, Integer.parseInt(context.getText()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Expression visitLongNumber(ExpressionParser.LongNumberContext context) {
        return new Literal(LiteralType.LONG, Long.parseLong(context.getText()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitNumber(ExpressionParser.NumberContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitCondition(ExpressionParser.ConditionContext context) {
        Expression left = visit(context.operand());

        if (context.conditionRightHandSide().compare() != null) {
            ArithmeticCompareType type = ArithmeticCompareType.parseByValue(context.conditionRightHandSide().compare().getText());

            Expression right = visit(context.conditionRightHandSide().operand(0));

            return new ArithmeticCompare(type, left, right);
        }

        return visitChildren(context);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitExpression(ExpressionParser.ExpressionContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitAndCondition(ExpressionParser.AndConditionContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitConditionRightHandSide(ExpressionParser.ConditionRightHandSideContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitValue(ExpressionParser.ValueContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitParam(ExpressionParser.ParamContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitId(ExpressionParser.IdContext ctx) { return visitChildren(ctx); }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Expression visitColumnRef(ExpressionParser.ColumnRefContext context) {
        return new FieldRef(context.ID(0).getText(), context.ID(1).getText());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitOperand(ExpressionParser.OperandContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitSummand(ExpressionParser.SummandContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitPlusMinus(ExpressionParser.PlusMinusContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitFactor(ExpressionParser.FactorContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitMulDivMod(ExpressionParser.MulDivModContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitTerm(ExpressionParser.TermContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitFunction(ExpressionParser.FunctionContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitCaseWhen(ExpressionParser.CaseWhenContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitAgg(ExpressionParser.AggContext ctx) { return visitChildren(ctx); }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Expression visitTimeunit(ExpressionParser.TimeunitContext context) {
        return visitChildren(context);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Expression visitAggregation(ExpressionParser.AggregationContext context) {
        AggregationType type = AggregationType.valueOf(context.agg().getText());

        Expression expression = visit(context.expression());

        TimeCondition timeCondition = null;

        if (context.Within() != null) {
            int value = Integer.parseInt(context.intNumber().getText());
            TimeUnit timeUnit = TimeUnit.valueOf(context.timeunit().getText());

            timeCondition = new TimeCondition(value, timeUnit);
        }

        return new Aggregation(type, expression, timeCondition);
    }
}
