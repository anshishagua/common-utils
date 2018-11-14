from Node import Node


class Mod(Node):
    def __init__(self, left, right):
        self.left = left
        self.right = right
        self.children = [left, right]
        self.type = "MOD"

    def __str__(self):
        return "%s % %s" % (self.left, self.right)