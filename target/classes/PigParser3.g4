grammar PigParser3;


pigFile : statement* EOF;

COMMENT : SL_COMMENT | ML_COMMENT;

statement : empty_statement
            | foreach_statement
            | general_statement SEMI_COLON
            | split_clause SEMI_COLON
            | inline_clause SEMI_COLON
            | import_clause SEMI_COLON
            | realias_clause SEMI_COLON
            | declare_statement
            | default_statement
            ;

empty_statement : SEMI_COLON;

declare_statement : PERCENT DECLARE property_name (scalar | func_name | EXECCOMMAND);
default_statement : PERCENT DEFAULT property_name (scalar | func_name | EXECCOMMAND);


nested_op_clause : LEFT_PAREN op_clause parallel_clause? RIGHT_PAREN
                 | LEFT_PAREN FOREACH rel ( foreach_plan_complex | ( foreach_generate_simple parallel_clause? ) ) RIGHT_PAREN
                 ;

general_statement : identifier_assignment? (( op_clause parallel_clause? ) | nested_op_clause );

identifier_assignment : (IDENTIFIER EQUAL) | FAT_ARROW;


foreach_statement : foreach_assignment FOREACH rel ( foreach_plan_complex | ( foreach_generate_simple parallel_clause? SEMI_COLON));

foreach_assignment : FAT_ARROW | (IDENTIFIER EQUAL)? ;
foreach_plan_complex : LEFT_BRACKET nested_blk RIGHT_BRACKET;

foreach_generate_simple : GENERATE flatten_generated_item (COMMA flatten_generated_item)*;

macro_content : LEFT_BRACKET ( macro_content | ~(LEFT_BRACKET | RIGHT_BRACKET) )* RIGHT_BRACKET;

macro_param_clause : LEFT_PAREN ( IDENTIFIER (',' IDENTIFIER)* )? RIGHT_PAREN;

macro_return_clause : RETURNS ((IDENTIFIER (COMMA IDENTIFIER)*) | VOID);

macro_body_clause : macro_content;

macro_clause : macro_param_clause macro_return_clause macro_body_clause;

inline_return_clause
    : IDENTIFIER EQUAL
	| IDENTIFIER (COMMA IDENTIFIER)+ EQUAL
	;

parameter
    : IDENTIFIER
    | INTEGER
    | DOUBLENUMBER
    | BIGDECIMALNUMBER
    | BIGINTEGERNUMBER
    | QUOTEDSTRING
    | DOLLARVAR
    | SCRIPT_PARAM_NAME
    ;

inline_param_clause : LEFT_PAREN ( parameter (COMMA parameter)* )? RIGHT_PAREN;
inline_clause : inline_return_clause IDENTIFIER inline_param_clause;

// TYPES

simple_type : BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER | BIGDECIMAL | CHARARRAY | BYTEARRAY;

implicit_tuple_type : LEFT_PAREN field_def_list? RIGHT_PAREN;

explicit_tuple_type : TUPLE implicit_tuple_type;

explicit_tuple_type_cast : TUPLE LEFT_PAREN (explicit_type_cast (COMMA explicit_type_cast )* )? RIGHT_PAREN;

tuple_type : implicit_tuple_type | explicit_tuple_type;

implicit_bag_type : '{' NULL ':' tuple_type? '}'
                  | '{' ( ( IDENTIFIER COLON )? tuple_type )? '}'
                  ;

explicit_bag_type : BAG implicit_bag_type;

explicit_bag_type_cast : BAG '{' explicit_tuple_type_cast? '}';

implicit_map_type : '[' type? ']' ;

explicit_map_type : MAP implicit_map_type;

map_type : implicit_map_type | explicit_map_type;

explicit_type : simple_type | explicit_tuple_type | explicit_bag_type | explicit_map_type;

implicit_type : implicit_tuple_type | implicit_bag_type | implicit_map_type;

type : explicit_type | implicit_type;

explicit_type_cast : simple_type | explicit_map_type | explicit_tuple_type_cast | explicit_bag_type_cast;

// CLAUSES

import_clause : IMPORT QUOTEDSTRING;

define_clause : DEFINE IDENTIFIER ( cmd | func_clause | macro_clause);
set_clause : SET property_name property_value;
property_value : ('-')* (scalar | func_name);

register_clause : REGISTER FILENAME;
property_name : eid ('.' eid)*;  // current hack adding map

realias_clause : IDENTIFIER '=' IDENTIFIER;


