package t1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class TestaAnalisador {

    public static void main(String args[]) throws IOException, RecognitionException {
        SaidaParser out = new SaidaParser();
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
        LALexer lexer = new LALexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LAParser parser = new LAParser(tokens);
        try {
            // Adição dos listeners no LEXER e no PARSER
            lexer.addErrorListener(new T1ErrorListenerLexer(out));
            parser.addErrorListener(new T1ErrorListener(out));

            // Inicio 
            parser.programa();
           
        } catch (RuntimeException e) {
            // Pega as mensagens de erro semanticas
            if (e.getMessage() != null) {
                out.println(e.getMessage() + "Fim da compilacao");
            }
        }
        PrintWriter pw = new PrintWriter(new File(args[1]));
        pw.print(out.toString());
        pw.flush();
        pw.close();
    }
}
