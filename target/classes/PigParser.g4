grammar PigParser;

// Statement represented by a foreach operator with a nested block. Simple foreach statement
program : statement* EOF;

statement: ';'
            | general_statement ';'
            ;

general_statement: identifier_assignment? (( op_clause parallel_clause? ) );

parallel_clause : PARALLEL (INTEGER | ID);

identifier_assignment : (IDENTIFIER EQUAL) | FAT_ARROW;

op_clause : load_clause | set_clause | filter_clause;
filter_clause : FILTER rel BY ((LEFT_PAREN cond RIGHT_PAREN) | cond);
rel : IDENTIFIER;
cond : not_cond ( (AND|OR) not_cond )* ;
not_cond : (NOT)? unary_cond;
unary_cond : expr ( ( IS (NOT)? NULL ) | ( rel_op expr ) )?;

expr : multi_expr ( (PLUS | MINUS) multi_expr )*;
multi_expr : cast_expr ( ( STAR | DIV | MOD ) cast_expr )*;
cast_expr :
            identifier_with_function
          | function_name_with_columns
          | '-' cast_expr
          | col_ref_without_identifier projection*
          | identifier_with_projection
          | curly_expr
          | bracket_expr
          | paren_expr
          | scalar;

bracket_expr : '[' real_arg ( ',' real_arg )* ']' projection*
             | '[' keyvalue ( ',' keyvalue )* ']' projection*
| '[' ']' projection*;


keyvalue : QUOTEDSTRING '#' literal;
literal : scalar;
curly_expr : '{' real_arg ( ',' real_arg )* '}' projection*
           | '{' '}' projection*;

identifier_with_projection : IDENTIFIER projection*;
identifier_with_function : IDENTIFIER func_name_suffix? '(' arg_list? ')' projection*;
func_name_suffix: ( ( '$' | '.' ) eid )+;
arg_list : ( real_arg ( ',' real_arg )* );
real_arg : expr
         | STAR
| col_range;

col_range : col_ref DOUBLE_PERIOD col_ref?
| DOUBLE_PERIOD col_ref;

function_name_with_columns : func_name_without_columns '(' arg_list? ')' projection*;
func_name_without_columns : eid_without_columns ( ( '.' | '$' ) eid )*;
eid_without_columns : rel_str_op;
paren_expr : LEFT_PAREN  after_left_paren;

after_left_paren : simple_type ')' cast_expr
                 | ')' projection*
                 | STAR ( ',' real_arg )* ')' projection* /*-> ^( FUNC_EVAL TOTUPLE STAR real_arg* ) projection**/
                 | col_range ( ',' real_arg )* ')' projection* /*-> ^( FUNC_EVAL TOTUPLE col_range real_arg* ) projection**/
                 // Tuples begin with '(' expr, but shorthand-booleans begin with '(' cond. As cond
                 // and expr are indistinguishable, we'll parse as a cond (i.e. the most lenient) and
                 // for exprs, strip off the BOOL_COND trees. You can have both nested conds and nested
                 // exprs, so we'll just assume cond.
                 | (cond)
                   ( ( ( ',' real_arg )+ ')' projection*
                   | ( ')' )
                   | ( '?' expr ':' expr ')') ))
;

projection : '.' ( col_ref | '(' col_ref ( ',' col_ref )* ')' )
| '#' ( QUOTEDSTRING | NULL );

col_ref : col_ref_without_identifier | IDENTIFIER;

col_ref_without_identifier : GROUP | CUBE | DOLLARVAR;

rel_op : rel_str_op
       | NUM_OP_EQ
       | NUM_OP_NE
       | NUM_OP_GT
       | NUM_OP_GTE
       | NUM_OP_LT
       | NUM_OP_LTE
;

rel_str_op : STR_OP_EQ
           | STR_OP_NE
           | STR_OP_GT
           | STR_OP_LT
           | STR_OP_GTE
           | STR_OP_LTE
           | STR_OP_MATCHES;

set_clause : SET property_name property_value;
define_clause : DEFINE IDENTIFIER ( cmd | func_clause | macro_clause);

macro_clause : macro_param_clause macro_return_clause macro_body_clause;
macro_return_clause : RETURNS ((IDENTIFIER (',' IDENTIFIER)*) | VOID);
macro_param_clause : '(' ( IDENTIFIER (',' IDENTIFIER)* )? ')';
macro_body_clause : macro_content;
macro_content : '{' ( macro_content | ~('{' | '}') )* '}';
cmd : EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*;

register_clause : REGISTER FILENAME USING package  AS IDENTIFIER;

package: ID (PERIOD ID)*;
ship_clause : SHIP '(' path_list? ')';

path_list : QUOTEDSTRING ( ',' QUOTEDSTRING )*;

cache_clause : CACHE '(' path_list ')';

input_clause : INPUT '(' stream_cmd_list ')';

output_clause : OUTPUT '(' stream_cmd_list ')';

stream_cmd_list : stream_cmd ( ',' stream_cmd )*;

stream_cmd : ( STDIN | STDOUT | QUOTEDSTRING ) ( USING func_clause )?;

error_clause : STDERROR '(' ( QUOTEDSTRING ( LIMIT INTEGER )? )? ')';

property_name : eid ('.' eid)* ;
property_value : COMMA* (scalar | func_name);
load_clause: LOAD QUOTEDSTRING ( USING func_clause )? as_clause? ;

as_clause : AS ( field_def | ( LEFT_PAREN field_def_list? RIGHT_PAREN ) );

field_def_list: field_def ( ',' field_def )*;

field_def : IDENTIFIER ( ':' type )?
| explicit_type;

type : simple_type;

explicit_type : simple_type;
simple_type : BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER
| BIGDECIMAL | CHARARRAY | BYTEARRAY;



func_clause: func_name_with_args | func_name_zero_args | func_name;
func_name_zero_args : func_name LEFT_PAREN RIGHT_PAREN;
func_name_with_args : func_name LEFT_PAREN func_args RIGHT_PAREN;

func_name : eid ( ( '.' | '$' ) eid )*;
func_args : func_args_string ( ',' func_args_string )*;
func_args_string : QUOTEDSTRING | MULTILINE_QUOTEDSTRING;

eid: IDENTIFIER;

scalar : INTEGER
       | LONG
       | FLOATNUMBER
       | DOUBLENUMBER
       | QUOTEDSTRING
       | NULL
       | TRUE
       | FALSE
       | SCRIPT_PARAM_NAME
| DOLLARVAR;

FILENAME: (PATH_SEP? (IDENTIFIER | PARENT_PATH)?)+;

PARENT_PATH: '..';
PATH_SEP: '/';

SET : 'SET';

VOID    : 'VOID'
;

NULL    : 'NULL'
;

IMPORT  : 'IMPORT'
;

REGISTER : 'REGISTER' | 'register'
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

TRUE : 'TRUE' | 'true'
;

FALSE : 'FALSE' | 'false'
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

fragment DIGIT : [0-9]
;

fragment LETTER : [a-zA-Z]
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

MOD : '%';

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