from Node import Node
from Field import Field
from SimpleRelation import SimpleRelation
from ComplexRelation import ComplexRelation


class JoinItem(Node):
    def __init__(self, relation, fields):
        self.relation = relation
        self.fields = fields
        self.type = "JOIN_ITEM"
        self.children = [relation, fields]


class Join(Node):
    def __init__(self, join_type, join_items):
        self.join_type = join_type
        self.join_items = join_items
        self.type = "JOIN"
        self.fields = []
        self.children = [join_items]

    def build_join_condition(self, left_join_item, right_join_item):
        pass

    def to_spark(self, exec_context):
        result_fields = set([])

        if self.join_type == "INNER":
            generated_code = self.join_items[0].relation.to_spark(exec_context)

            for i in range(1, len(self.join_items)):
                join_conditions = []

                left_join_item = self.join_items[i]
                right_join_item = self.join_items[i - 1]
                left_relation_name = left_join_item.relation.to_spark(exec_context)
                right_relation_name = left_join_item.relation.to_spark(exec_context)

                for j in range(len(left_join_item.fields)):
                    left_join_field = left_join_item.fields[j]
                    right_join_field = right_join_item.fields[j]

                    join_condition = "(%s.%s == %s.%s)" % (left_relation_name,
                                                       left_join_field.name,
                                                       right_relation_name,
                                                       right_join_field.name)
                    join_conditions.append(join_condition)

                    self.fields.append(Field(left_join_field.name, left_relation_name))
                    self.fields.append(Field(right_join_field.name, right_relation_name))

                condition = " & ".join(join_conditions)

                generated_code += '.join(%s, %s)' % (left_relation_name, condition)

            return generated_code
            """
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
            """


        else:
            join_type = self.join_type.lower()

            join_conditions = []

            left_join_item = self.join_items[0]
            right_join_item = self.join_items[1]
            left_relation_name = left_join_item.relation.to_spark(exec_context)
            right_relation_name = left_join_item.relation.to_spark(exec_context)

            for i in range(len(left_join_item.fields)):
                left_join_field = left_join_item.fields[i]
                right_join_field = right_join_item.fields[i]

                join_condition = "(%s.%s == %s.%s)" % (left_relation_name,
                                                       left_join_field.name,
                                                       right_relation_name,
                                                       right_join_field.name)
                join_conditions.append(join_condition)

                self.fields.append(Field(left_join_field.name, left_relation_name))
                self.fields.append(Field(right_join_field.name, right_relation_name))

            condition = " & ".join(join_conditions)

            return '%s.join(%s, %s, "%s")' % (left_relation_name, right_relation_name, condition, join_type)