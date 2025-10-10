grammar hello;

// Regla inicial: reconoce la palabra "hello" seguida de un identificador
r : 'hello' ID ;

// Token que reconoce letras (identificadores)
ID : [a-zA-Z]+ ;

// Espacios, tabs y saltos de línea se ignoran
WS : [ \t\r\n]+ -> skip ;