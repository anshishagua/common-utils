package com.anshishagua.utils;

import com.anshishagua.object.Schema;
import com.anshishagua.object.TableField;
import com.anshishagua.utils.DateTimeUtils;
import com.anshishagua.utils.ParamUtils;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;

import static org.apache.spark.sql.functions.expr;
import static org.apache.spark.sql.functions.lit;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SparkUtils {
    public static final int DEFAULT_NUM_PARTITION = 5;

    public static void save(Dataset dataset, Schema schema, Map<String, String> params) {
        save(dataset, schema, params, DEFAULT_NUM_PARTITION);
    }

    public static void save(Dataset dataset, Schema schema, Map<String, String> params, int partition) {
        String path = ParamUtils.replace(schema.getTableLocation(), params);

        dataset = dataset.coalesce(partition);

        dataset.write().mode(SaveMode.Overwrite).format(schema.getFileFormat()).save(path);
    }

    public static Dataset<Row> load(SparkSession spark, Schema schema, Map<String, String> params, String startDateString, String endDateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDate = LocalDate.parse(startDateString, formatter);
        LocalDate endDate = LocalDate.parse(endDateString, formatter);

        Dataset<Row> dataset = null;

        for (LocalDate date : DateTimeUtils.generate(startDate, endDate)) {
            params.put("date", formatter.format(date));

            Dataset<Row> df = load(spark, schema, params);

            if (dataset == null) {
                dataset = df;
            } else {
                dataset = dataset.union(df);
            }
        }

        return dataset;
    }

    public static Dataset<Row> load(SparkSession spark, String schemaFile, Map<String, String> params) throws IOException {
        return load(spark, Schema.load(new FileInputStream(schemaFile)), params);
    }

    public static Dataset<Row> load(SparkSession spark, Schema schema, Map<String, String> params) {
        String fileFormat = schema.getFileFormat();

        Dataset<Row> dataset = null;

        String path = ParamUtils.replace(schema.getTableLocation(), params);

        if ("parquet".equalsIgnoreCase(fileFormat)) {
            dataset = spark.read().parquet(path);
        } else if ("csv".equalsIgnoreCase(fileFormat)) {
            JavaRDD<String> javaRDD = spark.read().textFile(path).javaRDD();

            List<TableField> tableFields = schema.getTableFields();

            JavaRDD<Row> rowJavaRDD = javaRDD.map(line -> {
                String [] fields = line.split(",", -1);

                Object [] values = new Object[fields.length];

                for (int i = 0; i < fields.length; ++i) {
                    String type = tableFields.get(i).getFieldType();

                    values[i] = TypeUtils.convert(fields[i], type);
                }

                return RowFactory.create(values);
            });

            StructType structType = DataTypes.createStructType(tableFields.stream().map(it -> TypeUtils.toStructField(it)).collect(Collectors.toList()));

            dataset = spark.createDataFrame(rowJavaRDD, structType);
        } else {
            throw new IllegalArgumentException("Unsupported file format:" + fileFormat);
        }

        return dataset;
    }

    public static Dataset<Row> loadDaysData(SparkSession spark, String path, LocalDate startDate, LocalDate endDate) {
        Dataset<Row> dataset = null;

        Map<String, String> map = new HashMap<>();

        for (LocalDate date : DateTimeUtils.generate(startDate, endDate)) {
            map.put("date", date.toString());

            Dataset<Row> df = spark.read().parquet(ParamUtils.replace(path, map));

            if (dataset == null) {
                dataset = df;
            } else {
                dataset = dataset.union(df);
            }
        }

        return dataset;
    }

    public static void main(String [] args) throws Exception {
        SparkSession spark = SparkSession.builder().appName("hello").master("local[*]").getOrCreate();

        String schemaFile = "/Users/xiaoli/IdeaProjects/common-utils/src/main/resources/user_info/schema.json";

        Schema schema = Schema.load(new FileInputStream(schemaFile));
        Map<String, String> map = new HashMap<>();
        map.put("date", "2018-09-10");

        Dataset<Row> userInfo = load(spark, schema, map);

        System.out.println(userInfo.count());

        schemaFile = "/Users/xiaoli/IdeaProjects/common-utils/src/main/resources/user_account/schema.json";

        schema = Schema.load(new FileInputStream(schemaFile));
        Dataset<Row> userAccount = load(spark, schema, map);

        //userAccount.show();

        //Dataset<Row> result = userInfo.join(userAccount,
        //        userInfo.col("id").equalTo(userAccount.col("user_id")), "left_outer").groupBy();

        //result = result.drop("id[0]");
        //result.printSchema();
        //result.show();
    }
}
