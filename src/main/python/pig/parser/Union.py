from Node import Node

class Union(Node):
    def __init__(self, target, relations):
        self.target = target
        self.children = relations
        self.type = "UNION"

    def __str__(self):
        return ",".join(self.children)
