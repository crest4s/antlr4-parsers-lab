grammar EPP;

program: statement* EOF;

statement: assignStmt | printStmt | ifStmt | COMMENT;
assignStmt: 'asignar' ID '=' expr ENDLINE;
printStmt: 'mostrar' expr ENDLINE;
ifStmt: condition 'si' '->' statement* ('no' '->' statement*)? 'terminar';
condition: expr comparator expr '???';
expr: expr ('+' | '-') term # additiveExpr | term # simpleExpr;
term: NUMBER | STRING | ID | '(' expr ')';
comparator: '>' | '<' | '>=' | '<=' | '==' | '!=';

ENDLINE: ';P';
COMMENT: '#' ~[\r\n]* -> skip;
ID: [a-zA-Z_][a-zA-Z0-9_]*;
NUMBER: [0-9]+ ('.' [0-9]+)?;
STRING: '"' (~['"'\r\n])* '"';
WS: [ \t\r\n]+ -> skip;