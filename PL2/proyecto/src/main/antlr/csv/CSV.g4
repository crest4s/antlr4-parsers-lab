// CSV.g4
// Gramática CSV para ANTLR4
// Esta gramática define las reglas para analizar archivos CSV con las siguientes características:
// - Separadores admitidos: ',', ';', '|'
// - Campos: pueden estar sin comillas, entrecomillados o vacíos
// - Comillas escapadas dentro de campos entrecomillados: ""
// - Campos vacíos permitidos
// - Saltos de línea admitidos: \n, \r\n, \r
// - Los espacios no se recortan automáticamente; forman parte del contenido del campo
//   (si se desea recortar, debe hacerse en el visitor o listener correspondiente)

grammar CSV;

@header {
package csv; // Define el paquete Java donde se generará el código
}

// ---------- Reglas del parser ----------

// Regla principal que representa un archivo CSV completo
csv
  : fila (NL fila)* NL? EOF // Un archivo CSV contiene una o más filas, separadas por saltos de línea
  ;

// Regla que define una fila en el archivo CSV
fila
  : campo (SEPARADOR campo)*        // Una fila con campos separados por un delimitador (ejemplo: a,b,,c)
  | (SEPARADOR campo)+              // Una fila que comienza con uno o más delimitadores (ejemplo: ,a,,b)
  ;

// Regla que define un campo en una fila
campo
  : QUOTED                         // Campo entrecomillado (ejemplo: "texto, con separador")
  | TEXTO                          // Campo sin comillas (ejemplo: texto sin comillas)
  |                                // Campo vacío (ejemplo: ;; o al final de una fila ;)
  ;

// ---------- Reglas del lexer ----------

// Token que define los separadores permitidos: coma, punto y coma o barra vertical
SEPARADOR : [;,|];

// Token que define un campo entrecomillado:
// - Empieza y termina con comillas dobles (")
// - Permite cualquier carácter excepto saltos de línea
// - Permite comillas escapadas representadas como ""
QUOTED
  : '"' ( '""' | ~["\r\n] )* '"'
  ;

// Token que define un campo sin comillas:
// - Contiene cualquier carácter que no sea un separador, comillas o salto de línea
// - Incluye espacios y tabuladores, que se conservan como parte del contenido
TEXTO
  : ~[;\r\n,|"]+
  ;

// Token que define los saltos de línea admitidos:
// - \n (Unix), \r\n (Windows) o \r (antiguo Mac)
NL
  : '\r'? '\n'
  | '\r'
  ;