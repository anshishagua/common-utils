from Node import Node


class In(Node):
    def __init__(self, expression, values):
        self.expression = expression
        self.children = values
        self.type = "IN"

    def __str__(self):
        return "%s IN (%s)" % (self.expression, " ".join(map(str, self.children)))