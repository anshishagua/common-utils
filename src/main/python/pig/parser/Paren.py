from Node import Node

class Paren(Node):
    def __init__(self, child):
        self.children = [child]
        self.type = "PAREN"