package es.uniovi.dlp.ast;

public interface Locatable extends ASTNode {
    int getLine();
    int getColumn();
}
