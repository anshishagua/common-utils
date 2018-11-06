package com.anshishagua.object.nodes;

public class Paren extends AbstractExpression {
    public Paren(Expression expression) {
        this.children.add(expression);
    }

    @Override
    public String toSQL() {
        return String.format("(%s)", getChild(0).toSQL());
    }
}
