from Node import Node


class JoinItem(object):
    def __init__(self, relation, fields):
        self.relation = relation
        self.fields = fields


class Join(Node):
    def __init__(self, target, joinType, joinItems):
        self.target = target
        self.joinType = joinType
        self.joinItems = joinItems
        self.type = "JOIN"

    def toSpark(self):
        if self.joinType == "INNER":
            relations = []

            for joinItem in self.joinItems:
                relations.append(joinItem.relation.toSpark())

            fields = []

            for field in self.joinItems[0].fields:
                fields.append("'" + field.fieldName + "'")

            return '%s = join_spark_dfs([%s], [%s])' % (self.target, ", ".join(relations), ", ".join(fields))
        else:
            joinType = self.joinType.lower()
            left = self.joinItems[0].relation
            right = self.joinItems[1].relation
            fields = []

            for field in self.joinItems[0].fields:
                fields.append("'" + field.fieldName + "'")

            return '%s = join_spark_df(%s, %s, [%s], "%s")' % (self.target, left, right, ", ".join(fields), joinType)



