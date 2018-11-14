from Node import Node

class Compare(Node):
    def __init__(self, compareType, left, right):
        self.compareType = compareType
        self.left = left
        self.right = right
        self.children = [left, right]

    def __str__(self):
        return "%s %s %s" % (self.left, self.compareType, self.right)