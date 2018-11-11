from PyTestVisitor import PyTestVisitor


class PyParser(PyTestVisitor):
    def visitId(self, ctx):
        return ctx.getText()

    def visitExpr(self, ctx):
        return self.visit(ctx.id()) + self.visit(ctx.int(1))

    def visitInt(self, ctx):
        return int(ctx.getText())
