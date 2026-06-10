package es.uniovi.dlp.codegenerator;

import es.uniovi.dlp.ast.Definition;
import es.uniovi.dlp.ast.Program;
import es.uniovi.dlp.ast.Statement;
import es.uniovi.dlp.ast.definitions.FuncDefinition;
import es.uniovi.dlp.ast.definitions.VarDefinition;
import es.uniovi.dlp.ast.types.FuncType;
import es.uniovi.dlp.ast.types.StructField;
import es.uniovi.dlp.ast.types.StructType;
import es.uniovi.dlp.visitor.AbstractVisitor;
import es.uniovi.dlp.visitor.Visitor;

public class OffSetVisitor extends AbstractVisitor<Void, Void> {
    private int globalBytesSum = 0;
    private int localBytesSum = 0;

    @Override
    public Void visit(Program ast, Void tp) {
        for(Definition def : ast.getDefinitions()){
            def.accept(this, tp);
        }
        return null;
    }

    @Override
    public Void visit(VarDefinition ast, Void tp) {
        ast.getType().accept(this, tp);

        if(ast.getScope() == 0){
            ast.setOffset(globalBytesSum);
            globalBytesSum += ast.getType().numberOfBytes();
        } else{
            localBytesSum += ast.getType().numberOfBytes();
            ast.setOffset(-localBytesSum);
        }

        return null;
    }

    @Override
    public Void visit(FuncDefinition ast, Void tp) {
        localBytesSum = 0;

        ast.getType().accept(this, tp);

        for(Statement stmt : ast.getStatements()){
            stmt.accept(this, tp);
        }

        return null;
    }

    @Override
    public Void visit(FuncType ast, Void tp) {
        int paramBytesSum = 4;
        for(VarDefinition varDef: ast.getParams().reversed()) {
            varDef.setOffset(paramBytesSum);
            paramBytesSum += varDef.getType().numberOfBytes();
        }

        return null;
    }

    @Override
    public Void visit(StructType ast, Void tp) {
        int fieldBytesSum = 0;
        for(StructField field : ast.getFields()){
            field.accept(this, tp);
            field.setOffset(fieldBytesSum);
            fieldBytesSum += field.getType().numberOfBytes();
        }

        return null;
    }
}