parallel_clause : PARALLEL (INTEGER| DOLLAR ID);

op_clause : define_clause
          | load_clause
          | group_clause
          | cube_clause
          | store_clause
          | filter_clause
          | distinct_clause
          | illustrate_clause
          | limit_clause
          | sample_clause
          | order_clause
          | rank_clause
          | cross_clause
          | join_clause
          | union_clause
          | stream_clause
          | mr_clause
          | set_clause
          | register_clause
          | dump_clause
          | rmf_clause
          ;

rmf_clause : RMF FILENAME;

dump_clause : DUMP IDENTIFIER;

ship_clause : SHIP LEFT_PAREN path_list? RIGHT_PAREN;

path_list : QUOTEDSTRING ( ',' QUOTEDSTRING )*;

cache_clause : CACHE LEFT_PAREN path_list RIGHT_PAREN;

input_clause : INPUT LEFT_PAREN stream_cmd_list RIGHT_PAREN;

output_clause : OUTPUT LEFT_PAREN stream_cmd_list RIGHT_PAREN;

error_clause : STDERROR LEFT_PAREN ( QUOTEDSTRING ( LIMIT INTEGER )? )? RIGHT_PAREN;

load_clause : LOAD QUOTEDSTRING ( USING func_clause )? as_clause?;

func_clause : func_name_with_args |  func_name_zero_args | func_name;

func_name_zero_args : func_name LEFT_PAREN RIGHT_PAREN;
func_name_with_args : func_name LEFT_PAREN func_args RIGHT_PAREN;

// needed for disambiguation when parsing expressions...see below
func_name_without_columns : eid_without_columns ( ( '.' | '$' ) eid )*;

func_name : eid ( ( '.' | '$' ) eid )*;

func_args_string : QUOTEDSTRING | MULTILINE_QUOTEDSTRING;

func_args : func_args_string ( ',' func_args_string )*;

group_clause : ( GROUP | COGROUP ) group_item_list ( USING QUOTEDSTRING )? partition_clause?;

group_item_list : group_item ( ',' group_item )*;

group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?;

// "AS" CLAUSES

explicit_field_def : IDENTIFIER ( ':' type )?
                   | explicit_type
                   ;

field_def : explicit_field_def
          | implicit_type
          ;

field_def_list : field_def ( ',' field_def )*;

as_clause : AS ( explicit_field_def | ( LEFT_PAREN field_def_list? RIGHT_PAREN ) );

// OTHERS

stream_cmd_list : stream_cmd ( ',' stream_cmd )*;

stream_cmd : ( STDIN | STDOUT | QUOTEDSTRING ) ( USING func_clause )?;

cmd : EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*;

rel : IDENTIFIER | previous_rel | nested_op_clause;

previous_rel : '@';

store_clause : STORE rel INTO QUOTEDSTRING ( USING func_clause )?;

filter_clause : FILTER rel BY ((LEFT_PAREN cond RIGHT_PAREN) | cond);

stream_clause : STREAM rel THROUGH ( EXECCOMMAND | IDENTIFIER ) as_clause?;

mr_clause : MAPREDUCE QUOTEDSTRING ( LEFT_PAREN path_list RIGHT_PAREN )? store_clause load_clause EXECCOMMAND?;

split_clause : SPLIT rel INTO split_branch (',' split_branch)* split_otherwise?;

split_branch : IDENTIFIER IF ((LEFT_PAREN cond RIGHT_PAREN) | cond);

split_otherwise : IDENTIFIER OTHERWISE;

limit_clause : LIMIT rel expr;

sample_clause : SAMPLE rel expr;

rank_clause : RANK rel ( rank_by_statement )?;

rank_by_statement : BY rank_by_clause DENSE;

rank_by_clause : STAR ( ASC | DESC )?
               | rank_list
               ;

rank_list : rank_col ( ',' rank_col )*;

rank_col : col_range ( ASC | DESC )?
         | col_ref ( ASC | DESC )?
         ;

order_clause : ORDER rel BY order_by_clause ( USING func_clause )?;

order_by_clause : '*' ( ASC | DESC )?
                | order_col_list
                ;

order_col_list : order_col ( ',' order_col )*;

order_col : col_range (ASC | DESC)?
          | col_ref ( ASC | DESC )?
          | LEFT_PAREN col_ref ( ASC | DESC )? RIGHT_PAREN
          ;

distinct_clause : DISTINCT rel partition_clause? ;
illustrate_clause : ILLUSTRATE IDENTIFIER;

