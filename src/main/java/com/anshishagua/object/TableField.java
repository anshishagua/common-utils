package com.anshishagua.object;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class TableField implements Serializable {
    @JSONField(name = "field_name")
    private String fieldName;

    @JSONField(name = "field_type")
    private String fieldType;

    @JSONField(name = "nullable")
    private boolean nullable;

    @JSONField(name = "is_primary_key")
    private boolean isPrimaryKey;

    public TableField() {

    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }

    @Override
    public String toString() {
        return "TableField{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", nullable=" + nullable +
                ", isPrimaryKey=" + isPrimaryKey +
                '}';
    }
}