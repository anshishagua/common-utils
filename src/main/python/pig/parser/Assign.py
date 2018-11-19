from Node import Node

class Assign(Node):
    def __init__(self, target, expression):
        self.target = target
        self.expression = expression
        self.children = [expression]
        self.type = "ASSIGN"

    def __str__(self):
        return "ASSIGN:%s = %s" % (self.target, self.expression)

    def toSpark(self, raw=False):
        return "%s = %s" % (self.target.toSpark(), self.expression.toSpark())