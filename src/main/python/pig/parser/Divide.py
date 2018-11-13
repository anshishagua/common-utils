from Node import Node


class Divide(Node):
    def __init__(self, left, right):
        self.children = [left, right]
        self.type = "DIV"