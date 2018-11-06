package com.anshishagua.object.nodes;

/**
 * IsNotNull.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class IsNotNull extends AbstractExpression {
    public IsNotNull(Expression expression) {
        addChild(expression);
    }

    @Override
    public String toSQL() {
        return String.format("%s IS NOT NULL", getChild(0).toSQL());
    }
}
