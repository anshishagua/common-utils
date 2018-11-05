package com.anshishagua.object.nodes;

import org.apache.spark.sql.types.DataTypes;

/**
 * Literal.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class Literal implements Node {
    public enum Type {
        BOOLEAN,
        STRING,
        SHORT,
        INTEGER,
        LONG,
        FLOAT,
        DOUBLE,
        DATE,
        TIMESTAMP
    };

    private Type type;
    private Object value;

}
