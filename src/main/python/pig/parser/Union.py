from Node import Node


class Union(Node):
    def __init__(self, relations):
        self.relations = relations
        self.children = relations
        self.type = "UNION"
        self.fields = None

    def is_relation_op(self):
        return True

    def __str__(self):
        return "UNION:%s = [%s]" % (self.target, ", ".join(map(str, self.relations)))

    def to_spark(self, exec_context):
        relations = []

        for relation in self.relations:
            relations.append(relation.to_spark(exec_context))

        self.fields = exec_context.relation_map[self.relations[0].name]

        return "union_spark_dfs([%s])" % (", ".join(relations))
