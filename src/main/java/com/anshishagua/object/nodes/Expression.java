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
    <T extends Expression> List<T> getChildByType(Class<T> clazz);
    Expression replace(Expression source, Expression target);
    Literal evaluate();
    default <T extends Expression> T get() {
        return (T) this;
    }
}
