from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType
import datetime, time
import pyspark.sql.utils
import pyspark.sql.functions as F

string = "2018-0011-19 00:00:00.00"

try:
	timestamp = time.mktime(datetime.datetime.strptime(string, "%Y-%m-%d %H:%M:%S.%f").timetuple())
except:
	timestamp = 0

print int(timestamp)


string = "2018-11-30 14:33:20.7|-300     |45.56678,-71.999092 |36e44fc30fb44b1b0001533747259826 "
data = []

data.append([value.strip() for value in string.split("|")])

print data

spark = SparkSession.builder.master("yarn").appName("test").getOrCreate()

schema = StructType([StructField("a", StringType())])
df = spark.read.schema(schema).csv("file:///tmp/aaa")
df = spark.createDataFrame(data, ('timestamp', 'offset', 'lat_lon', 'guid'))

print df.count()

networks = [
	("Vungle", "api.vungle.com"),
	("Startapp", "startappexchange.com"),
	("Mopub", "ads.mopub.com"),
	("Fyber", "adproxy.fyber.com"),
	("FAN", "graph.facebook.com"),
	("Adcolony", "iosads24.adcolony.com", "androidads21.adcolony.com"),
	("Admob", "googleads.g.doubleclick.net"),
	("Chartboost", "live.chartboost.com"),
	("Inmobi", "i.w.inmobi.com"),
	("Ironsource", "is-gateway.supersonicads.com", "rv-gateway.supersonicads.com"),
	("Youtube", "www.googleapis.com/youtubei"),
	("Unity", "webview.unityads.unity3d.com")
]


def parse_network(column):
	result = None

	for network in networks:
		key = network[0]
		values = network[1:]

		for value in values:
			if result is None:
				result = F.when(F.instr(column, value) > 0, key)
			else:
				result = result.when(F.instr(column, value) > 0, key)

	result = result.otherwise(F.lit("Other"))

	return result

