grammar IKEA;

// -------- Parser --------
program
  : header? toolsDecl? stepDecl+ EOF
  ;

header
  : 'modelo' NAME ';'
  ;

toolsDecl
  : 'herramientas' ':' toolItem (',' toolItem)* ';'
  ;

stepDecl
  : 'paso' INT ':' instr (',' instr)* ';'            # simpleStep
  | 'opcion' NAME '{' stepDecl+ '}'                  # optionBlock
  ;

instr
  : action obj (prep obj)*                           # genericInstr
  ;

action
  : 'usar' | 'fijar' | 'atornillar' | 'encajar' | 'pegar'
  | 'colgar' | 'montar' | 'girar' | 'alinear' | 'insertar'
  ;

obj
  : qty? (hardware | piece | toolItem | NAME | STRING)
  ;

qty       : INT 'x' ;
prep      : 'en' | 'a' | 'con' | 'sobre' | 'entre' ;

hardware
  : H_TORNILLO
  | H_ESPIGA
  | H_TACO
  | H_BISAGRA
  | H_PERNO
  | H_MINIFIX
  | H_SOPORTE
  | H_PATAS
  | H_TIRADOR
  ;

toolItem
  : T_DESTORNILLADOR
  | T_MARTILLO
  | T_ALLEN
  | T_TALADRO
  | T_NIVEL
  | T_METRO
  | T_LAPIZ
  | NAME
  ;

piece
  : 'pieza' NAME                // p.ej. pieza A, pieza LADO-IZQ
  | 'tablero' NAME
  | 'panel' NAME
  | 'estante' NAME
  | 'trasera' NAME
  ;

// -------- Lexer --------
NAME      : [a-zA-Z0-9_][a-zA-Z0-9_\-]* ;
INT       : [0-9]+ ;
STRING    : '"' ('\\"' | ~["\r\n])* '"' ;

H_TORNILLO: 'tornillo' ;
H_ESPIGA  : 'espiga' ;
H_TACO    : 'taco' ;
H_BISAGRA : 'bisagra' ;
H_PERNO   : 'perno' ;
H_MINIFIX : 'minifix' ;
H_SOPORTE : 'soporte' ;
H_PATAS   : 'pata' | 'patas' ;
H_TIRADOR : 'tirador' ;

T_DESTORNILLADOR : 'destornillador' ;
T_MARTILLO       : 'martillo' ;
T_ALLEN          : 'llave-allen' | 'allen' ;
T_TALADRO        : 'taladro' ;
T_NIVEL          : 'nivel' ;
T_METRO          : 'metro' ;
T_LAPIZ          : 'lapiz' | 'lápiz' ;

NL        : '\r'? '\n' ;
LINE_COMMENT
          : '#' ~[\r\n]* NL -> skip
          ;
WS        : [ \t]+ -> skip ;