package com.anshishagua.object.nodes;

import com.anshishagua.constants.LiteralType;

import java.sql.Timestamp;

/**
 * Literal.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class Literal extends AbstractExpression {
    private LiteralType type;
    private Object value;

    public Literal(LiteralType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public LiteralType getType() {
        return type;
    }

    public <T> T getAs() {
        return (T) value;
    }

    public Boolean getBoolean() {
        return (Boolean) value;
    }

    public Short getShort() {
        return (Short) value;
    }

    public Integer getInteger() {
        return (Integer) value;
    }

    public Long getLong() {
        return (Long) value;
    }

    public Float getFloat() {
        return (Float) value;
    }

    public Double getDouble() {
        return (Double) value;
    }

    public String getString() {
        return (String) value;
    }

    public Timestamp getTimestamp() {
        return (Timestamp) value;
    }

    @Override
    public String toSQL() {
        if (value == null) {
            return "null";
        }

        if (type == LiteralType.STRING || type == LiteralType.TIMESTAMP) {
            return "'" + value.toString() + "'";
        }

        return value.toString();
    }

    @Override
    public Literal evaluate() {
        return this;
    }
}
