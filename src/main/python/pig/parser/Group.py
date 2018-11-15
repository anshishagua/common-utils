from Node import Node


class GroupItem(object):
    def __init__(self, relation, groupByFields=None):
        self.relation = relation
        self.groupByFields = groupByFields
        self.groupAll = True if groupByFields is None else False


class Group(Node):
    def __init__(self, target, groupItems):
        self.target = target
        self.groupItems = groupItems
        self.type = "GROUP"