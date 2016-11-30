/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carol
 */
public class AnalisadorSemantico extends LABaseListener {
    
    SaidaParser out;
    static PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
    TabelaDeSimbolos TabelaDeTiposAtual;
    PilhaDeTabelas TabelasDeRegistros = new PilhaDeTabelas();
    String error="";
    boolean funcao = false;
    
    public AnalisadorSemantico(SaidaParser out){
        this.out = out;
    }

    @Override
    public void enterPrograma(LAParser.ProgramaContext ctx) {
    
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("global"));
         TabelaDeTiposAtual.adicionarSimbolo("literal", "literal");
         TabelaDeTiposAtual.adicionarSimbolo("inteiro", "inteiro");
         TabelaDeTiposAtual.adicionarSimbolo("real", "real");
         TabelaDeTiposAtual.adicionarSimbolo("logico", "logico");
 
    }

    @Override
    public void exitPrograma(LAParser.ProgramaContext ctx) {

        pilhaDeTabelas.desempilhar();
        if(error!="")throw new RuntimeException(error);
    }
    
     public String getNome(LAParser.Declaracao_localContext ctx){
        return ctx.variavel().IDENT().getText();
    }
     
     public int getLinha(LAParser.Declaracao_localContext ctx){
        return ctx.variavel().IDENT().getSymbol().getLine();
    }
    
    @Override
    public void enterDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        TabelaDeTiposAtual = pilhaDeTabelas.topo();
    
        String nome, tipo;
        int linha, funcao =0;
        
        if(ctx.getStart().getText().equals("declare")){
            if(ctx.variavel().tipo().registro()==null){
                nome = getNome(ctx);
                linha = getLinha(ctx);
                tipo = ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                //verifica se o tipo já foi declarado anteriormente
                if(ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT()!= null){
                    //verifica se ele já foi declarado anteriormente
                    if(!pilhaDeTabelas.existeSimbolo(tipo)){
                        out.println("Linha "+linha+ " tipo: "+tipo+" nao declarado");
                    }
                }
                
                //verificando se existe uma variavel com o mesmo nome
                if(!TabelaDeTiposAtual.existeSimbolo(nome)){
                    TabelaDeTiposAtual.adicionarSimbolo(nome, tipo);
                }else{
                    out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente");
                }
                
                //variaveis de mesmo tipo, verificação
                
                for(int i=0; i<ctx.variavel().mais_var().IDENT().size();i++){
                    nome = getNome(ctx);
                    linha = getLinha(ctx);
                    if(!TabelaDeTiposAtual.existeSimbolo(nome)){
                        TabelaDeTiposAtual.adicionarSimbolo(nome, tipo);
                    }else{
                       out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente");
                    }
                }
                
                
            }else{
                // se a verificação de registro retornou não nulo, um novo registro foi declarado
                nome = getNome(ctx);
                linha= getLinha(ctx);
                //verifica se nao existe nenhum nome já declarado
                if(!pilhaDeTabelas.existeSimbolo(nome)){
                    AdicionarSimboloRegistro(ctx, TabelaDeTiposAtual, nome, linha);
                }
                // pode ocorrer varios nomes para um mesmo tipo de registro, então adiciona-se cada um
                for(int i=0; i<ctx.variavel().mais_var().IDENT().size();i++){
                    nome = ctx.variavel().mais_var().IDENT(i).getText();
                    //verifica-se se já existe esse mesmo nome associado a esse tipo
                    if(TabelaDeTiposAtual.existeSimbolo(nome)){
                        out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente");
                    }else{
                        AdicionarSimboloRegistro(ctx, TabelaDeTiposAtual, nome, linha);
                    }
                }
            }
        }else{
           if(ctx.getStart().getText().equals("constante")){
               nome = ctx.IDENT().getText();
               linha = ctx.IDENT().getSymbol().getLine();
               tipo = ctx.tipo_basico().getText();
               
               if(pilhaDeTabelas.existeSimbolo(nome)){
                 out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente"); 
               }else{
                   TabelaDeTiposAtual.adicionarSimbolo(nome, tipo);
                    
               }
           }else{
               if(ctx.getStart().getText().equals("tipo")){
                   nome = ctx.IDENT().getText();
                   linha = ctx.IDENT().getSymbol().getLine();
                   // verificação se já existe nome na tabela de simbolos  
                   if(TabelaDeTiposAtual.existeSimbolo(nome)){
                       out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente");
                   }else{
                       AdicionarSimboloRegistro(ctx, TabelaDeTiposAtual, nome, linha);
                   }
               }
           }
        }
    }
    
    
      @Override
    public void enterCmd(LAParser.CmdContext ctx) {
       
        TabelaDeTiposAtual = pilhaDeTabelas.topo();
        String nome, tipo, outrosIdent = null;
        int linha;
        // se o comando começar com leia
        if(ctx.getStart().getText().equals("leia")){
           nome = ctx.identificador().IDENT().getText();
           linha = ctx.identificador().IDENT().getSymbol().getLine();
           tipo = pilhaDeTabelas.getTipoDoSimbolo(nome);
           
           if(ctx.outros_ident()!=null){
               if(ctx.outros_ident().identificador().IDENT()!=null){
                   outrosIdent = ctx.outros_ident().identificador().IDENT().getText();
                   TabelaDeSimbolos tabelaS = pilhaDeTabelas.getSubtabela(tipo);
                   
                   if(!tabelaS.existeSimbolo(outrosIdent)){
                        out.println("Linha "+linha+": identificador "+nome+"."+outrosIdent+" nao declarado");  
                   }
               }
           }
           
           if(!pilhaDeTabelas.existeSimbolo(nome)){
               if(outrosIdent!=null){
                   nome = nome + "." +outrosIdent;
                   outrosIdent = null;
               }
               out.println("Linha "+linha+": identificador "+nome+" nao declarado");  
           }
           
           for(int i = 0; i<ctx.mais_ident().identificador().size();i++){
               nome = ctx.mais_ident().identificador(i).IDENT().getText();
               linha = ctx.mais_ident().identificador(i).IDENT().getSymbol().getLine();
               if(ctx.mais_ident().identificador(i).outros_ident()!=null){
                   if(ctx.mais_ident().identificador(i).outros_ident().identificador()!=null){
                   outrosIdent = ctx.mais_ident().identificador(i).outros_ident().identificador().IDENT().getText();
                   TabelaDeSimbolos tabelaS = pilhaDeTabelas.getSubtabela(tipo);
                   if(!tabelaS.existeSimbolo(outrosIdent)){
                       out.println("Linha "+linha+": identificador "+nome+"."+outrosIdent+" nao declarado"); 
                   }
                 }
               }
               
               if(!pilhaDeTabelas.existeSimbolo(nome)){
                    if(outrosIdent!=null){
                        nome = nome + "." + outrosIdent;
                        outrosIdent = null;
                    }else{
                        out.println("Linha "+linha+": identificador "+nome+" nao declarado");       
                    }
           }
        }
        //o comando de atribuição também utiliza o identificador, então é necessario verificar se ele já foi declarado
    }else{
            if(ctx.chamada_atribuicao()!=null){
                if(ctx.chamada_atribuicao().expressao()!=null){
                    //verifica qual a variavel recebeu a atribuicao
                    nome = ctx.IDENT().getText();
                    tipo = pilhaDeTabelas.getTipoDoSimbolo(nome);   
                    
                    if(tipo == null){
                        tipo = "tipo_invalido";
                    }
                    
                    linha = ctx.IDENT().getSymbol().getLine();
                    
                    //verifica se a variavel ja foi declarada antes, se não foi retorna um erro
                    if(!pilhaDeTabelas.existeSimbolo(nome)){
                        out.println("Linha "+linha+": identificador "+nome+" nao declarado");
                    }
                    
                   //verifica se outros_ident é diferente de null, se for, é uma variavel normal
                   // se não, a variavel é de registro e deve ser colocado um ponto
                   if(ctx.chamada_atribuicao().outros_ident().identificador() !=null){
                       TabelaDeSimbolos tabelaRegistro = pilhaDeTabelas.getSubtabela(tipo);
                       outrosIdent = ctx.chamada_atribuicao().outros_ident().identificador().IDENT().getText();
                       tipo = tabelaRegistro.getTipo(outrosIdent);
                       nome = nome + "." + outrosIdent;
                   }
                   
                   // vetores
                    LAParser.DimensaoContext dimensaoCtx = ctx.chamada_atribuicao().dimensao();
                    if(dimensaoCtx!=null){
                        LAParser.Exp_aritmeticaContext expressaoACtx = dimensaoCtx.exp_aritmetica(0);
                        if(expressaoACtx!=null){
                            outrosIdent = expressaoACtx.getText();
                            nome = nome + "["+outrosIdent+"]";
                        }
                    }
                    
                    // Verificando se a atribuição é compativel entre os tipos
                    
                    String tipoAtribuicao = verificaTipo(ctx.expressao());
                    if(!tipo.equals(tipoAtribuicao)){
                        if(!tipo.equals("tipo_invalido")){
                           // atribuição não equivalente, ou seja, a atribuição não tem tipo válido
                           if(tipo.equals("literal") || tipoAtribuicao.equals("literal")|| tipoAtribuicao.equals("tipo_invalido")){
                               out.println("Linha "+linha+": atribuicao nao compativel para "+nome);
                           }
                        }
                    }
                    
                }
                //comando retorne
            }else{
                if(ctx.getStart().getText().equals("retorne")){
                    linha = ctx.getStop().getLine();
                    if(funcao == false){
                        out.println("Linha "+linha+": comando retorne nao permitido nesse escopo");
                    }
                }
            }
        }
  }

    @Override
    public void enterChamada_partes(LAParser.Chamada_partesContext ctx) {
        if(ctx.getStart().getText().equals("("))
        {   //a verificacao dos parametros deve ser feita se a regra iniciar-se com "("
            List<String> ParametrosFormais = new ArrayList<>();
            String nomeSubRotina = ctx.getParent().getStart().getText();
            int Linha = ctx.getParent().getStart().getLine();
            ParametrosFormais = pilhaDeTabelas.getListaPar(nomeSubRotina);
            //Declarando uma lista para armazenar cada um dos parametros passados
            List<String> ParametrosReais = new ArrayList<>();
            ParametrosReais.add(verificaTipo(ctx.expressao()));
	    //Obtendo o tipo de cada um dos nomes passados como parametro
            for(LAParser.ExpressaoContext eCtx : ctx.mais_expressao().expressao()) {
                ParametrosReais.add(verificaTipo(eCtx));
            }

	    //realizando as comparacoes para determinar se a chamada e equivalente a declaracao, se nao tiverem a mesma quantidade
            //isso ja representa um erro            
            if(ParametrosFormais.size() != ParametrosReais.size())
            {
                 out.println("Linha "+Linha+": incompatibilidade de parametros na chamada de "+ nomeSubRotina);
            }else
            { //Se a quantidade for a mesma, e necessario verificar, parametro por parametro se eles sao de tipos iguais, se nao forem, isso constitui um erro
                for(int i=0; i< ParametrosReais.size(); i++)
                 {
                     String tipo1 = ParametrosReais.get(i);
                     String tipo2 = ParametrosFormais.get(i);
                
                    if(!tipo1.equals(tipo2))
                    {
                       out.println("Linha "+Linha+": incompatibilidade de parametros na chamada de "+ nomeSubRotina);
                    }
                }
            }
        }
        
    }

      @Override
    public void enterParcela_unario(LAParser.Parcela_unarioContext ctx)
    {
        String tipo = null;
        
        if(ctx.IDENT()!=null)
        {
            //Obtendo o nome do identificador, e verificando se ele ja foi declarado anteriormente
            String nome = ctx.IDENT().getText();
            int linha = ctx.IDENT().getSymbol().getLine();
            tipo = pilhaDeTabelas.getTipoDoSimbolo(nome);
            if(!pilhaDeTabelas.existeSimbolo(nome))
            {
                if(ctx.chamada_partes()!=null)
                {
                    if (ctx.chamada_partes().outros_ident().identificador() != null)
                    {
                        nome = nome + '.' + ctx.chamada_partes().outros_ident().identificador().IDENT().getText();
                    }
                }
                
                out.println("Linha "+linha+": identificador "+nome+" nao declarado");
            }
        }
            
    }
    
    @Override
    public void enterParcela_nao_unario(LAParser.Parcela_nao_unarioContext ctx)
    {
        String tipo = null;
        if(ctx.IDENT()!=null)
        {
            String nome = ctx.IDENT().getText();
            System.out.println("Nome parcela_unario "+nome);
            int linha = ctx.IDENT().getSymbol().getLine();
            tipo = pilhaDeTabelas.getTipoDoSimbolo(nome);
            System.out.println("Tipo recuperado "+tipo);
            if(!pilhaDeTabelas.existeSimbolo(nome))
            {
                if (ctx.outros_ident().identificador()!= null)
                {   
                    nome = nome + '.' + ctx.outros_ident().identificador().IDENT().getText();
                }
                
                out.println("Linha "+linha+": identificador "+nome+" nao declarado");
            }
        }
    }


    @Override
    public void exitDeclaracao_global(LAParser.Declaracao_globalContext ctx) {
        
        //quando acaba a declaração global, ou seja, etá saindo de uma função ou procedimento, tem que desempilhar
        pilhaDeTabelas.desempilhar();
        funcao = false;
        
    }

    @Override
    public void enterDeclaracao_global(LAParser.Declaracao_globalContext ctx) {
      
        String nome = ctx.IDENT().getText();
        String nomePar, tipoPar;
        TabelaDeSimbolos tabelaDeSimbolosAtual = pilhaDeTabelas.topo();
        List<String> nomeParametros  = new ArrayList<>();
        List<String> tipoParametros = new ArrayList<>();
        
        //verifica se é um procedimento
        if(ctx.getStart().getText().equals("procedimento")){
            //verifica se existe um procedimento com mesmo nome já declarado
            if(!pilhaDeTabelas.existeSimbolo(nome)){
                // verifica se tem parametros
                if(ctx.parametros_opcional()!=null){
                    TabelaDeSimbolos tabelaDeSimbolosAtual2 = pilhaDeTabelas.topo();
                    nomePar = ctx.parametros_opcional().parametro().identificador().IDENT().getText();
                    int linhaPar = ctx.parametros_opcional().parametro().identificador().IDENT().getSymbol().getLine();
                    if(!tabelaDeSimbolosAtual2.existeSimbolo(nome)){
                        nomeParametros.add(nome);
                    }else{
                        out.println("Linha "+linhaPar+": identificador " +nome+ " ja declarado anteriormente");
                    }
                    
                    if(ctx.parametros_opcional().parametro().tipo_estendido().tipo_basico_ident().IDENT()!=null){
                        tipoPar = ctx.parametros_opcional().parametro().tipo_estendido().tipo_basico_ident().IDENT().getText();
                    }else{
                        tipoPar = ctx.parametros_opcional().parametro().tipo_estendido().tipo_basico_ident().tipo_basico().getText();
                    }
                    
                    tipoParametros.add(tipoPar);
                    
                    for(int i=0;i<ctx.parametros_opcional().parametro().mais_ident().identificador().size();i++){
                        nomePar = ctx.parametros_opcional().parametro().mais_ident().identificador(i).IDENT().getText();
                        linhaPar = ctx.parametros_opcional().parametro().mais_ident().identificador(i).IDENT().getSymbol().getLine();
                        
                        if(!tabelaDeSimbolosAtual2.existeSimbolo(nome)){
                            nomeParametros.add(nome);
                        }else{
                            out.println("Linha "+linhaPar+": identificador " +nome+ " ja declarado anteriormente");
                        }
                        tipoParametros.add(tipoPar);
                    } 
                    
                    if(ctx.parametros_opcional().parametro().mais_parametros().parametro()!=null)
        {
            nomePar = ctx.parametros_opcional().parametro().mais_parametros().parametro().identificador().IDENT().getText();
            linhaPar = ctx.parametros_opcional().parametro().mais_parametros().parametro().identificador().IDENT().getSymbol().getLine();
            if(!tabelaDeSimbolosAtual.existeSimbolo(nome))
            {
                nomeParametros.add(nome);
            }else{
            
                out.println("Linha "+linhaPar+": identificador " +nome+ " ja declarado anteriormente");
            }
        
            if(ctx.parametros_opcional().parametro().tipo_estendido().tipo_basico_ident().IDENT()!=null)
            {
                tipoPar = ctx.parametros_opcional().parametro().tipo_estendido().tipo_basico_ident().IDENT().getText();
            }else
            {
                tipoPar = ctx.parametros_opcional().parametro().tipo_estendido().tipo_basico_ident().tipo_basico().getText();
            }
        
            tipoParametros.add(tipoPar);
        
        for(int i = 0; i < ctx.parametros_opcional().parametro().mais_parametros().parametro().mais_ident().identificador().size(); i++)
        {
            nome = ctx.parametros_opcional().parametro().mais_parametros().parametro().mais_ident().identificador(i).IDENT().getText();
            linhaPar = ctx.parametros_opcional().parametro().mais_parametros().parametro().mais_ident().identificador(i).IDENT().getSymbol().getLine();
            if(!tabelaDeSimbolosAtual.existeSimbolo(nome))
            {
                nomeParametros.add(nome);
            }else{
            
                out.println("Linha "+linhaPar+": identificador " +nome+ " ja declarado anteriormente");
            }
            tipoParametros.add(tipoPar);
        }
            
            
    
        }
                    
                }
                String tipoFuncao;
                if(ctx.tipo_estendido().tipo_basico_ident().IDENT()!=null){
                    tipoFuncao = ctx.tipo_estendido().tipo_basico_ident().IDENT().getText();
                }else{
                    tipoFuncao = ctx.tipo_estendido().tipo_basico_ident().tipo_basico().getText();
                }
                
                tabelaDeSimbolosAtual.adicionarSimbolo(nome, tipoFuncao,tipoParametros,null);
                TabelaDeSimbolos tabelaSimbolosFuncao = new TabelaDeSimbolos("funcao"+nome);
                
                //precisamos adicionar a lista de parametros no escopo da funcao
                for(int i=0 ; i<nomeParametros.size();i++){
                    if(!tabelaSimbolosFuncao.existeSimbolo(nomeParametros.get(i))){
                            tabelaSimbolosFuncao.adicionarSimbolo(nomeParametros.get(i), tipoParametros.get(i), null, null);
                    }
                    
                }
                
                pilhaDeTabelas.empilhar(tabelaSimbolosFuncao);
           }else{
                out.println("identificador "+nome+" ja declarado anteriormente");
            }
        
        }
    }

    public void AdicionarSimboloRegistro(LAParser.Declaracao_localContext ctx, TabelaDeSimbolos TabelaDeTiposAtual, String nomeRegistro, int linhaRegistro) {
        String nome,tipo; 
        int linha; 
        TabelaDeSimbolos tabelaDoRegistro = new TabelaDeSimbolos("registro");
            //Observacao: nao havia caso de teste em que tinha algum tipo nao declarado dentro das declaracoes do 
            //registro. Essa verificacao nao foi adicionada nesse metodo, mas deveria ter sido =[.
            if(ctx.tipo()!=null){
                nome = ctx.tipo().registro().variavel().IDENT().getText();
                linha = ctx.tipo().registro().variavel().IDENT().getSymbol().getLine();
                   if(ctx.tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT()!=null){
                       tipo = ctx.tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                    if(!pilhaDeTabelas.existeSimbolo(tipo)){
                        out.println("Linha "+linha+ ": tipo "+tipo+" nao declarado");
                    }
                   }else{
                       //nesse caso, recupera o tipo pre estabelecido da gramatica. 
                       tipo = ctx.tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText();
                   }
                   
                   // verificando se já nao existe nenhuma variavel "nome"
                   if(!tabelaDoRegistro.existeSimbolo(nome)){
                       tabelaDoRegistro.adicionarSimbolo(nome, tipo);
                   }else{
                       out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente");
                   }
                   
                   //Variaveis que possuem mesmo tipo
                   for(int i = 0; i<ctx.tipo().registro().variavel().mais_var().IDENT().size(); i++){
                       nome = ctx.tipo().registro().variavel().mais_var().IDENT(i).getText();
                       linha = ctx.tipo().registro().variavel().mais_var().IDENT(i).getSymbol().getLine();
                       if(!tabelaDoRegistro.existeSimbolo(nome)){
                           tabelaDoRegistro.adicionarSimbolo(nome, tipo);
                       }else{
                           out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente");
                       }
                   }
                   
                   //Variaveis com tipo diferente
                   
                   for(int i = 0; i < ctx.tipo().registro().mais_variaveis().variavel().size(); i++){
                        nome = ctx.tipo().registro().mais_variaveis().variavel(i).IDENT().getText();
                        linha = ctx.tipo().registro().mais_variaveis().variavel(i).IDENT().getSymbol().getLine();
                        if(ctx.tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT()!=null){
                            tipo = ctx.tipo().registro().mais_variaveis().variavel(i).tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                        }else{
                            tipo = ctx.tipo().registro().mais_variaveis().variavel(i).tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText();
                        }
                   
                        if(!tabelaDoRegistro.existeSimbolo(nome)){
                            tabelaDoRegistro.adicionarSimbolo(nome, tipo);
                        }else{
                            out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente");
                        }
                   
                        for(int j = 0; j<ctx.tipo().registro().mais_variaveis().variavel(i).mais_var().IDENT().size(); j++){
                            nome = ctx.tipo().registro().mais_variaveis().variavel(i).mais_var().IDENT(i).getText();
                            if(!tabelaDoRegistro.existeSimbolo(nome))
                            {
                                tabelaDoRegistro.adicionarSimbolo(nome, tipo);
                            }else{
                                out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente");
                            }
                        }
                   }
            }else{
                if(ctx.variavel().tipo()!=null){
                   nome = ctx.variavel().tipo().registro().variavel().IDENT().getText();
                   linha = ctx.variavel().tipo().registro().variavel().IDENT().getSymbol().getLine();
                   if(ctx.variavel().tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT()!=null){
                       tipo = ctx.variavel().tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                   }else{
                       tipo = ctx.variavel().tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText();
                   }
                   
                   if(!tabelaDoRegistro.existeSimbolo(nome)){
                       tabelaDoRegistro.adicionarSimbolo(nome, tipo);
                   }else{
                       out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente");
                   }
                   
                   for(int i = 0; i<ctx.variavel().tipo().registro().variavel().mais_var().IDENT().size(); i++){
                       nome = ctx.variavel().tipo().registro().variavel().mais_var().IDENT(i).getText();
                       if(!tabelaDoRegistro.existeSimbolo(nome))
                       {
                           tabelaDoRegistro.adicionarSimbolo(nome, tipo);
                       }else
                       {
                           out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente");
                       }
                   }
                   
                   for(int i = 0; i < ctx.variavel().tipo().registro().mais_variaveis().variavel().size(); i++){
                        nome = ctx.variavel().tipo().registro().mais_variaveis().variavel(i).IDENT().getText();
                        linha = ctx.variavel().tipo().registro().mais_variaveis().variavel(i).IDENT().getSymbol().getLine();
                        if(ctx.variavel().tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT()!=null){
                            tipo = ctx.variavel().tipo().registro().mais_variaveis().variavel(i).tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                        }else{
                            tipo = ctx.variavel().tipo().registro().mais_variaveis().variavel(i).tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText();
                        }
                   
                        if(!tabelaDoRegistro.existeSimbolo(nome)){
                            tabelaDoRegistro.adicionarSimbolo(nome, tipo);
                        }else{
                            out.println("Linha "+linha+": identificador " +nome+ " ja declarado anteriormente");
                        }
                   
                        for(int j = 0; j<ctx.variavel().tipo().registro().mais_variaveis().variavel(i).mais_var().IDENT().size(); j++){
                            nome = ctx.variavel().tipo().registro().mais_variaveis().variavel(i).mais_var().IDENT(i).getText();
                            if(!tabelaDoRegistro.existeSimbolo(nome)){
                                tabelaDoRegistro.adicionarSimbolo(nome, tipo);
                            }
                        }
                }
            } 
        }     
        
        //Apos adicionar todas as variaveis a tabela de simbolos do registro, adicionamos a tabela a tabela do escopo atual
        TabelaDeTiposAtual.adicionarSimbolo(nomeRegistro, nomeRegistro, null, tabelaDoRegistro);
    }
    
       public static String verificaTipo(LAParser.ExpressaoContext ctx) {
        //Uma expressao e composta por termo_logico e outros_termos_logicos. O tipo da expressao sera dado pelo tipo do termo_logico,
	//Se a regra outros_termos_logicos for nula
	String tipoExp = verificaTipo(ctx.termo_logico());

        //Se a regra outros_termos_logicos nao for nula, o tipo da expressao sera dado pela verificacao 2 a 2 de cada um dos termos logicos
        if(ctx.outros_termos_logicos() == null) {
            return tipoExp;
        } else {
            for(LAParser.Termo_logicoContext termo: ctx.outros_termos_logicos().termo_logico()) {
                String tipoOutroTermo = verificaTipo(termo);
                tipoExp = regraTipos(tipoExp, tipoOutroTermo);
            }
        }
        
        return tipoExp;
    }
    
     //Metodo verificaTipo para o contexto de um termo_logico
     public static String verificaTipo(LAParser.Termo_logicoContext ctx) {
	//Um termo_logico e composto por fator_logico e outros_fatores_logicos. O tipo do termo sera dado pelo tipo do fator_logico,
	//Se a regra outros_fatoeres_logicos for nula
         String tipoTermoLogico = verificaTipo(ctx.fator_logico());
        
	//Se a regra outros_fatores_logicos nao for nula, o tipo do termo_logico sera dado pela verificacao 2 a 2 de cada um dos fatores logicos
        if(ctx.outros_fatores_logicos() == null) {
            return tipoTermoLogico;
        } else {
            for(LAParser.Fator_logicoContext termo: ctx.outros_fatores_logicos().fator_logico()) {
                String tipoOutroTermo = verificaTipo(termo);
                tipoTermoLogico = regraTipos(tipoTermoLogico, tipoOutroTermo);
            }
        }
        
        return tipoTermoLogico;
     }
     
    //Metodo verificaTipo para o contexto de um fator_logico
    public static String verificaTipo(LAParser.Fator_logicoContext ctx) {
	//Um fator logico chega apenas em uma parcela logica, sendo assim, o tipo e determinado pelo tipo da parcela logica
        String tipof_logico = verificaTipo(ctx.parcela_logica());
        
        return tipof_logico;
    }
    
    //Metodo verificaTipo para o contexto de uma parcela_logica
    public static String verificaTipo(LAParser.Parcela_logicaContext ctx) {
        String tipoP_logica;
	//parcela_logica pode chegar ate as palavras chave verdadeiro ou falso, o que determinaria o tipo dessa parcela como logico
        if(ctx.getStart().getText().equals("verdadeiro") || ctx.getStart().getText().equals("falso"))
            tipoP_logica = "logico";
        else
	    //mas tambem pode chegar a uma exp_relacional, de modo que o tipo passa a ser determinado pelo tipo dessa exp_relacional
            tipoP_logica = verificaTipo(ctx.exp_relacional());
        return tipoP_logica;
    }


    //Metodo verificaTipo para o contexto de uma exp_relacional
    public static String verificaTipo(LAParser.Exp_relacionalContext ctx) {
        String tipoExp_rel = "tipo_invalido";
	//uma exp_relacional pode ter um operador opcional. Se esse operador opcional existir, nao importa o tipo da exp_aritmetica retornado
	// o tipo da exp_relacional como um todo passara a ser logico
        if(ctx.op_opcional() != null)
        {
            if(ctx.op_opcional().op_relacional()!=null)
            {
                tipoExp_rel = "logico";
            }else{
                tipoExp_rel = verificaTipo(ctx.exp_aritmetica());
            }
        }    
        else
	    //Mas se o operador opcional nao existir, o tipo da exp_relacional passara a ser determinado pelo tipo da exp_aritmetica	
            tipoExp_rel = verificaTipo(ctx.exp_aritmetica());
        
        return tipoExp_rel;  
    }
    
    //Metodo verificaTipo para o contexto de uma exp_aritmetica	
    public static String verificaTipo(LAParser.Exp_aritmeticaContext ctx) {
	//Uma exp_aritmetica e composta por termo e outros_termos. O tipo da exp_aritmetica sera dado pelo tipo do termo,
	//Se a regra outros_termos for nula
        String tipoExp_ar = verificaTipo(ctx.termo());
        //Se a regra outros_termos_ nao for nula, o tipo da exp_aritmetica sera dado pela verificacao 2 a 2 de cada um dos termos
        if(ctx.outros_termos()== null) {
            return tipoExp_ar;
        } else {
            for(LAParser.TermoContext termo: ctx.outros_termos().termo()) {
                String tipoOutroTermo = verificaTipo(termo);
                tipoExp_ar = regraTipos(tipoExp_ar, tipoOutroTermo);
            }
        }
        
        return tipoExp_ar;
    }
    

    //Metodo verificaTipo para o contexto de um termo
    public static String verificaTipo(LAParser.TermoContext ctx) {
        String tipotermo = verificaTipo(ctx.fator());
        //Um termo e composto por fator e outros_fatores. O tipo do termo sera dado pelo tipo do fator,
	//Se a regra outros_fatores for nula
        if(ctx.outros_fatores() == null) {
            return tipotermo;
	//Se a regra outros_fatores nao for nula, o tipo do termo sera dado pela verificacao 2 a 2 de cada um dos fatores
        } else {
            for(LAParser.FatorContext termo: ctx.outros_fatores().fator()) {
                String tipoOutroTermo = verificaTipo(termo);
                tipotermo = regraTipos(tipotermo, tipoOutroTermo);
            }
        }
        
        return tipotermo;
    }
    
    //Metodo verificaTipo para o contexto de um fator
    public static String verificaTipo(LAParser.FatorContext ctx) {
	//Um fator e composto por parcela e outras_parcelas. O tipo do fator sera dado pelo tipo da parcela,
	//Se a regra outras_parcelas for nula
        String tipofator = verificaTipo(ctx.parcela());
        //Se a regra outras_parcelas nao for nula, o tipo do fator sera dado pela verificacao 2 a 2 de cada uma das parcelas
        if(ctx.outras_parcelas() == null) {
            return tipofator;
        } else {
            for(LAParser.ParcelaContext termo: ctx.outras_parcelas().parcela()) {
                String tipoOutroTermo = verificaTipo(termo);
                tipofator = regraTipos(tipofator, tipoOutroTermo);
            }
        }
        
        return tipofator;
    }
    
    //Metodo verificaTipo para o contexto de uma parcela
    public static String verificaTipo(LAParser.ParcelaContext ctx) {
        String tipo;
		
	    //Uma parcela pode chegar na regra parcela_unario ou na regra parcela_nao unario, de modo que o tipo da parcela vai ser determinado
	    //pelo tipo da regra que essa parcela chegar
            if(ctx.parcela_unario()!=null)
            {
                tipo = verificaTipo(ctx.parcela_unario());
            }else{
                tipo = verificaTipo(ctx.parcela_nao_unario());
            }

        return tipo;
    }
    
    //Metodo verificaTipo para o contexto de uma parcela_unario
    public static String verificaTipo(LAParser.Parcela_unarioContext ctx) {
        String tipo = "tipo_invalido";
	//A regra parcela nao unario pode ser um numero inteiro, um numero real, um identificador, ou uma chamada de subrotina
        if(ctx.N_INTEIRO() != null)
        {
	    //Se a regra lexica NUM_INT nao for nula, trata-se de um numero inteiro
            tipo = "inteiro";
        }else
        {
            if(ctx.N_REAL()!= null)
            {
		//Se a regra lexica NUM_REAL nao for nula trata-se de um tipo real
                tipo = "real";
            }else
            {
		//Se nao for nenhum dos outros dois, entao temos um identificador, desse modo, e necessario identificar seu tipo associado
		// na tabela de simbolos
                PilhaDeTabelas atual = pilhaDeTabelas;
                if(ctx.outros_ident()!=null)
                {
		    //Se outros ident e diferente de null, entao o tipo desse nome composto e dado pelo nome apos o ponto, desse modo,
		    //o tipo do primeiro nome e recuperado para encontrar a subtabela associada aquele tipo, e, desse modo, determinar o
		    //tipo do nome apos o ponto
                    if(ctx.outros_ident().identificador()!=null)
                    {
                        String nome = ctx.IDENT().getText();
                        String tipo1 = atual.getTipoDoSimbolo(nome);
                        TabelaDeSimbolos TabelaReg = atual.getSubtabela(tipo1);
                        nome = ctx.outros_ident().identificador().IDENT().getText();
                        tipo = TabelaReg.getTipo(nome);
                    }
                    
                }else{
                    if(ctx.chamada_partes()!=null)
                    {   //Pode-se chegar em outros_ident pela regra chamada_partes, entao e feita uma verificacao para saber se esses outros_ident 
                        //existe, pois se a regra nao for nula, o tipo do nome composto sera dado pelo tipo do outros_ident
                        if(ctx.chamada_partes().outros_ident()!=null)
                        {    if(ctx.chamada_partes().outros_ident().identificador()!=null)
                            {
                                String nome = ctx.IDENT().getText();
                                String tipo1 = atual.getTipoDoSimbolo(nome);
                                TabelaDeSimbolos TabelaReg = atual.getSubtabela(tipo1);
                                nome = ctx.chamada_partes().outros_ident().identificador().IDENT().getText();
                                tipo = TabelaReg.getTipo(nome);
                            }else{
                                if(ctx.IDENT() != null)
                                {
                                    String nome = ctx.IDENT().getText();
                                    tipo = atual.getTipoDoSimbolo(nome);
                                }else
                                {
                                    if(ctx.getStart().getText().equals("("))
                                    {
                                        tipo = verificaTipo(ctx.expressao());                 
                                    }
                                }
                            }
                        }else{
                                if(ctx.IDENT() != null)
                                {
				   //Se nao for nenhuma das anteriores, basta pegar o tipo do identificador retornado por IDENT
                                    String nome = ctx.IDENT().getText();
                                    tipo = atual.getTipoDoSimbolo(nome);
                                }else
                                {
                                    if(ctx.getStart().getText().equals("("))
                                    {
                                        tipo = verificaTipo(ctx.expressao());
                                    }
                                }
                            }
                    }
                    else{
                        
                    
                    if(ctx.IDENT() != null)
                    {
                        String nome = ctx.IDENT().getText();
                        tipo = atual.getTipoDoSimbolo(nome);
                    }else
                    {
                        if(ctx.getStart().getText().equals("("))
                        {
                            tipo = verificaTipo(ctx.expressao());
                        }
                    }
                }
                }
                
               
            }
        }
        
        return tipo;
    }
    
    //Metodo verificaTipo para o contexto de uma parcela_nao_unario
    public static String verificaTipo(LAParser.Parcela_nao_unarioContext ctx) {
	//Na regra parcela_nao_unario, e possivel ter um IDENT ou uma CADEIA
        String tipo = "tipo_invalido";
        if(ctx.CADEIA() != null)
        {   //Se a regra lexica CADEIA for diferente de null, isso significa que o tipo da parcela_nao_unario e literal
            tipo = "literal";
        }else
        {
            //Se nao, se trata de um identificador, um nome. E necessario recuperar o tipo dele da tabela de simbolos
            PilhaDeTabelas atual = pilhaDeTabelas;
            if(ctx.outros_ident()!=null)
            {
		//Se outros ident e diferente de null, entao o tipo desse nome composto e dado pelo nome apos o ponto, desse modo,
		//o tipo do primeiro nome e recuperado para encontrar a subtabela associada aquele tipo, e, desse modo, determinar o
		//tipo do nome apos o ponto
                if(ctx.outros_ident().identificador()!=null)
                {
                    String nome = ctx.IDENT().getText();
                    String tipo1 = atual.getTipoDoSimbolo(nome);
                    TabelaDeSimbolos TabelaReg = atual.getSubtabela(tipo1);
                    nome = ctx.outros_ident().identificador().IDENT().getText();
                    tipo = TabelaReg.getTipo(nome);
                }else{
                    if(ctx.IDENT() != null)
                    {	//Se nao e nome composto, entao, basta apenas recuperar o tipo associado ao nome.
                        String nome = ctx.IDENT().getText();
                        tipo = atual.getTipoDoSimbolo(nome);
                    }
                }
            }else{
                if(ctx.IDENT() != null)
                {
                   String nome = ctx.IDENT().getText();
                   tipo = atual.getTipoDoSimbolo(nome);
                }
            
        } 
        }
        
        return tipo;
    }
    
    //Metodo para determinacao do retorno da verificacao do tipo de dois elementos
    private static String regraTipos(String tipoExp, String tipoOutroTermo) {
        if(tipoExp.equals(tipoOutroTermo)) {
            return tipoExp;
	    //Se os tipos sao iguais, basta retornar o tipo do primeiro elemento
        } else if(tipoExp.equals("real") && tipoOutroTermo.equals("inteiro") ||
                tipoExp.equals("inteiro") && tipoOutroTermo.equals("real")) {
            return "real";
           //Se eles nao sao iguais, mas algum dos tipos e inteiro e outro tipo e real, trata-se de uma expressao real
        } else {
            return "tipo_invalido";
	  //Se nao for um dos citados acima, o tipo e invalido
        }
    }
}
