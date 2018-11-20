from Node import Node
from GlobalContext import GlobalContext
import re


class Load(Node):
    def __init__(self, schema):
        self.schema = schema
        self.type = "LOAD"
        self.children = []

    def getRelation(self):
        return self.relation

    def getSchema(self):
        return self.schema

    def is_relation_op(self):
        return True

    def __str__(self):
        return "[type:%s, relation:%s, schema:%s]" % (self.type, self.relation, self.schema)

    def to_spark(self):
        schema_root_path = GlobalContext.get("schema_root")

        schema_name = self.schema

        if "|" in schema_name:
            schema_name = schema_name.split("|")[0]

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

        return "load_data_to_spark_dataframe(sc, %s, params)" % (schema)
