from Node import Node


class Program(Node):
    def __init__(self, statements):
        self.children = statements
        self.type = "PROGRAM"

    def __str__(self):
        result = "[type:%s, statements:[" % (self.type)

        for child in self.children:
            result += " " + str(child)

        result += "]]"

        return result

    def toSpark(self):
        code = []
        imports = []

        imports.append("from pyspark.sql.functions import col, when, lit, udf, to_date, broadcast")
        imports.append("from bdce.common.spark.spark_utils import load_data_to_spark_dataframe, store_spark_dataframe")
        imports.append("from bdce.common.spark.udfs import join_spark_df, join_spark_dfs")

        for line in imports:
            code.append(line)
        code.append("\n")

        code.append("def main(sc, params):")

        body = []

        for statement in self.children:
            body.append(statement.toSpark())

        for line in body:
            code.append("\t" + line)

        return "\n".join(code)

