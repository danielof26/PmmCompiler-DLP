package es.uniovi.dlp.ast.statements;

import es.uniovi.dlp.ast.AbstractLocatable;
import es.uniovi.dlp.ast.Expression;
import es.uniovi.dlp.ast.Statement;
import es.uniovi.dlp.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Print extends AbstractLocatable implements Statement {
    private List<Expression> expressions;

    public Print(int line, int column, List<Expression> expressions) {
        super(line, column);
        this.expressions = expressions;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("print");
        for (Expression exp : expressions) {
            print.append(exp.toString());
        }
        return print.toString();
    }
}
