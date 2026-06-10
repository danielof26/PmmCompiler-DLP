package es.uniovi.dlp.ast.types;

import es.uniovi.dlp.ast.Locatable;
import es.uniovi.dlp.ast.Type;
import es.uniovi.dlp.errorhandler.ErrorHandler;
import es.uniovi.dlp.visitor.Visitor;

import java.util.List;

public class ErrorType extends AbstractType {
    private String message;
    private Locatable locatable;

    public ErrorType(String message, Locatable locatable) {
        this.message = message;
        this.locatable = locatable;

        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
    }

    @Override
    public Type dot(String name, Locatable locatable) {
        return this;
    }

    @Override
    public Type logic(Type type, Locatable locatable) {
        return this;
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return this;
    }

    @Override
    public Type arithmetic(Type type, Locatable locatable) {
        return this;
    }

    @Override
    public void mustBeLogical(Locatable locatable) {
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
    }

    @Override
    public Type comparison(Type type, Locatable locatable) {
        return this;
    }

    @Override
    public Type logic(Locatable locatable) {
        return this;
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable locatable) {
        return this;
    }

    @Override
    public Type squareBrackets(Type type, Locatable locatable) {
      return this;
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        return this;
    }

    @Override
    public Type superType(Type type, Locatable locatable) {
        return this;
    }

    @Override
    public int numberOfBytes() {
        throw new RuntimeException("An error type cannot have any size bytes");
    }
}
