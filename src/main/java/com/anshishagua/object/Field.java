package com.anshishagua.object;

import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;

import java.io.Serializable;

public class Field implements Serializable {
    private int index;
    private String name;
    private String type;
    private boolean nullable;
    private boolean primaryKey;
    private boolean isTimestamp;

    public Field(String name, String type, boolean isTimestamp) {
        this.name = name;
        this.type = type;
        this.isTimestamp = isTimestamp;
    }

    public Field(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isTimestamp() {
        return isTimestamp;
    }

    public StructField toStructField() {
        DataType dataType = DataTypes.StringType;

        switch (type) {
            case "int":
                dataType = DataTypes.IntegerType;
                break;
            case "long":
                dataType = DataTypes.LongType;
                break;
            case "double":
                dataType = DataTypes.DoubleType;
                break;
            default:
                break;
        }

        return DataTypes.createStructField(name, dataType, false);
    }
}
