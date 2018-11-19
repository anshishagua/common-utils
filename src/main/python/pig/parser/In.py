from Node import Node


class In(Node):
    def __init__(self, expression, values):
        self.expression = expression
        self.children = values
        self.type = "IN"

    def __str__(self):
        return "%s IN (%s)" % (self.expression, " ".join(map(str, self.children)))

    def toSpark(self, raw=False):
        in_list = []

        for child in self.children:
            in_list.append(child.toSpark())

        return "%s IN (%s)" % (self.expression.toSpark(), " ".join(in_list))
