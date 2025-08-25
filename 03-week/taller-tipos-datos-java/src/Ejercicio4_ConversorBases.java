/*
 * 4. Conversor de bases y control de overflow
 * 
 * Enunciado:
 * Recibe un numero como String y una base de origen (2, 10 o 16).
 * Convierte a las otras dos bases, si el valor excede el rango
 * de long, usa BigInteger.
 * 
 * Paso a paso:
 * 1. Normalizar el String (e.g., hex en mayusculas).
 * 2. Valida que los caracteres sean validos para la base indicada.
 * 3. Intenta parcear a long, con Long.parseLong en base 10 si cabe,
 * si falla o se desborda usa BigInteger(String, base).
 * 4. Convierte a binario y hex con toString(base).
 * 5. Reporta si hubo uso de BigIntege (bandera boolean).
 * 
 * Tipos sugeridos: String, char, Long, BigInteger, boolean.
 */

import java.math.BigInteger;

public class Ejercicio4_ConversorBases {

    // Verifica si un caracter es válido para la base dada
    public static boolean esCaracterValido(char c, int base) {
        if (base == 2)
            return c == '0' || c == '1';
        if (base == 10)
            return Character.isDigit(c);
        if (base == 16)
            return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F');
        return false; // Base no soportada

    }

    // Verifica si toda la cadena es válida para la base dada
    public static boolean esCadenaValida(String numStr, int base) {
        for (char c : numStr.toCharArray()) {
            if (!esCaracterValido(c, base)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // Datos de entrada
        String numStr = "12345678901234567890";
        int baseOrigen = 10; // Cambia a 2 o 16 para probar otras bases

        // Normalizar el numero a mayúsculas
        numStr = numStr.toUpperCase();

        // Validar la cadena y su base
        if (!esCadenaValida(numStr, baseOrigen)) {
            System.out.println("Error: Caracteres inválidos para la base " + baseOrigen);
            return;
        }
        // Variables para los resultados
        String binario = "";
        String decimal = "";
        String hexadecimal = "";
        boolean usoBigInteger = false;

        // try-catch para manejar overflow con long
        try {
            // Intentar parsear a long
            long numLong = Long.parseLong(numStr, baseOrigen);
            binario = Long.toBinaryString(numLong);
            decimal = Long.toString(numLong);
            hexadecimal = Long.toHexString(numLong);
        } catch (Exception e) {
            // Si falla, usar BigInteger
            usoBigInteger = true;
            BigInteger numBigInteger = new BigInteger(numStr, baseOrigen);
            binario = numBigInteger.toString(2);
            decimal = numBigInteger.toString(10);
            hexadecimal = numBigInteger.toString(16).toUpperCase();
        }

        System.out.println("Numero inicial: " + numStr + " en base " + baseOrigen);
        System.out.println("Binario: " + binario);
        System.out.println("Decimal: " + decimal);
        System.out.println("Hexadecimal: " + hexadecimal);
        System.out.println("Uso de BigInterger: " + usoBigInteger);
    }
}