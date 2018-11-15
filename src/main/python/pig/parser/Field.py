from Node import Node


class Field(Node):
    def __init__(self, fieldName, relation=None):
        self.relation = relation
        self.fieldName = fieldName
        self.type = "FIELD"

    def __str__(self):
        return '"FIELD": {"relation": "%s", "fieldName": "%s"}' % (self.relation, self.fieldName)

    def toSpark(self, raw=False):
        if self.relation is None:
            if raw:
                return self.fieldName
            else:
                return "F.col('%s')" %(self.fieldName)
