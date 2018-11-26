from Node import Node
from Function import Function


class Flatten(Node):
    def __init__(self, expression, as_fields=None):
        self.expression = expression
        self.as_fields = as_fields
        self.children = []
        self.type = "FLATTEN"

    def transform(self):
        if isinstance(self.expression, Function):
            return "func"
        else:
            generate_items = []

            for as_field in self.as_fields:
                generate_items.append(as_field)

            return generate_items

    def to_spark(self, exec_context):
        if self.expression.type == 'FIELD':
            if self.expression.name == 'group':
                pass
            else:
                pass

            print self.expression
        else:
            pass

        return "FLATTEN"