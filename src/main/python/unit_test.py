import unittest
import os
import sys

SPARK_HOME = os.environ["SPARK_HOME"]
os.path.join(SPARK_HOME)
print SPARK_HOME + "\n"

# Add the PySpark directories to the Python path:
sys.path.insert(1, os.path.join(SPARK_HOME, 'python'))
sys.path.insert(1, os.path.join(SPARK_HOME, 'python', 'pyspark'))
sys.path.insert(1, os.path.join(SPARK_HOME, 'python', 'build'))
sys.path.insert(1, os.path.join(SPARK_HOME, 'python', 'lib/py4j-0.8.2.1-src.zip'))

# If PySpark isn't specified, use currently running Python binary:
pyspark_python = sys.executable
os.environ['PYSPARK_PYTHON'] = pyspark_python

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType
import pyspark.sql.functions as F



class MyTest(unittest.TestCase):
	def tearDown(self):
		self.spark.stop()
		print('111')

	def setUp(self):
		self.spark = SparkSession.builder.master("local[*]").getOrCreate()

	@classmethod
	def tearDownClass(self):
		print('4444444')

	@classmethod
	def setUpClass(self):
		print('33333')

	def test_a_run(self):
		self.assertEqual(1, 1)

	def test_b_run(self):
		schema = StructType([StructField("name", StringType()), StructField("age", IntegerType())])

		df = self.spark.createDataFrame([('Alice', 1)], schema)
		df.printSchema()

		string = df.select(F.reverse("name")).collect()[0][0]
		self.assertEqual(string, "ecilA")


if __name__ == '__main__':
	# unittest.main()
	pass


string = """Vungle    https://api.vungle.com
Startapp startappexchange.com
Mopub    ads.mopub.com
Fyber    adproxy.fyber.com
FAN    graph.facebook.com
Adcolony https://iosads24.adcolony.com    https://androidads21.adcolony.com
Admob    googleads.g.doubleclick.net
Chartboost    https://live.chartboost.com
Inmobi    http://i.w.inmobi.com
Ironsource    http://is-gateway.supersonicads.com    http://rv-gateway.supersonicads.com
Youtube  https://www.googleapis.com/youtubei
Unity    https://webview.unityads.unity3d.com/
"""

lines = string.split("\n")

for line in lines:
	a = line.split(" ")

	array = []

	for s in a:
		if s == "":
			continue

		s = s.replace("http://", "").replace("https://", "")

		array.append('"' + s + '"')

	s = ", ".join(array)
	s = "(" + s + "),"
	print s