from Node import Node
from Null import Null

class ConditionCase(Node):
    def __init__(self, conditions, values):
        self.conditions = conditions
        self.values = values

        self.children = conditions + values

        if len(self.values) == len(self.conditions):
            self.values.append(Null())

        self.type = "CONDITION_CASE"

    def to_spark(self, exec_context):
        result = "F"

        length = len(self.conditions)

        for i in range(length):
            result += ".when(%s, %s)" % (self.conditions[i].to_spark(exec_context), self.values[i].to_spark(exec_context))

        result += ".otherwise(%s)" % (self.values[length].to_spark(exec_context))

        return result





