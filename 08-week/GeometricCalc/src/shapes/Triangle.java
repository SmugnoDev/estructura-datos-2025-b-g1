/**
 * Clase que representa un triángulo.
 * Hereda de Shape e implementa los métodos para calcular área y perímetro.
 *
 * @author smugno
 * @version 1.0
 */
package shapes;

public class Triangle extends Shape {
    private double sideA, sideB, sideC, area, perimeter;
    private String color, shape;

    /**
     * Constructor de la clase Triangle.
     * 
     * @param sideA Lado A del triángulo
     * @param sideB Lado B del triángulo
     * @param sideC Lado C del triángulo
     * @param color Color del triángulo
     */
    public Triangle(double sideA, double sideB, double sideC, String color) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.color = color;
        this.shape = "Triangulo";
        this.area = calcularArea();
        this.perimeter = calcularPerimetro();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calcularArea() {
        double s = calcularSemiperimetro();
        double aux = s * (s - sideA) * (s - sideB) * (s - sideC);
        return Math.sqrt(aux);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calcularPerimetro() {
        return sideA + sideB + sideC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Figura: " + this.shape
                + "\nColor: " + this.color
                + "\nLado A: " + this.sideA
                + "\nLado B: " + this.sideB
                + "\nLado C: " + this.sideC
                + "\nArea: " + this.area
                + "\nPerimetro: " + this.perimeter);
    }

    /**
     * Calcula el semiperímetro del triángulo.
     * 
     * @return semiperímetro
     */
    private double calcularSemiperimetro() {
        return (calcularPerimetro()) / 2;
    }
}
