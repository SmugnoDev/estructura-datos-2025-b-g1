/**
 * Clase abstracta que representa una figura geométrica.
 * Define los métodos que deben implementar las figuras concretas.
 *
 * @author smugno
 * @version 1.0
 */
package shapes;

public abstract class Shape {
    /**
     * Calcula el área de la figura.
     * @return área de la figura
     */
    public abstract double calcularArea();

    /**
     * Calcula el perímetro de la figura.
     * @return perímetro de la figura
     */
    public abstract double calcularPerimetro();

    /**
     * Muestra la información de la figura por consola.
     */
    public abstract void mostrarInformacion();
}
