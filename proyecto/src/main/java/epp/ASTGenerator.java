package epp;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.Trees;
import java.io.IOException;

/**
 * Genera y muestra gráficamente el árbol sintáctico (AST)
 * del lenguaje EPP.
 */
public class ASTGenerator {

    public static void showAST(String filePath) throws IOException {
        // 1️⃣ Crear flujo de entrada
        CharStream input = CharStreams.fromFileName(filePath);

        // 2️⃣ Crear lexer y parser generados por ANTLR
        EPPLexer lexer = new EPPLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EPPParser parser = new EPPParser(tokens);

        // 3️⃣ Obtener árbol sintáctico (regla inicial: programa)
        ParseTree tree = parser.programa();

        // 4️⃣ Mostrar GUI interactiva del árbol
        Trees.inspect(tree, parser);
    }
}