// Generated from /Users/lixiao/code/common-utils/src/main/resources/Expression.g4 by ANTLR 4.7
package com.anshishagua.parser.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "Boolean", "Equal", "NotEqual", "LessThan", "LessThanOrEqual", 
		"GreaterThan", "GreaterThanOrEqual", "Dot", "Exp", "STRING", "Case", "When", 
		"Then", "Else", "End", "Digit", "And", "Or", "Not", "Multiply", "Divide", 
		"Mod", "Plus", "Minus", "In", "Is", "Null", "LeftParen", "RightParen", 
		"Comma", "Between", "Like", "Count", "Sum", "Avg", "Max", "Min", "Within", 
		"MilliSeconds", "Seconds", "Minutes", "Hours", "Days", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'${'", "'}'", null, "'='", null, "'<'", "'<='", "'>'", "'>='", 
		"'.'", null, null, "'CASE'", "'WHEN'", "'THEN'", "'ELSE'", "'END'", null, 
		null, null, null, "'*'", "'/'", "'%'", "'+'", "'-'", "'In'", "'IS'", "'NULL'", 
		"'('", "')'", "','", "'BETWEEN'", "'LIKE'", null, null, null, null, null, 
		"'within'", "'milliseconds'", "'seconds'", "'minutes'", "'hours'", "'days'"
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


	public ExpressionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0154\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4p\n\4\3\5\3\5\3\6\3\6\3\6\3\6\5\6x\n\6\3\7\3"+
		"\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\7\r\u008a"+
		"\n\r\f\r\16\r\u008d\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00b3"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00bb\n\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u00c3\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\5$\u00f7\n$\3%\3%\3%\3%\3%\3%\5%\u00ff\n%\3&\3&\3"+
		"&\3&\3&\3&\5&\u0107\n&\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u010f\n\'\3(\3(\3("+
		"\3(\3(\3(\5(\u0117\n(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-"+
		"\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\6/\u014a\n/\r/\16/\u014b\3\60\6\60\u014f"+
		"\n\60\r\60\16\60\u0150\3\60\3\60\2\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W"+
		"-Y.[/]\60_\61\3\2\b\4\2GGgg\3\2))\3\2\62;\6\2C\\aac|\u4e02\u9fa7\7\2\62"+
		";C\\aac|\u4e02\u9fa7\5\2\13\f\17\17\"\"\2\u0162\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5d\3\2\2\2\7o\3"+
		"\2\2\2\tq\3\2\2\2\13w\3\2\2\2\ry\3\2\2\2\17{\3\2\2\2\21~\3\2\2\2\23\u0080"+
		"\3\2\2\2\25\u0083\3\2\2\2\27\u0085\3\2\2\2\31\u0087\3\2\2\2\33\u0090\3"+
		"\2\2\2\35\u0095\3\2\2\2\37\u009a\3\2\2\2!\u009f\3\2\2\2#\u00a4\3\2\2\2"+
		"%\u00a8\3\2\2\2\'\u00b2\3\2\2\2)\u00ba\3\2\2\2+\u00c2\3\2\2\2-\u00c4\3"+
		"\2\2\2/\u00c6\3\2\2\2\61\u00c8\3\2\2\2\63\u00ca\3\2\2\2\65\u00cc\3\2\2"+
		"\2\67\u00ce\3\2\2\29\u00d1\3\2\2\2;\u00d4\3\2\2\2=\u00d9\3\2\2\2?\u00db"+
		"\3\2\2\2A\u00dd\3\2\2\2C\u00df\3\2\2\2E\u00e7\3\2\2\2G\u00f6\3\2\2\2I"+
		"\u00fe\3\2\2\2K\u0106\3\2\2\2M\u010e\3\2\2\2O\u0116\3\2\2\2Q\u0118\3\2"+
		"\2\2S\u011f\3\2\2\2U\u012c\3\2\2\2W\u0134\3\2\2\2Y\u013c\3\2\2\2[\u0142"+
		"\3\2\2\2]\u0147\3\2\2\2_\u014e\3\2\2\2ab\7&\2\2bc\7}\2\2c\4\3\2\2\2de"+
		"\7\177\2\2e\6\3\2\2\2fg\7V\2\2gh\7T\2\2hi\7W\2\2ip\7G\2\2jk\7H\2\2kl\7"+
		"C\2\2lm\7N\2\2mn\7U\2\2np\7G\2\2of\3\2\2\2oj\3\2\2\2p\b\3\2\2\2qr\7?\2"+
		"\2r\n\3\2\2\2st\7>\2\2tx\7@\2\2uv\7#\2\2vx\7?\2\2ws\3\2\2\2wu\3\2\2\2"+
		"x\f\3\2\2\2yz\7>\2\2z\16\3\2\2\2{|\7>\2\2|}\7?\2\2}\20\3\2\2\2~\177\7"+
		"@\2\2\177\22\3\2\2\2\u0080\u0081\7@\2\2\u0081\u0082\7?\2\2\u0082\24\3"+
		"\2\2\2\u0083\u0084\7\60\2\2\u0084\26\3\2\2\2\u0085\u0086\t\2\2\2\u0086"+
		"\30\3\2\2\2\u0087\u008b\7)\2\2\u0088\u008a\n\3\2\2\u0089\u0088\3\2\2\2"+
		"\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\7)\2\2\u008f\32\3\2\2\2\u0090"+
		"\u0091\7E\2\2\u0091\u0092\7C\2\2\u0092\u0093\7U\2\2\u0093\u0094\7G\2\2"+
		"\u0094\34\3\2\2\2\u0095\u0096\7Y\2\2\u0096\u0097\7J\2\2\u0097\u0098\7"+
		"G\2\2\u0098\u0099\7P\2\2\u0099\36\3\2\2\2\u009a\u009b\7V\2\2\u009b\u009c"+
		"\7J\2\2\u009c\u009d\7G\2\2\u009d\u009e\7P\2\2\u009e \3\2\2\2\u009f\u00a0"+
		"\7G\2\2\u00a0\u00a1\7N\2\2\u00a1\u00a2\7U\2\2\u00a2\u00a3\7G\2\2\u00a3"+
		"\"\3\2\2\2\u00a4\u00a5\7G\2\2\u00a5\u00a6\7P\2\2\u00a6\u00a7\7F\2\2\u00a7"+
		"$\3\2\2\2\u00a8\u00a9\t\4\2\2\u00a9&\3\2\2\2\u00aa\u00ab\7C\2\2\u00ab"+
		"\u00ac\7P\2\2\u00ac\u00b3\7F\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7p\2\2"+
		"\u00af\u00b3\7f\2\2\u00b0\u00b1\7(\2\2\u00b1\u00b3\7(\2\2\u00b2\u00aa"+
		"\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3(\3\2\2\2\u00b4"+
		"\u00b5\7Q\2\2\u00b5\u00bb\7T\2\2\u00b6\u00b7\7q\2\2\u00b7\u00bb\7t\2\2"+
		"\u00b8\u00b9\7~\2\2\u00b9\u00bb\7~\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00b6"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb*\3\2\2\2\u00bc\u00bd\7P\2\2\u00bd\u00be"+
		"\7Q\2\2\u00be\u00c3\7V\2\2\u00bf\u00c0\7p\2\2\u00c0\u00c1\7q\2\2\u00c1"+
		"\u00c3\7v\2\2\u00c2\u00bc\3\2\2\2\u00c2\u00bf\3\2\2\2\u00c3,\3\2\2\2\u00c4"+
		"\u00c5\7,\2\2\u00c5.\3\2\2\2\u00c6\u00c7\7\61\2\2\u00c7\60\3\2\2\2\u00c8"+
		"\u00c9\7\'\2\2\u00c9\62\3\2\2\2\u00ca\u00cb\7-\2\2\u00cb\64\3\2\2\2\u00cc"+
		"\u00cd\7/\2\2\u00cd\66\3\2\2\2\u00ce\u00cf\7K\2\2\u00cf\u00d0\7p\2\2\u00d0"+
		"8\3\2\2\2\u00d1\u00d2\7K\2\2\u00d2\u00d3\7U\2\2\u00d3:\3\2\2\2\u00d4\u00d5"+
		"\7P\2\2\u00d5\u00d6\7W\2\2\u00d6\u00d7\7N\2\2\u00d7\u00d8\7N\2\2\u00d8"+
		"<\3\2\2\2\u00d9\u00da\7*\2\2\u00da>\3\2\2\2\u00db\u00dc\7+\2\2\u00dc@"+
		"\3\2\2\2\u00dd\u00de\7.\2\2\u00deB\3\2\2\2\u00df\u00e0\7D\2\2\u00e0\u00e1"+
		"\7G\2\2\u00e1\u00e2\7V\2\2\u00e2\u00e3\7Y\2\2\u00e3\u00e4\7G\2\2\u00e4"+
		"\u00e5\7G\2\2\u00e5\u00e6\7P\2\2\u00e6D\3\2\2\2\u00e7\u00e8\7N\2\2\u00e8"+
		"\u00e9\7K\2\2\u00e9\u00ea\7M\2\2\u00ea\u00eb\7G\2\2\u00ebF\3\2\2\2\u00ec"+
		"\u00ed\7E\2\2\u00ed\u00ee\7Q\2\2\u00ee\u00ef\7W\2\2\u00ef\u00f0\7P\2\2"+
		"\u00f0\u00f7\7V\2\2\u00f1\u00f2\7e\2\2\u00f2\u00f3\7q\2\2\u00f3\u00f4"+
		"\7w\2\2\u00f4\u00f5\7p\2\2\u00f5\u00f7\7v\2\2\u00f6\u00ec\3\2\2\2\u00f6"+
		"\u00f1\3\2\2\2\u00f7H\3\2\2\2\u00f8\u00f9\7U\2\2\u00f9\u00fa\7W\2\2\u00fa"+
		"\u00ff\7O\2\2\u00fb\u00fc\7u\2\2\u00fc\u00fd\7w\2\2\u00fd\u00ff\7o\2\2"+
		"\u00fe\u00f8\3\2\2\2\u00fe\u00fb\3\2\2\2\u00ffJ\3\2\2\2\u0100\u0101\7"+
		"C\2\2\u0101\u0102\7X\2\2\u0102\u0107\7I\2\2\u0103\u0104\7c\2\2\u0104\u0105"+
		"\7x\2\2\u0105\u0107\7i\2\2\u0106\u0100\3\2\2\2\u0106\u0103\3\2\2\2\u0107"+
		"L\3\2\2\2\u0108\u0109\7O\2\2\u0109\u010a\7C\2\2\u010a\u010f\7Z\2\2\u010b"+
		"\u010c\7o\2\2\u010c\u010d\7c\2\2\u010d\u010f\7z\2\2\u010e\u0108\3\2\2"+
		"\2\u010e\u010b\3\2\2\2\u010fN\3\2\2\2\u0110\u0111\7O\2\2\u0111\u0112\7"+
		"K\2\2\u0112\u0117\7P\2\2\u0113\u0114\7o\2\2\u0114\u0115\7k\2\2\u0115\u0117"+
		"\7p\2\2\u0116\u0110\3\2\2\2\u0116\u0113\3\2\2\2\u0117P\3\2\2\2\u0118\u0119"+
		"\7y\2\2\u0119\u011a\7k\2\2\u011a\u011b\7v\2\2\u011b\u011c\7j\2\2\u011c"+
		"\u011d\7k\2\2\u011d\u011e\7p\2\2\u011eR\3\2\2\2\u011f\u0120\7o\2\2\u0120"+
		"\u0121\7k\2\2\u0121\u0122\7n\2\2\u0122\u0123\7n\2\2\u0123\u0124\7k\2\2"+
		"\u0124\u0125\7u\2\2\u0125\u0126\7g\2\2\u0126\u0127\7e\2\2\u0127\u0128"+
		"\7q\2\2\u0128\u0129\7p\2\2\u0129\u012a\7f\2\2\u012a\u012b\7u\2\2\u012b"+
		"T\3\2\2\2\u012c\u012d\7u\2\2\u012d\u012e\7g\2\2\u012e\u012f\7e\2\2\u012f"+
		"\u0130\7q\2\2\u0130\u0131\7p\2\2\u0131\u0132\7f\2\2\u0132\u0133\7u\2\2"+
		"\u0133V\3\2\2\2\u0134\u0135\7o\2\2\u0135\u0136\7k\2\2\u0136\u0137\7p\2"+
		"\2\u0137\u0138\7w\2\2\u0138\u0139\7v\2\2\u0139\u013a\7g\2\2\u013a\u013b"+
		"\7u\2\2\u013bX\3\2\2\2\u013c\u013d\7j\2\2\u013d\u013e\7q\2\2\u013e\u013f"+
		"\7w\2\2\u013f\u0140\7t\2\2\u0140\u0141\7u\2\2\u0141Z\3\2\2\2\u0142\u0143"+
		"\7f\2\2\u0143\u0144\7c\2\2\u0144\u0145\7{\2\2\u0145\u0146\7u\2\2\u0146"+
		"\\\3\2\2\2\u0147\u0149\t\5\2\2\u0148\u014a\t\6\2\2\u0149\u0148\3\2\2\2"+
		"\u014a\u014b\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c^\3"+
		"\2\2\2\u014d\u014f\t\7\2\2\u014e\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\b\60"+
		"\2\2\u0153`\3\2\2\2\20\2ow\u008b\u00b2\u00ba\u00c2\u00f6\u00fe\u0106\u010e"+
		"\u0116\u014b\u0150\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}