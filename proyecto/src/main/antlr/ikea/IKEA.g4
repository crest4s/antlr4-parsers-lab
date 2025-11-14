grammar IKEA;

@header { package ikea; }

// =======================================================
//  REGLAS PRINCIPALES
// =======================================================

/*
 * Regla principal que representa un manual completo.
 * Un manual contiene un encabezado de ítem, una o más instrucciones,
 * y termina con el token FIN seguido del final del archivo (EOF).
 */
manual
    : itemHeader instruction+ FIN EOF
    ;

/*
 * Regla que define el encabezado de un ítem.
 * Un encabezado está compuesto por el token ITEM seguido de un identificador (ID).
 */
itemHeader
    : ITEM ID
    ;

/*
 * Regla que define una instrucción.
 * Una instrucción comienza con un número entero (INT), seguido de una lista de pasos
 * separados por guiones y puntos.
 */
instruction
    : INT '-' stepList ('.' stepList)* '.'
    ;

/*
 * Regla que define una lista de pasos.
 * Una lista de pasos contiene uno o más pasos separados por punto y coma (';').
 */
stepList
    : step (';' step)*
    ;

// =======================================================
//  PASOS / ACCIONES
// =======================================================

/*
 * Regla que define un paso.
 * Un paso puede ser una de las acciones especificadas, como unir, colocar, atornillar, etc.
 * También puede incluir acciones realizadas con herramientas.
 */
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

/*
 * Regla para la acción "unir".
 * Permite unir una lista de piezas.
 */
unir
    : 'Unir' listaPiezas
    ;

/*
 * Regla para la acción "colocar".
 * Permite colocar una lista de componentes o piezas, opcionalmente en una zona específica.
 */
colocar
    : 'Colocar' (listaComponentes | listaPiezas)
      ('en' (piezaConZona | listaPiezas | zona))?
    ;

/*
 * Regla para la acción "fijar".
 * Permite fijar algo en una zona específica.
 */
fijar
    : 'Fijar' 'en' zona
    ;

/*
 * Regla para la acción "atornillar".
 * Permite atornillar una lista de componentes, opcionalmente en una zona específica.
 */
atornillar
    : ('Atornillar' | 'atornillar')
      listaComponentes ('en' (piezaConZona | listaPiezas | zona))?
    ;

/*
 * Regla para la acción "insertar".
 * Permite insertar una lista de componentes, opcionalmente en una zona específica.
 */
insertar
    : ('Insertar' | 'insertar')
      listaComponentes ('en' (piezaConZona | listaPiezas | zona))?
    ;

/*
 * Regla para la acción "clavar".
 * Permite clavar una lista de componentes, opcionalmente en una zona específica.
 */
clavar
    : ('Clavar' | 'clavar')
      listaComponentes ('en' (piezaConZona | listaPiezas | zona))?
    ;

/*
 * Regla para la acción "marcar".
 * Permite marcar con una herramienta en una lista de piezas o en una zona específica.
 */
marcar
    : 'Marcar' 'con' herramienta 'en' (listaPiezas | zona)
    ;

/*
 * Regla para la acción "desplegar".
 * Permite desplegar una pieza específica.
 */
desplegar
    : 'Desplegar' pieza
    ;

/*
 * Regla para la acción "deslizar".
 * Permite deslizar una pieza en una zona específica.
 */
deslizar
    : 'Deslizar' pieza 'en' zona
    ;

/*
 * Regla para la acción "sacar".
 * Permite sacar una pieza o un identificador (ID).
 */
sacar
    : 'Sacar' (pieza | ID)
    ;

/*
 * Regla para la acción "nivelar".
 * Permite nivelar algo.
 */
nivelar
    : 'Nivelar'
    ;

/*
 * Regla para la acción "con herramienta".
 * Define el uso de una herramienta para realizar una acción específica.
 */
conHerramienta
    : 'Con' herramienta ','
    ;

/*
 * Regla para la acción "girar".
 * Permite girar en una dirección específica.
 */
girar
    : 'Girar' direccion
    ;

/*
 * Regla para la acción "voltear".
 * Permite voltear algo.
 */
voltear
    : 'Voltear'
    ;

/*
 * Regla para la acción "repetir".
 * Permite repetir un paso un número específico de veces.
 */
repetir
    : 'Repetir' '(' paso=INT ')' (X veces=INT)?
    ;

// =======================================================
//  COMPONENTES Y PIEZAS
// =======================================================

/*
 * Regla que define un componente.
 * Un componente puede incluir una cantidad, un tipo y un código opcional.
 */
