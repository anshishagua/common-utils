from Node import Node

from pig.constants import PIG_SPARK_TYPE_MAPPING

class Cast(Node):
    def __init__(self, toType, expression):
        self.toType = toType
        self.expression = expression
        self.children = [expression]
        self.type = "CAST"

    def __str__(self):
        return "CAST:toType:%s:(%s)" % (self.toType, self.expression)

    def to_spark(self):
        sparkType = PIG_SPARK_TYPE_MAPPING[self.toType]

        expression = self.expression.to_spark()

        if self.expression.type == 'STRING' or self.expression.type == 'NUMBER':
            expression = "F.lit(%s)" % str(expression)

        return '%s.cast("%s")' % (expression, sparkType)
