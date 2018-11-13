from Node import Node


class In(Node):
    def __init__(self, values):
        self.children = values
        self.type = "IN"