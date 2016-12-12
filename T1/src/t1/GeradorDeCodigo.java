package t1;

public class GeradorDeCodigo extends LABaseListener {

    SaidaParser saida;

    public GeradorDeCodigo(SaidaParser saida) {
        this.saida = saida;
    }

    @Override
    public void enterPrograma(LAParser.ProgramaContext ctx) {
        saida.println("#include <stdio.h>");
        saida.println("#include <stdlib.h>");
        saida.println("int main(){");

    }

    @Override
    public void exitPrograma(LAParser.ProgramaContext ctx) {
        saida.println("return 0;");
        saida.println("}");
    }

    @Override
    public void enterCmd(LAParser.CmdContext ctx) {
        String variavel, expressao="", nomeVariavel, retorno="",tipoReg,tipo;
        PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
        if (ctx.tipoComando.equals("leia")) {
            saida.println("scanf(\"%" + verifica_tipo(ctx.identificador().tipoSimbolo) + "\",&" + ctx.identificador().nomeID + ");");
        } else {
            if (ctx.tipoComando.equals("escreva")) {
                saida.println("printf(\"%" + verifica_tipo(ctx.expressao().tipoSimbolo) +  "\"," + ctx.expressao().txt +  ");");
            }else{
                 if (ctx.chamada_atribuicao() != null) {
            if (ctx.chamada_atribuicao().getStart().getText().equals("(") && ctx.chamada_atribuicao().getStop().getText().equals(")")) {
                saida.println(ctx.getText() + ";");
            } else {
                variavel = ctx.IDENT().getText();
                expressao = expressao + ctx.chamada_atribuicao().expressao().getText();
                //ver se é variavel de registro
                if (ctx.chamada_atribuicao().outros_ident().getStart().getText().equals(".")) {
                    nomeVariavel = ctx.chamada_atribuicao().outros_ident().identificador().IDENT().getText();
                    tipoReg = variavel;
                    variavel = variavel + "." + nomeVariavel;

                    if (pilhaDeTabelas.getSubtabela(tipoReg) != null) {
                        TabelaDeSimbolos tabelaRegistro = pilhaDeTabelas.getSubtabela(tipoReg);
                        tipo = tabelaRegistro.getTipoSimbolo(nomeVariavel);
                    } else {
                        tipo = pilhaDeTabelas.topo().getTipoSimbolo(tipoReg);
                        TabelaDeSimbolos tabelaRegistro = pilhaDeTabelas.getSubtabela(tipo);
                        tipo = tabelaRegistro.getTipoSimbolo(nomeVariavel);
                    }

                    if (tipo.equals("literal")) {
                        saida.println("strcpy(" + variavel + "," + ctx.chamada_atribuicao().expressao().getText() + ");");
                    } else {
                        saida.println(variavel + expressao + ";");
                    }
                } else //vetor
                if (ctx.chamada_atribuicao().dimensao().getStart().getText().equals("[")) {
                    variavel = variavel + ctx.chamada_atribuicao().dimensao().getText();
                    saida.println(variavel + expressao + ";");
                }
            }
        } else //atr ponteiro
        if (ctx.getStart().getText().equals("^")) {
            variavel = "*" + ctx.IDENT().getText();
            expressao = expressao + ctx.expressao().getText();
            if (ctx.outros_ident().getStart().getText().equals(".")) {
                nomeVariavel = ctx.outros_ident().identificador().IDENT().getText();
                tipo = ctx.IDENT().getText();
                tipoReg = variavel;
                variavel = variavel + "." + nomeVariavel;
                if (pilhaDeTabelas.getSubtabela(tipoReg) != null) {
                    TabelaDeSimbolos tabelaRegistro = pilhaDeTabelas.getSubtabela(tipoReg);
                    tipo = tabelaRegistro.getTipoSimbolo(nomeVariavel);

                } else {
                    tipo = pilhaDeTabelas.topo().getTipoSimbolo(nomeVariavel);
                    TabelaDeSimbolos tabelaRegistro = pilhaDeTabelas.getSubtabela(tipo);
                    tipo = tabelaRegistro.getTipoSimbolo(nomeVariavel);
                }

                if (tipo.equals("literal")) {
                    saida.println("strcpy(" + variavel + "," + ctx.chamada_atribuicao().expressao().getText() + ");");
                } else {
                    saida.println(variavel + expressao + ";");
                }
            } else {
                //se é vetor
                if (ctx.dimensao().getStart().getText().equals("[")) {
                    variavel = variavel + ctx.chamada_atribuicao().dimensao().getText();
                }
                saida.println(variavel + expressao + ";");
            }
        } else if (ctx.getStart().getText().equals("se") || ctx.getStart().getText().equals("caso")
                || ctx.getStart().getText().equals("para") || ctx.getStart().getText().equals("enquanto")) {
            if (ctx.getStart().getText().equals("se")) {
                retorno = "if (";
                if (ctx.expressao().termo_logico().fator_logico().op_nao().getText().equals("nao")) {
                    retorno = retorno + "!(" + ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().getText();
                    if (!ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().op_opcional().getStart().getText().equals("")) {
                        retorno = retorno + " " + trataToken(ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().op_opcional().op_relacional()) + " " + ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().op_opcional().exp_aritmetica().getText();

                    }

                    if (ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao()
                            .termo_logico().outros_fatores_logicos().getStart().getText().equals("e")) {
                        retorno = retorno + " " + trataToken(ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().outros_fatores_logicos()) + " " + ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().outros_fatores_logicos().getChild(1).getText();

                    }

                    if (ctx.expressao().outros_termos_logicos().getStart().getText().equals("ou")) {

                        retorno = retorno + " " + trataToken(ctx.expressao().outros_termos_logicos()) + " "
                                + ctx.expressao().outros_termos_logicos().getChild(1).getText();
                    }

                }
            } else if (ctx.getStart().getText().equals("caso")) {
                retorno = "switch (";
                retorno = retorno+ctx.exp_aritmetica(0).getText(); //ERRO
            } else if (ctx.getStart().getText().equals("para")) {
                retorno = "for (";
                retorno = retorno + ctx.IDENT().getText() + " = " + ctx.getChild(3).getText() + "; ";
                            retorno = retorno + ctx.IDENT().getText() + " <= " + ctx.getChild(5).getText() + "; ";
                            retorno = retorno + ctx.IDENT().getText() + "++";
            } else if (ctx.getStart().getText().equals("enquanto")) {
                retorno = "while (";
                if (ctx.expressao().termo_logico().fator_logico().op_nao().getText().equals("nao")) {
                    retorno = retorno + "!(" + ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().getText();
                    if (!ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().op_opcional().getStart().getText().equals("")) {
                        retorno = retorno + " " + trataToken(ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().op_opcional().op_relacional()) + " " + ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().op_opcional().exp_aritmetica().getText();

                    }

                    if (ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao()
                            .termo_logico().outros_fatores_logicos().getStart().getText().equals("e")) {
                        retorno = retorno + " " + trataToken(ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().outros_fatores_logicos()) + " " + ctx.expressao().termo_logico().fator_logico().parcela_logica().exp_relacional().exp_aritmetica().termo().fator().parcela().parcela_unario().expressao().termo_logico().outros_fatores_logicos().getChild(1).getText();

                    }

                    if (ctx.expressao().outros_termos_logicos().getStart().getText().equals("ou")) {

                        retorno = retorno + " " + trataToken(ctx.expressao().outros_termos_logicos()) + " "
                                + ctx.expressao().outros_termos_logicos().getChild(1).getText();
                    }

                }
            }
            
            retorno = retorno + ") {";
            saida.println(retorno);

        } else
                 if (ctx.tipoComando.equals("se")) {
                saida.println("if("+ctx.expressao().getText()+"){");
                }
                 if (ctx.tipoComando.equals("senao")){
                     saida.println("}else{");
                 }
        
        
      }
            
        }

    }
  
