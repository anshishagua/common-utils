from Node import Node
from Register import Register
from Set import Set


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

        imports.append("import pyspark.sql.functions as F")
        imports.append("from bdce.common.spark.spark_utils import load_data_to_spark_dataframe, store_spark_dataframe")
        imports.append("from bdce.common.spark.udfs import join_spark_df, join_spark_dfs, union_spark_dfs")

        for line in imports:
            code.append(line)
        code.append("\n")

        code.append("def main(sc, params):")

        body = []

        for statement in self.children:
            if isinstance(statement, (Register, Set)):
                continue

            body.append(statement.toSpark())

        for statement in body:
            if isinstance(statement, list):
                for line in statement:
                    code.append("\t" + line)
            else:
                code.append("\t" + statement)

        return "\n".join(code)

