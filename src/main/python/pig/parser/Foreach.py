from Node import Node
from SimpleRelation import SimpleRelation
from Flatten import Flatten
from Field import Field
from Aggregation import Aggregation
from Group import GroupItem


class Foreach(Node):
    def __init__(self, src, nested_commands, genItems):
        self.src = src
        self.nested_commands = nested_commands
        self.genItems = genItems

    def __str__(self):
        return "FOREACH:%s = for %s, generate:%s" % (self.target, self.src, ", ".join(map(str, self.genItems)))

    def to_spark(self):
        result = ""

        group_bys = []

        source_table = None

        if self.src.type == "COMPLEX_RELATION":
            expr = self.src.expr[0]

            if isinstance(expr, GroupItem):
                group_bys = expr.groupByFields
                source_table = expr.relation.to_spark()
        else:
            source_table = self.src.to_spark()

        select_fields = []

        if self.nested_commands:
            for command in self.nested_commands:
                result += command.to_spark() + "\n"

                #assign
                if command.children[0].is_relation_op():
                    self.src = command.target
                else:
                    select_fields.append(command)

        for select_field in select_fields:
            result += "%s = %s.withColumn('%s', %s)\n" % (self.src.to_spark(),
                                                      self.src.to_spark(),
                                                      select_field.target.name,
                                                      select_field.children[0].to_spark())

        has_aggregation = False

        for item in self.genItems:
            if item.contains_aggregation():
                has_aggregation = True
                break

        print has_aggregation

        if has_aggregation:
            group_by_clause = []

            for group_expr in group_bys:
                group_by_clause.append(group_expr.to_spark())

            group_by_clause = ", ".join(group_by_clause)
            group_by_clause = "[" + group_by_clause + "]"

            select_fields = []

            for item in self.genItems:
                if item.contains_aggregation():
                    select_fields.append(item.to_spark())

            result = "%s = %s.groupBy(%s).aggr(%s)" % (self.target.to_spark(),
                                                        source_table,
                                                        group_by_clause,
                                                        ", ".join(select_fields))

            return result

        select_fields = []

        #simple generate
        if not group_bys:
            for item in self.genItems:
                select_fields.append(item.to_spark())

            result = "%s = %s.select(%s)" % (self.target.to_spark(), self.src.to_spark(), ", ".join(select_fields))

            return result


        for item in self.genItems:
            if isinstance(item, Flatten):
                expr = item.expression
                as_fields = item.as_fields

                for field in as_fields:
                    select_fields.append(field.to_spark())

                if isinstance(item, Field):
                    if item.name == "group":
                        pass
                    elif item.name == "cube":
                        pass
                    else:
                        pass
                else:
                    print "#flatten call function"

                pass
            else:
                select_fields.append(item.to_spark())

        result += "%s.select(%s)" % (self.src.to_spark(), ", ".join(select_fields))

        return result
