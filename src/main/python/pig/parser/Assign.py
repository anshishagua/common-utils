from Node import Node

class Assign(Node):
    def __init__(self, src, target):
        self.src = src
        self.target = target
        self.type = "ASSIGN"

    def __str__(self):
        return "ASSIGN:%s = %s" % (self.src, self.target)