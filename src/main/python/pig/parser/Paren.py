from Node import Node


class Paren(Node):
    def __init__(self, child):
        self.child = child
        self.children = [child]
        self.type = "PAREN"

    def __str__(self):
        return '"paren": "%s"' % (self.child)

    def to_spark(self, raw=False):
        return "(%s)" % (self.child.to_spark())