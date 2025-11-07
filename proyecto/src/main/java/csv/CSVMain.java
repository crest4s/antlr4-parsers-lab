package csv;

import java.util.Scanner;

public class CSVMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ANALIZADOR CSV ===");

        while (true) {
            try {
                System.out.println("\nOpciones:");
                System.out.println("1. Mostrar AST (modo gráfico)");
                System.out.println("2. Generar AST (modo texto)");
                System.out.println("3. Cambiar archivo de entrada");
                System.out.println("Escribe 'exit' para salir.");
                System.out.print("> ");

                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("👋 Saliendo del analizador CSV...");
                    break;
                }

                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1 -> {
                        System.out.print("Ruta del archivo CSV: ");
                        String filePath = scanner.nextLine().trim();
                        System.out.println("🔹 Mostrando árbol sintáctico interactivo...");
                        ASTGenerator.showAST(filePath);
                    }
                    case 2 -> {
                        System.out.print("Ruta del archivo CSV: ");
                        String filePath = scanner.nextLine().trim();
                        System.out.print("Ruta de salida del archivo .txt: ");
                        String outputPath = scanner.nextLine().trim();
                        System.out.println("🔹 Generando AST textual...");
                        ASTTextGenerator.generateASTText(filePath, outputPath);
                    }
                    case 3 -> {
                        System.out.print("Introduce la nueva ruta de archivo CSV: ");
                        String newPath = scanner.nextLine().trim();
                        System.out.println("Archivo configurado: " + newPath);
                    }
                    default -> System.out.println("❌ Opción no válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Introduce un número válido o 'exit' para salir.");
            } catch (Exception e) {
                System.err.println("❌ Error al procesar:");
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}