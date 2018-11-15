from Node import Node


class ComplexRelation(Node):
    def __init__(self, expr):
        self.expr = expr
        self.type = "COMPLEX_RELATION"