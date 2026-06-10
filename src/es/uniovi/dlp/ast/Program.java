package es.uniovi.dlp.ast;

import es.uniovi.dlp.visitor.Visitor;

import java.util.List;

public class Program implements ASTNode {

    private List<Definition> definitions;

    public Program(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }
}
