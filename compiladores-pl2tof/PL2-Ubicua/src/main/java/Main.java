import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Texto de entrada que queremos analizar
        String inputText = "hello world";

        // 1️⃣ Crea un flujo de caracteres de entrada
        CharStream input = CharStreams.fromString(inputText);

        // 2️⃣ Crea el lexer (analizador léxico)
        helloLexer lexer = new helloLexer(input);

        // 3️⃣ Genera un flujo de tokens a partir del lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 4️⃣ Crea el parser (analizador sintáctico)
        helloParser parser = new helloParser(tokens);

        // 5️⃣ Ejecuta la regla inicial (definida en Hello.g4 como 'r')
        ParseTree tree = parser.r();

        // 6️⃣ Muestra el árbol sintáctico resultante
        System.out.println(tree.toStringTree(parser));
    }
}