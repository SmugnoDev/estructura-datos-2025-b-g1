/**
 * Representa un producto con nombre y categoría.
 *
 * @author Sergio Andres Losada Bahamon
 */
public class Product {
    private String name;
    private String category;

    /**
     * Crea un nuevo producto.
     *
     * @param name     Nombre del producto.
     * @param category Categoría del producto.
     */
    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve una representación en cadena del producto.
     *
     * @return Cadena con los datos del producto.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + name + '\'' +
                ", categoría='" + category + '\'' +
                '}';
    }
}