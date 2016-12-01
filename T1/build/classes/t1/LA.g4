grammar LA;

@members
{
   public static String grupo="551503,";
   String msg_error="";
   PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
   PilhaDeTabelas tabelaRegistros = new PilhaDeTabelas();
   TabelaDeSimbolos tabelaTipos = new TabelaDeSimbolos("tipos");
     
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

/*Aqui começamos o inicio da arvore sintatica com a declaração de programa */
programa : { 
            /*Primeiramente criar um novo escopo e empila-lo. Ele será o escopo global do programa*/
             pilhaDeTabelas.empilhar(new TabelaDeSimbolos("global"));
             /* Feito isso, definimos os tipos default da linguagem, ou seja, adicionamos
             todos os tipos pertencentes a LA para que dado uma varivel com esses tipos não precise
             adicionar no codigo, se um tipo diferente desses for declarado, ele é tratado no código*/
             tabelaTipos.adicionarSimbolo("literal", "literal");
             tabelaTipos.adicionarSimbolo("inteiro", "inteiro");
             tabelaTipos.adicionarSimbolo("real", "real");
             tabelaTipos.adicionarSimbolo("logico", "logico");
                      
          }
           /*Um programa é composto da seguinte maneira: um conjunto de declarações (global), a palavra
           algoritmo, seguido do corpo que é composto de funções,procedimentos, loops, atribuições, leitura, escrita etc..
           e um fim_algoritmo que determina quando o programa acabou*/
             declaracoes ALGORITMO corpo FIM_ALGORITMO
             {
              /* Depois que o fim_algoritmo é encontrado no programa, é executado o seguinte comando:*/
              { 
              /* Ele serve para desempilhar a pilha global que criamos no inicio dele e terminar a execução */
              pilhaDeTabelas.desempilhar();
              /* msg_error guarda qualquer possivel erro que ocorreu na analise semantica e lança uma exceção */
              if(msg_error!=""){
                  throw new RuntimeException(msg_error);
              }   
          }
      };

declaracoes : (decl_local_global)*;

decl_local_global 
    : declaracao_local 
    | declaracao_global;

declaracao_local
    /* Aqui temos os tipos de declaração_local, ela pode ser precedida da palavra declare,tipo e constante
    declare são declarações de variáveis, registros
    tipo declaração de um novo tipo
    constantes são declarações de constantes*/
    : DECLARE variavel 
      {
       /* aqui há um loop para percorrer os nomes das variaveis declaradas pois podemos declarar varios nomes
       de variáveis do mesmo tipo de uma só vez. Essa parte entra juntamente com o processamento de variaveis e consequentemente
       de mais_variaveis pois lá atribuimos nomes, tipo e linha que pegamos aqui para tratar*/
       for (String s : $variavel.nomes){
         // verificação se existe o símbolo na pilha de tabelas
            if(pilhaDeTabelas.topo().existeSimbolo(s)){
            // se existir, é emitida uma mensagem de erro que a variavel com identificador já foi declarada
                msg_error += "Linha " + $variavel.linha + ": identificador "+s+" ja declarado anteriormente\n" ;
		
            }else{
                // se não tiver o simbolo, verificamos se o tipo desse simbolo já esta declarado
	        if(tabelaTipos.existeSimbolo($variavel.tipoSimbolo)){
                    // se o tipo já existir, então só ai o simbolo é adicionado no escopo atual
                    pilhaDeTabelas.topo().adicionarSimbolo(s, $variavel.tipoSimbolo);
                    // aqui verificamos se existe alguma tabela com o tipo declarado pois esse tipo declarado pode ser um tipo de registro
                    // então devemos procurar na tabela de registro, pois o tratamento é diferente
                    if(tabelaRegistros.existeTabela($variavel.tipoSimbolo)!=null){
                        //se existir uma tabela de registro com o tipo informado então temos uma variavel do tipo do registro
                        //resgatamos a tabela do registro na qual o tipo declarado pertence
                        TabelaDeSimbolos tabela_registro = tabelaRegistros.existeTabela($variavel.tipoSimbolo);
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
                  
                    msg_error += "Linha " + $variavel.linha + ": tipo "+$variavel.tipoSimbolo+" nao declarado\n" ;
                    pilhaDeTabelas.topo().adicionarSimbolo(s, $variavel.tipoSimbolo);
                }
            }
        }
    }
       
    // aqui tratamos do caso da declração local ser uma constante
    | CONSTANTE v1=IDENT DOIS_PONTOS v2=tipo_basico IGUAL valor_constante {
       //primeiro verificamos se existe uma variavel no mesmo escopo com o mesmo nome
       if(pilhaDeTabelas.topo().existeSimbolo($v1.getText()))
           // se existir é executado um erro  
            msg_error += "Linha " + $v1.getLine() + ": identificador "+$v1.getText()+" ja declarado anteriormente\n" ;
        else{
            // se ainda não foi declara nenhuma variavel com esse nome, então o identificador da variável e tipo são
            // adiicionados no escopo atual
            pilhaDeTabelas.topo().adicionarSimbolo($v1.getText(), $v2.tipoSimbolo);
         }
       }
    
      //aqui tratamos da declaração de tipo
    | TIPO v1=IDENT DOIS_PONTOS v3=tipo[$v1.getText()]{
        //primeiro verificamos se já existe um identificador com mesmo nome já declarado
        if(pilhaDeTabelas.topo().existeSimbolo($v1.getText()))
           // se existir executa um erro
            msg_error += "Linha " + $v1.getLine() + ": identificador "+$v1.getText()+" ja declarado anteriormente\n" ;
        else{
           // se não existir então adiciona-se o identificador e tipo no escopo atual
            pilhaDeTabelas.topo().adicionarSimbolo($v1.getText(), $v3.tipoSimbolo);
            //e também adiciona-se um novo tipo, pois estamos declarando um novo tipo
            tabelaTipos.adicionarSimbolo($v1.getText(), $v3.tipoSimbolo);  
        }
    }
    ;
    
/* 
 Essa regra retorna uma lista de nomes pq trata a possibilidade de se declarar varias variaveis com mesmo tipo em uma linha só
Ou seja, essa lista terá todos identificadores dessas variáveis declaradas.
Como elas serão do mesmo tipo, então também retorna qual o tipo delas e em qual linha elas estão pra efeito de mensagem de erro
*/
variavel returns[List<String> nomes, String tipoSimbolo, int linha]
//primeiro inicializamos as variaveis auxiliares, $nomes guardará a lista de identidificadores
    @init {$nomes = new ArrayList<String>(); $tipoSimbolo=""; $linha=-1;}
//aqui colocamos variaveis auxiliares para auxiliar na recuperação da informação
    : v1=IDENT dimensao v2=mais_var DOIS_PONTOS m3=tipo[$tipoSimbolo]{
        $tipoSimbolo = $m3.tipoSimbolo;
        $nomes.add($v1.getText());
        $nomes.addAll($v2.nomes);
        if($v2.linha==-1){
            $linha = $v1.getLine();
        }else{
            $linha = $v2.linha;
        }
       
    }
;

/*Essa regra é executada quando se tem mais variaveis declaradas do mesmo tipo na mesma linha
ela retorna uma lista de nomes que são os identificadores e a linha que estão*/
mais_var returns[ List<String> nomes, int linha ] 
//inicialização dos valores
    @init { $nomes = new ArrayList<String>(); $linha=-1; }
    : (VIRGULA v1=IDENT {
        //depois que chegamos no identidicador fazemos um processamento para verificar se ele já existe
        if(!pilhaDeTabelas.existeSimbolo($v1.getText())){
            // se não existe, então adicionamos ele na lista de nomes e pegamos a linha dele
            $nomes.add($v1.getText());
            $linha = $v1.getLine();
        }
        else{
            //se já existir um identificador com mesmo nome é disprada uma mensagem de erro
            msg_error+="Linha " + $v1.getLine() + ": identificador " + $v1.getText() + " ja declarado anteriormente\n";
           
        }
     }
//lembrando que essa regra é recursiva, então para todos os identificadores encontrados eles serão adicionados na lista de nomes
// e anteriormente verificados se já existem
dimensao)*;

//essa regra trata os identificadores
//retorna o nome deles, a linha e o tipo deles
identificador returns [ String txt, int linha, String tipoSimbolo]
//inicialização de valores
    @init { $txt = ""; $linha=-1; $tipoSimbolo="SEM_TIPO";}
    :   
    
        ponteiros_opcionais v1=IDENT dimensao v2=outros_ident{
        // essa regra se for um registro então é retornado uma string com o nome do identificador '.' atributo
        // são os casos de por exemplo pessoa.nome tipo=pessoa, variavel do tipo = nome
        // a concatenação do ponto será feita na regra outros_ident
        $txt += $v1.text+$v2.txt;
        $linha = $v1.getLine();
        $tipoSimbolo = pilhaDeTabelas.topo().GetTipoSimbolo($txt); //error
    }
;

ponteiros_opcionais : (EXPOENTE)*;

outros_ident returns [ String txt ]
@init {$txt="";}
: 
(PONTO id=identificador { $txt = "."+$id.txt; })?;

//concatena o formado de vetores com [dimensao]
dimensao  returns [String txt]
@init {$txt="";}
: 
(ABRE_COLCHETE v1=exp_aritmetica FECHA_COLCHETE {$txt= "[" + $v1.txt + "]";})*;

//tipo retorna o tipo e uma lista de nomes
//PODE TER ERRO AQUI
tipo [String tipo_registro] returns [String tipoSimbolo, List<String> nomes ]
    @init {$tipoSimbolo=""; $nomes = new ArrayList<String>();}
    : v1=registro [$tipo_registro] {$tipoSimbolo=$v1.typeRegistro; $nomes.addAll($registro.nomes);} 
        | tipo_estendido {$tipoSimbolo = $tipo_estendido.tipoSimbolo;} ;

//mais ident complementa a regra identificador e adiciona os outros identficadores declarados juntos
mais_ident returns [List<String> nomes, int linha] 
@init {$nomes = new ArrayList<String>(); $linha=-1;}
: VIRGULA v1=identificador v2=mais_ident
    {
       $nomes.add($v1.txt);
       $nomes.addAll($v2.nomes);
       $linha=$v1.linha;
      }
| ;

//mais variaveis percorre a lista de variaveis declaradas juntas e as adiciona pra a regra variavel tratar	
mais_variaveis returns[ List<String> nomes, String tipoSimbolo, int linha ]
@init {$nomes = new ArrayList<String>(); $tipoSimbolo=""; $linha=-1;}   
: 
variavel f1=mais_variaveis
  { 
         $nomes.addAll($variavel.nomes); 
         $tipoSimbolo=$variavel.tipoSimbolo; 
         $linha=$variavel.linha; 
         $nomes.addAll($f1.nomes);
    } 
|;
      
//verifica e retorna qual tipo básico um identificador é
tipo_basico returns [String tipoSimbolo]
@init {$tipoSimbolo="";}
    : LITERAL {$tipoSimbolo = "literal";}| 
      INTEIRO{$tipoSimbolo = "inteiro";}| 
      REAL {$tipoSimbolo = "real";}| 
      LOGICO {$tipoSimbolo = "logico";};

tipo_basico_ident returns [String tipoSimbolo]
@init {$tipoSimbolo="";}
    : v1=tipo_basico {$tipoSimbolo = $v1.tipoSimbolo;}
| v2= IDENT {$tipoSimbolo = $v2.getText();};

tipo_estendido returns [String tipoSimbolo]
@init {$tipoSimbolo="";}
: ponteiros_opcionais v1=tipo_basico_ident {$tipoSimbolo = $v1.tipoSimbolo;} ;

valor_constante 
    : CADEIA
    | N_INTEIRO
    | N_REAL
    | VERDADEIRO
    | FALSO
    ;

registro [String nome_registro] returns[String typeRegistro, List<String> nomes]
@init {$nomes = new ArrayList<String>();}
: 
REGISTRO
 {
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("registro"));
        if(!$nome_registro.equals(""))
            tabelaRegistros.empilhar(new TabelaDeSimbolos($nome_registro));
        else
            tabelaRegistros.empilhar(new TabelaDeSimbolos("registro"));
    }
variavel mais_variaveis
 {
        for (String s : $variavel.nomes)
        {
            tabelaRegistros.topo().adicionarSimbolo(s, $variavel.tipoSimbolo);
            $nomes.add(s);
        }
        for (String u : $mais_variaveis.nomes)
        {
            //msg_error+=u+"\n";
            tabelaRegistros.topo().adicionarSimbolo(u, $mais_variaveis.tipoSimbolo);
            $nomes.add(u);
        }
        
        $typeRegistro=$variavel.tipoSimbolo;
    }
FIM_REGISTRO
    {
        pilhaDeTabelas.desempilhar();
    };

declaracao_global 
    : PROCEDIMENTO v1=IDENT 
      {
        if(pilhaDeTabelas.topo().existeSimbolo($v1.getText()))
            msg_error += "Linha " + $v1.getLine() + ": identificador "+$v1.getText()+" ja declarado anteriormente\n" ;
        else
        {
            pilhaDeTabelas.topo().adicionarSimbolo($v1.getText(), "procedimento");
            pilhaDeTabelas.empilhar(new TabelaDeSimbolos("procedimento"));
        }
       
    }
      ABRE_PARENTESIS parametros_opcional FECHA_PARENTESIS declaracoes_locais comandos FIM_PROCEDIMENTO  
      {    
        pilhaDeTabelas.desempilhar();
    }
     | FUNCAO v1=IDENT
        {
        if(pilhaDeTabelas.topo().existeSimbolo($v1.getText()))
            msg_error += "Linha " + $v1.getLine() + ": identificador "+$v1.getText()+" ja declarado anteriormente\n" ;
        else
        {
            pilhaDeTabelas.empilhar(new TabelaDeSimbolos("funcao"));
        }
    }
       ABRE_PARENTESIS parametros_opcional FECHA_PARENTESIS DOIS_PONTOS g1=tipo_estendido declaracoes_locais comandos FIM_FUNCAO
     {
        pilhaDeTabelas.desempilhar();
        pilhaDeTabelas.topo().adicionarSimbolo($v1.getText(), $g1.tipoSimbolo);
        
    }
    ;

parametros_opcional : (parametro)?;

parametro: var_opcional v1=identificador v3=mais_ident DOIS_PONTOS v2=tipo_estendido mais_parametros
         {
        if(pilhaDeTabelas.topo().existeSimbolo($v1.txt))
            msg_error += "Linha " + $v1.linha + ": identificador "+$v1.txt+" ja declarado anteriormente\n" ;
        else
        {
             pilhaDeTabelas.topo().adicionarSimbolo($v1.txt, $v2.tipoSimbolo);

             if(tabelaRegistros.existeTabela($v2.tipoSimbolo)!=null)
             {
                 TabelaDeSimbolos tabela_registro = tabelaRegistros.existeTabela($v2.tipoSimbolo);
                 for (String t : tabela_registro.getSimbolos())
                 {
                     pilhaDeTabelas.topo().adicionarSimbolo($v1.txt+t, $v2.tipoSimbolo);
                 }
             }
         }
        
     }
         ;

var_opcional : VAR?;

mais_parametros: (VIRGULA v1=parametro)?;

declaracoes_locais: (declaracao_local)*;

corpo : declaracoes_locais comandos;

comandos : (cmd)*;

cmd returns [ String tipoCmd ]
@init{$tipoCmd="";}
    : LEIA ABRE_PARENTESIS v10=identificador v11=mais_ident
    {    
         if(!pilhaDeTabelas.existeSimbolo($v10.txt))
             msg_error+="Linha " + $v10.linha + ": identificador " + $v10.txt + " nao declarado\n";
         for (String s : $v11.nomes)
         {
             if(!pilhaDeTabelas.existeSimbolo(s))
                 msg_error+="Linha " + $v10.linha + ": identificador " + s + " nao declarado\n";
         }    
    } 
FECHA_PARENTESIS { $tipoCmd = "leia"; }
    | ESCREVA ABRE_PARENTESIS expressao mais_expressao FECHA_PARENTESIS {$tipoCmd="escreva";}
    | SE expressao ENTAO comandos senao_opcional FIM_SE { $tipoCmd = "se"; }
    | CASO exp_aritmetica SEJA selecao senao_opcional FIM_CASO { $tipoCmd = "caso"; }
    | PARA IDENT ATRIBUICAO exp_aritmetica ATE exp_aritmetica FACA comandos FIM_PARA { $tipoCmd = "para"; }
    | ENQUANTO expressao FACA comandos FIM_ENQUANTO { $tipoCmd = "enquanto"; }
    | FACA comandos ATE expressao { $tipoCmd = "faca"; }
    | EXPOENTE v2=IDENT v5=outros_ident dimensao ATRIBUICAO v6=expressao { $tipoCmd = "expoente"; }
      {
        String tipo_expressao = $v6.tipoSimbolo;
        String tipo_ident = pilhaDeTabelas.topo().GetTipoSimbolo($v2.getText());
        if(!tipo_expressao.equals(tipo_ident))
            msg_error+="Linha " + $v2.getLine() + ": atribuicao nao compativel para ^" + $v2.getText()+$v5.txt + "\n";
       
    }
    | v3=IDENT chamada_atribuicao [$v3.text]
        {
          if(!pilhaDeTabelas.existeSimbolo($v3.getText()))
              msg_error+="Linha " + $v3.getLine() + ": identificador " + $v3.getText() + " nao declarado\n";
          //Verificação para ver se o simbolo já foi declarado anteriormente.

      }

    | v4=RETORNE expressao
        {
        String escopoAtual=pilhaDeTabelas.topo().getEscopo();
        if(escopoAtual.equals("funcao")==false){
            msg_error+="Linha " + $v4.getLine() + ": comando retorne nao permitido nesse escopo\n";
      
        }
      }
;

mais_expressao returns[String tipoSimbolo]
@init {$tipoSimbolo="SEM_TIPO";}
: VIRGULA v1=expressao v2=mais_expressao 
{
     if($v2.tipoSimbolo.equals("SEM_TIPO"))
        $tipoSimbolo=$v1.tipoSimbolo;
     else
     {
      if($v1.tipoSimbolo.equals($v2.tipoSimbolo) || $v1.tipoSimbolo.equals("inteiro") && $v2.tipoSimbolo.equals("real") || $v1.tipoSimbolo.equals("real") && $v2.tipoSimbolo.equals("inteiro"))
          $tipoSimbolo=$v1.tipoSimbolo;
      else
          $tipoSimbolo="incompativel";
     }
    }
|;

senao_opcional : (SENAO comandos)?;

chamada_atribuicao [String primeiroIdent]
    : ABRE_PARENTESIS argumentos_opcional FECHA_PARENTESIS
    | v1=outros_ident d1=dimensao v2=ATRIBUICAO e1=expressao 

{
        if(pilhaDeTabelas.existeSimbolo($primeiroIdent+$v1.txt))
        {
            String tipo1 = pilhaDeTabelas.topo().GetTipoSimbolo($primeiroIdent+$v1.txt);
            String tipo2 = $e1.tipoSimbolo;
            if(tipo1.equals(tipo2) || tipo1.equals("inteiro") && tipo2.equals("real") || tipo1.equals("real") && tipo2.equals("inteiro"))
            {
            }
            else
                msg_error+="Linha " + $v2.getLine() + ": atribuicao nao compativel para " + $primeiroIdent+$v1.txt+$d1.txt +"\n";
        }
     
    }
    ;

argumentos_opcional : (expressao mais_expressao)?;

selecao : constantes DOIS_PONTOS comandos mais_selecao;

mais_selecao : (selecao)?;

constantes : numero_intervalo mais_constantes;

mais_constantes : (VIRGULA constantes)?;

numero_intervalo : op_unario N_INTEIRO intervalo_opcional;

intervalo_opcional : (PONTO_PONTO op_unario N_INTEIRO)?;

op_unario : (SUBTRACAO)?;

exp_aritmetica returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
: v1=termo v2=outros_termos
 {
        $txt=$v1.txt;
        if($v2.tipoSimbolo.equals("SEM_TIPO"))
            $tipoSimbolo=$v1.tipoSimbolo;
        else
        {
            if($v1.tipoSimbolo.equals($v2.tipoSimbolo) || $v1.tipoSimbolo.equals("inteiro") && $v2.tipoSimbolo.equals("real") || $v1.tipoSimbolo.equals("real") && $v2.tipoSimbolo.equals("inteiro"))
                $tipoSimbolo=$v1.tipoSimbolo;
            else
                $tipoSimbolo="incompativel";
        }   
    };

op_multiplicacao : MULTIPLICACAO | DIVISAO;

op_adicao : SOMA | SUBTRACAO;

termo returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
:
v1=fator outros_fatores
 { 
        $tipoSimbolo=$v1.tipoSimbolo; 
        $txt=$v1.txt;
    }
;

outros_termos  returns[String tipoSimbolo]
@init{$tipoSimbolo="SEM_TIPO";}
: op_adicao v1=termo v2=outros_termos
{
        if($v2.tipoSimbolo.equals("SEM_TIPO"))
            $tipoSimbolo=$v1.tipoSimbolo;
        else
        {
            if($v1.tipoSimbolo.equals($v2.tipoSimbolo) || $v1.tipoSimbolo.equals("inteiro") && $v2.tipoSimbolo.equals("real") || $v1.tipoSimbolo.equals("real") && $v2.tipoSimbolo.equals("inteiro"))
                $tipoSimbolo=$v1.tipoSimbolo;
            else
                $tipoSimbolo="incompativel";
        }
    }
|;

fator returns [String tipoSimbolo, String txt]
  @init{$tipoSimbolo="SEM_TIPO"; $txt="";}  
    : v1=parcela outras_parcelas
    {
        $tipoSimbolo=$v1.tipoSimbolo; 
        $txt=$v1.txt;
    }
;
  
outros_fatores : (op_multiplicacao fator)*;

parcela returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
    : op_unario v1=parcela_unario
{
        $tipoSimbolo=$v1.tipoSimbolo; 
        $txt=$v1.txt;
    }

| v2= parcela_nao_unario
{
        $tipoSimbolo=$v2.tipoSimbolo; 
        $txt=$v2.txt;
    }
;

parcela_unario returns [String txt, int linha, String tipoSimbolo] 
@init {$txt=""; $linha=-1; $tipoSimbolo="SEM_TIPO";}
    : EXPOENTE v1=IDENT v2=outros_ident dimensao
{ 
        $txt+=$v1.getText()+$v2.txt;
        $linha = $v1.getLine();
       
        if(!pilhaDeTabelas.existeSimbolo($v1.getText()+$v2.txt))
            msg_error+="Linha " + $v1.getLine() + ": identificador " + $v1.getText()+$v2.txt + " nao declarado\n";
        if($v2.txt.equals("")) 
            $tipoSimbolo = pilhaDeTabelas.topo().GetTipoSimbolo($txt);
        else
            $tipoSimbolo = tabelaRegistros.getTipoDoSimbolo($v2.txt.substring(1));
    }
    | v3=IDENT v4=chamada_partes[$v3.getText()]
    {
        $txt+=$v3.getText()+$v4.outrosIdent;
        $linha = $v3.getLine();
        if(!pilhaDeTabelas.existeSimbolo($txt))
            msg_error+="Linha " + $v3.getLine() + ": identificador " + $txt + " nao declarado\n";
        else
        {
            if($v4.tipoSimbolo.equals("SEM_TIPO"))
                $tipoSimbolo = pilhaDeTabelas.topo().GetTipoSimbolo($txt);
            else
                $tipoSimbolo = $v4.tipoSimbolo;
        }
    }             
    | N_INTEIRO  
        {
        $tipoSimbolo = "inteiro"; 
        $txt=$N_INTEIRO.getText();
    }
    | N_REAL 
         {  
        $tipoSimbolo = "real"; 
        $txt=$N_REAL.getText();
    }
    | ABRE_PARENTESIS v7=expressao FECHA_PARENTESIS 
    {
        $tipoSimbolo=$v7.tipoSimbolo;
    }
    ;

parcela_nao_unario returns [String txt, int linha, String tipoSimbolo]
@init {$txt=""; $linha=-1; $tipoSimbolo="SEM_TIPO";}
    : OP_AND v1=IDENT v2=outros_ident
     {
        $txt+=$v1.getText(); 
        $linha = $v1.getLine();
        $txt+= $v2.txt; $tipoSimbolo = pilhaDeTabelas.getTipoDoSimbolo($txt);
    }
dimensao
    | CADEIA 
{
        $tipoSimbolo = "literal"; 
        $txt=$CADEIA.getText();
    }
;

outras_parcelas : (PORCENTAGEM parcela)*;

chamada_partes [String primeiroIdent] returns[String tipoSimbolo, String outrosIdent]
@init {$tipoSimbolo="SEM_TIPO"; $outrosIdent="";}
    : ABRE_PARENTESIS v1=expressao v2=mais_expressao FECHA_PARENTESIS
    | v3=outros_ident dimensao 
     {
        $outrosIdent = $v3.txt;
        $tipoSimbolo = pilhaDeTabelas.topo().GetTipoSimbolo($primeiroIdent+$v3.txt);
    }
    |;

exp_relacional returns [String tipoSimbolo,String txt]
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
    : v1=exp_aritmetica v2=op_opcional
  {
        if($v2.tipoSimbolo.equals("SEM_TIPO"))
            $tipoSimbolo=$v1.tipoSimbolo;
        else
            $tipoSimbolo=$v2.tipoSimbolo;
        $txt=$v1.txt;
    }
;

op_opcional  returns[String tipoSimbolo]
@init{$tipoSimbolo="SEM_TIPO";} 
    : (v1=op_relacional exp_aritmetica
 {
        $tipoSimbolo=$v1.tipoSimbolo;
    }
)? ;

op_relacional returns[String tipoSimbolo]
@init{$tipoSimbolo="SEM_TIPO";}
    : IGUAL {$tipoSimbolo="logico";}
    | DIFERENTE {$tipoSimbolo="logico";}
    | MAIOR_IGUAL {$tipoSimbolo="logico";}
    | MENOR_IGUAL {$tipoSimbolo="logico";}
    | MAIOR {$tipoSimbolo="logico";}
    | MENOR {$tipoSimbolo="logico";};

expressao returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="SEM_TIPO"; $txt="";} 
: v1=termo_logico outros_termos_logicos {$tipoSimbolo=$v1.tipoSimbolo; $txt=$v1.txt;} ;

op_nao : (NAO)?;

termo_logico  returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
: v1=fator_logico outros_fatores_logicos {$tipoSimbolo=$v1.tipoSimbolo; $txt=$v1.txt;};

outros_termos_logicos : (OU termo_logico)*;

outros_fatores_logicos : (E fator_logico)*;

fator_logico returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
: op_nao v1=parcela_logica {$tipoSimbolo=$v1.tipoSimbolo; $txt=$v1.txt;} ;

parcela_logica returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
    : VERDADEIRO {$tipoSimbolo = "logico";}
    | FALSO {$tipoSimbolo = "logico";}
    | v1=exp_relacional {$tipoSimbolo=$v1.tipoSimbolo; $txt=$v1.txt;}
;