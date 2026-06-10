package es.uniovi.dlp.ast.types;

import es.uniovi.dlp.ast.Locatable;
import es.uniovi.dlp.ast.Type;
import es.uniovi.dlp.visitor.Visitor;

import java.util.List;
import java.util.Locale;

public abstract class AbstractType implements Type {
    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        if(!(type instanceof ErrorType)){
            new ErrorType("Type cannot be promoted to '" + type.toString() + "' (line: " + locatable.getLine() + ")", locatable);
        }
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        }
        else {
            return new ErrorType("Type '" + this.toString() + "' cannot be used to cast" + " (line: " + locatable.getLine() + ")", locatable);
        }
    }

    @Override
    public Type dot(String name, Locatable locatable) {
        return new ErrorType("Field '" + name + "' cannot be accessed in a non-struct type" + " (line: " + locatable.getLine() + ")" , locatable);
    }

    @Override
    public Type logic(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        } else {
            return new ErrorType("Logical operation cannot be done with '" + this.toString() + "' type" + " (line: " + locatable.getLine() + ")", locatable);
        }
    }

    @Override
    public void mustBeLogical(Locatable locatable) {
        new ErrorType("A logical operation cannot be done with a '" + this.toString() + "' type" + " (line: " + locatable.getLine() + ")", locatable);
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return new ErrorType("Negation operation cannot be done with a '" + this.toString() + "' type" + " (line: " + locatable.getLine() + ")", locatable);
    }

    @Override
    public Type arithmetic(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        } else {
            return new ErrorType("Arithmetic operation cannot be done with '" + type.toString() + "' type" + " (line: " + locatable.getLine() + ")", locatable);
        }
    }

    @Override
    public Type comparison(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return type;
        } else {
            return new ErrorType("A comparison cannot be done between '" + type.toString() + "' and '" + this.toString() + "'" + " (line: " + locatable.getLine() + ")", locatable);
        }
    }

    @Override
    public Type logic(Locatable locatable) {
        return new ErrorType("Negation operation cannot be done with '" + this.toString() + "' type" + " (line: " + locatable.getLine() + ")", locatable);
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable locatable) {
        for(Type type : types){
            if(type instanceof ErrorType){
                return type;
            }
        }

        return new ErrorType("Function invocation cannot be done with a non-function type" + " (line: " + locatable.getLine() + ")", locatable);
    }

    @Override
    public char suffix() {
        throw new IllegalStateException("Cannot have a suffix for a non-built-in type");
    }

    @Override
    public Type squareBrackets(Type type, Locatable locatable) {
        if(type instanceof ErrorType) {
            return type;
        } else {
            return new ErrorType("Indexing action cannot be done in a non-array type" + " (line: " + locatable.getLine() + ")", locatable);
        }
    }

    @Override
    public Type superType(Type type, Locatable locatable) {
        if(type instanceof ErrorType) {
            return type;
        } else {
            return new ErrorType("Super action cannot be done in a non-array type" + " (line: " + locatable.getLine() + ")", locatable);
        }
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
        new ErrorType("'" + this.toString() + "' is not a built-in type" + " (line: " + locatable.getLine() + ")", locatable);
    }
}
