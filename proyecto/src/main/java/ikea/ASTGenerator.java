package ikea;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.Trees;
import java.io.IOException;

/**
 * Clase `ASTGenerator` que se encarga de generar y mostrar gráficamente
 * el árbol sintáctico (AST) del lenguaje IKEA utilizando ANTLR.
 */
public class ASTGenerator {

    /**
     * Genera y muestra gráficamente el árbol sintáctico (AST) de un archivo
     * que contiene código en el lenguaje IKEA.
     *
     * @param filePath Ruta del archivo que contiene el código fuente en IKEA.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public static void showAST(String filePath) throws IOException {
        // 1. Crear flujo de entrada desde el archivo especificado
        CharStream input = CharStreams.fromFileName(filePath);

        // 2. Crear el lexer y el parser generados por ANTLR
        IKEALexer lexer = new IKEALexer(input); // Lexer para analizar los tokens del archivo IKEA
        CommonTokenStream tokens = new CommonTokenStream(lexer); // Flujo de tokens generado por el lexer
        IKEAParser parser = new IKEAParser(tokens); // Parser para construir el árbol sintáctico

        // 3. Obtener el árbol sintáctico a partir de la regla inicial del parser (manual)
        ParseTree tree = parser.manual();

        // 4. Mostrar una interfaz gráfica interactiva del árbol sintáctico
        Trees.inspect(tree, parser);
    }
}
