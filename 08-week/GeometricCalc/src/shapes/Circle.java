/**
 * Clase que representa un círculo.
 * Hereda de Shape e implementa los métodos para calcular área y perímetro.
 *
 * @author smugno
 * @version 1.0
 */
package shapes;

public class Circle extends Shape {

    private String color, shape;
    private double radio, pi, area, perimeter;

    /**
     * Constructor de la clase Circle.
     * @param radio Radio del círculo
     * @param color Color del círculo
     */
    public Circle(double radio, String color) {
        this.radio = radio;
        this.color = color;
        this.shape = "Circulo";
        this.pi = Math.PI;
        this.area = calcularArea();
        this.perimeter = calcularPerimetro();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calcularArea() {
        return this.pi * (this.radio * this.radio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calcularPerimetro() {
        return 2 * pi * radio;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Figura: " + this.shape
                + "\nColor: " + this.color
                + "\nRadio: " + this.radio
                + "\nArea: " + this.area
                + "\nPerimetro: " + this.perimeter);
    }
}
