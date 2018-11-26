from Node import Node


class Null(Node):
    def __init__(self):
        self.type = "NONE"
        self.children = []

    def __str__(self):
        return "NULL"

    def to_spark(self, exec_context):
        return "F.lit(None)"