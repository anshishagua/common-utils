from Node import Node


class Distinct(Node):
    def __init__(self, src, target):
        self.target = target
        self.src = src
        self.children = [src]
        self.type = "DISTINCT"

    def __str__(self):
        return "DISTINCT[src:%s, target:%s]" % (self.src, self.target)

    def to_spark(self, exec_context):
        return "%s = %s.distinct()" % (self.target, self.src.to_spark(exec_context))