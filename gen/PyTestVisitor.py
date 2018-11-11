# Generated from /Users/lixiao/code/common-utils/src/main/resources/PyTest.g4 by ANTLR 4.7
from antlr4 import *

# This class defines a complete generic visitor for a parse tree produced by PyTestParser.

class PyTestVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by PyTestParser#expr.
    def visitExpr(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PyTestParser#id.
    def visitId(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PyTestParser#int.
    def visitInt(self, ctx):
        return self.visitChildren(ctx)


