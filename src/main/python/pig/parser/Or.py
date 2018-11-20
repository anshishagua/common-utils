from Node import Node

class Or(Node):
    def __init__(self, left, right):
        self.left = left
        self.right = right
        self.type = "OR"

    def __str__(self):
        return "%s OR %s" % (self.left, self.right)

    def to_spark(self):
        return "((%s) | (%s))" % (self.left.to_spark(), self.right.to_spark())
