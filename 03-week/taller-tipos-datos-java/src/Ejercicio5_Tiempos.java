/*
 * Ejercicio 5: Agregacion de tiempos de ejecucion
 * 
 * Enunciado:
 * Dada un lista de tiempos en formato HH:MM:SS, calcula:
 * 1. Tiempo total
 * 2. promedio
 * 3. El tramo mas largo
 * 4. Porcentaje de cada tramo respecto al total (redondeado a 2 decimales)
 * 
 * Paso a paso:
 * 1. Parsea cada String a segundos: h*3600 + m*60 + s.
 * 2. Suma total (long si la lista es grande).
 * 3. Promedio = total / n. (usa double para porcentajes)
 * 4. Manten max y su indice.
 * 5. Convierte segundos de vuelta a HH:MM:SS con división y módulo.
 * 6. Calcula porcentajes (segmento / total) * 100, controla total 0.
 * 
 * Tipos sugeridos: String, int[]/long[], long, double.
 */

public class Ejercicio5_Tiempos {
    // Formatea segundos a HH:MM:SS
    public static String formatearTiempo(long totalSegundos) {
        long horas = totalSegundos / 3600;
        long minutos = (totalSegundos % 3600) / 60;
        long segundos = totalSegundos % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public static void main(String[] args) {
        String[] tiempos = { "01:20:15", "00:45:30", "02:10:05", "00:00:00" };
        long[] tiemposSegundos = new long[tiempos.length];
        double[] porcentajes = new double[tiempos.length];
        long totalSegundos = 0;
        long maxSegundos = 0;
        int indiceMax = -1;

        // Parsear y calcular total y maximo
        for (int i = 0; i < tiempos.length; i++) {
            // Separar y parsear horas, minutos y segundos
            String[] partesTiempo = tiempos[i].split(":");
            int horas = Integer.parseInt(partesTiempo[0]);
            int minutos = Integer.parseInt(partesTiempo[1]);
            int segundos = Integer.parseInt(partesTiempo[2]);

            // Convertir a segundos
            long totalSegs = horas * 3600 + minutos * 60 + segundos;

            // Almacenar y actualizar totales
            tiemposSegundos[i] = totalSegs;
            totalSegundos += totalSegs;
            if (totalSegs > maxSegundos) {
                maxSegundos = totalSegs;
                indiceMax = i;
            }
        }

        // Calcular promedio
        double promedioSegundos = tiempos.length > 0 ? (double) totalSegundos / tiempos.length : 0;

        // Calcular porcentajes
        for (int i = 0; i < tiempos.length; i++) {
            porcentajes[i] = totalSegundos > 0 ? ((double) tiemposSegundos[i] / totalSegundos) * 100 : 0;
        }

        // Imprimir resultados
        System.out.println("Tiempo Total: " + formatearTiempo(totalSegundos));
        System.out.println("Promedio: " + formatearTiempo((long) promedioSegundos));
        System.out.println("Tramo más largo: " + tiempos[indiceMax] + " en índice " + indiceMax);
        System.out.println("Porcentajes:");
        for (int i = 0; i < tiempos.length; i++) {
            System.out.printf("Tramo %d (%s): %.2f%%\n", i, tiempos[i], porcentajes[i]);
        }
    }
}