// Generated from /Users/xiaoli/IdeaProjects/common-utils/src/main/resources/Expression.g4 by ANTLR 4.7
package com.anshishagua.parser.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, Boolean=3, Equal=4, NotEqual=5, LessThan=6, LessThanOrEqual=7, 
		GreaterThan=8, GreaterThanOrEqual=9, Dot=10, Exp=11, STRING=12, Case=13, 
		When=14, Then=15, Else=16, End=17, Digit=18, And=19, Or=20, Not=21, Multiply=22, 
		Divide=23, Mod=24, Plus=25, Minus=26, In=27, Is=28, Null=29, LeftParen=30, 
		RightParen=31, Comma=32, Between=33, Like=34, Count=35, Sum=36, Avg=37, 
		Max=38, Min=39, Within=40, MilliSeconds=41, Seconds=42, Minutes=43, Hours=44, 
		Days=45, ID=46, WS=47;
	public static final int
		RULE_start = 0, RULE_compare = 1, RULE_numeric = 2, RULE_sign = 3, RULE_decimal = 4, 
		RULE_string = 5, RULE_intNumber = 6, RULE_longNumber = 7, RULE_number = 8, 
		RULE_condition = 9, RULE_expression = 10, RULE_andCondition = 11, RULE_conditionRightHandSide = 12, 
		RULE_value = 13, RULE_param = 14, RULE_id = 15, RULE_columnRef = 16, RULE_operand = 17, 
		RULE_summand = 18, RULE_plusMinus = 19, RULE_factor = 20, RULE_mulDivMod = 21, 
		RULE_term = 22, RULE_function = 23, RULE_caseWhen = 24, RULE_agg = 25, 
		RULE_timeunit = 26, RULE_aggregation = 27;
	public static final String[] ruleNames = {
		"start", "compare", "numeric", "sign", "decimal", "string", "intNumber", 
		"longNumber", "number", "condition", "expression", "andCondition", "conditionRightHandSide", 
		"value", "param", "id", "columnRef", "operand", "summand", "plusMinus", 
		"factor", "mulDivMod", "term", "function", "caseWhen", "agg", "timeunit", 
		"aggregation"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'${'", "'}'", null, "'='", null, "'<'", "'<='", "'>'", "'>='", 
		"'.'", null, null, "'CASE'", "'WHEN'", "'THEN'", "'ELSE'", "'END'", null, 
		null, null, "'NOT'", "'*'", "'/'", "'%'", "'+'", "'-'", "'In'", "'IS'", 
		"'NULL'", "'('", "')'", "','", "'BETWEEN'", "'LIKE'", "'COUNT'", "'SUM'", 
		"'AVG'", "'MAX'", "'MIN'", "'WITHIN'", "'milliseconds'", "'seconds'", 
		"'minutes'", "'hours'", "'days'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "Boolean", "Equal", "NotEqual", "LessThan", "LessThanOrEqual", 
		"GreaterThan", "GreaterThanOrEqual", "Dot", "Exp", "STRING", "Case", "When", 
		"Then", "Else", "End", "Digit", "And", "Or", "Not", "Multiply", "Divide", 
		"Mod", "Plus", "Minus", "In", "Is", "Null", "LeftParen", "RightParen", 
		"Comma", "Between", "Like", "Count", "Sum", "Avg", "Max", "Min", "Within", 
		"MilliSeconds", "Seconds", "Minutes", "Hours", "Days", "ID", "WS"
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
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExpressionParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			expression();
			setState(57);
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

	public static class CompareContext extends ParserRuleContext {
		public TerminalNode Equal() { return getToken(ExpressionParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(ExpressionParser.NotEqual, 0); }
		public TerminalNode LessThanOrEqual() { return getToken(ExpressionParser.LessThanOrEqual, 0); }
		public TerminalNode LessThan() { return getToken(ExpressionParser.LessThan, 0); }
		public TerminalNode GreaterThan() { return getToken(ExpressionParser.GreaterThan, 0); }
		public TerminalNode GreaterThanOrEqual() { return getToken(ExpressionParser.GreaterThanOrEqual, 0); }
		public CompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitCompare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareContext compare() throws RecognitionException {
		CompareContext _localctx = new CompareContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equal) | (1L << NotEqual) | (1L << LessThan) | (1L << LessThanOrEqual) | (1L << GreaterThan) | (1L << GreaterThanOrEqual))) != 0)) ) {
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

	public static class NumericContext extends ParserRuleContext {
		public DecimalContext decimal() {
			return getRuleContext(DecimalContext.class,0);
		}
		public IntNumberContext intNumber() {
			return getRuleContext(IntNumberContext.class,0);
		}
		public LongNumberContext longNumber() {
			return getRuleContext(LongNumberContext.class,0);
		}
		public NumericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNumeric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNumeric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitNumeric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericContext numeric() throws RecognitionException {
		NumericContext _localctx = new NumericContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_numeric);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				decimal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				intNumber();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				longNumber();
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

	public static class SignContext extends ParserRuleContext {
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if ( !(_la==Plus || _la==Minus) ) {
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

	public static class DecimalContext extends ParserRuleContext {
		public TerminalNode Dot() { return getToken(ExpressionParser.Dot, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public DecimalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalContext decimal() throws RecognitionException {
		DecimalContext _localctx = new DecimalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decimal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Plus || _la==Minus) {
				{
				setState(68);
				sign();
				}
			}

			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Dot:
				{
				setState(71);
				match(Dot);
				setState(72);
				number();
				}
				break;
			case Digit:
				{
				setState(73);
				number();
				setState(74);
				match(Dot);
				setState(75);
				number();
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExpressionParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(STRING);
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

	public static class IntNumberContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public IntNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterIntNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitIntNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitIntNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntNumberContext intNumber() throws RecognitionException {
		IntNumberContext _localctx = new IntNumberContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_intNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Plus || _la==Minus) {
				{
				setState(81);
				sign();
				}
			}

			setState(84);
			number();
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

	public static class LongNumberContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public LongNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_longNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLongNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLongNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitLongNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LongNumberContext longNumber() throws RecognitionException {
		LongNumberContext _localctx = new LongNumberContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_longNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Plus || _la==Minus) {
				{
				setState(86);
				sign();
				}
			}

			setState(89);
			number();
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

	public static class NumberContext extends ParserRuleContext {
		public List<TerminalNode> Digit() { return getTokens(ExpressionParser.Digit); }
		public TerminalNode Digit(int i) {
			return getToken(ExpressionParser.Digit, i);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_number);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(91);
					match(Digit);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(94); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public ConditionRightHandSideContext conditionRightHandSide() {
			return getRuleContext(ConditionRightHandSideContext.class,0);
		}
		public TerminalNode Not() { return getToken(ExpressionParser.Not, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_condition);
		int _la;
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case Boolean:
			case Dot:
			case STRING:
			case Case:
			case Digit:
			case Plus:
			case Minus:
			case Null:
			case LeftParen:
			case Count:
			case Sum:
			case Avg:
			case Max:
			case Min:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				operand();
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolean) | (1L << Equal) | (1L << NotEqual) | (1L << LessThan) | (1L << LessThanOrEqual) | (1L << GreaterThan) | (1L << GreaterThanOrEqual) | (1L << Dot) | (1L << STRING) | (1L << Case) | (1L << Digit) | (1L << Not) | (1L << Plus) | (1L << Minus) | (1L << In) | (1L << Is) | (1L << Null) | (1L << LeftParen) | (1L << Between) | (1L << Like) | (1L << Count) | (1L << Sum) | (1L << Avg) | (1L << Max) | (1L << Min) | (1L << ID))) != 0)) {
					{
					setState(97);
					conditionRightHandSide();
					}
				}

				}
				break;
			case Not:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(Not);
				setState(101);
				condition();
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<AndConditionContext> andCondition() {
			return getRuleContexts(AndConditionContext.class);
		}
		public AndConditionContext andCondition(int i) {
			return getRuleContext(AndConditionContext.class,i);
		}
		public List<TerminalNode> Or() { return getTokens(ExpressionParser.Or); }
		public TerminalNode Or(int i) {
			return getToken(ExpressionParser.Or, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			andCondition();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Or) {
				{
				{
				setState(105);
				match(Or);
				setState(106);
				andCondition();
				}
				}
				setState(111);
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
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<TerminalNode> And() { return getTokens(ExpressionParser.And); }
		public TerminalNode And(int i) {
			return getToken(ExpressionParser.And, i);
		}
		public AndConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAndCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAndCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAndCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndConditionContext andCondition() throws RecognitionException {
		AndConditionContext _localctx = new AndConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_andCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			condition();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==And) {
				{
				{
				setState(113);
				match(And);
				setState(114);
				condition();
				}
				}
				setState(119);
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

	public static class ConditionRightHandSideContext extends ParserRuleContext {
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode Is() { return getToken(ExpressionParser.Is, 0); }
		public TerminalNode Null() { return getToken(ExpressionParser.Null, 0); }
		public TerminalNode Not() { return getToken(ExpressionParser.Not, 0); }
		public TerminalNode In() { return getToken(ExpressionParser.In, 0); }
		public TerminalNode LeftParen() { return getToken(ExpressionParser.LeftParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(ExpressionParser.RightParen, 0); }
		public List<TerminalNode> Comma() { return getTokens(ExpressionParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(ExpressionParser.Comma, i);
		}
		public TerminalNode Between() { return getToken(ExpressionParser.Between, 0); }
		public TerminalNode And() { return getToken(ExpressionParser.And, 0); }
		public TerminalNode Like() { return getToken(ExpressionParser.Like, 0); }
		public ConditionRightHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionRightHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterConditionRightHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitConditionRightHandSide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitConditionRightHandSide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionRightHandSideContext conditionRightHandSide() throws RecognitionException {
		ConditionRightHandSideContext _localctx = new ConditionRightHandSideContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_conditionRightHandSide);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Equal:
			case NotEqual:
			case LessThan:
			case LessThanOrEqual:
			case GreaterThan:
			case GreaterThanOrEqual:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				compare();
				setState(121);
				operand();
				}
				break;
			case Is:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(Is);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Not) {
					{
					setState(124);
					match(Not);
					}
				}

				setState(127);
				match(Null);
				}
				break;
			case In:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				match(In);
				setState(129);
				match(LeftParen);
				setState(130);
				expression();
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(131);
					match(Comma);
					setState(132);
					expression();
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(138);
				match(RightParen);
				}
				break;
			case Between:
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				match(Between);
				setState(141);
				operand();
				setState(142);
				match(And);
				setState(143);
				operand();
				}
				break;
			case T__0:
			case Boolean:
			case Dot:
			case STRING:
			case Case:
			case Digit:
			case Not:
			case Plus:
			case Minus:
			case Null:
			case LeftParen:
			case Like:
			case Count:
			case Sum:
			case Avg:
			case Max:
			case Min:
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Not) {
					{
					setState(145);
					match(Not);
					}
				}

				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Like) {
					{
					setState(148);
					match(Like);
					}
				}

				setState(151);
				operand();
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

	public static class ValueContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public ColumnRefContext columnRef() {
			return getRuleContext(ColumnRefContext.class,0);
		}
		public TerminalNode Boolean() { return getToken(ExpressionParser.Boolean, 0); }
		public TerminalNode Null() { return getToken(ExpressionParser.Null, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_value);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				string();
				}
				break;
			case Dot:
			case Digit:
			case Plus:
			case Minus:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				numeric();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				param();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				columnRef();
				}
				break;
			case Boolean:
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				match(Boolean);
				}
				break;
			case Null:
				enterOuterAlt(_localctx, 6);
				{
				setState(159);
				match(Null);
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExpressionParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__0);
			setState(163);
			match(ID);
			setState(164);
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

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExpressionParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(ID);
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

	public static class ColumnRefContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ExpressionParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExpressionParser.ID, i);
		}
		public TerminalNode Dot() { return getToken(ExpressionParser.Dot, 0); }
		public ColumnRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterColumnRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitColumnRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitColumnRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnRefContext columnRef() throws RecognitionException {
		ColumnRefContext _localctx = new ColumnRefContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_columnRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(ID);
			setState(169);
			match(Dot);
			setState(170);
			match(ID);
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

	public static class OperandContext extends ParserRuleContext {
		public SummandContext summand() {
			return getRuleContext(SummandContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			summand();
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

	public static class SummandContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<PlusMinusContext> plusMinus() {
			return getRuleContexts(PlusMinusContext.class);
		}
		public PlusMinusContext plusMinus(int i) {
			return getRuleContext(PlusMinusContext.class,i);
		}
		public SummandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_summand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterSummand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitSummand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitSummand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SummandContext summand() throws RecognitionException {
		SummandContext _localctx = new SummandContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_summand);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			factor();
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(175);
					plusMinus();
					setState(176);
					factor();
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class PlusMinusContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(ExpressionParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(ExpressionParser.Minus, 0); }
		public PlusMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusMinus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitPlusMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusMinusContext plusMinus() throws RecognitionException {
		PlusMinusContext _localctx = new PlusMinusContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_plusMinus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_la = _input.LA(1);
			if ( !(_la==Plus || _la==Minus) ) {
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

	public static class FactorContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<MulDivModContext> mulDivMod() {
			return getRuleContexts(MulDivModContext.class);
		}
		public MulDivModContext mulDivMod(int i) {
			return getRuleContext(MulDivModContext.class,i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			term();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multiply) | (1L << Divide) | (1L << Mod))) != 0)) {
				{
				{
				setState(186);
				mulDivMod();
				setState(187);
				term();
				}
				}
				setState(193);
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

	public static class MulDivModContext extends ParserRuleContext {
		public TerminalNode Multiply() { return getToken(ExpressionParser.Multiply, 0); }
		public TerminalNode Divide() { return getToken(ExpressionParser.Divide, 0); }
		public TerminalNode Mod() { return getToken(ExpressionParser.Mod, 0); }
		public MulDivModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulDivMod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterMulDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitMulDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulDivModContext mulDivMod() throws RecognitionException {
		MulDivModContext _localctx = new MulDivModContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_mulDivMod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multiply) | (1L << Divide) | (1L << Mod))) != 0)) ) {
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

	public static class TermContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode Plus() { return getToken(ExpressionParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(ExpressionParser.Minus, 0); }
		public TerminalNode LeftParen() { return getToken(ExpressionParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(ExpressionParser.RightParen, 0); }
		public CaseWhenContext caseWhen() {
			return getRuleContext(CaseWhenContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_term);
		int _la;
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				function();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				value();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(199);
				term();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(200);
				match(LeftParen);
				setState(201);
				expression();
				setState(202);
				match(RightParen);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				caseWhen();
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExpressionParser.ID, 0); }
		public TerminalNode LeftParen() { return getToken(ExpressionParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(ExpressionParser.RightParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(ExpressionParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(ExpressionParser.Comma, i);
		}
		public AggregationContext aggregation() {
			return getRuleContext(AggregationContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_function);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(ID);
				setState(208);
				match(LeftParen);
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Boolean) | (1L << Dot) | (1L << STRING) | (1L << Case) | (1L << Digit) | (1L << Not) | (1L << Plus) | (1L << Minus) | (1L << Null) | (1L << LeftParen) | (1L << Count) | (1L << Sum) | (1L << Avg) | (1L << Max) | (1L << Min) | (1L << ID))) != 0)) {
					{
					setState(209);
					expression();
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(210);
						match(Comma);
						setState(211);
						expression();
						}
						}
						setState(216);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(219);
				match(RightParen);
				}
				break;
			case Count:
			case Sum:
			case Avg:
			case Max:
			case Min:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				aggregation();
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

	public static class CaseWhenContext extends ParserRuleContext {
		public TerminalNode Case() { return getToken(ExpressionParser.Case, 0); }
		public TerminalNode Else() { return getToken(ExpressionParser.Else, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode End() { return getToken(ExpressionParser.End, 0); }
		public List<TerminalNode> When() { return getTokens(ExpressionParser.When); }
		public TerminalNode When(int i) {
			return getToken(ExpressionParser.When, i);
		}
		public List<TerminalNode> Then() { return getTokens(ExpressionParser.Then); }
		public TerminalNode Then(int i) {
			return getToken(ExpressionParser.Then, i);
		}
		public CaseWhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseWhen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterCaseWhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitCaseWhen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitCaseWhen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseWhenContext caseWhen() throws RecognitionException {
		CaseWhenContext _localctx = new CaseWhenContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_caseWhen);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(Case);
			setState(229); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(224);
				match(When);
				setState(225);
				expression();
				setState(226);
				match(Then);
				setState(227);
				expression();
				}
				}
				setState(231); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==When );
			setState(233);
			match(Else);
			setState(234);
			expression();
			setState(235);
			match(End);
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

	public static class AggContext extends ParserRuleContext {
		public TerminalNode Count() { return getToken(ExpressionParser.Count, 0); }
		public TerminalNode Sum() { return getToken(ExpressionParser.Sum, 0); }
		public TerminalNode Avg() { return getToken(ExpressionParser.Avg, 0); }
		public TerminalNode Max() { return getToken(ExpressionParser.Max, 0); }
		public TerminalNode Min() { return getToken(ExpressionParser.Min, 0); }
		public AggContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAgg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAgg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAgg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggContext agg() throws RecognitionException {
		AggContext _localctx = new AggContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_agg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Count) | (1L << Sum) | (1L << Avg) | (1L << Max) | (1L << Min))) != 0)) ) {
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

	public static class TimeunitContext extends ParserRuleContext {
		public TerminalNode MilliSeconds() { return getToken(ExpressionParser.MilliSeconds, 0); }
		public TerminalNode Minutes() { return getToken(ExpressionParser.Minutes, 0); }
		public TerminalNode Hours() { return getToken(ExpressionParser.Hours, 0); }
		public TerminalNode Days() { return getToken(ExpressionParser.Days, 0); }
		public TimeunitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeunit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterTimeunit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitTimeunit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitTimeunit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeunitContext timeunit() throws RecognitionException {
		TimeunitContext _localctx = new TimeunitContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_timeunit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MilliSeconds) | (1L << Minutes) | (1L << Hours) | (1L << Days))) != 0)) ) {
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

	public static class AggregationContext extends ParserRuleContext {
		public AggContext agg() {
			return getRuleContext(AggContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(ExpressionParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(ExpressionParser.RightParen, 0); }
		public TerminalNode Within() { return getToken(ExpressionParser.Within, 0); }
		public IntNumberContext intNumber() {
			return getRuleContext(IntNumberContext.class,0);
		}
		public TimeunitContext timeunit() {
			return getRuleContext(TimeunitContext.class,0);
		}
		public AggregationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAggregation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAggregation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAggregation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregationContext aggregation() throws RecognitionException {
		AggregationContext _localctx = new AggregationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_aggregation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			agg();
			setState(242);
			match(LeftParen);
			setState(243);
			expression();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Within) {
				{
				setState(244);
				match(Within);
				setState(245);
				intNumber();
				setState(246);
				timeunit();
				}
			}

			setState(250);
			match(RightParen);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u00ff\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\4\5\4C\n\4\3\5\3\5\3\6\5\6H\n\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6P\n\6\3\7"+
		"\3\7\3\b\5\bU\n\b\3\b\3\b\3\t\5\tZ\n\t\3\t\3\t\3\n\6\n_\n\n\r\n\16\n`"+
		"\3\13\3\13\5\13e\n\13\3\13\3\13\5\13i\n\13\3\f\3\f\3\f\7\fn\n\f\f\f\16"+
		"\fq\13\f\3\r\3\r\3\r\7\rv\n\r\f\r\16\ry\13\r\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0080\n\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0088\n\16\f\16\16"+
		"\16\u008b\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0095\n\16"+
		"\3\16\5\16\u0098\n\16\3\16\5\16\u009b\n\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u00a3\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u00b5\n\24\f\24\16\24\u00b8\13\24"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u00c0\n\26\f\26\16\26\u00c3\13\26"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00d0\n\30"+
		"\3\31\3\31\3\31\3\31\3\31\7\31\u00d7\n\31\f\31\16\31\u00da\13\31\5\31"+
		"\u00dc\n\31\3\31\3\31\5\31\u00e0\n\31\3\32\3\32\3\32\3\32\3\32\3\32\6"+
		"\32\u00e8\n\32\r\32\16\32\u00e9\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00fb\n\35\3\35\3\35\3\35\2\2"+
		"\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\7\3"+
		"\2\6\13\3\2\33\34\3\2\30\32\3\2%)\4\2++-/\2\u0105\2:\3\2\2\2\4=\3\2\2"+
		"\2\6B\3\2\2\2\bD\3\2\2\2\nG\3\2\2\2\fQ\3\2\2\2\16T\3\2\2\2\20Y\3\2\2\2"+
		"\22^\3\2\2\2\24h\3\2\2\2\26j\3\2\2\2\30r\3\2\2\2\32\u009a\3\2\2\2\34\u00a2"+
		"\3\2\2\2\36\u00a4\3\2\2\2 \u00a8\3\2\2\2\"\u00aa\3\2\2\2$\u00ae\3\2\2"+
		"\2&\u00b0\3\2\2\2(\u00b9\3\2\2\2*\u00bb\3\2\2\2,\u00c4\3\2\2\2.\u00cf"+
		"\3\2\2\2\60\u00df\3\2\2\2\62\u00e1\3\2\2\2\64\u00ef\3\2\2\2\66\u00f1\3"+
		"\2\2\28\u00f3\3\2\2\2:;\5\26\f\2;<\7\2\2\3<\3\3\2\2\2=>\t\2\2\2>\5\3\2"+
		"\2\2?C\5\n\6\2@C\5\16\b\2AC\5\20\t\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2C\7"+
		"\3\2\2\2DE\t\3\2\2E\t\3\2\2\2FH\5\b\5\2GF\3\2\2\2GH\3\2\2\2HO\3\2\2\2"+
		"IJ\7\f\2\2JP\5\22\n\2KL\5\22\n\2LM\7\f\2\2MN\5\22\n\2NP\3\2\2\2OI\3\2"+
		"\2\2OK\3\2\2\2P\13\3\2\2\2QR\7\16\2\2R\r\3\2\2\2SU\5\b\5\2TS\3\2\2\2T"+
		"U\3\2\2\2UV\3\2\2\2VW\5\22\n\2W\17\3\2\2\2XZ\5\b\5\2YX\3\2\2\2YZ\3\2\2"+
		"\2Z[\3\2\2\2[\\\5\22\n\2\\\21\3\2\2\2]_\7\24\2\2^]\3\2\2\2_`\3\2\2\2`"+
		"^\3\2\2\2`a\3\2\2\2a\23\3\2\2\2bd\5$\23\2ce\5\32\16\2dc\3\2\2\2de\3\2"+
		"\2\2ei\3\2\2\2fg\7\27\2\2gi\5\24\13\2hb\3\2\2\2hf\3\2\2\2i\25\3\2\2\2"+
		"jo\5\30\r\2kl\7\26\2\2ln\5\30\r\2mk\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2"+
		"\2\2p\27\3\2\2\2qo\3\2\2\2rw\5\24\13\2st\7\25\2\2tv\5\24\13\2us\3\2\2"+
		"\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\31\3\2\2\2yw\3\2\2\2z{\5\4\3\2{|\5$"+
		"\23\2|\u009b\3\2\2\2}\177\7\36\2\2~\u0080\7\27\2\2\177~\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u009b\7\37\2\2\u0082\u0083\7\35\2\2"+
		"\u0083\u0084\7 \2\2\u0084\u0089\5\26\f\2\u0085\u0086\7\"\2\2\u0086\u0088"+
		"\5\26\f\2\u0087\u0085\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2"+
		"\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d"+
		"\7!\2\2\u008d\u009b\3\2\2\2\u008e\u008f\7#\2\2\u008f\u0090\5$\23\2\u0090"+
		"\u0091\7\25\2\2\u0091\u0092\5$\23\2\u0092\u009b\3\2\2\2\u0093\u0095\7"+
		"\27\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0098\7$\2\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u009b\5$\23\2\u009az\3\2\2\2\u009a}\3\2\2\2\u009a\u0082\3\2"+
		"\2\2\u009a\u008e\3\2\2\2\u009a\u0094\3\2\2\2\u009b\33\3\2\2\2\u009c\u00a3"+
		"\5\f\7\2\u009d\u00a3\5\6\4\2\u009e\u00a3\5\36\20\2\u009f\u00a3\5\"\22"+
		"\2\u00a0\u00a3\7\5\2\2\u00a1\u00a3\7\37\2\2\u00a2\u009c\3\2\2\2\u00a2"+
		"\u009d\3\2\2\2\u00a2\u009e\3\2\2\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2"+
		"\2\2\u00a2\u00a1\3\2\2\2\u00a3\35\3\2\2\2\u00a4\u00a5\7\3\2\2\u00a5\u00a6"+
		"\7\60\2\2\u00a6\u00a7\7\4\2\2\u00a7\37\3\2\2\2\u00a8\u00a9\7\60\2\2\u00a9"+
		"!\3\2\2\2\u00aa\u00ab\7\60\2\2\u00ab\u00ac\7\f\2\2\u00ac\u00ad\7\60\2"+
		"\2\u00ad#\3\2\2\2\u00ae\u00af\5&\24\2\u00af%\3\2\2\2\u00b0\u00b6\5*\26"+
		"\2\u00b1\u00b2\5(\25\2\u00b2\u00b3\5*\26\2\u00b3\u00b5\3\2\2\2\u00b4\u00b1"+
		"\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\'\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\t\3\2\2\u00ba)\3\2\2\2\u00bb"+
		"\u00c1\5.\30\2\u00bc\u00bd\5,\27\2\u00bd\u00be\5.\30\2\u00be\u00c0\3\2"+
		"\2\2\u00bf\u00bc\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2+\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\t\4\2\2"+
		"\u00c5-\3\2\2\2\u00c6\u00d0\5\60\31\2\u00c7\u00d0\5\34\17\2\u00c8\u00c9"+
		"\t\3\2\2\u00c9\u00d0\5.\30\2\u00ca\u00cb\7 \2\2\u00cb\u00cc\5\26\f\2\u00cc"+
		"\u00cd\7!\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00d0\5\62\32\2\u00cf\u00c6\3"+
		"\2\2\2\u00cf\u00c7\3\2\2\2\u00cf\u00c8\3\2\2\2\u00cf\u00ca\3\2\2\2\u00cf"+
		"\u00ce\3\2\2\2\u00d0/\3\2\2\2\u00d1\u00d2\7\60\2\2\u00d2\u00db\7 \2\2"+
		"\u00d3\u00d8\5\26\f\2\u00d4\u00d5\7\"\2\2\u00d5\u00d7\5\26\f\2\u00d6\u00d4"+
		"\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00d3\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e0\7!\2\2\u00de\u00e0\58\35\2\u00df"+
		"\u00d1\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\61\3\2\2\2\u00e1\u00e7\7\17\2"+
		"\2\u00e2\u00e3\7\20\2\2\u00e3\u00e4\5\26\f\2\u00e4\u00e5\7\21\2\2\u00e5"+
		"\u00e6\5\26\f\2\u00e6\u00e8\3\2\2\2\u00e7\u00e2\3\2\2\2\u00e8\u00e9\3"+
		"\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ec\7\22\2\2\u00ec\u00ed\5\26\f\2\u00ed\u00ee\7\23\2\2\u00ee\63\3\2"+
		"\2\2\u00ef\u00f0\t\5\2\2\u00f0\65\3\2\2\2\u00f1\u00f2\t\6\2\2\u00f2\67"+
		"\3\2\2\2\u00f3\u00f4\5\64\33\2\u00f4\u00f5\7 \2\2\u00f5\u00fa\5\26\f\2"+
		"\u00f6\u00f7\7*\2\2\u00f7\u00f8\5\16\b\2\u00f8\u00f9\5\66\34\2\u00f9\u00fb"+
		"\3\2\2\2\u00fa\u00f6\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u00fd\7!\2\2\u00fd9\3\2\2\2\32BGOTY`dhow\177\u0089\u0094\u0097\u009a"+
		"\u00a2\u00b6\u00c1\u00cf\u00d8\u00db\u00df\u00e9\u00fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}