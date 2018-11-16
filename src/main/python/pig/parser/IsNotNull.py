from Node import Node


class IsNotNull(Node):
    def __init__(self, expression):
        self.expression = expression
        self.children = [expression]
        self.type = "IS_NOT_NULL"

    def __str__(self):
        return "%s IS NOT NULL" % (self.expression)

    def toSpark(self, raw=False):
        return "%s.isNotNull()" % (self.expression.toSpark())