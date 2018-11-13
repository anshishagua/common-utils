from Node import Node

class Compare(Node):
    def __init__(self, compareType, left, right):
        self.compareType = compareType
        self.left = left
        self.right = right
        self.children = [left, right]