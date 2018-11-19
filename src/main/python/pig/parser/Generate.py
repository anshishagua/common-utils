from Node import Node

class Genereate(Node):
    def __init__(self, src, fields):
        self.src = src
        self.fields = fields
        self.type = "GENERATE"

    def toSpark(self, raw=False):
        items = []

        for field in self.fields:
            items.append(field.toSpark())

        return "%s = %s" % (self.src.toSpark(), ", ".join(items))