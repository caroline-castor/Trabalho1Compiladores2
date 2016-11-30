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
    
    //retorna uma lista com tipo dos simbolos
    public List<String> getTipos_simbolos(){
        List<String> atributos = new ArrayList<String>();
        for(int i=0; i< simbolos.size();i++){
            atributos.add(simbolos.get(i).getTipo());
        }
        return atributos;
    }
    
    //retorna uma lista com simbolos existentes da tabela
    public List<EntradaTabelaDeSimbolos> getListaSimbolos(){
        List<EntradaTabelaDeSimbolos> atributos = new ArrayList<EntradaTabelaDeSimbolos>();
        for(int i=0; i< simbolos.size();i++){
            atributos.add(simbolos.get(i));
        }
        return atributos;
    }
    
    //Retorna qual o escopo da tabela
    public String getEscopo(){
        return this.escopo;
    } 
    
    public boolean existeSimbolo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
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
    //Retorna o simbolo associado a um nome
    public EntradaTabelaDeSimbolos getSimbolo(String nome){
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return etds;
            }
        }
        return null;
    } 
    
        public List<String> getListaPar(String nomeSubrotina)
    {
        List<String> ListaPar = new ArrayList<String>();
        
        for(int i = 0; i < simbolos.size(); i++) {
            if(simbolos.get(i).getNome().equals(nomeSubrotina)) {
                ListaPar = simbolos.get(i).getListaPar();
                return ListaPar;
            }
        }
        
       return null; 
    }
    
    
    //Retorna o tipo do simbolo, se declarado e se não retorna "sem simbolo"
    public String getTipo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return etds.getTipo();
            }
        }
        return "SEM_TIPO";
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
