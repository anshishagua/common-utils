from Node import Node


class Multiply(Node):
    def __init__(self, left, right):
        self.children = [left, right]
        self.type = "MUL"