package csv;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Genera una representación textual del árbol sintáctico
 * y la guarda en un archivo .txt.
 */
public class ASTTextGenerator {

    public static void generateASTText(String filePath, String outputPath) throws IOException {
        // 1️⃣ Crear flujo de entrada
        CharStream input = CharStreams.fromFileName(filePath);

        // 2️⃣ Crear lexer y parser
        CSVLexer lexer = new CSVLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CSVParser parser = new CSVParser(tokens);

        // 3️⃣ Obtener árbol sintáctico
        ParseTree tree = parser.csv();

        // 4️⃣ Generar texto a partir del árbol
        StringBuilder sb = new StringBuilder();
        printTree(tree, parser, sb, 0);

        // 5️⃣ Guardar en archivo
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(sb.toString());
        }

        System.out.println("✅ AST textual guardado en: " + outputPath);
    }

    // Función recursiva para imprimir el árbol con indentación
    private static void printTree(ParseTree tree, CSVParser parser, StringBuilder sb, int indent) {
        String indentStr = "  ".repeat(indent);

        // Obtener el nombre de la regla o token
        String nodeText = Trees.getNodeText(tree, parser);

        sb.append(indentStr).append(nodeText).append("\n");

        // Recorrer los hijos recursivamente
        for (int i = 0; i < tree.getChildCount(); i++) {
            printTree(tree.getChild(i), parser, sb, indent + 1);
        }
    }
}