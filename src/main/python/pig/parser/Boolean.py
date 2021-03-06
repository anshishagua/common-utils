from Node import Node


class Boolean(Node):
    def __init__(self, value):
        self.value = value
        self.type = "BOOLEAN"
        self.children = []

    def __str__(self):
        return "TRUE" if self.value else "FALSE"

    def to_spark(self, exec_context):
        return "TRUE" if self.value else "FALSE"

