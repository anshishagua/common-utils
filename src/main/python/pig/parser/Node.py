class Node(object):
    def __init__(self, children):
        self.children = children
        self.type = "NODE"
        self.parent = None

    def getChild(self, i):
        return self.children[i]

    def __str__(self):
        return self.type

    def toSpark(self, raw=False):
        return "%s" % (self)