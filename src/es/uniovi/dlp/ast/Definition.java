package es.uniovi.dlp.ast;

public interface Definition extends Locatable {
    String getName();
    Type getType();
    int getScope();
    void setScope(int scope);
}
