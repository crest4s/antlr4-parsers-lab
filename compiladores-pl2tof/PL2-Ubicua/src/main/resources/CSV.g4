grammar CSV;

// Regla inicial
csv
    : fila+ EOF
    ;

// Una fila tiene uno o más valores separados por un separador
fila
    : valor (SEPARADOR valor)* (NL | EOF)
    ;

// Valor puede ser texto entre comillas o sin comillas
valor
    : TEXTO
    ;

// Tokens
SEPARADOR : [;,|];
TEXTO     : ~[,\n;\r|]+;
NL        : '\r'? '\n';
ESPACIO   : [ \t\r]+ -> skip;