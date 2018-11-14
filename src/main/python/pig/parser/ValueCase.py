from Node import Node

class ValuseCase(Node):
    def __init__(self, expr, expressions, values):
        self.expr = expr
        self.expressions = expressions
        self.values = values
        self.type = "VALUE_CASE"