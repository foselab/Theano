// Generated from matlab.g4 by ANTLR 4.5

package generated;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class matlabLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		DEFVARIABLES=25, ENDVARIABLES=26, ISSTARTUP=27, ARRAYMUL=28, ARRAYDIV=29, 
		ARRAYRDIV=30, ARRAYPOW=31, PREV=32, DUR=33, LE_OP=34, GE_OP=35, EQ_OP=36, 
		NE_OP=37, CONSTANT=38, CR=39, IDENTIFIER=40, COMMA=41, SEMICOLUMN=42, 
		WS=43;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "DEFVARIABLES", 
		"ENDVARIABLES", "ISSTARTUP", "ARRAYMUL", "ARRAYDIV", "ARRAYRDIV", "ARRAYPOW", 
		"PREV", "DUR", "LE_OP", "GE_OP", "EQ_OP", "NE_OP", "CONSTANT", "NUMBER", 
		"E", "SIGN", "CR", "IDENTIFIER", "COMMA", "SEMICOLUMN", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'vardef'", "'endvardef'", "'reqdef'", "'endreqdef'", "'('", "')'", 
		"'>'", "'<'", "'='", "':'", "'+'", "'-'", "'~'", "'*'", "'/'", "'\\'", 
		"'^'", "'!'", "'&'", "'|'", "'Int'", "'Real'", "'input'", "'output'", 
		"'defVariables'", "'endVariables'", "'isStartup'", "'.*'", "'.\\'", "'./'", 
		"'.^'", "'prev'", "'dur'", "'<='", "'>='", "'=='", "'~='", null, null, 
		null, "','", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "DEFVARIABLES", "ENDVARIABLES", "ISSTARTUP", "ARRAYMUL", "ARRAYDIV", 
		"ARRAYRDIV", "ARRAYPOW", "PREV", "DUR", "LE_OP", "GE_OP", "EQ_OP", "NE_OP", 
		"CONSTANT", "CR", "IDENTIFIER", "COMMA", "SEMICOLUMN", "WS"
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


	public matlabLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "matlab.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2-\u012d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3"+
		"%\3%\3%\3&\3&\3&\3\'\3\'\3\'\5\'\u0100\n\'\3\'\3\'\5\'\u0104\n\'\3(\6"+
		"(\u0107\n(\r(\16(\u0108\3(\3(\6(\u010d\n(\r(\16(\u010e\5(\u0111\n(\3)"+
		"\3)\3*\3*\3+\6+\u0118\n+\r+\16+\u0119\3,\3,\7,\u011e\n,\f,\16,\u0121\13"+
		",\3-\3-\3.\3.\3/\6/\u0128\n/\r/\16/\u0129\3/\3/\2\2\60\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O\2Q\2S\2U)W*Y+[,]-\3\2\b\4\2GGgg\4\2--//\4\2\f\f\17\17\4\2C\\c|\6"+
		"\2\62;C\\aac|\4\2\13\13\"\"\u0131\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5f\3"+
		"\2\2\2\7p\3\2\2\2\tw\3\2\2\2\13\u0081\3\2\2\2\r\u0083\3\2\2\2\17\u0085"+
		"\3\2\2\2\21\u0087\3\2\2\2\23\u0089\3\2\2\2\25\u008b\3\2\2\2\27\u008d\3"+
		"\2\2\2\31\u008f\3\2\2\2\33\u0091\3\2\2\2\35\u0093\3\2\2\2\37\u0095\3\2"+
		"\2\2!\u0097\3\2\2\2#\u0099\3\2\2\2%\u009b\3\2\2\2\'\u009d\3\2\2\2)\u009f"+
		"\3\2\2\2+\u00a1\3\2\2\2-\u00a5\3\2\2\2/\u00aa\3\2\2\2\61\u00b0\3\2\2\2"+
		"\63\u00b7\3\2\2\2\65\u00c4\3\2\2\2\67\u00d1\3\2\2\29\u00db\3\2\2\2;\u00de"+
		"\3\2\2\2=\u00e1\3\2\2\2?\u00e4\3\2\2\2A\u00e7\3\2\2\2C\u00ec\3\2\2\2E"+
		"\u00f0\3\2\2\2G\u00f3\3\2\2\2I\u00f6\3\2\2\2K\u00f9\3\2\2\2M\u00fc\3\2"+
		"\2\2O\u0106\3\2\2\2Q\u0112\3\2\2\2S\u0114\3\2\2\2U\u0117\3\2\2\2W\u011b"+
		"\3\2\2\2Y\u0122\3\2\2\2[\u0124\3\2\2\2]\u0127\3\2\2\2_`\7x\2\2`a\7c\2"+
		"\2ab\7t\2\2bc\7f\2\2cd\7g\2\2de\7h\2\2e\4\3\2\2\2fg\7g\2\2gh\7p\2\2hi"+
		"\7f\2\2ij\7x\2\2jk\7c\2\2kl\7t\2\2lm\7f\2\2mn\7g\2\2no\7h\2\2o\6\3\2\2"+
		"\2pq\7t\2\2qr\7g\2\2rs\7s\2\2st\7f\2\2tu\7g\2\2uv\7h\2\2v\b\3\2\2\2wx"+
		"\7g\2\2xy\7p\2\2yz\7f\2\2z{\7t\2\2{|\7g\2\2|}\7s\2\2}~\7f\2\2~\177\7g"+
		"\2\2\177\u0080\7h\2\2\u0080\n\3\2\2\2\u0081\u0082\7*\2\2\u0082\f\3\2\2"+
		"\2\u0083\u0084\7+\2\2\u0084\16\3\2\2\2\u0085\u0086\7@\2\2\u0086\20\3\2"+
		"\2\2\u0087\u0088\7>\2\2\u0088\22\3\2\2\2\u0089\u008a\7?\2\2\u008a\24\3"+
		"\2\2\2\u008b\u008c\7<\2\2\u008c\26\3\2\2\2\u008d\u008e\7-\2\2\u008e\30"+
		"\3\2\2\2\u008f\u0090\7/\2\2\u0090\32\3\2\2\2\u0091\u0092\7\u0080\2\2\u0092"+
		"\34\3\2\2\2\u0093\u0094\7,\2\2\u0094\36\3\2\2\2\u0095\u0096\7\61\2\2\u0096"+
		" \3\2\2\2\u0097\u0098\7^\2\2\u0098\"\3\2\2\2\u0099\u009a\7`\2\2\u009a"+
		"$\3\2\2\2\u009b\u009c\7#\2\2\u009c&\3\2\2\2\u009d\u009e\7(\2\2\u009e("+
		"\3\2\2\2\u009f\u00a0\7~\2\2\u00a0*\3\2\2\2\u00a1\u00a2\7K\2\2\u00a2\u00a3"+
		"\7p\2\2\u00a3\u00a4\7v\2\2\u00a4,\3\2\2\2\u00a5\u00a6\7T\2\2\u00a6\u00a7"+
		"\7g\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7n\2\2\u00a9.\3\2\2\2\u00aa\u00ab"+
		"\7k\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7r\2\2\u00ad\u00ae\7w\2\2\u00ae"+
		"\u00af\7v\2\2\u00af\60\3\2\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7w\2\2\u00b2"+
		"\u00b3\7v\2\2\u00b3\u00b4\7r\2\2\u00b4\u00b5\7w\2\2\u00b5\u00b6\7v\2\2"+
		"\u00b6\62\3\2\2\2\u00b7\u00b8\7f\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7"+
		"h\2\2\u00ba\u00bb\7X\2\2\u00bb\u00bc\7c\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be"+
		"\7k\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7d\2\2\u00c0\u00c1\7n\2\2\u00c1"+
		"\u00c2\7g\2\2\u00c2\u00c3\7u\2\2\u00c3\64\3\2\2\2\u00c4\u00c5\7g\2\2\u00c5"+
		"\u00c6\7p\2\2\u00c6\u00c7\7f\2\2\u00c7\u00c8\7X\2\2\u00c8\u00c9\7c\2\2"+
		"\u00c9\u00ca\7t\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7c\2\2\u00cc\u00cd"+
		"\7d\2\2\u00cd\u00ce\7n\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7u\2\2\u00d0"+
		"\66\3\2\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7u\2\2\u00d3\u00d4\7U\2\2\u00d4"+
		"\u00d5\7v\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7t\2\2\u00d7\u00d8\7v\2\2"+
		"\u00d8\u00d9\7w\2\2\u00d9\u00da\7r\2\2\u00da8\3\2\2\2\u00db\u00dc\7\60"+
		"\2\2\u00dc\u00dd\7,\2\2\u00dd:\3\2\2\2\u00de\u00df\7\60\2\2\u00df\u00e0"+
		"\7^\2\2\u00e0<\3\2\2\2\u00e1\u00e2\7\60\2\2\u00e2\u00e3\7\61\2\2\u00e3"+
		">\3\2\2\2\u00e4\u00e5\7\60\2\2\u00e5\u00e6\7`\2\2\u00e6@\3\2\2\2\u00e7"+
		"\u00e8\7r\2\2\u00e8\u00e9\7t\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7x\2\2"+
		"\u00ebB\3\2\2\2\u00ec\u00ed\7f\2\2\u00ed\u00ee\7w\2\2\u00ee\u00ef\7t\2"+
		"\2\u00efD\3\2\2\2\u00f0\u00f1\7>\2\2\u00f1\u00f2\7?\2\2\u00f2F\3\2\2\2"+
		"\u00f3\u00f4\7@\2\2\u00f4\u00f5\7?\2\2\u00f5H\3\2\2\2\u00f6\u00f7\7?\2"+
		"\2\u00f7\u00f8\7?\2\2\u00f8J\3\2\2\2\u00f9\u00fa\7\u0080\2\2\u00fa\u00fb"+
		"\7?\2\2\u00fbL\3\2\2\2\u00fc\u0103\5O(\2\u00fd\u00ff\5Q)\2\u00fe\u0100"+
		"\5S*\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0102\5O(\2\u0102\u0104\3\2\2\2\u0103\u00fd\3\2\2\2\u0103\u0104\3\2\2"+
		"\2\u0104N\3\2\2\2\u0105\u0107\4\62;\2\u0106\u0105\3\2\2\2\u0107\u0108"+
		"\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0110\3\2\2\2\u010a"+
		"\u010c\7\60\2\2\u010b\u010d\4\62;\2\u010c\u010b\3\2\2\2\u010d\u010e\3"+
		"\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110"+
		"\u010a\3\2\2\2\u0110\u0111\3\2\2\2\u0111P\3\2\2\2\u0112\u0113\t\2\2\2"+
		"\u0113R\3\2\2\2\u0114\u0115\t\3\2\2\u0115T\3\2\2\2\u0116\u0118\t\4\2\2"+
		"\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a"+
		"\3\2\2\2\u011aV\3\2\2\2\u011b\u011f\t\5\2\2\u011c\u011e\t\6\2\2\u011d"+
		"\u011c\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120X\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0123\7.\2\2\u0123Z\3\2"+
		"\2\2\u0124\u0125\7=\2\2\u0125\\\3\2\2\2\u0126\u0128\t\7\2\2\u0127\u0126"+
		"\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b\u012c\b/\2\2\u012c^\3\2\2\2\13\2\u00ff\u0103\u0108"+
		"\u010e\u0110\u0119\u011f\u0129\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}