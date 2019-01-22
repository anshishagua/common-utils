import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.anshishagua.utils.CollectionUtils;
import com.anshishagua.utils.SparkUtils;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.StructType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsageWorkFlow {
    public static StructType structTypeFromFile(String fileName) {

        String json = null;

        try {
            json = Files.readAllLines(Paths.get(fileName)).stream().collect(Collectors.joining(" "));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        JSONArray jsonArray = JSON.parseObject(json).getJSONArray("schema");

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < jsonArray.size(); ++i) {
            if (builder.length() > 0) {
                builder.append(",");
            }

            builder.append(jsonArray.getString(i));
        }

        return SparkUtils.parseStructType(builder.toString());
    }

    public static void main(String [] args) {
        SparkSession spark = SparkSession.builder().master("spark://xiaoli:7077").appName("test").getOrCreate();

        List<Row> rows = new ArrayList<>();

        Dataset<Row> factAppDataUsage =  spark.createDataFrame(rows, structTypeFromFile("/Users/xiaoli/IdeaProjects/aardvark-analyze/statistics/marketing/schema/definitions/fact/hm_stage_fact_app_data_usage_f.schema"));

        //Dataset<Row> factAppDataUsage = SparkUtils.unionDataFrame(list);
        Map<String, String> params = new HashMap<>();
        params.put("date", "2018-01-01");

        long date = Long.parseLong(params.get("date").replace("-", ""));
        factAppDataUsage = factAppDataUsage.filter(functions.col("utc_date_key").gt(0).and(functions.col("utc_date_key").equalTo(date)));
        factAppDataUsage = factAppDataUsage
                .withColumnRenamed("network_operator_key", "serving_operator_key")
                .withColumnRenamed("upload_bytes", "bytes_ul")
                .withColumnRenamed("download_bytes", "bytes_dl")
                .withColumnRenamed("agent_receive_date", "agent_received_at")
                .withColumn("transformed_at", functions.lit(""));
        factAppDataUsage = SparkUtils.topElements(factAppDataUsage, Arrays.asList(functions.col("dup_key")), Arrays.asList(functions.col("agent_received_at").desc()));

        Dataset<Row> dimGuid = spark.createDataFrame(rows, structTypeFromFile("/Users/xiaoli/IdeaProjects/aardvark-analyze/statistics/usage/schema/definitions/dimension/mdm_dim_guid_d.schema"));
                //SparkUtils.loadDataFrame(spark, "MDM_DIM_GUID_D", params);
        dimGuid = dimGuid.select(functions.col("guid"), functions.col("guid_key"), functions.col("latest_os_version"), functions.col("latest_device_key"));
        factAppDataUsage = SparkUtils.joinDataFrame(factAppDataUsage, dimGuid, Arrays.asList("guid"));
        factAppDataUsage = factAppDataUsage
                .withColumn("device_key", functions.when(functions.col("latest_device_key").isNotNull(), functions.col("latest_device_key").cast("long")).otherwise(functions.col("device_key").cast("long")))
                .withColumn("os_version", functions.when(functions.col("latest_os_version").isNotNull(), functions.col("latest_os_version")).otherwise(functions.col("os_version")));

        List<Column> columns = Arrays.asList(functions.col("is_bad_product"), functions.col("is_bad_os_version"), functions.col("is_bad_bytes"));

        Column condition = functions.col("is_bad_product").equalTo("yes");
        condition = condition.or(functions.col("is_bad_os_version").equalTo("yes"));
        condition = condition.or(functions.col("is_bad_bytes").equalTo("yes"));

        factAppDataUsage = factAppDataUsage
                .withColumn("bad_record_key", functions.when(condition, functions.lit(1)).otherwise(functions.lit(-1)));
        //.withColumn("bad_record_key", _badRecordKey.apply(JavaConverters.asScalaIteratorConverter(columns.iterator()).asScala().toSeq()));

        Column [] groupByColumns = {
                functions.col("utc_date_key"),
                functions.col("utc_time_key"),
                functions.col("local_date_key"),
                functions.col("local_time_key"),
                functions.col("package"),
                functions.col("product_key"),
                functions.col("plan_key"),
                functions.col("guid_key"),
                functions.col("interface_key"),
                functions.col("sim_operator_key"),
                functions.col("serving_operator_key"),
                functions.col("device_key"),
                functions.col("longitude"),
                functions.col("latitude"),
                functions.col("os_version"),
                functions.col("ssid"),
                functions.col("bssid")
        };

        List<Column> aggrColumns = Arrays.asList(
                functions.max(functions.col("bad_record_key")).alias("bad_record_key"),
                functions.sum(functions.col("bytes_ul")).alias("bytes_ul"),
                functions.sum(functions.col("bytes_dl")).alias("bytes_dl"),
                functions.min(functions.col("transformed_at")).alias("transformed_at"),
                functions.min(functions.col("agent_received_at")).alias("agent_received_at"),
                functions.max(functions.col("backfill")).alias("backfill"),
                functions.max(functions.col("app_install_source")).alias("app_install_source"),
                functions.max(functions.col("app_version")).alias("app_version")
        );
        Dataset<Row> dedupFact = factAppDataUsage.groupBy(groupByColumns).agg(aggrColumns.get(0), CollectionUtils.toScalaSeq(aggrColumns.subList(1, aggrColumns.size())));
        dedupFact = dedupFact
                .withColumnRenamed("package", "bundle_name")
                .withColumnRenamed("bytes_ul", "upload_bytes")
                .withColumnRenamed("bytes_dl", "download_bytes");

        //SparkUtils.storeDataFrame(dedupFact,"", params, 20);

        long count = dedupFact.count();

        dedupFact.show();

        while (true) {

        }
    }
}
