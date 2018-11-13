from Node import Node


class Distinct(Node):
    def __init__(self, src, target):
        self.target = target
        self.src = src
        self.children = [src]
        self.type = "DISTINCT"

    def __str__(self):
        return "[src:%s, target:%s]" % (self.src, self.target)