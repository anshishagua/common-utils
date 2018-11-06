package com.anshishagua.object.nodes;

public class And extends AbstractExpression {
    public And(Expression left, Expression right) {
        addChild(left);
        addChild(right);
    }

    public Expression getLeft() {
        return getChild(0);
    }

    public Expression getRight() {
        return getChild(1);
    }

    @Override
    public String toSQL() {
        return String.format("%s AND %s", getLeft(), getRight());
    }
}
