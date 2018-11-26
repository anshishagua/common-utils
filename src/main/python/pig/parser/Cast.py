from Node import Node

from pig.constants import PIG_SPARK_TYPE_MAPPING

class Cast(Node):
    def __init__(self, data_type, expression):
        self.data_type = data_type
        self.expression = expression
        self.children = [expression]
        self.type = "CAST"

    def __str__(self):
        return "CAST:data_type:%s:(%s)" % (self.data_type, self.expression)

    def to_spark(self, exec_context):
        spark_type = PIG_SPARK_TYPE_MAPPING[self.data_type]

        expression = self.expression.to_spark(exec_context)

        if self.expression.type == 'STRING' or self.expression.type == 'NUMBER':
            expression = "F.lit(%s)" % str(expression)

        return '%s.cast("%s")' % (expression, spark_type)
