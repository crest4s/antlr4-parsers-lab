package epp;

import java.util.Scanner;

/**
 * Clase principal `EPPMain` que actúa como punto de entrada para el analizador EPP.
 * Permite al usuario interactuar con el programa para analizar archivos EPP,
 * mostrar el árbol sintáctico (AST) en modo gráfico o generar una representación textual del AST.
 */
public class EPPMain {

    /**
     * Método principal que inicia el programa y gestiona la interacción con el usuario.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ANALIZADOR EPP ===");

        String currentFile = null;

        while (true) {
            // Solicitar la ruta del archivo EPP si no hay un archivo actual configurado
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
                // Mostrar menú de opciones al usuario
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

                // Procesar la opción seleccionada por el usuario
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
                // Manejar errores de entrada no numérica
                System.out.println("Introduce un número válido o 'exit' para salir.");
            } catch (Exception e) {
                // Manejar errores generales
                System.err.println("Error al procesar:");
                e.printStackTrace();
            }
        }

        // Cerrar el escáner al finalizar el programa
        scanner.close();
    }
}