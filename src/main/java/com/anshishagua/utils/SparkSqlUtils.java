package com.anshishagua.utils;

import com.anshishagua.functions.UserDefinedFunctions;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;

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

    public static void registerUdfs(SparkSession spark) {
        spark.udf().register("parse_timestamp", UserDefinedFunctions.PARSE_TIMESTAMP_LONG_PARAM, DataTypes.TimestampType);
        spark.udf().register("parse_timestamp", UserDefinedFunctions.PARSE_TIMESTAMP_STRING_PARAM, DataTypes.TimestampType);
        spark.udf().register("timestamp_within", UserDefinedFunctions.TIMESTAMP_WITHIN, DataTypes.BooleanType);
    }
}
