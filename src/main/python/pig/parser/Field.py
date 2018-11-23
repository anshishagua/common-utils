from Node import Node


class Field(Node):
    def __init__(self, name, relation=None):
        self.relation = relation
        self.name = name
        self.children = []
        self.type = "FIELD"

    def __str__(self):
        return '"FIELD": {"relation": "%s", "field_name": "%s"}' % (self.relation, self.name)

    def to_spark(self, exec_context):
        if self.relation is None:
                return "F.col('%s')" % (self.name)
        else:
            return "%s.%s" % (self.relation, self.name)

ALL_FIELD = Field("*")
