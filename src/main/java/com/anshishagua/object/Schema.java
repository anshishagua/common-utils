package com.anshishagua.object;

/*
{
  "table_name": "user_info",
  "file_format": "csv",
  "table_location": "/aaa/bbb/ccc/date=${date}/",
  "table_partitions": [
    {"field_name": "date", "field_type": "string"}
  ],
  "table_fields": [
    {"field_name": "id", "field_type": "long", "nullable": true, "is_primary_key": true},
    {"field_name": "name", "field_type": "string", "nullable": true},
    {"field_name": "age", "field_type": "int", "nullable": true}
  ]
}
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class Schema implements Serializable {
    @JSONField(name = "table_name")
    private String tableName;

    @JSONField(name = "file_format")
    private String fileFormat;

    @JSONField(name = "table_location")
    private String tableLocation;

    @JSONField(name = "table_partitions")
    private List<TableField> tablePartitions;

    @JSONField(name = "table_fields")
    private List<TableField> tableFields;

    public Schema() {

    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getTableLocation() {
        return tableLocation;
    }

    public void setTableLocation(String tableLocation) {
        this.tableLocation = tableLocation;
    }

    public List<TableField> getTablePartitions() {
        return tablePartitions;
    }

    public void setTablePartitions(List<TableField> tablePartitions) {
        this.tablePartitions = tablePartitions;
    }

    public List<TableField> getTableFields() {
        return tableFields;
    }

    public void setTableFields(List<TableField> tableFields) {
        this.tableFields = tableFields;
    }

    @Override
    public String toString() {
        return "Schema{" +
                "tableName='" + tableName + '\'' +
                ", fileFormat='" + fileFormat + '\'' +
                ", tableLocation='" + tableLocation + '\'' +
                ", tablePartitions=" + tablePartitions +
                ", tableFields=" + tableFields +
                '}';
    }

    public static Schema load(InputStream inputStream) throws IOException {
        return JSON.parseObject(inputStream, Schema.class);
    }

    public static Schema load(String json) {
        return JSON.parseObject(json, Schema.class);
    }

    public static void main(String [] args) throws IOException {
        Schema schema = Schema.load(new FileInputStream("/Users/xiaoli/IdeaProjects/common-utils/src/main/resources/schema.json"));

        System.out.println(schema);
    }
}
