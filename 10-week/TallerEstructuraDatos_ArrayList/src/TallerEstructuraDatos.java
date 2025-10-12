import java.util.Scanner;

/**
 * Clase principal que ejecuta la aplicación de consola TechMarket.
 * <p>
 * Permite gestionar productos y categorías usando un menú interactivo.
 *
 * @author Sergio Andres Losada Bahamon
 */
public class TallerEstructuraDatos {
    /**
     * Muestra el menú principal en consola.
     */
    public static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║        MENÚ DE TECHMARKET      ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║ 1. Agregar producto            ║");
        System.out.println("║ 2. Listar productos            ║");
        System.out.println("║ 3. Eliminar producto           ║");
        System.out.println("║ 4. Mostrar categorías          ║");
        System.out.println("║ 5. Cargar Productos Demo       ║");
        System.out.println("║ 0. Salir                       ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Agrega productos de demostración al catálogo.
     *
     * @param techMarket Instancia de TechMarket.
     */
    public static void addDemoProducts(TechMarket techMarket) {
        techMarket.addProduct("Laptop Lenovo IdeaPad 3", "Tecnología");
        techMarket.addProduct("Mouse Logitech M170", "Tecnología");
        techMarket.addProduct("Licuadora Oster 10 Velocidades", "Hogar");
        techMarket.addProduct("Detergente Ariel 4kg", "Aseo");
        techMarket.addProduct("Coca-Cola 1.5L", "Bebidas");
        techMarket.addProduct("Papas Margarita Limón 130g", "Snacks");

        System.out.println("✅ 6 productos de demostración agregados al catálogo.");
    }

    /**
     * Método principal. Ejecuta el menú y gestiona la interacción con el usuario.
     *
     * @param args Argumentos de línea de comandos (no se usan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TechMarket techMarket = new TechMarket();
        int opt;

        do {
            mostrarMenu();
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1 -> {// AGREGAR PRODUCTO
                    System.out.println("Ingrese nombre del producto:");
                    String name = scanner.nextLine();

                    if (name.isEmpty()) {
                        System.out.println("El campo no puede estar vacio");
                        break;
                    }

                    System.out.println("\nDe las siguientes categorias");
                    techMarket.showCategory();
                    System.out.println("\nIngrese la categoria del producto: ");
                    String category = scanner.nextLine();

                    if (category.isEmpty()) {
                        System.out.println("El campo no puede estar vacio");
                        break;
                    }

                    Product product = new Product(name, category);
                    techMarket.addProduct(product);
                }
                case 2 -> {
                    techMarket.listProducts();
                }
                case 3 -> {
                    if (techMarket.getProductCount() == 0) {
                        System.out.println("⚠️ No hay productos para eliminar.");
                        break;
                    }

                    techMarket.listProducts();
                    System.out.print("Ingrese el número del producto a eliminar: ");
                    int index = scanner.nextInt() - 1;
                    techMarket.removeProduct(index);
                }
                case 4 -> {
                    techMarket.showCategory();
                }
                case 5 -> {
                    addDemoProducts(techMarket);
                }
                case 0 -> System.out.println("Saliendo del Sistema...");
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opt != 0);
        scanner.close();
    }
}
