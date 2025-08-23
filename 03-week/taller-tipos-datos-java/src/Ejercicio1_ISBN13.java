public class Ejercicio1_ISBN13 {
    public static boolean isValidISBN13(String isbn) {
        if (isbn == null || isbn.length() != 13) // Verifica longitud
            return false;
        int suma = 0;
        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);
            if (!Character.isDigit(c)) // Verifica que todos sean dígitos
                return false;
            int d = c - '0';
            // Multiplica por 1 si la posición es par, por 3 si es impar
            suma += d * (i % 2 == 0 ? 1 : 3);
        }
        // El ISBN es válido si la suma es múltiplo de 10
        return suma % 10 == 0;
    }

    /**
     * Método principal para probar la validación de un ISBN-13.
     */
    public static void main(String[] args) {
        String prueba = "9780306406157";
        String prueba2 = "9780306406158";
        System.out.println("ISBN valido? " + isValidISBN13(prueba));
        System.out.println("ISBN valido? " + isValidISBN13(prueba2));
    }
}
