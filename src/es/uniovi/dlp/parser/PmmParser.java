// Generated from /Users/danielonisfabian/Desktop/DLP/Pmm/ws/Pmm-UO293946/src/es/uniovi/dlp/parser/Pmm.g4 by ANTLR 4.13.2
package es.uniovi.dlp.parser;

    import es.uniovi.dlp.ast.*;
    import es.uniovi.dlp.ast.types.*;
    import es.uniovi.dlp.ast.expressions.*;
    import es.uniovi.dlp.ast.statements.*;
    import es.uniovi.dlp.ast.definitions.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, SINGLE_LINE_COMMENT=40, MULTIPLE_LINE_COMMENT=41, IDENTIFIER=42, 
		INT_CONSTANT=43, CHAR_CONSTANT=44, REAL_CONSTANT=45, WS=46;
	public static final int
		RULE_program = 0, RULE_definition = 1, RULE_main_definition = 2, RULE_var_definition = 3, 
		RULE_func_definition = 4, RULE_params = 5, RULE_func_body = 6, RULE_expression = 7, 
		RULE_statement = 8, RULE_block = 9, RULE_func_invocation = 10, RULE_type = 11, 
		RULE_built_in = 12, RULE_struct_field = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definition", "main_definition", "var_definition", "func_definition", 
			"params", "func_body", "expression", "statement", "block", "func_invocation", 
			"type", "built_in", "struct_field"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'main'", "'('", "')'", "'->'", "'None'", "':'", "'{'", 
			"'}'", "','", "';'", "'.'", "'['", "']'", "'-'", "'!'", "'*'", "'/'", 
			"'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", "'=='", "'&&'", "'||'", 
			"'print'", "'input'", "'return'", "'while'", "'if'", "'else:'", "'='", 
			"'struct'", "'int'", "'double'", "'char'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "SINGLE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT", 
			"IDENTIFIER", "INT_CONSTANT", "CHAR_CONSTANT", "REAL_CONSTANT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> definitions = new ArrayList<>();
		public DefinitionContext d;
		public Main_definitionContext m;
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public Main_definitionContext main_definition() {
			return getRuleContext(Main_definitionContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(28);
					((ProgramContext)_localctx).d = definition();
					 _localctx.definitions.addAll(((ProgramContext)_localctx).d.ast); 
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(36);
			((ProgramContext)_localctx).m = main_definition();
			 _localctx.definitions.add(((ProgramContext)_localctx).m.ast); 
			setState(38);
			match(EOF);
			 ((ProgramContext)_localctx).ast =  new Program(_localctx.definitions); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<>();
		public Var_definitionContext v;
		public Func_definitionContext f;
		public Var_definitionContext var_definition() {
			return getRuleContext(Var_definitionContext.class,0);
		}
		public Func_definitionContext func_definition() {
			return getRuleContext(Func_definitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitDefinition(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				((DefinitionContext)_localctx).v = var_definition();
				 _localctx.ast.addAll(((DefinitionContext)_localctx).v.ast); 
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				((DefinitionContext)_localctx).f = func_definition();
				 _localctx.ast.add(((DefinitionContext)_localctx).f.ast); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Main_definitionContext extends ParserRuleContext {
		public Definition ast;
		public Token ID;
		public Func_bodyContext f;
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public Main_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterMain_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitMain_definition(this);
		}
	}

	public final Main_definitionContext main_definition() throws RecognitionException {
		Main_definitionContext _localctx = new Main_definitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__0);
			setState(50);
			((Main_definitionContext)_localctx).ID = match(T__1);
			setState(51);
			match(T__2);
			setState(52);
			match(T__3);
			setState(53);
			match(T__4);
			setState(54);
			match(T__5);
			setState(55);
			match(T__6);
			setState(56);
			match(T__7);
			setState(57);
			((Main_definitionContext)_localctx).f = func_body();
			setState(58);
			match(T__8);
			 ((Main_definitionContext)_localctx).ast =  new FuncDefinition(((Main_definitionContext)_localctx).ID.getLine(), ((Main_definitionContext)_localctx).ID.getCharPositionInLine()+1, "main", new FuncType(VoidType.getInstance(), new ArrayList<VarDefinition>()), ((Main_definitionContext)_localctx).f.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_definitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<>();
		public List<String> ids = new ArrayList<>();
		public List<Integer> cols = new ArrayList<>();
		public Token ID1;
		public Token ID2;
		public TypeContext t;
		public List<TerminalNode> IDENTIFIER() { return getTokens(PmmParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PmmParser.IDENTIFIER, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Var_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterVar_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitVar_definition(this);
		}
	}

	public final Var_definitionContext var_definition() throws RecognitionException {
		Var_definitionContext _localctx = new Var_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			((Var_definitionContext)_localctx).ID1 = match(IDENTIFIER);
			 _localctx.ids.add((((Var_definitionContext)_localctx).ID1!=null?((Var_definitionContext)_localctx).ID1.getText():null)); _localctx.cols.add(((Var_definitionContext)_localctx).ID1.getCharPositionInLine()+1); 
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(63);
				match(T__9);
				setState(64);
				((Var_definitionContext)_localctx).ID2 = match(IDENTIFIER);
				 _localctx.ids.add((((Var_definitionContext)_localctx).ID2!=null?((Var_definitionContext)_localctx).ID2.getText():null)); _localctx.cols.add(((Var_definitionContext)_localctx).ID2.getCharPositionInLine()+1); 
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(T__6);
			setState(72);
			((Var_definitionContext)_localctx).t = type();
			setState(73);
			match(T__10);

			            int counter = 0;
			            for(String id : _localctx.ids){
			                int line = ((Var_definitionContext)_localctx).ID1.getLine();
			                int column = _localctx.cols.get(counter);
			                VarDefinition v = new VarDefinition(line, column, id, ((Var_definitionContext)_localctx).t.ast);
			                if(_localctx.ast.contains(v)) new ErrorType("Cannot have variable '" + id + "' duplicated: (line: " + line + ", column: " + column + ")", v);
			                _localctx.ast.add(v);
			                counter++;
			            }
			         
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_definitionContext extends ParserRuleContext {
		public Definition ast;
		public List<VarDefinition> parameters = new ArrayList<>();
		public Type returnType;
		public Token ID;
		public ParamsContext p;
		public Built_inContext b;
		public Token n;
		public Func_bodyContext f;
		public TerminalNode IDENTIFIER() { return getToken(PmmParser.IDENTIFIER, 0); }
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Built_inContext built_in() {
			return getRuleContext(Built_inContext.class,0);
		}
		public Func_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterFunc_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitFunc_definition(this);
		}
	}

	public final Func_definitionContext func_definition() throws RecognitionException {
		Func_definitionContext _localctx = new Func_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__0);
			setState(77);
			((Func_definitionContext)_localctx).ID = match(IDENTIFIER);
			setState(78);
			match(T__2);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(79);
				((Func_definitionContext)_localctx).p = params();
				 ((Func_definitionContext)_localctx).parameters =  ((Func_definitionContext)_localctx).p.ast; 
				}
			}

			setState(84);
			match(T__3);
			setState(85);
			match(T__4);
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
			case T__37:
			case T__38:
				{
				{
				setState(86);
				((Func_definitionContext)_localctx).b = built_in();
				}
				 ((Func_definitionContext)_localctx).returnType =  ((Func_definitionContext)_localctx).b.ast; 
				}
				break;
			case T__5:
				{
				setState(89);
				((Func_definitionContext)_localctx).n = match(T__5);
				 ((Func_definitionContext)_localctx).returnType =  VoidType.getInstance(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(93);
			match(T__6);
			setState(94);
			match(T__7);
			setState(95);
			((Func_definitionContext)_localctx).f = func_body();
			setState(96);
			match(T__8);
			 ((Func_definitionContext)_localctx).ast =  new FuncDefinition(((Func_definitionContext)_localctx).ID.getLine(), ((Func_definitionContext)_localctx).ID.getCharPositionInLine()+1, (((Func_definitionContext)_localctx).ID!=null?((Func_definitionContext)_localctx).ID.getText():null), new FuncType(_localctx.returnType, _localctx.parameters), ((Func_definitionContext)_localctx).f.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<>();
		public Token ID1;
		public Built_inContext t1;
		public Token ID2;
		public Built_inContext t2;
		public List<TerminalNode> IDENTIFIER() { return getTokens(PmmParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PmmParser.IDENTIFIER, i);
		}
		public List<Built_inContext> built_in() {
			return getRuleContexts(Built_inContext.class);
		}
		public Built_inContext built_in(int i) {
			return getRuleContext(Built_inContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			((ParamsContext)_localctx).ID1 = match(IDENTIFIER);
			setState(100);
			match(T__6);
			setState(101);
			((ParamsContext)_localctx).t1 = built_in();
			 _localctx.ast.add(new VarDefinition(((ParamsContext)_localctx).ID1.getLine(), ((ParamsContext)_localctx).ID1.getCharPositionInLine()+1, (((ParamsContext)_localctx).ID1!=null?((ParamsContext)_localctx).ID1.getText():null), ((ParamsContext)_localctx).t1.ast)); 
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(103);
				match(T__9);
				setState(104);
				((ParamsContext)_localctx).ID2 = match(IDENTIFIER);
				setState(105);
				match(T__6);
				setState(106);
				((ParamsContext)_localctx).t2 = built_in();
				 _localctx.ast.add(new VarDefinition(((ParamsContext)_localctx).ID2.getLine(), ((ParamsContext)_localctx).ID2.getCharPositionInLine()+1, (((ParamsContext)_localctx).ID2!=null?((ParamsContext)_localctx).ID2.getText():null), ((ParamsContext)_localctx).t2.ast)); 
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_bodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public Var_definitionContext v;
		public StatementContext s;
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Func_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterFunc_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitFunc_body(this);
		}
	}

	public final Func_bodyContext func_body() throws RecognitionException {
		Func_bodyContext _localctx = new Func_bodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_func_body);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(114);
					((Func_bodyContext)_localctx).v = var_definition();
					 _localctx.ast.addAll(((Func_bodyContext)_localctx).v.ast); 
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65987340763144L) != 0)) {
				{
				{
				setState(122);
				((Func_bodyContext)_localctx).s = statement();
				 _localctx.ast.add(((Func_bodyContext)_localctx).s.ast); 
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext exp;
		public ExpressionContext exp1;
		public Func_invocationContext f;
		public TypeContext t;
		public Token ID;
		public Token CONST;
		public Token OP;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Func_invocationContext func_invocation() {
			return getRuleContext(Func_invocationContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(PmmParser.IDENTIFIER, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(131);
				match(T__2);
				setState(132);
				((ExpressionContext)_localctx).exp = expression(0);
				setState(133);
				match(T__3);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).exp.ast; 
				}
				break;
			case 2:
				{
				setState(136);
				((ExpressionContext)_localctx).f = func_invocation();
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).f.ast; 
				}
				break;
			case 3:
				{
				setState(139);
				match(T__2);
				setState(140);
				((ExpressionContext)_localctx).t = type();
				setState(141);
				match(T__3);
				setState(142);
				((ExpressionContext)_localctx).exp = expression(11);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast, ((ExpressionContext)_localctx).t.ast); 
				}
				break;
			case 4:
				{
				setState(145);
				match(T__14);
				setState(146);
				((ExpressionContext)_localctx).exp = expression(10);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast); 
				}
				break;
			case 5:
				{
				setState(149);
				match(T__15);
				setState(150);
				((ExpressionContext)_localctx).exp = expression(9);
				 ((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast); 
				}
				break;
			case 6:
				{
				setState(153);
				((ExpressionContext)_localctx).ID = match(IDENTIFIER);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 7:
				{
				setState(155);
				((ExpressionContext)_localctx).CONST = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).CONST.getLine(), ((ExpressionContext)_localctx).CONST.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).CONST!=null?((ExpressionContext)_localctx).CONST.getText():null))); 
				}
				break;
			case 8:
				{
				setState(157);
				((ExpressionContext)_localctx).CONST = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).CONST.getLine(), ((ExpressionContext)_localctx).CONST.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).CONST!=null?((ExpressionContext)_localctx).CONST.getText():null))); 
				}
				break;
			case 9:
				{
				setState(159);
				((ExpressionContext)_localctx).CONST = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CONST.getLine(), ((ExpressionContext)_localctx).CONST.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CONST!=null?((ExpressionContext)_localctx).CONST.getText():null))); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(193);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(163);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(164);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 917504L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(165);
						((ExpressionContext)_localctx).exp2 = expression(9);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(168);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(169);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==T__19) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(170);
						((ExpressionContext)_localctx).exp2 = expression(8);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(173);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(174);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 132120576L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(175);
						((ExpressionContext)_localctx).exp2 = expression(7);
						 ((ExpressionContext)_localctx).ast =  new Comparison(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(178);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(179);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__27) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(180);
						((ExpressionContext)_localctx).exp2 = expression(6);
						 ((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(184);
						match(T__11);
						setState(185);
						((ExpressionContext)_localctx).ID = match(IDENTIFIER);
						 ((ExpressionContext)_localctx).ast =  new FieldAccess(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(187);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(188);
						match(T__12);
						setState(189);
						((ExpressionContext)_localctx).exp2 = expression(0);
						setState(190);
						match(T__13);
						 ((ExpressionContext)_localctx).ast =   new ArrayAccess(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast); 
						}
						break;
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public List<Expression> expressions;
		public List<Statement> elseBlock = new ArrayList<>();
		public Func_invocationContext f;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public ExpressionContext exp;
		public BlockContext b;
		public BlockContext b1;
		public BlockContext b2;
		public Func_invocationContext func_invocation() {
			return getRuleContext(Func_invocationContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				((StatementContext)_localctx).f = func_invocation();
				setState(199);
				match(T__10);
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).f.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(T__28);
				setState(203);
				((StatementContext)_localctx).exp1 = expression(0);
				 ((StatementContext)_localctx).expressions =  new ArrayList<>(); _localctx.expressions.add(((StatementContext)_localctx).exp1.ast); 
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(205);
					match(T__9);
					setState(206);
					((StatementContext)_localctx).exp2 = expression(0);
					 _localctx.expressions.add(((StatementContext)_localctx).exp2.ast); 
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(214);
				match(T__10);
				 ((StatementContext)_localctx).ast =  new Print(((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn(), _localctx.expressions); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				match(T__29);
				setState(218);
				((StatementContext)_localctx).exp1 = expression(0);
				 ((StatementContext)_localctx).expressions =  new ArrayList<>(); _localctx.expressions.add(((StatementContext)_localctx).exp1.ast); 
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(220);
					match(T__9);
					setState(221);
					((StatementContext)_localctx).exp2 = expression(0);
					 _localctx.expressions.add(((StatementContext)_localctx).exp2.ast); 
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(229);
				match(T__10);
				 ((StatementContext)_localctx).ast =  new Input(((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn(), _localctx.expressions); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				match(T__30);
				setState(233);
				((StatementContext)_localctx).exp = expression(0);
				setState(234);
				match(T__10);
				 ((StatementContext)_localctx).ast =  new Return(((StatementContext)_localctx).exp.ast.getLine(), ((StatementContext)_localctx).exp.ast.getColumn(), ((StatementContext)_localctx).exp.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(237);
				match(T__31);
				setState(238);
				((StatementContext)_localctx).exp = expression(0);
				setState(239);
				match(T__6);
				setState(240);
				((StatementContext)_localctx).b = block();
				 ((StatementContext)_localctx).ast =  new While(((StatementContext)_localctx).exp.ast.getLine(), ((StatementContext)_localctx).exp.ast.getColumn(), ((StatementContext)_localctx).exp.ast, ((StatementContext)_localctx).b.ast); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(243);
				match(T__32);
				setState(244);
				((StatementContext)_localctx).exp = expression(0);
				setState(245);
				match(T__6);
				setState(246);
				((StatementContext)_localctx).b1 = block();
				setState(251);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(247);
					match(T__33);
					setState(248);
					((StatementContext)_localctx).b2 = block();
					 ((StatementContext)_localctx).elseBlock =  ((StatementContext)_localctx).b2.ast; 
					}
					break;
				}
				 ((StatementContext)_localctx).ast =  new Conditional(((StatementContext)_localctx).exp.ast.getLine(), ((StatementContext)_localctx).exp.ast.getColumn(), ((StatementContext)_localctx).exp.ast, ((StatementContext)_localctx).b1.ast, _localctx.elseBlock); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(255);
				((StatementContext)_localctx).exp1 = expression(0);
				setState(256);
				match(T__34);
				setState(257);
				((StatementContext)_localctx).exp2 = expression(0);
				setState(258);
				match(T__10);
				 ((StatementContext)_localctx).ast =  new Assignment(((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn(), ((StatementContext)_localctx).exp1.ast, ((StatementContext)_localctx).exp2.ast); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();;
		public StatementContext st;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block);
		int _la;
		try {
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__14:
			case T__15:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case IDENTIFIER:
			case INT_CONSTANT:
			case CHAR_CONSTANT:
			case REAL_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				((BlockContext)_localctx).st = statement();
				 _localctx.ast.add(((BlockContext)_localctx).st.ast); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(T__7);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65987340763144L) != 0)) {
					{
					{
					setState(267);
					((BlockContext)_localctx).st = statement();
					 _localctx.ast.add(((BlockContext)_localctx).st.ast); 
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(275);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_invocationContext extends ParserRuleContext {
		public FuncInvocation ast;
		public List<Expression> expressions = new ArrayList<>();
		public Token ID;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public TerminalNode IDENTIFIER() { return getToken(PmmParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Func_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterFunc_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitFunc_invocation(this);
		}
	}

	public final Func_invocationContext func_invocation() throws RecognitionException {
		Func_invocationContext _localctx = new Func_invocationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_func_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			((Func_invocationContext)_localctx).ID = match(IDENTIFIER);
			setState(279);
			match(T__2);
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65970697764872L) != 0)) {
				{
				setState(280);
				((Func_invocationContext)_localctx).exp1 = expression(0);
				 _localctx.expressions.add(((Func_invocationContext)_localctx).exp1.ast); 
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(282);
					match(T__9);
					setState(283);
					((Func_invocationContext)_localctx).exp2 = expression(0);
					 _localctx.expressions.add(((Func_invocationContext)_localctx).exp2.ast); 
					}
					}
					setState(290);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(293);
			match(T__3);
			 ((Func_invocationContext)_localctx).ast =  new FuncInvocation(((Func_invocationContext)_localctx).ID.getLine(), ((Func_invocationContext)_localctx).ID.getCharPositionInLine()+1, new Variable(((Func_invocationContext)_localctx).ID.getLine(), ((Func_invocationContext)_localctx).ID.getCharPositionInLine()+1, (((Func_invocationContext)_localctx).ID!=null?((Func_invocationContext)_localctx).ID.getText():null)), _localctx.expressions); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public List<StructField> fields = new ArrayList<>();
		public Built_inContext built_in;
		public Token I;
		public TypeContext t;
		public Struct_fieldContext sf;
		public Built_inContext built_in() {
			return getRuleContext(Built_inContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<Struct_fieldContext> struct_field() {
			return getRuleContexts(Struct_fieldContext.class);
		}
		public Struct_fieldContext struct_field(int i) {
			return getRuleContext(Struct_fieldContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
			case T__37:
			case T__38:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				((TypeContext)_localctx).built_in = built_in();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).built_in.ast; 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				match(T__12);
				setState(300);
				((TypeContext)_localctx).I = match(INT_CONSTANT);
				setState(301);
				match(T__13);
				setState(302);
				((TypeContext)_localctx).t = type();
				 ((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).t.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).I!=null?((TypeContext)_localctx).I.getText():null))); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				match(T__35);
				setState(306);
				match(T__7);
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(307);
					((TypeContext)_localctx).sf = struct_field();

					        for(StructField f : ((TypeContext)_localctx).sf.ast){
					            if(_localctx.fields.contains(f)) new ErrorType("Cannot have field '" + f.getName() + "' duplicated: (line: " + f.getLine() + ", column: " + f.getColumn() + ")", f);
					            _localctx.fields.add(f);
					        }
					    
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(315);
				match(T__8);
				 ((TypeContext)_localctx).ast =  new StructType(_localctx.fields); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Built_inContext extends ParserRuleContext {
		public Type ast;
		public Built_inContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built_in; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterBuilt_in(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitBuilt_in(this);
		}
	}

	public final Built_inContext built_in() throws RecognitionException {
		Built_inContext _localctx = new Built_inContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_built_in);
		try {
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				match(T__36);
				 ((Built_inContext)_localctx).ast =  IntType.getInstance(); 
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				match(T__37);
				 ((Built_inContext)_localctx).ast =  DoubleType.getInstance(); 
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 3);
				{
				setState(323);
				match(T__38);
				 ((Built_inContext)_localctx).ast =  CharType.getInstance(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_fieldContext extends ParserRuleContext {
		public List<StructField> ast = new ArrayList<>();
		public List<String> ids = new ArrayList<>();
		public List<Integer> cols = new ArrayList<>();
		public Token ID1;
		public Token ID2;
		public TypeContext t;
		public List<TerminalNode> IDENTIFIER() { return getTokens(PmmParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PmmParser.IDENTIFIER, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Struct_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterStruct_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitStruct_field(this);
		}
	}

	public final Struct_fieldContext struct_field() throws RecognitionException {
		Struct_fieldContext _localctx = new Struct_fieldContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_struct_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			((Struct_fieldContext)_localctx).ID1 = match(IDENTIFIER);
			 _localctx.ids.add((((Struct_fieldContext)_localctx).ID1!=null?((Struct_fieldContext)_localctx).ID1.getText():null)); _localctx.cols.add(((Struct_fieldContext)_localctx).ID1.getCharPositionInLine()+1); 
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(329);
				match(T__9);
				setState(330);
				((Struct_fieldContext)_localctx).ID2 = match(IDENTIFIER);
				 _localctx.ids.add((((Struct_fieldContext)_localctx).ID2!=null?((Struct_fieldContext)_localctx).ID2.getText():null)); _localctx.cols.add(((Struct_fieldContext)_localctx).ID2.getCharPositionInLine()+1); 
				}
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(337);
			match(T__6);
			setState(338);
			((Struct_fieldContext)_localctx).t = type();
			setState(339);
			match(T__10);

			            int counter = 0;
			            for(String id : _localctx.ids){
			                StructField field = new StructField(((Struct_fieldContext)_localctx).ID1.getLine(), _localctx.cols.get(counter), id, ((Struct_fieldContext)_localctx).t.ast);
			                //if(_localctx.ast.contains(field)) new ErrorType("Cannot have field '" + id + "' duplicated", field);
			                _localctx.ast.add(field);
			                counter++;
			            }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u0157\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u00010\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003C\b\u0003\n\u0003\f\u0003"+
		"F\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004S\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\\\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005n\b\u0005\n\u0005\f\u0005"+
		"q\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006v\b\u0006\n\u0006"+
		"\f\u0006y\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006~\b\u0006"+
		"\n\u0006\f\u0006\u0081\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a2\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u00c2\b\u0007\n\u0007\f\u0007\u00c5\t\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u00d2\b\b\n\b\f\b\u00d5\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00e1\b\b\n\b\f\b\u00e4"+
		"\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00fc\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0106\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u010f\b\t\n\t\f\t\u0112"+
		"\t\t\u0001\t\u0003\t\u0115\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0005\n\u011f\b\n\n\n\f\n\u0122\t\n\u0003\n\u0124"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0137"+
		"\b\u000b\n\u000b\f\u000b\u013a\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u013e\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f"+
		"\u0146\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u014d\b\r\n"+
		"\r\f\r\u0150\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0000"+
		"\u0001\u000e\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u0000\u0004\u0001\u0000\u0011\u0013\u0002\u0000\u000f"+
		"\u000f\u0014\u0014\u0001\u0000\u0015\u001a\u0001\u0000\u001b\u001c\u0171"+
		"\u0000!\u0001\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u00041"+
		"\u0001\u0000\u0000\u0000\u0006=\u0001\u0000\u0000\u0000\bL\u0001\u0000"+
		"\u0000\u0000\nc\u0001\u0000\u0000\u0000\fw\u0001\u0000\u0000\u0000\u000e"+
		"\u00a1\u0001\u0000\u0000\u0000\u0010\u0105\u0001\u0000\u0000\u0000\u0012"+
		"\u0114\u0001\u0000\u0000\u0000\u0014\u0116\u0001\u0000\u0000\u0000\u0016"+
		"\u013d\u0001\u0000\u0000\u0000\u0018\u0145\u0001\u0000\u0000\u0000\u001a"+
		"\u0147\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0002\u0001\u0000\u001d"+
		"\u001e\u0006\u0000\uffff\uffff\u0000\u001e \u0001\u0000\u0000\u0000\u001f"+
		"\u001c\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001"+
		"\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000"+
		"#!\u0001\u0000\u0000\u0000$%\u0003\u0004\u0002\u0000%&\u0006\u0000\uffff"+
		"\uffff\u0000&\'\u0005\u0000\u0000\u0001\'(\u0006\u0000\uffff\uffff\u0000"+
		"(\u0001\u0001\u0000\u0000\u0000)*\u0003\u0006\u0003\u0000*+\u0006\u0001"+
		"\uffff\uffff\u0000+0\u0001\u0000\u0000\u0000,-\u0003\b\u0004\u0000-.\u0006"+
		"\u0001\uffff\uffff\u0000.0\u0001\u0000\u0000\u0000/)\u0001\u0000\u0000"+
		"\u0000/,\u0001\u0000\u0000\u00000\u0003\u0001\u0000\u0000\u000012\u0005"+
		"\u0001\u0000\u000023\u0005\u0002\u0000\u000034\u0005\u0003\u0000\u0000"+
		"45\u0005\u0004\u0000\u000056\u0005\u0005\u0000\u000067\u0005\u0006\u0000"+
		"\u000078\u0005\u0007\u0000\u000089\u0005\b\u0000\u00009:\u0003\f\u0006"+
		"\u0000:;\u0005\t\u0000\u0000;<\u0006\u0002\uffff\uffff\u0000<\u0005\u0001"+
		"\u0000\u0000\u0000=>\u0005*\u0000\u0000>D\u0006\u0003\uffff\uffff\u0000"+
		"?@\u0005\n\u0000\u0000@A\u0005*\u0000\u0000AC\u0006\u0003\uffff\uffff"+
		"\u0000B?\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000"+
		"\u0000\u0000DE\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000FD\u0001"+
		"\u0000\u0000\u0000GH\u0005\u0007\u0000\u0000HI\u0003\u0016\u000b\u0000"+
		"IJ\u0005\u000b\u0000\u0000JK\u0006\u0003\uffff\uffff\u0000K\u0007\u0001"+
		"\u0000\u0000\u0000LM\u0005\u0001\u0000\u0000MN\u0005*\u0000\u0000NR\u0005"+
		"\u0003\u0000\u0000OP\u0003\n\u0005\u0000PQ\u0006\u0004\uffff\uffff\u0000"+
		"QS\u0001\u0000\u0000\u0000RO\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TU\u0005\u0004\u0000\u0000U[\u0005\u0005"+
		"\u0000\u0000VW\u0003\u0018\f\u0000WX\u0006\u0004\uffff\uffff\u0000X\\"+
		"\u0001\u0000\u0000\u0000YZ\u0005\u0006\u0000\u0000Z\\\u0006\u0004\uffff"+
		"\uffff\u0000[V\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]^\u0005\u0007\u0000\u0000^_\u0005\b\u0000\u0000_`\u0003"+
		"\f\u0006\u0000`a\u0005\t\u0000\u0000ab\u0006\u0004\uffff\uffff\u0000b"+
		"\t\u0001\u0000\u0000\u0000cd\u0005*\u0000\u0000de\u0005\u0007\u0000\u0000"+
		"ef\u0003\u0018\f\u0000fo\u0006\u0005\uffff\uffff\u0000gh\u0005\n\u0000"+
		"\u0000hi\u0005*\u0000\u0000ij\u0005\u0007\u0000\u0000jk\u0003\u0018\f"+
		"\u0000kl\u0006\u0005\uffff\uffff\u0000ln\u0001\u0000\u0000\u0000mg\u0001"+
		"\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000p\u000b\u0001\u0000\u0000\u0000qo\u0001\u0000"+
		"\u0000\u0000rs\u0003\u0006\u0003\u0000st\u0006\u0006\uffff\uffff\u0000"+
		"tv\u0001\u0000\u0000\u0000ur\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x\u007f\u0001"+
		"\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0003\u0010\b\u0000{|\u0006"+
		"\u0006\uffff\uffff\u0000|~\u0001\u0000\u0000\u0000}z\u0001\u0000\u0000"+
		"\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\r\u0001\u0000\u0000\u0000\u0081\u007f"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0006\u0007\uffff\uffff\u0000\u0083"+
		"\u0084\u0005\u0003\u0000\u0000\u0084\u0085\u0003\u000e\u0007\u0000\u0085"+
		"\u0086\u0005\u0004\u0000\u0000\u0086\u0087\u0006\u0007\uffff\uffff\u0000"+
		"\u0087\u00a2\u0001\u0000\u0000\u0000\u0088\u0089\u0003\u0014\n\u0000\u0089"+
		"\u008a\u0006\u0007\uffff\uffff\u0000\u008a\u00a2\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0005\u0003\u0000\u0000\u008c\u008d\u0003\u0016\u000b\u0000"+
		"\u008d\u008e\u0005\u0004\u0000\u0000\u008e\u008f\u0003\u000e\u0007\u000b"+
		"\u008f\u0090\u0006\u0007\uffff\uffff\u0000\u0090\u00a2\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0005\u000f\u0000\u0000\u0092\u0093\u0003\u000e\u0007"+
		"\n\u0093\u0094\u0006\u0007\uffff\uffff\u0000\u0094\u00a2\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0005\u0010\u0000\u0000\u0096\u0097\u0003\u000e\u0007"+
		"\t\u0097\u0098\u0006\u0007\uffff\uffff\u0000\u0098\u00a2\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0005*\u0000\u0000\u009a\u00a2\u0006\u0007\uffff\uffff"+
		"\u0000\u009b\u009c\u0005+\u0000\u0000\u009c\u00a2\u0006\u0007\uffff\uffff"+
		"\u0000\u009d\u009e\u0005-\u0000\u0000\u009e\u00a2\u0006\u0007\uffff\uffff"+
		"\u0000\u009f\u00a0\u0005,\u0000\u0000\u00a0\u00a2\u0006\u0007\uffff\uffff"+
		"\u0000\u00a1\u0082\u0001\u0000\u0000\u0000\u00a1\u0088\u0001\u0000\u0000"+
		"\u0000\u00a1\u008b\u0001\u0000\u0000\u0000\u00a1\u0091\u0001\u0000\u0000"+
		"\u0000\u00a1\u0095\u0001\u0000\u0000\u0000\u00a1\u0099\u0001\u0000\u0000"+
		"\u0000\u00a1\u009b\u0001\u0000\u0000\u0000\u00a1\u009d\u0001\u0000\u0000"+
		"\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00c3\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\n\b\u0000\u0000\u00a4\u00a5\u0007\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0003\u000e\u0007\t\u00a6\u00a7\u0006\u0007\uffff\uffff\u0000"+
		"\u00a7\u00c2\u0001\u0000\u0000\u0000\u00a8\u00a9\n\u0007\u0000\u0000\u00a9"+
		"\u00aa\u0007\u0001\u0000\u0000\u00aa\u00ab\u0003\u000e\u0007\b\u00ab\u00ac"+
		"\u0006\u0007\uffff\uffff\u0000\u00ac\u00c2\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\n\u0006\u0000\u0000\u00ae\u00af\u0007\u0002\u0000\u0000\u00af\u00b0"+
		"\u0003\u000e\u0007\u0007\u00b0\u00b1\u0006\u0007\uffff\uffff\u0000\u00b1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00b2\u00b3\n\u0005\u0000\u0000\u00b3\u00b4"+
		"\u0007\u0003\u0000\u0000\u00b4\u00b5\u0003\u000e\u0007\u0006\u00b5\u00b6"+
		"\u0006\u0007\uffff\uffff\u0000\u00b6\u00c2\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\n\r\u0000\u0000\u00b8\u00b9\u0005\f\u0000\u0000\u00b9\u00ba\u0005"+
		"*\u0000\u0000\u00ba\u00c2\u0006\u0007\uffff\uffff\u0000\u00bb\u00bc\n"+
		"\f\u0000\u0000\u00bc\u00bd\u0005\r\u0000\u0000\u00bd\u00be\u0003\u000e"+
		"\u0007\u0000\u00be\u00bf\u0005\u000e\u0000\u0000\u00bf\u00c0\u0006\u0007"+
		"\uffff\uffff\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00a3\u0001"+
		"\u0000\u0000\u0000\u00c1\u00a8\u0001\u0000\u0000\u0000\u00c1\u00ad\u0001"+
		"\u0000\u0000\u0000\u00c1\u00b2\u0001\u0000\u0000\u0000\u00c1\u00b7\u0001"+
		"\u0000\u0000\u0000\u00c1\u00bb\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c4\u000f\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0003\u0014\n\u0000\u00c7\u00c8\u0005\u000b"+
		"\u0000\u0000\u00c8\u00c9\u0006\b\uffff\uffff\u0000\u00c9\u0106\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0005\u001d\u0000\u0000\u00cb\u00cc\u0003\u000e"+
		"\u0007\u0000\u00cc\u00d3\u0006\b\uffff\uffff\u0000\u00cd\u00ce\u0005\n"+
		"\u0000\u0000\u00ce\u00cf\u0003\u000e\u0007\u0000\u00cf\u00d0\u0006\b\uffff"+
		"\uffff\u0000\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00cd\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u000b"+
		"\u0000\u0000\u00d7\u00d8\u0006\b\uffff\uffff\u0000\u00d8\u0106\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0005\u001e\u0000\u0000\u00da\u00db\u0003\u000e"+
		"\u0007\u0000\u00db\u00e2\u0006\b\uffff\uffff\u0000\u00dc\u00dd\u0005\n"+
		"\u0000\u0000\u00dd\u00de\u0003\u000e\u0007\u0000\u00de\u00df\u0006\b\uffff"+
		"\uffff\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00dc\u0001\u0000"+
		"\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005\u000b"+
		"\u0000\u0000\u00e6\u00e7\u0006\b\uffff\uffff\u0000\u00e7\u0106\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e9\u0005\u001f\u0000\u0000\u00e9\u00ea\u0003\u000e"+
		"\u0007\u0000\u00ea\u00eb\u0005\u000b\u0000\u0000\u00eb\u00ec\u0006\b\uffff"+
		"\uffff\u0000\u00ec\u0106\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005 \u0000"+
		"\u0000\u00ee\u00ef\u0003\u000e\u0007\u0000\u00ef\u00f0\u0005\u0007\u0000"+
		"\u0000\u00f0\u00f1\u0003\u0012\t\u0000\u00f1\u00f2\u0006\b\uffff\uffff"+
		"\u0000\u00f2\u0106\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005!\u0000\u0000"+
		"\u00f4\u00f5\u0003\u000e\u0007\u0000\u00f5\u00f6\u0005\u0007\u0000\u0000"+
		"\u00f6\u00fb\u0003\u0012\t\u0000\u00f7\u00f8\u0005\"\u0000\u0000\u00f8"+
		"\u00f9\u0003\u0012\t\u0000\u00f9\u00fa\u0006\b\uffff\uffff\u0000\u00fa"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fb\u00f7\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd"+
		"\u00fe\u0006\b\uffff\uffff\u0000\u00fe\u0106\u0001\u0000\u0000\u0000\u00ff"+
		"\u0100\u0003\u000e\u0007\u0000\u0100\u0101\u0005#\u0000\u0000\u0101\u0102"+
		"\u0003\u000e\u0007\u0000\u0102\u0103\u0005\u000b\u0000\u0000\u0103\u0104"+
		"\u0006\b\uffff\uffff\u0000\u0104\u0106\u0001\u0000\u0000\u0000\u0105\u00c6"+
		"\u0001\u0000\u0000\u0000\u0105\u00ca\u0001\u0000\u0000\u0000\u0105\u00d9"+
		"\u0001\u0000\u0000\u0000\u0105\u00e8\u0001\u0000\u0000\u0000\u0105\u00ed"+
		"\u0001\u0000\u0000\u0000\u0105\u00f3\u0001\u0000\u0000\u0000\u0105\u00ff"+
		"\u0001\u0000\u0000\u0000\u0106\u0011\u0001\u0000\u0000\u0000\u0107\u0108"+
		"\u0003\u0010\b\u0000\u0108\u0109\u0006\t\uffff\uffff\u0000\u0109\u0115"+
		"\u0001\u0000\u0000\u0000\u010a\u0110\u0005\b\u0000\u0000\u010b\u010c\u0003"+
		"\u0010\b\u0000\u010c\u010d\u0006\t\uffff\uffff\u0000\u010d\u010f\u0001"+
		"\u0000\u0000\u0000\u010e\u010b\u0001\u0000\u0000\u0000\u010f\u0112\u0001"+
		"\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0110\u0111\u0001"+
		"\u0000\u0000\u0000\u0111\u0113\u0001\u0000\u0000\u0000\u0112\u0110\u0001"+
		"\u0000\u0000\u0000\u0113\u0115\u0005\t\u0000\u0000\u0114\u0107\u0001\u0000"+
		"\u0000\u0000\u0114\u010a\u0001\u0000\u0000\u0000\u0115\u0013\u0001\u0000"+
		"\u0000\u0000\u0116\u0117\u0005*\u0000\u0000\u0117\u0123\u0005\u0003\u0000"+
		"\u0000\u0118\u0119\u0003\u000e\u0007\u0000\u0119\u0120\u0006\n\uffff\uffff"+
		"\u0000\u011a\u011b\u0005\n\u0000\u0000\u011b\u011c\u0003\u000e\u0007\u0000"+
		"\u011c\u011d\u0006\n\uffff\uffff\u0000\u011d\u011f\u0001\u0000\u0000\u0000"+
		"\u011e\u011a\u0001\u0000\u0000\u0000\u011f\u0122\u0001\u0000\u0000\u0000"+
		"\u0120\u011e\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000"+
		"\u0121\u0124\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000"+
		"\u0123\u0118\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000"+
		"\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u0126\u0005\u0004\u0000\u0000"+
		"\u0126\u0127\u0006\n\uffff\uffff\u0000\u0127\u0015\u0001\u0000\u0000\u0000"+
		"\u0128\u0129\u0003\u0018\f\u0000\u0129\u012a\u0006\u000b\uffff\uffff\u0000"+
		"\u012a\u013e\u0001\u0000\u0000\u0000\u012b\u012c\u0005\r\u0000\u0000\u012c"+
		"\u012d\u0005+\u0000\u0000\u012d\u012e\u0005\u000e\u0000\u0000\u012e\u012f"+
		"\u0003\u0016\u000b\u0000\u012f\u0130\u0006\u000b\uffff\uffff\u0000\u0130"+
		"\u013e\u0001\u0000\u0000\u0000\u0131\u0132\u0005$\u0000\u0000\u0132\u0138"+
		"\u0005\b\u0000\u0000\u0133\u0134\u0003\u001a\r\u0000\u0134\u0135\u0006"+
		"\u000b\uffff\uffff\u0000\u0135\u0137\u0001\u0000\u0000\u0000\u0136\u0133"+
		"\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0136"+
		"\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013b"+
		"\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u013c"+
		"\u0005\t\u0000\u0000\u013c\u013e\u0006\u000b\uffff\uffff\u0000\u013d\u0128"+
		"\u0001\u0000\u0000\u0000\u013d\u012b\u0001\u0000\u0000\u0000\u013d\u0131"+
		"\u0001\u0000\u0000\u0000\u013e\u0017\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u0005%\u0000\u0000\u0140\u0146\u0006\f\uffff\uffff\u0000\u0141\u0142"+
		"\u0005&\u0000\u0000\u0142\u0146\u0006\f\uffff\uffff\u0000\u0143\u0144"+
		"\u0005\'\u0000\u0000\u0144\u0146\u0006\f\uffff\uffff\u0000\u0145\u013f"+
		"\u0001\u0000\u0000\u0000\u0145\u0141\u0001\u0000\u0000\u0000\u0145\u0143"+
		"\u0001\u0000\u0000\u0000\u0146\u0019\u0001\u0000\u0000\u0000\u0147\u0148"+
		"\u0005*\u0000\u0000\u0148\u014e\u0006\r\uffff\uffff\u0000\u0149\u014a"+
		"\u0005\n\u0000\u0000\u014a\u014b\u0005*\u0000\u0000\u014b\u014d\u0006"+
		"\r\uffff\uffff\u0000\u014c\u0149\u0001\u0000\u0000\u0000\u014d\u0150\u0001"+
		"\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001"+
		"\u0000\u0000\u0000\u014f\u0151\u0001\u0000\u0000\u0000\u0150\u014e\u0001"+
		"\u0000\u0000\u0000\u0151\u0152\u0005\u0007\u0000\u0000\u0152\u0153\u0003"+
		"\u0016\u000b\u0000\u0153\u0154\u0005\u000b\u0000\u0000\u0154\u0155\u0006"+
		"\r\uffff\uffff\u0000\u0155\u001b\u0001\u0000\u0000\u0000\u0017!/DR[ow"+
		"\u007f\u00a1\u00c1\u00c3\u00d3\u00e2\u00fb\u0105\u0110\u0114\u0120\u0123"+
		"\u0138\u013d\u0145\u014e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}