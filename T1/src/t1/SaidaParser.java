package t1;

public class SaidaParser {

    StringBuffer texto;
    boolean modified;

    public SaidaParser() {
        texto= new StringBuffer();
        modified = false;
    }

    public void println(String texto) {
        if(!modified) modified = true;
        this.texto.append(texto);
        this.texto.append("\n");
    }
    
    public boolean isModified() {
        return modified;
    }
    
    public void modify(){
        modified = true;
    }

    @Override
    public String toString() {
        return texto.toString();
    }
}