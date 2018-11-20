from Node import Node


class Relation(Node):
    def __init__(self, expr):
        self.expr = expr
        self.type = "RELATION"

    def is_simple(self):
        return not isinstance(self.expr, Node)

    def to_spark(self):
        if self.is_simple():
            return self.expr

        return self.expr.to_spark()
