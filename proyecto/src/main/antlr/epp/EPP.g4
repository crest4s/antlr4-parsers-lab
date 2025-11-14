grammar EPP;

@header {
package epp; // Define el paquete Java donde se generará el código
}

// --------------------------------------------------------------------
// PARSER
// --------------------------------------------------------------------

/*
 * Regla principal que representa un programa completo.
 * Un programa puede contener múltiples instrucciones o comentarios,
 * y termina con el final del archivo (EOF).
 */
programa
    : (instruccion | comentario)* EOF
    ;

/*
 * Regla que define las posibles instrucciones en el programa.
 * Las instrucciones pueden ser asignaciones, mostrar valores,
 * condicionales, leer valores o bucles mientras.
 */
instruccion
    : asignacion
    | mostrar
    | condicional
    | leer
    | mientras
    ;

/*
 * Regla para la instrucción de asignación.
 * Permite asignar un valor a una variable usando la palabra clave 'asignar'
 * o directamente con el operador '='.
 * Ejemplo: asignar x = 5;P
 */
asignacion
    : ('asignar' ID '=' expresion
     | ID '=' expresion
     ) FINLINEA
    ;

/*
 * Regla para la instrucción de mostrar.
 * Permite imprimir una expresión en la salida.
 * Ejemplo: mostrar "Hola, mundo";P
 */
mostrar
    : 'mostrar' expresion FINLINEA
    ;

/*
 * Regla para la instrucción de leer.
 * Permite leer un valor y asignarlo a una variable.
 * Ejemplo: leer x;P
 */
leer
    : 'leer' ID FINLINEA
    ;

/*
 * Regla para la instrucción mientras.
 * Define un bucle que se ejecuta mientras una expresión sea verdadera.
 * Ejemplo:
 * mientras x < 10 ->
 *   mostrar x;P
 * terminar
 */
mientras
    : 'mientras' expresion '->' bloque 'terminar'
    ;

/*
 * Regla para la instrucción condicional.
 * Permite ejecutar un bloque de código si una expresión es verdadera,
 * con una opción para un bloque alternativo si es falsa.
 * Ejemplo:
 * x > 5 si ->
 *   mostrar "Mayor";P
 * no ->
 *   mostrar "Menor o igual";P
 * terminar
 */
condicional
    : expresion CONDICION 'si' '->' bloque
      ('no' '->' bloque)?
      'terminar'
    ;

/*
 * Regla para un bloque de código.
 * Un bloque puede contener múltiples instrucciones o comentarios.
 */
bloque
    : (instruccion | comentario)*
    ;

/*
 * Regla para los comentarios.
 * Los comentarios comienzan con '#' y terminan al final de la línea.
 * Ejemplo: # Esto es un comentario
 */
comentario
    : COMENTARIO
    ;

// --------------------------------------------------------------------
// EXPRESIONES (con precedencia y sin etiquetas artificiales)
// --------------------------------------------------------------------

/*
 * Regla para las expresiones.
 * Define las operaciones permitidas, como comparaciones, operaciones
 * aritméticas, uso de paréntesis, variables, números, cadenas y valores
 * booleanos.
 */
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

/*
 * Regla para los operadores de comparación.
 * Incluye operadores como >, <, ==, !=, >=, <=.
 */
operadorComparacion
    : MAYOR | MENOR | IGUAL | DIFERENTE | MAYORIGUAL | MENORIGUAL
    ;

/*
 * Regla para los operadores aditivos.
 * Incluye suma (+) y resta (-).
 */
operadorAditivo
    : MAS | MENOS
    ;

/*
 * Regla para los operadores multiplicativos.
 * Incluye multiplicación (*), división (/) y módulo (%).
 */
operadorMultiplicativo
    : POR | DIV | MOD
    ;

// --------------------------------------------------------------------
// LEXER
// --------------------------------------------------------------------

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

/*
 * Token para identificadores.
 * Representa nombres de variables o funciones.
 * Ejemplo: miVariable, suma1
 */
ID         : [a-zA-Z_][a-zA-Z_0-9]*;

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
