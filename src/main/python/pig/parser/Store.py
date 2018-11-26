from Node import Node
import re


class Store(Node):
    def __init__(self, relation, schema):
        self.relation = relation
        self.schema = schema
        self.type = "STORE"
        self.children = []

    def getSchema(self):
        return self.schema

    def __str__(self):
        return "[type:%s, relation:%s, schema:%s]" % (self.type, self.relation, self.schema)

    def to_spark(self, exec_context):
        schema = self.schema

        params = re.findall("\$[a-zA-Z0-9_]+", schema)

        paramValues = []

        for param in params:
            key = param[1:]
            schema = schema.replace(param, "%s")
            paramValues.append("str(params['%s'])" % (key))

        if paramValues:
            schema = "'" + schema + "' % (" + ", ".join(paramValues) + ")"
        else:
            schema = "'" + schema + "'"

        return "store_spark_dataframe(sc, %s, %s)" % (self.relation, schema)
