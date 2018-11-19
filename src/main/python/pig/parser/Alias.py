from Node import Node

class Alias(Node):
    def __init__(self, name, expr):
        self.name = name
        self.expr = expr
        self.children = [expr]
        self.type = "ALIAS"

    def __str__(self):
        return "ALIAS:name:%s,expr:%s" % (self.name, self.expr)

    def toSpark(self):
        filed = self.expr.toSpark()

        if self.expr.type == 'STRING':
            filed = "F.lit(%s)" % (filed)

        alias = self.name.toSpark()

        if self.name.type == 'FIELD':
            alias = "'%s'" %(self.name.fieldName)

        return "%s.alias(%s)" % (filed, alias)