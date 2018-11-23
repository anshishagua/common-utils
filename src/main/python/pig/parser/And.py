from Node import Node


class And(Node):
    def __init__(self, left, right):
        self.left = left
        self.right = right
        self.children = [left, right]
        self.type = "AND"

    def __str__(self):
        return "%s AND %s" % (self.left, self.right)

    def to_spark(self, exec_context):
        return "(%s) & (%s)" % (self.left.to_spark(), self.right.to_spark())

