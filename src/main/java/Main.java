import org.antlr.v4.runtime.*;
import java.io.*;
import org.antlr.v4.runtime.Token;

public class Main
{
    public static void main( String[] args )
    {
        if (args == null || args.length < 1) {
            System.err.println("Name required");
            System.exit(1);
        }
        String pathToFile = args[0];
        if (!pathToFile.endsWith(".swift")) {
            System.err.println("Expansion error");
            System.exit(1);
        }
        try {
            Swift lexer = new Swift(CharStreams.fromFileName(pathToFile));
            for (Token token : lexer.getAllTokens()) {
                System.out.printf("Loc=<%d:%d>\t%s  '%s'\n", token.getLine(), token.getCharPositionInLine(),
                        Swift.VOCABULARY.getSymbolicName(token.getType()), token.getText());
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}

