package com.anshishagua.object.nodes;

import com.anshishagua.constants.ArithmeticCompareType;

/**
 * ArithmeticCompare.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class ArithmeticCompare extends AbstractExpression {
    private ArithmeticCompareType type;

    public ArithmeticCompare(ArithmeticCompareType type, Expression left, Expression right) {
        this.type = type;

        this.addChild(left);
        this.addChild(right);
    }

    @Override
    public String toSQL() {
        return String.format("%s %s %s", getChild(0).toSQL(), type.getValue(), getChild(1).toSQL());
    }
}
