from Node import Node

class Or(Node):
    def __init__(self, left, right):
        self.left = left
        self.right = right
        self.type = "OR"
    
