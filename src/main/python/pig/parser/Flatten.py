from Node import Node

class Flatten(Node):
    def __init__(self, expression):
        self.expression = expression
        self.type = "FLATTEN"

    def toSpark(self, raw=False):
        return "FLATTEN"