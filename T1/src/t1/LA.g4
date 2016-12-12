grammar LA;

@members
{
   public static String grupo="551503, 586773";
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
       for (String s : $variavel.listaVar){
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
                        for (EntradaTabelaDeSimbolos t : tabela_registro.getListaSimbolosTabela()){
                            pilhaDeTabelas.topo().adicionarSimbolo(s+"."+t.getNome(), t.getTipo());
                        }
                    }else{
                        //aqui verificamos o caso de existir uma tabela de registro
                        if(tabelaRegistros.existeTabela("registro")!=null){
                            //recuperamos a tabela de registro 
                            TabelaDeSimbolos tabela_registro = tabelaRegistros.existeTabela("registro");
                            //e adicionamos cada variavel pertencente ao registro a ela
                            for (EntradaTabelaDeSimbolos t : tabela_registro.getListaSimbolosTabela())
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
    | CONSTANTE id=IDENT DOIS_PONTOS tipoBasico=tipo_basico IGUAL valor_constante {
       //primeiro verificamos se existe uma variavel no mesmo escopo com o mesmo nome
       if(pilhaDeTabelas.topo().existeSimbolo($id.getText()))
           // se existir é executado um erro  
            msg_error += "Linha " + $id.getLine() + ": identificador "+$id.getText()+" ja declarado anteriormente\n" ;
        else{
            // se ainda não foi declara nenhuma variavel com esse nome, então o identificador da variável e tipo são
            // adiicionados no escopo atual
            pilhaDeTabelas.topo().adicionarSimbolo($id.getText(), $tipoBasico.tipoSimbolo);
         }
       }
    
      //aqui tratamos da declaração de tipo
    | TIPO id=IDENT DOIS_PONTOS tipoId=tipo[$id.getText()]{
        //primeiro verificamos se já existe um identificador com mesmo nome já declarado
        if(pilhaDeTabelas.topo().existeSimbolo($id.getText()))
           // se existir executa um erro
            msg_error += "Linha " + $id.getLine() + ": identificador "+$id.getText()+" ja declarado anteriormente\n" ;
        else{
           // se não existir então adiciona-se o identificador e tipo no escopo atual
            pilhaDeTabelas.topo().adicionarSimbolo($id.getText(), $tipoId.tipoSimbolo);
            //e também adiciona-se um novo tipo, pois estamos declarando um novo tipo
            tabelaTipos.adicionarSimbolo($id.getText(), $tipoId.tipoSimbolo);  
        }
    }
    ;
    
/* 
 Essa regra retorna uma lista de nomes pq trata a possibilidade de se declarar varias variaveis com mesmo tipo em uma linha só
Ou seja, essa lista terá todos identificadores dessas variáveis declaradas.
Como elas serão do mesmo tipo, então também retorna qual o tipo delas e em qual linha elas estão pra efeito de mensagem de erro
*/
variavel returns[List<String> listaVar, String tipoSimbolo, int linha]
//primeiro inicializamos as variaveis auxiliares, $nomes guardará a lista de identidificadores
    @init {$listaVar = new ArrayList<String>(); $tipoSimbolo=""; $linha=-1;}
//aqui colocamos variaveis auxiliares para auxiliar na recuperação da informação
    : id=IDENT dimensao maisVar=mais_var DOIS_PONTOS tipoVar=tipo[$tipoSimbolo]{
        $tipoSimbolo = $tipoVar.tipoSimbolo;
        $listaVar.add($id.getText());
        $listaVar.addAll($maisVar.listaVar);
        if($maisVar.linha==-1){
            $linha = $id.getLine();
        }else{
            $linha = $maisVar.linha;
        }
       
    }
;

/*Essa regra é executada quando se tem mais variaveis declaradas do mesmo tipo na mesma linha
ela retorna uma lista de nomes que são os identificadores e a linha que estão*/
mais_var returns[ List<String> listaVar, int linha ] 
//inicialização dos valores
    @init { $listaVar = new ArrayList<String>(); $linha=-1; }
    : (VIRGULA id=IDENT {
        //depois que chegamos no identidicador fazemos um processamento para verificar se ele já existe
        if(!pilhaDeTabelas.existeSimbolo($id.getText())){
            // se não existe, então adicionamos ele na lista de nomes e pegamos a linha dele
            $listaVar.add($id.getText());
            $linha = $id.getLine();
        }
        else{
            //se já existir um identificador com mesmo nome é disprada uma mensagem de erro
            msg_error+="Linha " + $id.getLine() + ": identificador " + $id.getText() + " ja declarado anteriormente\n";
           
        }
     }dimensao)*;
//lembrando que essa regra é recursiva, então para todos os identificadores encontrados eles serão adicionados na lista de nomes
// e anteriormente verificados se já existem


//essa regra trata os identificadores
//retorna o nome deles, a linha e o tipo deles
identificador returns [ String nomeID, int linha, String tipoSimbolo]
//inicialização de valores
    @init { $nomeID = ""; $linha=-1; $tipoSimbolo="TIPO_NAO_DECLARADO";}
    :   
    
        ponteiros_opcionais id=IDENT dimensao outrosID=outros_ident{
        // essa regra se for um registro então é retornado uma string com o nome do identificador '.' atributo
        // são os casos de por exemplo pessoa.nome tipo=pessoa, variavel do tipo = nome
        // a concatenação do ponto será feita na regra outros_ident
        $nomeID += $id.text+$outrosID.txt;
        $linha = $id.getLine();
        $tipoSimbolo = pilhaDeTabelas.topo().getTipoSimbolo($nomeID); //error
    }
;

ponteiros_opcionais : (EXPOENTE)*;

outros_ident returns [ String txt ]
@init {$txt="";}
: 
(PONTO id=identificador { $txt = "."+$id.nomeID; })?;

//concatena o formado de vetores com [dimensao]
dimensao  returns [String txt]
@init {$txt="";}
: 
(ABRE_COLCHETE exp=exp_aritmetica FECHA_COLCHETE {$txt= "[" + $exp.txt + "]";})*;

//tipo retorna o tipo e uma lista de nomes
//PODE TER ERRO AQUI
tipo [String tipo_registro] returns [String tipoSimbolo, List<String> nomesVar ]
    @init {$tipoSimbolo=""; $nomesVar = new ArrayList<String>();}
    : reg=registro [$tipo_registro] {$tipoSimbolo=$reg.tipoRegistro; $nomesVar.addAll($registro.nomesVar);} 
        | tipo_estendido {$tipoSimbolo = $tipo_estendido.tipoSimbolo;} ;

//mais ident complementa a regra identificador e adiciona os outros identficadores declarados juntos
mais_ident returns [List<String> nomesVar, int linha] 
@init {$nomesVar = new ArrayList<String>(); $linha=-1;}
: VIRGULA id=identificador maisID=mais_ident
    {
       $nomesVar.add($id.nomeID);
       $nomesVar.addAll($maisID.nomesVar);
       $linha=$id.linha;
      }
| ;

//mais variaveis percorre a lista de variaveis declaradas juntas e as adiciona pra a regra variavel tratar	
mais_variaveis returns[ List<String> nomesVar, String tipoSimbolo, int linha ]
@init {$nomesVar = new ArrayList<String>(); $tipoSimbolo=""; $linha=-1;}   
: 
variavel maisVar=mais_variaveis
  { 
         $nomesVar.addAll($variavel.listaVar); 
         $tipoSimbolo=$variavel.tipoSimbolo; 
         $linha=$variavel.linha; 
         $nomesVar.addAll($maisVar.nomesVar);
    } 
|;
      
//verifica e retorna qual tipo básico um identificador é
tipo_basico returns [String tipoSimbolo]
@init {$tipoSimbolo="";}
    : LITERAL {$tipoSimbolo = "literal";}| 
      INTEIRO{$tipoSimbolo = "inteiro";}| 
      REAL {$tipoSimbolo = "real";}| 
      LOGICO {$tipoSimbolo = "logico";};

// aqui é quando um identificador tem um tipo novo que não é o basico
tipo_basico_ident returns [String tipoSimbolo]
@init {$tipoSimbolo="";}
    : tipoB=tipo_basico {$tipoSimbolo = $tipoB.tipoSimbolo;}
| id= IDENT {$tipoSimbolo = $id.getText();};

tipo_estendido returns [String tipoSimbolo]
@init {$tipoSimbolo="";}
: ponteiros_opcionais tipoBasicoID=tipo_basico_ident {$tipoSimbolo = $tipoBasicoID.tipoSimbolo;} ;

valor_constante 
    : CADEIA
    | N_INTEIRO
    | N_REAL
    | VERDADEIRO
    | FALSO
    ;

/*Recebe como parametro o nome do registro
E retorna o tipo do registro e uma lista de nomes associadas ao registro*/
registro [String nomeRegistro] returns[String tipoRegistro, List<String> nomesVar]
@init {$nomesVar = new ArrayList<String>();}
: 
REGISTRO
 {
        /*Quando um registro é declarado empilha-se uma nova tabela de simbolos de registro*/
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("registro"));
        /*Aqui verifica-se se o nome do registro não é vazio*/
        if(!$nomeRegistro.equals("")){
            /* se não for empilha na tabela de registros uma nova tabela de simbolo associada ao registro,
            ou seja, a tabela de registros guarda todos os registros declarados e os nomes associados a cada um deles*/
            tabelaRegistros.empilhar(new TabelaDeSimbolos($nomeRegistro));
        }else{
            /*Se o nome de registro é vazio então cria-se uma tabela de registro com nome registro padrao*/
            tabelaRegistros.empilhar(new TabelaDeSimbolos("registro"));
        }
    }
/*Nessa parte tratamos assim como nas outras regras, a existencia da variavel com mesmo identificador no escopo
e adicionamos todas as variaveis associadas com o mesmo tipo*/
variavel mais_variaveis
 {
        /*Percorremos todas as variaveis declaradas juntas
        Quem vai auxiliar nessa regra é a regra mais_variaveis que retornará uma lista de nomes, linha e tipo*/
        for (String s : $variavel.listaVar)
        {
            //adiciona o simbolo na tabela de registros
            tabelaRegistros.topo().adicionarSimbolo(s, $variavel.tipoSimbolo);
            $nomesVar.add(s);
        }
        for (String u : $mais_variaveis.nomesVar)
        {
            tabelaRegistros.topo().adicionarSimbolo(u, $mais_variaveis.tipoSimbolo);
            $nomesVar.add(u);
        }
        
        $tipoRegistro=$variavel.tipoSimbolo;
    }
FIM_REGISTRO
    {
        //ao final do registro desempilha-se a tabela
        pilhaDeTabelas.desempilhar();
    };

declaracao_global 
    /*Declaração de procedimento*/
    : PROCEDIMENTO id=IDENT 
      {
       /*Verifica-se se já não foi declarado um identificador com mesmo nome*/
        if(pilhaDeTabelas.topo().existeSimbolo($id.getText())){
         /*Se foi, emite-se um erro*/
            msg_error += "Linha " + $id.getLine() + ": identificador "+$id.getText()+" ja declarado anteriormente\n" ;
        }else{
            /*Se o identificador é valido então coloca-se o procedimento na pilha de tabelas*/
            pilhaDeTabelas.topo().adicionarSimbolo($id.getText(), "procedimento");
            /*E empilha-se uma nova tabela de simbolos associada ao procedimento*/
            pilhaDeTabelas.empilhar(new TabelaDeSimbolos("procedimento"));
        }
       
    }
      ABRE_PARENTESIS parametros_opcional FECHA_PARENTESIS declaracoes_locais comandos FIM_PROCEDIMENTO{    
        /*Ao final da declaracao do procedimento, desempilha-se da pilha de tabelas*/
        pilhaDeTabelas.desempilhar();
      }
      
      /*Declaração de função, segue mesmo tratamento de procedimento mas tem um retorno no final que deve
      ser tratado (vai ser tratado na regra comandos*/
     | FUNCAO id=IDENT
        {
        if(pilhaDeTabelas.topo().existeSimbolo($id.getText()))
            msg_error += "Linha " + $id.getLine() + ": identificador "+$id.getText()+" ja declarado anteriormente\n" ;
        else
        {
            pilhaDeTabelas.empilhar(new TabelaDeSimbolos("funcao"));
        }
    }
       ABRE_PARENTESIS parametros_opcional FECHA_PARENTESIS DOIS_PONTOS tipoExt=tipo_estendido declaracoes_locais comandos FIM_FUNCAO
     {
        pilhaDeTabelas.desempilhar();
        /*é necessario empilhar um simbolo que é o nome da função no escopo atual*/
        pilhaDeTabelas.topo().adicionarSimbolo($id.getText(), $tipoExt.tipoSimbolo);
        
     }
    ;

parametros_opcional : (parametro)?;

/*Tratamento de parametros*/
parametro: var_opcional id=identificador mais_ident DOIS_PONTOS tipoExt=tipo_estendido mais_parametros{
        /*Verifica-se  se já existe um simbolo com mesmo nome declarado*/
        if(pilhaDeTabelas.topo().existeSimbolo($id.nomeID)){
            /*Se existir é disparado um erro*/
            msg_error += "Linha " + $id.linha + ": identificador "+$id.nomeID+" ja declarado anteriormente\n" ;
        }else{
              /*se não adiciona-se o simbolo juntamente com seu tipo na pilha de tabelas*/
             pilhaDeTabelas.topo().adicionarSimbolo($id.nomeID, $tipoExt.tipoSimbolo);
             /*se o tipo é um registro, fazemos as declarações adicionais na variavel*/
             if(tabelaRegistros.existeTabela($tipoExt.tipoSimbolo)!=null)
             {
                 /*Recupera a tabela associada*/
                 TabelaDeSimbolos tabela_registro = tabelaRegistros.existeTabela($tipoExt.tipoSimbolo);
                 /*Pega todos os simbolos associados e adicionamos novamente a pilha de tabelas*/
                 for (String simbolos : tabela_registro.getSimbolos())
                 {
                     pilhaDeTabelas.topo().adicionarSimbolo($id.nomeID+simbolos, $tipoExt.tipoSimbolo);
                 }
             }
         }
        
     }
         ;

var_opcional : VAR?;

/*Trata da declaração de mais de um parametro na funcao*/
mais_parametros: (VIRGULA parametro)?;

declaracoes_locais: (declaracao_local)*;

corpo : declaracoes_locais comandos;

comandos : (cmd)*;

/*Cmd retorna o tipo de comando que está sendo executado
Comandos podem ser leia, escreva, se, caso, para, enquanto, faça (...)*/
cmd returns [ String tipoComando ]
@init{$tipoComando="";}
    : LEIA ABRE_PARENTESIS id=identificador maisID=mais_ident{ 
         /*Verifica-se se existe o identificador usado no comando*/
         if(!pilhaDeTabelas.existeSimbolo($id.nomeID)){
             /*se não existe, então quer dizer que ele não pode ser usado pq não foi declarado
              então é adicionado um erro*/
             msg_error+="Linha " + $id.linha + ": identificador " + $id.nomeID + " nao declarado\n";
         }
         /*Caso exista então é valido usar então verificamos se as outras variaveis também existem
         porque de acordo com as regras da linguagem posso ler um valor atribuido a varias variaveis*/
         for (String nome : $maisID.nomesVar)
         {   
            /*Caso alguma variavel usada no comando leia não exista é emitido um erro*/
             if(!pilhaDeTabelas.existeSimbolo(nome)){
                 msg_error+="Linha " + $id.linha + ": identificador " + nome + " nao declarado\n";
            }
         }    
    } 
    FECHA_PARENTESIS {  
        /*Atribuimos o tipo como leia*/
         $tipoComando = "leia"; 
    }
    | ESCREVA ABRE_PARENTESIS expressao mais_expressao FECHA_PARENTESIS {
        /*Como não usamos nenhum identificador nessa regra, então só atibuimos o tipo do comando como 'escreva'*/
        $tipoComando="escreva";
    }
    | SE expressao ENTAO comandos senao_opcional FIM_SE { 
        /*Como não usamos nenhum identificador nessa regra, então só atribuimos o tipo do comando como 'se'*/
        $tipoComando = "se"; 
    }
    | CASO exp_aritmetica SEJA selecao senao_opcional FIM_CASO { 
        /*Como não usamos nenhum identificador nessa regra, então só atribuimos o tipo do comando como 'caso'*/
        $tipoComando = "caso"; 
    }
    | PARA IDENT ATRIBUICAO exp_aritmetica ATE exp_aritmetica FACA comandos FIM_PARA { 
        
        $tipoComando = "para"; 
    }
    | ENQUANTO expressao FACA comandos FIM_ENQUANTO { 
        /*Como não usamos nenhum identificador nessa regra, então só atribuimos o tipo do comando como 'enquanto'*/
        $tipoComando = "enquanto"; 
    }
    | FACA comandos ATE expressao {
        /*Como não usamos nenhum identificador nessa regra, então só atribuimos o tipo do comando como 'faca'*/
        $tipoComando = "faca"; 
    }
    | EXPOENTE idExp=IDENT outrosId=outros_ident dimensao ATRIBUICAO exp=expressao { 
        /*Como usanmos o identificador, enão devemos tratá-lo*/
        $tipoComando = "expoente"; 
        /*verificamos qual o tipo da expressao*/
        String tipo_expressao = $exp.tipoSimbolo;
        /*verificamos qual o tipo do identificador*/
        String tipo_ident = pilhaDeTabelas.topo().getTipoSimbolo($idExp.getText());
        /*Se o tipo da expressão não for compativel com o tipo do identificador então emite-se um erro*/
        if(!tipo_expressao.equals(tipo_ident))
            msg_error+="Linha " + $idExp.getLine() + ": atribuicao nao compativel para ^" + $idExp.getText()+$outrosId.txt + "\n";
    }
    | idCh=IDENT chamada_atribuicao [$idCh.text]{
          /*Verificação se existe o identificador, se não existir emite-se um erro*/
          if(!pilhaDeTabelas.existeSimbolo($idCh.getText())){
              msg_error+="Linha " + $idCh.getLine() + ": identificador " + $idCh.getText() + " nao declarado\n";
          }
       }

    | ret=RETORNE expressao{
        /*Aqui fazemos o tratamento do retorne nas funcoes*/
        /*Primeiro pegamos o escopo atual*/
        String escopoAtual=pilhaDeTabelas.topo().getEscopo();
        /*Depois verificamos se o escopo atual é funcao, se não for função então o comando não pode ser usado nesse escopo
        então emite-se um erro*/
        if(escopoAtual.equals("funcao")==false){
            msg_error+="Linha " + $ret.getLine() + ": comando retorne nao permitido nesse escopo\n";
        }
      }
;

/*Nessa regra, colocamos regras para os tipos de simbolos compativeis*/
mais_expressao returns[String tipoSimbolo]
@init {$tipoSimbolo="TIPO_NAO_DECLARADO";}
: VIRGULA exp=expressao maisExp=mais_expressao 
{
     if($maisExp.tipoSimbolo.equals("TIPO_NAO_DECLARADO"))
        $tipoSimbolo=$exp.tipoSimbolo;
     else{
      if($exp.tipoSimbolo.equals($maisExp.tipoSimbolo) || $exp.tipoSimbolo.equals("inteiro") && $maisExp.tipoSimbolo.equals("real") || $exp.tipoSimbolo.equals("real") && $maisExp.tipoSimbolo.equals("inteiro")){
          $tipoSimbolo=$exp.tipoSimbolo;
       }else{
          $tipoSimbolo="incompativel";
      }
     }
    }
|;

senao_opcional : (SENAO comandos)?;

/*Verificação de tipos compativeis para atribuição AQUI ESTÁ O ERRO*/
chamada_atribuicao [String primeiroIdent]
    : ABRE_PARENTESIS argumentos_opcional FECHA_PARENTESIS
    | id=outros_ident dimen=dimensao atr=ATRIBUICAO exp=expressao 

{
        if(pilhaDeTabelas.existeSimbolo($primeiroIdent+$id.txt))
        {
            String tipo1 = pilhaDeTabelas.topo().getTipoSimbolo($primeiroIdent+$id.txt);
            String tipo2 = $exp.tipoSimbolo;
            if(!(tipo1.equals(tipo2) || tipo1.equals("inteiro") && tipo2.equals("real") || tipo1.equals("real") && tipo2.equals("inteiro"))){
                msg_error+="Linha " + $atr.getLine() + ": atribuicao nao compativel para " + $primeiroIdent+$id.txt+$dimen.txt +"\n";
            }
                
        }else{
             msg_error+="Linha " + $atr.getLine() + ": identificador " + $atr.getText() + " nao declarado\n";
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

/*Retorna o tipo simbolo e qual é o termo
Faz a verificacao da compatibilidade dos termos*/
exp_aritmetica returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="TIPO_NAO_DECLARADO"; $txt="";}
: termo1=termo termo2=outros_termos
 {
        $txt=$termo1.txt;
        if($termo2.tipoSimbolo.equals("TIPO_NAO_DECLARADO"))
            $tipoSimbolo=$termo1.tipoSimbolo;
        else
        {
            if($termo1.tipoSimbolo.equals($termo2.tipoSimbolo) || $termo1.tipoSimbolo.equals("inteiro") && $termo2.tipoSimbolo.equals("real") || $termo1.tipoSimbolo.equals("real") && $termo2.tipoSimbolo.equals("inteiro"))
                $tipoSimbolo=$termo1.tipoSimbolo;
            else
                $tipoSimbolo="incompativel";
        }   
    };

op_multiplicacao : MULTIPLICACAO | DIVISAO;

op_adicao : SOMA | SUBTRACAO;

/*Retorna o tipo do simbolo do termo e seu nome*/
termo returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="TIPO_NAO_DECLARADO"; $txt="";}
:
fat=fator outros_fatores
 { 
        $tipoSimbolo=$fat.tipoSimbolo; 
        $txt=$fat.txt;
    }
;
/*Retorna o tipo do simbolo do outros termos e verifica compatibilidade*/
outros_termos  returns[String tipoSimbolo]
@init{$tipoSimbolo="TIPO_NAO_DECLARADO";}
: op_adicao termo1=termo termo2=outros_termos
{
        if($termo2.tipoSimbolo.equals("TIPO_NAO_DECLARADO"))
            $tipoSimbolo=$termo1.tipoSimbolo;
        else
        {
            if($termo1.tipoSimbolo.equals($termo2.tipoSimbolo) || $termo1.tipoSimbolo.equals("inteiro") && $termo2.tipoSimbolo.equals("real") || $termo1.tipoSimbolo.equals("real") && $termo2.tipoSimbolo.equals("inteiro"))
                $tipoSimbolo=$termo1.tipoSimbolo;
            else
                $tipoSimbolo="incompativel";
        }
    }
|;
/*Retorna tipo do simbolo do fator e seu nome*/
fator returns [String tipoSimbolo, String txt]
  @init{$tipoSimbolo="TIPO_NAO_DECLARADO"; $txt="";}  
    : parc=parcela outras_parcelas
    {
        $tipoSimbolo=$parc.tipoSimbolo; 
        $txt=$parc.txt;
    }
;
  
outros_fatores : (op_multiplicacao fator)*;

/*Retorna o tipo do simbolo da parcela e nome*/
parcela returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="TIPO_NAO_DECLARADO"; $txt="";}
    : op_unario parcUnario=parcela_unario{
        $tipoSimbolo=$parcUnario.tipoSimbolo; 
        $txt=$parcUnario.txt;
    }

| parcNUnario= parcela_nao_unario
{
        $tipoSimbolo=$parcNUnario.tipoSimbolo; 
        $txt=$parcNUnario.txt;
    }
;
/*Retorna o nome, linha e tipo do simbolo da parcela*/
parcela_unario returns [String txt, int linha, String tipoSimbolo] 
@init {$txt=""; $linha=-1; $tipoSimbolo="TIPO_NAO_DECLARADO";}
    : EXPOENTE id=IDENT outrosID=outros_ident dimensao
{ 
        $txt+=$id.getText()+$outrosID.txt;
        $linha = $id.getLine();
       /*Verificamos se os identificadores usados já foram declarados*/
        if(!pilhaDeTabelas.existeSimbolo($id.getText()+$outrosID.txt)){
        /*Se não foi emite um erro*/
            msg_error+="Linha " + $id.getLine() + ": identificador " + $id.getText()+$outrosID.txt + " nao declarado\n";
        }
        if($outrosID.txt.equals("")) 
            $tipoSimbolo = pilhaDeTabelas.topo().getTipoSimbolo($txt);
        else
            $tipoSimbolo = tabelaRegistros.getTipoDoSimbolo($outrosID.txt.substring(1));
    }
    | idCh=IDENT chP=chamada_partes[$idCh.getText()]
    {
        $txt+=$idCh.getText()+$chP.outrosIdent;
        $linha = $idCh.getLine();
        /*Verifica-se se o simbolo foi declarado*/
        if(!pilhaDeTabelas.existeSimbolo($txt))
            msg_error+="Linha " + $idCh.getLine() + ": identificador " + $txt + " nao declarado\n";
        else
        {
            if($chP.tipoSimbolo.equals("TIPO_NAO_DECLARADO"))
                $tipoSimbolo = pilhaDeTabelas.topo().getTipoSimbolo($txt);
            else
                $tipoSimbolo = $chP.tipoSimbolo;
        }
    }             
    /*Se o simbolo é um numero inteiro então retorna o tipo inteiro e o nome*/
    | N_INTEIRO{
        $tipoSimbolo = "inteiro"; 
        $txt=$N_INTEIRO.getText();
    }
    /*Se o simbolo é um numero inteiro então retorna o tipo real e o nome*/
    | N_REAL {  
        $tipoSimbolo = "real"; 
        $txt=$N_REAL.getText();
    }
    | ABRE_PARENTESIS v7=expressao FECHA_PARENTESIS {
        $tipoSimbolo=$v7.tipoSimbolo;
    }
    ;

/*Retorna o simbolo, tipo e linha que foi declarado*/
parcela_nao_unario returns [String txt, int linha, String tipoSimbolo]
@init {$txt=""; $linha=-1; $tipoSimbolo="TIPO_NAO_DECLARADO";}
    : OP_AND id=IDENT outrosID=outros_ident
     {
        $txt+=$id.getText(); 
        $linha = $id.getLine();
        $txt+= $outrosID.txt; $tipoSimbolo = pilhaDeTabelas.getTipoDoSimbolo($txt);
    }
dimensao
    | CADEIA 
{
        $tipoSimbolo = "literal"; 
        $txt=$CADEIA.getText();
    }
;

outras_parcelas : 
    (PORCENTAGEM parcela)*;

/*recebe o identificador como parametro para retornar o tipo do simbolo e retorna também os outros identificadores*/
chamada_partes [String primeiroIdent] returns[String tipoSimbolo, String outrosIdent]
@init {$tipoSimbolo="TIPO_NAO_DECLARADO"; $outrosIdent="";}
    : ABRE_PARENTESIS expressao mais_expressao FECHA_PARENTESIS
    | outrosID=outros_ident dimensao 
     {
        $outrosIdent = $outrosID.txt;
        $tipoSimbolo = pilhaDeTabelas.topo().getTipoSimbolo($primeiroIdent+$outrosID.txt);
    }
    |;
/*Retorna tipo e nome do identificador*/
exp_relacional returns [String tipoSimbolo,String txt]
@init{$tipoSimbolo="TIPO_NAO_DECLARADO"; $txt="";}
    : exp=exp_aritmetica opOp=op_opcional
  {
        if($opOp.tipoSimbolo.equals("TIPO_NAO_DECLARADO"))
            $tipoSimbolo=$exp.tipoSimbolo;
        else
            $tipoSimbolo=$opOp.tipoSimbolo;
        $txt=$exp.txt;
    }
;

/*Retorna tipo do operador opcional*/
op_opcional  returns[String tipoSimbolo]
@init{$tipoSimbolo="TIPO_NAO_DECLARADO";} 
    : (opRel=op_relacional exp_aritmetica{
        $tipoSimbolo=$opRel.tipoSimbolo;
    }
)? ;

/*Retorna tipo do operador relacional*/
op_relacional returns[String tipoSimbolo]
@init{$tipoSimbolo="TIPO_NAO_DECLARADO";}
    : IGUAL {
        $tipoSimbolo="logico";
    }
    | DIFERENTE {
        $tipoSimbolo="logico";
    }
    | MAIOR_IGUAL {
        $tipoSimbolo="logico";
    }
    | MENOR_IGUAL {
        $tipoSimbolo="logico";
    }
    | MAIOR {
        $tipoSimbolo="logico";
    }
    | MENOR {
        $tipoSimbolo="logico";
    };

expressao returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="TIPO_NAO_DECLARADO"; $txt="";} 
: termoLog=termo_logico outros_termos_logicos {
        $tipoSimbolo=$termoLog.tipoSimbolo; $txt=$termoLog.txt;
    } ;

op_nao : (NAO)?;

termo_logico  returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="TIPO_NAO_DECLARADO"; $txt="";}
: fatLog=fator_logico outros_fatores_logicos {
    $tipoSimbolo=$fatLog.tipoSimbolo; $txt=$fatLog.txt;
   };

outros_termos_logicos : (OU termo_logico)*;

outros_fatores_logicos : (E fator_logico)*;

fator_logico returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="TIPO_NAO_DECLARADO"; $txt="";}
: op_nao parcLog=parcela_logica {
        $tipoSimbolo=$parcLog.tipoSimbolo; $txt=$parcLog.txt;
} ;

parcela_logica returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="TIPO_NAO_DECLARADO"; $txt="";}
    : VERDADEIRO {
        $tipoSimbolo = "logico";
    }
    | FALSO {
        $tipoSimbolo = "logico";
    }
    | exp=exp_relacional {
        $tipoSimbolo=$exp.tipoSimbolo; $txt=$exp.txt;
}
;