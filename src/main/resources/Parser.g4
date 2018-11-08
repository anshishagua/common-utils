grammar Parser;


scalar : INTEGER
       | LONGINTEGER
       | FLOATNUMBER
       | DOUBLENUMBER
       | BIGINTEGERNUMBER
       | BIGDECIMALNUMBER
       | QUOTEDSTRING
       | NULL
       | TRUE
       | FALSE
;

statement : SEMI_COLON
          | general_statement SEMI_COLON
          | split_clause SEMI_COLON
          | inline_clause SEMI_COLON
          | import_clause SEMI_COLON
          | realias_clause SEMI_COLON
          | register_clause SEMI_COLON
          | assert_clause SEMI_COLON
          | foreach_statement
;



general_statement : FAT_ARROW ( ( op_clause parallel_clause? ) | nested_op_clause ) -> ^( STATEMENT IDENTIFIER["____RESERVED____"] op_clause? parallel_clause? nested_op_clause? )
                  | ( identifier_plus EQUAL )? ( ( op_clause parallel_clause? ) | nested_op_clause ) -> ^( STATEMENT identifier_plus? op_clause? parallel_clause? nested_op_clause? )
;

op_clause : define_clause
          | load_clause
          | group_clause
          | cube_clause
          | store_clause
          | filter_clause
          | distinct_clause
          | limit_clause
          | sample_clause
          | order_clause
          | rank_clause
          | cross_clause
          | join_clause
          | union_clause
          | stream_clause
          | mr_clause

identifier_plus : IDENTIFIER | reserved_identifier_whitelist -> IDENTIFIER[$reserved_identifier_whitelist.text]


reserved_identifier_whitelist : RANK
                              | CUBE
                              | IN
                              | WHEN
                              | THEN
                              | ELSE
                              | END
;


VOID    : 'VOID'
;

NULL    : 'NULL'
;

IMPORT  : 'IMPORT'
;

REGISTER : 'REGISTER'
;

RETURNS : 'RETURNS'
;

DEFINE : 'DEFINE'
;

LOAD   : 'LOAD'
;

FILTER : 'FILTER'
;

FOREACH : 'FOREACH'
;

ORDER   :  'ORDER'
;

RANK   :  'RANK'
;

DENSE   :  'DENSE'
;

CUBE    : 'CUBE'
;

ROLLUP	: 'ROLLUP'
;

INVOKE  : 'INVOKE'
;

DISTINCT : 'DISTINCT'
;

COGROUP : 'COGROUP'
;

JOIN : 'JOIN'
;

CROSS : 'CROSS'
;

UNION : 'UNION'
;

SPLIT : 'SPLIT'
;

INTO : 'INTO'
;

IF : 'IF'
;

OTHERWISE : 'OTHERWISE'
;

ALL : 'ALL'
;

AS : 'AS'
;

BY : 'BY'
;

USING : 'USING'
;

INNER : 'INNER'
;

OUTER : 'OUTER'
;

ONSCHEMA : 'ONSCHEMA'
;

PARALLEL : 'PARALLEL'
;

PARTITION : 'PARTITION'
;

GROUP : 'GROUP'
;

AND : 'AND'
;

OR : 'OR'
;

NOT : 'NOT'
;

GENERATE : 'GENERATE'
;

FLATTEN : 'FLATTEN'
;

ASC : 'ASC'
;

DESC : 'DESC'
;

BOOLEAN : 'BOOLEAN'
;

INT : 'INT'
;

LONG : 'LONG'
;

FLOAT : 'FLOAT'
;

BIGDECIMAL : 'BIGDECIMAL'
;

BIGINTEGER : 'BIGINTEGER'
;

DOUBLE : 'DOUBLE'
;

DATETIME : 'DATETIME'
;

CHARARRAY : 'CHARARRAY'
;

BYTEARRAY : 'BYTEARRAY'
;

BAG : 'BAG'
;

TUPLE : 'TUPLE'
;

MAP : 'MAP'
;

IS : 'IS'
;

STREAM : 'STREAM'
;

THROUGH : 'THROUGH'
;

STORE : 'STORE'
;

ASSERT : 'ASSERT'
;

MAPREDUCE : 'MAPREDUCE' | 'NATIVE'
;

SHIP : 'SHIP'
;

CACHE : 'CACHE'
;

