from Node import Node


class Filter(Node):
    def __init__(self, fromRelation, toRelation, condition):
        self.fromRelation = fromRelation
        self.toRelation = toRelation
        self.condition = condition
        self.children = [condition]
        self.type = "FILTER"
