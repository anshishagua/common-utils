from Node import Node


class Field(Node):
    def __init__(self, fieldName, relation=None):
        self.relation = relation
        self.fieldName = fieldName
        self.type = "FIELD"
