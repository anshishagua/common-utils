grammar Pig;

program: statement* EOF;

statement :
            setStatement
          | loadStatement
          | forEachStatement
          | storeStatement
          | distinctStatement
          | filterStatement
          | joinStatement
          | groupStatement
          | unionStatement
          | registerStatement
          | splitStatement
          | defineStatement
          ;

opClause : setClause
         | loadClause
         | forEachClause
         | storeClause
         | distinctClause
         | filterClause
         | joinClause
         | groupClause
         | unionClause
         | registerClause
         | splitClause
         ;

defineStatement: DEFINE IDENTIFIER funcCall SEMI_COLON?;

splitStatement: splitClause SEMI_COLON?;
splitClause: SPLIT rel INTO split_branch (COMMA split_branch)* split_otherwise?;

split_branch : IDENTIFIER IF ((LEFT_PAREN condition RIGHT_PAREN) | condition);
split_otherwise: COMMA IDENTIFIER OTHERWISE;

registerStatement: registerClause SEMI_COLON;
registerClause: REGISTER registerFile (USING className)? (AS IDENTIFIER)?;
registerFile: ~(SEMI_COLON | AS | USING)+;

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

//USING PigStorage() AS (name:chararray, age:int, gpa:float);
//FUNC_NAME: IDENTIFIER;
USING: 'USING';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
AS: 'AS' | 'as';
COLON: ':';

dataType : BOOLEAN_TYPE
         | INT_TYPE
         | LONG_TYPE
         | FLOAT_TYPE
         | DOUBLE_TYPE
         | CHARARRAY_TYPE
         | BYTEARRAY_TYPE
         | DATETIME_TYPE
         | BIGINTEGER_TYPE
         | BIGDECIMAL_TYPE
         ;

//tupleSchema: IDENTIFIER (COLON TUPLE) LEFT_PAREN IDENTIFIER RIGHT_PAREN

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
fieldDefinetion: IDENTIFIER (COLON dataType)?;
function: IDENTIFIER LEFT_PAREN RIGHT_PAREN;

setStatement: setClause SEMI_COLON?;
setClause: SET className propertyValue;


propertyValue: MINUS? (scalar | className);
loadStatement: IDENTIFIER ASSIGN loadClause;
loadClause: LOAD PARAM_PATTERN directory PARAM_PATTERN (USING function)?
(AS LEFT_PAREN fieldDefinetion (COMMA fieldDefinetion)*  RIGHT_PAREN)? SEMI_COLON?;

//schema: ~('#')+;

forEachStatement: IDENTIFIER ASSIGN forEachClause SEMI_COLON?;

forEachClause: FOREACH rel (foreach_plan_complex | ( foreach_generate_simple parallelClause?));
foreach_generate_simple : GENERATE flatten_generated_item (COMMA flatten_generated_item )*;

foreach_plan_complex : LEFT_BRACE nested_blk RIGHT_BRACE;

flatten_generated_item: flatten_clause generate_as_clause? | real_arg generate_as_clause?;

generate_as_clause : AS ( (LEFT_PAREN field_def_list RIGHT_PAREN) | explicit_field_def );
field_def_list : field_def ( ',' field_def )*;
field_def : explicit_field_def;
explicit_field_def : IDENTIFIER (COLON dataType)? | dataType;
flatten_clause: FLATTEN LEFT_PAREN expr RIGHT_PAREN;

nested_blk : (nested_command SEMI_COLON)* GENERATE flatten_generated_item (COMMA flatten_generated_item )* SEMI_COLON;

nested_command :
  IDENTIFIER ASSIGN condition
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
nested_sort : ORDER nested_op_input BY order_by_clause (USING funcCall)?;
order_by_clause : STAR ( ASC | DESC )? | order_col_list;
order_col_list : order_col ( ',' order_col )*;
order_col : col_range (ASC | DESC)?
          | col_ref ( ASC | DESC )?
| LEFT_PAREN col_ref ( ASC | DESC )? RIGHT_PAREN;
col_range : col_ref '..' col_ref?
| '..' col_ref;


nested_filter : FILTER nested_op_input BY condition;
nested_op_input : col_ref | nested_proj;
col_ref: IDENTIFIER | DOLLAR_VAR;
nested_proj: col_ref '.' col_ref_list;
col_ref_list : ( col_ref | ( LEFT_PAREN col_ref (COMMA col_ref )* RIGHT_PAREN));


storeStatement: storeClause SEMI_COLON?;
storeClause: STORE IDENTIFIER INTO PARAM_PATTERN directory PARAM_PATTERN;
//alias = DISTINCT alias [PARTITION BY partitioner] [PARALLEL n];
distinctStatement: IDENTIFIER ASSIGN distinctClause SEMI_COLON?;
distinctClause: DISTINCT rel parallelClause?;
//alias = FILTER alias  BY expression;
filterStatement: IDENTIFIER ASSIGN filterClause SEMI_COLON?;
filterClause: FILTER IDENTIFIER BY condition;
//alias = JOIN alias BY {expression|'('expression [, expression …]')'} (, alias BY {expression|'('expression [, expression …]')'} …) [USING 'replicated' | 'bloom' | 'skewed' | 'merge' | 'merge-sparse'] [PARTITION BY partitioner] [PARALLEL n];

