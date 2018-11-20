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
    "TOP": "df_top_elements"
}


class Function(Node):
    def __init__(self, name, args):
        self.name = name
        self.args = args
        self.children = args
        self.type = "FUNC"

    def isRelOp(self):
        if self.name == "TOP":
            return True
        return False

    def __str__(self):
        return "FUNC, name:%s, args:(%s)" % (self.name, ", ".join(map(str, self.args)))

    def toSpark(self):
        name = self.name
        sparkFuncName = name

        if name in PIG_SPARK_FUNCTION_MAPPING:
            sparkFuncName = PIG_SPARK_FUNCTION_MAPPING[name]

        if name == 'ToDate':
            sparkFuncName = 'F.to_date'
        elif name == 'SubtractDuration' or name == 'AddDuration':
            duration = self.args[1].value

            unit = duration[-1]

            sign = 1 if name == 'AddDuration' else -1
            days = int(duration[1:-1]) * sign

            self.args[1] = Number(days)
            sparkFuncName = "F.date_add"
        elif name == 'TOP':
            sparkFuncName = "df_top_elements"

            topN = self.args[0].toSpark()
            fieldIndex = self.args[1].toSpark()
            relation = self.args[2].toSpark(True)

            return "%s(%s, %s, %s, %s)" % (sparkFuncName, relation, "111", fieldIndex, topN)
        elif name == "ToUnixTime":
            sparkFuncName = "F.to_timestamp"
        elif name == "ToString":
            sparkFuncName = "F.date_format"
        elif name == "ToMilliSeconds":
            sparkFuncName = "F.to_timestamp"
            return "%s(%s) * 1000" % (sparkFuncName, self.args[0].toSpark())
        elif name == "SUBSTRING":
            sparkFuncName = "F.substring"
            arg_start_index = self.args[0].toSpark()
            arg_length = "%s - %s" % (self.args[1].toSpark(), self.args[0].toSpark())

            return "%s(%s, %s)" % (sparkFuncName, arg_start_index, arg_length)
        elif name == "STARTSWITH":
            sparkFuncName = "F.instr"

            return "%s(%s, %s) == 1" % (sparkFuncName, self.args[0].toSpark(), self.args[1].toSpark())

        args = []

        for arg in self.args:
            args.append(arg.toSpark())

        return "%s(%s)" % (sparkFuncName, ", ".join(args))