from Node import Node

class ConditionCase(Node):
    def __init__(self, conditions, values):
        self.conditions = conditions
        self.values = values
        self.type = "CONDITION_CASE"


