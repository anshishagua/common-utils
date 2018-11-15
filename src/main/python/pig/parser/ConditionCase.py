from Node import Node
from Null import Null

class ConditionCase(Node):
    def __init__(self, conditions, values):
        self.conditions = conditions
        self.values = values

        if len(self.values) == len(self.conditions):
            self.values.append(Null())

        self.type = "CONDITION_CASE"

    def toSpark(self, raw=False):
        result = "F"

        length = len(self.conditions)

        for i in range(length):
            result += ".when(%s, %s)" % (self.conditions[i].toSpark(), self.values[i].toSpark())

        result += ".otherwise(%s)" % (self.values[length].toSpark())

        return result





