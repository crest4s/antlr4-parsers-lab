import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Uso: java Main <gramatica> <archivo>");
            return;
        }

        String grammar = args[0];
        String filename = args[1];
        CharStream input = CharStreams.fromFileName(filename);

        switch (grammar) {
            case "csv":
                CSVLexer csvLexer = new CSVLexer(input);
                CommonTokenStream csvTokens = new CommonTokenStream(csvLexer);
                CSVParser csvParser = new CSVParser(csvTokens);
                ParseTree csvTree = csvParser.file();
                CSVPrinter csvPrinter = new CSVPrinter();
                ParseTreeWalker.DEFAULT.walk(csvPrinter, csvTree);
                break;

            case "epp":
                EPPLexer eppLexer = new EPPLexer(input);
                CommonTokenStream eppTokens = new CommonTokenStream(eppLexer);
                EPPParser eppParser = new EPPParser(eppTokens);
                ParseTree eppTree = eppParser.program();
                EPPPrinter eppPrinter = new EPPPrinter();
                ParseTreeWalker.DEFAULT.walk(eppPrinter, eppTree);
                break;

            case "ikea":
                IkeaLangLexer ikeaLexer = new IkeaLangLexer(input);
                CommonTokenStream ikeaTokens = new CommonTokenStream(ikeaLexer);
                IkeaLangParser ikeaParser = new IkeaLangParser(ikeaTokens);
                ParseTree ikeaTree = ikeaParser.assembly();
                IkeaPrinter ikeaPrinter = new IkeaPrinter();
                ParseTreeWalker.DEFAULT.walk(ikeaPrinter, ikeaTree);
                break;

            default:
                System.out.println("Gramática no reconocida (usa: csv | epp | ikea)");
        }
    }
}