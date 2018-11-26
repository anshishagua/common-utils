from Node import Node
from Field import Field

class JoinItem(object):
    def __init__(self, relation, fields):
        self.relation = relation
        self.fields = fields


class Join(Node):
    def __init__(self, join_type, join_items):
        self.join_type = join_type
        self.join_items = join_items
        self.type = "JOIN"
        self.fields = []

    def to_spark(self, exec_context):
        result_fields = set([])

        if self.join_type == "INNER":
            relations = []

            for join_item in self.join_items:
                relations.append(join_item.relation.to_spark(exec_context))

                relation_fields = set([field.name for field in exec_context.relation_map[join_item.relation.name]])

                result_fields = result_fields | relation_fields

            for result_field in result_fields:
                self.fields.append(Field(result_field))

            fields = []
            for field in self.join_items[0].fields:
                fields.append("'" + field.name + "'")

            return 'join_spark_dfs([%s], [%s])' % (", ".join(relations), ", ".join(fields))
        else:
            join_type = self.join_type.lower()
            left = self.join_items[0].relation
            right = self.join_items[1].relation
            fields = []

            for field in self.join_items[0].fields:
                fields.append("'" + field.name + "'")

            for join_relation in [left, right]:
                relation_fields = set([field.name for field in exec_context.relation_map[join_relation.relation.name]])

                result_fields = result_fields | relation_fields

            for result_field in result_fields:
                self.fields.append(Field(result_field))

            return 'join_spark_df(%s, %s, [%s], "%s")' % (left, right, ", ".join(fields), join_type)



