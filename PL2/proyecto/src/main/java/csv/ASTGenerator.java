package csv;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.Trees;
import java.io.IOException;
import csv.*;

public class ASTGenerator {

    /**
     * Genera y muestra el árbol sintáctico (AST) de un archivo CSV.
     */
    public static void showAST(String filePath) throws IOException {
        // 1. Crear flujo de entrada
        CharStream input = CharStreams.fromFileName(filePath);

        // 2. Crear lexer y parser generados por ANTLR
        CSVLexer lexer = new CSVLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CSVParser parser = new CSVParser(tokens);

        // 3. Obtener árbol sintáctico (regla inicial)
        ParseTree tree = parser.csv();

        // 4. Mostrar GUI interactiva del árbol (equivalente a 'grun CSV file -gui')
        Trees.inspect(tree, parser);
    }
}
