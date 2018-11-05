package com.anshishagua.utils;

import org.apache.spark.sql.Column;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SparkSqlUtils {
    public static String callFunction(String functionName, String ... args) {
        StringBuilder builder = new StringBuilder(functionName);

        builder.append("(");

        builder.append(Arrays.asList(args).stream().collect(Collectors.joining(", ")));

        builder.append(")");

        return builder.toString();
    }

    public static String cast(String expression, String dataType) {
        return String.format("CAST(%s as %s)", expression, dataType);
    }

    public static String cast(String expression, String dataType, String alias) {
        return String.format("CAST(%s as %s) AS %s", expression, dataType, alias);
    }

    public static Column toColumn() {
        return null;
    }
}
