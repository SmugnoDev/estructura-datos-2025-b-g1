public class Ejercicio3 {

    // Clave personalizada que genera colisiones
    static class ClaveColision {
        private String valor;
        private int hashFijo;

        public ClaveColision(String valor, int hashFijo) {
            this.valor = valor;
            this.hashFijo = hashFijo;
        }

        @Override
        public int hashCode() {
            return hashFijo; // Siempre el mismo hash para forzar colisiones
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            ClaveColision that = (ClaveColision) obj;
            return valor.equals(that.valor);
        }

        @Override
        public String toString() {
            return valor + "(hash=" + hashFijo + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE COLISIONES ===");

        // Crear tabla hash pequeña para forzar colisiones
        HashTable<ClaveColision, String> tabla = new HashTable<>(4);

        // Crear claves que colisionarán (mismo hash)
        ClaveColision clave1 = new ClaveColision("clave1", 1);
        ClaveColision clave2 = new ClaveColision("clave2", 1); // Mismo hash
        ClaveColision clave3 = new ClaveColision("clave3", 2);
        ClaveColision clave4 = new ClaveColision("clave4", 1); // Mismo hash

        System.out.println("Insertando claves con colisiones...");
        tabla.put(clave1, "valor1");
        tabla.put(clave2, "valor2");
        tabla.put(clave3, "valor3");
        tabla.put(clave4, "valor4");

        System.out.println("\nEstado de la tabla hash:");
        tabla.display();

        System.out.println("\nBuscando claves:");
        System.out.println("clave1: " + tabla.get(clave1));
        System.out.println("clave2: " + tabla.get(clave2));
        System.out.println("clave4: " + tabla.get(clave4));

        System.out.println("\nEliminando clave2...");
        tabla.remove(clave2);

        System.out.println("\nEstado después de eliminar:");
        tabla.display();
    }
}