partition_clause : PARTITION BY func_name;

rel_list : rel ( ',' rel )*;

cross_clause : CROSS rel_list partition_clause?;


join_clause : JOIN join_sub_clause ( USING join_type )? partition_clause?;

join_type : QUOTEDSTRING;

join_sub_clause : join_item ( ( ( LEFT | RIGHT | FULL ) OUTER? ',' join_item ) | ( ( ',' join_item )+ ) );

join_item : rel join_group_by_clause;

join_group_by_clause : BY ((LEFT_PAREN arg_list RIGHT_PAREN) |  real_arg );

union_clause : UNION ONSCHEMA? rel_list;

cube_clause : CUBE rel BY cube_rollup_list ( ',' cube_rollup_list )*;

cube_rollup_list : ( CUBE | ROLLUP ) LEFT_PAREN real_arg ( ',' real_arg )* RIGHT_PAREN;

flatten_clause : FLATTEN LEFT_PAREN expr RIGHT_PAREN;

// unlike loading and streaming, we want the as_clause (if present) in a different format (i.e.
// we drop the AS token itself).
generate_as_clause :  AS ( ( LEFT_PAREN field_def_list RIGHT_PAREN ) | explicit_field_def );

flatten_generated_item : flatten_clause generate_as_clause? | real_arg generate_as_clause?;

// EXPRESSIONS

// conditional precedence is OR weakest, then AND, then NOT, then IS NOT NULL and the comparison operators equally
// by design the boolean operator hierarchy is entirely below the expression hierarchy

real_arg : expr
         | '*'
         | col_range
         ;

cond :  not_cond ( (AND|OR) not_cond )*;

not_cond  : (NOT)? unary_cond;

unary_cond : expr ( ( IS (NOT)? NULL ) | ( rel_op expr ) )?;

expr : multi_expr ( ( '+' | '-' ) multi_expr )*;

multi_expr : cast_expr ( ( '*' | '/' | PERCENT ) cast_expr )*;

func_name_suffix : ( ( '$' | '.' ) eid )+;

cast_expr
          :
            identifier_with_function
          | function_name_with_columns
          | '-' cast_expr
          | col_ref_without_identifier projection*
          | identifier_with_projection
          | curly_expr
          | bracket_expr
          | paren_expr
          | scalar
          ;
identifier_with_projection : IDENTIFIER projection*;
function_name_with_columns : func_name_without_columns LEFT_PAREN arg_list? RIGHT_PAREN projection*;
arg_list : ( real_arg ( ',' real_arg )* );
identifier_with_function : IDENTIFIER func_name_suffix? LEFT_PAREN arg_list? RIGHT_PAREN projection*;


// now we have to deal with parentheses: in an expr, '(' can be the
// start of a cast, the start of a nested expression or the start of
// a tuple. We'll ensure parsing is unambiguous by assuming a single
// expression in parentheses is a nested expression, whereas two or
// more nested expressions are a tuple (unless that single expression
// is a literal, in which case we assume tuple with a single element
// - that literal).
paren_expr : LEFT_PAREN  after_left_paren;

after_left_paren : explicit_type_cast RIGHT_PAREN cast_expr /*-> ^( CAST_EXPR explicit_type_cast cast_expr )*/
                 // tuples
                 | RIGHT_PAREN projection* /*-> ^( TUPLE_VAL ) projection**/
                 | '*' ( ',' real_arg )* RIGHT_PAREN projection* /*-> ^( FUNC_EVAL TOTUPLE STAR real_arg* ) projection**/
                 | col_range ( ',' real_arg )* RIGHT_PAREN projection* /*-> ^( FUNC_EVAL TOTUPLE col_range real_arg* ) projection**/
                 // Tuples begin with LEFT_PAREN expr, but shorthand-booleans begin with LEFT_PAREN cond. As cond
                 // and expr are indistinguishable, we'll parse as a cond (i.e. the most lenient) and
                 // for exprs, strip off the BOOL_COND trees. You can have both nested conds and nested
                 // exprs, so we'll just assume cond.
                 | (cond)
                   ( ( ( ',' real_arg )+ RIGHT_PAREN projection*
                   | ( RIGHT_PAREN )
                   | ( '?' expr ':' expr RIGHT_PAREN) ))
;


curly_expr : '{' real_arg ( ',' real_arg )* '}' projection*
           | '{' '}' projection*
           ;

