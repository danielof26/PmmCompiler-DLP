grammar Pmm;

@header {
    import es.uniovi.dlp.ast.*;
    import es.uniovi.dlp.ast.types.*;
    import es.uniovi.dlp.ast.expressions.*;
    import es.uniovi.dlp.ast.statements.*;
    import es.uniovi.dlp.ast.definitions.*;
}

program returns [Program ast] locals[List<Definition> definitions = new ArrayList<>()]:
        (d=definition{ $definitions.addAll($d.ast); })* m=main_definition{ $definitions.add($m.ast); } EOF { $ast = new Program($definitions); }
        ;

definition returns [List<Definition> ast = new ArrayList<>()]:
        v=var_definition { $ast.addAll($v.ast); }
        | f=func_definition { $ast.add($f.ast); }
        ;

main_definition returns [Definition ast]:
        'def' ID='main' '(' ')' '->' 'None' ':' '{' f=func_body '}' { $ast = new FuncDefinition($ID.getLine(), $ID.getCharPositionInLine()+1, "main", new FuncType(VoidType.getInstance(), new ArrayList<VarDefinition>()), $f.ast); }
        ;

var_definition returns [List<VarDefinition> ast = new ArrayList<>()] locals[List<String> ids = new ArrayList<>(), List<Integer> cols = new ArrayList<>()]:
        ID1=IDENTIFIER{ $ids.add($ID1.text); $cols.add($ID1.getCharPositionInLine()+1); } (',' ID2=IDENTIFIER{ $ids.add($ID2.text); $cols.add($ID2.getCharPositionInLine()+1); })* ':' t=type ';' {
            int counter = 0;
            for(String id : $ids){
                int line = $ID1.getLine();
                int column = $cols.get(counter);
                VarDefinition v = new VarDefinition(line, column, id, $t.ast);
                if($ast.contains(v)) new ErrorType("Cannot have variable '" + id + "' duplicated: (line: " + line + ", column: " + column + ")", v);
                $ast.add(v);
                counter++;
            }
         }
        ;

func_definition returns [Definition ast] locals [List<VarDefinition> parameters = new ArrayList<>(), Type returnType]:
        'def' ID=IDENTIFIER '(' (p=params{ $parameters = $p.ast; })? ')' '->' ((b=built_in){ $returnType = $b.ast; }|n='None'{ $returnType = VoidType.getInstance(); }) ':' '{' f=func_body '}' { $ast = new FuncDefinition($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text, new FuncType($returnType, $parameters), $f.ast); }
        ;

params returns [List<VarDefinition> ast = new ArrayList<>()]:
        ID1=IDENTIFIER ':' t1=built_in{ $ast.add(new VarDefinition($ID1.getLine(), $ID1.getCharPositionInLine()+1, $ID1.text, $t1.ast)); }(',' ID2=IDENTIFIER ':' t2=built_in{ $ast.add(new VarDefinition($ID2.getLine(), $ID2.getCharPositionInLine()+1, $ID2.text, $t2.ast)); })*
        ;

func_body returns [List<Statement> ast = new ArrayList<>()]:
        (v=var_definition{ $ast.addAll($v.ast); })* (s=statement{ $ast.add($s.ast); })*
        ;

expression returns [Expression ast]:
    '(' exp=expression ')' { $ast = $exp.ast; }
    | f=func_invocation { $ast = $f.ast; }
    | exp=expression '.' ID=IDENTIFIER { $ast = new FieldAccess($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast, $ID.text); }
    | exp1=expression '[' exp2=expression ']' { $ast =  new ArrayAccess($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast); }
    | '(' t=type ')' exp=expression { $ast = new Cast($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast, $t.ast); }
    | '-' exp=expression { $ast = new UnaryMinus($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast); }
    | '!' exp=expression { $ast = new UnaryNot($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast); }
    | exp1=expression OP=('*'|'/'|'%') exp2=expression { $ast = new Arithmetic($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast, $OP.text); }
    | exp1=expression OP=('+'|'-') exp2=expression { $ast = new Arithmetic($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast, $OP.text); }
    | exp1=expression OP=('>'|'>='|'<'|'<='|'!='|'==') exp2=expression { $ast = new Comparison($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast, $OP.text); }
    | exp1=expression OP=('&&'|'||') exp2=expression { $ast = new Logical($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast, $OP.text); }
    | ID=IDENTIFIER { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
    | CONST=INT_CONSTANT { $ast = new IntLiteral($CONST.getLine(), $CONST.getCharPositionInLine()+1, LexerHelper.lexemeToInt($CONST.text)); }
    | CONST=REAL_CONSTANT { $ast = new DoubleLiteral($CONST.getLine(), $CONST.getCharPositionInLine()+1, LexerHelper.lexemeToReal($CONST.text)); }
    | CONST=CHAR_CONSTANT { $ast = new CharLiteral($CONST.getLine(), $CONST.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CONST.text)); }
    ;

