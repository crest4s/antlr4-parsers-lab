package epp;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase `ASTTextGenerator` que genera una representación textual del árbol sintáctico (AST)
 * del lenguaje EPP, filtrando detalles sintácticos y mostrando solo la estructura semántica.
 */
public class ASTTextGenerator {

    /**
     * Genera un AST textual a partir de un archivo de entrada y lo guarda en un archivo de salida.
     *
     * @param filePath   Ruta del archivo de entrada que contiene el código fuente en EPP.
     * @param outputPath Ruta del archivo donde se guardará la representación textual del AST.
     * @throws IOException Si ocurre un error al leer o escribir en los archivos.
     */
    public static void generateASTText(String filePath, String outputPath) throws IOException {
        // 1. Crear flujo de entrada
        CharStream input = CharStreams.fromFileName(filePath);

        // 2. Crear lexer y parser
        EPPLexer lexer = new EPPLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EPPParser parser = new EPPParser(tokens);

        // 3. Obtener árbol sintáctico
        EPPParser.ProgramaContext tree = parser.programa();

        // 4. Generar texto a partir del árbol (AST semántico)
        StringBuilder sb = new StringBuilder();
        sb.append("Programa:\n");
        printPrograma(tree, sb, 1);

        // 5. Guardar en archivo
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(sb.toString());
        }

