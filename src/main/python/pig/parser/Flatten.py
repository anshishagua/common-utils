from Node import Node


class Flatten(Node):
    def __init__(self, expression, as_fields=None):
        self.expression = expression
        self.as_fields = as_fields
        self.children = []
        self.type = "FLATTEN"

    def toSpark(self, raw=False):
        if self.expression.type == 'FIELD':
            if self.expression.fieldName == 'group':
                pass
            else:
                pass

            print self.expression
        else:
            pass

        return "FLATTEN"