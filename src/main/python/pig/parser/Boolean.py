from Node import Node


class Boolean(Node):
    def __init__(self, value):
        self.value = value
        self.type = "BOOLEAN"