from Node import Node


class String(Node):
    def __init__(self, value):
        self.value = value[1:len(value) - 1]
        self.children = []
        self.type = "STRING"

    def __str__(self):
        return "STRING: '%s'" % (self.value)

    def to_spark(self):
        return "'%s'" % (self.value)