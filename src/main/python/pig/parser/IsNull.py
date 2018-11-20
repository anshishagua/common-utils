from Node import Node


class IsNull(Node):
    def __init__(self, expression):
        self.expression = expression
        self.children = [expression]
        self.type = "IS_NULL"

    def __str__(self):
        return "%s IS NULL" % (self.expression)

    def to_spark(self, raw=False):
        return "%s.isNull()" % (self.expression.to_spark())
