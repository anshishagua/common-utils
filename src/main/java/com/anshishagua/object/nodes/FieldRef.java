package com.anshishagua.object.nodes;

public class FieldRef extends AbstractExpression {
    private String tableName;
    private String fieldName;

    public FieldRef(String tableName, String fieldName) {
        this.tableName = tableName;
        this.fieldName = fieldName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String toSQL() {
        return String.format("%s.%s", tableName, fieldName);
    }
}
