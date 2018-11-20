from Node import Node


class Filter(Node):
    def __init__(self, src, condition):
        self.src = src
        self.condition = condition
        self.children = [condition]
        self.type = "FILTER"

    def __str__(self):
        return "FILTER:%s=%s by %s" % (self.src, self.target, self.condition)

    def to_spark(self):
        return "%s.filter(%s)" % (self.src, self.condition.to_spark())