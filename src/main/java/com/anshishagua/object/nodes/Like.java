package com.anshishagua.object.nodes;

/**
 * Like.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class Like extends AbstractExpression {
    public Like(Expression left, Expression right) {
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
        return String.format("%s LIKE %s", getLeft().toSQL(), getRight().toSQL());
    }
}
