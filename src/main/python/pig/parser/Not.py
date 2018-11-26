from Node import Node

class Not(Node):
    def __init__(self, condition):
        self.condition = condition
        self.children = [condition]

    def __str__(self):
        return "NOT %s" % (self.condition)

    def to_spark(self, exec_context):
        return "not (%s)" % (self.condition.to_spark(exec_context))