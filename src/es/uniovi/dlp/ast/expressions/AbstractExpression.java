package es.uniovi.dlp.ast.expressions;

import es.uniovi.dlp.ast.AbstractLocatable;
import es.uniovi.dlp.ast.Expression;
import es.uniovi.dlp.ast.Type;

public abstract class AbstractExpression extends AbstractLocatable implements Expression {
    private boolean lvalue;
    private Type type;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean getLValue() {
        return lvalue;
    }

    @Override
    public void setLValue(boolean lvalue) {
        this.lvalue = lvalue;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }
}
