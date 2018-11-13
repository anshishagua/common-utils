from Node import Node


class Relation(Node):
    def __init__(self, name):
        self.name = name
        self.type = "RELATION"