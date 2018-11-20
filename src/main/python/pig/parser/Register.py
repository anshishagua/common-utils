from Node import Node


class Register(Node):
    def __init__(self, file, alias):
        self.file = file
        self.alias = alias
        self.type = "REGISTER"

    def __str__(self):
        return "[type:%s, file:%s, alias:%s]" % (self.type, self.file, self.alias)

    def to_spark(self, raw=False):
        return ""