/*
 * A partir de un String de temperaturas separadas por comas,
 * (por ejemplo: "23.4,21.8,22.1,24.0,20.5"), calcula minimo,
 * maximo, promedio y desviacion estandar.
 */
public class Ejercicio3_Temperaturas {

    public static class Estadisticas {
        private double[] tempArrDouble;
        private double suma;
        private double minimo;
        private double maximo;
        private double promedio;
        private double desviacionEstandar;

        public Estadisticas(String temperaturas) {
            // Convertir el String de temperaturas a un array de doubles
            String[] tempArrString = temperaturas.trim().replaceAll(" ", "").split(",");

            // Inicializar el array de doubles
            tempArrDouble = new double[tempArrString.length];
            for (int i = 0; i < tempArrString.length; i++) {
                this.tempArrDouble[i] = Double.parseDouble(tempArrString[i]);
            }

            // Calcular el minimo, maximo y suma de las temperaturas
            this.minimo = Double.MAX_VALUE;
            this.maximo = Double.MIN_VALUE;
            for (double temp : tempArrDouble) {
                if (temp < this.minimo) {
                    this.minimo = temp;
                }
                if (temp > this.maximo) {
                    this.maximo = temp;
                }
                this.suma += temp;
            }

            // Calcular el promedio
            this.promedio = this.suma / tempArrDouble.length;

            // calcular la desviacion estandar
            double sumaDiferenciasCuadradas = 0.0;
            for (double temp : tempArrDouble) {
                sumaDiferenciasCuadradas += Math.pow(temp - this.promedio, 2);
            }
            this.desviacionEstandar = Math.sqrt(sumaDiferenciasCuadradas / tempArrDouble.length);

        }

        public void printData() {
            System.out.println("Minimo: " + this.minimo);
            System.out.println("Maximo: " + this.maximo);
            System.out.println("Suma: " + this.suma);
            System.out.println("Promedio: " + this.promedio);
            System.out.println("Desviacion Estandar: " + this.desviacionEstandar);
        }
    }

    public static void main(String[] args) {
        String temperaturas = "  23.4, 21.8,22 .1, 24.0,20.5 ";
        Estadisticas estadisticas = new Estadisticas(temperaturas);
        estadisticas.printData();
    }
}