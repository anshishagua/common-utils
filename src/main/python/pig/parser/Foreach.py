from Node import Node
from Relation import Relation
from Flatten import Flatten
from Field import Field
from Aggregation import Aggregation
from Group import GroupItem

class Foreach(Node):
    def __init__(self, target, src, nested_commands, genItems):
        self.target = target
        self.src = src
        self.nested_commands = nested_commands
        self.genItems = genItems

    def __str__(self):
        return "FOREACH:%s = for %s, genereate:%s" % (self.target, self.src, ", ".join(map(str, self.genItems)))

    def toSpark(self):
        result = ""

        group_bys = []

        source_table = None

        if self.src.type == "COMPLEX_RELATION":
            expr = self.src.expr[0]

            if isinstance(expr, GroupItem):
                group_bys = expr.groupByFields
                source_table = expr.relation.toSpark()
        else:
            source_table = self.src.toSpark()

        if self.nested_commands is not None:
            for command in self.nested_commands:
                result += command.toSpark()

        has_aggregation = False

        for item in self.genItems:
            if item.contains_aggregation():
                has_aggregation = True
                break

        print has_aggregation

        if has_aggregation:
            group_by_clause = []

            for group_expr in group_bys:
                group_by_clause.append(group_expr.toSpark())

            group_by_clause = ", ".join(group_by_clause)
            group_by_clause = "[" + group_by_clause + "]"

            select_fields = []

            for item in self.genItems:
                if item.contains_aggregation():
                    select_fields.append(item.toSpark())

            result = "%s = %s.groupBy(%s).aggr(%s)" % (self.target.toSpark(),
                                                        source_table,
                                                        group_by_clause,
                                                        ", ".join(select_fields))

            return result

        select_fields = []

        #simple generate
        if not group_bys:
            for item in self.genItems:
                select_fields.append(item.toSpark())

            result = "%s = %s.select(%s)" % (self.target.toSpark(), self.src.toSpark(), ", ".join(select_fields))

            return result


        for item in self.genItems:
            if isinstance(item, Flatten):
                expr = item.expression
                as_fields = item.as_fields

                for field in as_fields:
                    select_fields.append(field.toSpark())

                if isinstance(item, Field):
                    if item.fieldName == "group":
                        pass
                    elif item.fieldName == "cube":
                        pass
                    else:
                        pass
                else:
                    print "#flatten call function"

                pass
            else:
                select_fields.append(item.toSpark())

        result += "%s = %s.select(%s)" % (self.target.toSpark(), self.src.toSpark(), ", ".join(select_fields))

        return result
