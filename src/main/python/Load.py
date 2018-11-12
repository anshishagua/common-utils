
class Node(object):
    pass


class Load(Node):
    def __init__(self, relation, schema):
        self.relation = relation
        self.schema = schema

