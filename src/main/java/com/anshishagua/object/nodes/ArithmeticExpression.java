package com.anshishagua.object.nodes;

import com.anshishagua.constants.ArithmeticType;

public class ArithmeticExpression extends AbstractExpression {
    private ArithmeticType type;
    private Expression left;
    private Expression right;

    public ArithmeticExpression(ArithmeticType type, Expression left, Expression right) {
        this.type = type;
        this.left = left;
        this.right = right;

        this.addChild(left);
        this.addChild(right);
    }

    @Override
    public String toSQL() {
        return String.format("%s %s %s", left.toSQL(), type.getValue(), right.toSQL());
    }

    @Override
    public Literal evaluate() {
        Literal a = left.evaluate();
        Literal b = right.evaluate();

        return null;
    }
}
