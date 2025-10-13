public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE TAMAÑO Y RENDIMIENTO ===");

        HashTable<Integer, String> tabla = new HashTable<>();

        // Insertar múltiples elementos
        int elementos = 100;
        System.out.println("Insertando " + elementos + " elementos...");

        long inicio = System.currentTimeMillis();

        for (int i = 0; i < elementos; i++) {
            tabla.put(i, "Valor" + i);
        }

        long fin = System.currentTimeMillis();

        System.out.println("Tiempo de inserción: " + (fin - inicio) + " ms");
        System.out.println("Tamaño final: " + tabla.size());
        System.out.println("¿Está vacía?: " + tabla.isEmpty());

        // Buscar elementos
        System.out.println("\nBuscando elementos...");
        inicio = System.currentTimeMillis();

        for (int i = 0; i < elementos; i++) {
            if (!tabla.containsKey(i)) {
                System.out.println("Error: clave " + i + " no encontrada");
            }
        }

        fin = System.currentTimeMillis();
        System.out.println("Tiempo de búsqueda: " + (fin - inicio) + " ms");

        // Eliminar elementos
        System.out.println("\nEliminando elementos...");
        inicio = System.currentTimeMillis();

        for (int i = 0; i < elementos; i += 2) {
            tabla.remove(i);
        }

        fin = System.currentTimeMillis();
        System.out.println("Tiempo de eliminación: " + (fin - inicio) + " ms");
        System.out.println("Tamaño después de eliminar: " + tabla.size());

        // Mostrar distribución
        System.out.println("\nDistribución en buckets:");
        tabla.display();
    }
}