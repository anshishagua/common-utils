a = "1,2"

a = a.split(",")

print isinstance(a, tuple)

from pyspark.sql import SparkSession
import pyspark.sql.functions as F


MONTHS_NAME_MAPPING = {
	'01': 'Jan',
	'02': 'Feb',
	'03': 'Mar',
	'04': 'Apr',
	'05': 'May',
	'06': 'Jun',
	'07': 'Jul',
	'08': 'Aug',
	'09': 'Sep',
	'10': 'Oct',
	'11': 'Nov',
	'12': 'Dec'
}


def rename_month(date):
	year = F.split(date, "-")[0]
	month = F.split(date, "-")[1]

	new_month = None

	for key, value in MONTHS_NAME_MAPPING.iteritems():
		if new_month is None:
			new_month = F.when(month == key, value)
		else:
			new_month = new_month.when(month == key, value)

	new_month = new_month.otherwise(F.lit(""))

	return F.format_string("%s %s", new_month, year)


def seconds_to_time(seconds):
	result = F.when(seconds.isNull(), F.lit("n/a"))

	second = seconds % 60
	minute = second / 60
	hour = minute / 60
	minute = minute % 60

	result = result.otherwise(F.format_string("%d:%02d:%02d", lit(hour), lit(minute), lit(second)))


spark = SparkSession.builder.getOrCreate()

df = spark.createDataFrame([("111111", 1)], ["str", "id"])
df = df.withColumn("str", F.format_string("%12s", F.col("str")))
df = df.withColumn("str", F.split(F.col("str"), ""))
columns = [
	"a",
	"b",
	"c",
	"d",
	"e",
	"f",
	"g",
	"h",
	"i",
	"j",
	"k",
	"l"
]


def split(column_name, sep, index):
	if index >= 0:
		return F.split(F.col(column_name), sep)[index]
	else:
		index = -index - 1
		return F.reverse(F.split(F.reverse(F.col(column_name)), sep)[index])


for i, column in enumerate(columns):
	df = df.withColumn(column, F.col("str")[i])
	df = df.withColumn(column, F.when(F.col(column) == " ", F.lit("0")).otherwise(F.col(column)))

df.show()
df = df.withColumn("str", F.split(F.col("str"), ""))
df = df.withColumn("str", F.explode(F.col("str")))
df = df.withColumn("aaa", F.struct(F.lit("1"), F.lit("2")))
F.array
df.show()


df = spark.createDataFrame([("120,340,456", "/tmp/a/b/a.py", 1)], ["str", "file", "id"])
df = df.withColumn("width", F.split(F.col("str"), ",")[0])
df.select("width").show()
df = df.withColumn("str", F.split(F.col("str"), ""))

df = df.withColumn("ext", split("file", "\\.", -1))
df.show()

values = [1, 2, 3]
df = df.withColumn("xxx", F.col("id").isin(values))
