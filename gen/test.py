from antlr4 import *
from PyParser import PyParser
from PyTestLexer import PyTestLexer
from PyTestParser import PyTestParser


def main():
    inputStream = InputStream("111 + 111")
    lexer = PyTestLexer(inputStream)
    stream = CommonTokenStream(lexer)
    parser = PyTestParser(stream)
    tree = parser.expr()
    print tree
    v = PyParser()

    print v.visitExpr(tree)

main()