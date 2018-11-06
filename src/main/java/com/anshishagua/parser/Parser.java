package com.anshishagua.parser;

import com.anshishagua.constants.AggregationType;
import com.anshishagua.constants.ArithmeticCompareType;
import com.anshishagua.constants.ArithmeticType;
import com.anshishagua.constants.LiteralType;
import com.anshishagua.object.TimeCondition;
import com.anshishagua.object.TimeUnit;
import com.anshishagua.object.nodes.Aggregation;
import com.anshishagua.object.nodes.And;
import com.anshishagua.object.nodes.ArithmeticCompare;
import com.anshishagua.object.nodes.ArithmeticExpression;
import com.anshishagua.object.nodes.Expression;
import com.anshishagua.object.nodes.FieldRef;
import com.anshishagua.object.nodes.Function;
import com.anshishagua.object.nodes.IsNotNull;
import com.anshishagua.object.nodes.IsNull;
import com.anshishagua.object.nodes.Like;
import com.anshishagua.object.nodes.Literal;
import com.anshishagua.object.nodes.Not;
import com.anshishagua.object.nodes.NotLike;
import com.anshishagua.object.nodes.Or;
import com.anshishagua.object.nodes.Paren;
import com.anshishagua.parser.generated.ExpressionBaseVisitor;
import com.anshishagua.parser.generated.ExpressionParser;

import java.util.ArrayList;
import java.util.List;

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
        if (context.Not() != null) {
            return new Not(visit(context.condition()));
        }

        Expression expression = visit(context.operand());

        if (context.conditionRightHandSide() == null) {
            return expression;
        }

        if (context.conditionRightHandSide().compare() != null) {
            if (context.conditionRightHandSide().compare().GreaterThan() != null) {
                Expression right = visit(context.conditionRightHandSide().operand(0));

                return new ArithmeticCompare(ArithmeticCompareType.LARGER_THAN, expression, right);
            } else if (context.conditionRightHandSide().compare().GreaterThanOrEqual() != null) {
                Expression right = visit(context.conditionRightHandSide().operand(0));

                return new ArithmeticCompare(ArithmeticCompareType.LARGER_THAN_EQUAL, expression, right);
            } else if (context.conditionRightHandSide().compare().LessThan() != null) {
                Expression right = visit(context.conditionRightHandSide().operand(0));

                return new ArithmeticCompare(ArithmeticCompareType.LOWER_THAN, expression, right);
            } else if (context.conditionRightHandSide().compare().LessThanOrEqual() != null) {
                Expression right = visit(context.conditionRightHandSide().operand(0));

                return new ArithmeticCompare(ArithmeticCompareType.LOWER_THAN_EQUAL, expression, right);
            } else if (context.conditionRightHandSide().compare().Equal() != null) {
                Expression right = visit(context.conditionRightHandSide().operand(0));

                return new ArithmeticCompare(ArithmeticCompareType.EQUAL, expression, right);
            } else if (context.conditionRightHandSide().compare().NotEqual() != null) {
                Expression right = visit(context.conditionRightHandSide().operand(0));

                return new ArithmeticCompare(ArithmeticCompareType.NOT_EQUAL, expression, right);
            }
        }

        if (context.conditionRightHandSide().Is() != null && context.conditionRightHandSide().Null() != null) {
            if (context.conditionRightHandSide().Not() != null) {
                return new IsNotNull(expression);
            } else {
                return new IsNull(expression);
            }
        }

        if (context.conditionRightHandSide().Not() != null && context.conditionRightHandSide().Like() != null) {
            return new NotLike(expression, visit(context.conditionRightHandSide().operand(0)));
        }

        if (context.conditionRightHandSide().Not() != null) {
            return new Not(visit(context.conditionRightHandSide().operand(0)));
        }

        if (context.conditionRightHandSide().Like() != null) {
            return new Like(expression, visit(context.conditionRightHandSide().operand(0)));
        }

        return visitChildren(context);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Expression visitExpression(ExpressionParser.ExpressionContext context) {
        Expression expression = visit(context.andCondition(0));

        for (int i = 1; i < context.andCondition().size(); ++i) {
            Expression right = visit(context.andCondition(i));

            expression = new Or(expression, right);
        }

        return expression;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Expression visitAndCondition(ExpressionParser.AndConditionContext context) {
        Expression expression = visit(context.condition(0));

        for (int i = 1; i < context.condition().size(); ++i) {
            Expression right = visit(context.condition(i));

            expression = new And(expression, right);
        }

        return expression;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Expression visitConditionRightHandSide(ExpressionParser.ConditionRightHandSideContext context) {
        return visitChildren(context);
    }
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
    @Override
    public Expression visitSummand(ExpressionParser.SummandContext context) {
        Expression expression = visit(context.factor(0));

        for (int i = 0; i < context.plusMinus().size(); ++i) {
            Expression right = visit(context.factor(i + 1));

            if (context.plusMinus(i).Plus() != null) {
                expression = new ArithmeticExpression(ArithmeticType.PLUS, expression, right);
            } else if (context.plusMinus(i).Minus() != null) {
                expression = new ArithmeticExpression(ArithmeticType.MINUS, expression, right);
            }
        }

        return expression;
    }
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
    @Override
    public Expression visitFactor(ExpressionParser.FactorContext context) {
        Expression expression = visit(context.term(0));

        for (int i = 0; i < context.mulDivMod().size(); ++i) {
            Expression right = visit(context.term(i + 1));

            if (context.mulDivMod(i).Multiply() != null) {
                expression = new ArithmeticExpression(ArithmeticType.MULTIPLY, expression, right);
            } else if (context.mulDivMod(i).Divide() != null) {
                expression = new ArithmeticExpression(ArithmeticType.DIVIDE, expression, right);
            } else if (context.mulDivMod(i).Mod() != null) {
                expression = new ArithmeticExpression(ArithmeticType.MOD, expression, right);
            }
        }

        return expression;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public
    Expression visitMulDivMod(ExpressionParser.MulDivModContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Expression visitTerm(ExpressionParser.TermContext context) {
        if (context.LeftParen() != null) {
            return new Paren(visit(context.expression()));
        }

        if (context.Plus() != null) {
            return visit(context.term());
        }

        if (context.Minus() != null) {
            return new ArithmeticExpression(ArithmeticType.MULTIPLY, new Literal(LiteralType.INTEGER, -1), visit(context.term()));
        }

        return visitChildren(context);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Expression visitFunction(ExpressionParser.FunctionContext context) {
        if (context.aggregation() != null) {
            return visit(context.aggregation());
        }

        String functionName = context.ID().getText();

        int size = context.expression().size();

        List<Expression> arguments = new ArrayList<>(size);

        for (int i = 0; i < size; ++i) {
            arguments.add(visit(context.expression(i)));
        }

        return new Function(functionName, arguments);
    }

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
    @Override public Expression visitAggregationType(ExpressionParser.AggregationTypeContext ctx) { return visitChildren(ctx); }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Expression visitTimeUnit(ExpressionParser.TimeUnitContext context) {
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
        AggregationType type = AggregationType.valueOf(context.aggregationType().getText());

        Expression expression = visit(context.expression());

        TimeCondition timeCondition = null;

        if (context.Within() != null) {
            int value = Integer.parseInt(context.intNumber().getText());
            TimeUnit timeUnit = TimeUnit.parseByValue(context.timeUnit().getText());

            timeCondition = new TimeCondition(value, timeUnit);
        }

        return new Aggregation(type, expression, timeCondition);
    }
}
