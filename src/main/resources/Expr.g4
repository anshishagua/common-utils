grammar Expr;


INTEGER: [0-9]+;

condition:
            condition 'AND' condition
            | condition 'OR' condition
            | 'NOT' condition
            | expr COMPARE expr
            | func
            | '(' condition ')'
            ;

COMPARE: '>' | '>=' | '<' | '<=' | '==' | '!=';

func: IDENTIFIER '(' (expr (',' expr)*)? ')';


expr:
     '(' expr ')'
    | INTEGER
    | IDENTIFIER
    | '(' DATA_TYPE ')' expr
    | expr ('/' | '*' | '%') expr
    | expr ('+' | '-') expr
    | expr '?' expr ':' expr
    | 'CASE' expr 'WHEN' expr 'THEN' expr 'ELSE' expr 'END'
    | func
    ;

DATA_TYPE: 'int' | 'float';
fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
UNDER_SCORE: '_';
IDENTIFIER: LETTER (LETTER | DIGIT | UNDER_SCORE)*;
WS: [ \r\n\t] -> skip;