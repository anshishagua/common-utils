from antlr4 import InputStream
from antlr4 import CommonTokenStream

from pig.generated.PigLexer import PigLexer
from pig.generated.PigParser import PigParser
from pig.parser.PigNewVisitor import PigNewVisitor


def remove_comments(string):
    length = len(string)

    i = 0

    result = ""

    while i < length:
        ch = string[i]

        if ch == "'":
            result += ch
            i += 1

            while i < length and string[i] != "'":
                result += string[i]
                i += 1

            if i < length and string[i] == "'":
                result += string[i]

            i += 1
        elif ch == "-":
            if i + 1 < length and string[i + 1] == "-":
                i += 2

                while i < length and string[i] != "\n":
                    i += 1
            else:
                result += ch
                i += 1
        elif ch == "/":
            if i + 1 < length and string[i + 1] == "*":
                i += 2

                while i < length:
                    if i + 1 < length and not (string[i] == "*" and string[i + 1] == "/"):
                        i += 1
                    else:
                        i += 2

                        break
            else:
                result += ch
                i += 1
        else:
            result += ch
            i += 1

    return result

def to_spark(pigFilePath):
    program = ""

    f = open(pigFilePath)

    for line in f:
        program += (line)

    program = remove_comments(program)

    print program

    inputStream = InputStream(program)
    lexer = PigLexer(inputStream)
    stream = CommonTokenStream(lexer)
    parser = PigParser(stream)
    tree = parser.program()

    visitor = PigNewVisitor()

    program = visitor.visitProgram(tree)

    print program.toSpark()



def main():
    string = """
    
        /**
        wqerqwer
        qewrqwer
        ****/
        
        a = 1; --aaaaa
        b = 1;
        --adfwqerqwrqwerqwerqewr
        c = 3;
    """
    path = "/Users/xiaoli/IdeaProjects/aardvark-analyze/statistics/usage/python/operator_report/mdm_operator_matrix_by_tod.pig"

    to_spark(path)


main()
