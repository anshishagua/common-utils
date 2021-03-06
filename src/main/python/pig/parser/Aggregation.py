from Node import Node


class Aggregation(Node):
    TYPES = ["SUM", "MAX", "MIN", "AVG", "COUNT"]

    def __init__(self, aggr_type, expr):
        Node.__init__(self, [expr])
        self.aggr_type = aggr_type
        self.expr = expr
        self.type = "AGGR"

    def to_spark(self, exec_context):
        return "F.%s(%s)" % (self.aggr_type.lower(), self.expr.to_spark(exec_context))