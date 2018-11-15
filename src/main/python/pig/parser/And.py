from Node import Node


class And(Node):
    def __init__(self, left, right):
        self.left = left
        self.right = right
        self.type = "AND"

    def __str__(self):
        return "%s AND %s" % (self.left, self.right)

    def toSpark(self):
        return "(%s) & (%s)" % (self.left.toSpark(), self.right.toSpark())

