grammar IkeaLang;

// === Reglas principales ===

manual         : itemHeader instruction+ FIN EOF ;

itemHeader     : ITEM ID ;

// Una instrucción puede tener varios grupos de pasos separados por punto.
instruction    : INT '-' stepList ('.' stepList)* '.' ;

stepList       : step (';' step)* ;

// === Tipos de pasos ===

step           : unir
               | colocar
               | atornillar
               | conHerramienta atornillar
               | girar
               | voltear
               | repetir
               ;

unir           : 'Unir' pieza 'y' pieza ;
colocar        : 'Colocar' pieza ;
atornillar     : 'atornillar' INT 'tornillos' (INT | ID) ;
conHerramienta : 'Con' herramienta ',' ;

girar          : 'Girar' direccion ;
voltear        : 'Voltear' ;
repetir        : 'Repetir' '(' INT ')' ;

pieza          : 'pieza' ID ;
herramienta    : ID ;
direccion      : ID ;

// === Tokens ===

FIN            : 'FIN' ;
ITEM           : 'ITEM:' ;
INT            : [0-9]+ ;
ID             : [a-zA-Z_][a-zA-Z_0-9]* ;

// Ignorar espacios y saltos de línea
WS             : [ \t\r\n]+ -> skip ;