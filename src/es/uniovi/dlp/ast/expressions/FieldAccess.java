package es.uniovi.dlp.ast.expressions;

import es.uniovi.dlp.ast.Expression;
import es.uniovi.dlp.visitor.Visitor;

public class FieldAccess extends AbstractUnaryExpression {
    private String fieldName;

    public FieldAccess(int line, int column, Expression expression, String fieldName) {
        super(line, column, expression);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public String toString() {
        return fieldName + "." + getExpression();
    }
}
