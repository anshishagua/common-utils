package com.anshishagua.object;

import com.anshishagua.functions.UserDefinedFunctions;
import com.anshishagua.utils.SparkSqlUtils;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
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
        SparkSession spark = SparkSession
                .builder()
                .master("local[*]")
                .appName("aaa")
                .getOrCreate();

        List<Row> rows = new ArrayList<>();

        SparkSqlUtils.registerUdfs(spark);

        //id, name, money, timestamp
        rows.add(RowFactory.create(1, "benben", 100.00, "2018-01-01 00:00:00"));
        rows.add(RowFactory.create(1, "benben", 200.00, "2018-01-01 01:01:00"));
        rows.add(RowFactory.create(2, "a", 300.00, "2018-01-01 11:11:11"));
        rows.add(RowFactory.create(3, "bbb", 1000.00, "2018-01-01 12:00:00"));

        StructType structType = DataTypes.createStructType(
                Arrays.asList(
                DataTypes.createStructField("id", DataTypes.IntegerType, false),
                DataTypes.createStructField("name", DataTypes.StringType, false),
                DataTypes.createStructField("money", DataTypes.DoubleType, false),
                DataTypes.createStructField("timestamp", DataTypes.StringType, false)));

        Dataset<Row> dataset = spark.createDataFrame(rows, structType);

        dataset = dataset.selectExpr("id", "name", "money", "parse_timestamp(timestamp) as timestamp");
        dataset.registerTempTable("person");

        //dataset = spark.sql("select id, name, avg(money) as avg from person where money > 11 group by id, name");

        dataset = spark.sql("select a.timestamp, b.timestamp, timestamp_within(a.timestamp, b.timestamp, '1 days') from person a inner join person b on a.id = b.id");

        dataset.show();
    }
}
