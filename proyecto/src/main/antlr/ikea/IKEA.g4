grammar IKEA;
@header {
package ikea;
}

// === Reglas principales ===

manual         : itemHeader instruction+ FIN EOF ;

itemHeader     : ITEM ID ;

instruction    : INT '-' stepList ('.' stepList)* '.' ;

stepList       : step (';' step)* ;

step           : unir
               | colocar
               | atornillar
               | insertar
               | clavar
               | marcar
               | desplegar
               | deslizar
               | sacar
               | conHerramienta (atornillar | clavar | insertar | colocar)
               | girar
               | voltear
               | nivelar
               | repetir
               | fijar
               ;

// === Reglas de acciones ===

// 'Unir' admite cualquier combinación de piezas separadas por comas o 'y'
unir           : 'Unir' listaPiezas ;

// colocar admite colocar piezas o componentes en piezas o zonas, y soporta anidación de 'en'
colocar        : 'Colocar' (listaComponentes | listaPiezas) ( 'en' (piezaConZona | listaPiezas | zona) )? ;

// fijar siempre va seguido de 'en' + zona
fijar          : 'Fijar' 'en' zona ;

// atornillar/insertar/clavar con múltiples componentes y ubicaciones/zona, admiten anidación de 'en'
atornillar     : 'atornillar' listaComponentes ( 'en' (piezaConZona | listaPiezas | zona) )? ;
insertar       : 'Insertar'  listaComponentes ( 'en' (piezaConZona | listaPiezas | zona) )? ;
clavar         : 'clavar'    listaComponentes ( 'en' (piezaConZona | listaPiezas | zona) )? ;

// acciones adicionales
marcar         : 'Marcar' 'con' herramienta 'en' (listaPiezas | zona) ;
desplegar      : 'Desplegar' pieza ;
deslizar       : 'Deslizar' pieza 'en' zona ;
sacar          : 'Sacar' (pieza | ID) ;
nivelar        : 'Nivelar' ;

conHerramienta : 'Con' herramienta ',' ;

girar          : 'Girar' direccion ;
voltear        : 'Voltear' ;

// === Repetir con referencia de paso y número de repeticiones ===
repetir        : 'Repetir' '(' paso=INT ')' ( X veces=INT )? ;

// === COMPONENTES Y PIEZAS ===

componente      : (INT)? tipo (INT | ID)? ;
// tipo ahora admite identificadores generales (ej: pegatinas_antideslizantes, placas_metal, etc.)
tipo            : ID ;

// listas más estrictas: comas o 'y' opcionales
listaComponentes : componente ( (',' | 'y') componente )* ;

// PIEZA con cantidad opcional y posible zona interna anidada
pieza          : (INT 'piezas' ID (ID)* ('en' zona)?) | ('pieza' ID (ID)* ('en' zona)?) ;
piezaConZona   : pieza ('en' zona)? ;

// lista de piezas: admite comas o 'y' sin ambigüedad
listaPiezas    : pieza ( (',' | 'y') pieza )* ;

// === ZONAS ===

zona           : ID ;

// === Herramientas y direcciones como tokens fijos ===

herramienta    : DESTORNILLADOR | MARTILLO | LAPIZ | LLAVE_ALLEN ;
direccion      : ABAJO | LATERAL_CORTO ;

// === Tokens fijos ===

FIN            : 'FIN' ;
ITEM           : 'ITEM:' ;

DESTORNILLADOR : 'destornillador' ;
MARTILLO       : 'martillo' ;
LAPIZ          : 'lápiz' | 'lapiz' ;
LLAVE_ALLEN    : 'llave_allen' ;

ABAJO          : 'ABAJO' ;
LATERAL_CORTO  : 'LATERAL_CORTO' ;

X              : 'x' ;

// === Tokens generales ===

INT            : [0-9]+ ;
ID             : [a-zA-Z_áéíóúÁÉÍÓÚñÑ][a-zA-Z_0-9áéíóúÁÉÍÓÚñÑ]* ;
// Espacios ampliados para aceptar todos los tipos de espacio Unicode y BOM ocultos
WS             : [ \t\r\n\u00A0\u2000-\u200B\u202F\u205F\u3000\uFEFF\u200C\u200D\u200E\u200F\u2060]+ -> skip ;
