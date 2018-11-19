from Node import Node


class Filter(Node):
    def __init__(self, src, target, condition):
        self.src = src
        self.target = target
        self.condition = condition
        self.children = [condition]
        self.type = "FILTER"

    def __str__(self):
        return "FILTER:%s=%s by %s" % (self.src, self.target, self.condition)

    def toSpark(self):
        return "%s = %s.filter(%s)" % (self.target, self.src, self.condition.toSpark())