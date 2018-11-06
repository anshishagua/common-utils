package com.anshishagua.object.nodes;

import com.anshishagua.constants.LiteralType;
import com.anshishagua.object.Field;
import com.anshishagua.object.Fields;
import com.anshishagua.object.TimeCondition;
import com.anshishagua.parser.ExpressionParser;
import com.anshishagua.utils.SparkSqlUtils;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
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
        String string = "SUM(person.money within 7 minutes) >= 100 and person.age >= 30 and person.age <= 40";

        Expression expression = ExpressionParser.parse(string);

        System.out.println(expression.toSQL());

        SparkSession spark = SparkSession.builder().master("local[*]").appName("aaa").getOrCreate();

        SparkSqlUtils.registerUdfs(spark);

        List<Aggregation> aggregations = expression.getChildByType(Aggregation.class);

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

        for (Aggregation aggr : aggregations) {
            TimeCondition timeCondition = aggr.getTimeCondition();

            if (timeCondition != null) {
                String a = timestampField.getName();
                long b = current.getLong(timestampField.getIndex());

                String timeQuery = aggr.getTimeCondition().getValue() + " " + aggr.getTimeCondition().getTimeUnit().getValue();

                String sql = String.format("select * from person where timestamp_within(%s, %s, '%s')", a, b, timeQuery);

                dataset = spark.sql(sql);

                aggr.setTimeCondition(null);

                sql = String.format("select cast(" + aggr.toSQL() + " as double) from person ");

                double value = spark.sql(sql).collectAsList().get(0).getDouble(0);

                expression = expression.replace(aggr, new Literal(LiteralType.DOUBLE, value));
            }
        }

        String sql = "SELECT * FROM person WHERE " + expression.toSQL();

        dataset = spark.sql(sql);

        System.out.println(sql);

        dataset.show();


        /*
        List<Row> rows = new ArrayList<>();
        rows.add(RowFactory.create(1));
        rows.add(RowFactory.create(2));

        StructType structType = DataTypes.createStructType(Arrays.asList(DataTypes.createStructField("id", DataTypes.IntegerType, false)));
        Dataset<Row> dataset = spark.createDataFrame(rows, structType);
        dataset.registerTempTable("table");

        System.out.println(expression.toSQL());
        String sql = "SELECT COUNT(*) from table where " + expression.toSQL();

        //Row row = spark.sql(sql).collectAsList().get(0);

        //System.out.println(row.getLong(0));
        */
    }
}
