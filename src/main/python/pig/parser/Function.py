from Node import Node
from Number import Number

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
        name = self.name.lower()
        sparkFuncName = "F." + name

        if name == 'todate':
            sparkFuncName = 'F.to_date'
        elif name == 'subtractduration' or name == 'addduration':
            duration = self.args[1].value

            unit = duration[-1]

            sign = 1 if name == 'addduration' else -1
            days = int(duration[1:-1]) * sign

            self.args[1] = Number(days)
            sparkFuncName = "F.date_add"
        elif name == 'top':
            sparkFuncName = "df_top_elements"

            topN = self.args[0].toSpark()
            fieldIndex = self.args[1].toSpark()
            relation = self.args[2].toSpark(True)

            return "%s(%s, %s, %s, %s)" % (sparkFuncName, relation, "111", fieldIndex, topN)


        args = []

        for arg in self.args:
            args.append(arg.toSpark())

        return "%s(%s)" % (sparkFuncName, ", ".join(args))