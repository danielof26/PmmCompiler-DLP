package es.uniovi.dlp.visitor;

import es.uniovi.dlp.ast.*;
import es.uniovi.dlp.ast.definitions.FuncDefinition;
import es.uniovi.dlp.ast.definitions.VarDefinition;
import es.uniovi.dlp.ast.expressions.*;
import es.uniovi.dlp.ast.statements.*;
import es.uniovi.dlp.ast.types.*;

public abstract class AbstractVisitor<TP,TR> implements Visitor<TP,TR> {

    @Override
    public TR visit(Program ast, TP type) {
        for(Definition def : ast.getDefinitions()){
            def. accept(this, type);
        }

        return null;
    }

    @Override
    public TR visit(FuncDefinition ast, TP type) {
        ast.getType().accept(this, type);
        for (Statement stmt : ast.getStatements()){
            stmt.accept(this, type);
        }

        return null;
    }

    @Override
    public TR visit(VarDefinition ast, TP type) {
        ast.getType().accept(this, type);

        return null;
    }

    @Override
    public TR visit(Assignment ast, TP type) {
        ast.getLeftExpression().accept(this, type);
        ast.getRightExpression().accept(this, type);

        return null;
    }

    @Override
    public TR visit(Conditional ast, TP type) {
        ast.getCondition().accept(this, type);
        for(Statement stmt : ast.getIfBody()){
            stmt.accept(this, type);
        }
        for(Statement stmt : ast.getElseBody()){
            stmt.accept(this, type);
        }

        return null;
    }

    @Override
    public TR visit(Input ast, TP type) {
        for(Expression expr : ast.getExpressions()){
            expr.accept(this, type);
        }

        return null;
    }

    @Override
    public TR visit(Print ast, TP type) {
        for(Expression expr : ast.getExpressions()){
            expr.accept(this, type);
        }

        return null;
    }

    @Override
    public TR visit(Return ast, TP type) {
        ast.getExpression().accept(this, type);

        return null;
    }

    @Override
    public TR visit(While ast, TP type) {
        ast.getCondition().accept(this, type);
        for(Statement stmt : ast.getBody()){
            stmt.accept(this, type);
        }

        return null;
    }

    @Override
    public TR visit(Arithmetic ast, TP type) {
        ast.getLeftExpression().accept(this, type);
        ast.getRightExpression().accept(this, type);

        return null;
    }

    @Override
    public TR visit(Comparison ast, TP type) {
        ast.getLeftExpression().accept(this, type);
        ast.getRightExpression().accept(this, type);

        return null;
    }

    @Override
    public TR visit(Logical ast, TP type) {
        ast.getLeftExpression().accept(this, type);
        ast.getRightExpression().accept(this, type);

        return null;
    }

    @Override
    public TR visit(Cast ast, TP type) {
        ast.getType().accept(this, type);
        ast.getExpression().accept(this, type);

        return null;
    }

    @Override
    public TR visit(UnaryMinus ast, TP type) {
        ast.getExpression().accept(this, type);

        return null;
    }

    @Override
    public TR visit(UnaryNot ast, TP type) {
        ast.getExpression().accept(this, type);

        return null;
    }

    @Override
    public TR visit(IntLiteral ast, TP type) {
        return null;
    }

    @Override
    public TR visit(DoubleLiteral ast, TP type) {
        return null;
    }

    @Override
    public TR visit(CharLiteral ast, TP type) {
        return null;
    }

    @Override
    public TR visit(FuncInvocation ast, TP type) {
        ast.getName().accept(this, type);
        for(Expression expr : ast.getArgs()){
            expr.accept(this, type);
        }

        return null;
    }

    @Override
    public TR visit(ArrayAccess ast, TP type) {
        ast.getLeftExpression().accept(this, type);
        ast.getRightExpression().accept(this, type);

        return null;
    }

    @Override
    public TR visit(FieldAccess ast, TP type) {
        ast.getExpression().accept(this, type);

        return null;
    }

    @Override
    public TR visit(Variable ast, TP type) {
        return null;
    }

    @Override
    public TR visit(ArrayType ast, TP type) {
        ast.getType().accept(this, type);

        return null;
    }

    @Override
    public TR visit(CharType ast, TP type) {
        return null;
    }

    @Override
    public TR visit(DoubleType ast, TP type) {
        return null;
    }

    @Override
    public TR visit(ErrorType ast, TP type) {
        return null;
    }

    @Override
    public TR visit(FuncType ast, TP type) {
        ast.getType().accept(this, type);
        for(VarDefinition varDef : ast.getParams()){
            varDef.accept(this, type);
        }

        return null;
    }

    @Override
    public TR visit(IntType ast, TP type) {
        return null;
    }

    @Override
    public TR visit(StructField ast, TP type) {
        ast.getType().accept(this, type);

        return null;
    }

    @Override
    public TR visit(StructType ast, TP type) {
        for(StructField field : ast.getFields()){
            field.getType().accept(this, type);
        }

        return null;
    }

    @Override
    public TR visit(VoidType ast, TP type) {
        return null;
    }
}
