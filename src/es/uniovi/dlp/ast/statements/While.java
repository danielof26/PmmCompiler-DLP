package es.uniovi.dlp.ast.statements;

import es.uniovi.dlp.ast.AbstractLocatable;
import es.uniovi.dlp.ast.Expression;
import es.uniovi.dlp.ast.Statement;
import es.uniovi.dlp.visitor.Visitor;

import java.util.List;

public class While extends AbstractLocatable implements Statement {
    private List<Statement> body;
    private Expression condition;

    public While(int line, int column, Expression condition, List<Statement> body) {
        super(line, column);
        this.body = body;
        this.condition = condition;
    }

    public List<Statement> getBody() {
        return body;
    }

    public Expression getCondition() { return condition; }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public String toString() {
        return "while(" + condition + ")";
    }
}
