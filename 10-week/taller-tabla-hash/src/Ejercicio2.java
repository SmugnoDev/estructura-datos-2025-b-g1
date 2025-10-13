public class Ejercicio2 {
    private HashTable<String, Integer> contador;

    public Ejercicio2() {
        contador = new HashTable<>();
    }

    public void contarPalabras(String texto) {
        // Limpiar y dividir el texto en palabras
        String[] palabras = texto.toLowerCase()
                .replaceAll("[^a-záéíóúüñ\\s]", "")
                .split("\\s+");

        // Contar ocurrencias
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                Integer count = contador.get(palabra);
                if (count == null) {
                    contador.put(palabra, 1);
                } else {
                    contador.put(palabra, count + 1);
                }
            }
        }
    }

    public void mostrarConteo() {
        System.out.println("\n=== CONTEO DE PALABRAS ===");
        for (String palabra : contador.keys()) {
            System.out.println(palabra + ": " + contador.get(palabra));
        }
        System.out.println("Total de palabras únicas: " + contador.size());
    }

    public static void main(String[] args) {
        Ejercicio2 contador = new Ejercicio2();

        String texto = "hola mundo hola java mundo programacion java hola";
        System.out.println("Texto a analizar: " + texto);

        contador.contarPalabras(texto);
        contador.mostrarConteo();

        // Ejemplo con texto más complejo
        System.out.println("\n=== SEGUNDO EJEMPLO ===");
        Ejercicio2 contador2 = new Ejercicio2();
        String texto2 = "La casa es bonita. La casa tiene jardín. El jardín es grande.";
        System.out.println("Texto: " + texto2);

        contador2.contarPalabras(texto2);
        contador2.mostrarConteo();
    }
}