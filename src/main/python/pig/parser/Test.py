from antlr4 import InputStream
from antlr4 import CommonTokenStream

from pig.generated.PigLexer import PigLexer
from pig.generated.PigParser import PigParser
from pig.parser.PigBaseVisitor import PigBaseVisitor


def main():
    program = """
        SET pig.exec.reducers.max 4000; 
        a = LOAD ###erwqrqwrqwe###; 
        STORE aaa INTO ###asfwer###;
        app_data_usage_bad_record = LOAD ###MDM_APP_DATA_USAGE_BAD_RECORD_F:$load_days###;
        REGISTER ../../pig_udfs/fact_udfs.py USING org.apache.pig.scripting.jython.JythonScriptEngine AS fact_udfs;
        a = FILTER aaa BY a.bbbb == (1 + 1 * 1.000) AND 2 == 2 AND common_udf.is_guid_valid(guid);
    """

    program = """
    retention = UNION retention_day0,retention_day1,retention_day2,retention_day3,retention_day4,retention_day5,retention_day6,retention_day7,retention_day14,retention_day30;
fake_id_to_four_key = DISTINCT fake_id_to_four_key;                       
    
    capi_log = FILTER capi_log BY ToString(ToDate(connection_start_at), 'YYYY-MM-dd') == '$target_date' AND
                                    ((connection_type == 'APP' AND connection_start_at != 0 AND connection_end_at != 0 AND (input_bytes + output_bytes) != 0) OR
                                    (connection_type == 'SCREEN' AND (connection_end_at - connection_start_at) <= 3600*1000*4) OR
                                    (connection_type != 'APP'));    
    """

    inputStream = InputStream(program)
    lexer = PigLexer(inputStream)
    stream = CommonTokenStream(lexer)
    parser = PigParser(stream)
    tree = parser.program()

    visitor = PigBaseVisitor()

    program = visitor.visitProgram(tree)

    print program

main()