package com.anshishagua.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anshishagua.object.TableField;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.ForeachWriter;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.api.java.UDF2;
import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.streaming.GroupState;
import org.apache.spark.sql.streaming.GroupStateTimeout;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.LongType;
import org.apache.spark.sql.types.StringType;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Function1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparkStreamingUtils {
    public static void main(String [] args) throws Exception {
        SparkSession spark = SparkSession.builder().appName("wordcount").master("local[*]").getOrCreate();

        spark.sqlContext().udf().register("parse_json", new UDF2<String, String, String>() {
            public String call(String string, String field) throws Exception {
                JSONObject jsonObject = JSON.parseObject(string);

                return jsonObject.getString(field);
            }
        }, DataTypes.StringType);
        Dataset<Row> dataset = spark.readStream().format("kafka")
                .option("kafka.bootstrap.servers", "localhost:9092")
                .option("subscribe", "test")
                .load()
                .selectExpr("CAST(value AS STRING) AS value");

        dataset = dataset.selectExpr("parse_json(value, 'id') AS id",
                "parse_json(value, 'name') AS name",
                "parse_json(value, 'age') AS age", "parse_json(value, 'timestamp') AS timestamp");

        dataset = dataset.groupBy("age").agg(functions.sum(dataset.col("age")).alias("sum"));

        //dataset.as(Encoders.STRING()).groupByKey(null, Encoders.bean(Object.class)).mapGroupsWithState()
        //StreamingQuery query = dataset.writeStream().outputMode(OutputMode.Complete()).format("console").start();

        /*
        StreamingQuery query = dataset.writeStream().outputMode(OutputMode.Complete())
                .format("kafka")
                .option("kafka.bootstrap.servers", "localhost:9092")
                .option("subscribe", "output")
                .start();
        */

        StreamingQuery query1 = dataset.writeStream().outputMode(OutputMode.Complete()).format("foreach")
                .foreach(new ForeachWriter<Row>() {
                    @Override
                    public void process(Row value) {
                        System.out.println(value);
                    }

                    @Override
                    public void close(Throwable errorOrNull) {
                        //System.out.println("close");
                    }

                    @Override
                    public boolean open(long partitionId, long version) {
                        return true;
                    }
                })
                .start();

        /*
        JavaRDD<Row> javaRDD = dataset.toJavaRDD().map(new Function<Row, Row>() {
            public Row call(Row row) {
                String json = row.getString(0);

                JSONObject jsonObject = JSON.parseObject(json);

                Object [] objects = new Object[3];

                objects[0] = jsonObject.get("id");
                objects[1] = jsonObject.get("name");
                objects[2] = jsonObject.get("age");

                return RowFactory.create(objects);
            }
        });

        List<StructField> fields = Arrays.asList(DataTypes.createStructField("id", DataTypes.IntegerType, false),
                DataTypes.createStructField("name", DataTypes.StringType, false),
                DataTypes.createStructField("age", DataTypes.IntegerType, false));
        StructType structType = DataTypes.createStructType(fields);

        Dataset<Row> df = spark.createDataFrame(javaRDD, structType);

        query = df.writeStream().format("console").start();
        */

        query1.awaitTermination();

    }

    public static void main22(String [] args) throws Exception {
        SparkSession spark = SparkSession.builder().master("local[*]").appName("test").getOrCreate();

        List<Row> rows = new ArrayList<>();
        List<String> jsons = Files.readAllLines(Paths.get("/Users/xiaoli/IdeaProjects/common-utils/src/main/resources/jsons.txt"));

        jsons.forEach(json -> rows.add(RowFactory.create(json)));

        List<StructField> fields = Arrays.asList(DataTypes.createStructField("value", DataTypes.StringType, false));
        StructType structType = DataTypes.createStructType(fields);

        Dataset<Row> dataset = spark.createDataFrame(rows, structType);

        JavaRDD<Row> javaRDD = dataset.toJavaRDD().map(new Function<Row, Row>() {
            public Row call(Row row) {
                String json = row.getString(0);

                JSONObject jsonObject = JSON.parseObject(json);

                Object [] objects = new Object[3];

                objects[0] = jsonObject.get("id");
                objects[1] = jsonObject.get("name");
                objects[2] = jsonObject.get("age");

                return RowFactory.create(objects);
            }
        });

        fields = Arrays.asList(DataTypes.createStructField("id", DataTypes.IntegerType, false),
                DataTypes.createStructField("name", DataTypes.StringType, false),
                DataTypes.createStructField("age", DataTypes.IntegerType, false));
        structType = DataTypes.createStructType(fields);

        dataset = spark.createDataFrame(javaRDD, structType);

        dataset.select("id").show();
    }
}
