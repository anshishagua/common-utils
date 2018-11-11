// Generated from /Users/lixiao/code/common-utils/src/main/resources/Pig.g4 by ANTLR 4.7
package com.anshishagua.pig;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PigLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "LOAD", "LETTER", "DIGIT", "INTEGER", "LONGINTEGER", "UNDER_SCORE", 
		"DOLAR", "SEMI_COLON", "SINGLE_QUOTE", "USING", "LEFT_PAREN", "RIGHT_PAREN", 
		"AS", "COLON", "MAP", "TUPLE", "STAR", "PATH_SEP", "BOOLEAN_TYPE", "INT_TYPE", 
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


	public PigLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pig.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2[\u0286\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\6\7\u00cc\n\7\r\7"+
		"\16\7\u00cd\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3"+
		"%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3"+
		"-\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u01be\n\65"+
		"\3\66\3\66\3\66\3\66\5\66\u01c4\n\66\3\66\3\66\3\66\5\66\u01c9\n\66\3"+
		"\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\39\39\39\39\39\39\39\39\39\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\7:\u01ea\n:\f:\16:\u01ed\13:\3:\3:\3;"+
		"\3;\3;\3<\3<\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?"+
		"\3@\3@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C"+
		"\3D\3D\3D\3D\3D\3D\3D\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K"+
		"\3L\3L\3L\3L\3M\3M\3M\3N\3N\3N\3N\3O\3O\3O\3P\3P\3P\3Q\3Q\3Q\3R\3R\3S"+
		"\3S\3S\3T\3T\3U\3U\3U\3V\3V\3V\3W\3W\3W\3W\3W\3X\3X\3X\3X\7X\u0261\nX"+
		"\fX\16X\u0264\13X\3Y\3Y\3Y\3Z\3Z\3Z\3Z\7Z\u026d\nZ\fZ\16Z\u0270\13Z\3"+
		"Z\3Z\3[\3[\3[\3[\7[\u0278\n[\f[\16[\u027b\13[\3[\3[\3[\3\\\6\\\u0281\n"+
		"\\\r\\\16\\\u0282\3\\\3\\\3\u0279\2]\3\3\5\4\7\5\t\2\13\2\r\6\17\7\21"+
		"\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26"+
		"/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%M&O\'Q(S)U*W"+
		"+Y,[-]._/a\60c\61e\62g\63i\64k\65m\66o\67q8s9u:w;y<{=}>\177?\u0081@\u0083"+
		"A\u0085B\u0087C\u0089D\u008bE\u008dF\u008fG\u0091H\u0093I\u0095J\u0097"+
		"K\u0099L\u009bM\u009dN\u009fO\u00a1P\u00a3Q\u00a5R\u00a7S\u00a9T\u00ab"+
		"U\u00adV\u00afW\u00b1X\u00b3Y\u00b5Z\u00b7[\3\2\b\4\2C\\c|\3\2\62;\6\2"+
		"\f\f\17\17))^^\t\2))DDHHPPTTVV^^\4\2\62;CH\5\2\13\f\17\17\"\"\2\u0290"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2"+
		"s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3"+
		"\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2"+
		"\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5"+
		"\3\2\2\2\2\u00b7\3\2\2\2\3\u00b9\3\2\2\2\5\u00bb\3\2\2\2\7\u00c1\3\2\2"+
		"\2\t\u00c6\3\2\2\2\13\u00c8\3\2\2\2\r\u00cb\3\2\2\2\17\u00cf\3\2\2\2\21"+
		"\u00d2\3\2\2\2\23\u00d4\3\2\2\2\25\u00d6\3\2\2\2\27\u00d8\3\2\2\2\31\u00da"+
		"\3\2\2\2\33\u00e0\3\2\2\2\35\u00e2\3\2\2\2\37\u00e4\3\2\2\2!\u00e7\3\2"+
		"\2\2#\u00e9\3\2\2\2%\u00ed\3\2\2\2\'\u00f3\3\2\2\2)\u00f5\3\2\2\2+\u00f7"+
		"\3\2\2\2-\u00ff\3\2\2\2/\u0103\3\2\2\2\61\u0108\3\2\2\2\63\u010e\3\2\2"+
		"\2\65\u0115\3\2\2\2\67\u011f\3\2\2\29\u0129\3\2\2\2;\u0132\3\2\2\2=\u013d"+
		"\3\2\2\2?\u0148\3\2\2\2A\u014a\3\2\2\2C\u0154\3\2\2\2E\u015a\3\2\2\2G"+
		"\u015e\3\2\2\2I\u0163\3\2\2\2K\u0169\3\2\2\2M\u016e\3\2\2\2O\u0175\3\2"+
		"\2\2Q\u017e\3\2\2\2S\u0180\3\2\2\2U\u0182\3\2\2\2W\u0187\3\2\2\2Y\u0190"+
		"\3\2\2\2[\u0196\3\2\2\2]\u019a\3\2\2\2_\u019d\3\2\2\2a\u01a0\3\2\2\2c"+
		"\u01a3\3\2\2\2e\u01a7\3\2\2\2g\u01ab\3\2\2\2i\u01bd\3\2\2\2k\u01c8\3\2"+
		"\2\2m\u01ca\3\2\2\2o\u01cf\3\2\2\2q\u01d5\3\2\2\2s\u01de\3\2\2\2u\u01f0"+
		"\3\2\2\2w\u01f3\3\2\2\2y\u01f5\3\2\2\2{\u01f8\3\2\2\2}\u01ff\3\2\2\2\177"+
		"\u0208\3\2\2\2\u0081\u020c\3\2\2\2\u0083\u0211\3\2\2\2\u0085\u0217\3\2"+
		"\2\2\u0087\u021f\3\2\2\2\u0089\u0228\3\2\2\2\u008b\u022a\3\2\2\2\u008d"+
		"\u022c\3\2\2\2\u008f\u022e\3\2\2\2\u0091\u0230\3\2\2\2\u0093\u0232\3\2"+
		"\2\2\u0095\u0234\3\2\2\2\u0097\u0236\3\2\2\2\u0099\u023a\3\2\2\2\u009b"+
		"\u023d\3\2\2\2\u009d\u0241\3\2\2\2\u009f\u0244\3\2\2\2\u00a1\u0247\3\2"+
		"\2\2\u00a3\u024a\3\2\2\2\u00a5\u024c\3\2\2\2\u00a7\u024f\3\2\2\2\u00a9"+
		"\u0251\3\2\2\2\u00ab\u0254\3\2\2\2\u00ad\u0257\3\2\2\2\u00af\u025c\3\2"+
		"\2\2\u00b1\u0265\3\2\2\2\u00b3\u0268\3\2\2\2\u00b5\u0273\3\2\2\2\u00b7"+
		"\u0280\3\2\2\2\u00b9\u00ba\7~\2\2\u00ba\4\3\2\2\2\u00bb\u00bc\7C\2\2\u00bc"+
		"\u00bd\7C\2\2\u00bd\u00be\7C\2\2\u00be\u00bf\7C\2\2\u00bf\u00c0\7C\2\2"+
		"\u00c0\6\3\2\2\2\u00c1\u00c2\7N\2\2\u00c2\u00c3\7Q\2\2\u00c3\u00c4\7C"+
		"\2\2\u00c4\u00c5\7F\2\2\u00c5\b\3\2\2\2\u00c6\u00c7\t\2\2\2\u00c7\n\3"+
		"\2\2\2\u00c8\u00c9\t\3\2\2\u00c9\f\3\2\2\2\u00ca\u00cc\5\13\6\2\u00cb"+
		"\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\16\3\2\2\2\u00cf\u00d0\5\r\7\2\u00d0\u00d1\7N\2\2\u00d1\20"+
		"\3\2\2\2\u00d2\u00d3\7a\2\2\u00d3\22\3\2\2\2\u00d4\u00d5\7&\2\2\u00d5"+
		"\24\3\2\2\2\u00d6\u00d7\7=\2\2\u00d7\26\3\2\2\2\u00d8\u00d9\7)\2\2\u00d9"+
		"\30\3\2\2\2\u00da\u00db\7W\2\2\u00db\u00dc\7U\2\2\u00dc\u00dd\7K\2\2\u00dd"+
		"\u00de\7P\2\2\u00de\u00df\7I\2\2\u00df\32\3\2\2\2\u00e0\u00e1\7*\2\2\u00e1"+
		"\34\3\2\2\2\u00e2\u00e3\7+\2\2\u00e3\36\3\2\2\2\u00e4\u00e5\7C\2\2\u00e5"+
		"\u00e6\7U\2\2\u00e6 \3\2\2\2\u00e7\u00e8\7<\2\2\u00e8\"\3\2\2\2\u00e9"+
		"\u00ea\7o\2\2\u00ea\u00eb\7c\2\2\u00eb\u00ec\7r\2\2\u00ec$\3\2\2\2\u00ed"+
		"\u00ee\7v\2\2\u00ee\u00ef\7w\2\2\u00ef\u00f0\7r\2\2\u00f0\u00f1\7n\2\2"+
		"\u00f1\u00f2\7g\2\2\u00f2&\3\2\2\2\u00f3\u00f4\7,\2\2\u00f4(\3\2\2\2\u00f5"+
		"\u00f6\7\61\2\2\u00f6*\3\2\2\2\u00f7\u00f8\7d\2\2\u00f8\u00f9\7q\2\2\u00f9"+
		"\u00fa\7q\2\2\u00fa\u00fb\7n\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7c\2\2"+
		"\u00fd\u00fe\7p\2\2\u00fe,\3\2\2\2\u00ff\u0100\7k\2\2\u0100\u0101\7p\2"+
		"\2\u0101\u0102\7v\2\2\u0102.\3\2\2\2\u0103\u0104\7n\2\2\u0104\u0105\7"+
		"q\2\2\u0105\u0106\7p\2\2\u0106\u0107\7i\2\2\u0107\60\3\2\2\2\u0108\u0109"+
		"\7h\2\2\u0109\u010a\7n\2\2\u010a\u010b\7q\2\2\u010b\u010c\7c\2\2\u010c"+
		"\u010d\7v\2\2\u010d\62\3\2\2\2\u010e\u010f\7f\2\2\u010f\u0110\7q\2\2\u0110"+
		"\u0111\7w\2\2\u0111\u0112\7d\2\2\u0112\u0113\7n\2\2\u0113\u0114\7g\2\2"+
		"\u0114\64\3\2\2\2\u0115\u0116\7e\2\2\u0116\u0117\7j\2\2\u0117\u0118\7"+
		"c\2\2\u0118\u0119\7t\2\2\u0119\u011a\7c\2\2\u011a\u011b\7t\2\2\u011b\u011c"+
		"\7t\2\2\u011c\u011d\7c\2\2\u011d\u011e\7{\2\2\u011e\66\3\2\2\2\u011f\u0120"+
		"\7d\2\2\u0120\u0121\7{\2\2\u0121\u0122\7v\2\2\u0122\u0123\7g\2\2\u0123"+
		"\u0124\7c\2\2\u0124\u0125\7t\2\2\u0125\u0126\7t\2\2\u0126\u0127\7c\2\2"+
		"\u0127\u0128\7{\2\2\u01288\3\2\2\2\u0129\u012a\7f\2\2\u012a\u012b\7c\2"+
		"\2\u012b\u012c\7v\2\2\u012c\u012d\7g\2\2\u012d\u012e\7v\2\2\u012e\u012f"+
		"\7k\2\2\u012f\u0130\7o\2\2\u0130\u0131\7g\2\2\u0131:\3\2\2\2\u0132\u0133"+
		"\7d\2\2\u0133\u0134\7k\2\2\u0134\u0135\7i\2\2\u0135\u0136\7k\2\2\u0136"+
		"\u0137\7p\2\2\u0137\u0138\7v\2\2\u0138\u0139\7g\2\2\u0139\u013a\7i\2\2"+
		"\u013a\u013b\7g\2\2\u013b\u013c\7t\2\2\u013c<\3\2\2\2\u013d\u013e\7d\2"+
		"\2\u013e\u013f\7k\2\2\u013f\u0140\7i\2\2\u0140\u0141\7f\2\2\u0141\u0142"+
		"\7g\2\2\u0142\u0143\7e\2\2\u0143\u0144\7k\2\2\u0144\u0145\7o\2\2\u0145"+
		"\u0146\7c\2\2\u0146\u0147\7n\2\2\u0147>\3\2\2\2\u0148\u0149\7.\2\2\u0149"+
		"@\3\2\2\2\u014a\u014b\7R\2\2\u014b\u014c\7C\2\2\u014c\u014d\7T\2\2\u014d"+
		"\u014e\7V\2\2\u014e\u014f\7K\2\2\u014f\u0150\7V\2\2\u0150\u0151\7K\2\2"+
		"\u0151\u0152\7Q\2\2\u0152\u0153\7P\2\2\u0153B\3\2\2\2\u0154\u0155\7W\2"+
		"\2\u0155\u0156\7P\2\2\u0156\u0157\7K\2\2\u0157\u0158\7Q\2\2\u0158\u0159"+
		"\7P\2\2\u0159D\3\2\2\2\u015a\u015b\7C\2\2\u015b\u015c\7N\2\2\u015c\u015d"+
		"\7N\2\2\u015dF\3\2\2\2\u015e\u015f\7N\2\2\u015f\u0160\7G\2\2\u0160\u0161"+
		"\7H\2\2\u0161\u0162\7V\2\2\u0162H\3\2\2\2\u0163\u0164\7T\2\2\u0164\u0165"+
		"\7K\2\2\u0165\u0166\7I\2\2\u0166\u0167\7J\2\2\u0167\u0168\7V\2\2\u0168"+
		"J\3\2\2\2\u0169\u016a\7H\2\2\u016a\u016b\7W\2\2\u016b\u016c\7N\2\2\u016c"+
		"\u016d\7N\2\2\u016dL\3\2\2\2\u016e\u016f\7Q\2\2\u016f\u0170\7W\2\2\u0170"+
		"\u0171\7P\2\2\u0171\u0172\7V\2\2\u0172\u0173\7G\2\2\u0173\u0174\7T\2\2"+
		"\u0174N\3\2\2\2\u0175\u0176\7Q\2\2\u0176\u0177\7P\2\2\u0177\u0178\7U\2"+
		"\2\u0178\u0179\7E\2\2\u0179\u017a\7J\2\2\u017a\u017b\7G\2\2\u017b\u017c"+
		"\7O\2\2\u017c\u017d\7C\2\2\u017dP\3\2\2\2\u017e\u017f\7}\2\2\u017fR\3"+
		"\2\2\2\u0180\u0181\7\177\2\2\u0181T\3\2\2\2\u0182\u0183\7L\2\2\u0183\u0184"+
		"\7Q\2\2\u0184\u0185\7K\2\2\u0185\u0186\7P\2\2\u0186V\3\2\2\2\u0187\u0188"+
		"\7R\2\2\u0188\u0189\7C\2\2\u0189\u018a\7T\2\2\u018a\u018b\7C\2\2\u018b"+
		"\u018c\7N\2\2\u018c\u018d\7N\2\2\u018d\u018e\7G\2\2\u018e\u018f\7N\2\2"+
		"\u018fX\3\2\2\2\u0190\u0191\7I\2\2\u0191\u0192\7T\2\2\u0192\u0193\7Q\2"+
		"\2\u0193\u0194\7W\2\2\u0194\u0195\7R\2\2\u0195Z\3\2\2\2\u0196\u0197\7"+
		"U\2\2\u0197\u0198\7G\2\2\u0198\u0199\7V\2\2\u0199\\\3\2\2\2\u019a\u019b"+
		"\7G\2\2\u019b\u019c\7S\2\2\u019c^\3\2\2\2\u019d\u019e\7I\2\2\u019e\u019f"+
		"\7V\2\2\u019f`\3\2\2\2\u01a0\u01a1\7N\2\2\u01a1\u01a2\7V\2\2\u01a2b\3"+
		"\2\2\2\u01a3\u01a4\7I\2\2\u01a4\u01a5\7V\2\2\u01a5\u01a6\7G\2\2\u01a6"+
		"d\3\2\2\2\u01a7\u01a8\7N\2\2\u01a8\u01a9\7V\2\2\u01a9\u01aa\7G\2\2\u01aa"+
		"f\3\2\2\2\u01ab\u01ac\7P\2\2\u01ac\u01ad\7G\2\2\u01ad\u01ae\7S\2\2\u01ae"+
		"h\3\2\2\2\u01af\u01b0\7O\2\2\u01b0\u01b1\7C\2\2\u01b1\u01b2\7V\2\2\u01b2"+
		"\u01b3\7E\2\2\u01b3\u01b4\7J\2\2\u01b4\u01b5\7G\2\2\u01b5\u01be\7U\2\2"+
		"\u01b6\u01b7\7o\2\2\u01b7\u01b8\7c\2\2\u01b8\u01b9\7v\2\2\u01b9\u01ba"+
		"\7e\2\2\u01ba\u01bb\7j\2\2\u01bb\u01bc\7g\2\2\u01bc\u01be\7u\2\2\u01bd"+
		"\u01af\3\2\2\2\u01bd\u01b6\3\2\2\2\u01bej\3\2\2\2\u01bf\u01c3\5\r\7\2"+
		"\u01c0\u01c1\5w<\2\u01c1\u01c2\5\r\7\2\u01c2\u01c4\3\2\2\2\u01c3\u01c0"+
		"\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c9\3\2\2\2\u01c5\u01c6\5w<\2\u01c6"+
		"\u01c7\5\r\7\2\u01c7\u01c9\3\2\2\2\u01c8\u01bf\3\2\2\2\u01c8\u01c5\3\2"+
		"\2\2\u01c9l\3\2\2\2\u01ca\u01cb\7V\2\2\u01cb\u01cc\7T\2\2\u01cc\u01cd"+
		"\7W\2\2\u01cd\u01ce\7G\2\2\u01cen\3\2\2\2\u01cf\u01d0\7H\2\2\u01d0\u01d1"+
		"\7C\2\2\u01d1\u01d2\7N\2\2\u01d2\u01d3\7U\2\2\u01d3\u01d4\7G\2\2\u01d4"+
		"p\3\2\2\2\u01d5\u01d6\7H\2\2\u01d6\u01d7\7N\2\2\u01d7\u01d8\7C\2\2\u01d8"+
		"\u01d9\7V\2\2\u01d9\u01da\7V\2\2\u01da\u01db\7G\2\2\u01db\u01dc\7T\2\2"+
		"\u01dc\u01dd\7P\2\2\u01ddr\3\2\2\2\u01de\u01eb\7)\2\2\u01df\u01ea\n\4"+
		"\2\2\u01e0\u01e1\7^\2\2\u01e1\u01ea\t\5\2\2\u01e2\u01e3\7^\2\2\u01e3\u01e4"+
		"\7W\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\t\6\2\2\u01e6\u01e7\t\6\2\2\u01e7"+
		"\u01e8\t\6\2\2\u01e8\u01ea\t\6\2\2\u01e9\u01df\3\2\2\2\u01e9\u01e0\3\2"+
		"\2\2\u01e9\u01e2\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb"+
		"\u01ec\3\2\2\2\u01ec\u01ee\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01ef\7)"+
		"\2\2\u01eft\3\2\2\2\u01f0\u01f1\5k\66\2\u01f1\u01f2\7F\2\2\u01f2v\3\2"+
		"\2\2\u01f3\u01f4\7\60\2\2\u01f4x\3\2\2\2\u01f5\u01f6\7D\2\2\u01f6\u01f7"+
		"\7[\2\2\u01f7z\3\2\2\2\u01f8\u01f9\7H\2\2\u01f9\u01fa\7K\2\2\u01fa\u01fb"+
		"\7N\2\2\u01fb\u01fc\7V\2\2\u01fc\u01fd\7G\2\2\u01fd\u01fe\7T\2\2\u01fe"+
		"|\3\2\2\2\u01ff\u0200\7F\2\2\u0200\u0201\7K\2\2\u0201\u0202\7U\2\2\u0202"+
		"\u0203\7V\2\2\u0203\u0204\7K\2\2\u0204\u0205\7P\2\2\u0205\u0206\7E\2\2"+
		"\u0206\u0207\7V\2\2\u0207~\3\2\2\2\u0208\u0209\7%\2\2\u0209\u020a\7%\2"+
		"\2\u020a\u020b\7%\2\2\u020b\u0080\3\2\2\2\u020c\u020d\7K\2\2\u020d\u020e"+
		"\7P\2\2\u020e\u020f\7V\2\2\u020f\u0210\7Q\2\2\u0210\u0082\3\2\2\2\u0211"+
		"\u0212\7U\2\2\u0212\u0213\7V\2\2\u0213\u0214\7Q\2\2\u0214\u0215\7T\2\2"+
		"\u0215\u0216\7G\2\2\u0216\u0084\3\2\2\2\u0217\u0218\7H\2\2\u0218\u0219"+
		"\7Q\2\2\u0219\u021a\7T\2\2\u021a\u021b\7G\2\2\u021b\u021c\7C\2\2\u021c"+
		"\u021d\7E\2\2\u021d\u021e\7J\2\2\u021e\u0086\3\2\2\2\u021f\u0220\7I\2"+
		"\2\u0220\u0221\7G\2\2\u0221\u0222\7P\2\2\u0222\u0223\7G\2\2\u0223\u0224"+
		"\7T\2\2\u0224\u0225\7C\2\2\u0225\u0226\7V\2\2\u0226\u0227\7G\2\2\u0227"+
		"\u0088\3\2\2\2\u0228\u0229\7?\2\2\u0229\u008a\3\2\2\2\u022a\u022b\7-\2"+
		"\2\u022b\u008c\3\2\2\2\u022c\u022d\7/\2\2\u022d\u008e\3\2\2\2\u022e\u022f"+
		"\7,\2\2\u022f\u0090\3\2\2\2\u0230\u0231\7\61\2\2\u0231\u0092\3\2\2\2\u0232"+
		"\u0233\7\'\2\2\u0233\u0094\3\2\2\2\u0234\u0235\7A\2\2\u0235\u0096\3\2"+
		"\2\2\u0236\u0237\7C\2\2\u0237\u0238\7P\2\2\u0238\u0239\7F\2\2\u0239\u0098"+
		"\3\2\2\2\u023a\u023b\7Q\2\2\u023b\u023c\7T\2\2\u023c\u009a\3\2\2\2\u023d"+
		"\u023e\7P\2\2\u023e\u023f\7Q\2\2\u023f\u0240\7V\2\2\u0240\u009c\3\2\2"+
		"\2\u0241\u0242\7K\2\2\u0242\u0243\7P\2\2\u0243\u009e\3\2\2\2\u0244\u0245"+
		"\7?\2\2\u0245\u0246\7?\2\2\u0246\u00a0\3\2\2\2\u0247\u0248\7#\2\2\u0248"+
		"\u0249\7?\2\2\u0249\u00a2\3\2\2\2\u024a\u024b\7>\2\2\u024b\u00a4\3\2\2"+
		"\2\u024c\u024d\7>\2\2\u024d\u024e\7?\2\2\u024e\u00a6\3\2\2\2\u024f\u0250"+
		"\7@\2\2\u0250\u00a8\3\2\2\2\u0251\u0252\7@\2\2\u0252\u0253\7?\2\2\u0253"+
		"\u00aa\3\2\2\2\u0254\u0255\7k\2\2\u0255\u0256\7u\2\2\u0256\u00ac\3\2\2"+
		"\2\u0257\u0258\7p\2\2\u0258\u0259\7w\2\2\u0259\u025a\7n\2\2\u025a\u025b"+
		"\7n\2\2\u025b\u00ae\3\2\2\2\u025c\u0262\5\t\5\2\u025d\u0261\5\t\5\2\u025e"+
		"\u0261\5\13\6\2\u025f\u0261\5\21\t\2\u0260\u025d\3\2\2\2\u0260\u025e\3"+
		"\2\2\2\u0260\u025f\3\2\2\2\u0261\u0264\3\2\2\2\u0262\u0260\3\2\2\2\u0262"+
		"\u0263\3\2\2\2\u0263\u00b0\3\2\2\2\u0264\u0262\3\2\2\2\u0265\u0266\5\23"+
		"\n\2\u0266\u0267\5\r\7\2\u0267\u00b2\3\2\2\2\u0268\u0269\7/\2\2\u0269"+
		"\u026a\7/\2\2\u026a\u026e\3\2\2\2\u026b\u026d\13\2\2\2\u026c\u026b\3\2"+
		"\2\2\u026d\u0270\3\2\2\2\u026e\u026c\3\2\2\2\u026e\u026f\3\2\2\2\u026f"+
		"\u0271\3\2\2\2\u0270\u026e\3\2\2\2\u0271\u0272\7\f\2\2\u0272\u00b4\3\2"+
		"\2\2\u0273\u0274\7\61\2\2\u0274\u0275\7,\2\2\u0275\u0279\3\2\2\2\u0276"+
		"\u0278\13\2\2\2\u0277\u0276\3\2\2\2\u0278\u027b\3\2\2\2\u0279\u027a\3"+
		"\2\2\2\u0279\u0277\3\2\2\2\u027a\u027c\3\2\2\2\u027b\u0279\3\2\2\2\u027c"+
		"\u027d\7,\2\2\u027d\u027e\7\61\2\2\u027e\u00b6\3\2\2\2\u027f\u0281\t\7"+
		"\2\2\u0280\u027f\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0280\3\2\2\2\u0282"+
		"\u0283\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0285\b\\\2\2\u0285\u00b8\3\2"+
		"\2\2\16\2\u00cd\u01bd\u01c3\u01c8\u01e9\u01eb\u0260\u0262\u026e\u0279"+
		"\u0282\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}