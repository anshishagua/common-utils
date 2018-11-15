from Node import Node
from Number import Number
import pyspark.sql.functions

class Function(Node):
    def __init__(self, name, args):
        self.name = name
        self.args = args
        self.children = args
        self.type = "FUNC"

    def __str__(self):
        return "FUNC, name:%s, args:(%s)" % (self.name, ", ".join(map(str, self.args)))

    def toSpark(self):
        name = self.name.lower()
        sparkFuncName = name

        if name == 'todate':
            sparkFuncName = 'to_date'
        elif name == 'subtractduration' or name == 'addduration':
            duration = self.args[1].value

            unit = duration[-1]

            sign = 1 if name == 'addduration' else -1
            days = int(duration[1:-1]) * sign

            print days

            self.args[1] = Number(days)
            sparkFuncName = "date_add"

        sparkFuncName = "F." + sparkFuncName

        args = []

        for arg in self.args:
            args.append(arg.toSpark())

        return "%s(%s)" % (sparkFuncName, ", ".join(args))