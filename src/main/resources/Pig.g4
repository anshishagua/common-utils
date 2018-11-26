grammar Pig;

program : statement* EOF;

statement : set_statement
          | load_statement
          | foreach_statement
          | store_statement
          | distinct_statement
          | filter_statement
          | join_statement
          | group_statement
          | union_statement
          | register_statement
          | split_statement
          | define_statement
          | cube_statement
          ;

op_clause : set_clause
          | load_clause
          | foreach_clause
          | store_clause
          | distinct_clause
          | filter_clause
          | join_clause
          | group_clause
          | union_clause
          | register_clause
          | split_clause
          | cube_clause
          ;
          
cube_statement : IDENTIFIER ASSIGN cube_clause SEMI_COLON?;
cube_clause : CUBE rel BY cube_rollup_list (COMMA cube_rollup_list )*;
cube_rollup_list : ( CUBE | ROLLUP ) LEFT_PAREN real_arg (COMMA real_arg )* RIGHT_PAREN;

define_statement: DEFINE IDENTIFIER func_call SEMI_COLON?;

split_statement: split_clause SEMI_COLON?;
split_clause: SPLIT rel INTO split_branch (COMMA split_branch)* split_otherwise?;

split_branch : IDENTIFIER IF ((LEFT_PAREN expr RIGHT_PAREN) | expr);
split_otherwise: COMMA IDENTIFIER OTHERWISE;

register_statement: register_clause SEMI_COLON;
register_clause: REGISTER register_file (USING class_name)? (AS IDENTIFIER)?;
register_file: ~(SEMI_COLON | AS | USING)+;

PARENT_PATH: PERIOD PERIOD;

REGISTER: 'REGISTER' | 'register';
LOAD: 'LOAD';

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
INTEGER: MINUS? DIGIT+;
LONGINTEGER: MINUS? INTEGER 'L';
UNDER_SCORE: '_';

DOLAR: '$';
field: IDENTIFIER | DOLAR INTEGER;
SEMI_COLON: ';';
SINGLE_QUOTE: '\'';

USING: 'USING' | 'using';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
AS: 'AS' | 'as';
COLON: ':';

MAP: 'MAP';
TUPLE: 'TUPLE';

STAR: '*';
//PATH_SEP: '/';
BOOLEAN_TYPE: 'boolean';
INT_TYPE: 'int';
LONG_TYPE: 'long';
FLOAT_TYPE: 'float';
DOUBLE_TYPE: 'double';
CHARARRAY_TYPE: 'chararray';
BYTEARRAY_TYPE: 'bytearray';
DATETIME_TYPE: 'datetime';
BIGINTEGER_TYPE: 'biginteger';
BIGDECIMAL_TYPE: 'bigdecimal';
COMMA: ',';
field_definetion: IDENTIFIER (COLON data_type)?;
function: IDENTIFIER LEFT_PAREN RIGHT_PAREN;

set_statement: set_clause SEMI_COLON?;
set_clause: SET class_name property_value;


property_value: MINUS? (scalar | class_name);
load_statement: IDENTIFIER ASSIGN load_clause;
load_clause: LOAD PARAM_PATTERN directory PARAM_PATTERN (USING function)?
(AS LEFT_PAREN field_definetion (COMMA field_definetion)*  RIGHT_PAREN)? SEMI_COLON?;

//schema: ~('#')+;

foreach_statement: IDENTIFIER ASSIGN foreach_clause SEMI_COLON?;

foreach_clause: FOREACH rel (foreach_plan_complex | ( foreach_generate_simple parallel_clause?));
foreach_generate_simple : GENERATE flatten_generated_item (COMMA flatten_generated_item )*;

foreach_plan_complex : LEFT_BRACE nested_blk RIGHT_BRACE;

flatten_generated_item: flatten_clause generate_as_clause? | real_arg generate_as_clause?;

generate_as_clause : AS ( (LEFT_PAREN field_def_list RIGHT_PAREN) | explicit_field_def );
field_def_list : field_def (COMMA field_def )*;
field_def : explicit_field_def;
explicit_field_def : IDENTIFIER (COLON data_type)? | explicit_type;
data_type: explicit_type | implicit_type;
implicit_type : implicit_tuple_type | implicit_bag_type | implicit_map_type;

explicit_type : simple_type | explicit_tuple_type | explicit_bag_type | explicit_map_type;
simple_type : BOOLEAN_TYPE | INT_TYPE | LONG_TYPE | FLOAT_TYPE | DOUBLE_TYPE | DATETIME_TYPE
| BIGINTEGER_TYPE | BIGDECIMAL_TYPE | CHARARRAY_TYPE | BYTEARRAY_TYPE;
explicit_tuple_type : TUPLE implicit_tuple_type;
implicit_tuple_type : LEFT_PAREN field_def_list? RIGHT_PAREN;
explicit_bag_type: BAG implicit_bag_type;
implicit_bag_type : LEFT_BRACE NULL COLON tuple_type? '}'
| '{' ( ( IDENTIFIER COLON )? tuple_type )? '}';
tuple_type : implicit_tuple_type | explicit_tuple_type;
explicit_map_type : MAP implicit_map_type;
implicit_map_type: '[' data_type? ']';

