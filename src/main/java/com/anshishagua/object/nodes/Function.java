package com.anshishagua.object.nodes;

import java.util.List;

public class Function extends AbstractExpression {
    private String name;

    public Function(String name, List<Expression> arguments) {
        this.name = name;
        this.children = arguments;
    }

    public List<Expression> getArguments() {
        return this.children;
    }

    public Expression getArgument(int i) {
        return getChild(i);
    }
}
