from Node import Node


class ConditionExpr(Node):
    def __init__(self, condition, left, right):
        self.condition = condition
        self.left = left
        self.right = right
        self.children = [left, right]
        self.type = "COND_EXPR"

    def __str__(self):
        return "%s ? %s : %s" % (self.condition, self.left, self.right)

    def to_spark(self, exec_context):
        condition = self.condition.to_spark(exec_context)
        when_expr = self.left.to_spark(exec_context)
        otherwise_expr = self.right.to_spark(exec_context)
        return "F.when(%s, %s).otherwise(%s)" % (condition, when_expr, otherwise_expr)
