from Node import Node
from Field import Field


class FieldRange(Node):
    def __init__(self, start=0, end=-1):
        self.start = start
        self.end = end
        self.type = "FIELD_RANGE"
        self.children = []

    def __str__(self):
        return "COLUMN_RANGE:start:%d, end:%d" % (self.start, self.end)

    def to_spark(self, exec_context):
        relation_name = exec_context.params["relation_name"]

        fields = exec_context.relation_map[relation_name]

        if self.end == -1:
            self.end = len(fields)

        result = []

        for field in fields[self.start:self.end]:
            result.append(Field(field.name))

        return result

