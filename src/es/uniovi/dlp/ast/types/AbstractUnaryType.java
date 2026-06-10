package es.uniovi.dlp.ast.types;

import es.uniovi.dlp.ast.Type;

public abstract class AbstractUnaryType extends AbstractType {
    private Type type;

    public AbstractUnaryType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