        System.out.println("AST textual de EPP guardado en: " + outputPath);
    }

    /**
     * Imprime los nodos del programa en el AST.
     *
     * @param ctx   Contexto del programa en el árbol sintáctico.
     * @param sb    `StringBuilder` donde se almacenará la representación textual.
     * @param indent Nivel de indentación para la representación jerárquica.
     */
    private static void printPrograma(EPPParser.ProgramaContext ctx, StringBuilder sb, int indent) {
        if (ctx == null || ctx.children == null) return;

        for (ParseTree child : ctx.children) {
            if (child instanceof EPPParser.InstruccionContext instruccionCtx) {
                printInstruccion(instruccionCtx, sb, indent);
            } else if (child instanceof EPPParser.ComentarioContext comentarioCtx) {
                printComentario(comentarioCtx, sb, indent);
            }
        }
    }

    /**
     * Imprime un comentario del AST.
     *
     * @param ctx   Contexto del comentario en el árbol sintáctico.
     * @param sb    `StringBuilder` donde se almacenará la representación textual.
     * @param indent Nivel de indentación para la representación jerárquica.
     */
    private static void printComentario(EPPParser.ComentarioContext ctx, StringBuilder sb, int indent) {
        String text = ctx.COMENTARIO().getText();
        // Quitar el '#' inicial
        if (text.startsWith("#")) {
            text = text.substring(1).trim();
        }
        sb.append(indent(indent)).append("Comentario: ").append(text).append("\n");
    }

    /**
     * Imprime una instrucción del AST.
     *
     * @param ctx   Contexto de la instrucción en el árbol sintáctico.
     * @param sb    `StringBuilder` donde se almacenará la representación textual.
     * @param indent Nivel de indentación para la representación jerárquica.
     */
    private static void printInstruccion(EPPParser.InstruccionContext ctx, StringBuilder sb, int indent) {
        if (ctx.asignacion() != null) {
            printAsignacion(ctx.asignacion(), sb, indent);
        } else if (ctx.mostrar() != null) {
            printMostrar(ctx.mostrar(), sb, indent);
        } else if (ctx.condicional() != null) {
            printCondicional(ctx.condicional(), sb, indent);
        } else if (ctx.leer() != null) {
            printLeer(ctx.leer(), sb, indent);
        } else if (ctx.mientras() != null) {
            printMientras(ctx.mientras(), sb, indent);
        }
    }

    /**
     * Imprime una asignación del AST.
     *
     * @param ctx   Contexto de la asignación en el árbol sintáctico.
     * @param sb    `StringBuilder` donde se almacenará la representación textual.
     * @param indent Nivel de indentación para la representación jerárquica.
     */
    private static void printAsignacion(EPPParser.AsignacionContext ctx, StringBuilder sb, int indent) {
        sb.append(indent(indent)).append("Asignación:\n");

        String varName = ctx.ID().getText(); // en ambas alternativas hay un solo ID
        sb.append(indent(indent + 1)).append("Variable: ").append(varName).append("\n");

        String exprText = prettyExpr(ctx.expresion());
        sb.append(indent(indent + 1)).append("Valor: ").append(exprText).append("\n");
    }

    /**
     * Imprime una instrucción de mostrar del AST.
     *
     * @param ctx   Contexto de la instrucción de mostrar en el árbol sintáctico.
     * @param sb    `StringBuilder` donde se almacenará la representación textual.
     * @param indent Nivel de indentación para la representación jerárquica.
     */
    private static void printMostrar(EPPParser.MostrarContext ctx, StringBuilder sb, int indent) {
        sb.append(indent(indent)).append("Mostrar:\n");
        String exprText = prettyExpr(ctx.expresion());
        sb.append(indent(indent + 1)).append("Expresión: ").append(exprText).append("\n");
    }

    /**
     * Imprime una instrucción de leer del AST.
     *
     * @param ctx   Contexto de la instrucción de leer en el árbol sintáctico.
     * @param sb    `StringBuilder` donde se almacenará la representación textual.
     * @param indent Nivel de indentación para la representación jerárquica.
     */
    private static void printLeer(EPPParser.LeerContext ctx, StringBuilder sb, int indent) {
        sb.append(indent(indent)).append("Leer:\n");
        sb.append(indent(indent + 1)).append("Variable: ").append(ctx.ID().getText()).append("\n");
    }

    /**
     * Imprime una instrucción de mientras del AST.
     *
     * @param ctx   Contexto de la instrucción de mientras en el árbol sintáctico.
     * @param sb    `StringBuilder` donde se almacenará la representación textual.
     * @param indent Nivel de indentación para la representación jerárquica.
     */
    private static void printMientras(EPPParser.MientrasContext ctx, StringBuilder sb, int indent) {
        sb.append(indent(indent)).append("Mientras:\n");
        String condText = prettyExpr(ctx.expresion());
        sb.append(indent(indent + 1)).append("Condición: ").append(condText).append("\n");

        sb.append(indent(indent + 1)).append("Bloque:\n");
        printBloque(ctx.bloque(), sb, indent + 2);
    }

    /**
     * Imprime una instrucción condicional del AST.
     *
     * @param ctx   Contexto de la instrucción condicional en el árbol sintáctico.
     * @param sb    `StringBuilder` donde se almacenará la representación textual.
     * @param indent Nivel de indentación para la representación jerárquica.
     */
    private static void printCondicional(EPPParser.CondicionalContext ctx, StringBuilder sb, int indent) {
        sb.append(indent(indent)).append("Condicional:\n");

        String condText = prettyExpr(ctx.expresion());
        sb.append(indent(indent + 1)).append("Condición: ").append(condText).append("\n");

        // Bloque "si"
        sb.append(indent(indent + 1)).append("BloqueSi:\n");
        printBloque(ctx.bloque(0), sb, indent + 2);

        // Bloque "no" (si existe)
        if (ctx.bloque().size() > 1) {
            sb.append(indent(indent + 1)).append("BloqueNo:\n");
            printBloque(ctx.bloque(1), sb, indent + 2);
        }
    }

    /**
     * Imprime un bloque de instrucciones del AST.
     *
     * @param ctx   Contexto del bloque en el árbol sintáctico.
     * @param sb    `StringBuilder` donde se almacenará la representación textual.
     * @param indent Nivel de indentación para la representación jerárquica.
     */
    private static void printBloque(EPPParser.BloqueContext ctx, StringBuilder sb, int indent) {
        if (ctx == null || ctx.children == null) return;

        for (ParseTree child : ctx.children) {
            if (child instanceof EPPParser.InstruccionContext instruccionCtx) {
                printInstruccion(instruccionCtx, sb, indent);
            } else if (child instanceof EPPParser.ComentarioContext comentarioCtx) {
                printComentario(comentarioCtx, sb, indent);
            }
        }
    }

    /**
     * Genera una representación textual de una expresión del AST.
     *
     * @param ctx Contexto de la expresión en el árbol sintáctico.
     * @return Representación textual de la expresión.
     */
    private static String prettyExpr(EPPParser.ExpresionContext ctx) {
        if (ctx == null) return "";

        if (ctx instanceof EPPParser.ExprComparacionContext c) {
            String left = prettyExpr(c.expresion(0));
            String op = c.operadorComparacion().getText();
            String right = prettyExpr(c.expresion(1));
            return left + " " + op + " " + right;
        }

        if (ctx instanceof EPPParser.ExprAritmeticaSumaRestaContext c) {
            String left = prettyExpr(c.expresion(0));
            String op = c.operadorAditivo().getText();
            String right = prettyExpr(c.expresion(1));
            return left + " " + op + " " + right;
        }

        if (ctx instanceof EPPParser.ExprAritmeticaMultDivContext c) {
            String left = prettyExpr(c.expresion(0));
            String op = c.operadorMultiplicativo().getText();
            String right = prettyExpr(c.expresion(1));
            return left + " " + op + " " + right;
        }

        if (ctx instanceof EPPParser.ExprParentesisContext c) {
            return "(" + prettyExpr(c.expresion()) + ")";
        }

        if (ctx instanceof EPPParser.ExprVariableContext c) {
            return c.ID().getText();
        }

        if (ctx instanceof EPPParser.ExprNumeroContext c) {
            return c.NUM().getText();
        }

        if (ctx instanceof EPPParser.ExprTextoContext c) {
            return c.STRING().getText();
        }

        if (ctx instanceof EPPParser.ExprBooleanoVerdaderoContext c) {
            return c.VERDADERO().getText();
        }

        if (ctx instanceof EPPParser.ExprBooleanoFalsoContext c) {
            return c.FALSO().getText();
        }

        // Fallback genérico (no debería usarse casi nunca)
        return ctx.getText();
    }

    /**
     * Genera una cadena de espacios para la indentación.
     *
     * @param level Nivel de indentación.
     * @return Cadena de espacios correspondiente al nivel de indentación.
     */
    private static String indent(int level) {
        return "  ".repeat(Math.max(0, level));
    }
}