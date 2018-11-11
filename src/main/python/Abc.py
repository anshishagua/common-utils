
import antlr4


class TreeNode(object):
    def __init__(self):
        self.parent = None
        self.children = []

    def set_parent(self, parent):
        self.parent = parent


class Load(object):
    def __init__(self, alias, schema):
        self.alias = alias
        self.schema = schema

    def toSpark(self):
        return "%s = load_data_to_spark_dataframe(sc, \"%s\", params)" % (self.alias, self.schema)


class Store(object):
    def __init__(self, relation, schema):
        self.relation = relation
        self.schema = schema

    def toSpark(self):
        return "store_spark_dataframe(sc, %s, \"%s\", params)" % (self.relation, self.schema)


class SparkCodeGen(object):

    def __init__(self, parse_tree):
        self.aaa = None
        self.parsedTree = [Load("aaa", "bbb"), Store("ccc", "deee")]
        self.lines = []

    def doImport(self):
        string = "from bdce.common.spark.spark_utils import load_data_to_spark_dataframe, store_spark_dataframe"

        self.lines.append(string)

        string = "from pyspark.sql import functions as F"

        self.lines.append(string)

        self.lines.append("\n")
        ##self.lines.append("\n")

    def genMain(self):
        code = "def main(sc, params):"

        self.lines.append(code)

    def genLoad(self, ident):
        ident_string = "".join([" " for i in range(ident)])

        code = ident_string + self.parsedTree[0].toSpark()
        self.lines.append(code)

    def genStore(self, ident):
        ident_string = "".join([" " for x in range(ident)])

        code = ident_string + self.parsedTree[1].toSpark()
        self.lines.append(code)

    def codeGen(self):
        self.doImport()
        self.genMain()
        self.genLoad(4)
        self.genStore(4)
        return "\n".join(self.lines)


def main():
    codeGen = SparkCodeGen(None)

    print codeGen.codeGen()

    tree_node = TreeNode()
    tree_node.parent

main()

