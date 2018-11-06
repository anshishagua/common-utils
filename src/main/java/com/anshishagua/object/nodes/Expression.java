package com.anshishagua.object.nodes;

import com.anshishagua.constants.TraverseType;

import java.util.Iterator;
import java.util.List;

/**
 * Expression.java
 *
 * @author lixiao
 * @date 2018-11-05
 */

public interface Expression {
    List<Expression> getChildren();
    Expression getChild(int i);
    void setParent(Expression parent);
    Expression getParent();
    String toSQL();
    Iterator<Expression> traverse(TraverseType traverseType);
    List<Expression> getChildByType(Class<?> clazz);
    Expression replace(Expression source, Expression target);
    Expression evaluate();
    default <T extends Expression> T get() {
        return (T) this;
    }
}
