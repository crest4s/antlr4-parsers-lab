grammar EPP;

// -------- PARSER --------

// Un programa son instrucciones o líneas vacías
program
  : (stmt | NL)* EOF
  ;

// Tipos de sentencias admitidas
stmt
  : assignInit           // asignar x = ...
  | assign               // x = ...
  | printStmt            // mostrar ...
  | ifStmt               // ??? cond si -> ... (no -> ...)? terminar
  ;

// Asignación con "asignar" (inicialización)
assignInit
  : ASIGNAR ID '=' expr EOL
  ;

// Asignación normal
assign
  : ID '=' expr EOL
  ;

// Mostrar algo por pantalla
printStmt
  : MOSTRAR expr EOL
  ;

// Estructura condicional (nivel medio)
ifStmt
  : COND SI_ARROW block (NO_ARROW block)? TERMINAR
  ;

// Condición entre ???
COND
  : '???' expr compOp expr '???'
  ;

// Bloques de sentencias (pueden contener más sentencias)
block
  : (stmt | NL)*
  ;

// Expresiones aritméticas simples (+, -)
expr
  : expr '+' term   # add
  | expr '-' term   # sub
  | term            # toTerm
  ;

term
  : atom
  ;

atom
  : INT
  | FLOAT
  | STRING
  | ID
  | '(' expr ')'
  ;

// Operadores de comparación (nivel medio)
compOp
  : '==' | '!=' | '>' | '<' | '>=' | '<='
  ;

// -------- LEXER --------

// Palabras clave
ASIGNAR   : 'asignar' ;
MOSTRAR   : 'mostrar' ;
SI_ARROW  : 'si' ' ' '->' ;
NO_ARROW  : 'no' ' ' '->' ;
TERMINAR  : 'terminar' ;
EOL       : ';P' ;              // fin de instrucción obligatorio

// Identificadores y literales
ID        : [a-zA-Z_][a-zA-Z_0-9]* ;
INT       : [0-9]+ ;
FLOAT     : [0-9]+ '.' [0-9]+ ;
STRING    : '"' ('\\"' | ~["\r\n])* '"' ;

// Saltos de línea y comentarios
NL        : '\r'? '\n' ;
LINE_COMMENT
          : '#' ~[\r\n]* NL -> skip ;   // solo en su propia línea
WS        : [ \t]+ -> skip ;