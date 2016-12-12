package t1;

//Classe que implementa uma pilha para as Tabelas de Simbolos

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
    // verifica se um simbolo existe
    public boolean existeSimbolo(String nome) {
        for (TabelaDeSimbolos ts : pilha) {
            if (ts.existeSimbolo(nome)) {
                return true;
            }
        }
        return false;
    }
    
    //recupera a subtabela (escopo dentro de outro)
      public TabelaDeSimbolos getSubtabela(String tipo)
    {
        for(int i = 0; i < pilha.size(); i++) {
            if(pilha.get(i).existeSimbolo(tipo)) {
                return pilha.get(i).getSubtabela(tipo);
            }
        }
        
        return null;
    }
    
      //Retorna a tabela que tem o simbolo
    public TabelaDeSimbolos getTabelaDoSimbolo(String nome) {
        for (TabelaDeSimbolos ts : pilha) {
            if (ts.existeSimbolo(nome)) {
                return ts;
            }
        }
        return null;
    }
    
    // retorna o tipo de um simbolo
    public String getTipoDoSimbolo(String nome){
        TabelaDeSimbolos auxiliar = this.getTabelaDoSimbolo(nome);
        String tipo = auxiliar.getTipoSimbolo(nome);
        return tipo;
    
    }
    
    //Verifica se a tabela existe no escopo
    public TabelaDeSimbolos existeTabela(String nome) {
        for (TabelaDeSimbolos ts : pilha) {
            if (ts.getEscopo().equals(nome)) {
                return ts;
            }
        }
        return null;
    }

    public void desempilhar() {
        TabelaDeSimbolos ret = pilha.pop();
        Saida.println(ret.toString());
    }

   
}
