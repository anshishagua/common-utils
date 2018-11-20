from Node import Node

class Union(Node):
    def __init__(self, target, relations):
        self.target = target
        self.relations = relations
        self.children = relations
        self.type = "UNION"

    def is_relation_op(self):
        return True

    def __str__(self):
        return "UNION:%s = [%s]" % (self.target, ", ".join(map(str, self.relations)))

    def to_spark(self):
        relations = []

        for relation in self.relations:
            relations.append(relation.to_spark())

        return "%s = union_spark_dfs([%s])" % (self.target.to_spark(), ", ".join(relations))
