// Generated from /Users/lixiao/code/common-utils/src/main/resources/Pig.g4 by ANTLR 4.7
package com.anshishagua.pig;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PigParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, LOAD=3, INTEGER=4, LONGINTEGER=5, UNDER_SCORE=6, DOLAR=7, 
		SEMI_COLON=8, SINGLE_QUOTE=9, USING=10, LEFT_PAREN=11, RIGHT_PAREN=12, 
		AS=13, COLON=14, MAP=15, TUPLE=16, STAR=17, PATH_SEP=18, BOOLEAN_TYPE=19, 
		INT_TYPE=20, LONG_TYPE=21, FLOAT_TYPE=22, DOUBLE_TYPE=23, CHARARRAY_TYPE=24, 
		BYTEARRAY_TYPE=25, DATETIME_TYPE=26, BIGINTEGER_TYPE=27, BIGDECIMAL_TYPE=28, 
		COMMA=29, PARTITION=30, UNION=31, ALL=32, LEFT=33, RIGHT=34, FULL=35, 
		OUTER=36, ONSCHEMA=37, LEFT_BRACE=38, RIGHT_BRACE=39, JOIN=40, PARALLEL=41, 
		GROUP=42, SET=43, STR_OP_EQ=44, STR_OP_GT=45, STR_OP_LT=46, STR_OP_GTE=47, 
		STR_OP_LTE=48, STR_OP_NE=49, STR_OP_MATCHES=50, DOUBLENUMBER=51, TRUE=52, 
		FALSE=53, FLATTERN=54, QUOTEDSTRING=55, FLOATNUMBER=56, PERIOD=57, BY=58, 
		FILTER=59, DISTINCT=60, PARAM_PATTERN=61, INTO=62, STORE=63, FOREACH=64, 
		GENERATE=65, ASSIGN=66, PLUS=67, MINUS=68, MUL=69, DIV=70, MOD=71, QMARK=72, 
		AND=73, OR=74, NOT=75, IN=76, EQ=77, NEQ=78, LT=79, LTE=80, GT=81, GTE=82, 
		IS=83, NULL=84, IDENTIFIER=85, DOLLAR_VAR=86, END_OF_LINE_COMMENT=87, 
		COMMENT=88, WS=89;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_field = 2, RULE_dataType = 3, 
		RULE_fieldDefinetion = 4, RULE_function = 5, RULE_bbb = 6, RULE_setStatement = 7, 
		RULE_propertyValue = 8, RULE_loadStatement = 9, RULE_loadClause = 10, 
		RULE_schema = 11, RULE_forEachStatement = 12, RULE_foreach_generate_simple = 13, 
		RULE_foreach_plan_complex = 14, RULE_flatten_generated_item = 15, RULE_generate_as_clause = 16, 
		RULE_field_def_list = 17, RULE_field_def = 18, RULE_explicit_field_def = 19, 
		RULE_flatten_clause = 20, RULE_nested_blk = 21, RULE_nested_command = 22, 
		RULE_storeStatement = 23, RULE_distinctStatement = 24, RULE_filterStatement = 25, 
		RULE_joinStatement = 26, RULE_joinClause = 27, RULE_joinType = 28, RULE_joinSubClause = 29, 
		RULE_joinItem = 30, RULE_joinGroupByClause = 31, RULE_arg = 32, RULE_rel = 33, 
		RULE_partitionCaluse = 34, RULE_parallelClause = 35, RULE_groupStatement = 36, 
		RULE_unionStatement = 37, RULE_directory = 38, RULE_condition = 39, RULE_andCondition = 40, 
		RULE_notCondition = 41, RULE_unaryCondition = 42, RULE_expr = 43, RULE_multiExpr = 44, 
		RULE_basicExpression = 45, RULE_castType = 46, RULE_castExpr = 47, RULE_parenExpr = 48, 
		RULE_scalar = 49, RULE_relOp = 50, RULE_relStrOp = 51, RULE_nullExpression = 52, 
		RULE_className = 53;
	public static final String[] ruleNames = {
		"program", "statement", "field", "dataType", "fieldDefinetion", "function", 
		"bbb", "setStatement", "propertyValue", "loadStatement", "loadClause", 
		"schema", "forEachStatement", "foreach_generate_simple", "foreach_plan_complex", 
		"flatten_generated_item", "generate_as_clause", "field_def_list", "field_def", 
		"explicit_field_def", "flatten_clause", "nested_blk", "nested_command", 
		"storeStatement", "distinctStatement", "filterStatement", "joinStatement", 
		"joinClause", "joinType", "joinSubClause", "joinItem", "joinGroupByClause", 
		"arg", "rel", "partitionCaluse", "parallelClause", "groupStatement", "unionStatement", 
		"directory", "condition", "andCondition", "notCondition", "unaryCondition", 
		"expr", "multiExpr", "basicExpression", "castType", "castExpr", "parenExpr", 
		"scalar", "relOp", "relStrOp", "nullExpression", "className"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'|'", "'AAAAA'", "'LOAD'", null, null, "'_'", "'$'", "';'", "'''", 
		"'USING'", "'('", "')'", "'AS'", "':'", "'map'", "'tuple'", null, null, 
		"'boolean'", "'int'", "'long'", "'float'", "'double'", "'chararray'", 
		"'bytearray'", "'datetime'", "'biginteger'", "'bigdecimal'", "','", "'PARTITION'", 
		"'UNION'", "'ALL'", "'LEFT'", "'RIGHT'", "'FULL'", "'OUNTER'", "'ONSCHEMA'", 
		"'{'", "'}'", "'JOIN'", "'PARALLEL'", "'GROUP'", "'SET'", "'EQ'", "'GT'", 
		"'LT'", "'GTE'", "'LTE'", "'NEQ'", null, null, "'TRUE'", "'FALSE'", "'FLATTERN'", 
		null, null, "'.'", "'BY'", "'FILTER'", "'DISTINCT'", "'###'", "'INTO'", 
		"'STORE'", "'FOREACH'", "'GENERATE'", "'='", "'+'", "'-'", null, null, 
		"'%'", "'?'", "'AND'", "'OR'", "'NOT'", "'IN'", "'=='", "'!='", "'<'", 
		"'<='", "'>'", "'>='", "'is'", "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "LOAD", "INTEGER", "LONGINTEGER", "UNDER_SCORE", "DOLAR", 
		"SEMI_COLON", "SINGLE_QUOTE", "USING", "LEFT_PAREN", "RIGHT_PAREN", "AS", 
		"COLON", "MAP", "TUPLE", "STAR", "PATH_SEP", "BOOLEAN_TYPE", "INT_TYPE", 
		"LONG_TYPE", "FLOAT_TYPE", "DOUBLE_TYPE", "CHARARRAY_TYPE", "BYTEARRAY_TYPE", 
		"DATETIME_TYPE", "BIGINTEGER_TYPE", "BIGDECIMAL_TYPE", "COMMA", "PARTITION", 
		"UNION", "ALL", "LEFT", "RIGHT", "FULL", "OUTER", "ONSCHEMA", "LEFT_BRACE", 
		"RIGHT_BRACE", "JOIN", "PARALLEL", "GROUP", "SET", "STR_OP_EQ", "STR_OP_GT", 
		"STR_OP_LT", "STR_OP_GTE", "STR_OP_LTE", "STR_OP_NE", "STR_OP_MATCHES", 
		"DOUBLENUMBER", "TRUE", "FALSE", "FLATTERN", "QUOTEDSTRING", "FLOATNUMBER", 
		"PERIOD", "BY", "FILTER", "DISTINCT", "PARAM_PATTERN", "INTO", "STORE", 
		"FOREACH", "GENERATE", "ASSIGN", "PLUS", "MINUS", "MUL", "DIV", "MOD", 
		"QMARK", "AND", "OR", "NOT", "IN", "EQ", "NEQ", "LT", "LTE", "GT", "GTE", 
		"IS", "NULL", "IDENTIFIER", "DOLLAR_VAR", "END_OF_LINE_COMMENT", "COMMENT", 
		"WS"
	};
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
	public String getGrammarFileName() { return "Pig.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PigParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PigParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (SET - 43)) | (1L << (STORE - 43)) | (1L << (IDENTIFIER - 43)) | (1L << (COMMENT - 43)))) != 0)) {
				{
				{
				setState(108);
				statement();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			match(EOF);
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

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(PigParser.COMMENT, 0); }
		public SetStatementContext setStatement() {
			return getRuleContext(SetStatementContext.class,0);
		}
		public LoadStatementContext loadStatement() {
			return getRuleContext(LoadStatementContext.class,0);
		}
		public ForEachStatementContext forEachStatement() {
			return getRuleContext(ForEachStatementContext.class,0);
		}
		public StoreStatementContext storeStatement() {
			return getRuleContext(StoreStatementContext.class,0);
		}
		public DistinctStatementContext distinctStatement() {
			return getRuleContext(DistinctStatementContext.class,0);
		}
		public FilterStatementContext filterStatement() {
			return getRuleContext(FilterStatementContext.class,0);
		}
		public JoinStatementContext joinStatement() {
			return getRuleContext(JoinStatementContext.class,0);
		}
		public GroupStatementContext groupStatement() {
			return getRuleContext(GroupStatementContext.class,0);
		}
		public UnionStatementContext unionStatement() {
			return getRuleContext(UnionStatementContext.class,0);
		}
		public TerminalNode END_OF_LINE_COMMENT() { return getToken(PigParser.END_OF_LINE_COMMENT, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(COMMENT);
				}
				break;
			case SET:
			case STORE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(117);
					setStatement();
					}
					break;
				case 2:
					{
					setState(118);
					loadStatement();
					}
					break;
				case 3:
					{
					setState(119);
					forEachStatement();
					}
					break;
				case 4:
					{
					setState(120);
					storeStatement();
					}
					break;
				case 5:
					{
					setState(121);
					distinctStatement();
					}
					break;
				case 6:
					{
					setState(122);
					filterStatement();
					}
					break;
				case 7:
					{
					setState(123);
					joinStatement();
					}
					break;
				case 8:
					{
					setState(124);
					groupStatement();
					}
					break;
				case 9:
					{
					setState(125);
					unionStatement();
					}
					break;
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END_OF_LINE_COMMENT) {
					{
					setState(128);
					match(END_OF_LINE_COMMENT);
					}
				}

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

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public TerminalNode DOLAR() { return getToken(PigParser.DOLAR, 0); }
		public TerminalNode INTEGER() { return getToken(PigParser.INTEGER, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_field);
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				match(IDENTIFIER);
				}
				break;
			case DOLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(DOLAR);
				setState(135);
				match(INTEGER);
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

	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN_TYPE() { return getToken(PigParser.BOOLEAN_TYPE, 0); }
		public TerminalNode INT_TYPE() { return getToken(PigParser.INT_TYPE, 0); }
		public TerminalNode LONG_TYPE() { return getToken(PigParser.LONG_TYPE, 0); }
		public TerminalNode FLOAT_TYPE() { return getToken(PigParser.FLOAT_TYPE, 0); }
		public TerminalNode DOUBLE_TYPE() { return getToken(PigParser.DOUBLE_TYPE, 0); }
		public TerminalNode CHARARRAY_TYPE() { return getToken(PigParser.CHARARRAY_TYPE, 0); }
		public TerminalNode BYTEARRAY_TYPE() { return getToken(PigParser.BYTEARRAY_TYPE, 0); }
		public TerminalNode DATETIME_TYPE() { return getToken(PigParser.DATETIME_TYPE, 0); }
		public TerminalNode BIGINTEGER_TYPE() { return getToken(PigParser.BIGINTEGER_TYPE, 0); }
		public TerminalNode BIGDECIMAL_TYPE() { return getToken(PigParser.BIGDECIMAL_TYPE, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN_TYPE) | (1L << INT_TYPE) | (1L << LONG_TYPE) | (1L << FLOAT_TYPE) | (1L << DOUBLE_TYPE) | (1L << CHARARRAY_TYPE) | (1L << BYTEARRAY_TYPE) | (1L << DATETIME_TYPE) | (1L << BIGINTEGER_TYPE) | (1L << BIGDECIMAL_TYPE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class FieldDefinetionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(PigParser.COLON, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public FieldDefinetionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDefinetion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterFieldDefinetion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitFieldDefinetion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitFieldDefinetion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDefinetionContext fieldDefinetion() throws RecognitionException {
		FieldDefinetionContext _localctx = new FieldDefinetionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldDefinetion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(IDENTIFIER);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(141);
				match(COLON);
				setState(142);
				dataType();
				}
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(PigParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(PigParser.RIGHT_PAREN, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(IDENTIFIER);
			setState(146);
			match(LEFT_PAREN);
			setState(147);
			match(RIGHT_PAREN);
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

	public static class BbbContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public BbbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bbb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterBbb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitBbb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitBbb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BbbContext bbb() throws RecognitionException {
		BbbContext _localctx = new BbbContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bbb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(IDENTIFIER);
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

	public static class SetStatementContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(PigParser.SET, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public PropertyValueContext propertyValue() {
			return getRuleContext(PropertyValueContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(PigParser.SEMI_COLON, 0); }
		public SetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterSetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitSetStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitSetStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetStatementContext setStatement() throws RecognitionException {
		SetStatementContext _localctx = new SetStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_setStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(SET);
			setState(152);
			className();
			setState(153);
			propertyValue();
			setState(154);
			match(SEMI_COLON);
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

	public static class PropertyValueContext extends ParserRuleContext {
		public ScalarContext scalar() {
			return getRuleContext(ScalarContext.class,0);
		}
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public PropertyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterPropertyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitPropertyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitPropertyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyValueContext propertyValue() throws RecognitionException {
		PropertyValueContext _localctx = new PropertyValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_propertyValue);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case LONGINTEGER:
			case DOUBLENUMBER:
			case TRUE:
			case FALSE:
			case QUOTEDSTRING:
			case FLOATNUMBER:
			case NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				scalar();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				className();
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

	public static class LoadStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(PigParser.ASSIGN, 0); }
		public LoadClauseContext loadClause() {
			return getRuleContext(LoadClauseContext.class,0);
		}
		public LoadStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterLoadStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitLoadStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitLoadStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoadStatementContext loadStatement() throws RecognitionException {
		LoadStatementContext _localctx = new LoadStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_loadStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(IDENTIFIER);
			setState(161);
			match(ASSIGN);
			setState(162);
			loadClause();
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

	public static class LoadClauseContext extends ParserRuleContext {
		public TerminalNode LOAD() { return getToken(PigParser.LOAD, 0); }
		public List<TerminalNode> PARAM_PATTERN() { return getTokens(PigParser.PARAM_PATTERN); }
		public TerminalNode PARAM_PATTERN(int i) {
			return getToken(PigParser.PARAM_PATTERN, i);
		}
		public SchemaContext schema() {
			return getRuleContext(SchemaContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(PigParser.SEMI_COLON, 0); }
		public TerminalNode USING() { return getToken(PigParser.USING, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode AS() { return getToken(PigParser.AS, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(PigParser.LEFT_PAREN, 0); }
		public List<FieldDefinetionContext> fieldDefinetion() {
			return getRuleContexts(FieldDefinetionContext.class);
		}
		public FieldDefinetionContext fieldDefinetion(int i) {
			return getRuleContext(FieldDefinetionContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(PigParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigParser.COMMA, i);
		}
		public LoadClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterLoadClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitLoadClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitLoadClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoadClauseContext loadClause() throws RecognitionException {
		LoadClauseContext _localctx = new LoadClauseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_loadClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(LOAD);
			setState(165);
			match(PARAM_PATTERN);
			setState(166);
			schema();
			setState(167);
			match(PARAM_PATTERN);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(168);
				match(USING);
				setState(169);
				function();
				}
			}

			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(172);
				match(AS);
				setState(173);
				match(LEFT_PAREN);
				setState(174);
				fieldDefinetion();
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(175);
					match(COMMA);
					setState(176);
					fieldDefinetion();
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(182);
				match(RIGHT_PAREN);
				}
			}

			setState(186);
			match(SEMI_COLON);
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

	public static class SchemaContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PigParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PigParser.IDENTIFIER, i);
		}
		public TerminalNode ASSIGN() { return getToken(PigParser.ASSIGN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigParser.COMMA, i);
		}
		public List<TerminalNode> EQ() { return getTokens(PigParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(PigParser.EQ, i);
		}
		public List<ScalarContext> scalar() {
			return getRuleContexts(ScalarContext.class);
		}
		public ScalarContext scalar(int i) {
			return getRuleContext(ScalarContext.class,i);
		}
		public SchemaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterSchema(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitSchema(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitSchema(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SchemaContext schema() throws RecognitionException {
		SchemaContext _localctx = new SchemaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_schema);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(IDENTIFIER);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(189);
				match(T__0);
				{
				setState(190);
				match(IDENTIFIER);
				setState(191);
				match(ASSIGN);
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(192);
						matchWildcard();
						}
						} 
					}
					setState(197);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(198);
					match(COMMA);
					setState(199);
					match(IDENTIFIER);
					setState(200);
					match(EQ);
					setState(201);
					scalar();
					}
					}
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class ForEachStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(PigParser.ASSIGN, 0); }
		public TerminalNode FOREACH() { return getToken(PigParser.FOREACH, 0); }
		public RelContext rel() {
			return getRuleContext(RelContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(PigParser.SEMI_COLON, 0); }
		public Foreach_plan_complexContext foreach_plan_complex() {
			return getRuleContext(Foreach_plan_complexContext.class,0);
		}
		public Foreach_generate_simpleContext foreach_generate_simple() {
			return getRuleContext(Foreach_generate_simpleContext.class,0);
		}
		public ParallelClauseContext parallelClause() {
			return getRuleContext(ParallelClauseContext.class,0);
		}
		public ForEachStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forEachStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterForEachStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitForEachStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitForEachStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForEachStatementContext forEachStatement() throws RecognitionException {
		ForEachStatementContext _localctx = new ForEachStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forEachStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(IDENTIFIER);
			setState(210);
			match(ASSIGN);
			setState(211);
			match(FOREACH);
			setState(212);
			rel();
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACE:
				{
				setState(213);
				foreach_plan_complex();
				}
				break;
			case GENERATE:
				{
				{
				setState(214);
				foreach_generate_simple();
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARALLEL) {
					{
					setState(215);
					parallelClause();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(220);
			match(SEMI_COLON);
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

	public static class Foreach_generate_simpleContext extends ParserRuleContext {
		public TerminalNode GENERATE() { return getToken(PigParser.GENERATE, 0); }
		public List<Flatten_generated_itemContext> flatten_generated_item() {
			return getRuleContexts(Flatten_generated_itemContext.class);
		}
		public Flatten_generated_itemContext flatten_generated_item(int i) {
			return getRuleContext(Flatten_generated_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigParser.COMMA, i);
		}
		public Foreach_generate_simpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreach_generate_simple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterForeach_generate_simple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitForeach_generate_simple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitForeach_generate_simple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Foreach_generate_simpleContext foreach_generate_simple() throws RecognitionException {
		Foreach_generate_simpleContext _localctx = new Foreach_generate_simpleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_foreach_generate_simple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(GENERATE);
			setState(223);
			flatten_generated_item();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(224);
				match(COMMA);
				setState(225);
				flatten_generated_item();
				}
				}
				setState(230);
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

	public static class Foreach_plan_complexContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(PigParser.LEFT_BRACE, 0); }
		public Nested_blkContext nested_blk() {
			return getRuleContext(Nested_blkContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(PigParser.RIGHT_BRACE, 0); }
		public Foreach_plan_complexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreach_plan_complex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterForeach_plan_complex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitForeach_plan_complex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitForeach_plan_complex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Foreach_plan_complexContext foreach_plan_complex() throws RecognitionException {
		Foreach_plan_complexContext _localctx = new Foreach_plan_complexContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_foreach_plan_complex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(LEFT_BRACE);
			setState(232);
			nested_blk();
			setState(233);
			match(RIGHT_BRACE);
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

	public static class Flatten_generated_itemContext extends ParserRuleContext {
		public Flatten_clauseContext flatten_clause() {
			return getRuleContext(Flatten_clauseContext.class,0);
		}
		public Generate_as_clauseContext generate_as_clause() {
			return getRuleContext(Generate_as_clauseContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Flatten_generated_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flatten_generated_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterFlatten_generated_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitFlatten_generated_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitFlatten_generated_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Flatten_generated_itemContext flatten_generated_item() throws RecognitionException {
		Flatten_generated_itemContext _localctx = new Flatten_generated_itemContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_flatten_generated_item);
		int _la;
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLATTERN:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				flatten_clause();
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(236);
					generate_as_clause();
					}
				}

				}
				break;
			case INTEGER:
			case LONGINTEGER:
			case LEFT_PAREN:
			case STAR:
			case DOUBLENUMBER:
			case TRUE:
			case FALSE:
			case QUOTEDSTRING:
			case FLOATNUMBER:
			case NULL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				expr();
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(240);
					generate_as_clause();
					}
				}

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

	public static class Generate_as_clauseContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(PigParser.AS, 0); }
		public Explicit_field_defContext explicit_field_def() {
			return getRuleContext(Explicit_field_defContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(PigParser.LEFT_PAREN, 0); }
		public Field_def_listContext field_def_list() {
			return getRuleContext(Field_def_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(PigParser.RIGHT_PAREN, 0); }
		public Generate_as_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generate_as_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterGenerate_as_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitGenerate_as_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitGenerate_as_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Generate_as_clauseContext generate_as_clause() throws RecognitionException {
		Generate_as_clauseContext _localctx = new Generate_as_clauseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_generate_as_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(AS);
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				{
				setState(246);
				match(LEFT_PAREN);
				setState(247);
				field_def_list();
				setState(248);
				match(RIGHT_PAREN);
				}
				}
				break;
			case BOOLEAN_TYPE:
			case INT_TYPE:
			case LONG_TYPE:
			case FLOAT_TYPE:
			case DOUBLE_TYPE:
			case CHARARRAY_TYPE:
			case BYTEARRAY_TYPE:
			case DATETIME_TYPE:
			case BIGINTEGER_TYPE:
			case BIGDECIMAL_TYPE:
			case IDENTIFIER:
				{
				setState(250);
				explicit_field_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Field_def_listContext extends ParserRuleContext {
		public List<Field_defContext> field_def() {
			return getRuleContexts(Field_defContext.class);
		}
		public Field_defContext field_def(int i) {
			return getRuleContext(Field_defContext.class,i);
		}
		public Field_def_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_def_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterField_def_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitField_def_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitField_def_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_def_listContext field_def_list() throws RecognitionException {
		Field_def_listContext _localctx = new Field_def_listContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_field_def_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			field_def();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(254);
				match(COMMA);
				setState(255);
				field_def();
				}
				}
				setState(260);
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

	public static class Field_defContext extends ParserRuleContext {
		public Explicit_field_defContext explicit_field_def() {
			return getRuleContext(Explicit_field_defContext.class,0);
		}
		public Field_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterField_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitField_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitField_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_defContext field_def() throws RecognitionException {
		Field_defContext _localctx = new Field_defContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_field_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			explicit_field_def();
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

	public static class Explicit_field_defContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(PigParser.COLON, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public Explicit_field_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicit_field_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterExplicit_field_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitExplicit_field_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitExplicit_field_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Explicit_field_defContext explicit_field_def() throws RecognitionException {
		Explicit_field_defContext _localctx = new Explicit_field_defContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_explicit_field_def);
		int _la;
		try {
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				match(IDENTIFIER);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(264);
					match(COLON);
					setState(265);
					dataType();
					}
				}

				}
				break;
			case BOOLEAN_TYPE:
			case INT_TYPE:
			case LONG_TYPE:
			case FLOAT_TYPE:
			case DOUBLE_TYPE:
			case CHARARRAY_TYPE:
			case BYTEARRAY_TYPE:
			case DATETIME_TYPE:
			case BIGINTEGER_TYPE:
			case BIGDECIMAL_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				dataType();
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

	public static class Flatten_clauseContext extends ParserRuleContext {
		public TerminalNode FLATTERN() { return getToken(PigParser.FLATTERN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(PigParser.LEFT_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(PigParser.RIGHT_PAREN, 0); }
		public Flatten_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flatten_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterFlatten_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitFlatten_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitFlatten_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Flatten_clauseContext flatten_clause() throws RecognitionException {
		Flatten_clauseContext _localctx = new Flatten_clauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_flatten_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(FLATTERN);
			setState(272);
			match(LEFT_PAREN);
			setState(273);
			expr();
			setState(274);
			match(RIGHT_PAREN);
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

	public static class Nested_blkContext extends ParserRuleContext {
		public TerminalNode GENERATE() { return getToken(PigParser.GENERATE, 0); }
		public List<Flatten_generated_itemContext> flatten_generated_item() {
			return getRuleContexts(Flatten_generated_itemContext.class);
		}
		public Flatten_generated_itemContext flatten_generated_item(int i) {
			return getRuleContext(Flatten_generated_itemContext.class,i);
		}
		public List<TerminalNode> SEMI_COLON() { return getTokens(PigParser.SEMI_COLON); }
		public TerminalNode SEMI_COLON(int i) {
			return getToken(PigParser.SEMI_COLON, i);
		}
		public List<Nested_commandContext> nested_command() {
			return getRuleContexts(Nested_commandContext.class);
		}
		public Nested_commandContext nested_command(int i) {
			return getRuleContext(Nested_commandContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigParser.COMMA, i);
		}
		public Nested_blkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nested_blk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterNested_blk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitNested_blk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitNested_blk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nested_blkContext nested_blk() throws RecognitionException {
		Nested_blkContext _localctx = new Nested_blkContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_nested_blk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(276);
				nested_command();
				setState(277);
				match(SEMI_COLON);
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(284);
			match(GENERATE);
			setState(285);
			flatten_generated_item();
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(286);
				match(COMMA);
				setState(287);
				flatten_generated_item();
				}
				}
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(293);
			match(SEMI_COLON);
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

	public static class Nested_commandContext extends ParserRuleContext {
		public Nested_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nested_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterNested_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitNested_command(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitNested_command(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nested_commandContext nested_command() throws RecognitionException {
		Nested_commandContext _localctx = new Nested_commandContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_nested_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(T__1);
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

	public static class StoreStatementContext extends ParserRuleContext {
		public TerminalNode STORE() { return getToken(PigParser.STORE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public TerminalNode INTO() { return getToken(PigParser.INTO, 0); }
		public List<TerminalNode> PARAM_PATTERN() { return getTokens(PigParser.PARAM_PATTERN); }
		public TerminalNode PARAM_PATTERN(int i) {
			return getToken(PigParser.PARAM_PATTERN, i);
		}
		public DirectoryContext directory() {
			return getRuleContext(DirectoryContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(PigParser.SEMI_COLON, 0); }
		public StoreStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterStoreStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitStoreStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitStoreStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StoreStatementContext storeStatement() throws RecognitionException {
		StoreStatementContext _localctx = new StoreStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_storeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(STORE);
			setState(298);
			match(IDENTIFIER);
			setState(299);
			match(INTO);
			setState(300);
			match(PARAM_PATTERN);
			setState(301);
			directory();
			setState(302);
			match(PARAM_PATTERN);
			setState(303);
			match(SEMI_COLON);
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

	public static class DistinctStatementContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PigParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PigParser.IDENTIFIER, i);
		}
		public TerminalNode ASSIGN() { return getToken(PigParser.ASSIGN, 0); }
		public TerminalNode DISTINCT() { return getToken(PigParser.DISTINCT, 0); }
		public DistinctStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distinctStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterDistinctStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitDistinctStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitDistinctStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DistinctStatementContext distinctStatement() throws RecognitionException {
		DistinctStatementContext _localctx = new DistinctStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_distinctStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(IDENTIFIER);
			setState(306);
			match(ASSIGN);
			setState(307);
			match(DISTINCT);
			setState(308);
			match(IDENTIFIER);
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

	public static class FilterStatementContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PigParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PigParser.IDENTIFIER, i);
		}
		public TerminalNode ASSIGN() { return getToken(PigParser.ASSIGN, 0); }
		public TerminalNode FILTER() { return getToken(PigParser.FILTER, 0); }
		public TerminalNode BY() { return getToken(PigParser.BY, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(PigParser.SEMI_COLON, 0); }
		public FilterStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterFilterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitFilterStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitFilterStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterStatementContext filterStatement() throws RecognitionException {
		FilterStatementContext _localctx = new FilterStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_filterStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(IDENTIFIER);
			setState(311);
			match(ASSIGN);
			setState(312);
			match(FILTER);
			setState(313);
			match(IDENTIFIER);
			setState(314);
			match(BY);
			setState(315);
			condition();
			setState(316);
			match(SEMI_COLON);
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

	public static class JoinStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(PigParser.ASSIGN, 0); }
		public JoinClauseContext joinClause() {
			return getRuleContext(JoinClauseContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(PigParser.SEMI_COLON, 0); }
		public JoinStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterJoinStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitJoinStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitJoinStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinStatementContext joinStatement() throws RecognitionException {
		JoinStatementContext _localctx = new JoinStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_joinStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(IDENTIFIER);
			setState(319);
			match(ASSIGN);
			setState(320);
			joinClause();
			setState(321);
			match(SEMI_COLON);
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

	public static class JoinClauseContext extends ParserRuleContext {
		public TerminalNode JOIN() { return getToken(PigParser.JOIN, 0); }
		public JoinSubClauseContext joinSubClause() {
			return getRuleContext(JoinSubClauseContext.class,0);
		}
		public TerminalNode USING() { return getToken(PigParser.USING, 0); }
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public PartitionCaluseContext partitionCaluse() {
			return getRuleContext(PartitionCaluseContext.class,0);
		}
		public ParallelClauseContext parallelClause() {
			return getRuleContext(ParallelClauseContext.class,0);
		}
		public JoinClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterJoinClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitJoinClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitJoinClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinClauseContext joinClause() throws RecognitionException {
		JoinClauseContext _localctx = new JoinClauseContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_joinClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(JOIN);
			setState(324);
			joinSubClause();
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(325);
				match(USING);
				setState(326);
				joinType();
				}
			}

			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION) {
				{
				setState(329);
				partitionCaluse();
				}
			}

			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARALLEL) {
				{
				setState(332);
				parallelClause();
				}
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

	public static class JoinTypeContext extends ParserRuleContext {
		public TerminalNode QUOTEDSTRING() { return getToken(PigParser.QUOTEDSTRING, 0); }
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitJoinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitJoinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_joinType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(QUOTEDSTRING);
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

	public static class JoinSubClauseContext extends ParserRuleContext {
		public List<JoinItemContext> joinItem() {
			return getRuleContexts(JoinItemContext.class);
		}
		public JoinItemContext joinItem(int i) {
			return getRuleContext(JoinItemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigParser.COMMA, i);
		}
		public TerminalNode LEFT() { return getToken(PigParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(PigParser.RIGHT, 0); }
		public TerminalNode FULL() { return getToken(PigParser.FULL, 0); }
		public TerminalNode OUTER() { return getToken(PigParser.OUTER, 0); }
		public JoinSubClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinSubClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterJoinSubClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitJoinSubClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitJoinSubClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinSubClauseContext joinSubClause() throws RecognitionException {
		JoinSubClauseContext _localctx = new JoinSubClauseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_joinSubClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			joinItem();
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT:
			case RIGHT:
			case FULL:
				{
				{
				setState(338);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT) | (1L << RIGHT) | (1L << FULL))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(339);
					match(OUTER);
					}
				}

				setState(342);
				match(COMMA);
				setState(343);
				joinItem();
				}
				}
				break;
			case COMMA:
				{
				{
				setState(346); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(344);
					match(COMMA);
					setState(345);
					joinItem();
					}
					}
					setState(348); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class JoinItemContext extends ParserRuleContext {
		public RelContext rel() {
			return getRuleContext(RelContext.class,0);
		}
		public JoinGroupByClauseContext joinGroupByClause() {
			return getRuleContext(JoinGroupByClauseContext.class,0);
		}
		public JoinItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterJoinItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitJoinItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitJoinItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinItemContext joinItem() throws RecognitionException {
		JoinItemContext _localctx = new JoinItemContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_joinItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			rel();
			setState(353);
			joinGroupByClause();
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

	public static class JoinGroupByClauseContext extends ParserRuleContext {
		public TerminalNode BY() { return getToken(PigParser.BY, 0); }
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(PigParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(PigParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigParser.COMMA, i);
		}
		public JoinGroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinGroupByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterJoinGroupByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitJoinGroupByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitJoinGroupByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinGroupByClauseContext joinGroupByClause() throws RecognitionException {
		JoinGroupByClauseContext _localctx = new JoinGroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_joinGroupByClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(BY);
			setState(368);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				{
				setState(356);
				match(LEFT_PAREN);
				setState(357);
				arg();
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(358);
					match(COMMA);
					setState(359);
					arg();
					}
					}
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(365);
				match(RIGHT_PAREN);
				}
				}
				break;
			case STAR:
			case IDENTIFIER:
				{
				setState(367);
				arg();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ArgContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public TerminalNode STAR() { return getToken(PigParser.STAR, 0); }
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			_la = _input.LA(1);
			if ( !(_la==STAR || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class RelContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public RelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitRel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitRel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelContext rel() throws RecognitionException {
		RelContext _localctx = new RelContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_rel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(IDENTIFIER);
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

	public static class PartitionCaluseContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(PigParser.PARTITION, 0); }
		public TerminalNode BY() { return getToken(PigParser.BY, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public PartitionCaluseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionCaluse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterPartitionCaluse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitPartitionCaluse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitPartitionCaluse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionCaluseContext partitionCaluse() throws RecognitionException {
		PartitionCaluseContext _localctx = new PartitionCaluseContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_partitionCaluse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(PARTITION);
			setState(375);
			match(BY);
			setState(376);
			className();
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

	public static class ParallelClauseContext extends ParserRuleContext {
		public TerminalNode PARALLEL() { return getToken(PigParser.PARALLEL, 0); }
		public TerminalNode INTEGER() { return getToken(PigParser.INTEGER, 0); }
		public ParallelClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parallelClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterParallelClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitParallelClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitParallelClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParallelClauseContext parallelClause() throws RecognitionException {
		ParallelClauseContext _localctx = new ParallelClauseContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_parallelClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(PARALLEL);
			setState(379);
			match(INTEGER);
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

	public static class GroupStatementContext extends ParserRuleContext {
		public List<RelContext> rel() {
			return getRuleContexts(RelContext.class);
		}
		public RelContext rel(int i) {
			return getRuleContext(RelContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(PigParser.ASSIGN, 0); }
		public TerminalNode GROUP() { return getToken(PigParser.GROUP, 0); }
		public TerminalNode SEMI_COLON() { return getToken(PigParser.SEMI_COLON, 0); }
		public List<TerminalNode> ALL() { return getTokens(PigParser.ALL); }
		public TerminalNode ALL(int i) {
			return getToken(PigParser.ALL, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigParser.COMMA, i);
		}
		public TerminalNode USING() { return getToken(PigParser.USING, 0); }
		public TerminalNode QUOTEDSTRING() { return getToken(PigParser.QUOTEDSTRING, 0); }
		public PartitionCaluseContext partitionCaluse() {
			return getRuleContext(PartitionCaluseContext.class,0);
		}
		public ParallelClauseContext parallelClause() {
			return getRuleContext(ParallelClauseContext.class,0);
		}
		public GroupStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterGroupStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitGroupStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitGroupStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupStatementContext groupStatement() throws RecognitionException {
		GroupStatementContext _localctx = new GroupStatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_groupStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			rel();
			setState(382);
			match(ASSIGN);
			setState(383);
			match(GROUP);
			setState(384);
			rel();
			setState(387);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALL:
				{
				setState(385);
				match(ALL);
				}
				break;
			case INTEGER:
			case LONGINTEGER:
			case LEFT_PAREN:
			case STAR:
			case DOUBLENUMBER:
			case TRUE:
			case FALSE:
			case QUOTEDSTRING:
			case FLOATNUMBER:
			case NULL:
			case IDENTIFIER:
				{
				setState(386);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(389);
				match(COMMA);
				setState(390);
				rel();
				setState(393);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ALL:
					{
					setState(391);
					match(ALL);
					}
					break;
				case INTEGER:
				case LONGINTEGER:
				case LEFT_PAREN:
				case STAR:
				case DOUBLENUMBER:
				case TRUE:
				case FALSE:
				case QUOTEDSTRING:
				case FLOATNUMBER:
				case NULL:
				case IDENTIFIER:
					{
					setState(392);
					expr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(400);
				match(USING);
				setState(401);
				match(QUOTEDSTRING);
				}
			}

			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION) {
				{
				setState(404);
				partitionCaluse();
				}
			}

			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARALLEL) {
				{
				setState(407);
				parallelClause();
				}
			}

			setState(410);
			match(SEMI_COLON);
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

	public static class UnionStatementContext extends ParserRuleContext {
		public List<RelContext> rel() {
			return getRuleContexts(RelContext.class);
		}
		public RelContext rel(int i) {
			return getRuleContext(RelContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(PigParser.ASSIGN, 0); }
		public TerminalNode UNION() { return getToken(PigParser.UNION, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigParser.COMMA, i);
		}
		public TerminalNode SEMI_COLON() { return getToken(PigParser.SEMI_COLON, 0); }
		public TerminalNode ONSCHEMA() { return getToken(PigParser.ONSCHEMA, 0); }
		public ParallelClauseContext parallelClause() {
			return getRuleContext(ParallelClauseContext.class,0);
		}
		public UnionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterUnionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitUnionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitUnionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionStatementContext unionStatement() throws RecognitionException {
		UnionStatementContext _localctx = new UnionStatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_unionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			rel();
			setState(413);
			match(ASSIGN);
			setState(414);
			match(UNION);
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ONSCHEMA) {
				{
				setState(415);
				match(ONSCHEMA);
				}
			}

			setState(418);
			rel();
			setState(419);
			match(COMMA);
			setState(420);
			rel();
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(421);
				match(COMMA);
				setState(422);
				rel();
				}
				}
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARALLEL) {
				{
				setState(428);
				parallelClause();
				}
			}

			setState(431);
			match(SEMI_COLON);
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

	public static class DirectoryContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public DirectoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directory; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterDirectory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitDirectory(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitDirectory(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectoryContext directory() throws RecognitionException {
		DirectoryContext _localctx = new DirectoryContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_directory);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			match(IDENTIFIER);
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

	public static class ConditionContext extends ParserRuleContext {
		public List<AndConditionContext> andCondition() {
			return getRuleContexts(AndConditionContext.class);
		}
		public AndConditionContext andCondition(int i) {
			return getRuleContext(AndConditionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(PigParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(PigParser.OR, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			andCondition();
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(436);
				match(OR);
				setState(437);
				andCondition();
				}
				}
				setState(442);
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

	public static class AndConditionContext extends ParserRuleContext {
		public List<NotConditionContext> notCondition() {
			return getRuleContexts(NotConditionContext.class);
		}
		public NotConditionContext notCondition(int i) {
			return getRuleContext(NotConditionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(PigParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(PigParser.AND, i);
		}
		public AndConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterAndCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitAndCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitAndCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndConditionContext andCondition() throws RecognitionException {
		AndConditionContext _localctx = new AndConditionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_andCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			notCondition();
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(444);
				match(AND);
				setState(445);
				notCondition();
				}
				}
				setState(450);
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

	public static class NotConditionContext extends ParserRuleContext {
		public UnaryConditionContext unaryCondition() {
			return getRuleContext(UnaryConditionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PigParser.NOT, 0); }
		public NotConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterNotCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitNotCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitNotCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotConditionContext notCondition() throws RecognitionException {
		NotConditionContext _localctx = new NotConditionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_notCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(451);
				match(NOT);
				}
			}

			setState(454);
			unaryCondition();
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

	public static class UnaryConditionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IS() { return getToken(PigParser.IS, 0); }
		public TerminalNode NULL() { return getToken(PigParser.NULL, 0); }
		public RelOpContext relOp() {
			return getRuleContext(RelOpContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PigParser.NOT, 0); }
		public UnaryConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterUnaryCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitUnaryCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitUnaryCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryConditionContext unaryCondition() throws RecognitionException {
		UnaryConditionContext _localctx = new UnaryConditionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_unaryCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			expr();
			setState(465);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IS:
				{
				{
				setState(457);
				match(IS);
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(458);
					match(NOT);
					}
				}

				setState(461);
				match(NULL);
				}
				}
				break;
			case STR_OP_EQ:
			case STR_OP_GT:
			case STR_OP_LT:
			case STR_OP_GTE:
			case STR_OP_LTE:
			case STR_OP_NE:
			case STR_OP_MATCHES:
			case EQ:
			case NEQ:
			case LT:
			case LTE:
			case GT:
			case GTE:
				{
				{
				setState(462);
				relOp();
				setState(463);
				expr();
				}
				}
				break;
			case SEMI_COLON:
			case RIGHT_PAREN:
			case AND:
			case OR:
				break;
			default:
				break;
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

	public static class ExprContext extends ParserRuleContext {
		public List<MultiExprContext> multiExpr() {
			return getRuleContexts(MultiExprContext.class);
		}
		public MultiExprContext multiExpr(int i) {
			return getRuleContext(MultiExprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(PigParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(PigParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(PigParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(PigParser.MINUS, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			multiExpr();
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(468);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(469);
				multiExpr();
				}
				}
				setState(474);
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

	public static class MultiExprContext extends ParserRuleContext {
		public List<CastExprContext> castExpr() {
			return getRuleContexts(CastExprContext.class);
		}
		public CastExprContext castExpr(int i) {
			return getRuleContext(CastExprContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(PigParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(PigParser.STAR, i);
		}
		public List<TerminalNode> DIV() { return getTokens(PigParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(PigParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(PigParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(PigParser.MOD, i);
		}
		public MultiExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterMultiExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitMultiExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitMultiExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiExprContext multiExpr() throws RecognitionException {
		MultiExprContext _localctx = new MultiExprContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_multiExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			castExpr();
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (STAR - 17)) | (1L << (DIV - 17)) | (1L << (MOD - 17)))) != 0)) {
				{
				{
				setState(476);
				_la = _input.LA(1);
				if ( !(((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (STAR - 17)) | (1L << (DIV - 17)) | (1L << (MOD - 17)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(477);
				castExpr();
				}
				}
				setState(482);
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

	public static class BasicExpressionContext extends ParserRuleContext {
		public ScalarContext scalar() {
			return getRuleContext(ScalarContext.class,0);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(PigParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PigParser.IDENTIFIER, i);
		}
		public TerminalNode PERIOD() { return getToken(PigParser.PERIOD, 0); }
		public List<TerminalNode> COLON() { return getTokens(PigParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(PigParser.COLON, i);
		}
		public TerminalNode STAR() { return getToken(PigParser.STAR, 0); }
		public BasicExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterBasicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitBasicExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicExpressionContext basicExpression() throws RecognitionException {
		BasicExpressionContext _localctx = new BasicExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_basicExpression);
		try {
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(483);
				scalar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(484);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(485);
				match(IDENTIFIER);
				setState(486);
				match(PERIOD);
				setState(487);
				match(IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(488);
				match(IDENTIFIER);
				setState(489);
				match(COLON);
				setState(490);
				match(COLON);
				setState(491);
				match(IDENTIFIER);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(492);
				match(STAR);
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

	public static class CastTypeContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(PigParser.LEFT_PAREN, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(PigParser.RIGHT_PAREN, 0); }
		public CastTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterCastType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitCastType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitCastType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastTypeContext castType() throws RecognitionException {
		CastTypeContext _localctx = new CastTypeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_castType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(LEFT_PAREN);
			setState(496);
			dataType();
			setState(497);
			match(RIGHT_PAREN);
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

	public static class CastExprContext extends ParserRuleContext {
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public CastTypeContext castType() {
			return getRuleContext(CastTypeContext.class,0);
		}
		public ParenExprContext parenExpr() {
			return getRuleContext(ParenExprContext.class,0);
		}
		public CastExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterCastExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitCastExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitCastExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExprContext castExpr() throws RecognitionException {
		CastExprContext _localctx = new CastExprContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_castExpr);
		int _la;
		try {
			setState(504);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(500);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(499);
					castType();
					}
				}

				setState(502);
				basicExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(503);
				parenExpr();
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

	public static class ParenExprContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(PigParser.LEFT_PAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(PigParser.RIGHT_PAREN, 0); }
		public ParenExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenExprContext parenExpr() throws RecognitionException {
		ParenExprContext _localctx = new ParenExprContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_parenExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			match(LEFT_PAREN);
			setState(507);
			condition();
			setState(508);
			match(RIGHT_PAREN);
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

	public static class ScalarContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(PigParser.INTEGER, 0); }
		public TerminalNode LONGINTEGER() { return getToken(PigParser.LONGINTEGER, 0); }
		public TerminalNode FLOATNUMBER() { return getToken(PigParser.FLOATNUMBER, 0); }
		public TerminalNode DOUBLENUMBER() { return getToken(PigParser.DOUBLENUMBER, 0); }
		public TerminalNode QUOTEDSTRING() { return getToken(PigParser.QUOTEDSTRING, 0); }
		public TerminalNode NULL() { return getToken(PigParser.NULL, 0); }
		public TerminalNode TRUE() { return getToken(PigParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PigParser.FALSE, 0); }
		public ScalarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterScalar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitScalar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitScalar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarContext scalar() throws RecognitionException {
		ScalarContext _localctx = new ScalarContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_scalar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << LONGINTEGER) | (1L << DOUBLENUMBER) | (1L << TRUE) | (1L << FALSE) | (1L << QUOTEDSTRING) | (1L << FLOATNUMBER))) != 0) || _la==NULL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class RelOpContext extends ParserRuleContext {
		public RelStrOpContext relStrOp() {
			return getRuleContext(RelStrOpContext.class,0);
		}
		public TerminalNode EQ() { return getToken(PigParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(PigParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(PigParser.GT, 0); }
		public TerminalNode GTE() { return getToken(PigParser.GTE, 0); }
		public TerminalNode LT() { return getToken(PigParser.LT, 0); }
		public TerminalNode LTE() { return getToken(PigParser.LTE, 0); }
		public RelOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterRelOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitRelOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitRelOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelOpContext relOp() throws RecognitionException {
		RelOpContext _localctx = new RelOpContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_relOp);
		try {
			setState(519);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STR_OP_EQ:
			case STR_OP_GT:
			case STR_OP_LT:
			case STR_OP_GTE:
			case STR_OP_LTE:
			case STR_OP_NE:
			case STR_OP_MATCHES:
				enterOuterAlt(_localctx, 1);
				{
				setState(512);
				relStrOp();
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(513);
				match(EQ);
				}
				break;
			case NEQ:
				enterOuterAlt(_localctx, 3);
				{
				setState(514);
				match(NEQ);
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 4);
				{
				setState(515);
				match(GT);
				}
				break;
			case GTE:
				enterOuterAlt(_localctx, 5);
				{
				setState(516);
				match(GTE);
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 6);
				{
				setState(517);
				match(LT);
				}
				break;
			case LTE:
				enterOuterAlt(_localctx, 7);
				{
				setState(518);
				match(LTE);
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

	public static class RelStrOpContext extends ParserRuleContext {
		public TerminalNode STR_OP_EQ() { return getToken(PigParser.STR_OP_EQ, 0); }
		public TerminalNode STR_OP_NE() { return getToken(PigParser.STR_OP_NE, 0); }
		public TerminalNode STR_OP_GT() { return getToken(PigParser.STR_OP_GT, 0); }
		public TerminalNode STR_OP_LT() { return getToken(PigParser.STR_OP_LT, 0); }
		public TerminalNode STR_OP_GTE() { return getToken(PigParser.STR_OP_GTE, 0); }
		public TerminalNode STR_OP_LTE() { return getToken(PigParser.STR_OP_LTE, 0); }
		public TerminalNode STR_OP_MATCHES() { return getToken(PigParser.STR_OP_MATCHES, 0); }
		public RelStrOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relStrOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterRelStrOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitRelStrOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitRelStrOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelStrOpContext relStrOp() throws RecognitionException {
		RelStrOpContext _localctx = new RelStrOpContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_relStrOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR_OP_EQ) | (1L << STR_OP_GT) | (1L << STR_OP_LT) | (1L << STR_OP_GTE) | (1L << STR_OP_LTE) | (1L << STR_OP_NE) | (1L << STR_OP_MATCHES))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class NullExpressionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PigParser.IDENTIFIER, 0); }
		public TerminalNode IS() { return getToken(PigParser.IS, 0); }
		public TerminalNode NULL() { return getToken(PigParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(PigParser.NOT, 0); }
		public NullExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterNullExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitNullExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitNullExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullExpressionContext nullExpression() throws RecognitionException {
		NullExpressionContext _localctx = new NullExpressionContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_nullExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			match(IDENTIFIER);
			setState(524);
			match(IS);
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(525);
				match(NOT);
				}
			}

			setState(528);
			match(NULL);
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

	public static class ClassNameContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PigParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PigParser.IDENTIFIER, i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(PigParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(PigParser.PERIOD, i);
		}
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigListener ) ((PigListener)listener).exitClassName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigVisitor ) return ((PigVisitor<? extends T>)visitor).visitClassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_className);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			match(IDENTIFIER);
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PERIOD) {
				{
				{
				setState(531);
				match(PERIOD);
				setState(532);
				match(IDENTIFIER);
				}
				}
				setState(537);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3[\u021d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\7\2p\n\2\f\2\16\2s\13\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0081\n\3\3\3\5\3\u0084\n"+
		"\3\5\3\u0086\n\3\3\4\3\4\3\4\5\4\u008b\n\4\3\5\3\5\3\6\3\6\3\6\5\6\u0092"+
		"\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\5\n\u00a1\n\n"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ad\n\f\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u00b4\n\f\f\f\16\f\u00b7\13\f\3\f\3\f\5\f\u00bb\n\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\7\r\u00c4\n\r\f\r\16\r\u00c7\13\r\3\r\3\r\3\r\3"+
		"\r\7\r\u00cd\n\r\f\r\16\r\u00d0\13\r\5\r\u00d2\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00db\n\16\5\16\u00dd\n\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\7\17\u00e5\n\17\f\17\16\17\u00e8\13\17\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\5\21\u00f0\n\21\3\21\3\21\5\21\u00f4\n\21\5\21\u00f6\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u00fe\n\22\3\23\3\23\3\23\7\23\u0103\n"+
		"\23\f\23\16\23\u0106\13\23\3\24\3\24\3\25\3\25\3\25\5\25\u010d\n\25\3"+
		"\25\5\25\u0110\n\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\7\27\u011a"+
		"\n\27\f\27\16\27\u011d\13\27\3\27\3\27\3\27\3\27\7\27\u0123\n\27\f\27"+
		"\16\27\u0126\13\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\5\35\u014a\n\35\3\35"+
		"\5\35\u014d\n\35\3\35\5\35\u0150\n\35\3\36\3\36\3\37\3\37\3\37\5\37\u0157"+
		"\n\37\3\37\3\37\3\37\3\37\6\37\u015d\n\37\r\37\16\37\u015e\5\37\u0161"+
		"\n\37\3 \3 \3 \3!\3!\3!\3!\3!\7!\u016b\n!\f!\16!\u016e\13!\3!\3!\3!\5"+
		"!\u0173\n!\3\"\3\"\3#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\5&\u0186"+
		"\n&\3&\3&\3&\3&\5&\u018c\n&\7&\u018e\n&\f&\16&\u0191\13&\3&\3&\5&\u0195"+
		"\n&\3&\5&\u0198\n&\3&\5&\u019b\n&\3&\3&\3\'\3\'\3\'\3\'\5\'\u01a3\n\'"+
		"\3\'\3\'\3\'\3\'\3\'\7\'\u01aa\n\'\f\'\16\'\u01ad\13\'\3\'\5\'\u01b0\n"+
		"\'\3\'\3\'\3(\3(\3)\3)\3)\7)\u01b9\n)\f)\16)\u01bc\13)\3*\3*\3*\7*\u01c1"+
		"\n*\f*\16*\u01c4\13*\3+\5+\u01c7\n+\3+\3+\3,\3,\3,\5,\u01ce\n,\3,\3,\3"+
		",\3,\5,\u01d4\n,\3-\3-\3-\7-\u01d9\n-\f-\16-\u01dc\13-\3.\3.\3.\7.\u01e1"+
		"\n.\f.\16.\u01e4\13.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u01f0\n/\3\60\3"+
		"\60\3\60\3\60\3\61\5\61\u01f7\n\61\3\61\3\61\5\61\u01fb\n\61\3\62\3\62"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u020a\n\64"+
		"\3\65\3\65\3\66\3\66\3\66\5\66\u0211\n\66\3\66\3\66\3\67\3\67\3\67\7\67"+
		"\u0218\n\67\f\67\16\67\u021b\13\67\3\67\2\28\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjl\2\t\3\2"+
		"\25\36\3\2#%\4\2\23\23WW\3\2EF\4\2\23\23HI\6\2\6\7\65\679:VV\3\2.\64\2"+
		"\u022d\2q\3\2\2\2\4\u0085\3\2\2\2\6\u008a\3\2\2\2\b\u008c\3\2\2\2\n\u008e"+
		"\3\2\2\2\f\u0093\3\2\2\2\16\u0097\3\2\2\2\20\u0099\3\2\2\2\22\u00a0\3"+
		"\2\2\2\24\u00a2\3\2\2\2\26\u00a6\3\2\2\2\30\u00be\3\2\2\2\32\u00d3\3\2"+
		"\2\2\34\u00e0\3\2\2\2\36\u00e9\3\2\2\2 \u00f5\3\2\2\2\"\u00f7\3\2\2\2"+
		"$\u00ff\3\2\2\2&\u0107\3\2\2\2(\u010f\3\2\2\2*\u0111\3\2\2\2,\u011b\3"+
		"\2\2\2.\u0129\3\2\2\2\60\u012b\3\2\2\2\62\u0133\3\2\2\2\64\u0138\3\2\2"+
		"\2\66\u0140\3\2\2\28\u0145\3\2\2\2:\u0151\3\2\2\2<\u0153\3\2\2\2>\u0162"+
		"\3\2\2\2@\u0165\3\2\2\2B\u0174\3\2\2\2D\u0176\3\2\2\2F\u0178\3\2\2\2H"+
		"\u017c\3\2\2\2J\u017f\3\2\2\2L\u019e\3\2\2\2N\u01b3\3\2\2\2P\u01b5\3\2"+
		"\2\2R\u01bd\3\2\2\2T\u01c6\3\2\2\2V\u01ca\3\2\2\2X\u01d5\3\2\2\2Z\u01dd"+
		"\3\2\2\2\\\u01ef\3\2\2\2^\u01f1\3\2\2\2`\u01fa\3\2\2\2b\u01fc\3\2\2\2"+
		"d\u0200\3\2\2\2f\u0209\3\2\2\2h\u020b\3\2\2\2j\u020d\3\2\2\2l\u0214\3"+
		"\2\2\2np\5\4\3\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3"+
		"\2\2\2tu\7\2\2\3u\3\3\2\2\2v\u0086\7Z\2\2w\u0081\5\20\t\2x\u0081\5\24"+
		"\13\2y\u0081\5\32\16\2z\u0081\5\60\31\2{\u0081\5\62\32\2|\u0081\5\64\33"+
		"\2}\u0081\5\66\34\2~\u0081\5J&\2\177\u0081\5L\'\2\u0080w\3\2\2\2\u0080"+
		"x\3\2\2\2\u0080y\3\2\2\2\u0080z\3\2\2\2\u0080{\3\2\2\2\u0080|\3\2\2\2"+
		"\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081\u0083\3\2\2\2\u0082"+
		"\u0084\7Y\2\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2"+
		"\2\2\u0085v\3\2\2\2\u0085\u0080\3\2\2\2\u0086\5\3\2\2\2\u0087\u008b\7"+
		"W\2\2\u0088\u0089\7\t\2\2\u0089\u008b\7\6\2\2\u008a\u0087\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008b\7\3\2\2\2\u008c\u008d\t\2\2\2\u008d\t\3\2\2\2\u008e"+
		"\u0091\7W\2\2\u008f\u0090\7\20\2\2\u0090\u0092\5\b\5\2\u0091\u008f\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\13\3\2\2\2\u0093\u0094\7W\2\2\u0094\u0095"+
		"\7\r\2\2\u0095\u0096\7\16\2\2\u0096\r\3\2\2\2\u0097\u0098\7W\2\2\u0098"+
		"\17\3\2\2\2\u0099\u009a\7-\2\2\u009a\u009b\5l\67\2\u009b\u009c\5\22\n"+
		"\2\u009c\u009d\7\n\2\2\u009d\21\3\2\2\2\u009e\u00a1\5d\63\2\u009f\u00a1"+
		"\5l\67\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\23\3\2\2\2\u00a2"+
		"\u00a3\7W\2\2\u00a3\u00a4\7D\2\2\u00a4\u00a5\5\26\f\2\u00a5\25\3\2\2\2"+
		"\u00a6\u00a7\7\5\2\2\u00a7\u00a8\7?\2\2\u00a8\u00a9\5\30\r\2\u00a9\u00ac"+
		"\7?\2\2\u00aa\u00ab\7\f\2\2\u00ab\u00ad\5\f\7\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ba\3\2\2\2\u00ae\u00af\7\17\2\2\u00af\u00b0\7"+
		"\r\2\2\u00b0\u00b5\5\n\6\2\u00b1\u00b2\7\37\2\2\u00b2\u00b4\5\n\6\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7\16\2\2\u00b9"+
		"\u00bb\3\2\2\2\u00ba\u00ae\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\u00bd\7\n\2\2\u00bd\27\3\2\2\2\u00be\u00d1\7W\2\2\u00bf\u00c0"+
		"\7\3\2\2\u00c0\u00c1\7W\2\2\u00c1\u00c5\7D\2\2\u00c2\u00c4\13\2\2\2\u00c3"+
		"\u00c2\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\u00ce\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\7\37\2\2\u00c9"+
		"\u00ca\7W\2\2\u00ca\u00cb\7O\2\2\u00cb\u00cd\5d\63\2\u00cc\u00c8\3\2\2"+
		"\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00bf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\31\3\2\2\2\u00d3\u00d4\7W\2\2\u00d4\u00d5\7D\2\2\u00d5\u00d6\7B\2\2\u00d6"+
		"\u00dc\5D#\2\u00d7\u00dd\5\36\20\2\u00d8\u00da\5\34\17\2\u00d9\u00db\5"+
		"H%\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc"+
		"\u00d7\3\2\2\2\u00dc\u00d8\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\7\n"+
		"\2\2\u00df\33\3\2\2\2\u00e0\u00e1\7C\2\2\u00e1\u00e6\5 \21\2\u00e2\u00e3"+
		"\7\37\2\2\u00e3\u00e5\5 \21\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2"+
		"\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\35\3\2\2\2\u00e8\u00e6"+
		"\3\2\2\2\u00e9\u00ea\7(\2\2\u00ea\u00eb\5,\27\2\u00eb\u00ec\7)\2\2\u00ec"+
		"\37\3\2\2\2\u00ed\u00ef\5*\26\2\u00ee\u00f0\5\"\22\2\u00ef\u00ee\3\2\2"+
		"\2\u00ef\u00f0\3\2\2\2\u00f0\u00f6\3\2\2\2\u00f1\u00f3\5X-\2\u00f2\u00f4"+
		"\5\"\22\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2"+
		"\u00f5\u00ed\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f6!\3\2\2\2\u00f7\u00fd\7"+
		"\17\2\2\u00f8\u00f9\7\r\2\2\u00f9\u00fa\5$\23\2\u00fa\u00fb\7\16\2\2\u00fb"+
		"\u00fe\3\2\2\2\u00fc\u00fe\5(\25\2\u00fd\u00f8\3\2\2\2\u00fd\u00fc\3\2"+
		"\2\2\u00fe#\3\2\2\2\u00ff\u0104\5&\24\2\u0100\u0101\7\37\2\2\u0101\u0103"+
		"\5&\24\2\u0102\u0100\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105%\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\5(\25\2"+
		"\u0108\'\3\2\2\2\u0109\u010c\7W\2\2\u010a\u010b\7\20\2\2\u010b\u010d\5"+
		"\b\5\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u0110\3\2\2\2\u010e"+
		"\u0110\5\b\5\2\u010f\u0109\3\2\2\2\u010f\u010e\3\2\2\2\u0110)\3\2\2\2"+
		"\u0111\u0112\78\2\2\u0112\u0113\7\r\2\2\u0113\u0114\5X-\2\u0114\u0115"+
		"\7\16\2\2\u0115+\3\2\2\2\u0116\u0117\5.\30\2\u0117\u0118\7\n\2\2\u0118"+
		"\u011a\3\2\2\2\u0119\u0116\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2"+
		"\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u011b\3\2\2\2\u011e"+
		"\u011f\7C\2\2\u011f\u0124\5 \21\2\u0120\u0121\7\37\2\2\u0121\u0123\5 "+
		"\21\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128\7\n"+
		"\2\2\u0128-\3\2\2\2\u0129\u012a\7\4\2\2\u012a/\3\2\2\2\u012b\u012c\7A"+
		"\2\2\u012c\u012d\7W\2\2\u012d\u012e\7@\2\2\u012e\u012f\7?\2\2\u012f\u0130"+
		"\5N(\2\u0130\u0131\7?\2\2\u0131\u0132\7\n\2\2\u0132\61\3\2\2\2\u0133\u0134"+
		"\7W\2\2\u0134\u0135\7D\2\2\u0135\u0136\7>\2\2\u0136\u0137\7W\2\2\u0137"+
		"\63\3\2\2\2\u0138\u0139\7W\2\2\u0139\u013a\7D\2\2\u013a\u013b\7=\2\2\u013b"+
		"\u013c\7W\2\2\u013c\u013d\7<\2\2\u013d\u013e\5P)\2\u013e\u013f\7\n\2\2"+
		"\u013f\65\3\2\2\2\u0140\u0141\7W\2\2\u0141\u0142\7D\2\2\u0142\u0143\5"+
		"8\35\2\u0143\u0144\7\n\2\2\u0144\67\3\2\2\2\u0145\u0146\7*\2\2\u0146\u0149"+
		"\5<\37\2\u0147\u0148\7\f\2\2\u0148\u014a\5:\36\2\u0149\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b\u014d\5F$\2\u014c\u014b\3\2\2"+
		"\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u0150\5H%\2\u014f\u014e"+
		"\3\2\2\2\u014f\u0150\3\2\2\2\u01509\3\2\2\2\u0151\u0152\79\2\2\u0152;"+
		"\3\2\2\2\u0153\u0160\5> \2\u0154\u0156\t\3\2\2\u0155\u0157\7&\2\2\u0156"+
		"\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\7\37"+
		"\2\2\u0159\u0161\5> \2\u015a\u015b\7\37\2\2\u015b\u015d\5> \2\u015c\u015a"+
		"\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"\u0161\3\2\2\2\u0160\u0154\3\2\2\2\u0160\u015c\3\2\2\2\u0161=\3\2\2\2"+
		"\u0162\u0163\5D#\2\u0163\u0164\5@!\2\u0164?\3\2\2\2\u0165\u0172\7<\2\2"+
		"\u0166\u0167\7\r\2\2\u0167\u016c\5B\"\2\u0168\u0169\7\37\2\2\u0169\u016b"+
		"\5B\"\2\u016a\u0168\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\7\16"+
		"\2\2\u0170\u0173\3\2\2\2\u0171\u0173\5B\"\2\u0172\u0166\3\2\2\2\u0172"+
		"\u0171\3\2\2\2\u0173A\3\2\2\2\u0174\u0175\t\4\2\2\u0175C\3\2\2\2\u0176"+
		"\u0177\7W\2\2\u0177E\3\2\2\2\u0178\u0179\7 \2\2\u0179\u017a\7<\2\2\u017a"+
		"\u017b\5l\67\2\u017bG\3\2\2\2\u017c\u017d\7+\2\2\u017d\u017e\7\6\2\2\u017e"+
		"I\3\2\2\2\u017f\u0180\5D#\2\u0180\u0181\7D\2\2\u0181\u0182\7,\2\2\u0182"+
		"\u0185\5D#\2\u0183\u0186\7\"\2\2\u0184\u0186\5X-\2\u0185\u0183\3\2\2\2"+
		"\u0185\u0184\3\2\2\2\u0186\u018f\3\2\2\2\u0187\u0188\7\37\2\2\u0188\u018b"+
		"\5D#\2\u0189\u018c\7\"\2\2\u018a\u018c\5X-\2\u018b\u0189\3\2\2\2\u018b"+
		"\u018a\3\2\2\2\u018c\u018e\3\2\2\2\u018d\u0187\3\2\2\2\u018e\u0191\3\2"+
		"\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0194\3\2\2\2\u0191"+
		"\u018f\3\2\2\2\u0192\u0193\7\f\2\2\u0193\u0195\79\2\2\u0194\u0192\3\2"+
		"\2\2\u0194\u0195\3\2\2\2\u0195\u0197\3\2\2\2\u0196\u0198\5F$\2\u0197\u0196"+
		"\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u019a\3\2\2\2\u0199\u019b\5H%\2\u019a"+
		"\u0199\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019d\7\n"+
		"\2\2\u019dK\3\2\2\2\u019e\u019f\5D#\2\u019f\u01a0\7D\2\2\u01a0\u01a2\7"+
		"!\2\2\u01a1\u01a3\7\'\2\2\u01a2\u01a1\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a4\u01a5\5D#\2\u01a5\u01a6\7\37\2\2\u01a6\u01ab\5D#"+
		"\2\u01a7\u01a8\7\37\2\2\u01a8\u01aa\5D#\2\u01a9\u01a7\3\2\2\2\u01aa\u01ad"+
		"\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad"+
		"\u01ab\3\2\2\2\u01ae\u01b0\5H%\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2"+
		"\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\7\n\2\2\u01b2M\3\2\2\2\u01b3\u01b4"+
		"\7W\2\2\u01b4O\3\2\2\2\u01b5\u01ba\5R*\2\u01b6\u01b7\7L\2\2\u01b7\u01b9"+
		"\5R*\2\u01b8\u01b6\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01bbQ\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01c2\5T+\2\u01be"+
		"\u01bf\7K\2\2\u01bf\u01c1\5T+\2\u01c0\u01be\3\2\2\2\u01c1\u01c4\3\2\2"+
		"\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3S\3\2\2\2\u01c4\u01c2"+
		"\3\2\2\2\u01c5\u01c7\7M\2\2\u01c6\u01c5\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7"+
		"\u01c8\3\2\2\2\u01c8\u01c9\5V,\2\u01c9U\3\2\2\2\u01ca\u01d3\5X-\2\u01cb"+
		"\u01cd\7U\2\2\u01cc\u01ce\7M\2\2\u01cd\u01cc\3\2\2\2\u01cd\u01ce\3\2\2"+
		"\2\u01ce\u01cf\3\2\2\2\u01cf\u01d4\7V\2\2\u01d0\u01d1\5f\64\2\u01d1\u01d2"+
		"\5X-\2\u01d2\u01d4\3\2\2\2\u01d3\u01cb\3\2\2\2\u01d3\u01d0\3\2\2\2\u01d3"+
		"\u01d4\3\2\2\2\u01d4W\3\2\2\2\u01d5\u01da\5Z.\2\u01d6\u01d7\t\5\2\2\u01d7"+
		"\u01d9\5Z.\2\u01d8\u01d6\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2\2"+
		"\2\u01da\u01db\3\2\2\2\u01dbY\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd\u01e2"+
		"\5`\61\2\u01de\u01df\t\6\2\2\u01df\u01e1\5`\61\2\u01e0\u01de\3\2\2\2\u01e1"+
		"\u01e4\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3[\3\2\2\2"+
		"\u01e4\u01e2\3\2\2\2\u01e5\u01f0\5d\63\2\u01e6\u01f0\7W\2\2\u01e7\u01e8"+
		"\7W\2\2\u01e8\u01e9\7;\2\2\u01e9\u01f0\7W\2\2\u01ea\u01eb\7W\2\2\u01eb"+
		"\u01ec\7\20\2\2\u01ec\u01ed\7\20\2\2\u01ed\u01f0\7W\2\2\u01ee\u01f0\7"+
		"\23\2\2\u01ef\u01e5\3\2\2\2\u01ef\u01e6\3\2\2\2\u01ef\u01e7\3\2\2\2\u01ef"+
		"\u01ea\3\2\2\2\u01ef\u01ee\3\2\2\2\u01f0]\3\2\2\2\u01f1\u01f2\7\r\2\2"+
		"\u01f2\u01f3\5\b\5\2\u01f3\u01f4\7\16\2\2\u01f4_\3\2\2\2\u01f5\u01f7\5"+
		"^\60\2\u01f6\u01f5\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8"+
		"\u01fb\5\\/\2\u01f9\u01fb\5b\62\2\u01fa\u01f6\3\2\2\2\u01fa\u01f9\3\2"+
		"\2\2\u01fba\3\2\2\2\u01fc\u01fd\7\r\2\2\u01fd\u01fe\5P)\2\u01fe\u01ff"+
		"\7\16\2\2\u01ffc\3\2\2\2\u0200\u0201\t\7\2\2\u0201e\3\2\2\2\u0202\u020a"+
		"\5h\65\2\u0203\u020a\7O\2\2\u0204\u020a\7P\2\2\u0205\u020a\7S\2\2\u0206"+
		"\u020a\7T\2\2\u0207\u020a\7Q\2\2\u0208\u020a\7R\2\2\u0209\u0202\3\2\2"+
		"\2\u0209\u0203\3\2\2\2\u0209\u0204\3\2\2\2\u0209\u0205\3\2\2\2\u0209\u0206"+
		"\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u0208\3\2\2\2\u020ag\3\2\2\2\u020b"+
		"\u020c\t\b\2\2\u020ci\3\2\2\2\u020d\u020e\7W\2\2\u020e\u0210\7U\2\2\u020f"+
		"\u0211\7M\2\2\u0210\u020f\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0212\3\2"+
		"\2\2\u0212\u0213\7V\2\2\u0213k\3\2\2\2\u0214\u0219\7W\2\2\u0215\u0216"+
		"\7;\2\2\u0216\u0218\7W\2\2\u0217\u0215\3\2\2\2\u0218\u021b\3\2\2\2\u0219"+
		"\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021am\3\2\2\2\u021b\u0219\3\2\2\2"+
		"9q\u0080\u0083\u0085\u008a\u0091\u00a0\u00ac\u00b5\u00ba\u00c5\u00ce\u00d1"+
		"\u00da\u00dc\u00e6\u00ef\u00f3\u00f5\u00fd\u0104\u010c\u010f\u011b\u0124"+
		"\u0149\u014c\u014f\u0156\u015e\u0160\u016c\u0172\u0185\u018b\u018f\u0194"+
		"\u0197\u019a\u01a2\u01ab\u01af\u01ba\u01c2\u01c6\u01cd\u01d3\u01da\u01e2"+
		"\u01ef\u01f6\u01fa\u0209\u0210\u0219";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}