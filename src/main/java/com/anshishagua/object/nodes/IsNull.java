package com.anshishagua.object.nodes;

/**
 * IsNull.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class IsNull extends AbstractExpression {
    public IsNull(Expression expression) {
        addChild(expression);
    }

    @Override
    public String toSQL() {
        return String.format("%s IS NULL", getChild(0).toSQL());
    }
}