statement returns [Statement ast] locals[List<Expression> expressions, List<Statement> elseBlock = new ArrayList<>()]:
        f=func_invocation ';' { $ast = $f.ast; }
        | 'print' exp1=expression { $expressions = new ArrayList<>(); $expressions.add($exp1.ast); } (',' exp2=expression{ $expressions.add($exp2.ast); })* ';' { $ast = new Print($exp1.ast.getLine(), $exp1.ast.getColumn(), $expressions); }
        | 'input' exp1=expression { $expressions = new ArrayList<>(); $expressions.add($exp1.ast); } (',' exp2=expression{ $expressions.add($exp2.ast); })* ';' { $ast = new Input($exp1.ast.getLine(), $exp1.ast.getColumn(), $expressions); }
        | 'return' exp=expression ';' { $ast = new Return($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast); }
        | 'while' exp=expression ':' b=block { $ast = new While($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast, $b.ast); }
        | 'if' exp=expression ':' b1=block ('else:' b2=block{ $elseBlock = $b2.ast; })? { $ast = new Conditional($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast, $b1.ast, $elseBlock); }
        | exp1=expression '=' exp2=expression ';' { $ast = new Assignment($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast); }
        ;

block returns [List<Statement> ast = new ArrayList<>();]:
    st=statement{ $ast.add($st.ast); }
    | '{' (st=statement{ $ast.add($st.ast); })* '}'
    ;

func_invocation returns [FuncInvocation ast] locals[List<Expression> expressions = new ArrayList<>()]:
    ID=IDENTIFIER '(' (exp1=expression{ $expressions.add($exp1.ast); } (',' exp2=expression{ $expressions.add($exp2.ast); })*)? ')' { $ast = new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text), $expressions); }
;

type returns [Type ast] locals [List<StructField> fields = new ArrayList<>()]:
    built_in { $ast = $built_in.ast; }
    | '[' I=INT_CONSTANT ']' t=type { $ast = new ArrayType($t.ast, LexerHelper.lexemeToInt($I.text)); }
    | 'struct' '{' (sf=struct_field{
        for(StructField f : $sf.ast){
            if($fields.contains(f)) new ErrorType("Cannot have field '" + f.getName() + "' duplicated: (line: " + f.getLine() + ", column: " + f.getColumn() + ")", f);
            $fields.add(f);
        }
    })* '}' { $ast = new StructType($fields); }
    ;

built_in returns [Type ast]:
        'int' { $ast = IntType.getInstance(); }
        | 'double' { $ast = DoubleType.getInstance(); }
        | 'char' { $ast = CharType.getInstance(); }
        ;


struct_field returns [List<StructField> ast = new ArrayList<>()] locals [List<String> ids = new ArrayList<>(), List<Integer> cols = new ArrayList<>()]:
        ID1=IDENTIFIER { $ids.add($ID1.text); $cols.add($ID1.getCharPositionInLine()+1); } (',' ID2=IDENTIFIER { $ids.add($ID2.text); $cols.add($ID2.getCharPositionInLine()+1); })* ':' t=type ';' {
            int counter = 0;
            for(String id : $ids){
                StructField field = new StructField($ID1.getLine(), $cols.get(counter), id, $t.ast);
                //if($ast.contains(field)) new ErrorType("Cannot have field '" + id + "' duplicated", field);
                $ast.add(field);
                counter++;
            }
        }
        ;

fragment
DIGIT: [0-9]
    ;

fragment
LETTER: [a-zA-Z]
    ;

SINGLE_LINE_COMMENT: '#'~('\n'|'\r')* ('\n'|'\r'|EOF) -> skip
            ;

MULTIPLE_LINE_COMMENT: '"""'.*?'"""' -> skip
            ;

IDENTIFIER: (LETTER|'_')(LETTER|DIGIT|'_')*
            ;

INT_CONSTANT: [1-9] DIGIT*
            | '0'
            ;

CHAR_CONSTANT: '\''~('\''|'\n'|'\r'|'\t')+'\''
            ;

REAL_CONSTANT: DIGIT+'.'(DIGIT+([eE][+-]?DIGIT+)?)?
            | '.'DIGIT+([eE][+-]?DIGIT+)?
            | DIGIT+[eE][+-]?DIGIT+
            ;

WS: [ \n\r\t]+ -> skip
            ;