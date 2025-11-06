// CSV.g4
// Gramática CSV para ANTLR4
// - Separadores admitidos: ',', ';', '|'
// - Campos: sin comillas o entrecomillados
// - Comillas escapadas dentro de campo entrecomillado: ""
// - Campos vacíos permitidos
// - Saltos de línea: \n, \r\n, \r
// - No se recortan espacios: los espacios forman parte del contenido del campo
//   (si quieres recortar, hazlo en el visitor/listener)

grammar CSV;

// ---------- Reglas del parser ----------

csv
  : fila (NL fila)* NL? EOF
  ;

fila
  : campo (SEPARADOR campo)*        // a,b,,c
  | (SEPARADOR campo)+              // ,a,,b
  ;

campo
  : QUOTED                         // "texto, con separador"
  | TEXTO                          // texto sin comillas
  |                                // campo vacío (por ejemplo ;; o al final ;)
  ;

// ---------- Reglas del lexer ----------

// SEPARADOR permite coma, punto y coma o barra vertical
SEPARADOR : [;,|];

// Campo entrecomillado:
//   - Empieza y termina con "
//   - Permite cualquier carácter excepto salto de línea
//   - Permite comillas escapadas como ""
QUOTED
  : '"' ( '""' | ~["\r\n] )* '"'
  ;

// Texto sin comillas:
//   - Cualquier cosa que NO sea separador, comillas o salto de línea
//   - Incluye espacios y tabuladores, que se conservan
TEXTO
  : ~[;\r\n,|"]+
  ;

// Saltos de línea aceptados: \n, \r\n o \r
NL
  : '\r'? '\n'
  | '\r'
  ;

// No ignoramos espacios globalmente para no perderlos dentro de TEXTO.
// Si quieres permitir espacios *entre* campos sin que cuenten,
// puedes crear un token SPACES y referenciarlo opcionalmente en la regla `fila`
// alrededor de SEPARADOR, pero por simplicidad y fidelidad al CSV estándar
// los tratamos como parte del contenido del campo.