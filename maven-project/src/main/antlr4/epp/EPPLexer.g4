lexer grammar EPPLexer;

@header {
package epp;
}
// --------------------------------------------------------------------
// LEXER
// --------------------------------------------------------------------

// Palabras clave
ASIGNAR   : 'asignar';
MOSTRAR   : 'mostrar';
LEER      : 'leer';
MIENTRAS  : 'mientras';
PARA      : 'para';
DESDE     : 'desde';
HASTA     : 'hasta';
PASO      : 'paso';
SI        : 'si';
NO        : 'no';
TERMINAR  : 'terminar';

// Símbolos
FLECHA    : '->';
PARENIZQ  : '(';
PARENDER  : ')';
ASIGNACION: '=';

/*
 * Token para condiciones en estructuras como 'si'.
 * Representado por '???' en el lenguaje.
 */
CONDICION : '???';

/*
 * Token para el final de una línea de instrucción.
 * Representado por ';P' en el lenguaje.
 */
FINLINEA  : ';P';

// Operadores lógicos
Y_LOGICO  : 'AND';
O_LOGICO  : 'OR';
NO_LOGICO : 'NOT';

// Operadores
MAS        : '+';
MENOS      : '-';
POR        : '*';
DIV        : '/';
MOD        : '%';

// Operadores de comparación

MAYOR      : '>';
MENOR      : '<';
IGUAL      : '==';
DIFERENTE  : '!=';
MAYORIGUAL : '>=';
MENORIGUAL : '<=';

// Tipos de datos

/*
 * Token para números.
 * Puede ser un entero o un número decimal.
 * Ejemplo: 42, 3.14
 */
NUM        : DIGITO+ ('.' DIGITO+)?;

/*
 * Token para cadenas de texto.
 * Las cadenas están delimitadas por comillas dobles.
 * Ejemplo: "Hola, mundo"
 */
STRING     : '"' (~["\r\n])* '"';

// Literales booleanos

/*
 * Token para el valor booleano verdadero.
 * Representado por 'verdadero' en el lenguaje.
 */
VERDADERO  : 'verdadero';

/*
 * Token para el valor booleano falso.
 * Representado por 'falso' en el lenguaje.
 */
FALSO      : 'falso';

/*
 * Token para nombres de variables.
 * Deben empezar con letra minúscula.
 * Ejemplo: contador, suma1, miVariable
 */
VARIABLE   : [a-z][a-zA-Z_0-9]*;

// Comentarios y espacios

/*
 * Token para comentarios.
 * Los comentarios comienzan con '#' y terminan al final de la línea.
 * Ejemplo: # Esto es un comentario
 */
COMENTARIO : '#' ~[\r\n]*;

/*
 * Token para espacios en blanco.
 * Incluye espacios, tabulaciones y saltos de línea.
 * Se ignoran durante el análisis.
 */
WS         : [ \t\r\n]+ -> skip;

// Fragmento auxiliar

/*
 * Fragmento que define un dígito numérico (0-9).
 */
fragment DIGITO : [0-9];