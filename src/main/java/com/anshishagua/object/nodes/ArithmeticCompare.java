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
    private Expression left;
    private Expression right;

    public ArithmeticCompare(ArithmeticCompareType type, Expression left, Expression right) {
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
}
