lexer grammar Swift;

tokens {VAR, LET, SEMICOLON, COLON, COMMA, IF, ELSE, ELSE, IF, EQ, NOT, EQ, LESS, MR, LESS, EQ, MR, EQ, OP, ASSIGN,
ASSIGN, PLUS, ASSIGN, MINUS, ASSING, MUL, ASSIGN, DIV, ASSIGN, REM, PLUS, MINUS, MUL, DIV, REM, RLP, RRP, CLB, CRB,
RBRK, LBRK, REPEAT, WHILE, FOR, IN, PRINT, CHARACTER, STRING, INT, BOOL, TRUE, FALSE, EXCLAM, AND, OR, SWITCH, CASE,
DEFAULT, BREAK, CONTINUE, FALLTHROUGH, WHERE, FUNC, RET, RETURN, ID, DEC, DIGIT, STRING, CONST, COMMENT, COMMENT, WS}

VAR : 'var';
LET : 'let';

SEMICOLON : ';';
COLON : ':';
COMMA : ',';

IF : 'if';
ELSE : 'else';
ELSE_IF : 'else if';
EQ : '==';
NOT_EQ : '!=';
LESS : '<';
MR : '>';
LESS_EQ : '<=';
MR_EQ : '>=';
OP : '?';

ASSIGN : '=';
ASSIGN_PLUS : '+=';
ASSIGN_MINUS : '-=';
ASSIGN_MUL : '*=';
ASSIGN_DIV : '/=';
ASSIGN_REM : '%=';
PLUS : '+';
MINUS : '-';
MUL : '*';
DIV : '/';
REM : '%';

RLP : '(';
RRP : ')';
CLB : '{';
CRB : '}';
RBRK : ']';
LBRK : '[';

REPEAT : 'repeat';
WHILE : 'while';
FOR : 'for';
IN : 'in';
PRINT : 'print';

CHARACTER : 'Character';
STRING : 'String';
INT : 'Int';
BOOL: 'Bool';

TRUE: 'true';
FALSE: 'false';
EXCLAM : '!';
AND : '&&';
OR : '||';

SWITCH : 'switch';
CASE : 'case';
DEFAULT : 'default';
BREAK : 'break';
CONTINUE : 'continue';
FALLTHROUGH : 'fallthrough';
WHERE : 'where';
FUNC : 'func';
RET : '->';
RETURN : 'return';

ID : [_]*[a-zA-Z][a-zA-Z0-9_]*;

DEC_DIGIT : '0' | [1-9][0-9]*;
STRING_CONST : '"' ~ ["\n\r]* '"';

COMMENT1 : '//' ~ [\n\r]*;
COMMENT2 : '/*' ~ [\n\r]* '*/';

WS : [ \r\t\n]+ -> skip ;