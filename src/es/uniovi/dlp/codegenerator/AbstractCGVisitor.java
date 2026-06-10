package es.uniovi.dlp.codegenerator;

import es.uniovi.dlp.ast.FuncInvocation;
import es.uniovi.dlp.ast.Program;
import es.uniovi.dlp.ast.definitions.FuncDefinition;
import es.uniovi.dlp.ast.definitions.VarDefinition;
import es.uniovi.dlp.ast.expressions.*;
import es.uniovi.dlp.ast.statements.*;
import es.uniovi.dlp.ast.types.*;
import es.uniovi.dlp.visitor.Visitor;

public abstract class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {
    @Override
    public TR visit(Program ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(FuncDefinition ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(VarDefinition ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(Assignment ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(Conditional ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(Input ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(Print ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(Return ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(While ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(Arithmetic ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(Comparison ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(Logical ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(Cast ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(UnaryMinus ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(UnaryNot ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(IntLiteral ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(DoubleLiteral ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(CharLiteral ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(FuncInvocation ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(ArrayAccess ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(FieldAccess ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(Variable ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(ArrayType ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(CharType ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(DoubleType ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(ErrorType ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(FuncType ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(IntType ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(StructField ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(StructType ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }

    @Override
    public TR visit(VoidType ast, TP type) {
        throw new IllegalStateException("Cannot visit to generate code template");
    }
}
