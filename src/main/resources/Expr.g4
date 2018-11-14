grammar Expr;


INTEGER: '-'? [0-9]+;
LONG: '-'? INTEGER 'L';

condition:

            //| func
            | '(' condition ')'
            ;

COMPARE: '>' | '>=' | '<' | '<=' | '==' | '!=';

func: funcName '(' (expr (',' expr)*)? ')';

funcName: IDENTIFIER ('.' IDENTIFIER)?;

expr:
    '(' expr ')'
    | func
    | INTEGER
    | LONG
    | STRING
    | IDENTIFIER
    | IDENTIFIER '.' IDENTIFIER
    | IDENTIFIER '::' IDENTIFIER
    | '(' DATA_TYPE ')' expr
    | expr ('/' | '*' | '%') expr
    | expr ('+' | '-') expr
    | 'CASE' expr 'WHEN' expr 'THEN' expr 'ELSE' expr 'END'
    | 'CASE' ('WHEN' expr 'THEN' expr)+ ('ELSE' expr)? 'END'
    | expr COMPARE expr
    | expr 'IS' ('NOT')? 'NULL'
    | expr 'IN' '(' expr (',' expr)* ')'
    | expr 'AND' expr
    | expr 'OR' expr
    | 'NOT' expr
    | expr '?' expr ':' expr
    ;

STRING: '\'' ~('\'')* '\'';

DATA_TYPE: 'int' | 'float' | 'long' | 'chararray';
fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
UNDER_SCORE: '_';
IDENTIFIER: LETTER (LETTER | DIGIT | UNDER_SCORE)*;
WS: [ \r\n\t] -> skip;