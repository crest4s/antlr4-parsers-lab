grammar EPP;

@header {
package epp;
}

// --------------------------------------------------------------------
// PARSER
// --------------------------------------------------------------------

programa
    : (instruccion | comentario)* EOF
    ;

instruccion
    : asignacion
    | mostrar
    | condicional
    | leer
    | mientras
    ;

asignacion
    : ('asignar' ID '=' expresion
     | ID '=' expresion
     ) FINLINEA
    ;

mostrar
    : 'mostrar' expresion FINLINEA
    ;

leer
    : 'leer' ID FINLINEA
    ;

mientras
    : 'mientras' expresion '->' bloque 'terminar'
    ;

condicional
    : expresion CONDICION 'si' '->' bloque
      ('no' '->' bloque)?
      'terminar'
    ;

bloque
    : (instruccion | comentario)*
    ;

comentario
    : COMENTARIO
    ;

// --------------------------------------------------------------------
// EXPRESIONES (con precedencia y sin etiquetas artificiales)
// --------------------------------------------------------------------

expresion
    : expresion operadorComparacion expresion     # ExprComparacion
    | expresion operadorAditivo expresion         # ExprAritmeticaSumaResta
    | expresion operadorMultiplicativo expresion  # ExprAritmeticaMultDiv
    | '(' expresion ')'                           # ExprParentesis
    | ID                                          # ExprVariable
    | NUM                                         # ExprNumero
    | STRING                                      # ExprTexto
    | VERDADERO                                   # ExprBooleanoVerdadero
    | FALSO                                       # ExprBooleanoFalso
    ;

operadorComparacion
    : MAYOR | MENOR | IGUAL | DIFERENTE | MAYORIGUAL | MENORIGUAL
    ;

operadorAditivo
    : MAS | MENOS
    ;

operadorMultiplicativo
    : POR | DIV | MOD
    ;

// --------------------------------------------------------------------
// LEXER
// --------------------------------------------------------------------

CONDICION : '???';
FINLINEA  : ';P';

// Operadores
MAS        : '+';
MENOS      : '-';
POR        : '*';
DIV        : '/';
MOD        : '%';

MAYOR      : '>';
MENOR      : '<';
IGUAL      : '==';
DIFERENTE  : '!=';
MAYORIGUAL : '>=';
MENORIGUAL : '<=';

// Tipos de datos
NUM        : DIGITO+ ('.' DIGITO+)?;
STRING     : '"' (~["\r\n])* '"';
ID         : [a-zA-Z_][a-zA-Z_0-9]*;

// Literales booleanos
VERDADERO  : 'verdadero';
FALSO      : 'falso';

// Comentarios y espacios
COMENTARIO : '#' ~[\r\n]*;
WS         : [ \t\r\n]+ -> skip;

// Fragmento auxiliar
fragment DIGITO : [0-9];