joinStatement: IDENTIFIER ASSIGN joinClause SEMI_COLON?;

joinClause: JOIN joinSubClause (USING joinType)? partitionCaluse? parallelClause?;
joinType: QUOTEDSTRING;
joinSubClause: joinItem ( ( ( LEFT | RIGHT | FULL ) OUTER? COMMA joinItem ) | ( (COMMA joinItem)+ ) );
joinItem : rel joinGroupByClause;
joinGroupByClause : BY ((LEFT_PAREN arg (COMMA arg)* RIGHT_PAREN) | arg);
arg: IDENTIFIER | STAR;
rel : IDENTIFIER |  previous_rel | nested_op_clause;
previous_rel : AT;
nested_op_clause: LEFT_PAREN opClause parallelClause? RIGHT_PAREN
                  | LEFT_PAREN FOREACH rel ( foreach_plan_complex | ( foreach_generate_simple parallelClause? ) ) RIGHT_PAREN;


AT: '@';
partitionCaluse : PARTITION BY className;
parallelClause: PARALLEL INTEGER;
groupStatement: rel ASSIGN groupClause SEMI_COLON?;

groupClause: GROUP group_item_list ( USING QUOTEDSTRING )? parallelClause?;
group_item_list : group_item (COMMA group_item )*;
group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?;
join_group_by_clause : BY ((LEFT_PAREN arg_list RIGHT_PAREN) | real_arg );
arg_list : real_arg (COMMA real_arg )* ;
real_arg : biConExpr | STAR | col_range;


unionStatement: rel ASSIGN unionClause SEMI_COLON?;
unionClause: UNION ONSCHEMA? rel COMMA rel (COMMA rel)* parallelClause?;

directory: ~(PARAM_PATTERN)+;

parenCondition: LEFT_PAREN condition RIGHT_PAREN;

condition : parenCondition | andCondition (OR andCondition)* | funcCall;

andCondition : notCondition (AND notCondition)*
;

condition:

notCondition : NOT? unaryCondition;

unaryCondition: LEFT_PAREN condition RIGHT_PAREN
| expr ((IS (NOT)? NULL ) | (IN LEFT_PAREN biConExpr (COMMA biConExpr)* RIGHT_PAREN) | (relOp expr))
| funcCall;

parenExpr: LEFT_PAREN expr RIGHT_PAREN;


expr :
      LEFT_PAREN expr RIGHT_PAREN
   | scalar
   | IDENTIFIER
   | LEFT_PAREN dataType RIGHT_PAREN expr
   | NOT expr
   | expr mulDivModOp expr
   | expr plusMinusOp expr
   | expr relOp expr
   | expr AND expr
   | expr OR expr
   | LEFT_PAREN dataType RIGHT_PAREN expr
   | funcCall
   | expr QMARK expr COLON expr
   | caseWhenExpr
   ;

plusMinusOp: PLUS | MINUS;

mulDivModOp: STAR | DIV | MOD;

multiExpr : castExpr (mulDivModOp castExpr)*
;

//param: ''
basicExpression: scalar | IDENTIFIER | IDENTIFIER PERIOD IDENTIFIER | IDENTIFIER DOUBLE_COLON IDENTIFIER | STAR;

castType: LEFT_PAREN dataType RIGHT_PAREN;

castExpr : castType? basicExpression
        | caseWhenExpr
        | parenExpr
        | scalar
        | funcCall
        ;

biConExpr: LEFT_PAREN biConExpr RIGHT_PAREN
| condition QMARK biConExpr COLON biConExpr
| multiExpr (plusMinusOp multiExpr)*  ;

caseWhenExpr:
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

relOp  : relStrOp
       | EQ
       | NEQ
       | GT
       | GTE
       | LT
       | LTE
       ;

relStrOp   : STR_OP_EQ
           | STR_OP_NE
           | STR_OP_GT
           | STR_OP_LT
           | STR_OP_GTE
           | STR_OP_LTE
| STR_OP_MATCHES;

DOUBLE_COLON: '::';

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
ONSCHEMA: 'ONSCHEMA';
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
DEFINE: 'DEFINE';
SPLIT: 'SPLIT';
JOIN: 'JOIN';
PARALLEL: 'PARALLEL';
GROUP: 'GROUP';

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

nullExpression: IDENTIFIER IS (NOT)? NULL;


funcCall: className LEFT_PAREN biConExpr? (COMMA biConExpr)* RIGHT_PAREN;


//file: FILENAME;
//FILENAME: (PERIOD | PARENT_PATH)? (PATH_SEP (LETTER (LETTER | DIGIT | MINUS)))+ PERIOD LETTER+;


IDENTIFIER: LETTER (LETTER | DIGIT | UNDER_SCORE)*;

className: IDENTIFIER (PERIOD IDENTIFIER)*;



DOLLAR_VAR: DOLAR INTEGER;
END_OF_LINE_COMMENT: MINUS MINUS ~('\n')* '\n';

COMMENT: '/*' .*? '*/';



WS : [ \t\r\n]+ -> skip
   ;
