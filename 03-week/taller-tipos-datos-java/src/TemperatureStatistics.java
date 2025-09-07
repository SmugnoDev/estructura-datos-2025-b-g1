import java.util.Arrays;

/**
 * Clase para calcular estadísticas de temperaturas a partir de un String
 * con valores separados por comas.
 */
public class TemperatureStatistics {
    /**
     * Clase que representa las estadísticas calculadas de un conjunto de temperaturas
     */
    public static class TemperatureStats {
        private final double[] temperatures;
        private final double min;
        private final double max;
        private final double sum;
        private final double average;
        private final double standardDeviation;

        /**
         * Constructor que procesa el string de temperaturas y calcula todas las estadísticas
         * @param temperatureString String con temperaturas separadas por comas
         */
        public TemperatureStats(String temperatureString) {
            this.temperatures = parseTemperatures(temperatureString);
            this.min = calculateMin();
            this.max = calculateMax();
            this.sum = calculateSum();
            this.average = calculateAverage();
            this.standardDeviation = calculateStandardDeviation();
        }

        /**
         * Convierte el string de temperaturas a un array de doubles
         * @param temperatureString String con temperaturas separadas por comas
         * @return Array de valores double con las temperaturas
         */
        private double[] parseTemperatures(String temperatureString) {
            String normalizedString = temperatureString.trim().replaceAll("\\s+", "");
            String[] stringArray = normalizedString.split(",");
            
            return Arrays.stream(stringArray)
                        .mapToDouble(Double::parseDouble)
                        .toArray();
        }

        /**
         * Calcula la temperatura mínima
         * @return Valor mínimo del conjunto
         */
        private double calculateMin() {
            return Arrays.stream(temperatures).min().orElse(Double.MAX_VALUE);
        }

        /**
         * Calcula la temperatura máxima
         * @return Valor máximo del conjunto
         */
        private double calculateMax() {
            return Arrays.stream(temperatures).max().orElse(Double.MIN_VALUE);
        }

        /**
         * Calcula la suma de todas las temperaturas
         * @return Suma total de los valores
         */
        private double calculateSum() {
            return Arrays.stream(temperatures).sum();
        }

        /**
         * Calcula el promedio de las temperaturas
         * @return Valor promedio
         */
        private double calculateAverage() {
            return sum / temperatures.length;
        }

        /**
         * Calcula la desviación estándar de las temperaturas
         * @return Desviación estándar
         */
        private double calculateStandardDeviation() {
            double sumSquaredDifferences = Arrays.stream(temperatures)
                                                .map(temp -> Math.pow(temp - average, 2))
                                                .sum();
            
            return Math.sqrt(sumSquaredDifferences / temperatures.length);
        }

        /**
         * Imprime todas las estadísticas calculadas
         */
        public void printStatistics() {
            System.out.println("Estadísticas de Temperaturas:");
            System.out.printf("Mínimo: %.2f°C%n", min);
            System.out.printf("Máximo: %.2f°C%n", max);
            System.out.printf("Suma: %.2f°C%n", sum);
            System.out.printf("Promedio: %.2f°C%n", average);
            System.out.printf("Desviación Estándar: %.2f°C%n", standardDeviation);
        }
    }

    public static void main(String[] args) {
        String temperatureData = "23.4, 21.8, 22.1, 24.0, 20.5";
        TemperatureStats stats = new TemperatureStats(temperatureData);
        
        stats.printStatistics();
    }
}