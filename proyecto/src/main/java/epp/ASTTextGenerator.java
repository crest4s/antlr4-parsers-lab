package epp;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Genera un AST textual legible del lenguaje EPP filtrando detalles sintácticos
 * y mostrando solo la estructura semántica del programa.
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
        EPPParser.ProgramaContext tree = parser.programa();

        // 4️⃣ Generar texto a partir del árbol (AST semántico)
        StringBuilder sb = new StringBuilder();
        sb.append("Programa:\n");
        printPrograma(tree, sb, 1);

        // 5️⃣ Guardar en archivo
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(sb.toString());
        }

        System.out.println("✅ AST textual de EPP guardado en: " + outputPath);
    }

    // ---------------------------------------------------------------------
    // Impresión de nodos semánticos
    // ---------------------------------------------------------------------

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

    private static void printComentario(EPPParser.ComentarioContext ctx, StringBuilder sb, int indent) {
        String text = ctx.COMENTARIO().getText();
        // Quitar el '#' inicial
        if (text.startsWith("#")) {
            text = text.substring(1).trim();
        }
        sb.append(indent(indent)).append("Comentario: ").append(text).append("\n");
    }

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

    private static void printAsignacion(EPPParser.AsignacionContext ctx, StringBuilder sb, int indent) {
        sb.append(indent(indent)).append("Asignación:\n");

        String varName = ctx.ID().getText(); // en ambas alternativas hay un solo ID
        sb.append(indent(indent + 1)).append("Variable: ").append(varName).append("\n");

        String exprText = prettyExpr(ctx.expresion());
        sb.append(indent(indent + 1)).append("Valor: ").append(exprText).append("\n");
    }

    private static void printMostrar(EPPParser.MostrarContext ctx, StringBuilder sb, int indent) {
        sb.append(indent(indent)).append("Mostrar:\n");
        String exprText = prettyExpr(ctx.expresion());
        sb.append(indent(indent + 1)).append("Expresión: ").append(exprText).append("\n");
    }

    private static void printLeer(EPPParser.LeerContext ctx, StringBuilder sb, int indent) {
        sb.append(indent(indent)).append("Leer:\n");
        sb.append(indent(indent + 1)).append("Variable: ").append(ctx.ID().getText()).append("\n");
    }

    private static void printMientras(EPPParser.MientrasContext ctx, StringBuilder sb, int indent) {
        sb.append(indent(indent)).append("Mientras:\n");
        String condText = prettyExpr(ctx.expresion());
        sb.append(indent(indent + 1)).append("Condición: ").append(condText).append("\n");

        sb.append(indent(indent + 1)).append("Bloque:\n");
        printBloque(ctx.bloque(), sb, indent + 2);
    }

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

    // ---------------------------------------------------------------------
    // Pretty-printer de expresiones (usa las alternativas etiquetadas)
    // ---------------------------------------------------------------------

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

    // ---------------------------------------------------------------------
    // Utilidad de indentación
    // ---------------------------------------------------------------------

    private static String indent(int level) {
        return "  ".repeat(Math.max(0, level));
    }
}