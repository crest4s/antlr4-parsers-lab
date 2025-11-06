grammar IkeaLang;

// === Reglas principales ===

manual         : itemHeader instruction+ FIN EOF ;

itemHeader     : ITEM ID ;

instruction    : INT '-' stepList ('.' stepList)* '.' ;

stepList       : step (';' step)* ;

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

// === PIEZA: palabra clave + identificador de posición ===

pieza          : 'pieza' ID ;

// === Herramientas y direcciones como tokens fijos ===

herramienta    : DESTORNILLADOR ;
direccion      : ABAJO | LATERAL_CORTO ;

// === Tokens fijos ===

FIN            : 'FIN' ;
ITEM           : 'ITEM:' ;

DESTORNILLADOR : 'destornillador' ;

ABAJO          : 'ABAJO' ;
LATERAL_CORTO  : 'LATERAL_CORTO' ;

// === Tokens generales ===

INT            : [0-9]+ ;
ID             : [a-zA-Z_][a-zA-Z_0-9]* ;
WS             : [ \t\r\n]+ -> skip ;