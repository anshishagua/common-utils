from Node import Node


class IsNull(Node):
    def __init__(self, expression):
        self.expression = expression
        self.children = [expression]
        self.type = "IS_NULL"
