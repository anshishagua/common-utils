import pyspark.sql.functions as F
from pyspark.sql.session import SparkSession

sc = SparkSession.builder.getOrCreate()


params = {
	"date": "2019-01-08"
}

df = load_data_to_spark_dataframe(sc, "CAPI_APP_REQUESTS_F", params)
df = df.filter((F.instr(F.lower(F.col("remote_server_host")), "inmobi.com") > 0))

df = df.groupby("bundle_id").agg(F.count("bundle_id").alias("count"))

df = df.orderBy(F.col("count").desc())

#print df.count()
df.show(20, False)