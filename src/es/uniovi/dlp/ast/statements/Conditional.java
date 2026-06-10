package es.uniovi.dlp.ast.statements;

import es.uniovi.dlp.ast.AbstractLocatable;
import es.uniovi.dlp.ast.Expression;
import es.uniovi.dlp.ast.Statement;
import es.uniovi.dlp.visitor.Visitor;

import java.util.List;

public class Conditional extends AbstractLocatable implements Statement {
    private List<Statement> ifBody;
    private List<Statement> elseBody;
    private Expression condition;

    public Conditional(int line, int column, Expression condition,
                       List<Statement> ifBody, List<Statement> elseBody) {
        super(line, column);
        this.ifBody = ifBody;
        this.elseBody = elseBody;
        this.condition = condition;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }

    public Expression getCondition() { return condition; }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public String toString() {
        return "if(" + condition + ")";
    }
}
