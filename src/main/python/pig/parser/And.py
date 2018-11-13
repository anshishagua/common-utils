from Node import Node


class And(Node):
    def __init__(self, left, right):
        self.left = left
        self.right = right
        self.type = "AND"

