from Node import Node
from Relation import Relation

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

        if self.src.type == "COMPLEX_RELATION":
            for expr in self.src.expr:
                result += expr.toSpark() + "\n"
            self.src = Relation("temp")
            result += self.toSpark()

            return result

        if self.nested_commands is not None:
            for command in self.nested_commands:
                result += command.toSpark()


        items = []

        for item in self.genItems:
            items.append(item.toSpark())

        result += "%s = %s.select(%s);" % (self.target.toSpark(), self.src.toSpark(), ", ".join(items))

        return result