grammar LA;

@members {
   public static String grupo="";
   PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
   TabelaDeSimbolos TabelaDeTipos = new TabelaDeSimbolos("tipos");
   PilhaDeTabelas TabelasDeRegistros = new PilhaDeTabelas();
   String error="";
   
/*
Pilha de tabelas: armazena as pilhas utilizadas para análise sintática
Tabela de Registros: armazena os registros declarados
Tabela de Tipo: armazena tipos (inteiros, reais e outros)
Error: acusa o erro durante análise semantica
*/
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

programa : 
         { 
             pilhaDeTabelas.empilhar(new TabelaDeSimbolos("global"));
             TabelaDeTipos.adicionarSimbolo("literal", "literal");
             TabelaDeTipos.adicionarSimbolo("inteiro", "inteiro");
             TabelaDeTipos.adicionarSimbolo("real", "real");
             TabelaDeTipos.adicionarSimbolo("logico", "logico");
                          
          }
          declaracoes ALGORITMO corpo FIM_ALGORITMO
          { 
              //Fim do programa desempilha, casp erro é lançada uma exceção e armazenada na varivável error
              pilhaDeTabelas.desempilhar();
              if(error!="")throw new RuntimeException(error);
          }
         ;

declaracoes : decl_local_global declaracoes 
            |
            ;

decl_local_global : decl_local
                  | declaracao_global
                  ;

decl_local 
    : DECLARE variavel
    {
        for (String s : $variavel.nomes)
        {
            // Verificacao se a variável não foi declarada já
            if(pilhaDeTabelas.topo().existeSimbolo(s)){
                error += "Linha " + $variavel.linha + ": identificador "+s+" ja declarado anteriormente\n" ;
            //se não foi declarada
            }else{
                //verifica se o tipo existe e é válido
	        if(TabelaDeTipos.existeSimbolo($variavel.tipoSimbolo)){
                    // Se existe, a nova variável é adicionada na tabela de simbolos do escopo atual
                    pilhaDeTabelas.topo().adicionarSimbolo(s, $variavel.tipoSimbolo);
                    //se for um registro, declaramos todas as variáveis do registro
                    if(TabelasDeRegistros.existeTabela($variavel.tipoSimbolo)!=null){
                        TabelaDeSimbolos tabelaRegistro = TabelasDeRegistros.existeTabela($variavel.tipoSimbolo);
                        for (EntradaTabelaDeSimbolos t : tabelaRegistro.getListaSimbolos()){
                            pilhaDeTabelas.topo().adicionarSimbolo(s+"."+t.getNome(), t.getTipo());
                        }
                    }
                    else{
                    //Se não foi encontrado o tipo, verifica-se se ele é um registro
                    if(TabelasDeRegistros.existeTabela("registro")!=null){
                         //Se é um registro e ainda não foi declarada, então registra-se
                            TabelaDeSimbolos tabelaRegistro = TabelasDeRegistros.existeTabela("registro");
                            //declara-se todas as variaveis desse registro
                            for (EntradaTabelaDeSimbolos t : tabelaRegistro.getListaSimbolos()){
                                // um registro é formado por (nomeRegistro . nomevariavel tipo)                                                    
                                pilhaDeTabelas.topo().adicionarSimbolo(s+"."+t.getNome(), t.getTipo());
                            }
                         }
                    }   
                }
                // se não for nenhum tipo da linguagem, erro de tipo nao declarado
                else{ 
                    error += "Linha " + $variavel.linha + ": tipo "+$variavel.tipoSimbolo+" nao declarado\n" ;
                    pilhaDeTabelas.topo().adicionarSimbolo(s, $variavel.tipoSimbolo);
                }
            }
        }
    }
    | CONSTANTE v1=IDENT DOIS_PONTOS v2=tipo_basico IGUAL valor_constante
    {
        // declaração de constante: primeiro verificamos se existe uma variavel com o mesmo nome IDENT
        if(pilhaDeTabelas.topo().existeSimbolo($v1.getText()))
          // se já foi declarada, então acusa erro de identificador já declarado
            error += "Linha " + $v1.getLine() + ": identificador "+$v1.getText()+" ja declarado anteriormente\n" ;
        //se não foi declarado ainda, adiciona-se o simbolo (v1) e o tipo (v2) na tabela do escopo atual
        else{
            pilhaDeTabelas.topo().adicionarSimbolo($v1.getText(), $v2.tipoSimbolo);
        }
    }
    | TIPO v1=IDENT DOIS_PONTOS v3=tipo[$v1.getText()]
    {
        // se é um novo tipo
        //verifica se não há o mesmo simbolo declarado no escopo atual
        if(pilhaDeTabelas.topo().existeSimbolo($v1.getText())){
            // se existe, acusa erro de declaração já feita anteriormente
            error += "Linha " + $v1.getLine() + ": identificador "+$v1.getText()+" ja declarado anteriormente\n" ;
            }else{
            //se não foi, adiciona na tabela do escopo atual
            pilhaDeTabelas.topo().adicionarSimbolo($v1.getText(), $v3.tipoSimbolo);
            // além disso, temos que adicionar na tabela de tipos,pois é um novo tipo
            TabelaDeTipos.adicionarSimbolo($v1.getText(), $v3.tipoSimbolo);
        }
    }
    ;

variavel returns[List<String> nomes, String tipoSimbolo, int linha]
//nome = identificador
@init {$nomes = new ArrayList<String>(); $tipoSimbolo=""; $linha=-1;}
    : v1=IDENT dimensao v2=mais_var DOIS_PONTOS m3=tipo[$tipoSimbolo] 
    {    
        int i=0;
        $tipoSimbolo = $m3.tipoSimbolo;
        $nomes.add($v1.getText());
        $nomes.addAll($v2.nomes);
        if($v2.linha==-1)
            $linha = $v1.getLine();
        else
            //mais var
            $linha = $v2.linha;
    }
    ;

mais_var returns[ List<String> nomes, int linha ]
//retorna uma lista de identificadores, o tipo dos identificadores e a linha em que foi declarada, pode não retornar nada
@init { $nomes = new ArrayList<String>(); $linha=-1; }
//mais var significa que outras variaveis do mesmo tipo foram declaradas
    : (VIRGULA v1=IDENT{
        // verifica se já existe a variavel
        if(!pilhaDeTabelas.existeSimbolo($v1.getText())){
            // se não existe pega ela (v1) e adiciona seu nome (identificador) e a linha que foi declarada
            $nomes.add($v1.getText());
            $linha = $v1.getLine();
        }
        else{
            //se já foi declarada, então acusa erro
            error+="Linha " + $v1.getLine() + ": identificador " + $v1.getText() + " ja declarado anteriormente\n";
            
        }
     }
    //no caso de ser um vetor
    dimensao)*
    ;

identificador returns [ String txt, int linha, String tipoSimbolo ]
//retorna o nome dele, tipo e linha
//começamos com sem tipo, se mudar ja sabemos que é válido
@init { $txt = ""; $linha=-1; $tipoSimbolo="SEM_TIPO";}
    : ponteiros_opcionais v1=IDENT dimensao v2=outros_ident 
    {
        $txt += $v1.text+$v2.txt;
        $linha = $v1.getLine();
        $tipoSimbolo = pilhaDeTabelas.topo().getTipo($text);
    }
    ;

ponteiros_opcionais : EXPOENTE*;

outros_ident returns [ String txt ]
//outros_ident retorna um campo texto que é utilizado quando temos variáveis que são de tipos de registros
// exemplo: casa.endereço, casa.cor
@init {$txt="";}
    : PONTO id=identificador { $txt = "."+$id.txt; }
    |
    ;
	
dimensao returns [String txt]
// dimensão retorna um campo texto, é necessário quando temos operações com vetores
@init {$txt="";}
    : ABRE_COLCHETE v1=exp_aritmetica FECHA_COLCHETE dimensao {$txt= "[" + $v1.txt + "]";}
    |
    ;

tipo[String tipo_registro] returns [String tipoSimbolo, List<String> nomes ]
//tipo retorna o tipo que é correspondente e uma lista de nomes que identifica as variáveis associadas à este tipo
@init {$tipoSimbolo=""; $nomes = new ArrayList<String>();}
    : v1=registro[$tipo_registro] {$tipoSimbolo=$v1.typeRegistro; $nomes.addAll($registro.nomes);}
    | tipo_estendido {$tipoSimbolo = $tipo_estendido.tipoSimbolo;}
    ;

mais_ident returns [List<String> nomes, int linha]
//mais_ident retorna uma lista de variáveis declaradas (pode ser vazia) e a linha em que foram declaradas
@init {$nomes = new ArrayList<String>(); $linha=-1;}
    : VIRGULA v1=identificador v2=mais_ident 
      {
       $nomes.add($v1.txt);
       $nomes.addAll($v2.nomes);
       $linha=$v1.linha;
      }
    |
    ;
	
mais_variaveis returns[ List<String> nomes, String tipoSimbolo, int linha ]
//mais_variaveis retorna uma lista de variáveis declaradas (pode ser vazia), o tipo dessas variáveis e a linha em que foram declaradas
@init {$nomes = new ArrayList<String>(); $tipoSimbolo=""; $linha=-1;}
    : variavel f1=mais_variaveis 
    { 
         $nomes.addAll($variavel.nomes); 
         $tipoSimbolo=$variavel.tipoSimbolo; 
         $linha=$variavel.linha; 
         $nomes.addAll($f1.nomes);
    } 
    | 
    ;
      

tipo_basico returns [String tipoSimbolo]
@init {$tipoSimbolo="";}
    : LITERAL {$tipoSimbolo = "literal";}
    | INTEIRO {$tipoSimbolo = "inteiro";}
    | REAL    {$tipoSimbolo = "real";}
    | LOGICO  {$tipoSimbolo = "logico";}
    ;

tipo_basico_ident returns [String tipoSimbolo]
@init {$tipoSimbolo="";}
    : v1=tipo_basico {$tipoSimbolo = $v1.tipoSimbolo;}
    | v2=IDENT       {$tipoSimbolo = $v2.getText();}
    ;

tipo_estendido returns [String tipoSimbolo]
@init {$tipoSimbolo="";}
    : ponteiros_opcionais v1=tipo_basico_ident {$tipoSimbolo = $v1.tipoSimbolo;}
    ;

valor_constante 
    : CADEIA
    | N_INTEIRO
    | N_REAL
    | VERDADEIRO
    | FALSO
    ;

registro [String nome_registro] returns[String typeRegistro, List<String> nomes]
@init {$nomes = new ArrayList<String>();}
/* registro recebe como parâmetro o nome do registro
   retorna o tipo desse registro e uma lista de variáveis associadas ao registro
   quando um registro é declarado é empilhada uma nova tabela de simbolos para armazenar
   as variáveis locais, ao final da declaração do registro essa tabela é desempilhada
*/
    : REGISTRO 
    {
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("registro"));
        if(!$nome_registro.equals(""))
            TabelasDeRegistros.empilhar(new TabelaDeSimbolos($nome_registro));
        else
            TabelasDeRegistros.empilhar(new TabelaDeSimbolos("registro"));
    }
      
    variavel mais_variaveis
    {
        for (String s : $variavel.nomes)
        {
            TabelasDeRegistros.topo().adicionarSimbolo(s, $variavel.tipoSimbolo);
            $nomes.add(s);
        }
        for (String u : $mais_variaveis.nomes)
        {
            //error+=u+"\n";
            TabelasDeRegistros.topo().adicionarSimbolo(u, $mais_variaveis.tipoSimbolo);
            $nomes.add(u);
        }
        
        $typeRegistro=$variavel.tipoSimbolo;
    }
      
    FIM_REGISTRO
    {
        pilhaDeTabelas.desempilhar();
    }
    ;

