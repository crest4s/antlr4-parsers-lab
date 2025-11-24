parser grammar CSVParser;

@header { package csv; }

options { tokenVocab = CSVLexer; language = Java; }

// ---------- Reglas del parser ----------

// Regla principal que representa un archivo CSV completo
csv
  : fila (NL fila)* NL? EOF // Un archivo CSV contiene una o más filas, separadas por saltos de línea
  ;

// Regla que define una fila en el archivo CSV
fila
  : campo (SEPARADOR campo)*        // Una fila con campos separados por un delimitador (ejemplo: a,b,,c)
  ;

// Regla que define un campo en una fila
campo
  : QUOTED                         // Campo entrecomillado (ejemplo: "texto, con separador")
  | TEXTO                          // Campo sin comillas (ejemplo: texto sin comillas)
  |                                // Campo vacío (ejemplo: ;; o al final de una fila ;)
  ;