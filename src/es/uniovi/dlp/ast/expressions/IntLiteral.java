package es.uniovi.dlp.ast.expressions;

import es.uniovi.dlp.ast.AbstractLocatable;
import es.uniovi.dlp.ast.Expression;
import es.uniovi.dlp.visitor.Visitor;

public class IntLiteral extends AbstractExpression {
    private int value;

    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
