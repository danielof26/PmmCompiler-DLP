package es.uniovi.dlp.ast.types;

import es.uniovi.dlp.ast.Locatable;
import es.uniovi.dlp.ast.Type;
import es.uniovi.dlp.visitor.Visitor;

public class DoubleType extends AbstractType {

    private static final DoubleType INSTANCE = new DoubleType();

    private DoubleType() {}

    public static DoubleType getInstance() {
        return INSTANCE;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        if(!(type instanceof ErrorType || type instanceof DoubleType)){
            new ErrorType("'double' cannot be promoted to '" + type.toString() + "' (line: " + locatable.getLine() + ")", locatable);
        }
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        int a = 1;
        double b = 2.0;
        char c = 's';

        if(type instanceof ErrorType){
            return type;
        }
        else if(type instanceof DoubleType || type instanceof CharType || type instanceof IntType){
            return type;
        }

        return new ErrorType("Type '" + this.toString() + "' cannot be promoted to '" + type.toString() + "' (line: " + locatable.getLine() + ")", locatable);
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return this;
    }

    @Override
    public Type arithmetic(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }
        else if(type instanceof IntType || type instanceof DoubleType || type instanceof CharType) {
            return this;
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

        return new ErrorType("You cannot compare a '" + type.toString() + "' with a 'double' " + " (line: " + locatable.getLine() + ")", locatable);
    }

    @Override
    public Type superType(Type type, Locatable locatable) {
        if(type instanceof ErrorType) {
            return type;
        }
        else if(type instanceof DoubleType || type instanceof CharType || type instanceof IntType) {
            return this;
        }
        else {
            return new ErrorType("Super action cannot be done in a non-array type" + " (line: " + locatable.getLine() + ")", locatable);
        }
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    @Override
    public char suffix() {
        return 'f';
    }

    @Override
    public String toString() {
        return "real";
    }
}