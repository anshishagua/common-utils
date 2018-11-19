from Node import Node


class Cube(Node):
    def __init__(self, src, target, rollup_list):
        self.src = src
        self.target = target
        self.rollup_list = rollup_list

    def toSpark(self, raw=False):
        pass
