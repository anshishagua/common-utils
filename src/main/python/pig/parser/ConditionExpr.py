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