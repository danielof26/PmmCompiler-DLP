package es.uniovi.dlp.visitor;

import es.uniovi.dlp.ast.FuncInvocation;
import es.uniovi.dlp.ast.Program;
import es.uniovi.dlp.ast.definitions.FuncDefinition;
import es.uniovi.dlp.ast.definitions.VarDefinition;
import es.uniovi.dlp.ast.expressions.*;
import es.uniovi.dlp.ast.statements.*;
import es.uniovi.dlp.ast.types.*;

public interface Visitor<TP,TR>  {
    TR visit(Program ast, TP type);

    TR visit(FuncDefinition ast, TP type);
    TR visit(VarDefinition ast, TP type);

    TR visit(Assignment ast, TP type);
    TR visit(Conditional ast, TP type);
    TR visit(Input ast, TP type);
    TR visit(Print ast, TP type);
    TR visit(Return ast, TP type);
    TR visit(While ast, TP type);

    TR visit(Arithmetic ast, TP type);
    TR visit(Comparison ast, TP type);
    TR visit(Logical ast, TP type);
    TR visit(Cast ast, TP type);
    TR visit(UnaryMinus ast, TP type);
    TR visit(UnaryNot ast, TP type);
    TR visit(IntLiteral ast, TP type);
    TR visit(DoubleLiteral ast, TP type);
    TR visit(CharLiteral ast, TP type);
    TR visit(FuncInvocation ast, TP type);
    TR visit(ArrayAccess ast, TP type);
    TR visit(FieldAccess ast, TP type);
    TR visit(Variable ast, TP type);

    TR visit(ArrayType ast, TP type);
    TR visit(CharType ast, TP type);
    TR visit(DoubleType ast, TP type);
    TR visit(ErrorType ast, TP type);
    TR visit(FuncType ast, TP type);
    TR visit(IntType ast, TP type);
    TR visit(StructField ast, TP type);
    TR visit(StructType ast, TP type);
    TR visit(VoidType ast, TP type);
}
