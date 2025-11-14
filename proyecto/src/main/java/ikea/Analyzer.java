package ikea;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;

/**
 * Analizador para la gramática IKEA.g4
 * --------------------------------------------------
 * Funcionalidad:
 *  ✅ Lee un manual IKEA (archivo de texto).
 *  ✅ Procesa los pasos con ANTLR4.
 *  ✅ Construye una tabla de símbolos (herrajes y herramientas).
 *  ✅ Muestra las acciones, herrajes y herramientas por paso y totales.
 *
 * Compatible con gramática IKEA.g4 (última versión con alias paso/veces en "repetir").
 */
public class Analyzer {

    // --------------------------------------------------
    // MAIN
    // --------------------------------------------------
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Introduce la ruta del archivo del manual IKEA: ");
            String path = scanner.nextLine().trim();

            if (path.isEmpty()) {
                System.err.println("No se ha introducido ninguna ruta. Finalizando programa.");
                return;
            }

            String input = Files.readString(Paths.get(path));

            CharStream cs = CharStreams.fromString(input);
            IKEALexer lexer = new IKEALexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            IKEAParser parser = new IKEAParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new DiagnosticErrorListener());
            parser.setErrorHandler(new BailErrorStrategy());

            ParseTree tree = parser.manual();

            SymbolTable st = new SymbolTable();
            AnalyzerVisitor visitor = new AnalyzerVisitor(st);
            visitor.visit(tree);

            st.printReport(visitor.getItemId());

        } catch (ParseCancellationException e) {
            System.err.println("Error de sintaxis: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error en el análisis: ");
            e.printStackTrace();
        }
    }

    // --------------------------------------------------
    // TABLA DE SÍMBOLOS
    // --------------------------------------------------
    public static class SymbolTable {
        private final Map<Integer, List<String>> stepActions = new LinkedHashMap<>();
        private final Map<String, Integer> components = new LinkedHashMap<>();
        private final LinkedHashSet<String> tools = new LinkedHashSet<>();

        private final Map<Integer, Map<String, Integer>> componentsByStep = new LinkedHashMap<>();
        private final Map<Integer, LinkedHashSet<String>> toolsByStep = new LinkedHashMap<>();

        public void addAction(int step, String action) {
            stepActions.computeIfAbsent(step, k -> new ArrayList<>()).add(action);
        }

        public void addTool(String tool) {
            if (tool == null || tool.isEmpty()) return;
            tools.add(tool);
        }

        public void addTool(int step, String tool) {
            if (tool == null || tool.isEmpty()) return;
            addTool(tool);
            toolsByStep.computeIfAbsent(step, k -> new LinkedHashSet<>()).add(tool);
        }

        public void addComponent(String name, int qty) {
            if (name == null || name.isEmpty() || qty <= 0) return;
            components.merge(name, qty, Integer::sum);
        }

        public void addComponent(int step, String name, int qty) {
            addComponent(name, qty);
            componentsByStep
                    .computeIfAbsent(step, k -> new LinkedHashMap<>())
                    .merge(name, qty, Integer::sum);
        }

        public void printReport(String itemId) {
            System.out.println("\n==============================");
            System.out.println(" ITEM: " + itemId);
            System.out.println("==============================\n");

            System.out.println("PASOS:");
            for (Map.Entry<Integer, List<String>> e : stepActions.entrySet()) {
                int stepNo = e.getKey();
                List<String> actions = e.getValue();
                System.out.println(stepNo + ") " + String.join(", ", actions));

                Map<String, Integer> comps = componentsByStep.get(stepNo);
                if (comps != null && !comps.isEmpty()) {
                    System.out.println("   - Herrajes: " + comps);
                }
                LinkedHashSet<String> tps = toolsByStep.get(stepNo);
                if (tps != null && !tps.isEmpty()) {
                    System.out.println("   - Herramientas: " + tps);
                }
            }

            System.out.println("\nHERRAJES / COMPONENTES (totales):");
            if (components.isEmpty()) System.out.println("   (ninguno detectado)");
            else components.forEach((k, v) -> System.out.println("   - " + k + ": " + v));

            System.out.println("\nHERRAMIENTAS (totales):");
            if (tools.isEmpty()) System.out.println("   (ninguna)");
            else tools.forEach(t -> System.out.println("   - " + t));

            System.out.println();
        }
    }

    // --------------------------------------------------
    // VISITOR PRINCIPAL
    // --------------------------------------------------
    public static class AnalyzerVisitor extends IKEABaseVisitor<Void> {
        private final SymbolTable st;
        private String itemId = "";
        private int currentStep = -1;

        public AnalyzerVisitor(SymbolTable st) { this.st = st; }
        public String getItemId() { return itemId; }

        // ---------- Helpers ----------
        private void countListaComponentes(IKEAParser.ListaComponentesContext ctx) {
            if (ctx == null) return;
            for (IKEAParser.ComponenteContext c : ctx.componente()) countComponente(c);
        }

        private static String normalizeTipo(String t) {
            if (t == null) return null;
            String s = t.toLowerCase(Locale.ROOT);
            if (s.startsWith("tornillo")) return "tornillo";
            if (s.startsWith("espiga")) return "espiga";
            if (s.startsWith("placa")) return "placa";
            if (s.startsWith("arandela")) return "arandela";
            if (s.startsWith("escuadra")) return "escuadra";
            if (s.startsWith("soporte")) return "soporte";
            if (s.startsWith("taco")) return "taco";
            if (s.startsWith("listón") || s.startsWith("liston")) return "listón";
            if (s.startsWith("balda")) return "balda";
            if (s.startsWith("travesa")) return "travesa";
            if (s.startsWith("panel")) return "panel";
            return s;
        }

        private void countComponente(IKEAParser.ComponenteContext c) {
            if (c == null) return;
            int qty = 1;
            if (c.cantidad() != null && c.cantidad().INT() != null) {
                try {
                    qty = Integer.parseInt(c.cantidad().INT().getText());
                } catch (NumberFormatException ignored) {}
            }
            String tipo = c.tipo().getText();
            String normTipo = normalizeTipo(tipo);

            String name = normTipo;
            if (c.codigo() != null) {
                name = normTipo + " " + c.codigo().getText();
            }
            st.addComponent(currentStep, name, qty);
        }

        private String herramientaText(IKEAParser.HerramientaContext h) {
            return (h == null) ? null : h.getText().toLowerCase(Locale.ROOT);
        }

        // ---------- Overrides ----------
        @Override
        public Void visitItemHeader(IKEAParser.ItemHeaderContext ctx) {
            this.itemId = ctx.ID().getText();
            return null;
        }

        @Override
        public Void visitInstruction(IKEAParser.InstructionContext ctx) {
            try { currentStep = Integer.parseInt(ctx.INT().getText()); }
            catch (Exception e) { currentStep = -1; }
            return super.visitInstruction(ctx);
        }

        @Override public Void visitAccionUnir(IKEAParser.AccionUnirContext ctx) {
            st.addAction(currentStep, "Unir");
            return super.visitAccionUnir(ctx);
        }

        @Override public Void visitAccionColocar(IKEAParser.AccionColocarContext ctx) {
            st.addAction(currentStep, "Colocar");
            if (ctx.colocar().listaComponentes() != null) {
                countListaComponentes(ctx.colocar().listaComponentes());
            }
            return super.visitAccionColocar(ctx);
        }

        @Override public Void visitAccionAtornillar(IKEAParser.AccionAtornillarContext ctx) {
            st.addAction(currentStep, "Atornillar");
            st.addTool(currentStep, "destornillador");
            countListaComponentes(ctx.atornillar().listaComponentes());
            return super.visitAccionAtornillar(ctx);
        }

        @Override public Void visitAccionInsertar(IKEAParser.AccionInsertarContext ctx) {
            st.addAction(currentStep, "Insertar");
            countListaComponentes(ctx.insertar().listaComponentes());
            return super.visitAccionInsertar(ctx);
        }

        @Override public Void visitAccionClavar(IKEAParser.AccionClavarContext ctx) {
            st.addAction(currentStep, "Clavar");
            st.addTool(currentStep, "martillo");
            countListaComponentes(ctx.clavar().listaComponentes());
            return super.visitAccionClavar(ctx);
        }

        @Override public Void visitAccionMarcar(IKEAParser.AccionMarcarContext ctx) {
            st.addAction(currentStep, "Marcar");
            st.addTool(currentStep, herramientaText(ctx.marcar().herramienta()));
            return super.visitAccionMarcar(ctx);
        }

        @Override public Void visitAccionDesplegar(IKEAParser.AccionDesplegarContext ctx) { st.addAction(currentStep, "Desplegar"); return super.visitAccionDesplegar(ctx); }
        @Override public Void visitAccionDeslizar(IKEAParser.AccionDeslizarContext ctx)   { st.addAction(currentStep, "Deslizar");  return super.visitAccionDeslizar(ctx); }
        @Override public Void visitAccionSacar(IKEAParser.AccionSacarContext ctx)         { st.addAction(currentStep, "Sacar");     return super.visitAccionSacar(ctx); }
        @Override public Void visitAccionGirar(IKEAParser.AccionGirarContext ctx)         { st.addAction(currentStep, "Girar");     return super.visitAccionGirar(ctx); }
        @Override public Void visitAccionVoltear(IKEAParser.AccionVoltearContext ctx)     { st.addAction(currentStep, "Voltear");   return super.visitAccionVoltear(ctx); }
        @Override public Void visitAccionNivelar(IKEAParser.AccionNivelarContext ctx)     { st.addAction(currentStep, "Nivelar");   return super.visitAccionNivelar(ctx); }
        @Override public Void visitAccionFijar(IKEAParser.AccionFijarContext ctx)         { st.addAction(currentStep, "Fijar");     return super.visitAccionFijar(ctx); }

        // === "Con <herramienta>, <accion>" ===
        @Override
        public Void visitAccionConHerramienta(IKEAParser.AccionConHerramientaContext ctx) {
            String tool = herramientaText(ctx.conHerramienta().herramienta());
            st.addTool(currentStep, tool);

            if (ctx.atornillar() != null) {
                st.addAction(currentStep, "Atornillar");
                countListaComponentes(ctx.atornillar().listaComponentes());
            } else if (ctx.clavar() != null) {
                st.addAction(currentStep, "Clavar");
                countListaComponentes(ctx.clavar().listaComponentes());
            } else if (ctx.insertar() != null) {
                st.addAction(currentStep, "Insertar");
                countListaComponentes(ctx.insertar().listaComponentes());
            } else if (ctx.colocar() != null) {
                st.addAction(currentStep, "Colocar");
                if (ctx.colocar().listaComponentes() != null)
                    countListaComponentes(ctx.colocar().listaComponentes());
            }
            return super.visitAccionConHerramienta(ctx);
        }

        // === Repetir (usa subcontexto RepetirContext con alias paso/veces) ===
        @Override
        public Void visitAccionRepetir(IKEAParser.AccionRepetirContext ctx) {
            IKEAParser.RepetirContext repCtx = ctx.repetir();

            String pasoTxt  = (repCtx.paso  != null) ? repCtx.paso.getText()  : "?";
            String vecesTxt = (repCtx.veces != null) ? repCtx.veces.getText() : null;

            String name = "Repetir(" + pasoTxt + (vecesTxt != null ? ", x" + vecesTxt : "") + ")";
            st.addAction(currentStep, name);

            System.out.println(
                    "[INFO] Paso " + currentStep + " repite el paso " + pasoTxt +
                            (vecesTxt != null ? " " + vecesTxt + " veces." : ".")
            );

            return super.visitAccionRepetir(ctx);
        }
    }
}