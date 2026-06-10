package es.uniovi.dlp.ast;

public interface Expression extends Locatable {
    boolean getLValue();
    void setLValue(boolean lvalue);
    Type getType();
    void setType(Type type);
}
