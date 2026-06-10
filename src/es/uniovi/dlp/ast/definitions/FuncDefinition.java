package es.uniovi.dlp.ast.definitions;

import es.uniovi.dlp.ast.Statement;
import es.uniovi.dlp.ast.Type;
import es.uniovi.dlp.ast.types.FuncType;
import es.uniovi.dlp.visitor.Visitor;

import java.util.List;

public class FuncDefinition extends AbstractDefinition {
    private List<Statement> statements;

    public FuncDefinition(int line, int column, String name, Type type, List<Statement> statements) {
        super(line, column, name, type);
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public int bytesLocalSum(){
        int localSum = 0;
        for(Statement stmt : statements){
            if(stmt instanceof VarDefinition){
                localSum += ((VarDefinition)stmt).getType().numberOfBytes();
            }
        }

        return localSum;
    }

    public int bytesParamsSum(){
        int paramsSum = 0;
        for(VarDefinition param : ((FuncType)getType()).getParams()){
            paramsSum += param.getType().numberOfBytes();
        }

        return paramsSum;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public String toString() {
        return name + "(" + type.toString() + ")";
    }
}
