package ikea;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.Trees;
import java.io.IOException;

/**
 * Genera y muestra gráficamente el árbol sintáctico (AST)
 * del lenguaje IKEA.
 */
public class ASTGenerator {

    public static void showAST(String filePath) throws IOException {
        // 1️⃣ Crear flujo de entrada
        CharStream input = CharStreams.fromFileName(filePath);

        // 2️⃣ Crear lexer y parser generados por ANTLR
        IKEALexer lexer = new IKEALexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IKEAParser parser = new IKEAParser(tokens);

        // 3️⃣ Obtener árbol sintáctico (regla inicial: manual)
        ParseTree tree = parser.manual();

        // 4️⃣ Mostrar GUI interactiva del árbol
        Trees.inspect(tree, parser);
    }
}