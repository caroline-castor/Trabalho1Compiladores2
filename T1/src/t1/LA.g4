grammar LA;

@members
{
	private void stop(String msg)
	{
		throw new ParseCancellationException(msg);
	}
   
        PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
	
	Saida outSemantico = new Saida();

        private void erroSemantico(String msg) {
		outSemantico.println(msg);        
	}
}
// ANÁLISE LÉXICA
//PALAVRAS CHAVES E RESERVADAS DA LA 

ALGORITMO: 'algoritmo';
FIM_ALGORITMO :'fim_algoritmo';
DECLARE : 'declare';
CONSTANTE : 'constante';
TIPO : 'tipo';
DOIS_PONTOS : ':';	
ABRE_COLCHETE :	'[';
FECHA_COLCHETE : ']';
VIRGULA	: ',';
EXPOENTE : '^';
PONTO :	'.';
LITERAL : 'literal';
INTEIRO	: 'inteiro';
REAL : 'real';	
LOGICO: 'logico';
VERDADEIRO : 'verdadeiro';
FALSO : 'falso';
REGISTRO : 'registro';
FIM_REGISTRO : 'fim_registro';
PROCEDIMENTO : 'procedimento';
FIM_PROCEDIMENTO : 'fim_procedimento';
ABRE_PARENTESIS : '(';
FECHA_PARENTESIS : ')';
FUNCAO : 'funcao';
FIM_FUNCAO : 'fim_funcao';
VAR : 'var';
LEIA : 'leia';
ESCREVA : 'escreva';
SE : 'se';
ENTAO : 'entao';
FIM_SE : 'fim_se';
SENAO : 'senao';	
CASO : 'caso';
SEJA : 'seja';	
FIM_CASO : 'fim_caso';
PARA : 'para';
ATRIBUICAO : '<-';
ATE : 'ate';
FACA : 'faca';
FIM_PARA : 'fim_para';
ENQUANTO : 'enquanto';
FIM_ENQUANTO : 'fim_enquanto';
RETORNE : 'retorne';	
PONTO_PONTO : '..';
MULTIPLICACAO : '*';
MENOR_IGUAL : '<=';
DIVISAO : '/' ;
MAIOR_IGUAL : '>=';
PORCENTAGEM : '%';
MENOR : '<';
MAIOR : '>';
IGUAL : '=';
DIFERENTE : '<>';
OU : 'ou';
E : 'e';
NAO : 'nao';
SOMA: '+';
SUBTRACAO : '-';
OP_AND : '&';
CADEIA : '\'' ~('\n' | '\r' | '\'')* '\'' | '"' ~('\n' | '\r' | '"')* '"';
IDENT : ('_'|'a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
N_INTEIRO : ('0'..'9')+;
N_REAL : ('0'..'9')+ '.' ('0'..'9')+;
WS : ( ' ' |'\t' | '\r' | '\n') {skip();}; 
COMENTARIO : '{' ~('\n'|'\r'|'\t')* '\r'? '\n'? '}'('\n'('\n'|'\t'))* {skip();};

/* Analisador Sintático e Semântico*/

programa : declaracoes ALGORITMO corpo FIM_ALGORITMO;

declaracoes : (decl_local_global)*;

decl_local_global 
    : declaracao_local 
    | declaracao_global;

declaracao_local 
    : DECLARE variavel | CONSTANTE IDENT DOIS_PONTOS tipo_basico IGUAL valor_constante | TIPO IDENT DOIS_PONTOS tipo;
    
variavel : IDENT dimensao mais_var DOIS_PONTOS tipo;
  
mais_var : (VIRGULA IDENT dimensao)*;

identificador : ponteiros_opcionais IDENT dimensao outros_ident ;

ponteiros_opcionais : (EXPOENTE)*;

outros_ident: (PONTO identificador)?;
	
dimensao: (ABRE_COLCHETE exp_aritmetica FECHA_COLCHETE)*;

tipo
    : registro | tipo_estendido ;

mais_ident : (VIRGULA identificador)*;
	
mais_variaveis : (variavel)*;
      
tipo_basico 
    : LITERAL| 
      INTEIRO| 
      REAL| 
      LOGICO;

tipo_basico_ident
    : tipo_basico | IDENT;

tipo_estendido: ponteiros_opcionais tipo_basico_ident ;

valor_constante 
    : CADEIA
    | N_INTEIRO
    | N_REAL
    | VERDADEIRO
    | FALSO
    ;

registro : REGISTRO variavel mais_variaveis FIM_REGISTRO;

declaracao_global 
    : PROCEDIMENTO IDENT ABRE_PARENTESIS parametros_opcional FECHA_PARENTESIS declaracoes_locais comandos FIM_PROCEDIMENTO     
     | FUNCAO IDENT ABRE_PARENTESIS parametros_opcional FECHA_PARENTESIS DOIS_PONTOS tipo_estendido declaracoes_locais comandos FIM_FUNCAO;

parametros_opcional : (parametro)?;

parametro: var_opcional identificador mais_ident DOIS_PONTOS tipo_estendido mais_parametros;

var_opcional : VAR?;

mais_parametros: (VIRGULA v1=parametro)?;

declaracoes_locais: (declaracao_local)*;

corpo : declaracoes_locais comandos;

comandos : (cmd)*;

cmd 

    : LEIA ABRE_PARENTESIS identificador mais_ident FECHA_PARENTESIS 
    | ESCREVA ABRE_PARENTESIS expressao mais_expressao FECHA_PARENTESIS 
    | SE expressao ENTAO comandos senao_opcional FIM_SE 
    | CASO exp_aritmetica SEJA selecao senao_opcional FIM_CASO 
    | PARA IDENT ATRIBUICAO exp_aritmetica ATE exp_aritmetica FACA comandos FIM_PARA 
    | ENQUANTO expressao FACA comandos FIM_ENQUANTO 
    | FACA comandos ATE expressao 
    | EXPOENTE IDENT outros_ident dimensao ATRIBUICAO expressao 
    | IDENT chamada_atribuicao
    | RETORNE expressao;

mais_expressao : (VIRGULA expressao)*;

senao_opcional : (SENAO comandos)?;

chamada_atribuicao
    : ABRE_PARENTESIS argumentos_opcional FECHA_PARENTESIS
    | outros_ident dimensao ATRIBUICAO expressao 
    ;

argumentos_opcional : (expressao mais_expressao)?;

selecao : constantes DOIS_PONTOS comandos mais_selecao;

mais_selecao : (selecao)?;

constantes : numero_intervalo mais_constantes;

mais_constantes : (VIRGULA constantes)?;

numero_intervalo : op_unario N_INTEIRO intervalo_opcional;

intervalo_opcional : (PONTO_PONTO op_unario N_INTEIRO)?;

op_unario : (SUBTRACAO)?;

exp_aritmetica: termo outros_termos;

op_multiplicacao : MULTIPLICACAO | DIVISAO;

op_adicao : SOMA | SUBTRACAO;

termo :fator outros_fatores;

outros_termos : (op_adicao termo)*;

fator : parcela outras_parcelas ;
  
outros_fatores : (op_multiplicacao fator)*;

parcela 
    : op_unario parcela_unario | parcela_nao_unario ;

parcela_unario 
    : EXPOENTE IDENT outros_ident dimensao
    | IDENT chamada_partes             
    | N_INTEIRO  
    | N_REAL 
    | ABRE_PARENTESIS expressao FECHA_PARENTESIS 
    ;

parcela_nao_unario
    : OP_AND IDENT outros_ident dimensao
    | CADEIA ;

outras_parcelas : (PORCENTAGEM parcela)*;

chamada_partes
    : ABRE_PARENTESIS expressao mais_expressao FECHA_PARENTESIS
    | outros_ident dimensao 
    |;

exp_relacional 
    : exp_aritmetica op_opcional ;

op_opcional 
    : (op_relacional exp_aritmetica)? ;

op_relacional
    : IGUAL 
    | DIFERENTE 
    | MAIOR_IGUAL 
    | MENOR_IGUAL 
    | MAIOR 
    | MENOR ;

expressao : termo_logico outros_termos_logicos ;

op_nao : (NAO)?;

termo_logico : fator_logico outros_fatores_logicos ;

outros_termos_logicos : (OU termo_logico)*;

outros_fatores_logicos : (E fator_logico)*;

fator_logico : op_nao parcela_logica ;

parcela_logica 
    : VERDADEIRO 
    | FALSO 
    | exp_relacional 
    ;