declaracao_global 
    : PROCEDIMENTO v1=IDENT
    {
        if(pilhaDeTabelas.topo().existeSimbolo($v1.getText()))
            error += "Linha " + $v1.getLine() + ": identificador "+$v1.getText()+" ja declarado anteriormente\n" ;
        else
        {
            pilhaDeTabelas.topo().adicionarSimbolo($v1.getText(), "procedimento");
            pilhaDeTabelas.empilhar(new TabelaDeSimbolos("procedimento"));
        }
        // Quando se declara um procedimento é necessário que ele tenha um identificador válido (não tenha sido declarado ainda)
        // Uma nova tabela de simbolos é empilhada no inicio da declaração do procedimento e desempilhada ao seu término
    }
    ABRE_PARENTESIS parametros_opcional FECHA_PARENTESIS declaracoes_locais comandos FIM_PROCEDIMENTO 
    {    
        pilhaDeTabelas.desempilhar();
    }
    | FUNCAO v1=IDENT
    // Quando se declara uma função é necessário que ele tenha um identificador válido (não tenha sido declarado ainda)
    // Uma nova tabela de simbolos é empilhada no inicio da declaração da função e desempilhada ao seu término
    {
        if(pilhaDeTabelas.topo().existeSimbolo($v1.getText()))
            error += "Linha " + $v1.getLine() + ": identificador "+$v1.getText()+" ja declarado anteriormente\n" ;
        else
        {
            pilhaDeTabelas.empilhar(new TabelaDeSimbolos("funcao"));
        }
    }
    
                    
    ABRE_PARENTESIS parametros_opcional FECHA_PARENTESIS DOIS_PONTOS g1=tipo_estendido declaracoes_locais comandos FIM_FUNCAO
    {
        pilhaDeTabelas.desempilhar();
        pilhaDeTabelas.topo().adicionarSimbolo($v1.getText(), $g1.tipoSimbolo);
        //É necessário empilhar um simbolo que corresponde ao nome da função no escopo atual, logo abaixo do escopo da função
    }
    ;

