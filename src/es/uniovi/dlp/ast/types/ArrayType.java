package es.uniovi.dlp.ast.types;

import es.uniovi.dlp.ast.Locatable;
import es.uniovi.dlp.ast.Type;
import es.uniovi.dlp.visitor.Visitor;

public class ArrayType extends AbstractUnaryType {
    private int size;

    public ArrayType(Type type, int size) {
        super(type);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public Type squareBrackets(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return this;
        }
        else if(type instanceof IntType | type instanceof CharType){
            return getType();
        }

        return new ErrorType("Indexing type mut be an 'int', not an '" + type.toString() + "' " + " (line: " + locatable.getLine() + ")", locatable);
    }

    @Override
    public int numberOfBytes() {
        return getType().numberOfBytes() * size;
    }

    @Override
    public String toString() {
        return "array[" + this.getType() + "]";
    }
}
