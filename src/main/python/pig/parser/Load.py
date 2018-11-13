from Node import Node


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
        return "[type:%s, relation:%s, schema:%s]" % \
               (self.type, self.relation, self.schema)

