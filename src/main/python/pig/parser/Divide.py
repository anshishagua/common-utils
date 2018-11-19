from Node import Node


class Divide(Node):
    def __init__(self, left, right):
        self.left = left
        self.right = right
        self.children = [left, right]
        self.type = "DIV"

    def __str__(self):
        return "%s / %s" % (self.left, self.right)

    def toSpark(self, raw=False):
        return "%s / %s" % (self.left.toSpark(), self.right.toSpark())
