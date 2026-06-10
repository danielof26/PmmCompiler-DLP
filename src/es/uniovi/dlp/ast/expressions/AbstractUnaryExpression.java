package es.uniovi.dlp.ast.expressions;

import es.uniovi.dlp.ast.AbstractLocatable;
import es.uniovi.dlp.ast.Expression;

public abstract class AbstractUnaryExpression extends AbstractExpression {
    private Expression expression;

    public AbstractUnaryExpression(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
