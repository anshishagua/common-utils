from pyspark.sql import *
from pyspark.sql.types import *

def get():
	return 1, 2


spark = SparkSession.builder.appName("aaa").master("local[*]").getOrCreate()

rows = [(1, 2, (1, 2))]

struct_type = StructType([StructField("inner_id1", IntegerType()), StructField("inner_id2", IntegerType())])
struct_type = StructType([StructField("id1", IntegerType()), StructField("id2", IntegerType()), StructField("id3", struct_type)])

df = spark.createDataFrame(rows, struct_type)
df.select(df.id3.inner_id1).show()