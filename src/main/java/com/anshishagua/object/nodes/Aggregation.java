package com.anshishagua.object.nodes;

import com.anshishagua.constants.AggregationType;
import com.anshishagua.object.TimeCondition;

public class Aggregation extends AbstractExpression {
    private AggregationType type;
    private TimeCondition timeCondition;
    private boolean distinct;

    public Aggregation(AggregationType type, Expression expression) {
        this.type = type;
        this.addChild(expression);
    }

    public Aggregation(AggregationType type, Expression expression, TimeCondition timeCondition) {
        this.type = type;
        this.timeCondition = timeCondition;
        this.addChild(expression);
    }

    public Expression getExpression() {
        return getChild(0);
    }

    public TimeCondition getTimeCondition() {
        return timeCondition;
    }

    public void setTimeCondition(TimeCondition timeCondition) {
        this.timeCondition = timeCondition;
    }

    public boolean isDistinct() {
        return distinct;
    }

    @Override
    public String toSQL() {
        StringBuilder builder = new StringBuilder();

        builder.append(type).append("(");

        if (distinct) {
            builder.append("DISTINCT ");
        }

        Expression expression = getChild(0);
        builder.append(expression.toSQL());

        if (timeCondition != null) {
            builder.append(" within ").append(timeCondition.getValue()).append(" ").append(timeCondition.getTimeUnit().getValue());
        }

        builder.append(")");

        return builder.toString();
    }
}
