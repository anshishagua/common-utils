from Node import Node

class Alias(Node):
    def __init__(self, name, expr):
        self.name = name
        self.expr = expr
        self.type = "ALIAS"

    def __str__(self):
        return "ALIAS:name:%s,expr:%s" % (self.name, self.expr)

    def toSpark(self):
        return "%s.alias(%s)" % (self.name.toSpark(), self.expr.toSpark())