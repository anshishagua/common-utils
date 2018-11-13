from Node import Node


class Function(Node):
    def __init__(self, name, *args):
        self.name = name
        self.children = args
        self.type = "FUNC"