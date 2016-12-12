package t1;

import java.util.ArrayList;
import java.util.List;



public class EntradaTabelaDeSimbolos {
    private String nome, tipo;
     private List<String> parametros;
    private TabelaDeSimbolos subTabeladoRegistro;
    
    public EntradaTabelaDeSimbolos(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }
    // entrada na tabela de simbolos
      public EntradaTabelaDeSimbolos(String nome, String tipo, List<String> listaPassada, TabelaDeSimbolos sub) 
    {
        this.nome = nome;
        this.tipo = tipo;
        this.subTabeladoRegistro = sub;
        
        if(listaPassada == null)
        {
            this.parametros = listaPassada;
        }else
        {
	  
            this.parametros = new ArrayList<String>();
        
            for(int i=0; i< listaPassada.size(); i++)
            {
               this.parametros.add(i,listaPassada.get(i));
            }
        }

        
    }
      
    // retorna o nome daa variavel
    public String getNome() {
        return nome;
    }
    
    //retorna a subtabela
     public TabelaDeSimbolos getsubTabela()
    {
        return this.subTabeladoRegistro;
    }
     
    //retorna o tipo da variavel
    public String getTipo() {
        return tipo;
    }
    
    @Override
    public String toString() {
        return nome+"("+tipo+")";
    }
}
