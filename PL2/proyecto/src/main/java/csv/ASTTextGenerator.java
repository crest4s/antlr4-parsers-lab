package csv;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase `ASTTextGenerator` que genera una representación textual del árbol sintáctico (AST)
 * de un archivo CSV y la guarda en un archivo de texto.
 */
public class ASTTextGenerator {

    /**
     * Genera una representación textual del árbol sintáctico (AST) y la guarda en un archivo.
     *
     * @param filePath   Ruta del archivo CSV que se desea analizar.
     * @param outputPath Ruta del archivo donde se guardará la representación textual del AST.
     * @throws IOException Si ocurre un error al leer o escribir en los archivos.
     */
    public static void generateASTText(String filePath, String outputPath) throws IOException {
        // 1. Crear flujo de entrada desde el archivo especificado
        CharStream input = CharStreams.fromFileName(filePath);

        // 2. Crear el lexer y el parser generados por ANTLR
        CSVLexer lexer = new CSVLexer(input); // Lexer para analizar los tokens del archivo CSV
        CommonTokenStream tokens = new CommonTokenStream(lexer); // Flujo de tokens generado por el lexer
        CSVParser parser = new CSVParser(tokens); // Parser para construir el árbol sintáctico

        // 3. Obtener el árbol sintáctico a partir de la regla inicial del parser
        ParseTree tree = parser.csv();

        // 4. Generar la representación textual del árbol sintáctico
        StringBuilder sb = new StringBuilder();
        printTreeFiltered(tree, parser, sb, 0);

        // 5. Guardar la representación textual en el archivo de salida
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(sb.toString());
        }

        // Mensaje de confirmación
        System.out.println("AST textual guardado en: " + outputPath);
    }

    /**
     * Genera una representación filtrada del árbol sintáctico y la agrega a un `StringBuilder`.
     *
     * @param tree   Árbol sintáctico generado por el parser.
     * @param parser Parser utilizado para obtener los nombres de las reglas.
     * @param sb     `StringBuilder` donde se almacenará la representación textual.
     * @param indent Nivel de indentación para la representación jerárquica.
     */
    private static void printTreeFiltered(ParseTree tree, CSVParser parser, StringBuilder sb, int indent) {
        // Obtener el texto del nodo actual
        String nodeText = Trees.getNodeText(tree, parser);

        // Omitir nodos irrelevantes
        if (nodeText.equals("<EOF>")) return;
        if (nodeText.equals(";")) return;
        if (nodeText.equals(",")) return;
        if (nodeText.equals("|")) return;
        if (nodeText.trim().isEmpty()) return;

        // Si el nodo es un terminal con contenido, agregarlo al resultado
        if (tree instanceof TerminalNode) {
            String text = tree.getText().trim();

            // Ignorar tokens estructurales como coma, punto y coma, etc.
            if (!text.equals(";") && !text.equals("<EOF>"))
                sb.append("  ".repeat(indent)).append(text).append("\n");

            return;
        }

        // Si el nodo corresponde a la regla 'fila', agregar un encabezado
        if (parser.getRuleNames()[((RuleContext) tree).getRuleIndex()].equals("fila")) {
            sb.append("Fila:\n");
        }

        // Recorrer los hijos del nodo actual
        for (int i = 0; i < tree.getChildCount(); i++) {
            printTreeFiltered(tree.getChild(i), parser, sb, indent + 1);
        }
    }
}
