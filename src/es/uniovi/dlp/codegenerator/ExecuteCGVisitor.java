package es.uniovi.dlp.codegenerator;

import es.uniovi.dlp.ast.*;
import es.uniovi.dlp.ast.definitions.FuncDefinition;
import es.uniovi.dlp.ast.definitions.VarDefinition;
import es.uniovi.dlp.ast.statements.*;
import es.uniovi.dlp.ast.types.FuncType;
import es.uniovi.dlp.ast.types.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor<FuncDefinition, Void> {
    private CodeGenerator cG;
    private AddressCGVisitor addressCG;
    private ValueCGVisitor valueCG;

    public ExecuteCGVisitor(CodeGenerator cG) {
        this.cG = cG;
        this.addressCG = new AddressCGVisitor(cG);
        this.valueCG = new ValueCGVisitor(cG);

        addressCG.setValueCGVisitor(valueCG);
        valueCG.setAddressCGVisitor(addressCG);
    }

    @Override
    public Void visit(Program ast, FuncDefinition tp) {
        /*
            execute[[Program -> vardefinition* funcdefinition*]]()=
                vardefinition*.forEach(v -> {
                    execute[[v]]
                })
                <call> <main>
                <halt>
                funcdefinition*.forEach(f -> {
                    execute[[f]]
                })
        */
        for (Definition def : ast.getDefinitions()) {
            if (def instanceof VarDefinition) {
                def.accept(this, tp);
            }
        }
        cG.newLine();
        cG.comment("Invocation to main function");
        cG.call("main");
        cG.halt();
        cG.newLine();

        for (Definition def : ast.getDefinitions()) {
            if (def instanceof FuncDefinition) {
                cG.newLine();
                cG.line(def.getLine());
                cG.newLine();
                def.accept(this, tp);
            }
        }

        return null;
    }

    @Override
    public Void visit(FuncDefinition ast, FuncDefinition tp) {
        /*
            execute[[FuncDefinition: def -> ID type vardef* stmt*]]()=
                int argBytes = 0;
                int localBytes = 0;
                int returnBytes = 0;

                ' * Parameters
                vardef*.forEach(v -> {
                    execute[[v]]
                    argBytes += vardef.type.numberOfBytes()
                })
                ' * Local variables
                for(Statement st : stmt*){
                    if(st instanceof VarDefinition)
                        execute[[st]]
                        localBytes += (VarDefinition) st.type.numberOfBytes()
                }
                <enter> localBytes
                for(Statement st : stmt*){
                    if(!(st instanceof VarDefinition))
                        execute[[st]](def)

                <ret> (FuncType)type.returnType.numberOfBytes(), localBytes, argBytes

        */
        int argBytes = 0;
        int localBytes = 0;
        int returnBytes = 0;

        cG.label(ast.getName());
        cG.comment("Parameters");
        for (VarDefinition varDef : ((FuncType) ast.getType()).getParams()) {
            varDef.accept(this, tp);
            argBytes += varDef.getType().numberOfBytes();
        }
        cG.comment("Local variables");
        for (Statement stmt : ast.getStatements()) {
            if (stmt instanceof VarDefinition) {
                stmt.accept(this, tp);
                localBytes += ((VarDefinition) stmt).getType().numberOfBytes();
            }
        }
        cG.enter(localBytes);
        //cG.newLine();

        for (Statement stmt : ast.getStatements()) {
            if (!(stmt instanceof VarDefinition)) {
                stmt.accept(this, ast);
                cG.newLine();
            }
        }

        returnBytes = ((FuncType) ast.getType()).getReturnType().numberOfBytes();

        if(returnBytes == 0)
            cG.returns(returnBytes, localBytes, argBytes);

        return null;
    }

    @Override
    public Void visit(VarDefinition ast, FuncDefinition tp) {
        /*
            execute[[VarDefinition: def -> ID type]]()=
                ' * type def.name (offset def.offset)
        */
        cG.comment(ast.getType().toString() + " " + ast.getName() + " (offset " + ast.getOffset() + ")");

        return null;
    }

    @Override
    public Void visit(Assignment ast, FuncDefinition tp) {
        /*
            execute[[Assignment: stmt -> exp1 exp2]]()=
                address[[exp1]]
                value[[exp2]]
                if(exp1.type.suffix() != exp2.type.suffix())
                   cG.conversion(exp2.type.suffix(), exp1.type.suffix())
                <store> exp1.type.suffix()
        */
        cG.newLine();
        cG.line(ast.getLine());
        cG.comment("Assignment");
        ast.getLeftExpression().accept(addressCG, null);
        ast.getRightExpression().accept(valueCG, null);

        char from = ast.getRightExpression().getType().suffix();
        char to = ast.getLeftExpression().getType().suffix();
        if (from != to) {
            cG.conversion(from, to);
        }

        cG.store(to);

        return null;
    }

    @Override
    public Void visit(Conditional ast, FuncDefinition tp) {
        /*
            execute[[Conditional: stmt -> exp stmt1* stmt2*]]()=
                String else = cG.getLabel();
                String end = cG.getLabel();
                value[[exp]]
                if(exp.type.suffix() != 'i')
                    cG.conversion(exp.type.suffix, 'i')
                <jz> else
                stmt1*forEach(st -> execute[[st]])
                <jmp> end
                else <:>
                stmt2*forEach(st -> execute[[st]])
                end <:>
        */
        cG.line(ast.getLine());
        cG.comment("If");
        cG.newLine();
        cG.line(ast.getLine());
        String elseLabel = cG.getLabel();
        String end = cG.getLabel();
        ast.getCondition().accept(valueCG, null);
        if(ast.getCondition().getType().suffix() != 'i')
            cG.conversion(ast.getCondition().getType().suffix(), 'i');
        cG.jz(elseLabel);
        cG.comment("if body");
        cG.newLine();
        for (Statement st : ast.getIfBody()) {
            st.accept(this, tp);
        }
        cG.jmp(end);
        cG.label(elseLabel);
        cG.comment("else body");
        cG.newLine();
        for (Statement st : ast.getElseBody()) {
            st.accept(this, tp);
        }
        cG.label(end);

        return null;
    }

    @Override
    public Void visit(Input ast, FuncDefinition tp) {
        /*
            execute[[Input: stmt -> exp*]]()=
                exp*.forEach(e -> {
                    address[[e]]
                    <in> e.type.suffix()
                    <store> e.type.suffix()
                })
        */
        for (Expression expr : ast.getExpressions()) {
            cG.newLine();
            cG.line(expr.getLine());
            cG.comment("Read");
            expr.accept(addressCG, null);
            cG.input(expr.getType().suffix());
            cG.store(expr.getType().suffix());
        }

        return null;
    }

    @Override
    public Void visit(Print ast, FuncDefinition tp) {
        /*
            execute[[Print: stmt -> exp*]]()=
                exp*.forEach(e -> {
                    value[[e]]
                    <out> e.type.suffix()
                })
        */
        for (Expression expr : ast.getExpressions()) {
            cG.newLine();
            cG.line(expr.getLine());
            cG.comment("Write");
            expr.accept(valueCG, null);
            cG.output(expr.getType().suffix());
        }

        return null;
    }

    @Override
    public Void visit(Return ast, FuncDefinition tp) {
        /*
            execute[[Return: stmt -> exp]](funcDef)=
                value[[exp]]
                if(exp.type.suffix() != 'i')
                    cG.conversion(exp.type.suffix(), funcDef.type.returnType.suffix())
                <ret> funcDef.type.returnType.numberOfBytes() <, >
                      funcDef.bytesLocalSum <, >
                      funcDef.typesParamsSum
        */
        cG.line(ast.getLine());
        cG.comment("Return");
        ast.getExpression().accept(valueCG, null);

        char from = ast.getExpression().getType().suffix();
        char to = ((FuncType) tp.getType()).getReturnType().suffix();
        if (from != to)
            cG.conversion(from, to);

        cG.returns(((FuncType) tp.getType()).getReturnType().numberOfBytes(), tp.bytesLocalSum(), tp.bytesParamsSum());

        return null;
    }

    @Override
    public Void visit(While ast, FuncDefinition tp) {
        /*
            execute[[While: stmt -> exp stmt*]]()=
                String loop = cG.getLabel();
                String end = cG.getLabel();
                loop <:>
                value[[exp]]
                if(exp.type.suffix() != 'i')
                    cG.conversion(exp.type.suffix, 'i')
                <jz> end
                stmt*.forEach(st -> execute[[st]])
                <jmp loop>
                end <:>
        */
        cG.line(ast.getLine());
        cG.comment("While");
        cG.newLine();
        cG.line(ast.getLine());
        String loop = cG.getLabel();
        String end = cG.getLabel();
        cG.label(loop);
        ast.getCondition().accept(valueCG, null);
        if(ast.getCondition().getType().suffix() != 'i')
            cG.conversion(ast.getCondition().getType().suffix(), 'i');
        cG.jz(end);
        cG.comment("While body");
        //cG.newLine();

        for (Statement st : ast.getBody()) {
            st.accept(this, tp);
        }
        cG.jmp(loop);
        cG.label(end);
        return null;
    }

    @Override
    public Void visit(FuncInvocation ast, FuncDefinition tp) {
        /*
            execute[[FuncInvocation: stmt -> exp exp*]]()=
                value[[(Expression) stmt]]()
                if(!(((Expression)stmt).type instanceof VoidType))
                    <pop> ((Expression)stmt).type.suffix()
        */
        cG.newLine();
        cG.line(ast.getLine());
        ast.accept(valueCG, null);
        if (!(ast.getType() instanceof VoidType)) {
            cG.pop(ast.getType().suffix());
        }

        return null;
    }

}
