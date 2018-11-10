grammar Pig;

program: statement* EOF;

statement :
            COMMENT |
          (
            setStatement
          | loadStatement
          | forEachStatement
          | storeStatement
          | distinctStatement
          | filterStatement
          | joinStatement
          | groupStatement
          | unionStatement) END_OF_LINE_COMMENT?;

LOAD: 'LOAD';

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
INTEGER: DIGIT+;
LONGINTEGER: INTEGER 'L';
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
AS: 'AS';
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

MAP: 'map';
TUPLE: 'tuple';

STAR: '*';
PATH_SEP: '/';
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
bbb: IDENTIFIER;

setStatement: SET className propertyValue SEMI_COLON;

propertyValue: scalar | className;
loadStatement: IDENTIFIER ASSIGN loadClause;
loadClause: LOAD PARAM_PATTERN IDENTIFIER PARAM_PATTERN (USING function)?
(AS LEFT_PAREN fieldDefinetion (COMMA fieldDefinetion)*  RIGHT_PAREN)? SEMI_COLON;

forEachStatement: IDENTIFIER ASSIGN FOREACH rel (foreach_plan_complex | ( foreach_generate_simple parallelClause?)) SEMI_COLON;

foreach_generate_simple : GENERATE flatten_generated_item (COMMA flatten_generated_item )*;

foreach_plan_complex : LEFT_BRACE nested_blk RIGHT_BRACE;

flatten_generated_item: flatten_clause generate_as_clause? | expr generate_as_clause?;

generate_as_clause : AS ( (LEFT_PAREN field_def_list RIGHT_PAREN) | explicit_field_def );
field_def_list : field_def ( ',' field_def )*;
field_def : explicit_field_def;
explicit_field_def : IDENTIFIER (COLON dataType)? | dataType;
flatten_clause: FLATTERN LEFT_PAREN expr RIGHT_PAREN;

nested_blk : (nested_command SEMI_COLON)* GENERATE flatten_generated_item (COMMA flatten_generated_item )* SEMI_COLON;

nested_command: 'AAAAA';

//STORE alias INTO 'directory' [USING function];
storeStatement: STORE IDENTIFIER INTO PARAM_PATTERN directory PARAM_PATTERN SEMI_COLON;

//alias = DISTINCT alias [PARTITION BY partitioner] [PARALLEL n];
distinctStatement: IDENTIFIER ASSIGN DISTINCT IDENTIFIER;

//alias = FILTER alias  BY expression;
filterStatement: IDENTIFIER ASSIGN FILTER IDENTIFIER BY condition SEMI_COLON;

//alias = JOIN alias BY {expression|'('expression [, expression …]')'} (, alias BY {expression|'('expression [, expression …]')'} …) [USING 'replicated' | 'bloom' | 'skewed' | 'merge' | 'merge-sparse'] [PARTITION BY partitioner] [PARALLEL n];

joinStatement: IDENTIFIER ASSIGN joinClause SEMI_COLON;

joinClause: JOIN joinSubClause (USING joinType)? partitionCaluse? parallelClause?;
joinType: QUOTEDSTRING;
joinSubClause: joinItem ( ( ( LEFT | RIGHT | FULL ) OUTER? COMMA joinItem ) | ( (COMMA joinItem)+ ) );
joinItem : rel joinGroupByClause;
joinGroupByClause : BY ((LEFT_PAREN arg (COMMA arg)* RIGHT_PAREN) | arg);
arg: IDENTIFIER | STAR;
rel : IDENTIFIER;
partitionCaluse : PARTITION BY className;
parallelClause: PARALLEL INTEGER;
groupStatement: rel ASSIGN GROUP rel (ALL | expr) (COMMA rel (ALL | expr))* (USING QUOTEDSTRING)?
    partitionCaluse? parallelClause? SEMI_COLON;

unionStatement: rel ASSIGN UNION ONSCHEMA? rel COMMA rel (COMMA rel)* parallelClause? SEMI_COLON;

directory: IDENTIFIER;

condition : andCondition  (OR andCondition)*;

andCondition : notCondition (AND notCondition)*
;

notCondition : NOT? unaryCondition;

unaryCondition: expr ((IS (NOT)? NULL ) | (relOp expr))?;

expr : multiExpr ((PLUS | MINUS) multiExpr)*;

multiExpr : castExpr ((STAR | DIV | MOD) castExpr)*
;

//param: ''
basicExpression: scalar | IDENTIFIER | IDENTIFIER PERIOD IDENTIFIER | IDENTIFIER COLON COLON IDENTIFIER | STAR;

castType: LEFT_PAREN dataType RIGHT_PAREN;

castExpr: castType? basicExpression | parenExpr;

parenExpr: LEFT_PAREN condition RIGHT_PAREN;

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

JOIN: 'JOIN';
PARALLEL: 'PARALLEL';
GROUP: 'GROUP';

SET: 'SET';

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

TRUE : 'TRUE'
;

FALSE : 'FALSE'
;

FLATTERN: 'FLATTERN';

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


PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
MOD: '%';

QMARK: '?';
AND: 'AND';
OR: 'OR';
NOT: 'NOT';
IN: 'IN';

EQ: '==';
NEQ: '!=';
LT: '<';
LTE: '<=';
GT: '>';
GTE: '>=';

IS: 'is';
NULL: 'null';

nullExpression: IDENTIFIER IS (NOT)? NULL;

className: IDENTIFIER (PERIOD IDENTIFIER)*;
IDENTIFIER: LETTER (LETTER | DIGIT | UNDER_SCORE)*;

DOLLAR_VAR: DOLAR INTEGER;
END_OF_LINE_COMMENT: '--' .* '\n';

COMMENT:            '/*' .*? '*/';

WS
   : [ \t\r\n]+ -> skip
   ;
