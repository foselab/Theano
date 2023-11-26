// Generated from matlab.g4 by ANTLR 4.4

package generated;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class matlabParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		DEFVARIABLES=25, ENDVARIABLES=26, ISSTARTUP=27, ARRAYMUL=28, ARRAYDIV=29, 
		ARRAYRDIV=30, ARRAYPOW=31, PREV=32, DUR=33, LE_OP=34, GE_OP=35, EQ_OP=36, 
		NE_OP=37, CONSTANT=38, CR=39, IDENTIFIER=40, COMMA=41, SEMICOLUMN=42, 
		WS=43;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'endreqdef'", "'\\'", "'='", "'^'", "'&'", "'('", 
		"'*'", "'output'", "'Real'", "'endvardef'", "'Int'", "':'", "'|'", "'<'", 
		"'~'", "'>'", "'!'", "'reqdef'", "'vardef'", "'input'", "')'", "'+'", 
		"'-'", "'defVariables'", "'endVariables'", "'isStartup'", "'.*'", "'.\\'", 
		"'./'", "'.^'", "'prev'", "'dur'", "'<='", "'>='", "'=='", "'~='", "CONSTANT", 
		"CR", "IDENTIFIER", "','", "';'", "WS"
	};
	public static final int
		RULE_primaryExpression = 0, RULE_variablesdefinitions = 1, RULE_requirementsdefinitions = 2, 
		RULE_requirement = 3, RULE_precondition = 4, RULE_postcondition = 5, RULE_primary_expression = 6, 
		RULE_prev_expression = 7, RULE_dur_expression = 8, RULE_postfix_expression = 9, 
		RULE_index_expression = 10, RULE_unary_expression = 11, RULE_unary_operator = 12, 
		RULE_multiplicative_expression = 13, RULE_additive_expression = 14, RULE_relational_expression = 15, 
		RULE_equality_expression = 16, RULE_is_startup = 17, RULE_is_not_startup = 18, 
		RULE_and_expression = 19, RULE_or_expression = 20, RULE_expression = 21, 
		RULE_assignment_expression = 22, RULE_statement = 23, RULE_statement_list = 24, 
		RULE_variabledefinition = 25, RULE_variableName = 26, RULE_typeSpecifier = 27, 
		RULE_io = 28;
	public static final String[] ruleNames = {
		"primaryExpression", "variablesdefinitions", "requirementsdefinitions", 
		"requirement", "precondition", "postcondition", "primary_expression", 
		"prev_expression", "dur_expression", "postfix_expression", "index_expression", 
		"unary_expression", "unary_operator", "multiplicative_expression", "additive_expression", 
		"relational_expression", "equality_expression", "is_startup", "is_not_startup", 
		"and_expression", "or_expression", "expression", "assignment_expression", 
		"statement", "statement_list", "variabledefinition", "variableName", "typeSpecifier", 
		"io"
	};

	@Override
	public String getGrammarFileName() { return "matlab.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public matlabParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public VariablesdefinitionsContext variablesdefinitions() {
			return getRuleContext(VariablesdefinitionsContext.class,0);
		}
		public RequirementsdefinitionsContext requirementsdefinitions() {
			return getRuleContext(RequirementsdefinitionsContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitPrimaryExpression(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_primaryExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); variablesdefinitions();
			setState(59); requirementsdefinitions();
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

	public static class VariablesdefinitionsContext extends ParserRuleContext {
		public VariabledefinitionContext variabledefinition(int i) {
			return getRuleContext(VariabledefinitionContext.class,i);
		}
		public List<TerminalNode> CR() { return getTokens(matlabParser.CR); }
		public List<VariabledefinitionContext> variabledefinition() {
			return getRuleContexts(VariabledefinitionContext.class);
		}
		public TerminalNode CR(int i) {
			return getToken(matlabParser.CR, i);
		}
		public VariablesdefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablesdefinitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterVariablesdefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitVariablesdefinitions(this);
		}
	}

	public final VariablesdefinitionsContext variablesdefinitions() throws RecognitionException {
		VariablesdefinitionsContext _localctx = new VariablesdefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variablesdefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); match(T__4);
			setState(62); match(CR);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(63); variabledefinition();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69); match(T__13);
			setState(70); match(CR);
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

	public static class RequirementsdefinitionsContext extends ParserRuleContext {
		public List<RequirementContext> requirement() {
			return getRuleContexts(RequirementContext.class);
		}
		public List<TerminalNode> CR() { return getTokens(matlabParser.CR); }
		public TerminalNode CR(int i) {
			return getToken(matlabParser.CR, i);
		}
		public RequirementContext requirement(int i) {
			return getRuleContext(RequirementContext.class,i);
		}
		public RequirementsdefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirementsdefinitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterRequirementsdefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitRequirementsdefinitions(this);
		}
	}

	public final RequirementsdefinitionsContext requirementsdefinitions() throws RecognitionException {
		RequirementsdefinitionsContext _localctx = new RequirementsdefinitionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_requirementsdefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); match(T__5);
			setState(73); match(CR);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__8) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << ISSTARTUP) | (1L << PREV) | (1L << DUR) | (1L << CONSTANT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(74); requirement();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80); match(T__22);
			setState(81); match(CR);
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

	public static class RequirementContext extends ParserRuleContext {
		public TerminalNode SEMICOLUMN() { return getToken(matlabParser.SEMICOLUMN, 0); }
		public PreconditionContext precondition() {
			return getRuleContext(PreconditionContext.class,0);
		}
		public TerminalNode CR() { return getToken(matlabParser.CR, 0); }
		public PostconditionContext postcondition() {
			return getRuleContext(PostconditionContext.class,0);
		}
		public RequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitRequirement(this);
		}
	}

	public final RequirementContext requirement() throws RecognitionException {
		RequirementContext _localctx = new RequirementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_requirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); precondition();
			setState(84); match(COMMA);
			setState(85); postcondition();
			setState(86); match(SEMICOLUMN);
			setState(87); match(CR);
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

	public static class PreconditionContext extends ParserRuleContext {
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public PreconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterPrecondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitPrecondition(this);
		}
	}

	public final PreconditionContext precondition() throws RecognitionException {
		PreconditionContext _localctx = new PreconditionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_precondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); statement_list();
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

	public static class PostconditionContext extends ParserRuleContext {
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public PostconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postcondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterPostcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitPostcondition(this);
		}
	}

	public final PostconditionContext postcondition() throws RecognitionException {
		PostconditionContext _localctx = new PostconditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_postcondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); statement_list();
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

	public static class Primary_expressionContext extends ParserRuleContext {
		public Dur_expressionContext dur_expression() {
			return getRuleContext(Dur_expressionContext.class,0);
		}
		public Prev_expressionContext prev_expression() {
			return getRuleContext(Prev_expressionContext.class,0);
		}
		public TerminalNode CONSTANT() { return getToken(matlabParser.CONSTANT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(matlabParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitPrimary_expression(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_primary_expression);
		try {
			setState(101);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(93); match(IDENTIFIER);
				}
				break;
			case CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); match(CONSTANT);
				}
				break;
			case PREV:
				enterOuterAlt(_localctx, 3);
				{
				setState(95); prev_expression();
				}
				break;
			case DUR:
				enterOuterAlt(_localctx, 4);
				{
				setState(96); dur_expression();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 5);
				{
				setState(97); match(T__17);
				setState(98); expression(0);
				setState(99); match(T__2);
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

	public static class Prev_expressionContext extends ParserRuleContext {
		public TerminalNode PREV() { return getToken(matlabParser.PREV, 0); }
		public TerminalNode IDENTIFIER() { return getToken(matlabParser.IDENTIFIER, 0); }
		public Prev_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prev_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterPrev_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitPrev_expression(this);
		}
	}

	public final Prev_expressionContext prev_expression() throws RecognitionException {
		Prev_expressionContext _localctx = new Prev_expressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_prev_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103); match(PREV);
			setState(104); match(T__17);
			setState(105); match(IDENTIFIER);
			setState(106); match(T__2);
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

	public static class Dur_expressionContext extends ParserRuleContext {
		public TerminalNode GE_OP() { return getToken(matlabParser.GE_OP, 0); }
		public TerminalNode CONSTANT() { return getToken(matlabParser.CONSTANT, 0); }
		public TerminalNode LE_OP() { return getToken(matlabParser.LE_OP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DUR() { return getToken(matlabParser.DUR, 0); }
		public Dur_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dur_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterDur_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitDur_expression(this);
		}
	}

	public final Dur_expressionContext dur_expression() throws RecognitionException {
		Dur_expressionContext _localctx = new Dur_expressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dur_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(DUR);
			setState(109); match(T__17);
			setState(110); expression(0);
			setState(111); match(T__2);
			setState(112);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__9) | (1L << T__7) | (1L << LE_OP) | (1L << GE_OP))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(113); match(CONSTANT);
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

	public static class Postfix_expressionContext extends ParserRuleContext {
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterPostfix_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitPostfix_expression(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_postfix_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); primary_expression();
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

	public static class Index_expressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Index_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterIndex_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitIndex_expression(this);
		}
	}

	public final Index_expressionContext index_expression() throws RecognitionException {
		Index_expressionContext _localctx = new Index_expressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_index_expression);
		try {
			setState(119);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(117); match(T__11);
				}
				break;
			case T__17:
			case T__8:
			case T__6:
			case T__1:
			case T__0:
			case ISSTARTUP:
			case PREV:
			case DUR:
			case CONSTANT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(118); expression(0);
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

	public static class Unary_expressionContext extends ParserRuleContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitUnary_expression(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_unary_expression);
		try {
			setState(125);
			switch (_input.LA(1)) {
			case T__17:
			case PREV:
			case DUR:
			case CONSTANT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(121); postfix_expression();
				}
				break;
			case T__8:
			case T__1:
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(122); unary_operator();
				setState(123); postfix_expression();
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

	public static class Unary_operatorContext extends ParserRuleContext {
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__1) | (1L << T__0))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Multiplicative_expressionContext extends ParserRuleContext {
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode ARRAYDIV() { return getToken(matlabParser.ARRAYDIV, 0); }
		public TerminalNode ARRAYRDIV() { return getToken(matlabParser.ARRAYRDIV, 0); }
		public TerminalNode ARRAYPOW() { return getToken(matlabParser.ARRAYPOW, 0); }
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public TerminalNode ARRAYMUL() { return getToken(matlabParser.ARRAYMUL, 0); }
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitMultiplicative_expression(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		return multiplicative_expression(0);
	}

	private Multiplicative_expressionContext multiplicative_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, _parentState);
		Multiplicative_expressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_multiplicative_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(130); unary_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(156);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
						setState(132);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(133); match(T__16);
						setState(134); unary_expression();
						}
						break;
					case 2:
						{
						_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
						setState(135);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(136); match(T__23);
						setState(137); unary_expression();
						}
						break;
					case 3:
						{
						_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
						setState(138);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(139); match(T__21);
						setState(140); unary_expression();
						}
						break;
					case 4:
						{
						_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
						setState(141);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(142); match(T__19);
						setState(143); unary_expression();
						}
						break;
					case 5:
						{
						_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
						setState(144);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(145); match(ARRAYMUL);
						setState(146); unary_expression();
						}
						break;
					case 6:
						{
						_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
						setState(147);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(148); match(ARRAYDIV);
						setState(149); unary_expression();
						}
						break;
					case 7:
						{
						_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
						setState(150);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(151); match(ARRAYRDIV);
						setState(152); unary_expression();
						}
						break;
					case 8:
						{
						_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
						setState(153);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(154); match(ARRAYPOW);
						setState(155); unary_expression();
						}
						break;
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class Additive_expressionContext extends ParserRuleContext {
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public Additive_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitAdditive_expression(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		return additive_expression(0);
	}

	private Additive_expressionContext additive_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, _parentState);
		Additive_expressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_additive_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(162); multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(170);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new Additive_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additive_expression);
						setState(164);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(165); match(T__1);
						setState(166); multiplicative_expression(0);
						}
						break;
					case 2:
						{
						_localctx = new Additive_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additive_expression);
						setState(167);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(168); match(T__0);
						setState(169); multiplicative_expression(0);
						}
						break;
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class Relational_expressionContext extends ParserRuleContext {
		public Relational_expressionContext relational_expression() {
			return getRuleContext(Relational_expressionContext.class,0);
		}
		public TerminalNode GE_OP() { return getToken(matlabParser.GE_OP, 0); }
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public TerminalNode LE_OP() { return getToken(matlabParser.LE_OP, 0); }
		public Relational_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterRelational_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitRelational_expression(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		return relational_expression(0);
	}

	private Relational_expressionContext relational_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, _parentState);
		Relational_expressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_relational_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(176); additive_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(190);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new Relational_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational_expression);
						setState(178);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(179); match(T__9);
						setState(180); additive_expression(0);
						}
						break;
					case 2:
						{
						_localctx = new Relational_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational_expression);
						setState(181);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(182); match(T__7);
						setState(183); additive_expression(0);
						}
						break;
					case 3:
						{
						_localctx = new Relational_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational_expression);
						setState(184);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(185); match(LE_OP);
						setState(186); additive_expression(0);
						}
						break;
					case 4:
						{
						_localctx = new Relational_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational_expression);
						setState(187);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(188); match(GE_OP);
						setState(189); additive_expression(0);
						}
						break;
					}
					} 
				}
				setState(194);
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

	public static class Equality_expressionContext extends ParserRuleContext {
		public Relational_expressionContext relational_expression() {
			return getRuleContext(Relational_expressionContext.class,0);
		}
		public Is_not_startupContext is_not_startup() {
			return getRuleContext(Is_not_startupContext.class,0);
		}
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public TerminalNode NE_OP() { return getToken(matlabParser.NE_OP, 0); }
		public TerminalNode EQ_OP() { return getToken(matlabParser.EQ_OP, 0); }
		public Is_startupContext is_startup() {
			return getRuleContext(Is_startupContext.class,0);
		}
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterEquality_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitEquality_expression(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		return equality_expression(0);
	}

	private Equality_expressionContext equality_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, _parentState);
		Equality_expressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_equality_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			switch (_input.LA(1)) {
			case ISSTARTUP:
				{
				setState(196); is_startup();
				}
				break;
			case T__6:
				{
				setState(197); is_not_startup();
				}
				break;
			case T__17:
			case T__8:
			case T__1:
			case T__0:
			case PREV:
			case DUR:
			case CONSTANT:
			case IDENTIFIER:
				{
				setState(198); relational_expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(207);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new Equality_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equality_expression);
						setState(201);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(202); match(EQ_OP);
						setState(203); relational_expression(0);
						}
						break;
					case 2:
						{
						_localctx = new Equality_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equality_expression);
						setState(204);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(205); match(NE_OP);
						setState(206); relational_expression(0);
						}
						break;
					}
					} 
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class Is_startupContext extends ParserRuleContext {
		public TerminalNode ISSTARTUP() { return getToken(matlabParser.ISSTARTUP, 0); }
		public Is_startupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_startup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterIs_startup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitIs_startup(this);
		}
	}

	public final Is_startupContext is_startup() throws RecognitionException {
		Is_startupContext _localctx = new Is_startupContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_is_startup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); match(ISSTARTUP);
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

	public static class Is_not_startupContext extends ParserRuleContext {
		public TerminalNode ISSTARTUP() { return getToken(matlabParser.ISSTARTUP, 0); }
		public Is_not_startupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_not_startup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterIs_not_startup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitIs_not_startup(this);
		}
	}

	public final Is_not_startupContext is_not_startup() throws RecognitionException {
		Is_not_startupContext _localctx = new Is_not_startupContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_is_not_startup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214); match(T__6);
			setState(215); match(ISSTARTUP);
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

	public static class And_expressionContext extends ParserRuleContext {
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public And_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitAnd_expression(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		return and_expression(0);
	}

	private And_expressionContext and_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		And_expressionContext _localctx = new And_expressionContext(_ctx, _parentState);
		And_expressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_and_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(218); equality_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_and_expression);
					setState(220);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(221); match(T__18);
					setState(222); equality_expression(0);
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class Or_expressionContext extends ParserRuleContext {
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public Or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterOr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitOr_expression(this);
		}
	}

	public final Or_expressionContext or_expression() throws RecognitionException {
		return or_expression(0);
	}

	private Or_expressionContext or_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, _parentState);
		Or_expressionContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_or_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(229); and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Or_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_or_expression);
					setState(231);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(232); match(T__10);
					setState(233); and_expression(0);
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitExpression(this);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(240); or_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(247);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(242);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(243); match(T__11);
					setState(244); or_expression(0);
					}
					} 
				}
				setState(249);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Assignment_expressionContext extends ParserRuleContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Assignment_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterAssignment_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitAssignment_expression(this);
		}
	}

	public final Assignment_expressionContext assignment_expression() throws RecognitionException {
		Assignment_expressionContext _localctx = new Assignment_expressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assignment_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250); postfix_expression();
			setState(251); match(T__20);
			setState(252); expression(0);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); expression(0);
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

	public static class Statement_listContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Statement_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterStatement_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitStatement_list(this);
		}
	}

	public final Statement_listContext statement_list() throws RecognitionException {
		Statement_listContext _localctx = new Statement_listContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_statement_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256); statement();
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

	public static class VariabledefinitionContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode SEMICOLUMN() { return getToken(matlabParser.SEMICOLUMN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(matlabParser.COMMA); }
		public IoContext io() {
			return getRuleContext(IoContext.class,0);
		}
		public TerminalNode CR() { return getToken(matlabParser.CR, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(matlabParser.COMMA, i);
		}
		public VariabledefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variabledefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterVariabledefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitVariabledefinition(this);
		}
	}

	public final VariabledefinitionContext variabledefinition() throws RecognitionException {
		VariabledefinitionContext _localctx = new VariabledefinitionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_variabledefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); variableName();
			setState(259); match(COMMA);
			setState(260); typeSpecifier();
			setState(261); match(COMMA);
			setState(262); io();
			setState(263); match(SEMICOLUMN);
			setState(264); match(CR);
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

	public static class VariableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(matlabParser.IDENTIFIER, 0); }
		public VariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitVariableName(this);
		}
	}

	public final VariableNameContext variableName() throws RecognitionException {
		VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_variableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); match(IDENTIFIER);
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

	public static class TypeSpecifierContext extends ParserRuleContext {
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitTypeSpecifier(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_typeSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__12) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class IoContext extends ParserRuleContext {
		public IoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_io; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).enterIo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof matlabListener ) ((matlabListener)listener).exitIo(this);
		}
	}

	public final IoContext io() throws RecognitionException {
		IoContext _localctx = new IoContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_io);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_la = _input.LA(1);
			if ( !(_la==T__15 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		case 13: return multiplicative_expression_sempred((Multiplicative_expressionContext)_localctx, predIndex);
		case 14: return additive_expression_sempred((Additive_expressionContext)_localctx, predIndex);
		case 15: return relational_expression_sempred((Relational_expressionContext)_localctx, predIndex);
		case 16: return equality_expression_sempred((Equality_expressionContext)_localctx, predIndex);
		case 19: return and_expression_sempred((And_expressionContext)_localctx, predIndex);
		case 20: return or_expression_sempred((Or_expressionContext)_localctx, predIndex);
		case 21: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean equality_expression_sempred(Equality_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14: return precpred(_ctx, 2);
		case 15: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean or_expression_sempred(Or_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean and_expression_sempred(And_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additive_expression_sempred(Additive_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8: return precpred(_ctx, 2);
		case 9: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relational_expression_sempred(Relational_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10: return precpred(_ctx, 4);
		case 11: return precpred(_ctx, 3);
		case 12: return precpred(_ctx, 2);
		case 13: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicative_expression_sempred(Multiplicative_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 8);
		case 1: return precpred(_ctx, 7);
		case 2: return precpred(_ctx, 6);
		case 3: return precpred(_ctx, 5);
		case 4: return precpred(_ctx, 4);
		case 5: return precpred(_ctx, 3);
		case 6: return precpred(_ctx, 2);
		case 7: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u0113\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\7\3C\n\3\f\3\16\3F\13\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4N\n\4\f\4\16\4"+
		"Q\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\bh\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\5\fz\n\f\3\r\3\r\3\r\3\r\5\r\u0080\n\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u009f\n\17\f\17\16\17\u00a2\13\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u00ad\n\20\f\20\16\20\u00b0\13\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00c1"+
		"\n\21\f\21\16\21\u00c4\13\21\3\22\3\22\3\22\3\22\5\22\u00ca\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\7\22\u00d2\n\22\f\22\16\22\u00d5\13\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00e2\n\25\f\25"+
		"\16\25\u00e5\13\25\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u00ed\n\26\f\26"+
		"\16\26\u00f0\13\26\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00f8\n\27\f\27"+
		"\16\27\u00fb\13\27\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\2\t\34"+
		"\36 \"(*,\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:\2\6\6\2\6\6\21\21\23\23$%\4\2\22\22\31\32\4\2\f\f\16\16\4\2\13\13"+
		"\27\27\u0112\2<\3\2\2\2\4?\3\2\2\2\6J\3\2\2\2\bU\3\2\2\2\n[\3\2\2\2\f"+
		"]\3\2\2\2\16g\3\2\2\2\20i\3\2\2\2\22n\3\2\2\2\24u\3\2\2\2\26y\3\2\2\2"+
		"\30\177\3\2\2\2\32\u0081\3\2\2\2\34\u0083\3\2\2\2\36\u00a3\3\2\2\2 \u00b1"+
		"\3\2\2\2\"\u00c9\3\2\2\2$\u00d6\3\2\2\2&\u00d8\3\2\2\2(\u00db\3\2\2\2"+
		"*\u00e6\3\2\2\2,\u00f1\3\2\2\2.\u00fc\3\2\2\2\60\u0100\3\2\2\2\62\u0102"+
		"\3\2\2\2\64\u0104\3\2\2\2\66\u010c\3\2\2\28\u010e\3\2\2\2:\u0110\3\2\2"+
		"\2<=\5\4\3\2=>\5\6\4\2>\3\3\2\2\2?@\7\26\2\2@D\7)\2\2AC\5\64\33\2BA\3"+
		"\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\r\2\2HI\7"+
		")\2\2I\5\3\2\2\2JK\7\25\2\2KO\7)\2\2LN\5\b\5\2ML\3\2\2\2NQ\3\2\2\2OM\3"+
		"\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7\4\2\2ST\7)\2\2T\7\3\2\2\2UV\5"+
		"\n\6\2VW\7+\2\2WX\5\f\7\2XY\7,\2\2YZ\7)\2\2Z\t\3\2\2\2[\\\5\62\32\2\\"+
		"\13\3\2\2\2]^\5\62\32\2^\r\3\2\2\2_h\7*\2\2`h\7(\2\2ah\5\20\t\2bh\5\22"+
		"\n\2cd\7\t\2\2de\5,\27\2ef\7\30\2\2fh\3\2\2\2g_\3\2\2\2g`\3\2\2\2ga\3"+
		"\2\2\2gb\3\2\2\2gc\3\2\2\2h\17\3\2\2\2ij\7\"\2\2jk\7\t\2\2kl\7*\2\2lm"+
		"\7\30\2\2m\21\3\2\2\2no\7#\2\2op\7\t\2\2pq\5,\27\2qr\7\30\2\2rs\t\2\2"+
		"\2st\7(\2\2t\23\3\2\2\2uv\5\16\b\2v\25\3\2\2\2wz\7\17\2\2xz\5,\27\2yw"+
		"\3\2\2\2yx\3\2\2\2z\27\3\2\2\2{\u0080\5\24\13\2|}\5\32\16\2}~\5\24\13"+
		"\2~\u0080\3\2\2\2\177{\3\2\2\2\177|\3\2\2\2\u0080\31\3\2\2\2\u0081\u0082"+
		"\t\3\2\2\u0082\33\3\2\2\2\u0083\u0084\b\17\1\2\u0084\u0085\5\30\r\2\u0085"+
		"\u00a0\3\2\2\2\u0086\u0087\f\n\2\2\u0087\u0088\7\n\2\2\u0088\u009f\5\30"+
		"\r\2\u0089\u008a\f\t\2\2\u008a\u008b\7\3\2\2\u008b\u009f\5\30\r\2\u008c"+
		"\u008d\f\b\2\2\u008d\u008e\7\5\2\2\u008e\u009f\5\30\r\2\u008f\u0090\f"+
		"\7\2\2\u0090\u0091\7\7\2\2\u0091\u009f\5\30\r\2\u0092\u0093\f\6\2\2\u0093"+
		"\u0094\7\36\2\2\u0094\u009f\5\30\r\2\u0095\u0096\f\5\2\2\u0096\u0097\7"+
		"\37\2\2\u0097\u009f\5\30\r\2\u0098\u0099\f\4\2\2\u0099\u009a\7 \2\2\u009a"+
		"\u009f\5\30\r\2\u009b\u009c\f\3\2\2\u009c\u009d\7!\2\2\u009d\u009f\5\30"+
		"\r\2\u009e\u0086\3\2\2\2\u009e\u0089\3\2\2\2\u009e\u008c\3\2\2\2\u009e"+
		"\u008f\3\2\2\2\u009e\u0092\3\2\2\2\u009e\u0095\3\2\2\2\u009e\u0098\3\2"+
		"\2\2\u009e\u009b\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\35\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\b\20\1"+
		"\2\u00a4\u00a5\5\34\17\2\u00a5\u00ae\3\2\2\2\u00a6\u00a7\f\4\2\2\u00a7"+
		"\u00a8\7\31\2\2\u00a8\u00ad\5\34\17\2\u00a9\u00aa\f\3\2\2\u00aa\u00ab"+
		"\7\32\2\2\u00ab\u00ad\5\34\17\2\u00ac\u00a6\3\2\2\2\u00ac\u00a9\3\2\2"+
		"\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\37"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\b\21\1\2\u00b2\u00b3\5\36\20"+
		"\2\u00b3\u00c2\3\2\2\2\u00b4\u00b5\f\6\2\2\u00b5\u00b6\7\21\2\2\u00b6"+
		"\u00c1\5\36\20\2\u00b7\u00b8\f\5\2\2\u00b8\u00b9\7\23\2\2\u00b9\u00c1"+
		"\5\36\20\2\u00ba\u00bb\f\4\2\2\u00bb\u00bc\7$\2\2\u00bc\u00c1\5\36\20"+
		"\2\u00bd\u00be\f\3\2\2\u00be\u00bf\7%\2\2\u00bf\u00c1\5\36\20\2\u00c0"+
		"\u00b4\3\2\2\2\u00c0\u00b7\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c0\u00bd\3\2"+
		"\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"!\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\b\22\1\2\u00c6\u00ca\5$\23\2"+
		"\u00c7\u00ca\5&\24\2\u00c8\u00ca\5 \21\2\u00c9\u00c5\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00d3\3\2\2\2\u00cb\u00cc\f\4\2\2\u00cc"+
		"\u00cd\7&\2\2\u00cd\u00d2\5 \21\2\u00ce\u00cf\f\3\2\2\u00cf\u00d0\7\'"+
		"\2\2\u00d0\u00d2\5 \21\2\u00d1\u00cb\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2"+
		"\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4#\3\2\2\2"+
		"\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7\35\2\2\u00d7%\3\2\2\2\u00d8\u00d9\7"+
		"\24\2\2\u00d9\u00da\7\35\2\2\u00da\'\3\2\2\2\u00db\u00dc\b\25\1\2\u00dc"+
		"\u00dd\5\"\22\2\u00dd\u00e3\3\2\2\2\u00de\u00df\f\3\2\2\u00df\u00e0\7"+
		"\b\2\2\u00e0\u00e2\5\"\22\2\u00e1\u00de\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4)\3\2\2\2\u00e5\u00e3\3\2\2\2"+
		"\u00e6\u00e7\b\26\1\2\u00e7\u00e8\5(\25\2\u00e8\u00ee\3\2\2\2\u00e9\u00ea"+
		"\f\3\2\2\u00ea\u00eb\7\20\2\2\u00eb\u00ed\5(\25\2\u00ec\u00e9\3\2\2\2"+
		"\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef+\3"+
		"\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\b\27\1\2\u00f2\u00f3\5*\26\2\u00f3"+
		"\u00f9\3\2\2\2\u00f4\u00f5\f\3\2\2\u00f5\u00f6\7\17\2\2\u00f6\u00f8\5"+
		"*\26\2\u00f7\u00f4\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa-\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\5\24\13"+
		"\2\u00fd\u00fe\7\6\2\2\u00fe\u00ff\5,\27\2\u00ff/\3\2\2\2\u0100\u0101"+
		"\5,\27\2\u0101\61\3\2\2\2\u0102\u0103\5\60\31\2\u0103\63\3\2\2\2\u0104"+
		"\u0105\5\66\34\2\u0105\u0106\7+\2\2\u0106\u0107\58\35\2\u0107\u0108\7"+
		"+\2\2\u0108\u0109\5:\36\2\u0109\u010a\7,\2\2\u010a\u010b\7)\2\2\u010b"+
		"\65\3\2\2\2\u010c\u010d\7*\2\2\u010d\67\3\2\2\2\u010e\u010f\t\4\2\2\u010f"+
		"9\3\2\2\2\u0110\u0111\t\5\2\2\u0111;\3\2\2\2\23DOgy\177\u009e\u00a0\u00ac"+
		"\u00ae\u00c0\u00c2\u00c9\u00d1\u00d3\u00e3\u00ee\u00f9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}