from Node import Node


class Program(Node):
    def __init__(self, statements):
        self.children = statements
        self.type = "PROGRAM"

    def __str__(self):
        result = "[type:%s, statements:[" % (self.type)

        for child in self.children:
            result += " " + str(child)

        result += "]]"

        return result

