grammar PyTest;

expr: id PLUS int EOF;

id: LETTER+;
fragment LETTER : [a-zA-Z]+;
int: INTEGER;


PLUS: '+';
INTEGER: [0-9]+;

WS: [ \t\r\n]+ -> skip;
