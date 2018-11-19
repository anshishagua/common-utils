from Node import Node

class Not(Node):
    def __init__(self, condition):
        self.condition = condition
        self.children = [condition]

    def __str__(self):
        return "NOT %s" % (self.condition)

    def toSpark(self):
        return "not (%s)" % (self.condition.toSpark())