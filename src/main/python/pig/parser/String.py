from Node import Node


class String(Node):
    def __init__(self, value):
        self.value = value
        self.children = []
        self.type = "STRING"