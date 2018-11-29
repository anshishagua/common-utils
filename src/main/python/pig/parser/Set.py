from Node import Node


class Set(Node):
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.type = "SET"
        self.children = []

    def __str__(self):
        return "[type:%s, key:%s, value:%s]" % (self.type, self.key, self.value)

    def to_spark(self, exec_context):
        pass