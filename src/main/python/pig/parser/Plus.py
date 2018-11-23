from Node import Node


class Plus(Node):
    def __init__(self, left, right):
        self.left = left
        self.right = right
        self.children = [left, right]
        left.parent = self
        right.parent = self
        self.type = "PLUS"

    def __str__(self):
        return "(%s) + (%s)" % (self.left, self.right)

    def to_spark(self, exec_context):
        return "%s + %s" % (self.left.to_spark(exec_context), self.right.to_spark(exec_context))