    @Override
    public void enterDeclaracao_local(LAParser.Declaracao_localContext ctx)
    {
      if(ctx.variavel.tipoSimbolo.equals("inteiro"))
          saida.println("int " + ctx.variavel.listaVar.toString().substring(1, ctx.variavel.listaVar.toString().length()-1) + ";") ;
      else
      {
          if(ctx.variavel.tipoSimbolo.equals("real"))
          saida.println("float " + ctx.variavel.listaVar.toString().substring(1, ctx.variavel.listaVar.toString().length()-1)+ ";") ;
          else
          {
             if(ctx.variavel.tipoSimbolo.equals("literal"))
                  saida.println("char " + ctx.variavel.listaVar.toString().substring(1, ctx.variavel.listaVar.toString().length()-1) + "[80]" + ";") ;
             else
                 if(ctx.variavel.tipoSimbolo.equals("logico"))
                  saida.println("bool " + ctx.variavel.listaVar.toString().substring(1, ctx.variavel.listaVar.toString().length()-1)+ ";") ;
          }
      }
    
    }

    public char verifica_tipo(String tipo) {
        if (tipo.equals("literal")) {
            return 's';
        } else {
            if (tipo.equals("inteiro")) {
                return 'd';
            } else {
                if (tipo.equals("real")) {
                    return 'f';
                }
            }
        }
        return 'd';
    }

       public static String trataToken(LAParser.Op_relacionalContext ctx) {
        String token = ctx.getStart().getText();
        
        if (token.equals("="))
            token = "==";
        else{
            if (token.equals("<>"))
                token = "!=";
        }
        
        return token;            
    }
    
    public static String trataToken(LAParser.Outros_termos_logicosContext ctx) {
        String token = ctx.getStart().getText();
        
        if (token.equals("ou"))
            token = "||";
        
        return token;            
    }
    
    public static String trataToken(LAParser.Outros_fatores_logicosContext ctx) {
        String token = ctx.getStart().getText();
        
        if (token.equals("e"))
            token = "&&";
        
        return token;            
    }
    
    public static String trataToken(LAParser.Parcela_logicaContext ctx) {
        String token = ctx.getStart().getText();
        
        if (token.equals("verdadeiro"))
            token = "true";
        else{
            if (token.equals("falso"))
                token = "false";
        }
        
        return token;            
    }
}

