package es.uniovi.dlp.ast.types;

import es.uniovi.dlp.ast.Expression;
import es.uniovi.dlp.ast.Locatable;
import es.uniovi.dlp.ast.Type;
import es.uniovi.dlp.ast.definitions.VarDefinition;
import es.uniovi.dlp.visitor.Visitor;

import java.util.List;

public class FuncType extends AbstractUnaryType {
    private List<VarDefinition> params;

    public FuncType(Type returnType, List<VarDefinition> params) {
        super(returnType);
        this.params = params;
    }

    public Type getReturnType() {
        return getType();
    }

    public List<VarDefinition> getParams() {
        return params;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable locatable) {
        if(params.size() != types.size()){
            return new ErrorType("Wrong amount of parameters passed to the function (expecting " + params.size() + " but obtained " + types.size()  + ")" + " (line: " + locatable.getLine() + ")", locatable);
        }

        for(int i=0; i<params.size(); i++){
            types.get(i).mustPromoteTo(params.get(i).getType(), locatable);
        }

        return super.getType();
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("FuncType{");
        for (VarDefinition varDef : params) {
            print.append(varDef.toString());
        }
        return print.toString() + "}";
    }
}