parametros_opcional 
    : parametro
    |
    ;

parametro
    : var_opcional v1=identificador v3=mais_ident DOIS_PONTOS v2=tipo_estendido mais_parametros
    {
        if(pilhaDeTabelas.topo().existeSimbolo($v1.txt))
            error += "Linha " + $v1.linha + ": identificador "+$v1.txt+" ja declarado anteriormente\n" ;
        else
        {
             pilhaDeTabelas.topo().adicionarSimbolo($v1.txt, $v2.tipoSimbolo);
             //error+=pilhaDeTabelas.topo().getEscopo();
             if(TabelasDeRegistros.existeTabela($v2.tipoSimbolo)!=null)
             {
                 TabelaDeSimbolos tabelaRegistro = TabelasDeRegistros.existeTabela($v2.tipoSimbolo);
                 for (String t : tabelaRegistro.getSimbolos())
                 {
                     pilhaDeTabelas.topo().adicionarSimbolo($v1.txt+t, $v2.tipoSimbolo);
                 }
             }
         }  
     }
     ;

var_opcional : VAR;

mais_parametros: (VIRGULA v1=parametro)?;

declaracoes_locais: (decl_local)*;

corpo : declaracoes_locais comandos;

comandos : (cmd comandos)?;

cmd returns [ String tipoCmd ]
// cmd retorna o tipo do comando (necessário na geração de código)
@init{$tipoCmd="";}
    : LEIA ABRE_PARENTESIS v10=identificador v11=mais_ident 
    {    
         if(!pilhaDeTabelas.existeSimbolo($v10.txt))
             error+="Linha " + $v10.linha + ": identificador " + $v10.txt + " nao declarado\n";
         for (String s : $v11.nomes)
         {
             if(!pilhaDeTabelas.existeSimbolo(s))
                 error+="Linha " + $v10.linha + ": identificador " + s + " nao declarado\n";
         }    
    } 
    //Há uma verificação para ver se os simbolos utilizados já foram declarados anteriormente ou não
    FECHA_PARENTESIS { $tipoCmd = "leia"; }
    | ESCREVA ABRE_PARENTESIS expressao mais_expressao FECHA_PARENTESIS {$tipoCmd="escreva";}
    | SE expressao ENTAO comandos senao_opcional FIM_SE { $tipoCmd = "se"; }
    | CASO exp_aritmetica SEJA selecao senao_opcional FIM_CASO { $tipoCmd = "caso"; }
    | PARA v1=IDENT ATRIBUICAO exp_aritmetica ATE exp_aritmetica FACA comandos FIM_PARA { $tipoCmd = "para"; }
    | ENQUANTO expressao FACA comandos FIM_ENQUANTO { $tipoCmd = "enquanto"; }
    | FACA comandos ATE expressao { $tipoCmd = "faca"; }
    | EXPOENTE v2=IDENT v5=outros_ident dimensao ATRIBUICAO v6=expressao { $tipoCmd = "expoente"; }
    {
        String tipo_expressao = $v6.tipoSimbolo;
        String tipo_ident = pilhaDeTabelas.topo().getTipo($v2.getText());
        if(!tipo_expressao.equals(tipo_ident))
            error+="Linha " + $v2.getLine() + ": atribuicao nao compativel para ^" + $v2.getText()+$v5.txt + "\n";
       
    }//Quando há uma atribuição é necessário verificarmos se o simbolo atribuido é compatível com o simbolo do lado esquerdo da atribuição 
    | v3=IDENT chamada_atribuicao[$v3.text]
      {
          if(!pilhaDeTabelas.existeSimbolo($v3.getText()))
              error+="Linha " + $v3.getLine() + ": identificador " + $v3.getText() + " nao declarado\n";
          //Verificação para ver se o simbolo já foi declarado anteriormente.

      }
    | v4=RETORNE expressao
      {
        String escopoAtual=pilhaDeTabelas.topo().getEscopo();
        if(escopoAtual.equals("funcao")==false){
            error+="Linha " + $v4.getLine() + ": comando retorne nao permitido nesse escopo\n";
        //O comando retorne só é permitido no escopo de uma função, verificamos o escopo atual, caso ele seja diferente
        // do escopo de uma função geramos um erro.
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
    }//verificação para ver se os simbolos são compatíveis, eles devem possuir um tipo idêntico. Os únicos tipos diferentes
     // que são compatíveis da mesma forma são inteiros e reais.
    |
    ;

senao_opcional : (SENAO comandos)?;

chamada_atribuicao[String primeiroIdent]
    : ABRE_PARENTESIS argumentos_opcional FECHA_PARENTESIS
    | v1=outros_ident d1=dimensao v2=ATRIBUICAO e1=expressao 
    {
        if(pilhaDeTabelas.existeSimbolo($primeiroIdent+$v1.txt))
        {
            String tipo1 = pilhaDeTabelas.topo().getTipo($primeiroIdent+$v1.txt);
            String tipo2 = $e1.tipoSimbolo;
            if(tipo1.equals(tipo2) || tipo1.equals("inteiro") && tipo2.equals("real") || tipo1.equals("real") && tipo2.equals("inteiro"))
            {
            }
            else
                error+="Linha " + $v2.getLine() + ": atribuicao nao compativel para " + $primeiroIdent+$v1.txt+$d1.txt +"\n";
        }
        //Relizamos a verificação de tipos compatíveis, caso não sejam geramos um erro.
    }
    ;

argumentos_opcional 
    : (expressao mais_expressao)?;

selecao : constantes DOIS_PONTOS comandos mais_selecao;

mais_selecao : (selecao)?;

constantes : numero_intervalo mais_constantes;

mais_constantes : (VIRGULA constantes)?;

numero_intervalo : op_unario N_INTEIRO intervalo_opcional;

intervalo_opcional : (PONTO_PONTO op_unario N_INTEIRO)?;

op_unario : (SUBTRACAO)?;

exp_aritmetica returns [String tipoSimbolo, String txt]
//retorna o simbolo e o tipo do simbolo
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
    } ;

