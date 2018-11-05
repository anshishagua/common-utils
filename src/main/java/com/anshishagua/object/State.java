package com.anshishagua.object;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.sql.functions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State implements Serializable {
    private List<Row> rows;

    public State() {
        rows = new ArrayList<>();
    }

    public void addRow(Row row) {
        this.rows.add(row);
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void remove(Row row) {
        this.rows.remove(row);
    }

    public static void main(String [] args) {
        SparkSession spark = SparkSession.builder().master("local[*]").appName("aaa").getOrCreate();

        List<Row> rows = new ArrayList<>();

        //id, name, money
        rows.add(RowFactory.create(1, "benben", 1111));
        rows.add(RowFactory.create(1, "benben", 33333));
        rows.add(RowFactory.create(2, "a", 555));

        StructType structType = DataTypes.createStructType(
                Arrays.asList(
                DataTypes.createStructField("id", DataTypes.IntegerType, false),
                DataTypes.createStructField("name", DataTypes.StringType, false),
                DataTypes.createStructField("money", DataTypes.IntegerType, false)));

        Dataset<Row> dataset = spark.createDataFrame(rows, structType);
        dataset.registerTempTable("person");

        long timestamp = 23234;

        dataset = dataset.sparkSession().sqlContext().sql("money > 1111");

        dataset.show();
    }
}
