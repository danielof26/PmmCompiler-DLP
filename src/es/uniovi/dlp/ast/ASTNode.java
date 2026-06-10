package es.uniovi.dlp.ast;

import es.uniovi.dlp.visitor.Visitor;

public interface ASTNode {
    public <TP,TR> TR accept(Visitor<TP,TR> v, TP type);
}
