from Node import Node


class Number(Node):
    def __init__(self, value):
        self.value = value
        self.children = []
        self.type = "NUMBER"

    def __str__(self):
        return "NUMBER: %s" % str(self.value)

    def toSpark(self):
        return "%s" % str(self.value)

