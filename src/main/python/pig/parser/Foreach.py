from Node import Node

class Foreach(Node):
    def __init__(self, target, src, genItems):
        self.target = target
        self.src = src
        self.genItems = genItems

    def __str__(self):
        return "FOREACH:%s = for %s, genereate:%s" % (self.target, self.src, ", ".join(map(str, self.genItems)))

    def toSpark(self):
        items = []

        for item in self.genItems:
            items.append(item.toSpark())

        return "%s = %s.select(%s);" % (self.target.toSpark(), self.src.toSpark(), ", ".join(items))