flatten_clause: FLATTEN LEFT_PAREN expr RIGHT_PAREN;

nested_blk : (nested_command SEMI_COLON)* GENERATE flatten_generated_item (COMMA flatten_generated_item )* SEMI_COLON;

nested_command :
  IDENTIFIER ASSIGN expr
 | IDENTIFIER ASSIGN nested_op;

nested_op : nested_filter
          | nested_sort
          | nested_distinct
          | nested_limit
          | nested_cross
          | nested_foreach;


nested_foreach : FOREACH nested_op_input GENERATE flatten_generated_item (COMMA flatten_generated_item )*;
nested_cross : CROSS nested_op_input_list;
nested_op_input_list : nested_op_input (COMMA nested_op_input )*;
nested_limit : LIMIT nested_op_input ( (INTEGER SEMI_COLON) FAT_ARROW  INTEGER | expr );
nested_distinct : DISTINCT nested_op_input;
nested_sort : ORDER nested_op_input BY order_by_clause (USING func_call)?;
order_by_clause : STAR ( ASC | DESC )? | order_col_list;
order_col_list : order_col ( ',' order_col )*;
order_col : col_range (ASC | DESC)?
          | col_ref ( ASC | DESC )?
| LEFT_PAREN col_ref ( ASC | DESC )? RIGHT_PAREN;
col_range : col_ref op='..' col_ref? | op='..' col_ref;


nested_filter : FILTER nested_op_input BY expr;
nested_op_input : col_ref | nested_proj;
col_ref: IDENTIFIER | DOLLAR_VAR;
nested_proj: col_ref '.' col_ref_list;
col_ref_list : ( col_ref | ( LEFT_PAREN col_ref (COMMA col_ref )* RIGHT_PAREN));


store_statement: store_clause SEMI_COLON?;
store_clause: STORE IDENTIFIER INTO PARAM_PATTERN directory PARAM_PATTERN;
//alias = DISTINCT alias [PARTITION BY partitioner] [PARALLEL n];
distinct_statement: IDENTIFIER ASSIGN distinct_clause SEMI_COLON?;
distinct_clause: DISTINCT rel parallel_clause?;
//alias = FILTER alias  BY expression;
filter_statement: IDENTIFIER ASSIGN filter_clause SEMI_COLON?;
filter_clause: FILTER IDENTIFIER BY expr;
//alias = JOIN alias BY {expression|'('expression [, expression …]')'} (, alias BY {expression|'('expression [, expression …]')'} …) [USING 'replicated' | 'bloom' | 'skewed' | 'merge' | 'merge-sparse'] [PARTITION BY partitioner] [PARALLEL n];

join_statement: IDENTIFIER ASSIGN join_clause SEMI_COLON?;

join_clause: JOIN joinSubClause (USING join_type)? partition_clause? parallel_clause?;
join_type: QUOTEDSTRING;
joinSubClause: joinItem ( ( (LEFT | RIGHT | FULL ) OUTER? COMMA joinItem ) | ( (COMMA joinItem)+ ) );
joinItem : rel join_groupby_clause;
join_groupby_clause : BY ((LEFT_PAREN arg (COMMA arg)* RIGHT_PAREN) | arg);
arg: IDENTIFIER | STAR;
rel : IDENTIFIER |  previous_rel | nested_op_clause;
previous_rel : AT;
nested_op_clause: LEFT_PAREN op_clause parallel_clause? RIGHT_PAREN
                  | LEFT_PAREN FOREACH rel ( foreach_plan_complex | ( foreach_generate_simple parallel_clause? ) ) RIGHT_PAREN;


AT: '@';
partition_clause : PARTITION BY class_name;
parallel_clause: PARALLEL INTEGER;
group_statement: rel ASSIGN group_clause SEMI_COLON?;

group_clause: GROUP group_item_list ( USING QUOTEDSTRING )? parallel_clause?;
group_item_list : group_item (COMMA group_item )*;
group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?;
join_group_by_clause : BY ((LEFT_PAREN arg_list RIGHT_PAREN) | real_arg );
arg_list : real_arg (COMMA real_arg )* ;
real_arg : expr | STAR | col_range;


union_statement: rel ASSIGN union_clause SEMI_COLON?;
union_clause: UNION ONSCHEMA? rel COMMA rel (COMMA rel)* parallel_clause?;

directory: ~(PARAM_PATTERN)+;

