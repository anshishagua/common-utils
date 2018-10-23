spark-submit  --class org.apache.spark.examples.SparkPi \
    --master yarn \
    --deploy-mode cluster \
    --driver-memory 1g \
    --executor-memory 1g \
    --executor-cores 1 \
    /usr/local/spark/spark-2.0.2-bin-hadoop2.7/examples/jarspark-examples_2.11-2.0.2.jar \
    10
