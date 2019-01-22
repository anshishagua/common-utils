package com.anshishagua.object.nodes;

import com.anshishagua.constants.LiteralType;
import com.anshishagua.object.Field;
import com.anshishagua.object.Fields;
import com.anshishagua.object.TimeCondition;
import com.anshishagua.parser.ExpressionParser;
import com.anshishagua.utils.SparkSqlUtils;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF2;
import org.apache.spark.sql.catalyst.InternalRow;
import org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema;
import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.sql.functions;
import scala.Function2;
import scala.Tuple2;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    private static void process(Expression expression) {
        SparkSession spark = SparkSession.builder().getOrCreate();

        List<Aggregation> aggregations = expression.getChildByType(Aggregation.class);

        Aggregation aggregation = aggregations.get(0).get();

        Field timestampField = null;

        TimeCondition timeCondition = aggregation.getTimeCondition();

        if (timeCondition != null) {
            String a = timestampField.getName();
            String b = "'2018-01-01 11:11:11'";
            String timeQuery = aggregation.getTimeCondition().getValue() + " " + aggregation.getTimeCondition().getTimeUnit().getValue();

            String sql = String.format("select * from table where timestamp_within(%s, %s, %s)", a, b, timeQuery);

            Dataset<Row> dataset = spark.sql(sql);

            aggregation.setTimeCondition(null);

            sql = String.format("select " + aggregation.toSQL() + " from table ");

            double value = spark.sql(sql).collectAsList().get(0).getDouble(0);

            expression = expression.replace(aggregation, new Literal(LiteralType.DOUBLE, value));
        }

        System.out.println(aggregations);
    }

    public static void main(String [] args) {
        SparkSession spark = SparkSession.builder().master("local[*]").appName("aaa").getOrCreate();


        SparkSqlUtils.registerUdfs(spark);

        List<Field> list = new ArrayList<>();
        //id, name, age, money, timestamp
        list.add(new Field("id", "int", false));
        list.add(new Field("name", "string", false));
        list.add(new Field("age", "int", false));
        list.add(new Field("money", "double", false));
        list.add(new Field("timestamp", "long", true));

        Fields fields = new Fields(list.toArray(new Field[0]));
        StructType structType = fields.toStructType();

        Field timestampField = fields.getField("timestamp");

        Row current = RowFactory.create(1, "benben", 35, 100.0, System.currentTimeMillis());

        List<Row> rows = new ArrayList<>();
        rows.add(current);
        rows.add(RowFactory.create(1, "benben", 35, 100.0, System.currentTimeMillis()));
        rows.add(RowFactory.create(1, "benben", 38, 1000.0, System.currentTimeMillis()));

        Dataset<Row> dataset = spark.createDataFrame(rows, structType);
        dataset.registerTempTable("person");


        //String sql = "SELECT (1 as a, 2 as b, 3 as c) AS aaa FROM person where 1 > 1";

        UserDefinedFunction function = functions.udf(new UDF2<String, String, Row>() {
            @Override
            public Row call(String v1, String v2) {
                return RowFactory.create(v1.length(), v2.length());
            }
        }, DataTypes.createStructType(Arrays.asList(
                DataTypes.createStructField("id", DataTypes.LongType, false),
                DataTypes.createStructField("id2", DataTypes.LongType, false))));

        dataset = dataset.select(function.apply(functions.col("name"), functions.col("name")).alias("aaaa"));

        dataset = dataset.select(functions.col("aaaa.id2"));
        dataset.show();
        dataset.explain();

        //id, name, age
        rows = new ArrayList<>();
        structType = DataTypes.createStructType(Arrays.asList(
                DataTypes.createStructField("id", DataTypes.LongType, false),
                DataTypes.createStructField("name", DataTypes.StringType, false),
                DataTypes.createStructField("age", DataTypes.IntegerType, false)
        ));

        rows.add(RowFactory.create(111, "aaa", 11));
        Dataset<Row> df1 = spark.createDataFrame(Arrays.asList(RowFactory.create(new Long(1), "aaa", 11)), structType);
        Dataset<Row> df2 = spark.createDataFrame(Arrays.asList(RowFactory.create(new Long(1), "aaa", 11)), structType);

        Column condition = df1.col("id").equalTo(df2.col("id"));
        condition = condition.and(df1.col("name").equalTo(df2.col("name")));
        condition = condition.and(df1.col("age").equalTo(df2.col("age")));

        Dataset<Row> df = df1.join(df2, condition);

        df = df.select(df1.col("id"), df1.col("age"));
        //df = df.filter(df.col("id").$greater(111));


        df = df.repartition(3);
        int partitions = df.rdd().getNumPartitions();

        System.out.println(partitions);

        df.explain(true);

        Tuple2<String, String>[] all = spark.sparkContext().getConf().getAll();

        for (Tuple2<String, String> tuple2 : all) {
            System.out.println(tuple2._1 + ":" + tuple2._2);
        }

    }
}
