from Node import Node
from GlobalContext import GlobalContext

class GroupItem(Node):
    def __init__(self, relation, groupByFields=None):
        self.relation = relation
        self.groupByFields = groupByFields
        self.groupAll = True if groupByFields is None else False
        self.type = "GROUP_ITEM"

    def toSpark(self, raw=False):
        fields = []

        for field in self.groupByFields:
            fields.append(field.toSpark())

        return "%s = %s.groupBy([%s])" % (self.relation.toSpark(), self.relation.toSpark(), ", ".join(fields))


class Group(Node):
    def __init__(self, target, src, fields):
        self.target = target
        self.src = src
        self.fields = fields
        self.type = "GROUP"

    def toSpark(self, raw=False):
        items = []

        for item in self.fields:
            items.append(item.toSpark())

        GlobalContext.add(self.src, self)

        return "%s = %s.groupBy(%s)" % (self.src.toSpark(), self.target.toSpark(), ", ".join(items))