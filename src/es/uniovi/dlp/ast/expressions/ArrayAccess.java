package es.uniovi.dlp.ast.expressions;

import es.uniovi.dlp.ast.Expression;
import es.uniovi.dlp.visitor.Visitor;

public class ArrayAccess extends AbstractBinaryExpression {
    public ArrayAccess(int line, int column, Expression leftExpression, Expression rightExpression) {
        super(line, column, leftExpression, rightExpression);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public String toString() {
        return getLeftExpression().toString() + " [" + getRightExpression().toString() + "]";
    }
}
