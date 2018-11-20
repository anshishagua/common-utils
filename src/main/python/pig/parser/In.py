from Node import Node


class In(Node):
    def __init__(self, expression, values):
        self.expression = expression
        self.children = values
        self.type = "IN"

    def __str__(self):
        return "%s IN (%s)" % (self.expression, " ".join(map(str, self.children)))

    def to_spark(self, raw=False):
        in_list = []

        for child in self.children:
            in_list.append(child.to_spark())

        return "%s.isin([%s])" % (self.expression.to_spark(), ", ".join(in_list))
