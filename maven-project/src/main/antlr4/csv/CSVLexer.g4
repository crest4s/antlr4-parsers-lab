lexer grammar CSVLexer;

@header {
package csv; // Define el paquete Java donde se generará el código
}

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