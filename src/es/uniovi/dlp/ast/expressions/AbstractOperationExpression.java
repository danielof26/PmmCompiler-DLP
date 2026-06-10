package es.uniovi.dlp.ast.expressions;

import es.uniovi.dlp.ast.Expression;

public abstract class AbstractOperationExpression extends AbstractBinaryExpression {
    private String operator;

    public AbstractOperationExpression(int line, int column, Expression leftExpression,
                                       Expression rightExpression, String operator) {
        super(line, column, leftExpression, rightExpression);
        this.operator = operator;
    }

    public String getOperator(){
        return operator;
    }

    @Override
    public String toString() {
        return "(" + getLeftExpression() + " " + getOperator() + " " + getRightExpression() + ")";
    }
}
