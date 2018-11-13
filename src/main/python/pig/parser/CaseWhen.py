from Node import Node


class CaseWhen(Node):
    def __init__(self, whenConditions, thenValues, elseValue):
        self.caseExpression = None
        self.whenConditions = whenConditions
        self.thenValues = thenValues
        self.elseValue = elseValue
        self.type = "CASE_WHEN"

    def __init__(self, caseExpression, whenConditions, thenValues, elseValue):
        self.caseExpression = caseExpression
        self.whenConditions = whenConditions
        self.thenValues = thenValues
        self.elseValue = elseValue
        self.type = "CASE_WHEN"