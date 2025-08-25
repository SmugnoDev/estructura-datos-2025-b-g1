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