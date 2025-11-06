// Generated from /Users/adrianmoralesrodriguez/Documents/Universidad/Procesadores del Lenguaje/compiladores-pl2/compiladores-pl2tof/PL2-Ubicua/src/main/antlr/IkeaLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IkeaLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, FIN=17, 
		ITEM=18, INT=19, ID=20, WS=21;
	public static final int
		RULE_manual = 0, RULE_itemHeader = 1, RULE_instruction = 2, RULE_stepList = 3, 
		RULE_step = 4, RULE_unir = 5, RULE_colocar = 6, RULE_atornillar = 7, RULE_conHerramienta = 8, 
		RULE_girar = 9, RULE_voltear = 10, RULE_repetir = 11, RULE_pieza = 12, 
		RULE_herramienta = 13, RULE_direccion = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"manual", "itemHeader", "instruction", "stepList", "step", "unir", "colocar", 
			"atornillar", "conHerramienta", "girar", "voltear", "repetir", "pieza", 
			"herramienta", "direccion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", "'.'", "';'", "'Unir'", "'y'", "'Colocar'", "'atornillar'", 
			"'tornillos'", "'Con'", "','", "'Girar'", "'Voltear'", "'Repetir'", "'('", 
			"')'", "'pieza'", "'FIN'", "'ITEM:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "FIN", "ITEM", "INT", "ID", "WS"
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
	public String getGrammarFileName() { return "IkeaLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IkeaLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ManualContext extends ParserRuleContext {
		public ItemHeaderContext itemHeader() {
			return getRuleContext(ItemHeaderContext.class,0);
		}
		public TerminalNode FIN() { return getToken(IkeaLangParser.FIN, 0); }
		public TerminalNode EOF() { return getToken(IkeaLangParser.EOF, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public ManualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_manual; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterManual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitManual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitManual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ManualContext manual() throws RecognitionException {
		ManualContext _localctx = new ManualContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_manual);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			itemHeader();
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				instruction();
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT );
			setState(36);
			match(FIN);
			setState(37);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ItemHeaderContext extends ParserRuleContext {
		public TerminalNode ITEM() { return getToken(IkeaLangParser.ITEM, 0); }
		public TerminalNode ID() { return getToken(IkeaLangParser.ID, 0); }
		public ItemHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterItemHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitItemHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitItemHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemHeaderContext itemHeader() throws RecognitionException {
		ItemHeaderContext _localctx = new ItemHeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_itemHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(ITEM);
			setState(40);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(IkeaLangParser.INT, 0); }
		public List<StepListContext> stepList() {
			return getRuleContexts(StepListContext.class);
		}
		public StepListContext stepList(int i) {
			return getRuleContext(StepListContext.class,i);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(INT);
			setState(43);
			match(T__0);
			setState(44);
			stepList();
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45);
					match(T__1);
					setState(46);
					stepList();
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(52);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StepListContext extends ParserRuleContext {
		public List<StepContext> step() {
			return getRuleContexts(StepContext.class);
		}
		public StepContext step(int i) {
			return getRuleContext(StepContext.class,i);
		}
		public StepListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterStepList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitStepList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitStepList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepListContext stepList() throws RecognitionException {
		StepListContext _localctx = new StepListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stepList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			step();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(55);
				match(T__2);
				setState(56);
				step();
				}
				}
				setState(61);
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
	public static class StepContext extends ParserRuleContext {
		public UnirContext unir() {
			return getRuleContext(UnirContext.class,0);
		}
		public ColocarContext colocar() {
			return getRuleContext(ColocarContext.class,0);
		}
		public AtornillarContext atornillar() {
			return getRuleContext(AtornillarContext.class,0);
		}
		public ConHerramientaContext conHerramienta() {
			return getRuleContext(ConHerramientaContext.class,0);
		}
		public GirarContext girar() {
			return getRuleContext(GirarContext.class,0);
		}
		public VoltearContext voltear() {
			return getRuleContext(VoltearContext.class,0);
		}
		public RepetirContext repetir() {
			return getRuleContext(RepetirContext.class,0);
		}
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitStep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_step);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				unir();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				colocar();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				atornillar();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				conHerramienta();
				setState(66);
				atornillar();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				girar();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(69);
				voltear();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 7);
				{
				setState(70);
				repetir();
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
	public static class UnirContext extends ParserRuleContext {
		public List<PiezaContext> pieza() {
			return getRuleContexts(PiezaContext.class);
		}
		public PiezaContext pieza(int i) {
			return getRuleContext(PiezaContext.class,i);
		}
		public UnirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterUnir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitUnir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitUnir(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnirContext unir() throws RecognitionException {
		UnirContext _localctx = new UnirContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__3);
			setState(74);
			pieza();
			setState(75);
			match(T__4);
			setState(76);
			pieza();
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
	public static class ColocarContext extends ParserRuleContext {
		public PiezaContext pieza() {
			return getRuleContext(PiezaContext.class,0);
		}
		public ColocarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colocar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterColocar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitColocar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitColocar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColocarContext colocar() throws RecognitionException {
		ColocarContext _localctx = new ColocarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_colocar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__5);
			setState(79);
			pieza();
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
	public static class AtornillarContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(IkeaLangParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(IkeaLangParser.INT, i);
		}
		public TerminalNode ID() { return getToken(IkeaLangParser.ID, 0); }
		public AtornillarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atornillar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterAtornillar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitAtornillar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitAtornillar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtornillarContext atornillar() throws RecognitionException {
		AtornillarContext _localctx = new AtornillarContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atornillar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__6);
			setState(82);
			match(INT);
			setState(83);
			match(T__7);
			setState(84);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==ID) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConHerramientaContext extends ParserRuleContext {
		public HerramientaContext herramienta() {
			return getRuleContext(HerramientaContext.class,0);
		}
		public ConHerramientaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conHerramienta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterConHerramienta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitConHerramienta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitConHerramienta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConHerramientaContext conHerramienta() throws RecognitionException {
		ConHerramientaContext _localctx = new ConHerramientaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_conHerramienta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__8);
			setState(87);
			herramienta();
			setState(88);
			match(T__9);
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
	public static class GirarContext extends ParserRuleContext {
		public DireccionContext direccion() {
			return getRuleContext(DireccionContext.class,0);
		}
		public GirarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_girar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterGirar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitGirar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitGirar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GirarContext girar() throws RecognitionException {
		GirarContext _localctx = new GirarContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_girar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__10);
			setState(91);
			direccion();
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
	public static class VoltearContext extends ParserRuleContext {
		public VoltearContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voltear; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterVoltear(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitVoltear(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitVoltear(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoltearContext voltear() throws RecognitionException {
		VoltearContext _localctx = new VoltearContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_voltear);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__11);
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
	public static class RepetirContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(IkeaLangParser.INT, 0); }
		public RepetirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repetir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterRepetir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitRepetir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitRepetir(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepetirContext repetir() throws RecognitionException {
		RepetirContext _localctx = new RepetirContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_repetir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__12);
			setState(96);
			match(T__13);
			setState(97);
			match(INT);
			setState(98);
			match(T__14);
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
	public static class PiezaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IkeaLangParser.ID, 0); }
		public PiezaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pieza; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterPieza(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitPieza(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitPieza(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PiezaContext pieza() throws RecognitionException {
		PiezaContext _localctx = new PiezaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pieza);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__15);
			setState(101);
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

	@SuppressWarnings("CheckReturnValue")
	public static class HerramientaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IkeaLangParser.ID, 0); }
		public HerramientaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_herramienta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterHerramienta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitHerramienta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitHerramienta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HerramientaContext herramienta() throws RecognitionException {
		HerramientaContext _localctx = new HerramientaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_herramienta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DireccionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IkeaLangParser.ID, 0); }
		public DireccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direccion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).enterDireccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IkeaLangListener ) ((IkeaLangListener)listener).exitDireccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IkeaLangVisitor ) return ((IkeaLangVisitor<? extends T>)visitor).visitDireccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DireccionContext direccion() throws RecognitionException {
		DireccionContext _localctx = new DireccionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_direccion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0015l\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0004\u0000!\b\u0000\u000b\u0000\f\u0000\"\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u00020\b\u0002\n\u0002\f\u00023\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003:\b\u0003\n\u0003\f\u0003=\t\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004H\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0001"+
		"\u0001\u0000\u0013\u0014e\u0000\u001e\u0001\u0000\u0000\u0000\u0002\'"+
		"\u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000\u00066\u0001\u0000"+
		"\u0000\u0000\bG\u0001\u0000\u0000\u0000\nI\u0001\u0000\u0000\u0000\fN"+
		"\u0001\u0000\u0000\u0000\u000eQ\u0001\u0000\u0000\u0000\u0010V\u0001\u0000"+
		"\u0000\u0000\u0012Z\u0001\u0000\u0000\u0000\u0014]\u0001\u0000\u0000\u0000"+
		"\u0016_\u0001\u0000\u0000\u0000\u0018d\u0001\u0000\u0000\u0000\u001ag"+
		"\u0001\u0000\u0000\u0000\u001ci\u0001\u0000\u0000\u0000\u001e \u0003\u0002"+
		"\u0001\u0000\u001f!\u0003\u0004\u0002\u0000 \u001f\u0001\u0000\u0000\u0000"+
		"!\"\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000"+
		"\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0005\u0011\u0000\u0000%&\u0005"+
		"\u0000\u0000\u0001&\u0001\u0001\u0000\u0000\u0000\'(\u0005\u0012\u0000"+
		"\u0000()\u0005\u0014\u0000\u0000)\u0003\u0001\u0000\u0000\u0000*+\u0005"+
		"\u0013\u0000\u0000+,\u0005\u0001\u0000\u0000,1\u0003\u0006\u0003\u0000"+
		"-.\u0005\u0002\u0000\u0000.0\u0003\u0006\u0003\u0000/-\u0001\u0000\u0000"+
		"\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000"+
		"\u0000\u000024\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000045\u0005"+
		"\u0002\u0000\u00005\u0005\u0001\u0000\u0000\u00006;\u0003\b\u0004\u0000"+
		"78\u0005\u0003\u0000\u00008:\u0003\b\u0004\u000097\u0001\u0000\u0000\u0000"+
		":=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000"+
		"\u0000<\u0007\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>H\u0003"+
		"\n\u0005\u0000?H\u0003\f\u0006\u0000@H\u0003\u000e\u0007\u0000AB\u0003"+
		"\u0010\b\u0000BC\u0003\u000e\u0007\u0000CH\u0001\u0000\u0000\u0000DH\u0003"+
		"\u0012\t\u0000EH\u0003\u0014\n\u0000FH\u0003\u0016\u000b\u0000G>\u0001"+
		"\u0000\u0000\u0000G?\u0001\u0000\u0000\u0000G@\u0001\u0000\u0000\u0000"+
		"GA\u0001\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000"+
		"\u0000GF\u0001\u0000\u0000\u0000H\t\u0001\u0000\u0000\u0000IJ\u0005\u0004"+
		"\u0000\u0000JK\u0003\u0018\f\u0000KL\u0005\u0005\u0000\u0000LM\u0003\u0018"+
		"\f\u0000M\u000b\u0001\u0000\u0000\u0000NO\u0005\u0006\u0000\u0000OP\u0003"+
		"\u0018\f\u0000P\r\u0001\u0000\u0000\u0000QR\u0005\u0007\u0000\u0000RS"+
		"\u0005\u0013\u0000\u0000ST\u0005\b\u0000\u0000TU\u0007\u0000\u0000\u0000"+
		"U\u000f\u0001\u0000\u0000\u0000VW\u0005\t\u0000\u0000WX\u0003\u001a\r"+
		"\u0000XY\u0005\n\u0000\u0000Y\u0011\u0001\u0000\u0000\u0000Z[\u0005\u000b"+
		"\u0000\u0000[\\\u0003\u001c\u000e\u0000\\\u0013\u0001\u0000\u0000\u0000"+
		"]^\u0005\f\u0000\u0000^\u0015\u0001\u0000\u0000\u0000_`\u0005\r\u0000"+
		"\u0000`a\u0005\u000e\u0000\u0000ab\u0005\u0013\u0000\u0000bc\u0005\u000f"+
		"\u0000\u0000c\u0017\u0001\u0000\u0000\u0000de\u0005\u0010\u0000\u0000"+
		"ef\u0005\u0014\u0000\u0000f\u0019\u0001\u0000\u0000\u0000gh\u0005\u0014"+
		"\u0000\u0000h\u001b\u0001\u0000\u0000\u0000ij\u0005\u0014\u0000\u0000"+
		"j\u001d\u0001\u0000\u0000\u0000\u0004\"1;G";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}