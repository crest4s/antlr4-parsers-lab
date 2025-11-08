package ikea;

import java.util.Scanner;

public class IkeaMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ANALIZADOR IKEA ===");

        while (true) {
            try {
                System.out.print("\nIntroduce la ruta del archivo .ikea (o 'exit' para salir): ");
                String filePath = scanner.nextLine().trim();

                if (filePath.equalsIgnoreCase("exit")) {
                    System.out.println("👋 Saliendo del analizador IKEA...");
                    break;
                }

                System.out.println("🔹 Generando y mostrando árbol sintáctico...");
                ASTGenerator.showAST(filePath);

            } catch (Exception e) {
                System.err.println("❌ Error al generar o mostrar el AST:");
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}