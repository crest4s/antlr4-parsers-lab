package epp;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Genera un AST textual legible del lenguaje EPP y lo guarda en un archivo .txt.
 */
public class ASTTextGenerator {

    public static void generateASTText(String filePath, String outputPath) throws IOException {
        // 1️⃣ Crear flujo de entrada
        CharStream input = CharStreams.fromFileName(filePath);

        // 2️⃣ Crear lexer y parser
        EPPLexer lexer = new EPPLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EPPParser parser = new EPPParser(tokens);

        // 3️⃣ Obtener árbol sintáctico
        ParseTree tree = parser.programa();

        // 4️⃣ Generar texto legible del árbol
        StringBuilder sb = new StringBuilder();
        printTree(tree, parser, sb, 0);

        // 5️⃣ Guardar en archivo
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(sb.toString());
        }

        System.out.println("✅ AST textual de EPP guardado en: " + outputPath);
    }

    // Función recursiva con indentación para un formato legible
    private static void printTree(ParseTree tree, EPPParser parser, StringBuilder sb, int indent) {
        String indentStr = "  ".repeat(indent);
        String nodeText = Trees.getNodeText(tree, parser);
        sb.append(indentStr).append(nodeText).append("\n");

        for (int i = 0; i < tree.getChildCount(); i++) {
            printTree(tree.getChild(i), parser, sb, indent + 1);
        }
    }
}