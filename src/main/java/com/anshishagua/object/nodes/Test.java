package com.anshishagua.object.nodes;

import com.anshishagua.constants.AggregationType;
import com.anshishagua.constants.ArithmeticCompareType;
import com.anshishagua.constants.ArithmeticType;
import com.anshishagua.constants.LiteralType;
import com.anshishagua.object.Field;
import com.anshishagua.object.TimeCondition;
import com.anshishagua.object.TimeUnit;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.List;

public class Test {
    private static void process(Expression expression) {
        SparkSession spark = SparkSession.builder().getOrCreate();

        List<Expression> aggregations = expression.getChildByType(Aggregation.class);

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
        Expression add = new ArithmeticExpression(ArithmeticType.PLUS,
                new FieldRef("person", "money"),
                new Literal(LiteralType.INTEGER, 1));

        add = new Paren(add);

        Expression aggregation = new Aggregation(AggregationType.SUM,
                add,
                new TimeCondition(7, TimeUnit.MINUTES));

        Expression expression = new ArithmeticCompare(ArithmeticCompareType.LARGER_THAN,
                aggregation, new Literal(LiteralType.INTEGER, 111));

        expression = expression.replace(add, new Literal(LiteralType.INTEGER, 123));

        System.out.println(expression.toSQL());

        System.out.println(expression.getChildByType(Aggregation.class));
    }
}
