from Node import Node
from Function import Function
from Alias import Alias


class Flatten(Node):
    def __init__(self, expression, as_fields=None):
        self.expression = expression
        self.as_fields = as_fields
        self.children = []
        self.type = "FLATTEN"

    def transform(self):
        generate_items = []

        if isinstance(self.expression, Function):
            for as_field in self.as_fields:
                generate_items.append(Alias(as_field, self.expression))
        else:
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