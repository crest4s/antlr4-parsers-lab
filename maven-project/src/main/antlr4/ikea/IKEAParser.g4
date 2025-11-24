parser grammar IKEAParser;

@header { package ikea; }

options { tokenVocab = IKEALexer; language = Java; }

// =======================================================
//  REGLAS PRINCIPALES
// =======================================================

manual
    : itemHeader instruction+ FIN EOF
    ;

itemHeader
    : ITEM NOMBRE_ITEM
    ;

instruction
    : CANTIDAD_POSITIVA GUION stepList (PUNTO stepList)* PUNTO
    ;

stepList
    : step (PYCOMA step)*
    ;

// =======================================================
//  PASOS / ACCIONES
// =======================================================

step
    : unir                                                     #accionUnir
    | colocar                                                  #accionColocar
    | atornillar                                               #accionAtornillar
    | insertar                                                 #accionInsertar
    | clavar                                                   #accionClavar
    | marcar                                                   #accionMarcar
    | desplegar                                                #accionDesplegar
    | deslizar                                                 #accionDeslizar
    | sacar                                                    #accionSacar
    | conHerramientaAtornillar atornillar                      #accionConHerramientaAtornillar
    | conHerramientaClavar clavar                              #accionConHerramientaClavar
    | girar                                                    #accionGirar
    | voltear                                                  #accionVoltear
    | nivelar                                                  #accionNivelar
    | repetir                                                  #accionRepetir
    | fijar                                                    #accionFijar
    ;

// =======================================================
//  DEFINICIÓN DE ACCIONES
// =======================================================

unir
    : UNIR pieza Y listaPiezasUnir
    ;

listaPiezasUnir
    : pieza ( (COMA | Y) pieza )*
    ;

colocar
    : COLOCAR listaComponentes (EN (listaPiezas | zona))?
    ;

fijar
    : FIJAR EN zona
    ;

atornillar
    : ATORNILLAR listaTornillos (Y listaComponentesAccesorios)? (EN (listaPiezas | zona))?
    ;

listaComponentesAccesorios
    : componenteAccesorio ( (COMA | Y) componenteAccesorio )*
    ;

componenteAccesorio
    : CANTIDAD_POSITIVA (ESCUADRA | ARANDELA | PLACA) numero
    ;

listaTornillos
    : tornillo ( (COMA | Y) tornillo )*
    ;

tornillo
    : CANTIDAD_POSITIVA TORNILLO numero
    ;

numero
    : CANTIDAD_POSITIVA
    | INT
    ;

insertar
    : INSERTAR listaEspigas (EN (listaPiezas | zona))?
    ;

listaEspigas
    : espiga ( (COMA | Y) espiga )*
    ;

espiga
    : CANTIDAD_POSITIVA ESPIGA numero
    ;

clavar
    : CLAVAR listaClavos (EN (listaPiezas | zona))?
    ;

listaClavos
    : clavo ( (COMA | Y) clavo )*
    ;

clavo
    : CANTIDAD_POSITIVA CLAVO numero
    ;

marcar
    : MARCAR CON LAPIZ EN (listaPiezas | zona)
    ;

desplegar
    : DESPLEGAR pieza
    ;

deslizar
    : DESLIZAR pieza EN zona
    ;

sacar
    : SACAR (pieza | NOMBRE_PIEZA)
    ;

nivelar
    : NIVELAR
    ;

conHerramientaAtornillar
    : CON (DESTORNILLADOR | LLAVE_ALLEN) COMA
    ;

conHerramientaClavar
    : CON MARTILLO COMA
    ;

conHerramienta
    : CON herramienta COMA
    ;

girar
    : GIRAR direccion
    ;

voltear
    : VOLTEAR
    ;

repetir
    : REPETIR PARENIZQ paso=CANTIDAD_POSITIVA PARENDER (X veces=CANTIDAD_POSITIVA)?
    ;

// =======================================================
//  COMPONENTES Y PIEZAS
// =======================================================

componente
    : CANTIDAD_POSITIVA tipo numero
    ;

cantidad
    : CANTIDAD_POSITIVA
    ;

codigo
    : numero
    ;

tipo
    : TORNILLO
    | ESPIGA
    | CLAVO
    | PLACA
    | PLACAS_METAL
    | ARANDELA
    | ESCUADRA
    | SOPORTE
    | TACO
    | PEGATINA
    | PEGATINAS_ANTIDESLIZANTES
    | EMBELLECEDOR
    | LISTON
    | BALDA
    | TRAVIESA
    | TRAVESANO
    | PANEL
    | NOMBRE_PIEZA
    ;

listaComponentes
    : componente ( (COMA | Y) componente )*
    ;

pieza
    : (CANTIDAD_POSITIVA PIEZA nombrePieza (EN zona)?)
    | (PIEZA nombrePieza (EN zona)?)
    ;

nombrePieza
    : NOMBRE_PIEZA
    | BALDA
    | LISTON
    | TRAVIESA
    | TRAVESANO
    | PANEL
    ;

listaPiezas
    : pieza ( (COMA | Y) pieza )*
    ;

zona
    : NOMBRE_PIEZA
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

// =======================================================
//  DIRECCIONES
// =======================================================

direccion
    : ABAJO
    | LATERAL_CORTO
    | ARRIBA
    | LATERAL_LARGO
    ;