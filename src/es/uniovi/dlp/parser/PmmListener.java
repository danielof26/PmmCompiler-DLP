// Generated from /Users/danielonisfabian/Desktop/DLP/Pmm/ws/Pmm-UO293946/src/es/uniovi/dlp/parser/Pmm.g4 by ANTLR 4.13.2
package es.uniovi.dlp.parser;

    import es.uniovi.dlp.ast.*;
    import es.uniovi.dlp.ast.types.*;
    import es.uniovi.dlp.ast.expressions.*;
    import es.uniovi.dlp.ast.statements.*;
    import es.uniovi.dlp.ast.definitions.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PmmParser}.
 */
public interface PmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#main_definition}.
	 * @param ctx the parse tree
	 */
	void enterMain_definition(PmmParser.Main_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#main_definition}.
	 * @param ctx the parse tree
	 */
	void exitMain_definition(PmmParser.Main_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#var_definition}.
	 * @param ctx the parse tree
	 */
	void enterVar_definition(PmmParser.Var_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#var_definition}.
	 * @param ctx the parse tree
	 */
	void exitVar_definition(PmmParser.Var_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#func_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunc_definition(PmmParser.Func_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#func_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunc_definition(PmmParser.Func_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(PmmParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(PmmParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#func_body}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body(PmmParser.Func_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#func_body}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body(PmmParser.Func_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PmmParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PmmParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#func_invocation}.
	 * @param ctx the parse tree
	 */
	void enterFunc_invocation(PmmParser.Func_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#func_invocation}.
	 * @param ctx the parse tree
	 */
	void exitFunc_invocation(PmmParser.Func_invocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#built_in}.
	 * @param ctx the parse tree
	 */
	void enterBuilt_in(PmmParser.Built_inContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#built_in}.
	 * @param ctx the parse tree
	 */
	void exitBuilt_in(PmmParser.Built_inContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#struct_field}.
	 * @param ctx the parse tree
	 */
	void enterStruct_field(PmmParser.Struct_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#struct_field}.
	 * @param ctx the parse tree
	 */
	void exitStruct_field(PmmParser.Struct_fieldContext ctx);
}