from Node import Node

class FieldRange(Node):
    def __init__(self, start=0, end=-1):
        self.start = start
        self.end = end
        self.type = "FIELD_RANGE"


    def __str__(self):
        return "COLUMN_RANGE:start:%d, end:%d" % (self.start, self.end)