from Node import Node


class Register(Node):
    def __init__(self, file, alias):
        self.file = file
        self.alias = alias
        self.type = "REGISTER"
        self.children = []

    def __str__(self):
        return "[type:%s, file:%s, alias:%s]" % (self.type, self.file, self.alias)

    def to_spark(self, exec_context):
        if self.alias:
            exec_context.libs[self.alias] = self.file
