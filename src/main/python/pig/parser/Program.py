import os

from Node import Node
from Register import Register
from Set import Set
from Assign import Assign
from Group import Group
from ComplexRelation import ComplexRelation
from String import String
from ParamVar import ParamVar
from Define import Define
import os

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

    def get_param_vars(self, node, result):
        if isinstance(node, ParamVar):
            result.add(node.value)
        else:
            if node.children:
                for child in node.children:
                    if isinstance(child, list):
                        for item in child:
                            self.get_param_vars(item, result)
                    else:
                        self.get_param_vars(child, result)

    def to_spark(self, exec_context):
        code = []
        imports = []
        body = []

        param_vars = set()
        self.get_param_vars(self, param_vars)

        for param_var in param_vars:
            body.append('%s = params["%s"]' % (param_var, param_var))

        body.append("")

        imports.append("import pyspark.sql.functions as F")
        imports.append("from bdce.common.spark.spark_utils import load_data_to_spark_dataframe, store_spark_dataframe")
        imports.append("from bdce.common.spark.udfs import join_spark_df, join_spark_dfs, union_spark_dfs")

        i = 0

        while i < len(self.children):
            statement = self.children[i]

            if isinstance(statement, (Set, Define)):
                i += 1
                continue
            if isinstance(statement, Register):
                file = statement.file

                if not file.endswith(".py"):
                    i += 1
                    continue

                file = statement.file.replace(".py", "")

                file = [item for item in file.split("/") if item != ".."]
                package = ".".join(file)

                if statement.alias:
                    imports.append("import %s as %s" % (package, statement.alias))
                else:
                    imports.append("import %s" % (package))

                i += 1
                continue

            if isinstance(statement, Assign) and isinstance(statement.children[0], Group):
                next_statement = self.children[i + 1].children[1]
                next_statement.src = ComplexRelation(statement.children[0])

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
                    code.append("    " + line)
            else:
                code.append("    " + statement)

        return "\n".join(code)

