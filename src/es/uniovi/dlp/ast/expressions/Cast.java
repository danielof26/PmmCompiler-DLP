package es.uniovi.dlp.ast.expressions;

import es.uniovi.dlp.ast.Expression;
import es.uniovi.dlp.ast.Type;
import es.uniovi.dlp.visitor.Visitor;

public class Cast extends AbstractUnaryExpression {
    private Type castType;

    public Cast(int line, int column, Expression expression, Type castType) {
        super(line, column, expression);
        this.castType = castType;
    }

    public Type getType() {
        return castType;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public String toString() {
        return "(" + castType + ") "  + getExpression();
    }
}
