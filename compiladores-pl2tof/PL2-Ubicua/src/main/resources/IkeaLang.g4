grammar IkeaLang;

assembly: header? step+ 'FIN' EOF;
header: 'ITEM:' ID;
step: NUMBER '-' action ('.' | ';')?;
action: (phrase (CONNECTOR phrase)*)+;
phrase: (COMMAND object) (','? toolPhrase)? (','? hardwarePhrase)?;
toolPhrase: 'con' TOOL;
hardwarePhrase: 'atornillar' NUMBER 'tornillos' HARDWARE | 'usando' HARDWARE (',' HARDWARE)*;
object: ID;
CONNECTOR: (';' | 'y' | 'Y' | '.') -> skip;
COMMAND: 'Unir' | 'Colocar' | 'Girar' | 'Repetir' | 'Voltear' | 'Atornillar' | 'atornillar';
TOOL: 'destornillador' | 'martillo' | 'llave' | 'taladro';
HARDWARE: [0-9]+;
NUMBER: [0-9]+;
ID: [A-Za-z_][A-Za-z0-9_]*;
WS: [ \t\r\n]+ -> skip;