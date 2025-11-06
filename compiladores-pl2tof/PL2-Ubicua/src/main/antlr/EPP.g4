// ====================================================================
// EPP.g4
// Gramática extendida del lenguaje E++ (Nivel medio)
// ====================================================================
//
// Basada en la versión mínima que cumple el nivel básico (apartado 1.2).
// Extensiones incluidas:
//   🔹 [1] Operadores aritméticos adicionales (*, /, %)
//   🔹 [3] Literales booleanos (verdadero, falso)
//   🔹 [4] Instrucción de lectura (leer)
//   🔹 [7] Bucle 'mientras -> ... terminar'
//
// ====================================================================

grammar EPP;

// ====================================================================
// --------------------------- PARSER --------------------------------
// ====================================================================

programa
    : (instruccion | comentario)* EOF
    ;

// --------------------------------------------------------------------

instruccion
    : asignacion
    | mostrar
    | condicional
    | leer                      // 🔹 [4] Nueva instrucción de entrada
    | mientras                  // 🔹 [7] Nueva instrucción de bucle
    ;

// --------------------------------------------------------------------

asignacion
    // Acepta inicialización y reasignación
    : ( 'asignar' ID '=' expresion
      | ID '=' expresion
      ) FINLINEA
    ;

// --------------------------------------------------------------------

mostrar
    : 'mostrar' expresion FINLINEA
    ;

// --------------------------------------------------------------------

leer                             // 🔹 [4] Leer variable desde entrada
    : 'leer' ID FINLINEA
    ;

// --------------------------------------------------------------------

mientras                         // 🔹 [7] Estructura de bucle
    : 'mientras' expresion '->' bloque 'terminar'
    ;

// --------------------------------------------------------------------

condicional
    : expresion CONDICION 'si' '->' bloque
      ( 'no' '->' bloque )?
      'terminar'
    ;

// --------------------------------------------------------------------

bloque
    : (instruccion | comentario)*
    ;

// --------------------------------------------------------------------
// Expresiones y comparaciones
// --------------------------------------------------------------------

expresion
    : comparacion
    ;

comparacion
    : aritmetica ( (MAYOR | MENOR | IGUAL | DIFERENTE | MAYORIGUAL | MENORIGUAL) aritmetica )?
    ;

// 🔹 [1] Ampliación aritmética: ahora admite *, / y %
aritmetica
    : termino ( (MAS | MENOS | POR | DIV | MOD) termino )*
    ;

termino
    : NUM
    | STRING
    | ID
    | VERDADERO                 // 🔹 [3] Literal booleano
    | FALSO                     // 🔹 [3] Literal booleano
    | '(' expresion ')'
    ;

comentario
    : COMENTARIO
    ;

// ====================================================================
// --------------------------- LEXER ---------------------------------
// ====================================================================

CONDICION : '???';
FINLINEA  : ';P';

// --------------------------------------------------------------------
// Operadores aritméticos y relacionales
MAS        : '+';
MENOS      : '-';
POR        : '*';              // 🔹 [1]
DIV        : '/';              // 🔹 [1]
MOD        : '%';              // 🔹 [1]
MAYOR      : '>';
MENOR      : '<';
IGUAL      : '==';
DIFERENTE  : '!=';
MAYORIGUAL : '>=';
MENORIGUAL : '<=';

// --------------------------------------------------------------------
// Tipos de datos y literales
NUM        : DIGITO+ ('.' DIGITO+)?;
STRING     : '"' (~["\r\n])* '"';
ID         : [a-zA-Z_][a-zA-Z_0-9]*;

// 🔹 [3] Literales booleanos
VERDADERO  : 'verdadero';
FALSO      : 'falso';

// --------------------------------------------------------------------
// Comentarios y espacios
COMENTARIO : '#' ~[\r\n]*;
WS         : [ \t\r\n]+ -> skip;

// --------------------------------------------------------------------
// Fragmentos auxiliares
fragment DIGITO : [0-9];

// ====================================================================
// FIN DE LA GRAMÁTICA
// ====================================================================
