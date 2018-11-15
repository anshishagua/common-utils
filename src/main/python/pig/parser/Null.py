from Node import Node


class Null(Node):
    def __init__(self):
        self.type = "NONE"

    def __str__(self):
        return "NULL"

    def toSpark(self, raw=False):
        return "NULL"