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

    public void desempilhar() {
        TabelaDeSimbolos ret = pilha.pop();
        Saida.println(ret.toString());
    }

    public List getTodasTabelas() {
        return pilha;
    }
}
