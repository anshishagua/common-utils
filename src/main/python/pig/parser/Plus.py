from Node import Node


class Plus(Node):
    def __init__(self, left, right):
        self.children = [left, right]
        self.type = "PLUS"