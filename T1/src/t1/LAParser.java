// Generated from C:\Trabalho1-Compiladores2\T1\src\t1\LA.g4 by ANTLR 4.5.3
package t1;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LAParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALGORITMO=1, FIM_ALGORITMO=2, DECLARE=3, CONSTANTE=4, TIPO=5, DOIS_PONTOS=6, 
		ABRE_COLCHETE=7, FECHA_COLCHETE=8, VIRGULA=9, EXPOENTE=10, PONTO=11, LITERAL=12, 
		INTEIRO=13, REAL=14, LOGICO=15, VERDADEIRO=16, FALSO=17, REGISTRO=18, 
		FIM_REGISTRO=19, PROCEDIMENTO=20, FIM_PROCEDIMENTO=21, ABRE_PARENTESIS=22, 
		FECHA_PARENTESIS=23, FUNCAO=24, FIM_FUNCAO=25, VAR=26, LEIA=27, ESCREVA=28, 
		SE=29, ENTAO=30, FIM_SE=31, SENAO=32, CASO=33, SEJA=34, FIM_CASO=35, PARA=36, 
		ATRIBUICAO=37, ATE=38, FACA=39, FIM_PARA=40, ENQUANTO=41, FIM_ENQUANTO=42, 
		RETORNE=43, PONTO_PONTO=44, MULTIPLICACAO=45, MENOR_IGUAL=46, DIVISAO=47, 
		MAIOR_IGUAL=48, PORCENTAGEM=49, MENOR=50, MAIOR=51, IGUAL=52, DIFERENTE=53, 
		OU=54, E=55, NAO=56, SOMA=57, SUBTRACAO=58, OP_AND=59, CADEIA=60, IDENT=61, 
		N_INTEIRO=62, N_REAL=63, WS=64, COMENTARIO=65;
	public static final int
		RULE_programa = 0, RULE_declaracoes = 1, RULE_decl_local_global = 2, RULE_declaracao_local = 3, 
		RULE_variavel = 4, RULE_mais_var = 5, RULE_identificador = 6, RULE_ponteiros_opcionais = 7, 
		RULE_outros_ident = 8, RULE_dimensao = 9, RULE_tipo = 10, RULE_mais_ident = 11, 
		RULE_mais_variaveis = 12, RULE_tipo_basico = 13, RULE_tipo_basico_ident = 14, 
		RULE_tipo_estendido = 15, RULE_valor_constante = 16, RULE_registro = 17, 
		RULE_declaracao_global = 18, RULE_parametros_opcional = 19, RULE_parametro = 20, 
		RULE_var_opcional = 21, RULE_mais_parametros = 22, RULE_declaracoes_locais = 23, 
		RULE_corpo = 24, RULE_comandos = 25, RULE_cmd = 26, RULE_mais_expressao = 27, 
		RULE_senao_opcional = 28, RULE_chamada_atribuicao = 29, RULE_argumentos_opcional = 30, 
		RULE_selecao = 31, RULE_mais_selecao = 32, RULE_constantes = 33, RULE_mais_constantes = 34, 
		RULE_numero_intervalo = 35, RULE_intervalo_opcional = 36, RULE_op_unario = 37, 
		RULE_exp_aritmetica = 38, RULE_op_multiplicacao = 39, RULE_op_adicao = 40, 
		RULE_termo = 41, RULE_outros_termos = 42, RULE_fator = 43, RULE_outros_fatores = 44, 
		RULE_parcela = 45, RULE_parcela_unario = 46, RULE_parcela_nao_unario = 47, 
		RULE_outras_parcelas = 48, RULE_chamada_partes = 49, RULE_exp_relacional = 50, 
		RULE_op_opcional = 51, RULE_op_relacional = 52, RULE_expressao = 53, RULE_op_nao = 54, 
		RULE_termo_logico = 55, RULE_outros_termos_logicos = 56, RULE_outros_fatores_logicos = 57, 
		RULE_fator_logico = 58, RULE_parcela_logica = 59;
	public static final String[] ruleNames = {
		"programa", "declaracoes", "decl_local_global", "declaracao_local", "variavel", 
		"mais_var", "identificador", "ponteiros_opcionais", "outros_ident", "dimensao", 
		"tipo", "mais_ident", "mais_variaveis", "tipo_basico", "tipo_basico_ident", 
		"tipo_estendido", "valor_constante", "registro", "declaracao_global", 
		"parametros_opcional", "parametro", "var_opcional", "mais_parametros", 
		"declaracoes_locais", "corpo", "comandos", "cmd", "mais_expressao", "senao_opcional", 
		"chamada_atribuicao", "argumentos_opcional", "selecao", "mais_selecao", 
		"constantes", "mais_constantes", "numero_intervalo", "intervalo_opcional", 
		"op_unario", "exp_aritmetica", "op_multiplicacao", "op_adicao", "termo", 
		"outros_termos", "fator", "outros_fatores", "parcela", "parcela_unario", 
		"parcela_nao_unario", "outras_parcelas", "chamada_partes", "exp_relacional", 
		"op_opcional", "op_relacional", "expressao", "op_nao", "termo_logico", 
		"outros_termos_logicos", "outros_fatores_logicos", "fator_logico", "parcela_logica"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'algoritmo'", "'fim_algoritmo'", "'declare'", "'constante'", "'tipo'", 
		"':'", "'['", "']'", "','", "'^'", "'.'", "'literal'", "'inteiro'", "'real'", 
		"'logico'", "'verdadeiro'", "'falso'", "'registro'", "'fim_registro'", 
		"'procedimento'", "'fim_procedimento'", "'('", "')'", "'funcao'", "'fim_funcao'", 
		"'var'", "'leia'", "'escreva'", "'se'", "'entao'", "'fim_se'", "'senao'", 
		"'caso'", "'seja'", "'fim_caso'", "'para'", "'<-'", "'ate'", "'faca'", 
		"'fim_para'", "'enquanto'", "'fim_enquanto'", "'retorne'", "'..'", "'*'", 
		"'<='", "'/'", "'>='", "'%'", "'<'", "'>'", "'='", "'<>'", "'ou'", "'e'", 
		"'nao'", "'+'", "'-'", "'&'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ALGORITMO", "FIM_ALGORITMO", "DECLARE", "CONSTANTE", "TIPO", "DOIS_PONTOS", 
		"ABRE_COLCHETE", "FECHA_COLCHETE", "VIRGULA", "EXPOENTE", "PONTO", "LITERAL", 
		"INTEIRO", "REAL", "LOGICO", "VERDADEIRO", "FALSO", "REGISTRO", "FIM_REGISTRO", 
		"PROCEDIMENTO", "FIM_PROCEDIMENTO", "ABRE_PARENTESIS", "FECHA_PARENTESIS", 
		"FUNCAO", "FIM_FUNCAO", "VAR", "LEIA", "ESCREVA", "SE", "ENTAO", "FIM_SE", 
		"SENAO", "CASO", "SEJA", "FIM_CASO", "PARA", "ATRIBUICAO", "ATE", "FACA", 
		"FIM_PARA", "ENQUANTO", "FIM_ENQUANTO", "RETORNE", "PONTO_PONTO", "MULTIPLICACAO", 
		"MENOR_IGUAL", "DIVISAO", "MAIOR_IGUAL", "PORCENTAGEM", "MENOR", "MAIOR", 
		"IGUAL", "DIFERENTE", "OU", "E", "NAO", "SOMA", "SUBTRACAO", "OP_AND", 
		"CADEIA", "IDENT", "N_INTEIRO", "N_REAL", "WS", "COMENTARIO"
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
	public String getGrammarFileName() { return "LA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	   public static String grupo="551503,";
	   String msg_error="";
	   PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
	   PilhaDeTabelas tabelaRegistros = new PilhaDeTabelas();
	   TabelaDeSimbolos tabelaTipos = new TabelaDeSimbolos("tipos");
	     

	public LAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public TerminalNode ALGORITMO() { return getToken(LAParser.ALGORITMO, 0); }
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public TerminalNode FIM_ALGORITMO() { return getToken(LAParser.FIM_ALGORITMO, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
			            /*Primeiramente criar um novo escopo e empila-lo. Ele será o escopo global do programa*/
			             pilhaDeTabelas.empilhar(new TabelaDeSimbolos("global"));
			             /* Feito isso, definimos os tipos default da linguagem, ou seja, adicionamos
			             todos os tipos pertencentes a LA para que dado uma varivel com esses tipos não precise
			             adicionar no codigo, se um tipo diferente desses for declarado, ele é tratado no código*/
			             tabelaTipos.adicionarSimbolo("literal", "literal");
			             tabelaTipos.adicionarSimbolo("inteiro", "inteiro");
			             tabelaTipos.adicionarSimbolo("real", "real");
			             tabelaTipos.adicionarSimbolo("logico", "logico");
			                      
			          
			setState(121);
			declaracoes();
			setState(122);
			match(ALGORITMO);
			setState(123);
			corpo();
			setState(124);
			match(FIM_ALGORITMO);

			              /* Depois que o fim_algoritmo é encontrado no programa, é executado o seguinte comando:*/
			              { 
			              /* Ele serve para desempilhar a pilha global que criamos no inicio dele e terminar a execução */
			              pilhaDeTabelas.desempilhar();
			              /* msg_error guarda qualquer possivel erro que ocorreu na analise semantica e lança uma exceção */
			              if(msg_error!=""){
			                  throw new RuntimeException(msg_error);
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

	public static class DeclaracoesContext extends ParserRuleContext {
		public List<Decl_local_globalContext> decl_local_global() {
			return getRuleContexts(Decl_local_globalContext.class);
		}
		public Decl_local_globalContext decl_local_global(int i) {
			return getRuleContext(Decl_local_globalContext.class,i);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECLARE) | (1L << CONSTANTE) | (1L << TIPO) | (1L << PROCEDIMENTO) | (1L << FUNCAO))) != 0)) {
				{
				{
				setState(127);
				decl_local_global();
				}
				}
				setState(132);
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

	public static class Decl_local_globalContext extends ParserRuleContext {
		public Declaracao_localContext declaracao_local() {
			return getRuleContext(Declaracao_localContext.class,0);
		}
		public Declaracao_globalContext declaracao_global() {
			return getRuleContext(Declaracao_globalContext.class,0);
		}
		public Decl_local_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_local_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDecl_local_global(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDecl_local_global(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDecl_local_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_local_globalContext decl_local_global() throws RecognitionException {
		Decl_local_globalContext _localctx = new Decl_local_globalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl_local_global);
		try {
			setState(135);
			switch (_input.LA(1)) {
			case DECLARE:
			case CONSTANTE:
			case TIPO:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				declaracao_local();
				}
				break;
			case PROCEDIMENTO:
			case FUNCAO:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				declaracao_global();
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

	public static class Declaracao_localContext extends ParserRuleContext {
		public VariavelContext variavel;
		public Token v1;
		public Tipo_basicoContext v2;
		public TipoContext v3;
		public TerminalNode DECLARE() { return getToken(LAParser.DECLARE, 0); }
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public TerminalNode CONSTANTE() { return getToken(LAParser.CONSTANTE, 0); }
		public TerminalNode DOIS_PONTOS() { return getToken(LAParser.DOIS_PONTOS, 0); }
		public TerminalNode IGUAL() { return getToken(LAParser.IGUAL, 0); }
		public Valor_constanteContext valor_constante() {
			return getRuleContext(Valor_constanteContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public TerminalNode TIPO() { return getToken(LAParser.TIPO, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Declaracao_localContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_local; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracao_local(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracao_local(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracao_local(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_localContext declaracao_local() throws RecognitionException {
		Declaracao_localContext _localctx = new Declaracao_localContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracao_local);
		try {
			setState(155);
			switch (_input.LA(1)) {
			case DECLARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(DECLARE);
				setState(138);
				((Declaracao_localContext)_localctx).variavel = variavel();

				       /* aqui há um loop para percorrer os nomes das variaveis declaradas pois podemos declarar varios nomes
				       de variáveis do mesmo tipo de uma só vez. Essa parte entra juntamente com o processamento de variaveis e consequentemente
				       de mais_variaveis pois lá atribuimos nomes, tipo e linha que pegamos aqui para tratar*/
				       for (String s : ((Declaracao_localContext)_localctx).variavel.nomes){
				         // verificação se existe o símbolo na pilha de tabelas
				            if(pilhaDeTabelas.topo().existeSimbolo(s)){
				            // se existir, é emitida uma mensagem de erro que a variavel com identificador já foi declarada
				                msg_error += "Linha " + ((Declaracao_localContext)_localctx).variavel.linha + ": identificador "+s+" ja declarado anteriormente\n" ;
						
				            }else{
				                // se não tiver o simbolo, verificamos se o tipo desse simbolo já esta declarado
					        if(tabelaTipos.existeSimbolo(((Declaracao_localContext)_localctx).variavel.tipoSimbolo)){
				                    // se o tipo já existir, então só ai o simbolo é adicionado no escopo atual
				                    pilhaDeTabelas.topo().adicionarSimbolo(s, ((Declaracao_localContext)_localctx).variavel.tipoSimbolo);
				                    // aqui verificamos se existe alguma tabela com o tipo declarado pois esse tipo declarado pode ser um tipo de registro
				                    // então devemos procurar na tabela de registro, pois o tratamento é diferente
				                    if(tabelaRegistros.existeTabela(((Declaracao_localContext)_localctx).variavel.tipoSimbolo)!=null){
				                        //se existir uma tabela de registro com o tipo informado então temos uma variavel do tipo do registro
				                        //resgatamos a tabela do registro na qual o tipo declarado pertence
				                        TabelaDeSimbolos tabela_registro = tabelaRegistros.existeTabela(((Declaracao_localContext)_localctx).variavel.tipoSimbolo);
				                        //adicionamos todas variaveis do registro naa tabela
				                        for (EntradaTabelaDeSimbolos t : tabela_registro.getSimbolos2()){
				                            pilhaDeTabelas.topo().adicionarSimbolo(s+"."+t.getNome(), t.getTipo());
				                        }
				                    }else{
				                        //aqui verificamos o caso de existir uma tabela de registro
				                        if(tabelaRegistros.existeTabela("registro")!=null){
				                            //recuperamos a tabela de registro 
				                            TabelaDeSimbolos tabela_registro = tabelaRegistros.existeTabela("registro");
				                            //e adicionamos cada variavel pertencente ao registro a ela
				                            for (EntradaTabelaDeSimbolos t : tabela_registro.getSimbolos2())
				                            {
				                                pilhaDeTabelas.topo().adicionarSimbolo(s+"."+t.getNome(), t.getTipo());
				                            }
				                         }
				                    }   
				                }
				                else{ 
				                // esse else é executado se o tipo não foi declarado ainda e causa um erro se isso acontecer
				                  
				                    msg_error += "Linha " + ((Declaracao_localContext)_localctx).variavel.linha + ": tipo "+((Declaracao_localContext)_localctx).variavel.tipoSimbolo+" nao declarado\n" ;
				                    pilhaDeTabelas.topo().adicionarSimbolo(s, ((Declaracao_localContext)_localctx).variavel.tipoSimbolo);
				                }
				            }
				        }
				    
				}
				break;
			case CONSTANTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(CONSTANTE);
				setState(142);
				((Declaracao_localContext)_localctx).v1 = match(IDENT);
				setState(143);
				match(DOIS_PONTOS);
				setState(144);
				((Declaracao_localContext)_localctx).v2 = tipo_basico();
				setState(145);
				match(IGUAL);
				setState(146);
				valor_constante();

				       //primeiro verificamos se existe uma variavel no mesmo escopo com o mesmo nome
				       if(pilhaDeTabelas.topo().existeSimbolo(((Declaracao_localContext)_localctx).v1.getText()))
				           // se existir é executado um erro  
				            msg_error += "Linha " + ((Declaracao_localContext)_localctx).v1.getLine() + ": identificador "+((Declaracao_localContext)_localctx).v1.getText()+" ja declarado anteriormente\n" ;
				        else{
				            // se ainda não foi declara nenhuma variavel com esse nome, então o identificador da variável e tipo são
				            // adiicionados no escopo atual
				            pilhaDeTabelas.topo().adicionarSimbolo(((Declaracao_localContext)_localctx).v1.getText(), ((Declaracao_localContext)_localctx).v2.tipoSimbolo);
				         }
				       
				}
				break;
			case TIPO:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				match(TIPO);
				setState(150);
				((Declaracao_localContext)_localctx).v1 = match(IDENT);
				setState(151);
				match(DOIS_PONTOS);
				setState(152);
				((Declaracao_localContext)_localctx).v3 = tipo(((Declaracao_localContext)_localctx).v1.getText());

				        //primeiro verificamos se já existe um identificador com mesmo nome já declarado
				        if(pilhaDeTabelas.topo().existeSimbolo(((Declaracao_localContext)_localctx).v1.getText()))
				           // se existir executa um erro
				            msg_error += "Linha " + ((Declaracao_localContext)_localctx).v1.getLine() + ": identificador "+((Declaracao_localContext)_localctx).v1.getText()+" ja declarado anteriormente\n" ;
				        else{
				           // se não existir então adiciona-se o identificador e tipo no escopo atual
				            pilhaDeTabelas.topo().adicionarSimbolo(((Declaracao_localContext)_localctx).v1.getText(), ((Declaracao_localContext)_localctx).v3.tipoSimbolo);
				            //e também adiciona-se um novo tipo, pois estamos declarando um novo tipo
				            tabelaTipos.adicionarSimbolo(((Declaracao_localContext)_localctx).v1.getText(), ((Declaracao_localContext)_localctx).v3.tipoSimbolo);  
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

	public static class VariavelContext extends ParserRuleContext {
		public List<String> nomes;
		public String tipoSimbolo;
		public int linha;
		public Token v1;
		public Mais_varContext v2;
		public TipoContext m3;
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public TerminalNode DOIS_PONTOS() { return getToken(LAParser.DOIS_PONTOS, 0); }
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Mais_varContext mais_var() {
			return getRuleContext(Mais_varContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public VariavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variavel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitVariavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitVariavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariavelContext variavel() throws RecognitionException {
		VariavelContext _localctx = new VariavelContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variavel);
		((VariavelContext)_localctx).nomes =  new ArrayList<String>(); ((VariavelContext)_localctx).tipoSimbolo = ""; ((VariavelContext)_localctx).linha = -1;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			((VariavelContext)_localctx).v1 = match(IDENT);
			setState(158);
			dimensao();
			setState(159);
			((VariavelContext)_localctx).v2 = mais_var();
			setState(160);
			match(DOIS_PONTOS);
			setState(161);
			((VariavelContext)_localctx).m3 = tipo(_localctx.tipoSimbolo);

			        ((VariavelContext)_localctx).tipoSimbolo =  ((VariavelContext)_localctx).m3.tipoSimbolo;
			        _localctx.nomes.add(((VariavelContext)_localctx).v1.getText());
			        _localctx.nomes.addAll(((VariavelContext)_localctx).v2.nomes);
			        if(((VariavelContext)_localctx).v2.linha==-1){
			            ((VariavelContext)_localctx).linha =  ((VariavelContext)_localctx).v1.getLine();
			        }else{
			            ((VariavelContext)_localctx).linha =  ((VariavelContext)_localctx).v2.linha;
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

	public static class Mais_varContext extends ParserRuleContext {
		public List<String> nomes;
		public int linha;
		public Token v1;
		public List<TerminalNode> VIRGULA() { return getTokens(LAParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LAParser.VIRGULA, i);
		}
		public List<DimensaoContext> dimensao() {
			return getRuleContexts(DimensaoContext.class);
		}
		public DimensaoContext dimensao(int i) {
			return getRuleContext(DimensaoContext.class,i);
		}
		public List<TerminalNode> IDENT() { return getTokens(LAParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LAParser.IDENT, i);
		}
		public Mais_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_varContext mais_var() throws RecognitionException {
		Mais_varContext _localctx = new Mais_varContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mais_var);
		 ((Mais_varContext)_localctx).nomes =  new ArrayList<String>(); ((Mais_varContext)_localctx).linha = -1; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(164);
				match(VIRGULA);
				setState(165);
				((Mais_varContext)_localctx).v1 = match(IDENT);

				        //depois que chegamos no identidicador fazemos um processamento para verificar se ele já existe
				        if(!pilhaDeTabelas.existeSimbolo(((Mais_varContext)_localctx).v1.getText())){
				            // se não existe, então adicionamos ele na lista de nomes e pegamos a linha dele
				            _localctx.nomes.add(((Mais_varContext)_localctx).v1.getText());
				            ((Mais_varContext)_localctx).linha =  ((Mais_varContext)_localctx).v1.getLine();
				        }
				        else{
				            //se já existir um identificador com mesmo nome é disprada uma mensagem de erro
				            msg_error+="Linha " + ((Mais_varContext)_localctx).v1.getLine() + ": identificador " + ((Mais_varContext)_localctx).v1.getText() + " ja declarado anteriormente\n";
				           
				        }
				     
				setState(167);
				dimensao();
				}
				}
				setState(172);
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

	public static class IdentificadorContext extends ParserRuleContext {
		public String txt;
		public int linha;
		public String tipoSimbolo;
		public Token v1;
		public Outros_identContext v2;
		public Ponteiros_opcionaisContext ponteiros_opcionais() {
			return getRuleContext(Ponteiros_opcionaisContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterIdentificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitIdentificador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_identificador);
		 ((IdentificadorContext)_localctx).txt =  ""; ((IdentificadorContext)_localctx).linha = -1; ((IdentificadorContext)_localctx).tipoSimbolo = "SEM_TIPO";
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			ponteiros_opcionais();
			setState(174);
			((IdentificadorContext)_localctx).v1 = match(IDENT);
			setState(175);
			dimensao();
			setState(176);
			((IdentificadorContext)_localctx).v2 = outros_ident();

			        // essa regra se for um registro então é retornado uma string com o nome do identificador '.' atributo
			        // são os casos de por exemplo pessoa.nome tipo=pessoa, variavel do tipo = nome
			        // a concatenação do ponto será feita na regra outros_ident
			        _localctx.txt += (((IdentificadorContext)_localctx).v1!=null?((IdentificadorContext)_localctx).v1.getText():null)+((IdentificadorContext)_localctx).v2.txt;
			        ((IdentificadorContext)_localctx).linha =  ((IdentificadorContext)_localctx).v1.getLine();
			        ((IdentificadorContext)_localctx).tipoSimbolo =  pilhaDeTabelas.topo().GetTipoSimbolo(_localctx.txt); //error
			    
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

	public static class Ponteiros_opcionaisContext extends ParserRuleContext {
		public List<TerminalNode> EXPOENTE() { return getTokens(LAParser.EXPOENTE); }
		public TerminalNode EXPOENTE(int i) {
			return getToken(LAParser.EXPOENTE, i);
		}
		public Ponteiros_opcionaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ponteiros_opcionais; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterPonteiros_opcionais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitPonteiros_opcionais(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitPonteiros_opcionais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ponteiros_opcionaisContext ponteiros_opcionais() throws RecognitionException {
		Ponteiros_opcionaisContext _localctx = new Ponteiros_opcionaisContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ponteiros_opcionais);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXPOENTE) {
				{
				{
				setState(179);
				match(EXPOENTE);
				}
				}
				setState(184);
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

	public static class Outros_identContext extends ParserRuleContext {
		public String txt;
		public IdentificadorContext id;
		public TerminalNode PONTO() { return getToken(LAParser.PONTO, 0); }
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public Outros_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutros_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutros_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutros_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_identContext outros_ident() throws RecognitionException {
		Outros_identContext _localctx = new Outros_identContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_outros_ident);
		((Outros_identContext)_localctx).txt = "";
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_la = _input.LA(1);
			if (_la==PONTO) {
				{
				setState(185);
				match(PONTO);
				setState(186);
				((Outros_identContext)_localctx).id = identificador();
				 ((Outros_identContext)_localctx).txt =  "."+((Outros_identContext)_localctx).id.txt; 
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

	public static class DimensaoContext extends ParserRuleContext {
		public String txt;
		public Exp_aritmeticaContext v1;
		public List<TerminalNode> ABRE_COLCHETE() { return getTokens(LAParser.ABRE_COLCHETE); }
		public TerminalNode ABRE_COLCHETE(int i) {
			return getToken(LAParser.ABRE_COLCHETE, i);
		}
		public List<TerminalNode> FECHA_COLCHETE() { return getTokens(LAParser.FECHA_COLCHETE); }
		public TerminalNode FECHA_COLCHETE(int i) {
			return getToken(LAParser.FECHA_COLCHETE, i);
		}
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public DimensaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimensao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDimensao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDimensao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDimensao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensaoContext dimensao() throws RecognitionException {
		DimensaoContext _localctx = new DimensaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dimensao);
		((DimensaoContext)_localctx).txt = "";
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(191);
					match(ABRE_COLCHETE);
					setState(192);
					((DimensaoContext)_localctx).v1 = exp_aritmetica();
					setState(193);
					match(FECHA_COLCHETE);
					((DimensaoContext)_localctx).txt =  "[" + ((DimensaoContext)_localctx).v1.txt + "]";
					}
					} 
				}
				setState(200);
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
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public String tipo_registro;
		public String tipoSimbolo;
		public List<String> nomes;
		public RegistroContext v1;
		public RegistroContext registro;
		public Tipo_estendidoContext tipo_estendido;
		public RegistroContext registro() {
			return getRuleContext(RegistroContext.class,0);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TipoContext(ParserRuleContext parent, int invokingState, String tipo_registro) {
			super(parent, invokingState);
			this.tipo_registro = tipo_registro;
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo(String tipo_registro) throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState(), tipo_registro);
		enterRule(_localctx, 20, RULE_tipo);
		((TipoContext)_localctx).tipoSimbolo = ""; ((TipoContext)_localctx).nomes =  new ArrayList<String>();
		try {
			setState(207);
			switch (_input.LA(1)) {
			case REGISTRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				((TipoContext)_localctx).v1 = ((TipoContext)_localctx).registro = registro(_localctx.tipo_registro);
				((TipoContext)_localctx).tipoSimbolo = ((TipoContext)_localctx).v1.typeRegistro; _localctx.nomes.addAll(((TipoContext)_localctx).registro.nomes);
				}
				break;
			case EXPOENTE:
			case LITERAL:
			case INTEIRO:
			case REAL:
			case LOGICO:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				((TipoContext)_localctx).tipo_estendido = tipo_estendido();
				((TipoContext)_localctx).tipoSimbolo =  ((TipoContext)_localctx).tipo_estendido.tipoSimbolo;
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

	public static class Mais_identContext extends ParserRuleContext {
		public List<String> nomes;
		public int linha;
		public IdentificadorContext v1;
		public Mais_identContext v2;
		public TerminalNode VIRGULA() { return getToken(LAParser.VIRGULA, 0); }
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public Mais_identContext mais_ident() {
			return getRuleContext(Mais_identContext.class,0);
		}
		public Mais_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_identContext mais_ident() throws RecognitionException {
		Mais_identContext _localctx = new Mais_identContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mais_ident);
		((Mais_identContext)_localctx).nomes =  new ArrayList<String>(); ((Mais_identContext)_localctx).linha = -1;
		try {
			setState(215);
			switch (_input.LA(1)) {
			case VIRGULA:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(VIRGULA);
				setState(210);
				((Mais_identContext)_localctx).v1 = identificador();
				setState(211);
				((Mais_identContext)_localctx).v2 = mais_ident();

				       _localctx.nomes.add(((Mais_identContext)_localctx).v1.txt);
				       _localctx.nomes.addAll(((Mais_identContext)_localctx).v2.nomes);
				       ((Mais_identContext)_localctx).linha = ((Mais_identContext)_localctx).v1.linha;
				      
				}
				break;
			case DOIS_PONTOS:
			case FECHA_PARENTESIS:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Mais_variaveisContext extends ParserRuleContext {
		public List<String> nomes;
		public String tipoSimbolo;
		public int linha;
		public VariavelContext variavel;
		public Mais_variaveisContext f1;
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public Mais_variaveisContext mais_variaveis() {
			return getRuleContext(Mais_variaveisContext.class,0);
		}
		public Mais_variaveisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_variaveis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_variaveis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_variaveis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_variaveis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_variaveisContext mais_variaveis() throws RecognitionException {
		Mais_variaveisContext _localctx = new Mais_variaveisContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_mais_variaveis);
		((Mais_variaveisContext)_localctx).nomes =  new ArrayList<String>(); ((Mais_variaveisContext)_localctx).tipoSimbolo = ""; ((Mais_variaveisContext)_localctx).linha = -1;
		try {
			setState(222);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				((Mais_variaveisContext)_localctx).variavel = variavel();
				setState(218);
				((Mais_variaveisContext)_localctx).f1 = mais_variaveis();
				 
				         _localctx.nomes.addAll(((Mais_variaveisContext)_localctx).variavel.nomes); 
				         ((Mais_variaveisContext)_localctx).tipoSimbolo = ((Mais_variaveisContext)_localctx).variavel.tipoSimbolo; 
				         ((Mais_variaveisContext)_localctx).linha = ((Mais_variaveisContext)_localctx).variavel.linha; 
				         _localctx.nomes.addAll(((Mais_variaveisContext)_localctx).f1.nomes);
				    
				}
				break;
			case FIM_REGISTRO:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Tipo_basicoContext extends ParserRuleContext {
		public String tipoSimbolo;
		public TerminalNode LITERAL() { return getToken(LAParser.LITERAL, 0); }
		public TerminalNode INTEIRO() { return getToken(LAParser.INTEIRO, 0); }
		public TerminalNode REAL() { return getToken(LAParser.REAL, 0); }
		public TerminalNode LOGICO() { return getToken(LAParser.LOGICO, 0); }
		public Tipo_basicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo_basico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo_basico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo_basico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basicoContext tipo_basico() throws RecognitionException {
		Tipo_basicoContext _localctx = new Tipo_basicoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tipo_basico);
		((Tipo_basicoContext)_localctx).tipoSimbolo = "";
		try {
			setState(232);
			switch (_input.LA(1)) {
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				match(LITERAL);
				((Tipo_basicoContext)_localctx).tipoSimbolo =  "literal";
				}
				break;
			case INTEIRO:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(INTEIRO);
				((Tipo_basicoContext)_localctx).tipoSimbolo =  "inteiro";
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
				match(REAL);
				((Tipo_basicoContext)_localctx).tipoSimbolo =  "real";
				}
				break;
			case LOGICO:
				enterOuterAlt(_localctx, 4);
				{
				setState(230);
				match(LOGICO);
				((Tipo_basicoContext)_localctx).tipoSimbolo =  "logico";
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

	public static class Tipo_basico_identContext extends ParserRuleContext {
		public String tipoSimbolo;
		public Tipo_basicoContext v1;
		public Token v2;
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Tipo_basico_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo_basico_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo_basico_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo_basico_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basico_identContext tipo_basico_ident() throws RecognitionException {
		Tipo_basico_identContext _localctx = new Tipo_basico_identContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tipo_basico_ident);
		((Tipo_basico_identContext)_localctx).tipoSimbolo = "";
		try {
			setState(239);
			switch (_input.LA(1)) {
			case LITERAL:
			case INTEIRO:
			case REAL:
			case LOGICO:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				((Tipo_basico_identContext)_localctx).v1 = tipo_basico();
				((Tipo_basico_identContext)_localctx).tipoSimbolo =  ((Tipo_basico_identContext)_localctx).v1.tipoSimbolo;
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				((Tipo_basico_identContext)_localctx).v2 = match(IDENT);
				((Tipo_basico_identContext)_localctx).tipoSimbolo =  ((Tipo_basico_identContext)_localctx).v2.getText();
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

	public static class Tipo_estendidoContext extends ParserRuleContext {
		public String tipoSimbolo;
		public Tipo_basico_identContext v1;
		public Ponteiros_opcionaisContext ponteiros_opcionais() {
			return getRuleContext(Ponteiros_opcionaisContext.class,0);
		}
		public Tipo_basico_identContext tipo_basico_ident() {
			return getRuleContext(Tipo_basico_identContext.class,0);
		}
		public Tipo_estendidoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_estendido; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo_estendido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo_estendido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo_estendido(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_estendidoContext tipo_estendido() throws RecognitionException {
		Tipo_estendidoContext _localctx = new Tipo_estendidoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tipo_estendido);
		((Tipo_estendidoContext)_localctx).tipoSimbolo = "";
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			ponteiros_opcionais();
			setState(242);
			((Tipo_estendidoContext)_localctx).v1 = tipo_basico_ident();
			((Tipo_estendidoContext)_localctx).tipoSimbolo =  ((Tipo_estendidoContext)_localctx).v1.tipoSimbolo;
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

	public static class Valor_constanteContext extends ParserRuleContext {
		public TerminalNode CADEIA() { return getToken(LAParser.CADEIA, 0); }
		public TerminalNode N_INTEIRO() { return getToken(LAParser.N_INTEIRO, 0); }
		public TerminalNode N_REAL() { return getToken(LAParser.N_REAL, 0); }
		public TerminalNode VERDADEIRO() { return getToken(LAParser.VERDADEIRO, 0); }
		public TerminalNode FALSO() { return getToken(LAParser.FALSO, 0); }
		public Valor_constanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor_constante; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterValor_constante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitValor_constante(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitValor_constante(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valor_constanteContext valor_constante() throws RecognitionException {
		Valor_constanteContext _localctx = new Valor_constanteContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_valor_constante);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VERDADEIRO) | (1L << FALSO) | (1L << CADEIA) | (1L << N_INTEIRO) | (1L << N_REAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class RegistroContext extends ParserRuleContext {
		public String nome_registro;
		public String typeRegistro;
		public List<String> nomes;
		public VariavelContext variavel;
		public Mais_variaveisContext mais_variaveis;
		public TerminalNode REGISTRO() { return getToken(LAParser.REGISTRO, 0); }
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public Mais_variaveisContext mais_variaveis() {
			return getRuleContext(Mais_variaveisContext.class,0);
		}
		public TerminalNode FIM_REGISTRO() { return getToken(LAParser.FIM_REGISTRO, 0); }
		public RegistroContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RegistroContext(ParserRuleContext parent, int invokingState, String nome_registro) {
			super(parent, invokingState);
			this.nome_registro = nome_registro;
		}
		@Override public int getRuleIndex() { return RULE_registro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterRegistro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitRegistro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitRegistro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegistroContext registro(String nome_registro) throws RecognitionException {
		RegistroContext _localctx = new RegistroContext(_ctx, getState(), nome_registro);
		enterRule(_localctx, 34, RULE_registro);
		((RegistroContext)_localctx).nomes =  new ArrayList<String>();
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(REGISTRO);

			        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("registro"));
			        if(!_localctx.nome_registro.equals(""))
			            tabelaRegistros.empilhar(new TabelaDeSimbolos(_localctx.nome_registro));
			        else
			            tabelaRegistros.empilhar(new TabelaDeSimbolos("registro"));
			    
			setState(249);
			((RegistroContext)_localctx).variavel = variavel();
			setState(250);
			((RegistroContext)_localctx).mais_variaveis = mais_variaveis();

			        for (String s : ((RegistroContext)_localctx).variavel.nomes)
			        {
			            tabelaRegistros.topo().adicionarSimbolo(s, ((RegistroContext)_localctx).variavel.tipoSimbolo);
			            _localctx.nomes.add(s);
			        }
			        for (String u : ((RegistroContext)_localctx).mais_variaveis.nomes)
			        {
			            //msg_error+=u+"\n";
			            tabelaRegistros.topo().adicionarSimbolo(u, ((RegistroContext)_localctx).mais_variaveis.tipoSimbolo);
			            _localctx.nomes.add(u);
			        }
			        
			        ((RegistroContext)_localctx).typeRegistro = ((RegistroContext)_localctx).variavel.tipoSimbolo;
			    
			setState(252);
			match(FIM_REGISTRO);

			        pilhaDeTabelas.desempilhar();
			    
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

	public static class Declaracao_globalContext extends ParserRuleContext {
		public Token v1;
		public Tipo_estendidoContext g1;
		public TerminalNode PROCEDIMENTO() { return getToken(LAParser.PROCEDIMENTO, 0); }
		public TerminalNode ABRE_PARENTESIS() { return getToken(LAParser.ABRE_PARENTESIS, 0); }
		public Parametros_opcionalContext parametros_opcional() {
			return getRuleContext(Parametros_opcionalContext.class,0);
		}
		public TerminalNode FECHA_PARENTESIS() { return getToken(LAParser.FECHA_PARENTESIS, 0); }
		public Declaracoes_locaisContext declaracoes_locais() {
			return getRuleContext(Declaracoes_locaisContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public TerminalNode FIM_PROCEDIMENTO() { return getToken(LAParser.FIM_PROCEDIMENTO, 0); }
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public TerminalNode FUNCAO() { return getToken(LAParser.FUNCAO, 0); }
		public TerminalNode DOIS_PONTOS() { return getToken(LAParser.DOIS_PONTOS, 0); }
		public TerminalNode FIM_FUNCAO() { return getToken(LAParser.FIM_FUNCAO, 0); }
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public Declaracao_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracao_global(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracao_global(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracao_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_globalContext declaracao_global() throws RecognitionException {
		Declaracao_globalContext _localctx = new Declaracao_globalContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_declaracao_global);
		try {
			setState(279);
			switch (_input.LA(1)) {
			case PROCEDIMENTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				match(PROCEDIMENTO);
				setState(256);
				((Declaracao_globalContext)_localctx).v1 = match(IDENT);

				        if(pilhaDeTabelas.topo().existeSimbolo(((Declaracao_globalContext)_localctx).v1.getText()))
				            msg_error += "Linha " + ((Declaracao_globalContext)_localctx).v1.getLine() + ": identificador "+((Declaracao_globalContext)_localctx).v1.getText()+" ja declarado anteriormente\n" ;
				        else
				        {
				            pilhaDeTabelas.topo().adicionarSimbolo(((Declaracao_globalContext)_localctx).v1.getText(), "procedimento");
				            pilhaDeTabelas.empilhar(new TabelaDeSimbolos("procedimento"));
				        }
				       
				    
				setState(258);
				match(ABRE_PARENTESIS);
				setState(259);
				parametros_opcional();
				setState(260);
				match(FECHA_PARENTESIS);
				setState(261);
				declaracoes_locais();
				setState(262);
				comandos();
				setState(263);
				match(FIM_PROCEDIMENTO);
				    
				        pilhaDeTabelas.desempilhar();
				    
				}
				break;
			case FUNCAO:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(FUNCAO);
				setState(267);
				((Declaracao_globalContext)_localctx).v1 = match(IDENT);

				        if(pilhaDeTabelas.topo().existeSimbolo(((Declaracao_globalContext)_localctx).v1.getText()))
				            msg_error += "Linha " + ((Declaracao_globalContext)_localctx).v1.getLine() + ": identificador "+((Declaracao_globalContext)_localctx).v1.getText()+" ja declarado anteriormente\n" ;
				        else
				        {
				            pilhaDeTabelas.empilhar(new TabelaDeSimbolos("funcao"));
				        }
				    
				setState(269);
				match(ABRE_PARENTESIS);
				setState(270);
				parametros_opcional();
				setState(271);
				match(FECHA_PARENTESIS);
				setState(272);
				match(DOIS_PONTOS);
				setState(273);
				((Declaracao_globalContext)_localctx).g1 = tipo_estendido();
				setState(274);
				declaracoes_locais();
				setState(275);
				comandos();
				setState(276);
				match(FIM_FUNCAO);

				        pilhaDeTabelas.desempilhar();
				        pilhaDeTabelas.topo().adicionarSimbolo(((Declaracao_globalContext)_localctx).v1.getText(), ((Declaracao_globalContext)_localctx).g1.tipoSimbolo);
				        
				    
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

	public static class Parametros_opcionalContext extends ParserRuleContext {
		public ParametroContext parametro() {
			return getRuleContext(ParametroContext.class,0);
		}
		public Parametros_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParametros_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParametros_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParametros_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parametros_opcionalContext parametros_opcional() throws RecognitionException {
		Parametros_opcionalContext _localctx = new Parametros_opcionalContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_parametros_opcional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPOENTE) | (1L << VAR) | (1L << IDENT))) != 0)) {
				{
				setState(281);
				parametro();
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

	public static class ParametroContext extends ParserRuleContext {
		public IdentificadorContext v1;
		public Mais_identContext v3;
		public Tipo_estendidoContext v2;
		public Var_opcionalContext var_opcional() {
			return getRuleContext(Var_opcionalContext.class,0);
		}
		public TerminalNode DOIS_PONTOS() { return getToken(LAParser.DOIS_PONTOS, 0); }
		public Mais_parametrosContext mais_parametros() {
			return getRuleContext(Mais_parametrosContext.class,0);
		}
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public Mais_identContext mais_ident() {
			return getRuleContext(Mais_identContext.class,0);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParametro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			var_opcional();
			setState(285);
			((ParametroContext)_localctx).v1 = identificador();
			setState(286);
			((ParametroContext)_localctx).v3 = mais_ident();
			setState(287);
			match(DOIS_PONTOS);
			setState(288);
			((ParametroContext)_localctx).v2 = tipo_estendido();
			setState(289);
			mais_parametros();

			        if(pilhaDeTabelas.topo().existeSimbolo(((ParametroContext)_localctx).v1.txt))
			            msg_error += "Linha " + ((ParametroContext)_localctx).v1.linha + ": identificador "+((ParametroContext)_localctx).v1.txt+" ja declarado anteriormente\n" ;
			        else
			        {
			             pilhaDeTabelas.topo().adicionarSimbolo(((ParametroContext)_localctx).v1.txt, ((ParametroContext)_localctx).v2.tipoSimbolo);

			             if(tabelaRegistros.existeTabela(((ParametroContext)_localctx).v2.tipoSimbolo)!=null)
			             {
			                 TabelaDeSimbolos tabela_registro = tabelaRegistros.existeTabela(((ParametroContext)_localctx).v2.tipoSimbolo);
			                 for (String t : tabela_registro.getSimbolos())
			                 {
			                     pilhaDeTabelas.topo().adicionarSimbolo(((ParametroContext)_localctx).v1.txt+t, ((ParametroContext)_localctx).v2.tipoSimbolo);
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

	public static class Var_opcionalContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LAParser.VAR, 0); }
		public Var_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterVar_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitVar_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitVar_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_opcionalContext var_opcional() throws RecognitionException {
		Var_opcionalContext _localctx = new Var_opcionalContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_var_opcional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(292);
				match(VAR);
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

	public static class Mais_parametrosContext extends ParserRuleContext {
		public ParametroContext v1;
		public TerminalNode VIRGULA() { return getToken(LAParser.VIRGULA, 0); }
		public ParametroContext parametro() {
			return getRuleContext(ParametroContext.class,0);
		}
		public Mais_parametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_parametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_parametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_parametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_parametrosContext mais_parametros() throws RecognitionException {
		Mais_parametrosContext _localctx = new Mais_parametrosContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mais_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			_la = _input.LA(1);
			if (_la==VIRGULA) {
				{
				setState(295);
				match(VIRGULA);
				setState(296);
				((Mais_parametrosContext)_localctx).v1 = parametro();
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

	public static class Declaracoes_locaisContext extends ParserRuleContext {
		public List<Declaracao_localContext> declaracao_local() {
			return getRuleContexts(Declaracao_localContext.class);
		}
		public Declaracao_localContext declaracao_local(int i) {
			return getRuleContext(Declaracao_localContext.class,i);
		}
		public Declaracoes_locaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes_locais; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracoes_locais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracoes_locais(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracoes_locais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracoes_locaisContext declaracoes_locais() throws RecognitionException {
		Declaracoes_locaisContext _localctx = new Declaracoes_locaisContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_declaracoes_locais);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECLARE) | (1L << CONSTANTE) | (1L << TIPO))) != 0)) {
				{
				{
				setState(299);
				declaracao_local();
				}
				}
				setState(304);
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

	public static class CorpoContext extends ParserRuleContext {
		public Declaracoes_locaisContext declaracoes_locais() {
			return getRuleContext(Declaracoes_locaisContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCorpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCorpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_corpo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			declaracoes_locais();
			setState(306);
			comandos();
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

	public static class ComandosContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitComandos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitComandos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_comandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPOENTE) | (1L << LEIA) | (1L << ESCREVA) | (1L << SE) | (1L << CASO) | (1L << PARA) | (1L << FACA) | (1L << ENQUANTO) | (1L << RETORNE) | (1L << IDENT))) != 0)) {
				{
				{
				setState(308);
				cmd();
				}
				}
				setState(313);
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

	public static class CmdContext extends ParserRuleContext {
		public String tipoCmd;
		public IdentificadorContext v10;
		public Mais_identContext v11;
		public Token v2;
		public Outros_identContext v5;
		public ExpressaoContext v6;
		public Token v3;
		public Token v4;
		public TerminalNode LEIA() { return getToken(LAParser.LEIA, 0); }
		public TerminalNode ABRE_PARENTESIS() { return getToken(LAParser.ABRE_PARENTESIS, 0); }
		public TerminalNode FECHA_PARENTESIS() { return getToken(LAParser.FECHA_PARENTESIS, 0); }
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public Mais_identContext mais_ident() {
			return getRuleContext(Mais_identContext.class,0);
		}
		public TerminalNode ESCREVA() { return getToken(LAParser.ESCREVA, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Mais_expressaoContext mais_expressao() {
			return getRuleContext(Mais_expressaoContext.class,0);
		}
		public TerminalNode SE() { return getToken(LAParser.SE, 0); }
		public TerminalNode ENTAO() { return getToken(LAParser.ENTAO, 0); }
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Senao_opcionalContext senao_opcional() {
			return getRuleContext(Senao_opcionalContext.class,0);
		}
		public TerminalNode FIM_SE() { return getToken(LAParser.FIM_SE, 0); }
		public TerminalNode CASO() { return getToken(LAParser.CASO, 0); }
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public TerminalNode SEJA() { return getToken(LAParser.SEJA, 0); }
		public SelecaoContext selecao() {
			return getRuleContext(SelecaoContext.class,0);
		}
		public TerminalNode FIM_CASO() { return getToken(LAParser.FIM_CASO, 0); }
		public TerminalNode PARA() { return getToken(LAParser.PARA, 0); }
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public TerminalNode ATRIBUICAO() { return getToken(LAParser.ATRIBUICAO, 0); }
		public TerminalNode ATE() { return getToken(LAParser.ATE, 0); }
		public TerminalNode FACA() { return getToken(LAParser.FACA, 0); }
		public TerminalNode FIM_PARA() { return getToken(LAParser.FIM_PARA, 0); }
		public TerminalNode ENQUANTO() { return getToken(LAParser.ENQUANTO, 0); }
		public TerminalNode FIM_ENQUANTO() { return getToken(LAParser.FIM_ENQUANTO, 0); }
		public TerminalNode EXPOENTE() { return getToken(LAParser.EXPOENTE, 0); }
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public Chamada_atribuicaoContext chamada_atribuicao() {
			return getRuleContext(Chamada_atribuicaoContext.class,0);
		}
		public TerminalNode RETORNE() { return getToken(LAParser.RETORNE, 0); }
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_cmd);
		((CmdContext)_localctx).tipoCmd = "";
		try {
			setState(386);
			switch (_input.LA(1)) {
			case LEIA:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				match(LEIA);
				setState(315);
				match(ABRE_PARENTESIS);
				setState(316);
				((CmdContext)_localctx).v10 = identificador();
				setState(317);
				((CmdContext)_localctx).v11 = mais_ident();
				    
				         if(!pilhaDeTabelas.existeSimbolo(((CmdContext)_localctx).v10.txt))
				             msg_error+="Linha " + ((CmdContext)_localctx).v10.linha + ": identificador " + ((CmdContext)_localctx).v10.txt + " nao declarado\n";
				         for (String s : ((CmdContext)_localctx).v11.nomes)
				         {
				             if(!pilhaDeTabelas.existeSimbolo(s))
				                 msg_error+="Linha " + ((CmdContext)_localctx).v10.linha + ": identificador " + s + " nao declarado\n";
				         }    
				    
				setState(319);
				match(FECHA_PARENTESIS);
				 ((CmdContext)_localctx).tipoCmd =  "leia"; 
				}
				break;
			case ESCREVA:
				enterOuterAlt(_localctx, 2);
				{
				setState(322);
				match(ESCREVA);
				setState(323);
				match(ABRE_PARENTESIS);
				setState(324);
				expressao();
				setState(325);
				mais_expressao();
				setState(326);
				match(FECHA_PARENTESIS);
				((CmdContext)_localctx).tipoCmd = "escreva";
				}
				break;
			case SE:
				enterOuterAlt(_localctx, 3);
				{
				setState(329);
				match(SE);
				setState(330);
				expressao();
				setState(331);
				match(ENTAO);
				setState(332);
				comandos();
				setState(333);
				senao_opcional();
				setState(334);
				match(FIM_SE);
				 ((CmdContext)_localctx).tipoCmd =  "se"; 
				}
				break;
			case CASO:
				enterOuterAlt(_localctx, 4);
				{
				setState(337);
				match(CASO);
				setState(338);
				exp_aritmetica();
				setState(339);
				match(SEJA);
				setState(340);
				selecao();
				setState(341);
				senao_opcional();
				setState(342);
				match(FIM_CASO);
				 ((CmdContext)_localctx).tipoCmd =  "caso"; 
				}
				break;
			case PARA:
				enterOuterAlt(_localctx, 5);
				{
				setState(345);
				match(PARA);
				setState(346);
				match(IDENT);
				setState(347);
				match(ATRIBUICAO);
				setState(348);
				exp_aritmetica();
				setState(349);
				match(ATE);
				setState(350);
				exp_aritmetica();
				setState(351);
				match(FACA);
				setState(352);
				comandos();
				setState(353);
				match(FIM_PARA);
				 ((CmdContext)_localctx).tipoCmd =  "para"; 
				}
				break;
			case ENQUANTO:
				enterOuterAlt(_localctx, 6);
				{
				setState(356);
				match(ENQUANTO);
				setState(357);
				expressao();
				setState(358);
				match(FACA);
				setState(359);
				comandos();
				setState(360);
				match(FIM_ENQUANTO);
				 ((CmdContext)_localctx).tipoCmd =  "enquanto"; 
				}
				break;
			case FACA:
				enterOuterAlt(_localctx, 7);
				{
				setState(363);
				match(FACA);
				setState(364);
				comandos();
				setState(365);
				match(ATE);
				setState(366);
				expressao();
				 ((CmdContext)_localctx).tipoCmd =  "faca"; 
				}
				break;
			case EXPOENTE:
				enterOuterAlt(_localctx, 8);
				{
				setState(369);
				match(EXPOENTE);
				setState(370);
				((CmdContext)_localctx).v2 = match(IDENT);
				setState(371);
				((CmdContext)_localctx).v5 = outros_ident();
				setState(372);
				dimensao();
				setState(373);
				match(ATRIBUICAO);
				setState(374);
				((CmdContext)_localctx).v6 = expressao();
				 ((CmdContext)_localctx).tipoCmd =  "expoente"; 

				        String tipo_expressao = ((CmdContext)_localctx).v6.tipoSimbolo;
				        String tipo_ident = pilhaDeTabelas.topo().GetTipoSimbolo(((CmdContext)_localctx).v2.getText());
				        if(!tipo_expressao.equals(tipo_ident))
				            msg_error+="Linha " + ((CmdContext)_localctx).v2.getLine() + ": atribuicao nao compativel para ^" + ((CmdContext)_localctx).v2.getText()+((CmdContext)_localctx).v5.txt + "\n";
				       
				    
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 9);
				{
				setState(378);
				((CmdContext)_localctx).v3 = match(IDENT);
				setState(379);
				chamada_atribuicao((((CmdContext)_localctx).v3!=null?((CmdContext)_localctx).v3.getText():null));

				          if(!pilhaDeTabelas.existeSimbolo(((CmdContext)_localctx).v3.getText()))
				              msg_error+="Linha " + ((CmdContext)_localctx).v3.getLine() + ": identificador " + ((CmdContext)_localctx).v3.getText() + " nao declarado\n";
				          //Verificação para ver se o simbolo já foi declarado anteriormente.

				      
				}
				break;
			case RETORNE:
				enterOuterAlt(_localctx, 10);
				{
				setState(382);
				((CmdContext)_localctx).v4 = match(RETORNE);
				setState(383);
				expressao();

				        String escopoAtual=pilhaDeTabelas.topo().getEscopo();
				        if(escopoAtual.equals("funcao")==false){
				            msg_error+="Linha " + ((CmdContext)_localctx).v4.getLine() + ": comando retorne nao permitido nesse escopo\n";
				      
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

	public static class Mais_expressaoContext extends ParserRuleContext {
		public String tipoSimbolo;
		public ExpressaoContext v1;
		public Mais_expressaoContext v2;
		public TerminalNode VIRGULA() { return getToken(LAParser.VIRGULA, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Mais_expressaoContext mais_expressao() {
			return getRuleContext(Mais_expressaoContext.class,0);
		}
		public Mais_expressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_expressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_expressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_expressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_expressaoContext mais_expressao() throws RecognitionException {
		Mais_expressaoContext _localctx = new Mais_expressaoContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_mais_expressao);
		((Mais_expressaoContext)_localctx).tipoSimbolo = "SEM_TIPO";
		try {
			setState(394);
			switch (_input.LA(1)) {
			case VIRGULA:
				enterOuterAlt(_localctx, 1);
				{
				setState(388);
				match(VIRGULA);
				setState(389);
				((Mais_expressaoContext)_localctx).v1 = expressao();
				setState(390);
				((Mais_expressaoContext)_localctx).v2 = mais_expressao();

				     if(((Mais_expressaoContext)_localctx).v2.tipoSimbolo.equals("SEM_TIPO"))
				        ((Mais_expressaoContext)_localctx).tipoSimbolo = ((Mais_expressaoContext)_localctx).v1.tipoSimbolo;
				     else
				     {
				      if(((Mais_expressaoContext)_localctx).v1.tipoSimbolo.equals(((Mais_expressaoContext)_localctx).v2.tipoSimbolo) || ((Mais_expressaoContext)_localctx).v1.tipoSimbolo.equals("inteiro") && ((Mais_expressaoContext)_localctx).v2.tipoSimbolo.equals("real") || ((Mais_expressaoContext)_localctx).v1.tipoSimbolo.equals("real") && ((Mais_expressaoContext)_localctx).v2.tipoSimbolo.equals("inteiro"))
				          ((Mais_expressaoContext)_localctx).tipoSimbolo = ((Mais_expressaoContext)_localctx).v1.tipoSimbolo;
				      else
				          ((Mais_expressaoContext)_localctx).tipoSimbolo = "incompativel";
				     }
				    
				}
				break;
			case FECHA_PARENTESIS:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Senao_opcionalContext extends ParserRuleContext {
		public TerminalNode SENAO() { return getToken(LAParser.SENAO, 0); }
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Senao_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_senao_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterSenao_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitSenao_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitSenao_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Senao_opcionalContext senao_opcional() throws RecognitionException {
		Senao_opcionalContext _localctx = new Senao_opcionalContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_senao_opcional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(396);
				match(SENAO);
				setState(397);
				comandos();
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

	public static class Chamada_atribuicaoContext extends ParserRuleContext {
		public String primeiroIdent;
		public Outros_identContext v1;
		public DimensaoContext d1;
		public Token v2;
		public ExpressaoContext e1;
		public TerminalNode ABRE_PARENTESIS() { return getToken(LAParser.ABRE_PARENTESIS, 0); }
		public Argumentos_opcionalContext argumentos_opcional() {
			return getRuleContext(Argumentos_opcionalContext.class,0);
		}
		public TerminalNode FECHA_PARENTESIS() { return getToken(LAParser.FECHA_PARENTESIS, 0); }
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public TerminalNode ATRIBUICAO() { return getToken(LAParser.ATRIBUICAO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Chamada_atribuicaoContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Chamada_atribuicaoContext(ParserRuleContext parent, int invokingState, String primeiroIdent) {
			super(parent, invokingState);
			this.primeiroIdent = primeiroIdent;
		}
		@Override public int getRuleIndex() { return RULE_chamada_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterChamada_atribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitChamada_atribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitChamada_atribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Chamada_atribuicaoContext chamada_atribuicao(String primeiroIdent) throws RecognitionException {
		Chamada_atribuicaoContext _localctx = new Chamada_atribuicaoContext(_ctx, getState(), primeiroIdent);
		enterRule(_localctx, 58, RULE_chamada_atribuicao);
		try {
			setState(410);
			switch (_input.LA(1)) {
			case ABRE_PARENTESIS:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				match(ABRE_PARENTESIS);
				setState(401);
				argumentos_opcional();
				setState(402);
				match(FECHA_PARENTESIS);
				}
				break;
			case ABRE_COLCHETE:
			case PONTO:
			case ATRIBUICAO:
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				((Chamada_atribuicaoContext)_localctx).v1 = outros_ident();
				setState(405);
				((Chamada_atribuicaoContext)_localctx).d1 = dimensao();
				setState(406);
				((Chamada_atribuicaoContext)_localctx).v2 = match(ATRIBUICAO);
				setState(407);
				((Chamada_atribuicaoContext)_localctx).e1 = expressao();

				        if(pilhaDeTabelas.existeSimbolo(_localctx.primeiroIdent+((Chamada_atribuicaoContext)_localctx).v1.txt))
				        {
				            String tipo1 = pilhaDeTabelas.topo().GetTipoSimbolo(_localctx.primeiroIdent+((Chamada_atribuicaoContext)_localctx).v1.txt);
				            String tipo2 = ((Chamada_atribuicaoContext)_localctx).e1.tipoSimbolo;
				            if(tipo1.equals(tipo2) || tipo1.equals("inteiro") && tipo2.equals("real") || tipo1.equals("real") && tipo2.equals("inteiro"))
				            {
				            }
				            else
				                msg_error+="Linha " + ((Chamada_atribuicaoContext)_localctx).v2.getLine() + ": atribuicao nao compativel para " + _localctx.primeiroIdent+((Chamada_atribuicaoContext)_localctx).v1.txt+((Chamada_atribuicaoContext)_localctx).d1.txt +"\n";
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

	public static class Argumentos_opcionalContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Mais_expressaoContext mais_expressao() {
			return getRuleContext(Mais_expressaoContext.class,0);
		}
		public Argumentos_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterArgumentos_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitArgumentos_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitArgumentos_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argumentos_opcionalContext argumentos_opcional() throws RecognitionException {
		Argumentos_opcionalContext _localctx = new Argumentos_opcionalContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_argumentos_opcional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPOENTE) | (1L << VERDADEIRO) | (1L << FALSO) | (1L << ABRE_PARENTESIS) | (1L << NAO) | (1L << SUBTRACAO) | (1L << OP_AND) | (1L << CADEIA) | (1L << IDENT) | (1L << N_INTEIRO) | (1L << N_REAL))) != 0)) {
				{
				setState(412);
				expressao();
				setState(413);
				mais_expressao();
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

	public static class SelecaoContext extends ParserRuleContext {
		public ConstantesContext constantes() {
			return getRuleContext(ConstantesContext.class,0);
		}
		public TerminalNode DOIS_PONTOS() { return getToken(LAParser.DOIS_PONTOS, 0); }
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Mais_selecaoContext mais_selecao() {
			return getRuleContext(Mais_selecaoContext.class,0);
		}
		public SelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterSelecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitSelecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitSelecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelecaoContext selecao() throws RecognitionException {
		SelecaoContext _localctx = new SelecaoContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_selecao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			constantes();
			setState(418);
			match(DOIS_PONTOS);
			setState(419);
			comandos();
			setState(420);
			mais_selecao();
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

	public static class Mais_selecaoContext extends ParserRuleContext {
		public SelecaoContext selecao() {
			return getRuleContext(SelecaoContext.class,0);
		}
		public Mais_selecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_selecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_selecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_selecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_selecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_selecaoContext mais_selecao() throws RecognitionException {
		Mais_selecaoContext _localctx = new Mais_selecaoContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_mais_selecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			_la = _input.LA(1);
			if (_la==SUBTRACAO || _la==N_INTEIRO) {
				{
				setState(422);
				selecao();
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

	public static class ConstantesContext extends ParserRuleContext {
		public Numero_intervaloContext numero_intervalo() {
			return getRuleContext(Numero_intervaloContext.class,0);
		}
		public Mais_constantesContext mais_constantes() {
			return getRuleContext(Mais_constantesContext.class,0);
		}
		public ConstantesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterConstantes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitConstantes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitConstantes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantesContext constantes() throws RecognitionException {
		ConstantesContext _localctx = new ConstantesContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_constantes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			numero_intervalo();
			setState(426);
			mais_constantes();
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

	public static class Mais_constantesContext extends ParserRuleContext {
		public TerminalNode VIRGULA() { return getToken(LAParser.VIRGULA, 0); }
		public ConstantesContext constantes() {
			return getRuleContext(ConstantesContext.class,0);
		}
		public Mais_constantesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_constantes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_constantes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_constantes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_constantes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_constantesContext mais_constantes() throws RecognitionException {
		Mais_constantesContext _localctx = new Mais_constantesContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_mais_constantes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			_la = _input.LA(1);
			if (_la==VIRGULA) {
				{
				setState(428);
				match(VIRGULA);
				setState(429);
				constantes();
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

	public static class Numero_intervaloContext extends ParserRuleContext {
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public TerminalNode N_INTEIRO() { return getToken(LAParser.N_INTEIRO, 0); }
		public Intervalo_opcionalContext intervalo_opcional() {
			return getRuleContext(Intervalo_opcionalContext.class,0);
		}
		public Numero_intervaloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numero_intervalo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterNumero_intervalo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitNumero_intervalo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitNumero_intervalo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numero_intervaloContext numero_intervalo() throws RecognitionException {
		Numero_intervaloContext _localctx = new Numero_intervaloContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_numero_intervalo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			op_unario();
			setState(433);
			match(N_INTEIRO);
			setState(434);
			intervalo_opcional();
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

	public static class Intervalo_opcionalContext extends ParserRuleContext {
		public TerminalNode PONTO_PONTO() { return getToken(LAParser.PONTO_PONTO, 0); }
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public TerminalNode N_INTEIRO() { return getToken(LAParser.N_INTEIRO, 0); }
		public Intervalo_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalo_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterIntervalo_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitIntervalo_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitIntervalo_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Intervalo_opcionalContext intervalo_opcional() throws RecognitionException {
		Intervalo_opcionalContext _localctx = new Intervalo_opcionalContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_intervalo_opcional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			_la = _input.LA(1);
			if (_la==PONTO_PONTO) {
				{
				setState(436);
				match(PONTO_PONTO);
				setState(437);
				op_unario();
				setState(438);
				match(N_INTEIRO);
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

	public static class Op_unarioContext extends ParserRuleContext {
		public TerminalNode SUBTRACAO() { return getToken(LAParser.SUBTRACAO, 0); }
		public Op_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_unarioContext op_unario() throws RecognitionException {
		Op_unarioContext _localctx = new Op_unarioContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_op_unario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			_la = _input.LA(1);
			if (_la==SUBTRACAO) {
				{
				setState(442);
				match(SUBTRACAO);
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

	public static class Exp_aritmeticaContext extends ParserRuleContext {
		public String tipoSimbolo;
		public String txt;
		public TermoContext v1;
		public Outros_termosContext v2;
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public Outros_termosContext outros_termos() {
			return getRuleContext(Outros_termosContext.class,0);
		}
		public Exp_aritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_aritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterExp_aritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitExp_aritmetica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExp_aritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_aritmeticaContext exp_aritmetica() throws RecognitionException {
		Exp_aritmeticaContext _localctx = new Exp_aritmeticaContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_exp_aritmetica);
		((Exp_aritmeticaContext)_localctx).tipoSimbolo = "SEM_TIPO"; ((Exp_aritmeticaContext)_localctx).txt = "";
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			((Exp_aritmeticaContext)_localctx).v1 = termo();
			setState(446);
			((Exp_aritmeticaContext)_localctx).v2 = outros_termos();

			        ((Exp_aritmeticaContext)_localctx).txt = ((Exp_aritmeticaContext)_localctx).v1.txt;
			        if(((Exp_aritmeticaContext)_localctx).v2.tipoSimbolo.equals("SEM_TIPO"))
			            ((Exp_aritmeticaContext)_localctx).tipoSimbolo = ((Exp_aritmeticaContext)_localctx).v1.tipoSimbolo;
			        else
			        {
			            if(((Exp_aritmeticaContext)_localctx).v1.tipoSimbolo.equals(((Exp_aritmeticaContext)_localctx).v2.tipoSimbolo) || ((Exp_aritmeticaContext)_localctx).v1.tipoSimbolo.equals("inteiro") && ((Exp_aritmeticaContext)_localctx).v2.tipoSimbolo.equals("real") || ((Exp_aritmeticaContext)_localctx).v1.tipoSimbolo.equals("real") && ((Exp_aritmeticaContext)_localctx).v2.tipoSimbolo.equals("inteiro"))
			                ((Exp_aritmeticaContext)_localctx).tipoSimbolo = ((Exp_aritmeticaContext)_localctx).v1.tipoSimbolo;
			            else
			                ((Exp_aritmeticaContext)_localctx).tipoSimbolo = "incompativel";
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

	public static class Op_multiplicacaoContext extends ParserRuleContext {
		public TerminalNode MULTIPLICACAO() { return getToken(LAParser.MULTIPLICACAO, 0); }
		public TerminalNode DIVISAO() { return getToken(LAParser.DIVISAO, 0); }
		public Op_multiplicacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_multiplicacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_multiplicacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_multiplicacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_multiplicacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_multiplicacaoContext op_multiplicacao() throws RecognitionException {
		Op_multiplicacaoContext _localctx = new Op_multiplicacaoContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_op_multiplicacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			_la = _input.LA(1);
			if ( !(_la==MULTIPLICACAO || _la==DIVISAO) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class Op_adicaoContext extends ParserRuleContext {
		public TerminalNode SOMA() { return getToken(LAParser.SOMA, 0); }
		public TerminalNode SUBTRACAO() { return getToken(LAParser.SUBTRACAO, 0); }
		public Op_adicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_adicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_adicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_adicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_adicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_adicaoContext op_adicao() throws RecognitionException {
		Op_adicaoContext _localctx = new Op_adicaoContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_op_adicao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_la = _input.LA(1);
			if ( !(_la==SOMA || _la==SUBTRACAO) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class TermoContext extends ParserRuleContext {
		public String tipoSimbolo;
		public String txt;
		public FatorContext v1;
		public Outros_fatoresContext outros_fatores() {
			return getRuleContext(Outros_fatoresContext.class,0);
		}
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTermo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_termo);
		((TermoContext)_localctx).tipoSimbolo = "SEM_TIPO"; ((TermoContext)_localctx).txt = "";
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			((TermoContext)_localctx).v1 = fator();
			setState(454);
			outros_fatores();
			 
			        ((TermoContext)_localctx).tipoSimbolo = ((TermoContext)_localctx).v1.tipoSimbolo; 
			        ((TermoContext)_localctx).txt = ((TermoContext)_localctx).v1.txt;
			    
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

	public static class Outros_termosContext extends ParserRuleContext {
		public String tipoSimbolo;
		public TermoContext v1;
		public Outros_termosContext v2;
		public Op_adicaoContext op_adicao() {
			return getRuleContext(Op_adicaoContext.class,0);
		}
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public Outros_termosContext outros_termos() {
			return getRuleContext(Outros_termosContext.class,0);
		}
		public Outros_termosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_termos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutros_termos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutros_termos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutros_termos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_termosContext outros_termos() throws RecognitionException {
		Outros_termosContext _localctx = new Outros_termosContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_outros_termos);
		((Outros_termosContext)_localctx).tipoSimbolo = "SEM_TIPO";
		try {
			setState(463);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(457);
				op_adicao();
				setState(458);
				((Outros_termosContext)_localctx).v1 = termo();
				setState(459);
				((Outros_termosContext)_localctx).v2 = outros_termos();

				        if(((Outros_termosContext)_localctx).v2.tipoSimbolo.equals("SEM_TIPO"))
				            ((Outros_termosContext)_localctx).tipoSimbolo = ((Outros_termosContext)_localctx).v1.tipoSimbolo;
				        else
				        {
				            if(((Outros_termosContext)_localctx).v1.tipoSimbolo.equals(((Outros_termosContext)_localctx).v2.tipoSimbolo) || ((Outros_termosContext)_localctx).v1.tipoSimbolo.equals("inteiro") && ((Outros_termosContext)_localctx).v2.tipoSimbolo.equals("real") || ((Outros_termosContext)_localctx).v1.tipoSimbolo.equals("real") && ((Outros_termosContext)_localctx).v2.tipoSimbolo.equals("inteiro"))
				                ((Outros_termosContext)_localctx).tipoSimbolo = ((Outros_termosContext)_localctx).v1.tipoSimbolo;
				            else
				                ((Outros_termosContext)_localctx).tipoSimbolo = "incompativel";
				        }
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class FatorContext extends ParserRuleContext {
		public String tipoSimbolo;
		public String txt;
		public ParcelaContext v1;
		public Outras_parcelasContext outras_parcelas() {
			return getRuleContext(Outras_parcelasContext.class,0);
		}
		public ParcelaContext parcela() {
			return getRuleContext(ParcelaContext.class,0);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitFator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitFator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_fator);
		((FatorContext)_localctx).tipoSimbolo = "SEM_TIPO"; ((FatorContext)_localctx).txt = "";
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			((FatorContext)_localctx).v1 = parcela();
			setState(466);
			outras_parcelas();

			        ((FatorContext)_localctx).tipoSimbolo = ((FatorContext)_localctx).v1.tipoSimbolo; 
			        ((FatorContext)_localctx).txt = ((FatorContext)_localctx).v1.txt;
			    
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

	public static class Outros_fatoresContext extends ParserRuleContext {
		public List<Op_multiplicacaoContext> op_multiplicacao() {
			return getRuleContexts(Op_multiplicacaoContext.class);
		}
		public Op_multiplicacaoContext op_multiplicacao(int i) {
			return getRuleContext(Op_multiplicacaoContext.class,i);
		}
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public Outros_fatoresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_fatores; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutros_fatores(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutros_fatores(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutros_fatores(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_fatoresContext outros_fatores() throws RecognitionException {
		Outros_fatoresContext _localctx = new Outros_fatoresContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_outros_fatores);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLICACAO || _la==DIVISAO) {
				{
				{
				setState(469);
				op_multiplicacao();
				setState(470);
				fator();
				}
				}
				setState(476);
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

	public static class ParcelaContext extends ParserRuleContext {
		public String tipoSimbolo;
		public String txt;
		public Parcela_unarioContext v1;
		public Parcela_nao_unarioContext v2;
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public Parcela_unarioContext parcela_unario() {
			return getRuleContext(Parcela_unarioContext.class,0);
		}
		public Parcela_nao_unarioContext parcela_nao_unario() {
			return getRuleContext(Parcela_nao_unarioContext.class,0);
		}
		public ParcelaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParcelaContext parcela() throws RecognitionException {
		ParcelaContext _localctx = new ParcelaContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_parcela);
		((ParcelaContext)_localctx).tipoSimbolo = "SEM_TIPO"; ((ParcelaContext)_localctx).txt = "";
		try {
			setState(484);
			switch (_input.LA(1)) {
			case EXPOENTE:
			case ABRE_PARENTESIS:
			case SUBTRACAO:
			case IDENT:
			case N_INTEIRO:
			case N_REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(477);
				op_unario();
				setState(478);
				((ParcelaContext)_localctx).v1 = parcela_unario();

				        ((ParcelaContext)_localctx).tipoSimbolo = ((ParcelaContext)_localctx).v1.tipoSimbolo; 
				        ((ParcelaContext)_localctx).txt = ((ParcelaContext)_localctx).v1.txt;
				    
				}
				break;
			case OP_AND:
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(481);
				((ParcelaContext)_localctx).v2 = parcela_nao_unario();

				        ((ParcelaContext)_localctx).tipoSimbolo = ((ParcelaContext)_localctx).v2.tipoSimbolo; 
				        ((ParcelaContext)_localctx).txt = ((ParcelaContext)_localctx).v2.txt;
				    
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

	public static class Parcela_unarioContext extends ParserRuleContext {
		public String txt;
		public int linha;
		public String tipoSimbolo;
		public Token v1;
		public Outros_identContext v2;
		public Token v3;
		public Chamada_partesContext v4;
		public Token N_INTEIRO;
		public Token N_REAL;
		public ExpressaoContext v7;
		public TerminalNode EXPOENTE() { return getToken(LAParser.EXPOENTE, 0); }
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public Chamada_partesContext chamada_partes() {
			return getRuleContext(Chamada_partesContext.class,0);
		}
		public TerminalNode N_INTEIRO() { return getToken(LAParser.N_INTEIRO, 0); }
		public TerminalNode N_REAL() { return getToken(LAParser.N_REAL, 0); }
		public TerminalNode ABRE_PARENTESIS() { return getToken(LAParser.ABRE_PARENTESIS, 0); }
		public TerminalNode FECHA_PARENTESIS() { return getToken(LAParser.FECHA_PARENTESIS, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Parcela_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_unarioContext parcela_unario() throws RecognitionException {
		Parcela_unarioContext _localctx = new Parcela_unarioContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_parcela_unario);
		((Parcela_unarioContext)_localctx).txt = ""; ((Parcela_unarioContext)_localctx).linha = -1; ((Parcela_unarioContext)_localctx).tipoSimbolo = "SEM_TIPO";
		try {
			setState(505);
			switch (_input.LA(1)) {
			case EXPOENTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(486);
				match(EXPOENTE);
				setState(487);
				((Parcela_unarioContext)_localctx).v1 = match(IDENT);
				setState(488);
				((Parcela_unarioContext)_localctx).v2 = outros_ident();
				setState(489);
				dimensao();
				 
				        _localctx.txt+=((Parcela_unarioContext)_localctx).v1.getText()+((Parcela_unarioContext)_localctx).v2.txt;
				        ((Parcela_unarioContext)_localctx).linha =  ((Parcela_unarioContext)_localctx).v1.getLine();
				       
				        if(!pilhaDeTabelas.existeSimbolo(((Parcela_unarioContext)_localctx).v1.getText()+((Parcela_unarioContext)_localctx).v2.txt))
				            msg_error+="Linha " + ((Parcela_unarioContext)_localctx).v1.getLine() + ": identificador " + ((Parcela_unarioContext)_localctx).v1.getText()+((Parcela_unarioContext)_localctx).v2.txt + " nao declarado\n";
				        if(((Parcela_unarioContext)_localctx).v2.txt.equals("")) 
				            ((Parcela_unarioContext)_localctx).tipoSimbolo =  pilhaDeTabelas.topo().GetTipoSimbolo(_localctx.txt);
				        else
				            ((Parcela_unarioContext)_localctx).tipoSimbolo =  tabelaRegistros.getTipoDoSimbolo(((Parcela_unarioContext)_localctx).v2.txt.substring(1));
				    
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(492);
				((Parcela_unarioContext)_localctx).v3 = match(IDENT);
				setState(493);
				((Parcela_unarioContext)_localctx).v4 = chamada_partes(((Parcela_unarioContext)_localctx).v3.getText());

				        _localctx.txt+=((Parcela_unarioContext)_localctx).v3.getText()+((Parcela_unarioContext)_localctx).v4.outrosIdent;
				        ((Parcela_unarioContext)_localctx).linha =  ((Parcela_unarioContext)_localctx).v3.getLine();
				        if(!pilhaDeTabelas.existeSimbolo(_localctx.txt))
				            msg_error+="Linha " + ((Parcela_unarioContext)_localctx).v3.getLine() + ": identificador " + _localctx.txt + " nao declarado\n";
				        else
				        {
				            if(((Parcela_unarioContext)_localctx).v4.tipoSimbolo.equals("SEM_TIPO"))
				                ((Parcela_unarioContext)_localctx).tipoSimbolo =  pilhaDeTabelas.topo().GetTipoSimbolo(_localctx.txt);
				            else
				                ((Parcela_unarioContext)_localctx).tipoSimbolo =  ((Parcela_unarioContext)_localctx).v4.tipoSimbolo;
				        }
				    
				}
				break;
			case N_INTEIRO:
				enterOuterAlt(_localctx, 3);
				{
				setState(496);
				((Parcela_unarioContext)_localctx).N_INTEIRO = match(N_INTEIRO);

				        ((Parcela_unarioContext)_localctx).tipoSimbolo =  "inteiro"; 
				        ((Parcela_unarioContext)_localctx).txt = ((Parcela_unarioContext)_localctx).N_INTEIRO.getText();
				    
				}
				break;
			case N_REAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(498);
				((Parcela_unarioContext)_localctx).N_REAL = match(N_REAL);
				  
				        ((Parcela_unarioContext)_localctx).tipoSimbolo =  "real"; 
				        ((Parcela_unarioContext)_localctx).txt = ((Parcela_unarioContext)_localctx).N_REAL.getText();
				    
				}
				break;
			case ABRE_PARENTESIS:
				enterOuterAlt(_localctx, 5);
				{
				setState(500);
				match(ABRE_PARENTESIS);
				setState(501);
				((Parcela_unarioContext)_localctx).v7 = expressao();
				setState(502);
				match(FECHA_PARENTESIS);

				        ((Parcela_unarioContext)_localctx).tipoSimbolo = ((Parcela_unarioContext)_localctx).v7.tipoSimbolo;
				    
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

	public static class Parcela_nao_unarioContext extends ParserRuleContext {
		public String txt;
		public int linha;
		public String tipoSimbolo;
		public Token v1;
		public Outros_identContext v2;
		public Token CADEIA;
		public TerminalNode OP_AND() { return getToken(LAParser.OP_AND, 0); }
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public TerminalNode CADEIA() { return getToken(LAParser.CADEIA, 0); }
		public Parcela_nao_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_nao_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela_nao_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela_nao_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_nao_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_nao_unarioContext parcela_nao_unario() throws RecognitionException {
		Parcela_nao_unarioContext _localctx = new Parcela_nao_unarioContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_parcela_nao_unario);
		((Parcela_nao_unarioContext)_localctx).txt = ""; ((Parcela_nao_unarioContext)_localctx).linha = -1; ((Parcela_nao_unarioContext)_localctx).tipoSimbolo = "SEM_TIPO";
		try {
			setState(515);
			switch (_input.LA(1)) {
			case OP_AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(507);
				match(OP_AND);
				setState(508);
				((Parcela_nao_unarioContext)_localctx).v1 = match(IDENT);
				setState(509);
				((Parcela_nao_unarioContext)_localctx).v2 = outros_ident();

				        _localctx.txt+=((Parcela_nao_unarioContext)_localctx).v1.getText(); 
				        ((Parcela_nao_unarioContext)_localctx).linha =  ((Parcela_nao_unarioContext)_localctx).v1.getLine();
				        _localctx.txt+= ((Parcela_nao_unarioContext)_localctx).v2.txt; ((Parcela_nao_unarioContext)_localctx).tipoSimbolo =  pilhaDeTabelas.getTipoDoSimbolo(_localctx.txt);
				    
				setState(511);
				dimensao();
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(513);
				((Parcela_nao_unarioContext)_localctx).CADEIA = match(CADEIA);

				        ((Parcela_nao_unarioContext)_localctx).tipoSimbolo =  "literal"; 
				        ((Parcela_nao_unarioContext)_localctx).txt = ((Parcela_nao_unarioContext)_localctx).CADEIA.getText();
				    
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

	public static class Outras_parcelasContext extends ParserRuleContext {
		public List<TerminalNode> PORCENTAGEM() { return getTokens(LAParser.PORCENTAGEM); }
		public TerminalNode PORCENTAGEM(int i) {
			return getToken(LAParser.PORCENTAGEM, i);
		}
		public List<ParcelaContext> parcela() {
			return getRuleContexts(ParcelaContext.class);
		}
		public ParcelaContext parcela(int i) {
			return getRuleContext(ParcelaContext.class,i);
		}
		public Outras_parcelasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outras_parcelas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutras_parcelas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutras_parcelas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutras_parcelas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outras_parcelasContext outras_parcelas() throws RecognitionException {
		Outras_parcelasContext _localctx = new Outras_parcelasContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_outras_parcelas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PORCENTAGEM) {
				{
				{
				setState(517);
				match(PORCENTAGEM);
				setState(518);
				parcela();
				}
				}
				setState(523);
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

	public static class Chamada_partesContext extends ParserRuleContext {
		public String primeiroIdent;
		public String tipoSimbolo;
		public String outrosIdent;
		public ExpressaoContext v1;
		public Mais_expressaoContext v2;
		public Outros_identContext v3;
		public TerminalNode ABRE_PARENTESIS() { return getToken(LAParser.ABRE_PARENTESIS, 0); }
		public TerminalNode FECHA_PARENTESIS() { return getToken(LAParser.FECHA_PARENTESIS, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Mais_expressaoContext mais_expressao() {
			return getRuleContext(Mais_expressaoContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public Chamada_partesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Chamada_partesContext(ParserRuleContext parent, int invokingState, String primeiroIdent) {
			super(parent, invokingState);
			this.primeiroIdent = primeiroIdent;
		}
		@Override public int getRuleIndex() { return RULE_chamada_partes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterChamada_partes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitChamada_partes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitChamada_partes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Chamada_partesContext chamada_partes(String primeiroIdent) throws RecognitionException {
		Chamada_partesContext _localctx = new Chamada_partesContext(_ctx, getState(), primeiroIdent);
		enterRule(_localctx, 98, RULE_chamada_partes);
		((Chamada_partesContext)_localctx).tipoSimbolo = "SEM_TIPO"; ((Chamada_partesContext)_localctx).outrosIdent = "";
		try {
			setState(534);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(524);
				match(ABRE_PARENTESIS);
				setState(525);
				((Chamada_partesContext)_localctx).v1 = expressao();
				setState(526);
				((Chamada_partesContext)_localctx).v2 = mais_expressao();
				setState(527);
				match(FECHA_PARENTESIS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(529);
				((Chamada_partesContext)_localctx).v3 = outros_ident();
				setState(530);
				dimensao();

				        ((Chamada_partesContext)_localctx).outrosIdent =  ((Chamada_partesContext)_localctx).v3.txt;
				        ((Chamada_partesContext)_localctx).tipoSimbolo =  pilhaDeTabelas.topo().GetTipoSimbolo(_localctx.primeiroIdent+((Chamada_partesContext)_localctx).v3.txt);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class Exp_relacionalContext extends ParserRuleContext {
		public String tipoSimbolo;
		public String txt;
		public Exp_aritmeticaContext v1;
		public Op_opcionalContext v2;
		public Exp_aritmeticaContext exp_aritmetica() {
			return getRuleContext(Exp_aritmeticaContext.class,0);
		}
		public Op_opcionalContext op_opcional() {
			return getRuleContext(Op_opcionalContext.class,0);
		}
		public Exp_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterExp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitExp_relacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_relacionalContext exp_relacional() throws RecognitionException {
		Exp_relacionalContext _localctx = new Exp_relacionalContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_exp_relacional);
		((Exp_relacionalContext)_localctx).tipoSimbolo = "SEM_TIPO"; ((Exp_relacionalContext)_localctx).txt = "";
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			((Exp_relacionalContext)_localctx).v1 = exp_aritmetica();
			setState(537);
			((Exp_relacionalContext)_localctx).v2 = op_opcional();

			        if(((Exp_relacionalContext)_localctx).v2.tipoSimbolo.equals("SEM_TIPO"))
			            ((Exp_relacionalContext)_localctx).tipoSimbolo = ((Exp_relacionalContext)_localctx).v1.tipoSimbolo;
			        else
			            ((Exp_relacionalContext)_localctx).tipoSimbolo = ((Exp_relacionalContext)_localctx).v2.tipoSimbolo;
			        ((Exp_relacionalContext)_localctx).txt = ((Exp_relacionalContext)_localctx).v1.txt;
			    
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

	public static class Op_opcionalContext extends ParserRuleContext {
		public String tipoSimbolo;
		public Op_relacionalContext v1;
		public Exp_aritmeticaContext exp_aritmetica() {
			return getRuleContext(Exp_aritmeticaContext.class,0);
		}
		public Op_relacionalContext op_relacional() {
			return getRuleContext(Op_relacionalContext.class,0);
		}
		public Op_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_opcionalContext op_opcional() throws RecognitionException {
		Op_opcionalContext _localctx = new Op_opcionalContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_op_opcional);
		((Op_opcionalContext)_localctx).tipoSimbolo = "SEM_TIPO";
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR_IGUAL) | (1L << MAIOR_IGUAL) | (1L << MENOR) | (1L << MAIOR) | (1L << IGUAL) | (1L << DIFERENTE))) != 0)) {
				{
				setState(540);
				((Op_opcionalContext)_localctx).v1 = op_relacional();
				setState(541);
				exp_aritmetica();

				        ((Op_opcionalContext)_localctx).tipoSimbolo = ((Op_opcionalContext)_localctx).v1.tipoSimbolo;
				    
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

	public static class Op_relacionalContext extends ParserRuleContext {
		public String tipoSimbolo;
		public TerminalNode IGUAL() { return getToken(LAParser.IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(LAParser.DIFERENTE, 0); }
		public TerminalNode MAIOR_IGUAL() { return getToken(LAParser.MAIOR_IGUAL, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(LAParser.MENOR_IGUAL, 0); }
		public TerminalNode MAIOR() { return getToken(LAParser.MAIOR, 0); }
		public TerminalNode MENOR() { return getToken(LAParser.MENOR, 0); }
		public Op_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_relacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_relacionalContext op_relacional() throws RecognitionException {
		Op_relacionalContext _localctx = new Op_relacionalContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_op_relacional);
		((Op_relacionalContext)_localctx).tipoSimbolo = "SEM_TIPO";
		try {
			setState(558);
			switch (_input.LA(1)) {
			case IGUAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(546);
				match(IGUAL);
				((Op_relacionalContext)_localctx).tipoSimbolo = "logico";
				}
				break;
			case DIFERENTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(548);
				match(DIFERENTE);
				((Op_relacionalContext)_localctx).tipoSimbolo = "logico";
				}
				break;
			case MAIOR_IGUAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(550);
				match(MAIOR_IGUAL);
				((Op_relacionalContext)_localctx).tipoSimbolo = "logico";
				}
				break;
			case MENOR_IGUAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(552);
				match(MENOR_IGUAL);
				((Op_relacionalContext)_localctx).tipoSimbolo = "logico";
				}
				break;
			case MAIOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(554);
				match(MAIOR);
				((Op_relacionalContext)_localctx).tipoSimbolo = "logico";
				}
				break;
			case MENOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(556);
				match(MENOR);
				((Op_relacionalContext)_localctx).tipoSimbolo = "logico";
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

	public static class ExpressaoContext extends ParserRuleContext {
		public String tipoSimbolo;
		public String txt;
		public Termo_logicoContext v1;
		public Outros_termos_logicosContext outros_termos_logicos() {
			return getRuleContext(Outros_termos_logicosContext.class,0);
		}
		public Termo_logicoContext termo_logico() {
			return getRuleContext(Termo_logicoContext.class,0);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitExpressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_expressao);
		((ExpressaoContext)_localctx).tipoSimbolo = "SEM_TIPO"; ((ExpressaoContext)_localctx).txt = "";
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			((ExpressaoContext)_localctx).v1 = termo_logico();
			setState(561);
			outros_termos_logicos();
			((ExpressaoContext)_localctx).tipoSimbolo = ((ExpressaoContext)_localctx).v1.tipoSimbolo; ((ExpressaoContext)_localctx).txt = ((ExpressaoContext)_localctx).v1.txt;
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

	public static class Op_naoContext extends ParserRuleContext {
		public TerminalNode NAO() { return getToken(LAParser.NAO, 0); }
		public Op_naoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_nao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_nao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_nao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_nao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_naoContext op_nao() throws RecognitionException {
		Op_naoContext _localctx = new Op_naoContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_op_nao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			_la = _input.LA(1);
			if (_la==NAO) {
				{
				setState(564);
				match(NAO);
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

	public static class Termo_logicoContext extends ParserRuleContext {
		public String tipoSimbolo;
		public String txt;
		public Fator_logicoContext v1;
		public Outros_fatores_logicosContext outros_fatores_logicos() {
			return getRuleContext(Outros_fatores_logicosContext.class,0);
		}
		public Fator_logicoContext fator_logico() {
			return getRuleContext(Fator_logicoContext.class,0);
		}
		public Termo_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTermo_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTermo_logico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTermo_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Termo_logicoContext termo_logico() throws RecognitionException {
		Termo_logicoContext _localctx = new Termo_logicoContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_termo_logico);
		((Termo_logicoContext)_localctx).tipoSimbolo = "SEM_TIPO"; ((Termo_logicoContext)_localctx).txt = "";
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			((Termo_logicoContext)_localctx).v1 = fator_logico();
			setState(568);
			outros_fatores_logicos();
			((Termo_logicoContext)_localctx).tipoSimbolo = ((Termo_logicoContext)_localctx).v1.tipoSimbolo; ((Termo_logicoContext)_localctx).txt = ((Termo_logicoContext)_localctx).v1.txt;
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

	public static class Outros_termos_logicosContext extends ParserRuleContext {
		public List<TerminalNode> OU() { return getTokens(LAParser.OU); }
		public TerminalNode OU(int i) {
			return getToken(LAParser.OU, i);
		}
		public List<Termo_logicoContext> termo_logico() {
			return getRuleContexts(Termo_logicoContext.class);
		}
		public Termo_logicoContext termo_logico(int i) {
			return getRuleContext(Termo_logicoContext.class,i);
		}
		public Outros_termos_logicosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_termos_logicos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutros_termos_logicos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutros_termos_logicos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutros_termos_logicos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_termos_logicosContext outros_termos_logicos() throws RecognitionException {
		Outros_termos_logicosContext _localctx = new Outros_termos_logicosContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_outros_termos_logicos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OU) {
				{
				{
				setState(571);
				match(OU);
				setState(572);
				termo_logico();
				}
				}
				setState(577);
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

	public static class Outros_fatores_logicosContext extends ParserRuleContext {
		public List<TerminalNode> E() { return getTokens(LAParser.E); }
		public TerminalNode E(int i) {
			return getToken(LAParser.E, i);
		}
		public List<Fator_logicoContext> fator_logico() {
			return getRuleContexts(Fator_logicoContext.class);
		}
		public Fator_logicoContext fator_logico(int i) {
			return getRuleContext(Fator_logicoContext.class,i);
		}
		public Outros_fatores_logicosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_fatores_logicos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutros_fatores_logicos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutros_fatores_logicos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutros_fatores_logicos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_fatores_logicosContext outros_fatores_logicos() throws RecognitionException {
		Outros_fatores_logicosContext _localctx = new Outros_fatores_logicosContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_outros_fatores_logicos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==E) {
				{
				{
				setState(578);
				match(E);
				setState(579);
				fator_logico();
				}
				}
				setState(584);
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

	public static class Fator_logicoContext extends ParserRuleContext {
		public String tipoSimbolo;
		public String txt;
		public Parcela_logicaContext v1;
		public Op_naoContext op_nao() {
			return getRuleContext(Op_naoContext.class,0);
		}
		public Parcela_logicaContext parcela_logica() {
			return getRuleContext(Parcela_logicaContext.class,0);
		}
		public Fator_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterFator_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitFator_logico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitFator_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fator_logicoContext fator_logico() throws RecognitionException {
		Fator_logicoContext _localctx = new Fator_logicoContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_fator_logico);
		((Fator_logicoContext)_localctx).tipoSimbolo = "SEM_TIPO"; ((Fator_logicoContext)_localctx).txt = "";
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			op_nao();
			setState(586);
			((Fator_logicoContext)_localctx).v1 = parcela_logica();
			((Fator_logicoContext)_localctx).tipoSimbolo = ((Fator_logicoContext)_localctx).v1.tipoSimbolo; ((Fator_logicoContext)_localctx).txt = ((Fator_logicoContext)_localctx).v1.txt;
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

	public static class Parcela_logicaContext extends ParserRuleContext {
		public String tipoSimbolo;
		public String txt;
		public Exp_relacionalContext v1;
		public TerminalNode VERDADEIRO() { return getToken(LAParser.VERDADEIRO, 0); }
		public TerminalNode FALSO() { return getToken(LAParser.FALSO, 0); }
		public Exp_relacionalContext exp_relacional() {
			return getRuleContext(Exp_relacionalContext.class,0);
		}
		public Parcela_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_logica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela_logica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela_logica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_logica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_logicaContext parcela_logica() throws RecognitionException {
		Parcela_logicaContext _localctx = new Parcela_logicaContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_parcela_logica);
		((Parcela_logicaContext)_localctx).tipoSimbolo = "SEM_TIPO"; ((Parcela_logicaContext)_localctx).txt = "";
		try {
			setState(596);
			switch (_input.LA(1)) {
			case VERDADEIRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(589);
				match(VERDADEIRO);
				((Parcela_logicaContext)_localctx).tipoSimbolo =  "logico";
				}
				break;
			case FALSO:
				enterOuterAlt(_localctx, 2);
				{
				setState(591);
				match(FALSO);
				((Parcela_logicaContext)_localctx).tipoSimbolo =  "logico";
				}
				break;
			case EXPOENTE:
			case ABRE_PARENTESIS:
			case SUBTRACAO:
			case OP_AND:
			case CADEIA:
			case IDENT:
			case N_INTEIRO:
			case N_REAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(593);
				((Parcela_logicaContext)_localctx).v1 = exp_relacional();
				((Parcela_logicaContext)_localctx).tipoSimbolo = ((Parcela_logicaContext)_localctx).v1.tipoSimbolo; ((Parcela_logicaContext)_localctx).txt = ((Parcela_logicaContext)_localctx).v1.txt;
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3C\u0259\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\7\3\u0083\n\3\f\3\16\3\u0086\13\3\3\4"+
		"\3\4\5\4\u008a\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5\u009e\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\7\7\u00ab\n\7\f\7\16\7\u00ae\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\7\t\u00b7\n\t\f\t\16\t\u00ba\13\t\3\n\3\n\3\n\3\n\5\n\u00c0\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u00c7\n\13\f\13\16\13\u00ca\13\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u00d2\n\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00da\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u00e1\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00eb\n\17\3\20\3\20\3\20\3\20\3\20\5\20\u00f2\n\20\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u011a\n\24\3\25\5\25"+
		"\u011d\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\5\27\u0128\n"+
		"\27\3\30\3\30\5\30\u012c\n\30\3\31\7\31\u012f\n\31\f\31\16\31\u0132\13"+
		"\31\3\32\3\32\3\32\3\33\7\33\u0138\n\33\f\33\16\33\u013b\13\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\5\34\u0185\n\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u018d\n\35\3\36"+
		"\3\36\5\36\u0191\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\5\37\u019d\n\37\3 \3 \3 \5 \u01a2\n \3!\3!\3!\3!\3!\3\"\5\"\u01aa\n\""+
		"\3#\3#\3#\3$\3$\5$\u01b1\n$\3%\3%\3%\3%\3&\3&\3&\3&\5&\u01bb\n&\3\'\5"+
		"\'\u01be\n\'\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\5,"+
		"\u01d2\n,\3-\3-\3-\3-\3.\3.\3.\7.\u01db\n.\f.\16.\u01de\13.\3/\3/\3/\3"+
		"/\3/\3/\3/\5/\u01e7\n/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u01fc\n\60\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u0206\n\61\3\62\3\62\7\62\u020a"+
		"\n\62\f\62\16\62\u020d\13\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\5\63\u0219\n\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\5\65"+
		"\u0223\n\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\5\66\u0231\n\66\3\67\3\67\3\67\3\67\38\58\u0238\n8\39\39\39\39\3:\3:"+
		"\7:\u0240\n:\f:\16:\u0243\13:\3;\3;\7;\u0247\n;\f;\16;\u024a\13;\3<\3"+
		"<\3<\3<\3=\3=\3=\3=\3=\3=\3=\5=\u0257\n=\3=\2\2>\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnp"+
		"rtvx\2\5\5\2\22\23>>@A\4\2//\61\61\3\2;<\u0258\2z\3\2\2\2\4\u0084\3\2"+
		"\2\2\6\u0089\3\2\2\2\b\u009d\3\2\2\2\n\u009f\3\2\2\2\f\u00ac\3\2\2\2\16"+
		"\u00af\3\2\2\2\20\u00b8\3\2\2\2\22\u00bf\3\2\2\2\24\u00c8\3\2\2\2\26\u00d1"+
		"\3\2\2\2\30\u00d9\3\2\2\2\32\u00e0\3\2\2\2\34\u00ea\3\2\2\2\36\u00f1\3"+
		"\2\2\2 \u00f3\3\2\2\2\"\u00f7\3\2\2\2$\u00f9\3\2\2\2&\u0119\3\2\2\2(\u011c"+
		"\3\2\2\2*\u011e\3\2\2\2,\u0127\3\2\2\2.\u012b\3\2\2\2\60\u0130\3\2\2\2"+
		"\62\u0133\3\2\2\2\64\u0139\3\2\2\2\66\u0184\3\2\2\28\u018c\3\2\2\2:\u0190"+
		"\3\2\2\2<\u019c\3\2\2\2>\u01a1\3\2\2\2@\u01a3\3\2\2\2B\u01a9\3\2\2\2D"+
		"\u01ab\3\2\2\2F\u01b0\3\2\2\2H\u01b2\3\2\2\2J\u01ba\3\2\2\2L\u01bd\3\2"+
		"\2\2N\u01bf\3\2\2\2P\u01c3\3\2\2\2R\u01c5\3\2\2\2T\u01c7\3\2\2\2V\u01d1"+
		"\3\2\2\2X\u01d3\3\2\2\2Z\u01dc\3\2\2\2\\\u01e6\3\2\2\2^\u01fb\3\2\2\2"+
		"`\u0205\3\2\2\2b\u020b\3\2\2\2d\u0218\3\2\2\2f\u021a\3\2\2\2h\u0222\3"+
		"\2\2\2j\u0230\3\2\2\2l\u0232\3\2\2\2n\u0237\3\2\2\2p\u0239\3\2\2\2r\u0241"+
		"\3\2\2\2t\u0248\3\2\2\2v\u024b\3\2\2\2x\u0256\3\2\2\2z{\b\2\1\2{|\5\4"+
		"\3\2|}\7\3\2\2}~\5\62\32\2~\177\7\4\2\2\177\u0080\b\2\1\2\u0080\3\3\2"+
		"\2\2\u0081\u0083\5\6\4\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\5\3\2\2\2\u0086\u0084\3\2\2\2"+
		"\u0087\u008a\5\b\5\2\u0088\u008a\5&\24\2\u0089\u0087\3\2\2\2\u0089\u0088"+
		"\3\2\2\2\u008a\7\3\2\2\2\u008b\u008c\7\5\2\2\u008c\u008d\5\n\6\2\u008d"+
		"\u008e\b\5\1\2\u008e\u009e\3\2\2\2\u008f\u0090\7\6\2\2\u0090\u0091\7?"+
		"\2\2\u0091\u0092\7\b\2\2\u0092\u0093\5\34\17\2\u0093\u0094\7\66\2\2\u0094"+
		"\u0095\5\"\22\2\u0095\u0096\b\5\1\2\u0096\u009e\3\2\2\2\u0097\u0098\7"+
		"\7\2\2\u0098\u0099\7?\2\2\u0099\u009a\7\b\2\2\u009a\u009b\5\26\f\2\u009b"+
		"\u009c\b\5\1\2\u009c\u009e\3\2\2\2\u009d\u008b\3\2\2\2\u009d\u008f\3\2"+
		"\2\2\u009d\u0097\3\2\2\2\u009e\t\3\2\2\2\u009f\u00a0\7?\2\2\u00a0\u00a1"+
		"\5\24\13\2\u00a1\u00a2\5\f\7\2\u00a2\u00a3\7\b\2\2\u00a3\u00a4\5\26\f"+
		"\2\u00a4\u00a5\b\6\1\2\u00a5\13\3\2\2\2\u00a6\u00a7\7\13\2\2\u00a7\u00a8"+
		"\7?\2\2\u00a8\u00a9\b\7\1\2\u00a9\u00ab\5\24\13\2\u00aa\u00a6\3\2\2\2"+
		"\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\r\3"+
		"\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\5\20\t\2\u00b0\u00b1\7?\2\2\u00b1"+
		"\u00b2\5\24\13\2\u00b2\u00b3\5\22\n\2\u00b3\u00b4\b\b\1\2\u00b4\17\3\2"+
		"\2\2\u00b5\u00b7\7\f\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\21\3\2\2\2\u00ba\u00b8\3\2\2"+
		"\2\u00bb\u00bc\7\r\2\2\u00bc\u00bd\5\16\b\2\u00bd\u00be\b\n\1\2\u00be"+
		"\u00c0\3\2\2\2\u00bf\u00bb\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\23\3\2\2"+
		"\2\u00c1\u00c2\7\t\2\2\u00c2\u00c3\5N(\2\u00c3\u00c4\7\n\2\2\u00c4\u00c5"+
		"\b\13\1\2\u00c5\u00c7\3\2\2\2\u00c6\u00c1\3\2\2\2\u00c7\u00ca\3\2\2\2"+
		"\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\25\3\2\2\2\u00ca\u00c8"+
		"\3\2\2\2\u00cb\u00cc\5$\23\2\u00cc\u00cd\b\f\1\2\u00cd\u00d2\3\2\2\2\u00ce"+
		"\u00cf\5 \21\2\u00cf\u00d0\b\f\1\2\u00d0\u00d2\3\2\2\2\u00d1\u00cb\3\2"+
		"\2\2\u00d1\u00ce\3\2\2\2\u00d2\27\3\2\2\2\u00d3\u00d4\7\13\2\2\u00d4\u00d5"+
		"\5\16\b\2\u00d5\u00d6\5\30\r\2\u00d6\u00d7\b\r\1\2\u00d7\u00da\3\2\2\2"+
		"\u00d8\u00da\3\2\2\2\u00d9\u00d3\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\31"+
		"\3\2\2\2\u00db\u00dc\5\n\6\2\u00dc\u00dd\5\32\16\2\u00dd\u00de\b\16\1"+
		"\2\u00de\u00e1\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00db\3\2\2\2\u00e0\u00df"+
		"\3\2\2\2\u00e1\33\3\2\2\2\u00e2\u00e3\7\16\2\2\u00e3\u00eb\b\17\1\2\u00e4"+
		"\u00e5\7\17\2\2\u00e5\u00eb\b\17\1\2\u00e6\u00e7\7\20\2\2\u00e7\u00eb"+
		"\b\17\1\2\u00e8\u00e9\7\21\2\2\u00e9\u00eb\b\17\1\2\u00ea\u00e2\3\2\2"+
		"\2\u00ea\u00e4\3\2\2\2\u00ea\u00e6\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\35"+
		"\3\2\2\2\u00ec\u00ed\5\34\17\2\u00ed\u00ee\b\20\1\2\u00ee\u00f2\3\2\2"+
		"\2\u00ef\u00f0\7?\2\2\u00f0\u00f2\b\20\1\2\u00f1\u00ec\3\2\2\2\u00f1\u00ef"+
		"\3\2\2\2\u00f2\37\3\2\2\2\u00f3\u00f4\5\20\t\2\u00f4\u00f5\5\36\20\2\u00f5"+
		"\u00f6\b\21\1\2\u00f6!\3\2\2\2\u00f7\u00f8\t\2\2\2\u00f8#\3\2\2\2\u00f9"+
		"\u00fa\7\24\2\2\u00fa\u00fb\b\23\1\2\u00fb\u00fc\5\n\6\2\u00fc\u00fd\5"+
		"\32\16\2\u00fd\u00fe\b\23\1\2\u00fe\u00ff\7\25\2\2\u00ff\u0100\b\23\1"+
		"\2\u0100%\3\2\2\2\u0101\u0102\7\26\2\2\u0102\u0103\7?\2\2\u0103\u0104"+
		"\b\24\1\2\u0104\u0105\7\30\2\2\u0105\u0106\5(\25\2\u0106\u0107\7\31\2"+
		"\2\u0107\u0108\5\60\31\2\u0108\u0109\5\64\33\2\u0109\u010a\7\27\2\2\u010a"+
		"\u010b\b\24\1\2\u010b\u011a\3\2\2\2\u010c\u010d\7\32\2\2\u010d\u010e\7"+
		"?\2\2\u010e\u010f\b\24\1\2\u010f\u0110\7\30\2\2\u0110\u0111\5(\25\2\u0111"+
		"\u0112\7\31\2\2\u0112\u0113\7\b\2\2\u0113\u0114\5 \21\2\u0114\u0115\5"+
		"\60\31\2\u0115\u0116\5\64\33\2\u0116\u0117\7\33\2\2\u0117\u0118\b\24\1"+
		"\2\u0118\u011a\3\2\2\2\u0119\u0101\3\2\2\2\u0119\u010c\3\2\2\2\u011a\'"+
		"\3\2\2\2\u011b\u011d\5*\26\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		")\3\2\2\2\u011e\u011f\5,\27\2\u011f\u0120\5\16\b\2\u0120\u0121\5\30\r"+
		"\2\u0121\u0122\7\b\2\2\u0122\u0123\5 \21\2\u0123\u0124\5.\30\2\u0124\u0125"+
		"\b\26\1\2\u0125+\3\2\2\2\u0126\u0128\7\34\2\2\u0127\u0126\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128-\3\2\2\2\u0129\u012a\7\13\2\2\u012a\u012c\5*\26\2"+
		"\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c/\3\2\2\2\u012d\u012f\5"+
		"\b\5\2\u012e\u012d\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\61\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\5\60\31"+
		"\2\u0134\u0135\5\64\33\2\u0135\63\3\2\2\2\u0136\u0138\5\66\34\2\u0137"+
		"\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2"+
		"\2\2\u013a\65\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\7\35\2\2\u013d\u013e"+
		"\7\30\2\2\u013e\u013f\5\16\b\2\u013f\u0140\5\30\r\2\u0140\u0141\b\34\1"+
		"\2\u0141\u0142\7\31\2\2\u0142\u0143\b\34\1\2\u0143\u0185\3\2\2\2\u0144"+
		"\u0145\7\36\2\2\u0145\u0146\7\30\2\2\u0146\u0147\5l\67\2\u0147\u0148\5"+
		"8\35\2\u0148\u0149\7\31\2\2\u0149\u014a\b\34\1\2\u014a\u0185\3\2\2\2\u014b"+
		"\u014c\7\37\2\2\u014c\u014d\5l\67\2\u014d\u014e\7 \2\2\u014e\u014f\5\64"+
		"\33\2\u014f\u0150\5:\36\2\u0150\u0151\7!\2\2\u0151\u0152\b\34\1\2\u0152"+
		"\u0185\3\2\2\2\u0153\u0154\7#\2\2\u0154\u0155\5N(\2\u0155\u0156\7$\2\2"+
		"\u0156\u0157\5@!\2\u0157\u0158\5:\36\2\u0158\u0159\7%\2\2\u0159\u015a"+
		"\b\34\1\2\u015a\u0185\3\2\2\2\u015b\u015c\7&\2\2\u015c\u015d\7?\2\2\u015d"+
		"\u015e\7\'\2\2\u015e\u015f\5N(\2\u015f\u0160\7(\2\2\u0160\u0161\5N(\2"+
		"\u0161\u0162\7)\2\2\u0162\u0163\5\64\33\2\u0163\u0164\7*\2\2\u0164\u0165"+
		"\b\34\1\2\u0165\u0185\3\2\2\2\u0166\u0167\7+\2\2\u0167\u0168\5l\67\2\u0168"+
		"\u0169\7)\2\2\u0169\u016a\5\64\33\2\u016a\u016b\7,\2\2\u016b\u016c\b\34"+
		"\1\2\u016c\u0185\3\2\2\2\u016d\u016e\7)\2\2\u016e\u016f\5\64\33\2\u016f"+
		"\u0170\7(\2\2\u0170\u0171\5l\67\2\u0171\u0172\b\34\1\2\u0172\u0185\3\2"+
		"\2\2\u0173\u0174\7\f\2\2\u0174\u0175\7?\2\2\u0175\u0176\5\22\n\2\u0176"+
		"\u0177\5\24\13\2\u0177\u0178\7\'\2\2\u0178\u0179\5l\67\2\u0179\u017a\b"+
		"\34\1\2\u017a\u017b\b\34\1\2\u017b\u0185\3\2\2\2\u017c\u017d\7?\2\2\u017d"+
		"\u017e\5<\37\2\u017e\u017f\b\34\1\2\u017f\u0185\3\2\2\2\u0180\u0181\7"+
		"-\2\2\u0181\u0182\5l\67\2\u0182\u0183\b\34\1\2\u0183\u0185\3\2\2\2\u0184"+
		"\u013c\3\2\2\2\u0184\u0144\3\2\2\2\u0184\u014b\3\2\2\2\u0184\u0153\3\2"+
		"\2\2\u0184\u015b\3\2\2\2\u0184\u0166\3\2\2\2\u0184\u016d\3\2\2\2\u0184"+
		"\u0173\3\2\2\2\u0184\u017c\3\2\2\2\u0184\u0180\3\2\2\2\u0185\67\3\2\2"+
		"\2\u0186\u0187\7\13\2\2\u0187\u0188\5l\67\2\u0188\u0189\58\35\2\u0189"+
		"\u018a\b\35\1\2\u018a\u018d\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u0186\3"+
		"\2\2\2\u018c\u018b\3\2\2\2\u018d9\3\2\2\2\u018e\u018f\7\"\2\2\u018f\u0191"+
		"\5\64\33\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191;\3\2\2\2\u0192"+
		"\u0193\7\30\2\2\u0193\u0194\5> \2\u0194\u0195\7\31\2\2\u0195\u019d\3\2"+
		"\2\2\u0196\u0197\5\22\n\2\u0197\u0198\5\24\13\2\u0198\u0199\7\'\2\2\u0199"+
		"\u019a\5l\67\2\u019a\u019b\b\37\1\2\u019b\u019d\3\2\2\2\u019c\u0192\3"+
		"\2\2\2\u019c\u0196\3\2\2\2\u019d=\3\2\2\2\u019e\u019f\5l\67\2\u019f\u01a0"+
		"\58\35\2\u01a0\u01a2\3\2\2\2\u01a1\u019e\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2"+
		"?\3\2\2\2\u01a3\u01a4\5D#\2\u01a4\u01a5\7\b\2\2\u01a5\u01a6\5\64\33\2"+
		"\u01a6\u01a7\5B\"\2\u01a7A\3\2\2\2\u01a8\u01aa\5@!\2\u01a9\u01a8\3\2\2"+
		"\2\u01a9\u01aa\3\2\2\2\u01aaC\3\2\2\2\u01ab\u01ac\5H%\2\u01ac\u01ad\5"+
		"F$\2\u01adE\3\2\2\2\u01ae\u01af\7\13\2\2\u01af\u01b1\5D#\2\u01b0\u01ae"+
		"\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1G\3\2\2\2\u01b2\u01b3\5L\'\2\u01b3\u01b4"+
		"\7@\2\2\u01b4\u01b5\5J&\2\u01b5I\3\2\2\2\u01b6\u01b7\7.\2\2\u01b7\u01b8"+
		"\5L\'\2\u01b8\u01b9\7@\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01b6\3\2\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01bbK\3\2\2\2\u01bc\u01be\7<\2\2\u01bd\u01bc\3\2\2\2\u01bd"+
		"\u01be\3\2\2\2\u01beM\3\2\2\2\u01bf\u01c0\5T+\2\u01c0\u01c1\5V,\2\u01c1"+
		"\u01c2\b(\1\2\u01c2O\3\2\2\2\u01c3\u01c4\t\3\2\2\u01c4Q\3\2\2\2\u01c5"+
		"\u01c6\t\4\2\2\u01c6S\3\2\2\2\u01c7\u01c8\5X-\2\u01c8\u01c9\5Z.\2\u01c9"+
		"\u01ca\b+\1\2\u01caU\3\2\2\2\u01cb\u01cc\5R*\2\u01cc\u01cd\5T+\2\u01cd"+
		"\u01ce\5V,\2\u01ce\u01cf\b,\1\2\u01cf\u01d2\3\2\2\2\u01d0\u01d2\3\2\2"+
		"\2\u01d1\u01cb\3\2\2\2\u01d1\u01d0\3\2\2\2\u01d2W\3\2\2\2\u01d3\u01d4"+
		"\5\\/\2\u01d4\u01d5\5b\62\2\u01d5\u01d6\b-\1\2\u01d6Y\3\2\2\2\u01d7\u01d8"+
		"\5P)\2\u01d8\u01d9\5X-\2\u01d9\u01db\3\2\2\2\u01da\u01d7\3\2\2\2\u01db"+
		"\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd[\3\2\2\2"+
		"\u01de\u01dc\3\2\2\2\u01df\u01e0\5L\'\2\u01e0\u01e1\5^\60\2\u01e1\u01e2"+
		"\b/\1\2\u01e2\u01e7\3\2\2\2\u01e3\u01e4\5`\61\2\u01e4\u01e5\b/\1\2\u01e5"+
		"\u01e7\3\2\2\2\u01e6\u01df\3\2\2\2\u01e6\u01e3\3\2\2\2\u01e7]\3\2\2\2"+
		"\u01e8\u01e9\7\f\2\2\u01e9\u01ea\7?\2\2\u01ea\u01eb\5\22\n\2\u01eb\u01ec"+
		"\5\24\13\2\u01ec\u01ed\b\60\1\2\u01ed\u01fc\3\2\2\2\u01ee\u01ef\7?\2\2"+
		"\u01ef\u01f0\5d\63\2\u01f0\u01f1\b\60\1\2\u01f1\u01fc\3\2\2\2\u01f2\u01f3"+
		"\7@\2\2\u01f3\u01fc\b\60\1\2\u01f4\u01f5\7A\2\2\u01f5\u01fc\b\60\1\2\u01f6"+
		"\u01f7\7\30\2\2\u01f7\u01f8\5l\67\2\u01f8\u01f9\7\31\2\2\u01f9\u01fa\b"+
		"\60\1\2\u01fa\u01fc\3\2\2\2\u01fb\u01e8\3\2\2\2\u01fb\u01ee\3\2\2\2\u01fb"+
		"\u01f2\3\2\2\2\u01fb\u01f4\3\2\2\2\u01fb\u01f6\3\2\2\2\u01fc_\3\2\2\2"+
		"\u01fd\u01fe\7=\2\2\u01fe\u01ff\7?\2\2\u01ff\u0200\5\22\n\2\u0200\u0201"+
		"\b\61\1\2\u0201\u0202\5\24\13\2\u0202\u0206\3\2\2\2\u0203\u0204\7>\2\2"+
		"\u0204\u0206\b\61\1\2\u0205\u01fd\3\2\2\2\u0205\u0203\3\2\2\2\u0206a\3"+
		"\2\2\2\u0207\u0208\7\63\2\2\u0208\u020a\5\\/\2\u0209\u0207\3\2\2\2\u020a"+
		"\u020d\3\2\2\2\u020b\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020cc\3\2\2\2"+
		"\u020d\u020b\3\2\2\2\u020e\u020f\7\30\2\2\u020f\u0210\5l\67\2\u0210\u0211"+
		"\58\35\2\u0211\u0212\7\31\2\2\u0212\u0219\3\2\2\2\u0213\u0214\5\22\n\2"+
		"\u0214\u0215\5\24\13\2\u0215\u0216\b\63\1\2\u0216\u0219\3\2\2\2\u0217"+
		"\u0219\3\2\2\2\u0218\u020e\3\2\2\2\u0218\u0213\3\2\2\2\u0218\u0217\3\2"+
		"\2\2\u0219e\3\2\2\2\u021a\u021b\5N(\2\u021b\u021c\5h\65\2\u021c\u021d"+
		"\b\64\1\2\u021dg\3\2\2\2\u021e\u021f\5j\66\2\u021f\u0220\5N(\2\u0220\u0221"+
		"\b\65\1\2\u0221\u0223\3\2\2\2\u0222\u021e\3\2\2\2\u0222\u0223\3\2\2\2"+
		"\u0223i\3\2\2\2\u0224\u0225\7\66\2\2\u0225\u0231\b\66\1\2\u0226\u0227"+
		"\7\67\2\2\u0227\u0231\b\66\1\2\u0228\u0229\7\62\2\2\u0229\u0231\b\66\1"+
		"\2\u022a\u022b\7\60\2\2\u022b\u0231\b\66\1\2\u022c\u022d\7\65\2\2\u022d"+
		"\u0231\b\66\1\2\u022e\u022f\7\64\2\2\u022f\u0231\b\66\1\2\u0230\u0224"+
		"\3\2\2\2\u0230\u0226\3\2\2\2\u0230\u0228\3\2\2\2\u0230\u022a\3\2\2\2\u0230"+
		"\u022c\3\2\2\2\u0230\u022e\3\2\2\2\u0231k\3\2\2\2\u0232\u0233\5p9\2\u0233"+
		"\u0234\5r:\2\u0234\u0235\b\67\1\2\u0235m\3\2\2\2\u0236\u0238\7:\2\2\u0237"+
		"\u0236\3\2\2\2\u0237\u0238\3\2\2\2\u0238o\3\2\2\2\u0239\u023a\5v<\2\u023a"+
		"\u023b\5t;\2\u023b\u023c\b9\1\2\u023cq\3\2\2\2\u023d\u023e\78\2\2\u023e"+
		"\u0240\5p9\2\u023f\u023d\3\2\2\2\u0240\u0243\3\2\2\2\u0241\u023f\3\2\2"+
		"\2\u0241\u0242\3\2\2\2\u0242s\3\2\2\2\u0243\u0241\3\2\2\2\u0244\u0245"+
		"\79\2\2\u0245\u0247\5v<\2\u0246\u0244\3\2\2\2\u0247\u024a\3\2\2\2\u0248"+
		"\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249u\3\2\2\2\u024a\u0248\3\2\2\2"+
		"\u024b\u024c\5n8\2\u024c\u024d\5x=\2\u024d\u024e\b<\1\2\u024ew\3\2\2\2"+
		"\u024f\u0250\7\22\2\2\u0250\u0257\b=\1\2\u0251\u0252\7\23\2\2\u0252\u0257"+
		"\b=\1\2\u0253\u0254\5f\64\2\u0254\u0255\b=\1\2\u0255\u0257\3\2\2\2\u0256"+
		"\u024f\3\2\2\2\u0256\u0251\3\2\2\2\u0256\u0253\3\2\2\2\u0257y\3\2\2\2"+
		"*\u0084\u0089\u009d\u00ac\u00b8\u00bf\u00c8\u00d1\u00d9\u00e0\u00ea\u00f1"+
		"\u0119\u011c\u0127\u012b\u0130\u0139\u0184\u018c\u0190\u019c\u01a1\u01a9"+
		"\u01b0\u01ba\u01bd\u01d1\u01dc\u01e6\u01fb\u0205\u020b\u0218\u0222\u0230"+
		"\u0237\u0241\u0248\u0256";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}