grammar CSV;

// ---- Parser ----
file
  : record (NL record)* NL? EOF
  ;

record
  : field (SEP field)*
  ;

field
  : STRING              # quoted
  | UNQUOTED            # plain
  |                     # empty
  ;

// ---- Lexer ----
SEP       : [;,|] ;
STRING    : '"' ('""' | ~["\r\n])* '"' ;
UNQUOTED  : ~[",;\|\r\n]+ ;
NL        : '\r'? '\n' ;
WS        : [ \t]+ -> skip ;