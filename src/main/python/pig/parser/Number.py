from Node import Node


class Number(Node):
    def __init__(self, value):
        self.value = value
        self.children = []
        self.type = "NUMBER"