INPUT : 'INPUT'
;

OUTPUT : 'OUTPUT'
;

STDERROR : 'STDERR'
;

STDIN : 'STDIN'
;

STDOUT : 'STDOUT'
;

LIMIT : 'LIMIT'
;

SAMPLE : 'SAMPLE'
;

LEFT : 'LEFT'
;

RIGHT : 'RIGHT'
;

FULL : 'FULL'
;

CASE : 'CASE'
;

WHEN : 'WHEN'
;

THEN : 'THEN'
;

ELSE : 'ELSE'
;

END : 'END'
;

STR_OP_EQ : 'EQ'
;

STR_OP_GT : 'GT'
;

STR_OP_LT : 'LT'
;

STR_OP_GTE : 'GTE'
;

STR_OP_LTE : 'LTE'
;

STR_OP_NE : 'NEQ'
;

STR_OP_MATCHES : 'MATCHES'
;

IN : 'IN'
;

TRUE : 'TRUE'
;

FALSE : 'FALSE'
;

NUM_OP_EQ : '=='
;

NUM_OP_LT : '<'
;

NUM_OP_LTE : '<='
;

NUM_OP_GT : '>'
;

NUM_OP_GTE : '>='
;

NUM_OP_NE : '!='
;

fragment DIGIT : '0'..'9'
;

fragment LETTER : 'A'..'Z'
;

fragment SPECIALCHAR : '_'
;

fragment ID: LETTER ( DIGIT | LETTER | SPECIALCHAR )*
;

DCOLON : '::'
;

IDENTIFIER :
    ( ID DCOLON IDENTIFIER ) | ID
;

fragment FLOATINGPOINT : INTEGER ( PERIOD INTEGER )? | PERIOD INTEGER
;

INTEGER: ( DIGIT )+
;

LONGINTEGER: INTEGER 'L'
;

DOLLARVAR : DOLLAR INTEGER
;

DOUBLENUMBER : FLOATINGPOINT ( 'E' ( MINUS | PLUS )? INTEGER )?
;

BIGDECIMALNUMBER : DOUBLENUMBER 'BD'
;

BIGINTEGERNUMBER : INTEGER 'BI'
;

FLOATNUMBER : DOUBLENUMBER 'F'
;

QUOTEDSTRING :  '\'' (   ( ~ ( '\'' | '\\' | '\n' | '\r' ) )
                       | ( '\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\' | '\'' ) ) )
                       | ( '\\U' ( '0'..'9' | 'A'..'F' )
                                 ( '0'..'9' | 'A'..'F' )
                                 ( '0'..'9' | 'A'..'F' )
                                 ( '0'..'9' | 'A'..'F' )  )
                     )*
                '\''
;

MULTILINE_QUOTEDSTRING :  '\'' (   ( ~ ( '\'' | '\\' ) )
                                 | ( '\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\' | '\'' | 'n' | 'r' ) ) )
                                 | ( '\\U' ( '0'..'9' | 'A'..'F' )
                                           ( '0'..'9' | 'A'..'F' )
                                           ( '0'..'9' | 'A'..'F' )
                                           ( '0'..'9' | 'A'..'F' )  )
                               )*
                '\''
;

EXECCOMMAND : '`' ( ~( '`' ) )* '`'
;

STAR : '*'
;

COLON : ':'
;

DOLLAR : '$'
;

WS  :  ( ' ' | '\r' | '\t' | '\u000C' | '\n' ) -> skip
;

SL_COMMENT : '--' ( ~( '\r' | '\n' ) )*
;

ML_COMMENT : '/*' (.)* '*/'
;

SEMI_COLON : ';'
;

LEFT_PAREN : '('
;

RIGHT_PAREN : ')'
;

LEFT_CURLY : '{'
;

RIGHT_CURLY : '}'
;

LEFT_BRACKET : '['
;

RIGHT_BRACKET : ']'
;

POUND : '#'
;

EQUAL : '='
;

COMMA : ','
;

PERIOD : '.'
;

DOUBLE_PERIOD : '..'
;

DIV : '/'
;

PERCENT : '%'
;

PLUS : '+'
;

MINUS : '-'
;

QMARK : '?'
;

ARROBA : '@'
;

AMPERSAND : '&'
;

FAT_ARROW : '=>'
;