componente
    : cantidad? tipo codigo?
    ;

/*
 * Regla que define la cantidad de un componente.
 * Representada por un número entero (INT).
 */
cantidad
    : INT
    ;

/*
 * Regla que define el código de un componente.
 * Puede ser un número entero (INT) o un identificador (ID).
 */
codigo
    : INT | ID
    ;

/*
 * Regla que define el tipo de un componente.
 * Puede ser un token COMPONENTE o un identificador (ID).
 */
tipo
    : COMPONENTE
    | ID
    ;

/*
 * Token que define los tipos de componentes permitidos.
 * Incluye términos como tornillos, espigas, baldas, etc.
 */
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

/*
 * Regla que define una lista de componentes.
 * Los componentes pueden estar separados por comas o la palabra "y".
 */
listaComponentes
    : componente ( (',' | 'y') componente )*
    ;

/*
 * Regla que define una pieza.
 * Una pieza puede incluir un número, un tipo y una zona opcional.
 */
pieza
    : (INT 'piezas' (ID | COMPONENTE) (ID)* ('en' zona)?)
    | ('pieza' (ID | COMPONENTE) (ID)* ('en' zona)?)
    ;

/*
 * Regla que define una pieza con una zona específica.
 */
piezaConZona
    : pieza ('en' zona)?
    ;

/*
 * Regla que define una lista de piezas.
 * Las piezas pueden estar separadas por comas o la palabra "y".
 */
listaPiezas
    : pieza ( (',' | 'y') pieza )*
    ;

/*
 * Regla que define una zona.
 * Una zona puede ser un identificador (ID) o un componente (COMPONENTE).
 */
zona
    : ID
    | COMPONENTE
    ;

// =======================================================
//  HERRAMIENTAS
// =======================================================

/*
 * Regla que define una herramienta.
 * Incluye herramientas como destornillador, martillo, lápiz y llave Allen.
 */
herramienta
    : DESTORNILLADOR
    | MARTILLO
    | LAPIZ
    | LLAVE_ALLEN
    ;

/*
 * Token que define un destornillador.
 * Puede comenzar con mayúscula o minúscula.
 */
DESTORNILLADOR : [dD] 'estornillador' ;

/*
 * Token que define un martillo.
 * Puede comenzar con mayúscula o minúscula.
 */
MARTILLO       : [mM] 'artillo' ;

/*
 * Token que define un lápiz.
 * Puede comenzar con mayúscula o minúscula.
 */
LAPIZ          : [lL] ('ápiz' | 'apiz') ;

/*
 * Token que define una llave Allen.
 * Puede comenzar con mayúscula o minúscula.
 */
LLAVE_ALLEN    : [lL] 'lave_allen' ;

// =======================================================
//  DIRECCIONES
// =======================================================

/*
 * Regla que define una dirección.
 * Incluye direcciones como abajo, lateral corto, arriba y lateral largo.
 */
direccion
    : ABAJO
    | LATERAL_CORTO
    | ARRIBA
    | LATERAL_LARGO
    ;

/*
 * Token que define la dirección "abajo".
 */
ABAJO          : 'ABAJO' ;

/*
 * Token que define la dirección "lateral corto".
 */
LATERAL_CORTO  : 'LATERAL_CORTO' ;

/*
 * Token que define la dirección "arriba".
 */
ARRIBA         : 'ARRIBA' ;

/*
 * Token que define la dirección "lateral largo".
 */
LATERAL_LARGO  : 'LATERAL_LARGO' ;

// =======================================================
//  TOKENS FINALES
// =======================================================

/*
 * Token que define el final de un manual.
 */
FIN  : 'FIN' ;

/*
 * Token que define el encabezado de un ítem.
 */
ITEM : 'ITEM:' ;

/*
 * Token que define el carácter "x".
 */
X    : 'x' ;

/*
 * Token que define un número entero.
 */
INT  : [0-9]+ ;

/*
 * Token que define un identificador.
 * Puede incluir letras, números y caracteres especiales como tildes.
 */
ID   : [a-zA-Z_áéíóúÁÉÍÓÚñÑ][a-zA-Z_0-9áéíóúÁÉÍÓÚñÑ]* ;

/*
 * Token que define espacios en blanco.
 * Incluye espacios, tabulaciones y saltos de línea, que se ignoran durante el análisis.
 */
WS   : [ \t\r\n\u00A0\u2000-\u200B\u202F\u205F\u3000\uFEFF\u200C\u200D\u200E\u200F\u2060]+ -> skip ;