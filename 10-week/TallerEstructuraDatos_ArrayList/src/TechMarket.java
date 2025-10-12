import java.util.ArrayList;

/**
 * Clase que gestiona el catálogo de productos y categorías de TechMarket.
 * <p>
 * Permite agregar, eliminar, listar productos y mostrar categorías.
 *
 * @author Sergio Andres Losada Bahamon
 */
public class TechMarket {
    private ArrayList<Product> catalog;
    private String[] categories;

    /**
     * Constructor. Inicializa el catálogo y las categorías.
     */
    public TechMarket() {
        this.catalog = new ArrayList<>();
        this.categories = new String[]{"Tecnología", "Hogar", "Aseo", "Bebidas", "Snacks"};
    }

    /**
     * Agrega un producto al catálogo.
     *
     * @param product Producto a agregar.
     */
    public void addProduct(Product product) {
        catalog.add(product);
        System.out.println("✅ Producto agregado correctamente.");
    }

    /**
     * Agrega un producto al catálogo usando nombre y categoría.
     *
     * @param name     Nombre del producto.
     * @param category Categoría del producto.
     */
    public void addProduct(String name, String category) {
        Product product = new Product(name, category);
        catalog.add(product);
        System.out.println("✅ Producto agregado correctamente.");
    }

    /**
     * Elimina un producto del catálogo por índice.
     *
     * @param index Índice del producto a eliminar (base 0).
     */
    public void removeProduct(int index) {
        if (index < 0 || index >= catalog.size()) {
            System.out.println("⚠️ Índice no válido.");
            return;
        }

        Product removed = catalog.remove(index);
        System.out.println("❌ Producto eliminado: " + removed.getName());
    }

    /**
     * Lista todos los productos del catálogo.
     */
    public void listProducts() {
        if (catalog.isEmpty()) {
            System.out.println("⚠️ No hay productos en el catálogo.");
            return;
        }

        System.out.println("\n═══ LISTA DE PRODUCTOS ═══");
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println((i + 1) + ". " + catalog.get(i));
        }
    }

    /**
     * Muestra las categorías disponibles.
     */
    public void showCategory() {
        for (String category : categories) {
            System.out.print(category + " ");
        }
    }

    /**
     * Obtiene la cantidad de productos en el catálogo.
     *
     * @return Número de productos.
     */
    public int getProductCount() {
        return catalog.size();
    }
}
