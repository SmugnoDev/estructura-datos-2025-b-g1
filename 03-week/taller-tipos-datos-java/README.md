
# Documentación de Ejercicios Java

Este repositorio contiene cinco programas en Java que resuelven diferentes problemas.  
Cada ejercicio incluye la descripción, métodos principales y ejemplos de uso.

## Objetivo

El objetivo de este taller es comprender y aplicar los diferentes tipos de datos en Java, así como practicar la declaración de variables, la conversión de tipos y la manipulación de datos básicos. Los ejercicios fortalecen la lógica y el uso correcto de los tipos primitivos y de referencia en Java.

## Ejercicio 1: Validación de ISBN-13
**Archivo:** `Ejercicio1_ISBN13.java`  

Valida si un número ISBN-13 es correcto usando la fórmula de validación estándar.

**Método principal:**
```java
public static boolean isValidISBN13(String isbn)
```
- Verifica longitud y dígitos.
- Calcula la suma ponderada y valida si es múltiplo de 10.

**Ejemplo de uso:**
```java
System.out.println(isValidISBN13("9780306406157")); // true
System.out.println(isValidISBN13("9780306406158")); // false
```

---

## Ejercicio 2: Compresión Run-Length Encoding (RLE)
**Archivo:** `Ejercicio2_RLE.java`  

Comprime una cadena reemplazando secuencias de caracteres repetidos con el carácter y su número de repeticiones.

**Método principal:**
```java
public static String comprimirRLE(String input)
```
- Devuelve la cadena comprimida.
- Calcula ratio de compresión.

**Ejemplo:**
```java
String comprimido = comprimirRLE("aaabbBBBccccd");
// Salida: a3b2B3c4d1
```

---

## Ejercicio 3: Estadísticas de Temperaturas
**Archivo:** `Ejercicio3_Temperaturas.java`  

Dado un listado de temperaturas, calcula mínimo, máximo, promedio y desviación estándar.

**Clase principal:**
```java
public static class Estadisticas
```
- Convierte el string a un array de `double`.
- Calcula métricas estadísticas.

**Ejemplo:**
```java
Estadisticas est = new Estadisticas("23.4, 21.8, 22.1, 24.0, 20.5");
est.printData();
// Salida: 
// Original: 23.4, 21.8, 22.1, 24.0, 20.5
// Normalizado: 23.4,21.8,22.1,24.0,20.5
// Minimo: 20.5
// Maximo: 24.0
// Suma: 111.80000000000001
// Promedio: 22.360000000000003
// Desviacion Estandar: 1.233855745214974
```

---

## Ejercicio 4: Conversor de Bases y Control de Overflow
**Archivo:** `Ejercicio4_ConversorBases.java`  

Convierte un número dado en base 2, 10 o 16 a las otras dos bases, controlando posibles desbordamientos con `BigInteger`.

**Métodos principales:**
```java
public static boolean esCadenaValida(String numStr, int base)
```
- Valida caracteres de la base.
- Convierte a binario, decimal y hexadecimal.

**Ejemplo:**
```java
String num = "12345678901234567890"; 
// Salida en binario, decimal y hexadecimal con BigInteger si es necesario
```

---

## Ejercicio 5: Agregación de Tiempos
**Archivo:** `Ejercicio5_Tiempos.java`  

Calcula tiempo total, promedio, tramo más largo y porcentaje de cada tramo a partir de una lista de tiempos HH:MM:SS.

**Método principal:**
```java
public static String formatearTiempo(long totalSegundos)
```
- Convierte segundos a formato HH:MM:SS.
- Calcula estadísticas de tiempos.

**Ejemplo:**
```java
// Para ["01:20:15","00:45:30","02:10:05","00:00:00"]
// Total, promedio, tramo más largo y porcentajes
```

---

## Notas Generales
- Todos los programas incluyen método `main` con ejemplos de prueba.
- Se usa manejo básico de errores y estructuras de control en Java.