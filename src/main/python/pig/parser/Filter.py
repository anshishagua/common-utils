from Node import Node


class Filter(Node):
    def __init__(self, src, condition):
        self.src = src
        self.condition = condition
        self.children = [src, condition]
        self.type = "FILTER"
        self.relation = None

    def __str__(self):
        return "FILTER:%s by %s" % (self.src, self.condition)

    def to_spark(self, exec_context):
        self.fields = exec_context.relation_map[self.src.name]

        return "%s.filter(%s)" % (self.src.to_spark(exec_context), self.condition.to_spark(exec_context))