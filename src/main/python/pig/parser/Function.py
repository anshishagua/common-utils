import logging

from Node import Node
from Number import Number

PIG_SPARK_FUNCTION_MAPPING = {
    "ToString": "F.date_format",
    "ToUnixTime": "F.to_timestamp",
    "TOP": "df_top_elements",
    "ToMilliSeconds": "F.to_timestamp",
    "SubtractDuration": "F.date_add",
    "AddDuration": "F.date_add",
    "SUBSTRING": "F.substring",
    "STARTSWITH": "F.instr",
    "REPLACE": "F.regexp_replace",
    "LOWER": "F.lower",
    "UPPER": "F.upper",
    "TOP": "df_top_elements"
}


class Function(Node):
    def __init__(self, name, args):
        self.name = name
        self.args = args
        self.children = args
        self.type = "FUNC"
        self.fields = []

    def is_relation_op(self):
        if self.name in ("TOP", "SUM", "AVG", "COUNT", "MAX", "MIN"):
            return True
        return False

    def __str__(self):
        return "FUNC, name:%s, args:(%s)" % (self.name, ", ".join(map(str, self.args)))

    def to_spark(self, exec_context):
        name = self.name
        func_name = name

        if "." in func_name:
            module_name = func_name.split(".")[0]
            func_name = func_name.split(".")[1]

            logging.info("Found udf:" + module_name + "." + func_name)
            args = []

            for arg in self.args:
                args.append(arg.to_spark(exec_context))

            return "F.udf(%s.%s)(%s)" % (module_name, func_name, ", ".join(args))

        if name in PIG_SPARK_FUNCTION_MAPPING:
            func_name = PIG_SPARK_FUNCTION_MAPPING[name]

        if name == 'ToDate':
            func_name = 'F.to_date'
        elif name == 'SubtractDuration' or name == 'AddDuration':
            duration = self.args[1].value

            unit = duration[-1]

            sign = 1 if name == 'AddDuration' else -1
            days = int(duration[1:-1]) * sign

            self.args[1] = Number(days)
            func_name = "F.date_add"
        elif name == 'TOP':
            func_name = "df_top_elements"

            top_n = self.args[0].value
            field_index = int(self.args[1].to_spark(exec_context))
            relation = self.args[2].name

            sort_by_field = exec_context.relation_map[relation][field_index].to_spark(exec_context)

            group_by_fields = ", ".join(["'" + field.name + "'" for field in exec_context.params["group_by"].group_by_fields])

            exec_context.last_relation["fields"] = exec_context.relation_map[relation]

            if top_n > 1:
                return "%s(%s, [%s], %s, %s)" % (func_name, relation, group_by_fields, sort_by_field, top_n)
            else:
                return "%s(%s, [%s], %s)" % (func_name, relation, group_by_fields, sort_by_field)
        elif name == "ToUnixTime":
            func_name = "F.to_timestamp"
        elif name == "ToString":
            func_name = "F.date_format"
        elif name == "ToMilliSeconds":
            func_name = "F.to_timestamp"
            return "%s(%s) * 1000" % (func_name, self.args[0].to_spark(exec_context))
        elif name == "SUBSTRING":
            func_name = "F.substring"
            arg_start_index = self.args[0].to_spark(exec_context)
            arg_length = "%s - %s" % (self.args[1].to_spark(exec_context), self.args[0].to_spark(exec_context))

            return "%s(%s, %s)" % (func_name, arg_start_index, arg_length)
        elif name == "STARTSWITH":
            func_name = "F.instr"

            return "%s(%s, %s) == 1" % (func_name, self.args[0].to_spark(exec_context), self.args[1].to_spark(exec_context))

        args = []

        for arg in self.args:
            print arg
            args.append(arg.to_spark(exec_context))

        return "%s(%s)" % (func_name, ", ".join(args))