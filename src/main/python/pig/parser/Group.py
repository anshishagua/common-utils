from Node import Node
from GlobalContext import GlobalContext

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
    def __init__(self, target, src, fields):
        self.target = target
        self.src = src
        self.fields = fields
        self.type = "GROUP"

    def to_spark(self, raw=False):
        items = []

        for item in self.fields:
            items.append(item.to_spark())

        GlobalContext.add(self.src, self)

        return "%s = %s.groupBy(%s)" % (self.src.to_spark(), self.target.to_spark(), ", ".join(items))