bracket_expr : '[' real_arg ( ',' real_arg )* ']' projection*
             | '[' keyvalue ( ',' keyvalue )* ']' projection*
             | '[' ']' projection*
             ;

projection : '.' ( col_ref | LEFT_PAREN col_ref ( ',' col_ref )* RIGHT_PAREN )
           | '#' ( QUOTEDSTRING | NULL )
           ;

// ATOMS

// for disambiguation with func_names
col_ref_without_identifier : GROUP | CUBE | DOLLARVAR;

col_ref : col_ref_without_identifier | IDENTIFIER;

col_range : col_ref '..' col_ref?
          |  '..' col_ref
          ;

scalar : INTEGER_LITERAL
       | LONG_LITERAL
       | FLOAT_LITERAL
       | DOUBLE_LITERAL
       | QUOTEDSTRING
       | NULL
       | TRUE
       | FALSE
       | SCRIPT_PARAM_NAME
       | DOLLARVAR
       ;

keyvalue : QUOTEDSTRING '#' literal;

literal_map : '[' keyvalue ( ',' keyvalue )* ']'
            | '[' ']'
            ;


literal_bag : '{' literal_tuple ( ',' literal_tuple )* '}'
            | '{' '}'
            ;

literal_tuple : LEFT_PAREN literal ( ',' literal )* RIGHT_PAREN
              | LEFT_PAREN RIGHT_PAREN
              ;

literal : scalar | literal_map | literal_bag | literal_tuple;

// NESTING

nested_blk : ( nested_command SEMI_COLON )* GENERATE flatten_generated_item ( ',' flatten_generated_item )* SEMI_COLON;

nested_command : IDENTIFIER '=' cond
               | IDENTIFIER '=' nested_op
               ;

nested_op : nested_filter
          | nested_sort
          | nested_distinct
          | nested_limit
          | nested_cross
          | nested_foreach
          ;

nested_proj : col_ref '.' col_ref_list;

col_ref_list : ( col_ref | ( LEFT_PAREN col_ref ( ',' col_ref )* RIGHT_PAREN ) );

nested_filter : FILTER nested_op_input BY cond;

nested_sort : ORDER nested_op_input BY  order_by_clause ( USING func_clause )?;

nested_distinct : DISTINCT nested_op_input;

nested_limit : LIMIT nested_op_input ( (INTEGER SEMI_COLON) '=>' INTEGER | expr );

nested_cross : CROSS nested_op_input_list;

nested_foreach: FOREACH nested_op_input GENERATE flatten_generated_item ( ',' flatten_generated_item )*;

nested_op_input : col_ref | nested_proj;

nested_op_input_list: nested_op_input ( ',' nested_op_input )*;


eid_without_columns : rel_str_op
    | IMPORT
    | RETURNS
    | DEFINE
    | LOAD
    | FILTER
    | FOREACH
    | ROLLUP
    | ORDER
    | DISTINCT
    | COGROUP
    | JOIN
    | CROSS
    | UNION
    | SPLIT
    | INTO
    | INPUT
    | IF
    | ALL
    | AS
    | BY
    | USING
    | INNER
    | OUTER
    | PARALLEL
    | PARTITION
    | AND
    | OR
    | GENERATE
    | ASC
    | DESC
    | BOOL
    | BIGINTEGER
    | BIGDECIMAL
    | DATETIME
    | CHARARRAY
    | BYTEARRAY
    | IS
    | STREAM
    | THROUGH
    | STORE
    | MAPREDUCE
    | SHIP
    | CACHE
    | OUTPUT
    | STDERROR
    | STDIN
    | STDOUT
    | LIMIT
    | SAMPLE
    | LEFT
    | RIGHT
    | FULL
    | REALIAS
    | BOOL_COND
;

eid : eid_without_columns
    | IDENTIFIER
    | GROUP
    | CUBE
    | TRUE
    | FALSE
    | INT
    | LONG
    | FLOAT
    | DOUBLE
    | NULL
    | NOT
    | FLATTEN
    | BAG
    | TUPLE
    | MAP
;

// relational operator
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

DEFAULT: 'DEFAULT';

DUMP : 'DUMP';

DECLARE: 'DECLARE';

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

IDENTIFIER : ( ID DCOLON IDENTIFIER ) | ID
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

WS  :  ( ' ' | '\r' | '\t' | '\u000C' | '\n' )
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

FILENAME: (([0-9] | [A-Za-z]) | ('*' | '/' | ':' | '.' | '$' | '@' | '{' | '}' | '-'))*;
