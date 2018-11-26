from Node import Node


class Paren(Node):
    def __init__(self, child):
        self.child = child
        self.children = [child]
        self.type = "PAREN"

    def __str__(self):
        return '"paren": "%s"' % (self.child)

    def is_relation_op(self):
        return self.child.is_relation_op()

    def to_spark(self, exec_context):
        return "(%s)" % (self.child.to_spark(exec_context))