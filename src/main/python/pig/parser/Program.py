from Node import Node
from Register import Register
from Set import Set
from Assign import Assign
from Group import Group
from ComplexRelation import ComplexRelation


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

    def to_spark(self, exec_context):
        code = []
        imports = []
        body = []

        imports.append("import pyspark.sql.functions as F")
        imports.append("from bdce.common.spark.spark_utils import load_data_to_spark_dataframe, store_spark_dataframe")
        imports.append("from bdce.common.spark.udfs import join_spark_df, join_spark_dfs, union_spark_dfs")

        i = 0

        while i < len(self.children):
            statement = self.children[i]

            if isinstance(statement, Set):

                i += 1
                continue
            if isinstance(statement, Register):
                file = statement.file.replace(".py", "")

                if statement.alias:
                    imports.append("import %s as %s" % (file, statement.alias))
                else:
                    imports.append("import %s" % (file))

                i += 1
                continue

            if isinstance(statement, Assign) and isinstance(statement.children[1], Group):
                next_statement = self.children[i + 1].children[1]
                next_statement.src = ComplexRelation(statement.children[1])

                i += 1
                continue

            generated_code = statement.to_spark(exec_context)

            if isinstance(generated_code, list):
                for item in generated_code:
                    body.append(item)
            else:
                body.append(generated_code)

            i += 1

        for line in imports:
            code.append(line)
        code.append("\n")
        code.append("def main(sc, params):")

        for statement in body:
            if isinstance(statement, list):
                for line in statement:
                    code.append("\t" + line)
            else:
                code.append("\t" + statement)

        return "\n".join(code)

