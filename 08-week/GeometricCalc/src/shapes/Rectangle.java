/**
 * Clase que representa un rectángulo.
 * Hereda de Shape e implementa los métodos para calcular área y perímetro.
 *
 * @author smugno
 * @version 1.0
 */
package shapes;

public class Rectangle extends Shape {
    private double base, height, area, perimeter;
    private String color, shape;

    /**
     * Constructor de la clase Rectangle.
     * @param base Base del rectángulo
     * @param height Altura del rectángulo
     * @param color Color del rectángulo
     */
    public Rectangle(double base, double height, String color) {
        this.base = base;
        this.height = height;
        this.color = color;
        this.shape = "Rectangulo";
        this.area = calcularArea();
        this.perimeter = calcularPerimetro();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calcularArea() {
        return base * height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calcularPerimetro() {
        return 2 * (height + base);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Figura: " + this.shape
                + "\nColor: " + this.color
                + "\nBase: " + this.base
                + "\nAltura: " + this.height
                + "\nArea: " + this.area
                + "\nPerimetro: " + this.perimeter);
    }
}
