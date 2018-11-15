from Node import Node
import re


class Load(Node):
    def __init__(self, relation, schema):
        self.relation = relation
        self.schema = schema
        self.type = "LOAD"

    def getRelation(self):
        return self.relation

    def getSchema(self):
        return self.schema

    def __str__(self):
        return "[type:%s, relation:%s, schema:%s]" % (self.type, self.relation, self.schema)

    def toSpark(self):
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

        return "%s = load_data_to_spark_dataframe(sc, %s, params);" % (self.relation, schema)
