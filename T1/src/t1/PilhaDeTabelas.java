package t1;

//Classe que implementa uma pilha para as Tabelas de Simbolos

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class PilhaDeTabelas {

    private LinkedList<TabelaDeSimbolos> pilha;

    public PilhaDeTabelas() {
        pilha = new LinkedList<TabelaDeSimbolos>();
    }

    public void empilhar(TabelaDeSimbolos ts) {
        pilha.push(ts);
    }

    public TabelaDeSimbolos topo() {
        return pilha.peek();
    }

    public boolean existeSimbolo(String nome) {
        for (TabelaDeSimbolos ts : pilha) {
            if (ts.existeSimbolo(nome)) {
                return true;
            }
        }
        return false;
    }//Verifica se um simbolo pertence à alguma tabela de simbolos da pilha de tabelas
    
    public TabelaDeSimbolos getTabelaDoSimbolo(String nome) {
        for (TabelaDeSimbolos ts : pilha) {
            if (ts.existeSimbolo(nome)) {
                return ts;
            }
        }
        return null;
    }
    
     public TabelaDeSimbolos getSubtabela(String tipo)
    {
        for(int i = 0; i < pilha.size(); i++) {
            if(pilha.get(i).existeSimbolo(tipo)) {
                return pilha.get(i).getSubtabela(tipo);
            }
        }
        
        return null;
    }
    
    public String getTipoDoSimbolo(String nome){
        TabelaDeSimbolos auxiliar = this.getTabelaDoSimbolo(nome);
        String tipo = auxiliar.getTipo(nome);
        return tipo;
    
    }
    

    public TabelaDeSimbolos existeTabela(String nome) {
        for (TabelaDeSimbolos ts : pilha) {
            if (ts.getEscopo().equals(nome)) {
                return ts;
            }
        }
        return null;
    }//Retorna a tabela de simbolos cujo nome(escopo) é igual ao passado como parâmetro
    
      public List<String> getListaPar(String subRotina)
    {
        List<String> parametros = new ArrayList<String>();
        for(int i = 0; i < pilha.size(); i++) {
            if(pilha.get(i).existeSimbolo(subRotina)) {
                return pilha.get(i).getListaPar(subRotina);
            }
        }
        
        return parametros;
    }
      
     

    public void desempilhar() {
        TabelaDeSimbolos ret = pilha.pop();
        Saida.println(ret.toString());
    }

    public List getTodasTabelas() {
        return pilha;
    }
}
