from Node import Node

class Genereate(Node):
    def __init__(self, src, fields):
        self.src = src
        self.fields = fields
        self.type = "GENERATE"

    def to_spark(self, raw=False):
        items = []

        for field in self.fields:
            items.append(field.to_spark())

        return "%s = %s" % (self.src.to_spark(), ", ".join(items))