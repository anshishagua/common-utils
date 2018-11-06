package com.anshishagua.object.nodes;

public class Not extends AbstractExpression {
    public Not(Expression expression) {
        addChild(expression);
    }

    @Override
    public String toSQL() {
        return String.format("NOT %s", getChild(0).toSQL());
    }
}
