
class Node(object):
    def __init__(self, children=[]):
        self.children = children
        self.type = "NODE"
        self.parent = None
        for child in children:
            child.parent = self

    def get_child(self, i):
        return self.children[i]

    def __str__(self):
        return self.type

    def to_spark(self, raw=False):
        return "%s" % (self)

    def is_relation_op(self):
        return False

    def contains_aggregation(self):
        if self.type == "AGGR":
            return True

        if len(self.children) == 0:
            return False

        for child in self.children:
            result = child.contains_aggregation()

            if result:
                return True

        return False