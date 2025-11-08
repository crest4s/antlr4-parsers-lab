grammar IKEA;

@header { package ikea; }

// =======================================================
//  REGLAS PRINCIPALES
// =======================================================
manual
    : itemHeader instruction+ FIN EOF
    ;

itemHeader
    : ITEM ID
    ;

instruction
    : INT '-' stepList ('.' stepList)* '.'
    ;

stepList
    : step (';' step)*
    ;

// =======================================================
//  PASOS / ACCIONES
// =======================================================
step
    : unir                      #accionUnir
    | colocar                   #accionColocar
    | atornillar                #accionAtornillar
    | insertar                  #accionInsertar
    | clavar                    #accionClavar
    | marcar                    #accionMarcar
    | desplegar                 #accionDesplegar
    | deslizar                  #accionDeslizar
    | sacar                     #accionSacar
    | conHerramienta (atornillar | clavar | insertar | colocar) #accionConHerramienta
    | girar                     #accionGirar
    | voltear                   #accionVoltear
    | nivelar                   #accionNivelar
    | repetir                   #accionRepetir
    | fijar                     #accionFijar
    ;

// =======================================================
//  DEFINICIÓN DE ACCIONES
// =======================================================
unir
    : 'Unir' listaPiezas
    ;

colocar
    : 'Colocar' (listaComponentes | listaPiezas)
      ('en' (piezaConZona | listaPiezas | zona))?
    ;

fijar
    : 'Fijar' 'en' zona
    ;

atornillar
    : ('Atornillar' | 'atornillar')
      listaComponentes ('en' (piezaConZona | listaPiezas | zona))?
    ;

insertar
    : ('Insertar' | 'insertar')
      listaComponentes ('en' (piezaConZona | listaPiezas | zona))?
    ;

clavar
    : ('Clavar' | 'clavar')
      listaComponentes ('en' (piezaConZona | listaPiezas | zona))?
    ;

marcar
    : 'Marcar' 'con' herramienta 'en' (listaPiezas | zona)
    ;

desplegar
    : 'Desplegar' pieza
    ;

deslizar
    : 'Deslizar' pieza 'en' zona
    ;

sacar
    : 'Sacar' (pieza | ID)
    ;

nivelar
    : 'Nivelar'
    ;

conHerramienta
    : 'Con' herramienta ','
    ;

girar
    : 'Girar' direccion
    ;

voltear
    : 'Voltear'
    ;

repetir
    : 'Repetir' '(' paso=INT ')' (X veces=INT)?
    ;

// =======================================================
//  COMPONENTES Y PIEZAS
// =======================================================

componente
    : cantidad? tipo codigo?
    ;

cantidad
    : INT
    ;

codigo
    : INT | ID
    ;

tipo
    : COMPONENTE
    | ID
    ;

COMPONENTE
    : [tT] 'ornillo' 's'?
    | [eE] 'spiga' 's'?
    | [pP] 'laca' 's'?
    | [aA] 'randela' 's'?
    | [eE] 'scuadra' 's'?
    | [sS] 'oporte' 's'?
    | [tT] 'aco' 's'?
    | [lL] 'istón' ('es')?
    | [bB] 'alda' 's'?
    | [tT] 'raviesa' 's'?
    | [pP] 'anel' ('es')?
    ;

listaComponentes
    : componente ( (',' | 'y') componente )*
    ;

// Acepta también nombres de COMPONENTE como nombre de pieza (p.ej. balda)
pieza
    : (INT 'piezas' (ID | COMPONENTE) (ID)* ('en' zona)?)
    | ('pieza' (ID | COMPONENTE) (ID)* ('en' zona)?)
    ;

piezaConZona
    : pieza ('en' zona)?
    ;

listaPiezas
    : pieza ( (',' | 'y') pieza )*
    ;

// 🔧 CAMBIO: permite ID **o** COMPONENTE como zona
zona
    : ID
    | COMPONENTE
    ;

// =======================================================
//  HERRAMIENTAS
// =======================================================
herramienta
    : DESTORNILLADOR
    | MARTILLO
    | LAPIZ
    | LLAVE_ALLEN
    ;

DESTORNILLADOR : [dD] 'estornillador' ;
MARTILLO       : [mM] 'artillo' ;
LAPIZ          : [lL] ('ápiz' | 'apiz') ;
LLAVE_ALLEN    : [lL] 'lave_allen' ;

// =======================================================
//  DIRECCIONES
// =======================================================
direccion
    : ABAJO
    | LATERAL_CORTO
    ;

ABAJO          : 'ABAJO' ;
LATERAL_CORTO  : 'LATERAL_CORTO' ;

// =======================================================
//  TOKENS FINALES
// =======================================================
FIN  : 'FIN' ;
ITEM : 'ITEM:' ;
X    : 'x' ;
INT  : [0-9]+ ;
ID   : [a-zA-Z_áéíóúÁÉÍÓÚñÑ][a-zA-Z_0-9áéíóúÁÉÍÓÚñÑ]* ;
WS   : [ \t\r\n\u00A0\u2000-\u200B\u202F\u205F\u3000\uFEFF\u200C\u200D\u200E\u200F\u2060]+ -> skip ;