package es.uniovi.dlp.ast.types;

import es.uniovi.dlp.ast.Locatable;
import es.uniovi.dlp.ast.Type;
import es.uniovi.dlp.visitor.Visitor;

public class CharType extends AbstractType {

    private static final CharType INSTANCE = new CharType();

    private CharType() {}

    public static CharType getInstance() {
        return INSTANCE;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        if(!(type instanceof ErrorType || type instanceof CharType || type instanceof IntType || type instanceof DoubleType)){
            new ErrorType("'char' cannot be promoted to '" + type.toString() + "' (line: " + locatable.getLine() + ")", locatable);
        }
    }

    @Override
    public void mustBeLogical(Locatable locatable) {
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }
        else if(type instanceof IntType || type instanceof CharType || type instanceof DoubleType){
            return type;
        }

        return new ErrorType("Type '" + this.toString() + "' cannot be promoted to '" + type.toString() + "' (line: " + locatable.getLine() + ")", locatable);
    }

    @Override
    public Type logic(Locatable locatable) {
        return IntType.getInstance();
    }

    @Override
    public Type logic(Type type, Locatable locatable) {
        type.mustBeLogical(locatable);

        return IntType.getInstance();
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return IntType.getInstance();
    }

    @Override
    public Type arithmetic(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }
        else if(type instanceof DoubleType) {
            return type;
        }

        else if(type instanceof IntType || type instanceof CharType) {
            return IntType.getInstance();
        }

        return new ErrorType("Arithmetic operation cannot be done between '" + this.toString() + "' and '" + type.toString() + "' (line: " + locatable.getLine() + ")", locatable);
    }

    @Override
    public Type comparison(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return this;
        }
        else if(type instanceof IntType || type instanceof DoubleType  || type instanceof CharType){
            return IntType.getInstance();
        }

        return new ErrorType("You cannot compare a '" + type.toString() + "' with a 'char' " + " (line: " + locatable.getLine() + ")", locatable);
    }

    @Override
    public Type superType(Type type, Locatable locatable) {
        if(type instanceof ErrorType) {
            return type;
        }
        else if(type instanceof DoubleType) {
            return DoubleType.getInstance();
        }
        else if(type instanceof IntType || type instanceof CharType) {
            return IntType.getInstance();
        }
        else {
            return new ErrorType("Super action cannot be done in a non-array type" + " (line: " + locatable.getLine() + ")", locatable);
        }
    }

    @Override
    public int numberOfBytes() {
        return 1;
    }

    @Override
    public char suffix() {
        return 'b';
    }

    @Override
    public String toString() {
        return "char";
    }
}