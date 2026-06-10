package es.uniovi.dlp.ast;

import es.uniovi.dlp.ast.expressions.AbstractExpression;
import es.uniovi.dlp.ast.expressions.Variable;
import es.uniovi.dlp.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncInvocation extends AbstractExpression implements Statement {
    private Variable name;
    private List<Expression> args;

    public FuncInvocation(int line, int column, Variable name, List<Expression> args) {
        super(line, column);
        this.name = name;
        this.args = args;
    }

    public Variable getName() {
        return name;
    }

    public List<Expression> getArgs() {
        return args;
    }

    public List<Type> getArgTypes() {
        List<Type> types = new ArrayList<Type>();

        for(Expression arg : args){
            types.add(arg.getType());
        }

        return types;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public String toString() {
        StringBuilder input = new StringBuilder(name.getName() + "(");
        for (Expression exp : args) {
            input.append(exp.toString());
        }
        return input.toString() + ")";
    }
}
