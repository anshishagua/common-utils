package com.anshishagua.utils;

import com.anshishagua.object.ExecutePlan;
import com.anshishagua.object.ExecutePlan.ExecuteSQL;
import com.anshishagua.object.JoinType;
import com.anshishagua.object.Schema;
import com.anshishagua.object.TableField;
import com.anshishagua.object.Tuple2;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.concat;
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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SparkUtils {
    public static final int DEFAULT_NUM_PARTITION = 5;

    /*
    public static Dataset<Row> join(List<Dataset<Row>> datasets, List<String> joinColumns) {
        Dataset<Row> result = null;

        for (Dataset dataset : datasets) {
            if (result == null) {
                result = dataset;
            } else {
                Column joinCondition = null;

                result = result.join(dataset, )
            }
        }
    }
    */

    //a inner join b on b.id = a.id inner join c on c.id = b.id
    //

    /**
     *                         join
     *                     join   d
     *                 join   c
     *                a   b
     * @param datasetMap
     * @param joinConditions
     * @return
     */

    public static Dataset<Row> join(Map<String, Dataset<Row>> datasetMap, List<String> joinConditions) {
        Dataset<Row> dataset = null;

        Set<String> set = new HashSet<>();

        for (String joinCondition : joinConditions) {
            String [] strings = joinCondition.split("=");

            String leftTable = strings[0].trim().split("\\.")[0];
            String leftColumn = strings[0].trim().split("\\.")[1];

            String rightTable = strings[1].trim().split("\\.")[0];
            String rightColumn = strings[1].trim().split("\\.")[1];

            Dataset<Row> left = datasetMap.get(leftTable);
            Dataset<Row> right = datasetMap.get(rightTable);

            if (dataset == null) {
                dataset = left;
                set.add(leftTable);
            }

            if (!set.contains(rightTable)) {
                dataset = dataset.join(right, dataset.col(leftColumn).equalTo(right.col(rightColumn)));
                set.add(rightTable);
            } else {
                dataset = dataset.join(left, left.col(leftColumn).equalTo(dataset.col(rightColumn)));
                set.add(leftTable);
            }
        }

        return dataset;
    }

    public static Dataset<Row> join(Dataset<Row> a, Dataset<Row> b, String ... joinColumns) {
        return join(a, b, JoinType.INNER, joinColumns);
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

    public static Dataset<Row> join(Dataset<Row> a, Dataset<Row> b, List<Tuple2<String>> joinColumns) {
        return join(a, b, JoinType.INNER, joinColumns);
    }

    public static Dataset<Row> join(Dataset<Row> a, Dataset<Row> b, JoinType joinType, List<Tuple2<String>> joinColumns) {
        Column joinCondition = null;

        for (Tuple2<String> column : joinColumns) {
            Column condition = a.col(column.getFirst()).equalTo(b.col(column.getSecond()));

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

    public static Dataset<Row> emptyDataset(SparkSession spark, Schema schema) {
        List<TableField> tableFields = schema.getTableFields();

        StructType structType = DataTypes.createStructType(tableFields.stream().map(it -> TypeUtils.toStructField(it)).collect(Collectors.toList()));

        return spark.createDataFrame(new ArrayList<>(), structType);
    }

    public static void execute(ExecutePlan plan) {
        for (ExecuteSQL executeSQL : plan.getExecuteSQLs()) {

        }
    }

    public static void main2(String [] args) throws Exception {
        SparkSession spark = SparkSession.builder().appName("hello").master("local[*]").getOrCreate();

        String schemaFile = "/Users/lixiao/code/common-utils/src/main/resources/user_info/schema.json";

        Schema schema = Schema.load(new FileInputStream(schemaFile));
        Map<String, String> map = new HashMap<>();
        map.put("date", "2018-09-10");

        Dataset<Row> userInfo = load(spark, schema, map);

        //System.out.println(userInfo.count());

        schemaFile = "/Users/lixiao/code/common-utils/src/main/resources/user_account/schema.json";

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

        System.out.println(spark.sparkContext().applicationId());

        userInfo.join(userAccount, userInfo.col("id").equalTo(userAccount.col("user_id")))
                .show();

        Dataset<Row> aggregation = join(userInfo, userAccount, Arrays.asList(new Tuple2<>("id", "user_id")))
                .groupBy(userInfo.col("id"))
                .agg(sum(userAccount.col("balance")).alias("value"));

        result = join(userInfo, aggregation, "id");

        result = result.filter(userInfo.col("age").gt(34))
                .filter(userInfo.col("age").lt(36));

        result.registerTempTable("result");
        result.printSchema();
        result = result.filter("value >= 100000").select("id");

        result = result.withColumn("tag_name", lit("rich_man"))
                .withColumn("tag_id", lit(111L));

        result.printSchema();
        result.show();

        schema = Schema.load(new FileInputStream("/Users/lixiao/code/common-utils/src/main/resources/tags/schema.json"));

        map.put("date", "2018-09-10");
        map.put("tag_id", String.valueOf(111));

        save(result, schema, map, 3);

        Map<String, Dataset<Row>> datasetMap = new HashMap<>();

        //a.id
        datasetMap.put("aggregation_on_user_info", result);
    }

    public static void main(String [] args) throws Exception {
        SparkSession spark = SparkSession.builder().appName("hello").master("local[*]").getOrCreate();
        spark.sparkContext().setLogLevel("WARN");
        Map<String, Dataset<Row>> datasetMap = new HashMap<>();


        //System.out.println(userInfo.count());

        String schemaFile = "/Users/lixiao/code/common-utils/src/main/resources/user_info/schema.json";

        Schema schema = Schema.load(new FileInputStream(schemaFile));
        Map<String, String> map = new HashMap<>();
        map.put("date", "2018-09-10");
        Dataset<Row> userInfo = load(spark, schema, map);

        userInfo.show();

        schemaFile = "/Users/lixiao/code/common-utils/src/main/resources/user_account/schema.json";
        schema = Schema.load(new FileInputStream(schemaFile));
        Dataset<Row> userAccount = load(spark, schema, map);
        userAccount.show();

        schemaFile = "/Users/lixiao/code/common-utils/src/main/resources/account_info/schema.json";
        schema = Schema.load(new FileInputStream(schemaFile));
        Dataset<Row> accountInfo = load(spark, schema, map);
        userAccount.show();

        datasetMap.put("userInfo", userInfo);
        datasetMap.put("userAccount", userAccount);
        datasetMap.put("accountInfo", accountInfo);

        Dataset<Row> result = join(datasetMap, Arrays.asList("userAccount.id = userInfo.id",
                "accountInfo.account_id = userAccount.account_id"));

        result.printSchema();

        System.out.println(result.select(userInfo.col("id")));

    }
}
