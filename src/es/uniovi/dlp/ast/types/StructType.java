package es.uniovi.dlp.ast.types;

import es.uniovi.dlp.ast.Locatable;
import es.uniovi.dlp.ast.Type;
import es.uniovi.dlp.ast.definitions.VarDefinition;
import es.uniovi.dlp.visitor.Visitor;

import java.util.List;

public class StructType extends AbstractType {
    private List<StructField> fields;

    public StructType(List<StructField> fields) {
        this.fields = fields;
    }

    public List<StructField> getFields() {
        return fields;
    }

    public StructField getField(String name) {
        for (StructField field : fields) {
            if (field.getName().equals(name))
                return field;
        }

        return null;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP type) {
        return v.visit(this, type);
    }

    @Override
    public Type dot(String name, Locatable locatable) {
        for(StructField field : fields){
            if(field.getName().equals(name))
                return field.getType();
        }

        return new ErrorType("Field '" + name + "' is not defined" + " (line: " + locatable.getLine() + ")", locatable);
    }

    @Override
    public int numberOfBytes() {
        int fieldSumOfBytes = 0;
        for(StructField field : fields){
            fieldSumOfBytes += field.getType().numberOfBytes();
        }

        return fieldSumOfBytes;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("struct{ ");
        for (StructField field : fields) {
            print.append(field.getType().toString() + " ");
        }
        return print.toString() + "}";
    }
}
