from Node import Node

class ConditionExpr(Node):

    AAA = 111

    def __init__(self, condition, left, right):
        self.condition = condition
        self.left = left
        self.right = right
        self.children = [left, right]
        self.type = "COND_EXPR"

    def __str__(self):
        return "%s ? %s : %s" % (self.condition, self.left, self.right)

    def toSpark(self, raw=False):
        return "F.when(%s, %s).otherwise(%s)" % (self.condition.toSpark(), self.left.toSpark(), self.right.toSpark())
