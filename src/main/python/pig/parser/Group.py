from Node import Node
import GlobalContext


class Group(Node):
    def __init__(self, relation, group_by_fields):
        self.relation = relation
        self.group_by_fields = group_by_fields
        self.type = "GROUP"
        self.fields = []
        self.children = [relation, group_by_fields]

    def to_spark(self, exec_context):
        group_by_fields = []

        for item in self.group_by_fields:
            group_by_fields.append(item.to_spark(exec_context))

        return "%s.groupby(%s)" % (self.relation.to_spark(exec_context), ", ".join(group_by_fields))
