package org.antlr;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest
{
    @Test
    public void testHelloWorld() {
        String appHelloWorld = "print(\"Hello, World!\")";
        Swift lexer = new Swift(CharStreams.fromString(appHelloWorld));
        String expected = "Loc=<1:0>\tPRINT  'print'\n" +
                "Loc=<1:5>\tRLP  '('\n" +
                "Loc=<1:6>\tSTRING_CONST  '\"Hello, World!\"'\n" +
                "Loc=<1:21>\tRRP  ')'\n";
        String result = new String();
        for (Token token : lexer.getAllTokens()) {
            result += "Loc=<" + token.getLine() + ':' + token.getCharPositionInLine() + ">\t" +
                    Swift.VOCABULARY.getSymbolicName(token.getType()) + "  '" + token.getText() + "'\n";
        }
        assertEquals(expected, result);
    }

    @Test
    public void testReservedWords() {
        String reserved = "var\nlet\nif\nelse if\nwhile\nfor\nprint\nswitch\ncase\ndefault\nerr";
        Swift lexer = new Swift(CharStreams.fromString(reserved));
        String expected = "VAR\nLET\nIF\nELSE_IF\nWHILE\nFOR\nPRINT\nSWITCH\nCASE\nDEFAULT\nID\n";
        String result = new String();
        for (Token token : lexer.getAllTokens()) {
            result += Swift.VOCABULARY.getSymbolicName(token.getType()) + "\n";
        }
        assertEquals(expected, result);
    }

    @Test
    public void testComments() {
        String comments = "// THIS IS COMMENT 1\n/* THIS IS COMMENT 2*/\n";
        Swift lexer = new Swift(CharStreams.fromString(comments));
        String expected = "COMMENT1\nCOMMENT2\n";
        String result = new String();
        for (Token token : lexer.getAllTokens()) {
            result += Swift.VOCABULARY.getSymbolicName(token.getType()) + "\n";
        }
        assertEquals(expected, result);
    }

    @Test
    public void testID() {
        String id = "__var1__\nvar2\n1var\n1234567890\nvar_2___0__varvar__123";
        Swift lexer = new Swift(CharStreams.fromString(id));
        String expected = "ID\nID\nDEC_DIGIT\nVAR\nDEC_DIGIT\nID\n";
        String result = new String();
        for (Token token : lexer.getAllTokens()) {
            result += Swift.VOCABULARY.getSymbolicName(token.getType()) + "\n";
        }
        assertEquals(expected, result);
    }

    @Test
    public void testOperators() {
        String operators = "=\n==\n!=\n!\n>=\n<=\n?\n+=\n-=\n*=\n/=\n";
        Swift lexer = new Swift(CharStreams.fromString(operators));
        String expected = "ASSIGN\nEQ\nNOT_EQ\nEXCLAM\nMR_EQ\nLESS_EQ\nOP\nASSIGN_PLUS\nASSIGN_MINUS\nASSIGN_MUL\nASSIGN_DIV\n";
        String result = new String();
        for (Token token : lexer.getAllTokens()) {
            result += Swift.VOCABULARY.getSymbolicName(token.getType()) + "\n";
        }
        assertEquals(expected, result);
    }
}
