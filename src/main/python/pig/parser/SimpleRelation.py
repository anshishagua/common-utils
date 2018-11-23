from Node import Node


class SimpleRelation(Node):
    def __init__(self, name, fields=[]):
        self.name = name
        self.type = "SIMPLE_RELATION"
        self.fields = fields

    def is_simple(self):
        return not isinstance(self.expr, Node)

    def __str__(self):
        return "fields: %s, name: %s" % (self.fields, self.name)

    def to_spark(self, exec_context):
        #self.fields = exec_context.relation_map[self.name]

        return self.name
