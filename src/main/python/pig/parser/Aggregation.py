from Node import Node


class Aggregation(Node):
    TYPES = ["SUM", "MAX", "MIN", "AVG", "COUNT"]

    def __init__(self, aggr_type, expr):
        self.aggr_type = aggr_type
        self.expr = expr
        self.type = "AGGR"

    def toSpark(self, raw=False):
        return "F.%s(%s)" % (self.aggr_type.lower(), self.expr.toSpark())