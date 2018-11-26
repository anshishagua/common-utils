from Node import Node


class Cube(Node):
    def __init__(self, target, src, rollup_list):
        self.src = src
        self.target = target
        self.rollup_list = rollup_list

    def to_spark(self, exec_context):
        rollup_list = []

        for item in self.rollup_list:
            rollup_list.append(item.to_spark(exec_context))

        return "%s = %s.cube([%s])" % (self.target.to_spark(exec_context), self.src.to_spark(exec_context), ", ".join(rollup_list))
