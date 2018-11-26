from Node import Node


class Compare(Node):
    def __init__(self, compare_type, left, right):
        self.compare_type = compare_type
        self.left = left
        self.right = right
        self.children = [left, right]
        self.type = "COMPARE"

    def __str__(self):
        return "%s %s %s" % (self.left, self.compare_type, self.right)

    def to_spark(self, exec_context):
        return "%s %s %s" % (self.left.to_spark(exec_context), self.compare_type, self.right.to_spark(exec_context))