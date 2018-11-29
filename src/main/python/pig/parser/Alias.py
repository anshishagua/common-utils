from Node import Node

class Alias(Node):
    def __init__(self, name, expr):
        self.name = name
        self.expr = expr
        self.children = [expr]
        self.type = "ALIAS"

    def __str__(self):
        return "ALIAS:name:%s,expr:%s" % (self.name, self.expr)

    def to_spark(self, exec_context):
        field = self.expr.to_spark(exec_context)

        if self.expr.type == "STRING":
            field = "F.lit(%s)" % (field)

        alias = self.name

        if self.name.type == 'FIELD':
            alias = "'%s'" %(self.name.name)

        return "%s.alias(%s)" % (field, alias)