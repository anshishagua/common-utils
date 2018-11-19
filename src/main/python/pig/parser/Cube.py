from Node import Node


class Cube(Node):
    def __init__(self, target, src, rollup_list):
        self.src = src
        self.target = target
        self.rollup_list = rollup_list

    def toSpark(self, raw=False):
        rollup_list = []

        for item in self.rollup_list:
            rollup_list.append(item.toSpark())

        return "%s = %s.cube([%s])" % (self.target.toSpark(), self.src.toSpark(), ", ".join(rollup_list))
