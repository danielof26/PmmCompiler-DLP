package es.uniovi.dlp.semantic;

import es.uniovi.dlp.ast.definitions.FuncDefinition;
import es.uniovi.dlp.ast.definitions.VarDefinition;
import es.uniovi.dlp.ast.expressions.Variable;
import es.uniovi.dlp.ast.statements.Assignment;
import es.uniovi.dlp.ast.types.ErrorType;
import es.uniovi.dlp.symboltable.SymbolTable;
import es.uniovi.dlp.visitor.AbstractVisitor;

public class IdentificationVisitor extends AbstractVisitor<Void,Void> {
    private SymbolTable symbolTable = new SymbolTable();

    @Override
    public Void visit(VarDefinition ast, Void type) {
        if(!symbolTable.insert(ast)){
            new ErrorType("Variable '" + ast.getName() + "' is already defined in this scope - (line: " + ast.getLine() + ", column: " + ast.getColumn() + ")", ast);
        }

        super.visit(ast, type);

        return null;
    }

    @Override
    public Void visit(FuncDefinition ast, Void type) {
        if(!symbolTable.insert(ast)){
            new ErrorType("Function '" + ast.getName() + "' is already defined in this scope - (line: " + ast.getLine() + ", column: " + ast.getColumn() + ")", ast);
        }

        symbolTable.set();
        super.visit(ast, type);
        symbolTable.reset();

        return null;
    }

    @Override
    public Void visit(Variable ast, Void type) {
        var def = symbolTable.find(ast.getName());
        if(def == null){
            ast.setDefinition(new VarDefinition(ast.getLine(), ast.getColumn(), ast.getName(), new ErrorType("Variable '" + ast.getName() + "' does not exist", ast)));
            //new ErrorType("Variable '"  + ast.getName() + "' does not exist - (line: " + ast.getLine() + ", column: " + ast.getColumn() + ")", ast);
        } else {
            ast.setDefinition(def);
        }

        super.visit(ast, type);

        return null;
    }
}
