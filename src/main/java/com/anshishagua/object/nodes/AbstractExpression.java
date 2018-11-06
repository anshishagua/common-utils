package com.anshishagua.object.nodes;

import com.anshishagua.constants.TraverseType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractExpression implements Expression {
    protected List<Expression> children = new ArrayList<>();
    protected Expression parent;

    @Override
    public List<Expression> getChildren() {
        return children;
    }

    @Override
    public Expression getParent() {
        return parent;
    }

    @Override
    public void setParent(Expression parent) {
        this.parent = parent;
    }

    public void addChild(Expression expression) {
        expression.setParent(this);

        this.children.add(expression);
    }

    @Override
    public Expression getChild(int i) {
        return children.get(i);
    }

    public String toSQL() {
        return null;
    }

    @Override
    public Iterator<Expression> traverse(TraverseType traverseType) {
        switch (traverseType) {
            case INORDER:
                return inorder();
            case PREORDER:
                return preorder();
            default:
                return postorder();
        }
    }

    private void inorder(Expression root, List<Expression> list) {
        inorder(root.getChild(0), list);
        list.add(root);
        inorder(root.getChild(1));
    }

    private List<Expression> inorder(Expression root) {
        List<Expression> list = new ArrayList<>();
        inorder(root, list);

        return list;
    }

    private Iterator<Expression> inorder() {
        return inorder(this).iterator();
    }

    private void preorder(Expression root, List<Expression> list) {
        list.add(root);

        for (Expression child : root.getChildren()) {
            preorder(child, list);
        }
    }

    private List<Expression> preorder(Expression root) {
        List<Expression> list = new ArrayList<>();
        preorder(root, list);

        return list;
    }

    private Iterator<Expression> preorder() {
        return preorder(this).iterator();
    }

    private void postorder(Expression root, List<Expression> list) {
        for (Expression child : root.getChildren()) {
            postorder(child, list);
        }

        list.add(root);
    }

    private List<Expression> postorder(Expression root) {
        List<Expression> list = new ArrayList<>();
        postorder(root, list);

        return list;
    }

    private Iterator<Expression> postorder() {
        return postorder(this).iterator();
    }

    public List<Aggregation> getAggregations() {
        return getChildByType(Aggregation.class);
    }

    @Override
    public <T extends Expression> List<T> getChildByType(Class<T> clazz) {
        List<T> result = new ArrayList<>();

        Iterator<Expression> iterator = preorder();

        while (iterator.hasNext()) {
            Expression expression = iterator.next();

            if (expression.getClass() == clazz) {
                result.add((T) expression);
            }
        }

        return result;
    }

    @Override
    public Expression replace(Expression source, Expression target) {
        Expression parent = source.getParent();

        if (parent == null) {
            return target;
        }

        for (int index = 0; index < parent.getChildren().size(); ++index) {
            if (parent.getChild(index) == source) {
                target.setParent(parent);
                parent.getChildren().set(index, target);

                break;
            }
        }

        return this;
    }

    @Override
    public Literal evaluate() {
        throw new RuntimeException();
    }
}
