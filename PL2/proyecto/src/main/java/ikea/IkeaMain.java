package ikea;

import java.util.Scanner;

/**
 * Clase principal `IkeaMain` que actúa como punto de entrada para el analizador IKEA.
 * Permite al usuario interactuar con el programa para analizar archivos IKEA y
 * mostrar gráficamente el árbol sintáctico (AST) generado.
 */
public class IkeaMain {

    /**
     * Método principal que inicia el programa y gestiona la interacción con el usuario.
     * Solicita la ruta de un archivo IKEA, genera y muestra gráficamente su AST.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ANALIZADOR IKEA ===");

        // Bucle principal para interactuar con el usuario
        while (true) {
            try {
                // Solicitar la ruta del archivo IKEA o la opción de salir
                System.out.print("\nIntroduce la ruta del archivo .ikea (o 'exit' para salir): ");
                String filePath = scanner.nextLine().trim();

                // Salir del programa si el usuario introduce "exit"
                if (filePath.equalsIgnoreCase("exit")) {
                    System.out.println("Saliendo del analizador IKEA...");
                    break;
                }

                // Generar y mostrar el árbol sintáctico (AST) del archivo proporcionado
                System.out.println("Generando y mostrando árbol sintáctico...");
                ASTGenerator.showAST(filePath);

            } catch (Exception e) {
                // Manejar errores durante la generación o visualización del AST
                System.err.println("Error al generar o mostrar el AST:");
                e.printStackTrace();
            }
        }

        // Cerrar el escáner al finalizar el programa
        scanner.close();
    }
}
