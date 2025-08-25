public class Ejercicio2_RLE {
    // Método que comprime una cadena usando RLE
    public static String comprimirRLE(String input) {
        // Si la entrada es nula o vacía, retorna cadena vacía
        if (input == null || input.isEmpty())
            return "";

        // Usar StringBuilder para eficiencia
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = input.charAt(0);

        // Recorre la cadena desde el segundo caracter
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i); // Caracter actual
            if (c == prev) { // Si es igual al anterior
                count++; // Incrementa el contador
            } else {
                sb.append(prev); // Agrega el caracter anterior
                sb.append(count); // Agrega el número de repeticiones
                prev = c; // Actualiza el caracter anterior
                count = 1; // Reinicia el contador
            }
        }
        sb.append(prev); // Agrega el último caracter
        sb.append(count); // Agrega su conteo
        return sb.toString(); // Retorna la cadena comprimida
    }

    // Imprime los datos de la compresión
    public static void printData(String original, String comprimido, double ratio) {
        System.out.println("Original: " + original); // Imprime la cadena original
        System.out.println("Comprimido: " + comprimido); // Imprime la cadena comprimida
        System.out.println("Ratio de compresión: " + ratio); // Imprime el ratio de compresión
    }

    // Método principal para probar la compresión RLE
    public static void main(String[] args) {
        String original = "aaabbBBBccccd"; // Cadena de prueba
        String comprimido = comprimirRLE(original); // Comprime la cadena
        // Calcula el ratio de compresión (tamaño comprimido / original)
        double ratio = original.isEmpty() ? 0 : (double) comprimido.length() / original.length();
        printData(original, comprimido, ratio); // Muestra los resultados
    }
}
