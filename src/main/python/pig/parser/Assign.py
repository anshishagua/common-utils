from Node import Node


class Assign(Node):
    def __init__(self, target, expr):
        self.target = target
        self.expr = expr
        self.children = [expr]
        self.type = "ASSIGN"

    def __str__(self):
        return "ASSIGN:%s = %s" % (self.target, self.expr)

    def to_spark(self, raw=False):
        target = self.target.to_spark() if isinstance(self.target, Node) else self.target
        expr = self.expr.to_spark()

        return "%s = %s" % (target, expr)