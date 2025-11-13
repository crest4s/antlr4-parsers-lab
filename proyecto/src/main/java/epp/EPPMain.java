// src/main/java/epp/EPPMain.java
package epp;

import java.util.Scanner;

public class EPPMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ANALIZADOR EPP ===");

        String currentFile = null;

        while (true) {
            if (currentFile == null) {
                System.out.print("Introduce la ruta del archivo .epp (o 'exit' para salir): ");
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Saliendo del analizador EPP...");
                    break;
                }
                if (input.isEmpty()) {
                    System.out.println("Ruta no válida.");
                    continue;
                }
                currentFile = input;
                System.out.println("Archivo configurado: " + currentFile);
            }

            try {
                System.out.println("\nArchivo activo: " + currentFile);
                System.out.println("Opciones:");
                System.out.println("1. Mostrar AST (modo gráfico)");
                System.out.println("2. Generar AST (modo texto)");
                System.out.println("3. Cambiar archivo de entrada");
                System.out.println("Escribe 'exit' para salir.");
                System.out.print("> ");

                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Saliendo del analizador EPP...");
                    break;
                }

                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1 -> {
                        System.out.println("Mostrando AST interactivo...");
                        ASTGenerator.showAST(currentFile);
                    }
                    case 2 -> {
                        System.out.print("Ruta de salida del archivo .txt: ");
                        String outputPath = scanner.nextLine().trim();
                        System.out.println("Generando AST textual...");
                        ASTTextGenerator.generateASTText(currentFile, outputPath);
                    }
                    case 3 -> {
                        System.out.print("Introduce la nueva ruta de archivo EPP (o 'cancel' para mantener): ");
                        String newPath = scanner.nextLine().trim();
                        if (newPath.equalsIgnoreCase("cancel") || newPath.isEmpty()) {
                            System.out.println("No se cambió el archivo.");
                        } else {
                            currentFile = newPath;
                            System.out.println("Archivo configurado: " + currentFile);
                        }
                    }
                    default -> System.out.println("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido o 'exit' para salir.");
            } catch (Exception e) {
                System.err.println("Error al procesar:");
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}