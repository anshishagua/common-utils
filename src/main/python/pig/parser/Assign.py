from Node import Node


class Assign(Node):
    def __init__(self, target, expr):
        self.target = target
        self.expr = expr
        self.children = [target, expr]
        self.type = "ASSIGN"

    def __str__(self):
        return "ASSIGN:%s = %s" % (self.target, self.expr)

    def to_spark(self, exec_context):
        target = self.target.to_spark(exec_context) if isinstance(self.target, Node) else self.target
        expr = self.expr.to_spark(exec_context)

        exec_context.relation_map[target] = self.expr.fields

        return "%s = %s" % (target, expr)
