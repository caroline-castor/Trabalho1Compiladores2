package t1;

public class Saida {
    private static StringBuffer texto = new StringBuffer();
    
    public static void println(String txt) {
        texto.append(txt).append("\n");
    }
    
    public static void clear() {
        texto = new StringBuffer();
    }
    
    public static String getTexto() {
        return texto.toString();
    }

    static boolean is_modified() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
