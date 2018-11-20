from Node import Node

class ValueCase(Node):
    def __init__(self, expr, expressions, values):
        self.expr = expr
        self.expressions = expressions
        self.values = values
        self.type = "VALUE_CASE"
        self.children = expressions

    def to_spark(self, raw=False):
        result = "F"

        for i in range(len(self.expressions)):
            result += ".when(%s == %s, %s)" % (self.expr.to_spark(), self.expressions[i].to_spark(), self.values[i].to_spark())

        if len(self.expressions) != len(self.values):
            result += ".otherwise(%s)" % (self.values[-1].to_spark())

        return result
