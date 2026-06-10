package es.uniovi.dlp.codegenerator;

import es.uniovi.dlp.ast.Expression;
import es.uniovi.dlp.ast.FuncInvocation;
import es.uniovi.dlp.ast.expressions.*;
import es.uniovi.dlp.ast.types.FuncType;

public class ValueCGVisitor extends AbstractCGVisitor<Void,Void> {
    private CodeGenerator cG;
    private AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(CodeGenerator cG){
        this.cG = cG;
    }

    public void setAddressCGVisitor(AddressCGVisitor addressCGVisitor){
        this.addressCGVisitor = addressCGVisitor;
    }

    @Override
    public Void visit(Arithmetic ast, Void tp) {
        /*
            value[[Arithmetic: exp1 -> exp2 op=(+|-|*|/) exp3]]()=
                value[[exp2]]
                if(exp2.type.suffix() != exp1.type.suffix())
                    cG.conversion(exp2.type.suffix, exp1.type.suffix)
                value[[exp3]]
                if(exp3.type.suffix() != exp1.type.suffix())
                    cG.conversion(exp3.type.suffix, exp1.type.suffix)
                switch(op){
                    case '+': <add> exp1.type.suffix(); break;
                    case '-': <sub> exp1.type.suffix(); break;
                    case '*': <mul> exp1.type.suffix(); break;
                    case '/': <div> exp1.type.suffix(); break;
                }
        */
        char suffix = ast.getType().suffix(); // 1 + 2 + 3 + 4

        ast.getLeftExpression().accept(this, tp);
        if(ast.getLeftExpression().getType().suffix() != suffix){
            cG.conversion(ast.getLeftExpression().getType().suffix(), suffix);
        }

        ast.getRightExpression().accept(this, tp);
        if(ast.getRightExpression().getType().suffix() != suffix){
            cG.conversion(ast.getRightExpression().getType().suffix(), suffix);
        }

        cG.arithmetic(suffix, ast.getOperator().charAt(0));

        return null;
    }

    @Override
    public Void visit(Comparison ast, Void tp) {
        /*
            value[[Comparison: exp1 -> exp2 op=(>|>=|<|<=|!=|==) exp3 ]]()=
                char suffix = ast.getLeftExpression().getType().superType(ast.getRightExpression().getType(), ast).suffix();
                value[[exp2]]
                if(exp2.type.suffix() != suffix)
                    cG.conversion(exp2.type.suffix, suffix)
                value[[exp3]]
                if(exp3.type.suffix() != suffix)
                    cG.conversion(exp3.type.suffix, suffix)
                switch(op){
                    case '>': <gt> exp1.type.suffix(); break;
                    case '>=': <ge> exp1.type.suffix(); break;
                    case '<': <lt> exp1.type.suffix(); break;
                    case '<=': <le> exp1.type.suffix(); break;
                    case '!=': <ne> exp1.type.suffix(); break;
                    case '==': <eq> exp1.type.suffix(); break;
                }
        */
        char suffix = ast.getLeftExpression().getType().superType(ast.getRightExpression().getType(), ast).suffix();

        ast.getLeftExpression().accept(this, tp);
        if(ast.getLeftExpression().getType().suffix() != suffix){
            cG.conversion(ast.getLeftExpression().getType().suffix(), suffix);
        }
        ast.getRightExpression().accept(this, tp);
        if(ast.getRightExpression().getType().suffix() != suffix){
            cG.conversion(ast.getRightExpression().getType().suffix(), suffix);
        }

        cG.comparison(suffix, ast.getOperator());

        return null;
    }

    @Override
    public Void visit(Logical ast, Void tp) {
        /*
            value[[Logical: exp1 -> exp2 op=(&&|||) exp3]]()=
                value[[exp2]]
                if(exp2.type.suffix() != exp1.type.suffix)
                    cG.conversion(exp2.type.suffix, exp1.type.suffix)
                value[[exp3]]
                if(exp3.type.suffix() != exp1.type.suffix)
                    cG.conversion(exp3.type.suffix, exp1.type.suffix)
                switch(op){
                    case '&&': <and> break;
                    case '||' <or> break;
                }
        */

        char suffix = ast.getType().suffix();
        ast.getLeftExpression().accept(this, tp);
        if(ast.getLeftExpression().getType().suffix() != suffix){
            cG.conversion(ast.getLeftExpression().getType().suffix(), suffix);
        }
        ast.getRightExpression().accept(this, tp);
        if(ast.getRightExpression().getType().suffix() != suffix){
            cG.conversion(ast.getRightExpression().getType().suffix(), suffix);
        }
        if(ast.getOperator().charAt(0) == '&'){
            cG.and();
        } else {
            cG.or();
        }

        return null;
    }

