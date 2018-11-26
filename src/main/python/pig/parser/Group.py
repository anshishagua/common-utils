from Node import Node
import GlobalContext

class GroupItem(Node):
    def __init__(self, relation, groupByFields=None):
        self.relation = relation
        self.groupByFields = groupByFields
        self.groupAll = True if groupByFields is None else False
        self.type = "GROUP_ITEM"

    def to_spark(self, raw=False):
        fields = []

        for field in self.groupByFields:
            fields.append(field.to_spark())

        return "%s = %s.groupBy([%s])" % (self.relation.to_spark(), self.relation.to_spark(), ", ".join(fields))


class Group(Node):
    def __init__(self, relation, group_by_fields):
        self.relation = relation
        self.group_by_fields = group_by_fields
        self.type = "GROUP"
        self.fields = []

    def to_spark(self, exec_context):
        group_by_fields = []

        for item in self.group_by_fields:
            group_by_fields.append(item.to_spark(exec_context))

        return "%s.groupby(%s)" % (self.relation.to_spark(exec_context), ", ".join(group_by_fields))
