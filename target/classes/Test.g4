grammar Test;

expression: LEFT_PAREN expression RIGHT_PAREN
| expression (PLUS | MINUS) expression
| castExpression
| NUM;

castExpression: LEFT_PAREN DATA_TYPE RIGHT_PAREN expression;

NUM : DIGIT+;
fragment DIGIT : [0-9];

PLUS: '+';
MINUS: '-';
DATA_TYPE: 'int' | 'float' | 'double';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';

WS: [ \r\n] -> skip;
