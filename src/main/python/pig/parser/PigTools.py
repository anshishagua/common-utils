from antlr4 import InputStream
from antlr4 import CommonTokenStream

from pig.generated.PigLexer import PigLexer
from pig.generated.PigParser import PigParser
from pig.parser.PigBaseVisitor import PigBaseVisitor
from pig.parser.PigNewVisitor import PigNewVisitor
from pig.parser.Number import Number


def to_spark():
    inputStream = InputStream(program)
    lexer = PigLexer(inputStream)
    stream = CommonTokenStream(lexer)
    parser = PigParser(stream)
    tree = parser.program()

    visitor = PigNewVisitor()

    program = visitor.visitProgram(tree)

    print program.toSpark()