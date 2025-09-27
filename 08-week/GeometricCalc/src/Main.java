
/**
 * Clase principal para la aplicación GeometricCalc.
 * Permite al usuario gestionar una colección de figuras geométricas (círculos, rectángulos y triángulos).
 * Ofrece un menú interactivo para mostrar, agregar y eliminar figuras.
 * 
 * Funcionalidades principales:
 * <ul>
 *   <li>Mostrar todas las figuras almacenadas.</li>
 *   <li>Almacenar una nueva figura geométrica.</li>
 *   <li>Eliminar una figura existente por índice.</li>
 *   <li>Salir de la aplicación.</li>
 * </ul>
 *
 * @author smugno
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Scanner;

import shapes.*;

public class Main {
    private static void cleanConsole() {
        for (int i = 0; i < 3; ++i)
            System.out.println();
    }

    private static int menu(Scanner scanner) {
        cleanConsole();
        System.out.println("1. Mostrar todas las figuras");
        System.out.println("2. Almacenar una nueva figura");
        System.out.println("3. Eliminar una figura existente");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        return option;
    }

    private static int menuStoreShape(Scanner scanner) {
        cleanConsole();
        System.out.println("\n1. Almacenar un circulo");
        System.out.println("2. Almacenar un rectangulo");
        System.out.println("3. Almacenar un triangulo");
        System.out.print("Seleccione una opción: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        return option;
    }

    private static void showShapes(ArrayList<Shape> shapes) {
        if (shapes.isEmpty()) {
            System.out.println("No hay figuras almacenadas.");
            return;
        }
        cleanConsole();
        System.out.println("\n*****Figuras almacenadas*****");
        for (Shape shape : shapes) {
            shape.mostrarInformacion();
            System.out.println("--------------------");
        }
    }

    private static void storeShape(Scanner scanner, ArrayList<Shape> shapes) {
        int option = menuStoreShape(scanner);
        switch (option) {
            case 1:
                System.out.print("Ingrese el radio del circulo: ");
                double radio = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese el color del circulo: ");
                String colorC = scanner.nextLine();
                shapes.add(new Circle(radio, colorC));
                break;
            case 2:
                System.out.print("Ingrese la base del rectangulo: ");
                double base = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese la altura del rectangulo: ");
                double height = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese el color del rectangulo: ");
                String colorR = scanner.nextLine();
                shapes.add(new Rectangle(base, height, colorR));
                break;
            case 3:
                System.out.print("Ingrese el lado A del triangulo: ");
                double sideA = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese el lado B del triangulo: ");
                double sideB = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese el lado C del triangulo: ");
                double sideC = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese el color del triangulo: ");
                String colorT = scanner.nextLine();
                shapes.add(new Triangle(sideA, sideB, sideC, colorT));
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void deleteShape(Scanner scanner, ArrayList<Shape> shapes) {
        if (shapes.isEmpty()) {
            System.out.println("No hay figuras para eliminar.");
            return;
        }
        cleanConsole();
        System.out.print("Ingrese el índice de la figura a eliminar (0 a " + (shapes.size() - 1) + "): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (index >= 0 && index < shapes.size()) {
            shapes.remove(index);
            System.out.println("Figura eliminada.");
        } else {
            System.out.println("Índice no válido.");
        }
    }

    private static void loadShapes(ArrayList<Shape> shapes) {
        shapes.add(new Circle(4, "Rojo"));
        shapes.add(new Circle(2, "Rosado"));
        shapes.add(new Rectangle(2, 3, "Verde"));
        shapes.add(new Rectangle(4, 5, "Violeta"));
        shapes.add(new Triangle(2, 4, 5, "Azul"));
        shapes.add(new Triangle(3, 6, 6, "Amarillo"));
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<>();

        loadShapes(shapes);// cargar figuras

        boolean exit = false;

        while (!exit) {
            int option = menu(scanner);
            switch (option) {
                case 1:
                    showShapes(shapes);
                    break;
                case 2:
                    storeShape(scanner, shapes);
                    break;
                case 3:
                    deleteShape(scanner, shapes);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        scanner.close();
    }

}