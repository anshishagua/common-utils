from Node import Node


class Mod(Node):
    def __init__(self, left, right):
        self.children = [left, right]
        self.type = "MOD"