from Node import Node

class Cast(Node):
    def __init__(self, toType, expression):
        self.toType = toType
        self.expression = expression
        self.children = [expression]
        self.type = "CAST"
