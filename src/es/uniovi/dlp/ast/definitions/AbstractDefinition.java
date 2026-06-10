package es.uniovi.dlp.ast.definitions;

import es.uniovi.dlp.ast.AbstractLocatable;
import es.uniovi.dlp.ast.Definition;
import es.uniovi.dlp.ast.Type;

public abstract class AbstractDefinition extends AbstractLocatable implements Definition {
    protected String name;
    protected Type type;
    protected int scope;

    public AbstractDefinition(int line, int column, String name, Type type) {
        super(line, column);
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public int getScope() {
        return scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }
}