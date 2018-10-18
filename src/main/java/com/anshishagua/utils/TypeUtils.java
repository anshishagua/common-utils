package com.anshishagua.utils;

import com.anshishagua.object.TableField;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;

import java.time.LocalDate;

public class TypeUtils {
    public static Object convert(String string, String type) {
        switch (type) {
            case "boolean":
                return Boolean.parseBoolean(string);
            case "int":
                return Integer.parseInt(string);
            case "long":
                return Long.parseLong(string);
            case "float":
                return Float.parseFloat(string);
            case "double":
                return Double.parseDouble(string);
            case "date":
                return LocalDate.parse(string);
            case "timestamp":
                return string;
            default:
                return string;
        }
    }

    public static DataType toDataType(String string) {
        switch (string) {
            case "boolean":
                return DataTypes.BooleanType;
            case "int":
                return DataTypes.IntegerType;
            case "long":
                return DataTypes.LongType;
            case "float":
                return DataTypes.FloatType;
            case "double":
                return DataTypes.DoubleType;
            case "date":
                return DataTypes.DateType;
            case "timestamp":
                return DataTypes.TimestampType;
            default:
                return DataTypes.StringType;
        }
    }

    public static StructField toStructField(TableField tableField) {
        return DataTypes.createStructField(tableField.getFieldName(), toDataType(tableField.getFieldType()), tableField.isNullable());
    }
}