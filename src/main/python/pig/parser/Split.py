from Node import Node
from And import And
from Not import Not
from Or import Or


class Split(Node):
    def __init__(self, src, conditions, targets):
        self.src = src
        self.conditions = conditions
        self.targets = targets
        self.type = "SPLIT"

    def to_spark(self, exec_context):
        targets = []
        conditions = []

        results = []

        for i in range(len(self.conditions)):
            condition = self.conditions[i]
            target = self.targets[i]

            not_condition = None

            for condition in conditions:
                if not_condition is None:
                    not_condition = condition
                else:
                    not_condition = And(not_condition, condition)

            if not_condition is not None:
                not_condition = Not(not_condition)

                condition = And(condition, not_condition)

            code = "%s = %s.filter(%s)" % (target.to_spark(exec_context), self.src.to_spark(exec_context), condition.to_spark(exec_context))

            results.append(code)

            targets.append(target)
            conditions.append(condition)

        if len(self.conditions) != len(self.targets):
            target = self.targets[-1]

            not_condition = None

            for condition in conditions:
                if not_condition is None:
                    not_condition = condition
                else:
                    not_condition = Or(not_condition, condition)

            not_condition = Not(condition)

            code = "%s = %s.filter(%s)" % (target.to_spark(exec_context), self.src.to_spark(exec_context), not_condition.to_spark(exec_context))

            results.append(code)

        return results
