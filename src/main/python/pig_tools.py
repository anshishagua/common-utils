import sys

try:
    from antlr4 import InputStream
    from antlr4 import CommonTokenStream
except ImportError:
    print "Library antlr4 required, please install by command `sudo pip install antlr4-python2-runtime`"
    exit(-1)

from pig.generated.PigLexer import PigLexer
from pig.generated.PigParser import PigParser
from pig.parser.PigNewVisitor import PigNewVisitor
from pig.parser.context import ExecContext


def main():
    if len(sys.argv) <= 1:
        script_name = sys.argv[0].split("/")[-1]
        print "Usage: ./%s --schema-root [schema-root] --input-file [input-file] --output-file [output-file]" % (script_name)
        exit(0)

    input_path = None
    schema_root = None
    output_file = None

    i = 1

    while i < len(sys.argv):
        arg_name = sys.argv[i]
        arg_value = sys.argv[i + 1]

        if arg_name == "--schema-root":
            schema_root = arg_value
        elif arg_name == "--input-file":
            input_path = arg_value
        elif arg_name == "--output-file":
            output_file = arg_value

        i += 2

    if input_path is None or schema_root is None:
        print("Please specify input-file or schema-root")
        exit(0)

    program = ""

    input_path = open(input_path)

    for line in input_path:
        program += line + " "

    input_stream = InputStream(program)
    lexer = PigLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = PigParser(stream)
    tree = parser.program()

    visitor = PigNewVisitor()
    program = visitor.visitProgram(tree)

    exec_context = ExecContext()
    exec_context.schema_root = schema_root

    generated_code = program.to_spark(exec_context)

    if output_file is not None:
        output_file = open(output_file, "w")
        output_file.write(generated_code)
        output_file.close()
    else:
        print(generated_code)


main()
