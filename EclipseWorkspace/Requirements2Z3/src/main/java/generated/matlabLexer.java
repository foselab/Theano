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
		ARRAYMUL=18, ARRAYDIV=19, ARRAYRDIV=20, ARRAYPOW=21, PREV=22, LE_OP=23, 
		GE_OP=24, EQ_OP=25, NE_OP=26, IDENTIFIER=27, CONSTANT=28, CR=29, WS=30;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"ARRAYMUL", "ARRAYDIV", "ARRAYRDIV", "ARRAYPOW", "PREV", "LE_OP", "GE_OP", 
		"EQ_OP", "NE_OP", "IDENTIFIER", "CONSTANT", "NUMBER", "E", "SIGN", "CR", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "':'", "','", "'+'", "'-'", "'~'", "'*'", "'/'", "'\\'", 
		"'^'", "'<'", "'>'", "'&'", "'|'", "'='", "';'", "'.*'", "'.\\'", "'./'", 
		"'.^'", "'prev'", "'<='", "'>='", "'=='", "'~='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "ARRAYMUL", "ARRAYDIV", "ARRAYRDIV", 
		"ARRAYPOW", "PREV", "LE_OP", "GE_OP", "EQ_OP", "NE_OP", "IDENTIFIER", 
		"CONSTANT", "CR", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u00b1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\34\3\34\7\34\u0087\n\34\f\34\16\34\u008a\13"+
		"\34\3\35\3\35\3\35\5\35\u008f\n\35\3\35\3\35\5\35\u0093\n\35\3\36\6\36"+
		"\u0096\n\36\r\36\16\36\u0097\3\36\3\36\6\36\u009c\n\36\r\36\16\36\u009d"+
		"\5\36\u00a0\n\36\3\37\3\37\3 \3 \3!\6!\u00a7\n!\r!\16!\u00a8\3\"\6\"\u00ac"+
		"\n\"\r\"\16\"\u00ad\3\"\3\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\2=\2?\2A\37C \3\2\b\4\2C\\c|\6\2\62;C\\"+
		"aac|\4\2GGgg\4\2--//\4\2\f\f\17\17\4\2\13\13\"\"\u00b5\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\3E\3\2\2\2\5G\3\2\2\2\7I\3\2\2\2\tK\3\2\2\2\13M\3\2\2\2\rO\3\2\2\2\17"+
		"Q\3\2\2\2\21S\3\2\2\2\23U\3\2\2\2\25W\3\2\2\2\27Y\3\2\2\2\31[\3\2\2\2"+
		"\33]\3\2\2\2\35_\3\2\2\2\37a\3\2\2\2!c\3\2\2\2#e\3\2\2\2%g\3\2\2\2\'j"+
		"\3\2\2\2)m\3\2\2\2+p\3\2\2\2-s\3\2\2\2/x\3\2\2\2\61{\3\2\2\2\63~\3\2\2"+
		"\2\65\u0081\3\2\2\2\67\u0084\3\2\2\29\u008b\3\2\2\2;\u0095\3\2\2\2=\u00a1"+
		"\3\2\2\2?\u00a3\3\2\2\2A\u00a6\3\2\2\2C\u00ab\3\2\2\2EF\7*\2\2F\4\3\2"+
		"\2\2GH\7+\2\2H\6\3\2\2\2IJ\7<\2\2J\b\3\2\2\2KL\7.\2\2L\n\3\2\2\2MN\7-"+
		"\2\2N\f\3\2\2\2OP\7/\2\2P\16\3\2\2\2QR\7\u0080\2\2R\20\3\2\2\2ST\7,\2"+
		"\2T\22\3\2\2\2UV\7\61\2\2V\24\3\2\2\2WX\7^\2\2X\26\3\2\2\2YZ\7`\2\2Z\30"+
		"\3\2\2\2[\\\7>\2\2\\\32\3\2\2\2]^\7@\2\2^\34\3\2\2\2_`\7(\2\2`\36\3\2"+
		"\2\2ab\7~\2\2b \3\2\2\2cd\7?\2\2d\"\3\2\2\2ef\7=\2\2f$\3\2\2\2gh\7\60"+
		"\2\2hi\7,\2\2i&\3\2\2\2jk\7\60\2\2kl\7^\2\2l(\3\2\2\2mn\7\60\2\2no\7\61"+
		"\2\2o*\3\2\2\2pq\7\60\2\2qr\7`\2\2r,\3\2\2\2st\7r\2\2tu\7t\2\2uv\7g\2"+
		"\2vw\7x\2\2w.\3\2\2\2xy\7>\2\2yz\7?\2\2z\60\3\2\2\2{|\7@\2\2|}\7?\2\2"+
		"}\62\3\2\2\2~\177\7?\2\2\177\u0080\7?\2\2\u0080\64\3\2\2\2\u0081\u0082"+
		"\7\u0080\2\2\u0082\u0083\7?\2\2\u0083\66\3\2\2\2\u0084\u0088\t\2\2\2\u0085"+
		"\u0087\t\3\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0088\u0089\3\2\2\2\u00898\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u0092"+
		"\5;\36\2\u008c\u008e\5=\37\2\u008d\u008f\5? \2\u008e\u008d\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\5;\36\2\u0091\u0093\3\2"+
		"\2\2\u0092\u008c\3\2\2\2\u0092\u0093\3\2\2\2\u0093:\3\2\2\2\u0094\u0096"+
		"\4\62;\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u009f\3\2\2\2\u0099\u009b\7\60\2\2\u009a\u009c\4"+
		"\62;\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u0099\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0<\3\2\2\2\u00a1\u00a2\t\4\2\2\u00a2>\3\2\2\2\u00a3\u00a4\t\5"+
		"\2\2\u00a4@\3\2\2\2\u00a5\u00a7\t\6\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9B\3\2\2\2\u00aa"+
		"\u00ac\t\7\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\b\"\2\2\u00b0"+
		"D\3\2\2\2\13\2\u0088\u008e\u0092\u0097\u009d\u009f\u00a8\u00ad\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}