expr :
     paren_expr
   | scalar
   | field_reference
   | expr mul_div_mod_op expr
   | expr plus_minus_op expr
   | expr rel_op expr
   | expr IS (NOT)? NULL
   | expr AND expr
   | expr OR expr
   | NOT expr
   | func_call
   | expr QMARK expr COLON expr
   | case_when_expr
   | expr IN LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
   | expr rel_op expr
   | cast_type expr
   ;

field_reference:  IDENTIFIER
                 | IDENTIFIER PERIOD IDENTIFIER
                 | IDENTIFIER DOUBLE_COLON IDENTIFIER
                 | STAR;

paren_expr: LEFT_PAREN expr RIGHT_PAREN;

plus_minus_op: PLUS | MINUS;

mul_div_mod_op: STAR | DIV | MOD;

//param: ''

cast_type: LEFT_PAREN data_type RIGHT_PAREN;

case_when_expr:
    CASE expr (WHEN expr THEN expr)+ (ELSE expr)? END
    | CASE (WHEN expr THEN expr)+  (ELSE expr)? END
    ;

scalar : INTEGER
       | LONGINTEGER
       | FLOATNUMBER
       | DOUBLENUMBER
       | QUOTEDSTRING
       | NULL
       | TRUE
       | FALSE
;

rel_op  : rel_str_op
       | EQ
       | NEQ
       | GT
       | GTE
       | LT
       | LTE
       ;

rel_str_op   : STR_OP_EQ
           | STR_OP_NE
           | STR_OP_GT
           | STR_OP_LT
           | STR_OP_GTE
           | STR_OP_LTE
| STR_OP_MATCHES;

DOUBLE_COLON: '::';
BAG: 'BAG';
CASE: 'CASE';
WHEN: 'WHEN';
THEN: 'THEN';
ELSE: 'ELSE';
END: 'END';
STDIN: 'STDIN';
STDOUT: 'STDOUNT';
OTHERWISE: 'OTHERWISE';
IF: 'IF';
PARTITION: 'PARTITION';
UNION: 'UNION';
ALL: 'ALL';
LEFT: 'LEFT';
RIGHT: 'RIGHT';
FULL: 'FULL';
OUTER: 'OUNTER';
ONSCHEMA: 'ONSCHEMA' | 'onschema';
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
DEFINE: 'DEFINE';
SPLIT: 'SPLIT';
JOIN: 'JOIN';
PARALLEL: 'PARALLEL';
GROUP: 'GROUP';
CUBE: 'CUBE';
ROLLUP: 'ROLLUP';
SET: 'SET' | 'set';

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

STR_OP_MATCHES : 'MATCHES' | 'matches'
;

DOUBLENUMBER : INTEGER (PERIOD INTEGER)? | PERIOD INTEGER
;

VERTICAL_LINE: '|';

TRUE : 'TRUE'
;

FALSE : 'FALSE'
;

FLATTEN: 'FLATTEN';

QUOTEDSTRING :  '\'' (   ( ~ ( '\'' | '\\' | '\n' | '\r' ) )
                       | ( '\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\' | '\'' ) ) )
                       | ( '\\U' ( '0'..'9' | 'A'..'F' )
                                 ( '0'..'9' | 'A'..'F' )
                                 ( '0'..'9' | 'A'..'F' )
                                 ( '0'..'9' | 'A'..'F' )  )
                     )*
                '\''
;

FLOATNUMBER: DOUBLENUMBER 'D';

PERIOD: '.';

BY: 'BY';
FILTER: 'FILTER';
DISTINCT: 'DISTINCT';
PARAM_PATTERN: '###';
INTO: 'INTO';
STORE: 'STORE';
FOREACH: 'FOREACH';
GENERATE: 'GENERATE';
ASSIGN: '=';

ASC: 'ASC';
DESC: 'DESC';

CROSS: 'CROSS';
LIMIT: 'LIMIT';
ORDER: 'ORDER';
ANY: 'ANY';
INNER: 'INNER';
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
MOD: '%';

QMARK: '?';
AND: 'AND';
OR: 'OR';
NOT: 'NOT';
IN: 'IN' | 'in';

EQ: '==';
NEQ: '!=';
LT: '<';
LTE: '<=';
GT: '>';
GTE: '>=';

FAT_ARROW: '=>';
IS: 'IS' | 'is';
NULL: 'NULL' | 'null';

func_call: class_name LEFT_PAREN expr? (COMMA expr)* RIGHT_PAREN;


//file: FILENAME;
//FILENAME: (PERIOD | PARENT_PATH)? (PATH_SEP (LETTER (LETTER | DIGIT | MINUS)))+ PERIOD LETTER+;


IDENTIFIER: LETTER (LETTER | DIGIT | UNDER_SCORE)*;

class_name: IDENTIFIER (PERIOD IDENTIFIER)*;



DOLLAR_VAR: DOLAR INTEGER;
END_OF_LINE_COMMENT: MINUS MINUS ~('\n')* '\n' -> skip;

COMMENT: '/*' .*? '*/' -> skip;



WS : [ \t\r\n]+ -> skip
   ;
