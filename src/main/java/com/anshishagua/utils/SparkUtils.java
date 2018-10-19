package com.anshishagua.utils;

import com.anshishagua.object.JoinType;
import com.anshishagua.object.Schema;
import com.anshishagua.object.TableField;
import com.anshishagua.object.Tuple2;
import com.anshishagua.utils.DateTimeUtils;
import com.anshishagua.utils.ParamUtils;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.count;
import static org.apache.spark.sql.functions.expr;
import static org.apache.spark.sql.functions.lit;
import static org.apache.spark.sql.functions.sum;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

public class SparkUtils {
    public static final int DEFAULT_NUM_PARTITION = 5;

    public static Dataset<Row> join(Dataset<Row> a, Dataset<Row> b, String ... joinFields) {
        return join(a, b, JoinType.INNER, joinFields);
    }

    public static Dataset<Row> join(Dataset<Row> a, Dataset<Row> b, JoinType joinType, String ... joinColumns) {
        Dataset<Row> dataset = null;

        Column joinCondition = null;

        for (String field : joinColumns) {
            Column condition = a.col(field).equalTo(b.col(field));

            if (joinCondition == null) {
                joinCondition = condition;
            } else {
                joinCondition = joinCondition.and(condition);
            }
        }

        dataset = a.join(b, joinCondition, joinType.getValue());

        Set<String> aColumns = new LinkedHashSet<>();
        for (String column : a.columns()) {
            aColumns.add(column);
        }

        Set<String> bColumns = new LinkedHashSet<>();
        for (String column : a.columns()) {
            bColumns.add(column);
        }

        Set<String> commonColumns = new LinkedHashSet<>();
        for (String joinColumn : joinColumns) {
            commonColumns.add(joinColumn);
        }

        bColumns.removeAll(commonColumns);

        for (String column : commonColumns) {
            dataset = dataset.drop(b.col(column));
        }

        return dataset;
    }

    public static Dataset<Row> join(Dataset<Row> a, Dataset<Row> b, List<Tuple2<String>> joinFields) {
        return join(a, b, JoinType.INNER, joinFields);
    }

    public static Dataset<Row> join(Dataset<Row> a, Dataset<Row> b, JoinType joinType, List<Tuple2<String>> joinFields) {
        Column joinCondition = null;

        for (Tuple2<String> joinField : joinFields) {
            Column condition = a.col(joinField.getFirst()).equalTo(b.col(joinField.getSecond()));

            if (joinCondition == null) {
                joinCondition = condition;
            } else {
                joinCondition = joinCondition.and(condition);
            }
        }

        Dataset<Row> dataset = a.join(b, joinCondition, joinType.getValue());

        return dataset;
    }

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

        //System.out.println(userInfo.count());

        schemaFile = "/Users/xiaoli/IdeaProjects/common-utils/src/main/resources/user_account/schema.json";

        schema = Schema.load(new FileInputStream(schemaFile));
        Dataset<Row> userAccount = load(spark, schema, map);

        //userAccount.show();

        List<Tuple2<String>> list = new ArrayList<>();
        list.add(new Tuple2<>("id", "user_id"));
        Dataset<Row> result = join(userInfo, userAccount, JoinType.INNER, list)
                .groupBy(userInfo.col("id"))
                .agg(sum(userAccount.col("balance")).alias("total_balance"),
                        count(userAccount.col("id")).alias("num_account"))
                .orderBy(expr("total_balance").desc());

        result = result.withColumn("avg_balance", col("total_balance").divide(col("num_account")));

        result.printSchema();
        result.show();
    }
}
