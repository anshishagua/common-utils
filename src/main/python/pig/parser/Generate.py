from Node import Node

class Genereate(Node):
    def __init__(self, src, fields):
        self.src = src
        self.fields = fields
        self.type = "GENERATE"

    def to_spark(self, exec_context):
        items = []

        for field in self.fields:
            items.append(field.to_spark(exec_context))

        return "%s = %s" % (self.src.to_spark(exec_context), ", ".join(items))