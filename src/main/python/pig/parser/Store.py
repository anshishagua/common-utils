from Node import Node


class Store(Node):
    def __init__(self, relation, schema):
        self.relation = relation
        self.schema = schema
        self.type = "STORE"

    def getSchema(self):
        return self.schema

    def __str__(self):
        return "[type:%s, relation:%s, schema:%s]" % (self.type, self.relation, self.schema)

    def toSpark(self):
        return "store_spark_dataframe(sc, %s, '%s');" % (self.relation, self.schema)