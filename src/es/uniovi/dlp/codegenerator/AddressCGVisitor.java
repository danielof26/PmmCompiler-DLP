package es.uniovi.dlp.codegenerator;

import es.uniovi.dlp.ast.definitions.VarDefinition;
import es.uniovi.dlp.ast.expressions.ArrayAccess;
import es.uniovi.dlp.ast.expressions.FieldAccess;
import es.uniovi.dlp.ast.expressions.Variable;
import es.uniovi.dlp.ast.types.ArrayType;
import es.uniovi.dlp.ast.types.StructType;

public class AddressCGVisitor extends AbstractCGVisitor<Void,Void> {
    private CodeGenerator cG;
    private ValueCGVisitor valueCGVisitor;

    public AddressCGVisitor(CodeGenerator cG) {
        this.cG = cG;
    }

    public void setValueCGVisitor(ValueCGVisitor valueCGVisitor) {
        this.valueCGVisitor = valueCGVisitor;
    }

    @Override
    public Void visit(Variable ast, Void tp) {
        /*
            address[[Variable: exp -> ID]]()=
                if(exp.definition.scope == 0)
                    <pusha> exp.definition.offset
                else
                    <pushBP>
                    <push> exp.definition.offset
                    <addi>
        */
        if(ast.getDefinition().getScope() == 0){
            cG.pusha(((VarDefinition) ast.getDefinition()).getOffset());
        }
        else{
            cG.pushBP();
            cG.push(((VarDefinition) ast.getDefinition()).getOffset());
            cG.arithmetic('i', '+');
        }

        return null;
    }

    @Override
    public Void visit(ArrayAccess ast, Void tp){
        /*
            address[[ArrayAccess: exp1 -> exp2 exp3]]()=
                address[[exp2]]
                value[[exp3]]
                if(exp3.type.suffix() != 'i'){
                    cG.convert(exp3.type.suffix(), 'i')
                }
                <pushi> exp2.type.numberOfBytes()
                <muli>
                <addi>

        */
        ast.getLeftExpression().accept(this, tp); //address of the vector
        ast.getRightExpression().accept(valueCGVisitor, tp); //value of the index
        if(ast.getRightExpression().getType().suffix() != 'i'){
            cG.conversion(ast.getRightExpression().getType().suffix(), 'i');
        }
        cG.push(((ArrayType) ast.getLeftExpression().getType()).getType().numberOfBytes()); //number of bytes
        cG.arithmetic('i', '*');
        cG.arithmetic('i', '+');

        return null;
    }


    @Override
    public Void visit(FieldAccess ast, Void tp){
        /*
            address[[FieldAccess: exp1 -> exp2 ID]]()=
                address[[exp2]]
                <pushi> exp2.type.getField(ID).offset
                <addi>
        */
        ast.getExpression().accept(this, tp);
        cG.push(((StructType)ast.getExpression().getType()).getField(ast.getFieldName()).getOffset());
        cG.arithmetic('i', '+');

        return null;
    }
}
