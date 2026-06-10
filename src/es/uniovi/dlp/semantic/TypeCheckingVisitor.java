package es.uniovi.dlp.semantic;

import es.uniovi.dlp.ast.*;
import es.uniovi.dlp.ast.definitions.FuncDefinition;
import es.uniovi.dlp.ast.expressions.*;
import es.uniovi.dlp.ast.statements.*;
import es.uniovi.dlp.ast.types.*;
import es.uniovi.dlp.visitor.AbstractVisitor;

public class TypeCheckingVisitor extends AbstractVisitor<Type,Void> {

    //DEFINITIONS
    @Override
    public Void visit(FuncDefinition ast, Type type) {
        var returnType = ((FuncType) ast.getType()).getReturnType();

        ast.getType().accept(this, type);

        for (Statement stmt : ast.getStatements()){
            stmt.accept(this, returnType);
        }

        return null;
    }

    //STATEMENTS
    @Override
    public Void visit(Assignment ast, Type type) {
        super.visit(ast, type);

        if(!ast.getLeftExpression().getLValue()){
            new ErrorType("Expression on the left '"+ ast.getLeftExpression() +"' cannot be assigned: '" + ast + "' - (line:" + ast.getLeftExpression().getLine() +", column:" + ast.getLeftExpression().getColumn() + ")", ast.getLeftExpression());
        }

        ast.getRightExpression().getType().mustPromoteTo(ast.getLeftExpression().getType(), ast);

        return null;
    }


    @Override
    public Void visit(Input ast, Type type) {
        for(Expression expr : ast.getExpressions()){
            expr.accept(this, type);
            if(!expr.getLValue()){
                new ErrorType("Expression '"+ expr +"' as an input cannot be read: '" + ast + "' - (line:" + expr.getLine() +", column:" + expr.getColumn() + ")", expr);
            }

            expr.getType().mustBeBuiltIn(expr);
        }

        return null;
    }

    @Override
    public Void visit(Print ast, Type type) {
        for(Expression expr : ast.getExpressions()){
            expr.accept(this, type);
            expr.getType().mustBeBuiltIn(expr);
        }

        return null;
    }

    @Override
    public Void visit(While ast, Type type) {
        super.visit(ast, type);

        ast.getCondition().getType().mustBeLogical(ast);

        return null;
    }

    @Override
    public Void visit(Conditional ast, Type type) {
        super.visit(ast, type);

        ast.getCondition().getType().mustBeLogical(ast);

        return null;
    }

    @Override
    public Void visit(Return ast, Type type) {
        super.visit(ast, type);

        ast.getExpression().getType().mustPromoteTo(type, ast);

        return null;
    }

    //EXPRESSIONS
    @Override
    public Void visit(Arithmetic ast, Type type) {
        ast.setLValue(false);
        super.visit(ast, type);

        ast.setType(ast.getLeftExpression().getType().arithmetic(ast.getRightExpression().getType(), ast));

        return null;
    }

    @Override
    public Void visit(Comparison ast, Type type) {
        ast.setLValue(false);
        super.visit(ast, type);

        ast.setType(ast.getLeftExpression().getType().comparison(ast.getRightExpression().getType(), ast));

        return null;
    }

    @Override
    public Void visit(Logical ast, Type type) {
        ast.setLValue(false);
        super.visit(ast, type);

        ast.setType(ast.getLeftExpression().getType().logic(ast.getRightExpression().getType(), ast));

        return null;
    }

    @Override
    public Void visit(Cast ast, Type type) {
        ast.setLValue(false);
        super.visit(ast, type);

        ast.setType(ast.getExpression().getType().canBeCastTo(ast.getType(), ast));

        return null;
    }

    @Override
    public Void visit(UnaryMinus ast, Type type) {
        ast.setLValue(false);
        super.visit(ast, type);

        ast.setType(ast.getExpression().getType().arithmetic(ast));

        return null;
    }

    @Override
    public Void visit(UnaryNot ast, Type type) {
        ast.setLValue(false);
        super.visit(ast, type);

        ast.setType(ast.getExpression().getType().logic(ast));

        return null;
    }

    @Override
    public Void visit(IntLiteral ast, Type type) {
        ast.setLValue(false);
        ast.setType(IntType.getInstance());

        return null;
    }

    @Override
    public Void visit(DoubleLiteral ast, Type type) {
        ast.setLValue(false);
        ast.setType(DoubleType.getInstance());

        return null;
    }

    @Override
    public Void visit(CharLiteral ast, Type type) {
        ast.setLValue(false);
        ast.setType(CharType.getInstance());

        return null;
    }

    @Override
    public Void visit(FuncInvocation ast, Type type) {
        ast.setLValue(false);
        super.visit(ast, type);

        ast.setType(ast.getName().getType().parenthesis(ast.getArgTypes(), ast));

        return null;
    }

    @Override
    public Void visit(ArrayAccess ast, Type type) {
        ast.setLValue(true);
        super.visit(ast, type);

        ast.setType(ast.getLeftExpression().getType().squareBrackets(ast.getRightExpression().getType(), ast));

        return null;
    }

    @Override
    public Void visit(FieldAccess ast, Type type) {
        ast.setLValue(true);
        super.visit(ast, type);
        ast.setType(ast.getExpression().getType().dot(ast.getFieldName(), ast));

        return null;
    }

    @Override
    public Void visit(Variable ast, Type type) {
        ast.setLValue(true);
        ast.setType(ast.getDefinition().getType());

        return null;
    }
}