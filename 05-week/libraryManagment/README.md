# Sistema de Gestión de Bibliotecas

## Descripción
Sistema de gestión de biblioteca para Unidad 1 que utiliza diferentes estructuras de datos:
- **Arrays**: Catálogo + disponibilidad 2D
- **Lista simple**: Préstamos
- **Lista doble**: Historial

Interfaz de menú de consola con operaciones completas de alta/baja/búsqueda/préstamo/devolución y recorridos del historial.

## Estructuras de Datos y Complejidad

### Catálogo
- **Array `Libro[]`** ordenado por código
- **Alta**: Inserción ordenada O(n)
- **Búsqueda por código**: Búsqueda binaria O(log n)
- **Búsqueda por título**: Búsqueda lineal O(n)
- **Baja**: Lógica (flag activo) O(1)

### Disponibilidad
- **Matriz `int[][]`** [libros][sucursales]
- **Actualización**: O(S) donde S es el número de sucursales

### Préstamos
- **Lista simple**
- **Inserción**: Al final O(1)
- **Devolución**: Búsqueda O(n) + eliminación de nodo O(1)

### Historial
- **Lista doble**
- **Inserción**: Al final O(1)
- **Recorridos**: Hacia ambos sentidos

## Compilación y Ejecución (Java 17+)

```bash
$ mkdir -p out/src
$ javac -d out src/Main.java
$ java -cp out Main