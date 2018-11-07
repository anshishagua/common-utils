package com.anshishagua.utils;

import com.alibaba.fastjson.JSON;
import com.anshishagua.constants.LiteralType;
import com.anshishagua.functions.ParseJson;
import com.anshishagua.object.Event;
import com.anshishagua.object.EventConfig;
import com.anshishagua.object.EventState;
import com.anshishagua.object.Events;
import com.anshishagua.object.Field;
import com.anshishagua.object.KafkaDataSink;
import com.anshishagua.object.KafkaDataSource;
import com.anshishagua.object.SparkConfig;
import com.anshishagua.object.TimeCondition;
import com.anshishagua.object.nodes.Aggregation;
import com.anshishagua.object.nodes.Expression;
import com.anshishagua.object.nodes.Literal;
import com.anshishagua.parser.ExpressionParser;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.api.java.function.MapGroupsWithStateFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.GroupState;
import org.apache.spark.sql.streaming.GroupStateTimeout;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.types.StructType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * EventService.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class EventService {
    private static final Logger LOG = LoggerFactory.getLogger(EventService.class);

    public static void analyze(EventConfig eventConfig) {
        SparkConfig sparkConfig = eventConfig.getSparkConfig();

        SparkConf conf = new SparkConf();
        conf.setAppName(sparkConfig.getAppName());
        conf.setMaster(sparkConfig.getMaster());

        Properties properties = sparkConfig.getProperties();

        for (Object object : properties.keySet()) {
            String key = (String) object;
            String value = properties.getProperty(key);

            conf.set(key, value);
        }

        SparkSession spark = SparkSession
                .builder()
                .appName(sparkConfig.getAppName())
                .master(sparkConfig.getMaster())
                .config(conf)
                .getOrCreate();

        SparkSqlUtils.registerUdfs(spark);

        KafkaDataSource dataSource = new KafkaDataSource();

        String bootstrapServers = dataSource.getBootstrapServers().stream().map(it -> it.getHost() + ":" + it.getPort()).collect(Collectors.joining(","));
        Dataset<Row> dataset = spark
                .readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", bootstrapServers)
                .option("subscribe", dataSource.getTopic())
                .load()
                .selectExpr("CAST(value AS STRING) AS value");

        List<String> selectExpressions = new ArrayList<>();

        for (Field field : dataSource.getFields().getFields()) {
            String expression = SparkSqlUtils.callFunction(ParseJson.FUNCTION_NAME, "value", "'" + field.getName() + "'");

            expression = SparkSqlUtils.cast(expression, field.getType(), field.getName());

            selectExpressions.add(expression);
        }

        selectExpressions.add("value as json");

        dataset = dataset.selectExpr(selectExpressions.toArray(new String[0]));

        StructType structType = dataSource.getFields().toStructType();

        Field timestampField = dataSource.getFields().getTimestampField();

        String triggerCondition = eventConfig.getTriggerCondition();

        MapGroupsWithStateFunction<String, Row, EventState, Events> function = new MapGroupsWithStateFunction<String, Row, EventState, Events>() {
            @Override
            public Events call(String key, Iterator<Row> values, GroupState<EventState> state) throws Exception {
                Events events = new Events();

                while (values.hasNext()) {
                    Row row = values.next();

                    if (!state.exists()) {
                        EventState eventState = new EventState(Arrays.asList(row));

                        state.update(eventState);
                        continue;
                    }

                    EventState eventState = state.get();

                    List<Row> rows = eventState.getRows();
                    rows.add(row);

                    Dataset<Row> df = spark.createDataFrame(rows, structType);
                    String tempTableName = "table";

                    df.registerTempTable(tempTableName);

                    Expression expression = ExpressionParser.parse(triggerCondition);

                    List<Aggregation> aggregations = expression.getChildByType(Aggregation.class);

                    String sql = null;

                    for (Aggregation aggregation : aggregations) {
                        TimeCondition timeCondition = aggregation.getTimeCondition();

                        String a = timestampField.getName();
                        String b = row.getString(timestampField.getIndex());
                        String timeQuery = timeCondition.toString();

                        sql = String.format("select * from %s where timestamp_within(%s, %s, %s)", tempTableName, a, b, timeQuery);

                        df = spark.sql(sql);

                        aggregation.setTimeCondition(null);

                        sql = String.format("select cast(" + aggregation.toSQL() + " as double) from %s", tempTableName);

                        double value = spark.sql(sql).collectAsList().get(0).getDouble(0);

                        expression = expression.replace(aggregation, new Literal(LiteralType.DOUBLE, value));
                    }

                    df = spark.createDataFrame(Arrays.asList(row), structType);

                    boolean eventTriggered = !df.filter(expression.toSQL()).collectAsList().isEmpty();

                    if (eventTriggered) {
                        List<String> triggeredRecords = df.collectAsList()
                                .stream()
                                .map(it -> it.getString(dataSource.getFields().getField("json").getIndex()))
                                .collect(Collectors.toList());
                        long timestamp = row.getTimestamp(timestampField.getIndex()).getTime();

                        Event event = new Event(timestamp, triggeredRecords);

                        events.addEvent(event);

                        state.remove();
                    } else {
                        eventState = new EventState(df.collectAsList());
                        state.update(eventState);
                    }
                }

                return events;
            }
        };

        Field primaryKeyField = dataSource.getFields().getPrimaryKeyField();

        Dataset<Events> eventsDataset = dataset
                .groupByKey(new MapFunction<Row, String>() {
            @Override
            public String call(Row value) {
                return value.get(primaryKeyField.getIndex()).toString();
            }
        }, Encoders.STRING())
                .mapGroupsWithState(function,
                        Encoders.bean(EventState.class),
                        Encoders.bean(Events.class),
                        GroupStateTimeout.ProcessingTimeTimeout());

        Dataset<Event> eventDataset = eventsDataset.flatMap(new FlatMapFunction<Events, Event>() {
            public Iterator<Event> call(Events events) {
                return events.getEvents().iterator();
            }
        }, Encoders.bean(Event.class));

        Dataset<String> events = eventDataset.map(new MapFunction<Event, String>() {
            @Override
            public String call(Event value) {
                return JSON.toJSONString(value);
            }
        }, Encoders.STRING());

        KafkaDataSink dataSink = eventConfig.getKafkaDataSink();

        bootstrapServers = dataSink.getBootstrapServers().stream().map(hostPort -> String.format("%d:%s", hostPort.getHost(), hostPort.getPort())).collect(Collectors.joining(","));

        String checkpointLocation = String.format("/tmp/checkpoint/" + dataSink.getTopic());

        StreamingQuery query = events
                .writeStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", bootstrapServers)
                .option("topic", dataSink.getTopic())
                .option("checkpointLocation", checkpointLocation)
                .outputMode(OutputMode.Update())
                .start();

        try {
            query.awaitTermination();
        } catch (StreamingQueryException ex) {
            LOG.warn("Exception", ex);
        }
    }

    public static void main(String [] args) {

    }
}
