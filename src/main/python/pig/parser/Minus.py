from Node import Node


class Minus(Node):
    def __init__(self, left, right):
        self.children = [left, right]
        self.type = "MINUS"
