from Node import Node

class Not(Node):
    def __init__(self, condition):
        self.condition = condition
        self.children = [condition]