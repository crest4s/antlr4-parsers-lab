lexer grammar IKEALexer;

@header { package ikea; }

// ---------------------- PALABRAS CLAVE ----------------------

UNIR       : 'Unir';
COLOCAR    : 'Colocar';
EN         : 'en';
FIJAR      : 'Fijar';
ATORNILLAR : 'Atornillar' | 'atornillar';
INSERTAR   : 'Insertar' | 'insertar';
CLAVAR     : 'Clavar' | 'clavar';
MARCAR     : 'Marcar';
CON        : 'Con' | 'con';
DESPLEGAR  : 'Desplegar';
DESLIZAR   : 'Deslizar';
SACAR      : 'Sacar';
NIVELAR    : 'Nivelar';
GIRAR      : 'Girar';
VOLTEAR    : 'Voltear';
REPETIR    : 'Repetir';
PIEZA      : 'pieza';

// ---------------------- SÍMBOLOS ----------------------

GUION      : '-';
PUNTO      : '.';
PYCOMA     : ';';
COMA       : ',';
Y          : 'y';
PARENIZQ   : '(';
PARENDER   : ')';

// ---------------------- COMPONENTES ESPECÍFICOS ----------------------

// Tokens compuestos más específicos primero
PEGATINAS_ANTIDESLIZANTES : 'pegatinas_antideslizantes';
PLACAS_METAL : 'placas_metal';

// Componentes (siempre en singular para simplicidad)
TORNILLO   : 'tornillo';
ESPIGA     : 'espiga';
CLAVO      : 'clavo';
PLACA      : 'placa';
ARANDELA   : 'arandela';
ESCUADRA   : 'escuadra';
SOPORTE    : 'soporte';
TACO       : 'taco';
PEGATINA   : 'pegatina';
EMBELLECEDOR  : 'embellecedor';

// Otros componentes genéricos (singular)
LISTON     : 'listón' | 'liston';
BALDA      : 'balda';
TRAVIESA   : 'traviesa';
TRAVESANO  : 'travesaño';
PANEL      : 'panel';

// ---------------------- HERRAMIENTAS ----------------------

DESTORNILLADOR : 'destornillador' ;
MARTILLO       : 'martillo' ;
LAPIZ          : 'lápiz' | 'lapiz' ;
LLAVE_ALLEN    : 'llave_allen' ;

// ---------------------- DIRECCIONES ----------------------

ABAJO         : 'ABAJO';
LATERAL_CORTO : 'LATERAL_CORTO';
ARRIBA        : 'ARRIBA';
LATERAL_LARGO : 'LATERAL_LARGO';

// ---------------------- TOKENS GENERALES ------------------

FIN  : 'FIN';
ITEM : 'ITEM:';
X    : 'x';

// Cantidad positiva (excluye 0) - para componentes y pasos
// Debe ir ANTES de INT para tener prioridad en el lexer
CANTIDAD_POSITIVA : [1-9][0-9]*;

// Número entero (solo para casos específicos donde se permita 0)
INT  : [0-9]+;

// Nombres de piezas o zonas (deben incluir guion bajo)
NOMBRE_PIEZA : [a-z_áéíóúÁÉÍÓÚñÑ][a-z_0-9áéíóúÁÉÍÓÚñÑ]* ;

// Nombre de item (mayúsculas con guion bajo)
NOMBRE_ITEM : [A-Z_][A-Z_0-9]* ;

// ---------------------- ESPACIOS --------------------------

WS : [ \t\r\n\u00A0\u2000-\u200B\u202F\u205F\u3000\uFEFF\u200C\u200D\u200E\u200F\u2060]+ -> skip ;