    @Override
    public Void visit(Cast ast, Void tp) {
        /*
            value[[Cast: exp1 -> type exp2]]()=
                value[[exp2]]
                if(exp2.type.suffix() != type.suffix())
                   cG.conversion(exp2.type.suffix(), type.suffix())
        */
        char from = ast.getExpression().getType().suffix();
        char to = ast.getType().suffix();

        ast.getExpression().accept(this, tp);

        if(from != to){
            cG.conversion(from, to);
        }

        return null;
    }

    @Override
    public Void visit(UnaryMinus ast, Void tp) {
        /*
            value[[UnaryMinus: exp1 -> exp2]]()=
                if(exp1.type.suffix() == 'f')
                    <pushf> 0.0
                else
                    <pushi> 0
                value[[exp2]]
                if(exp2.type.suffix() != exp1.type.suffix)
                    cG.conversion(exp2.type.suffix, exp1.type.suffix)
                <sub> exp1.type.suffix()
        */
        char to = ast.getType().suffix();

        if(to == 'f'){
            cG.push(0.0);
        } else {
            cG.push(0);
        }

        ast.getExpression().accept(this, tp);
        char from = ast.getExpression().getType().suffix();
        if(from != to){
            cG.conversion(from, to);
        }
        cG.arithmetic(to, '-');

        return null;
    }

    @Override
    public Void visit(UnaryNot ast, Void tp) {
        /*
            [[UnaryNot: exp1 -> exp2]]()=
                value[[exp2]]
                if(exp2.type.suffix() != exp1.type.suffix)
                    cG.conversion(exp2.type.suffix, exp1.type.suffix)
                <not>
        */
        ast.getExpression().accept(this, tp);
        char from = ast.getExpression().getType().suffix();
        char to = ast.getType().suffix();
        if(from != to){
            cG.conversion(from, to);
        }

        cG.not();

        return null;
    }

    @Override
    public Void visit(IntLiteral ast, Void tp) {
        /*
            value[[IntLiteral: exp -> INT_CONSTANT]]()=
                <pushi> INT_CONSTANT
        */
        cG.push(ast.getValue());

        return null;
    }

    @Override
    public Void visit(DoubleLiteral ast, Void tp) {
        /*
            value[[DoubleLiteral: exp -> REAL_CONSTANT]]()=
                <pushf> REAL_CONSTANT
        */

        cG.push(ast.getValue());

        return null;
    }

    @Override
    public Void visit(CharLiteral ast, Void tp) {
        /*
            value[[CharLiteral: exp -> CHAR_CONSTANT]]()=
                <pushb> CHAR_CONSTANT
        */
        cG.push(ast.getValue());

        return null;
    }

    @Override
    public Void visit(FuncInvocation ast, Void tp) {
        /*
            value[[FuncInvocation: exp1 -> exp2 exp*]]()=
                for(int i=0; i<exp*.size(); i++){
                    value[[exp*[i]]]
                    if(exp*[i].type.suffix() != exp2.type.params[i].type.suffix())
                        cG.conversion(exp*[i].type.suffix(), exp2.type.params[i].type.suffix())
                }
                <call> exp2.name
        */

        for(int i=0; i<ast.getArgs().size(); i++){
            ast.getArgs().get(i).accept(this, tp);
            char from = ast.getArgs().get(i).getType().suffix();
            char to = ((FuncType)ast.getName().getType()).getParams().get(i).getType().suffix();

            if(from != to)
                cG.conversion(from, to);
        }

        cG.call(ast.getName().getName());

        return null;
    }

    @Override
    public Void visit(ArrayAccess ast, Void tp) {
        /*
            value[[ArrayAccess: exp1 -> exp2 exp3]]()=
                address[[exp1]]
                <load> exp1.type.suffix()
        */
        ast.accept(addressCGVisitor, tp);
        cG.load(ast.getType().suffix());

        return null;
    }

    @Override
    public Void visit(FieldAccess ast, Void tp) {
        /*
            value[[FieldAccess: exp1 -> exp2 ID]]()=
                address[[exp1]]
                <load> exp1.type.suffix()
        */
        ast.accept(addressCGVisitor, tp);
        cG.load(ast.getType().suffix());

        return null;
    }

    @Override
    public Void visit(Variable ast, Void tp) {
        /*
            value[[Variable: exp -> ID]]()=
                address[[exp]]
                <load> exp.type.suffix()
        */
        ast.accept(addressCGVisitor, tp);
        cG.load(ast.getType().suffix());

        return null;
    }
}