op_multiplicacao : MULTIPLICACAO | DIVISAO;

op_adicao : SOMA | SUBTRACAO;

termo returns [String tipoSimbolo, String txt]
//retorna o simbolo e o tipo do simbolo
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
    :v1=fator outros_fatores { 
        $tipoSimbolo=$v1.tipoSimbolo; 
        $txt=$v1.txt;
    };

outros_termos returns[String tipoSimbolo]
@init{$tipoSimbolo="SEM_TIPO";}
// retorna o tipo do simbolo
// verificar se todos os termos são compatíveis
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
    }|;

fator returns [String tipoSimbolo, String txt]
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
    : v1=parcela outras_parcelas 
    {
        $tipoSimbolo=$v1.tipoSimbolo; 
        $txt=$v1.txt;
    };

outros_fatores : (op_multiplicacao fator)*;

parcela returns [String tipoSimbolo, String txt]
//retorna o simbolo e o tipo do simbolo
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
    : op_unario v1=parcela_unario 
    {
        $tipoSimbolo=$v1.tipoSimbolo; 
        $txt=$v1.txt;
    }
    | v2=parcela_nao_unario 
    {
        $tipoSimbolo=$v2.tipoSimbolo; 
        $txt=$v2.txt;
    }
    ;

parcela_unario returns [String txt, int linha, String tipoSimbolo] 
//retorna o simbolo e o tipo do simbolo
// se os simbolos utilizados já foram declarados
@init {$txt=""; $linha=-1; $tipoSimbolo="SEM_TIPO";}
    : EXPOENTE v1=IDENT v2=outros_ident dimensao
    { 
        $txt+=$v1.getText()+$v2.txt;
        $linha = $v1.getLine();
       
        if(!pilhaDeTabelas.existeSimbolo($v1.getText()+$v2.txt))
            error+="Linha " + $v1.getLine() + ": identificador " + $v1.getText()+$v2.txt + " nao declarado\n";
        if($v2.txt.equals("")) 
            $tipoSimbolo = pilhaDeTabelas.topo().getTipo($txt);
        else
            $tipoSimbolo = TabelasDeRegistros.getTipoDoSimbolo($v2.txt.substring(1));
    }
                
    | v3=IDENT v4=chamada_partes[$v3.getText()]
    {
        $txt+=$v3.getText()+$v4.outrosIdent;
        $linha = $v3.getLine();
        if(!pilhaDeTabelas.existeSimbolo($txt))
            error+="Linha " + $v3.getLine() + ": identificador " + $txt + " nao declarado\n";
        else
        {
            if($v4.tipoSimbolo.equals("SEM_TIPO"))
                $tipoSimbolo = pilhaDeTabelas.topo().getTipo($txt);
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
//retorna o simbolo, o tipo do simbolo e a linha em que foi declarado
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

chamada_partes[String primeiroIdent] returns[String tipoSimbolo, String outrosIdent]
//recebe como parametro o primeiro identificador (necessário para retornar o tipo do simbolo)
//retorna o tipo do simbolo e os outrosIdent (caso existirem)
@init {$tipoSimbolo="SEM_TIPO"; $outrosIdent="";}
    : ABRE_PARENTESIS v1=expressao v2=mais_expressao FECHA_PARENTESIS
 
    | v3=outros_ident dimensao
    {
        $outrosIdent = $v3.txt;
        $tipoSimbolo = pilhaDeTabelas.topo().getTipo($primeiroIdent+$v3.txt);
    }
    |;

exp_relacional returns [String tipoSimbolo,String txt]
//retorna o simbolo e o tipo do simbolo
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
    : v1=exp_aritmetica v2=op_opcional 
    {
        if($v2.tipoSimbolo.equals("SEM_TIPO"))
            $tipoSimbolo=$v1.tipoSimbolo;
        else
            $tipoSimbolo=$v2.tipoSimbolo;
        $txt=$v1.txt;
    };

op_opcional returns[String tipoSimbolo]
// retorna o tipo do simbolo.
@init{$tipoSimbolo="SEM_TIPO";} 
    : v1=op_relacional exp_aritmetica 
    {
        $tipoSimbolo=$v1.tipoSimbolo;
    }|;

op_relacional returns[String tipoSimbolo]
//retorna o tipo do simbolo. 
@init{$tipoSimbolo="SEM_TIPO";}
    : IGUAL {$tipoSimbolo="logico";}
    | DIFERENTE {$tipoSimbolo="logico";}
    | MAIOR_IGUAL {$tipoSimbolo="logico";}
    | MENOR_IGUAL {$tipoSimbolo="logico";}
    | MAIOR {$tipoSimbolo="logico";}
    | MENOR {$tipoSimbolo="logico";};

expressao  returns [String tipoSimbolo, String txt]
//retorna o simbolo e o tipo do simbolo
@init{$tipoSimbolo="SEM_TIPO"; $txt="";} 
    : v1=termo_logico outros_termos_logicos {$tipoSimbolo=$v1.tipoSimbolo; $txt=$v1.txt;}
    ;

op_nao : (NAO)?;

termo_logico returns [String tipoSimbolo, String txt]
//retorna o simbolo e o tipo do simbolo
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
    : v1=fator_logico outros_fatores_logicos {$tipoSimbolo=$v1.tipoSimbolo; $txt=$v1.txt;}
    ;

outros_termos_logicos : (OU termo_logico)*;

outros_fatores_logicos : (E fator_logico)*;

fator_logico returns [String tipoSimbolo, String txt]
//retorna o simbolo e o tipo do simbolo
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
    : op_nao v1=parcela_logica {$tipoSimbolo=$v1.tipoSimbolo; $txt=$v1.txt;}
    ;

parcela_logica returns [String tipoSimbolo, String txt]
//retorna o simbolo e o tipo do simbolo
@init{$tipoSimbolo="SEM_TIPO"; $txt="";}
    : VERDADEIRO {$tipoSimbolo = "logico";}
    | FALSO {$tipoSimbolo = "logico";}
    | v1=exp_relacional {$tipoSimbolo=$v1.tipoSimbolo; $txt=$v1.txt;}
    ;