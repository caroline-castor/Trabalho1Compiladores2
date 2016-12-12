//Classe Tabela de Simbolos, possui um escopo e uma lista de simbolos
package t1;

import java.util.ArrayList;
import java.util.List;

public class TabelaDeSimbolos {
    private String escopo;
    private List<EntradaTabelaDeSimbolos> simbolos;
    
    public TabelaDeSimbolos(String escopo) {
        simbolos = new ArrayList<EntradaTabelaDeSimbolos>();
        this.escopo = escopo;
    }
    
     public void adicionarSimbolo(String nome, String tipo, List<String> parametros, TabelaDeSimbolos sub) {
        simbolos.add(new EntradaTabelaDeSimbolos(nome,tipo, parametros, sub));
    }
    
    public void adicionarSimbolos(List<String> nomes, String tipo, List<String> parametros, TabelaDeSimbolos sub) {
        for(String s:nomes) {
            simbolos.add(new EntradaTabelaDeSimbolos(s, tipo, parametros, sub));
        }
    }
    
    public void adicionarSimbolo(String nome, String tipo) {
        simbolos.add(new EntradaTabelaDeSimbolos(nome,tipo));
    }
    
    public void adicionarSimbolos(List<String> nomes, String tipo) {
        for(String s:nomes) {
            simbolos.add(new EntradaTabelaDeSimbolos(s, tipo));
        }
    }
    
    public List<String> getSimbolos(){
        List<String> atributos = new ArrayList<String>();
        for(int i=0; i< simbolos.size();i++){
            atributos.add("." + simbolos.get(i).getNome());
        }
        return atributos;
    }
    
        public TabelaDeSimbolos getSubtabela(String tipo)
    {
        for(int i = 0; i < simbolos.size(); i++) {
            if(simbolos.get(i).getNome().equals(tipo)) {
                return simbolos.get(i).getsubTabela();
            }
        }
        
        return null;
    }
    
 
    
    //lista com todos simbolos de uma tabela
    public List<EntradaTabelaDeSimbolos> getListaSimbolosTabela(){
        List<EntradaTabelaDeSimbolos> atributos = new ArrayList<EntradaTabelaDeSimbolos>();
        for(int i=0; i< simbolos.size();i++){
            atributos.add(simbolos.get(i));
        }
        return atributos;
    }
    
    //pega o escopo
    public String getEscopo(){
        return this.escopo;
        } 
    
    //verifica se existe o simbolo
    public boolean existeSimbolo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    //retorna tipo do simbolo
    public String getTipoSimbolo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return etds.getTipo();
            }
        }
        return "TIPO_NAO_DECLARADO";
    }
    
    @Override
    public String toString() {
        String ret = "Escopo: "+escopo;
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            ret += "\n   "+etds;
        }
        return ret;
    }
}
