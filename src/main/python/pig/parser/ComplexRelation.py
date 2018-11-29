from Node import Node


class ComplexRelation(Node):
    def __init__(self, expr):
        self.expr = expr
        self.type = "COMPLEX_RELATION"
        self.fields = []
        self.children = [expr]

    def __str__(self):
        return "fields: %s, name: %s" % (self.fields, self.name)

    def to_spark(self, exec_context):
        return self.expr.to_spark(exec_context)