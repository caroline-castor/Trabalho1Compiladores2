package t1;

import java.util.ArrayList;
import java.util.List;

/* Classe que define como os simbolos serão armazenados. Todos terão um nome e um tipo associado.
*/
public class EntradaTabelaDeSimbolos {
    private String nome, tipo;
     private List<String> parametros;
    private TabelaDeSimbolos subTabeladoRegistro;
    
    public EntradaTabelaDeSimbolos(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }
    
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
	    //inicializacao dos parametros
            this.parametros = new ArrayList<String>();
        
            for(int i=0; i< listaPassada.size(); i++)
            {
               this.parametros.add(i,listaPassada.get(i));
            }
        }

        
    }
      
      public List<String> getListaPar(){
        return this.parametros;
    }
    
    public String getNome() {
        return nome;
    }
    
     public TabelaDeSimbolos getsubTabela()
    {
        return this.subTabeladoRegistro;
    }
    public String getTipo() {
        return tipo;
    }
    
    @Override
    public String toString() {
        return nome+"("+tipo+")";
    }
}
