# Análisis de Complejidad - Tabla Hash

## Complejidad Temporal

| Operación    | Caso Promedio | Peor Caso | Justificación |
|--------------|---------------|-----------|---------------|
| `put()`      | O(1)          | O(n)      | En promedio, inserción directa. En peor caso, todas las claves colisionan |
| `get()`      | O(1)          | O(n)      | Búsqueda directa en bucket. En peor caso, lista enlazada muy larga |
| `remove()`   | O(1)          | O(n)      | Similar a get(), requiere recorrer lista en caso de colisiones |
| `containsKey()` | O(1)       | O(n)      | Utiliza get() internamente |
| `size()`     | O(1)          | O(1)      | Contador mantenido durante operaciones |
| `isEmpty()`  | O(1)          | O(1)      | Verificación simple del contador |

## Complejidad Espacial

- **Complejidad**: O(n + m)
  - `n`: número de elementos almacenados
  - `m`: tamaño del array de buckets

## Factores que Afectan el Rendimiento

1. **Función hash**: Debe distribuir uniformemente las claves
2. **Factor de carga**: Alto factor de carga aumenta probabilidad de colisiones
3. **Tamaño inicial**: Tamaño muy pequeño causa redimensionamientos frecuentes
4. **Calidad de hashCode()**: Implementaciones pobres generan muchas colisiones

## Optimizaciones Implementadas

1. **Redimensionamiento dinámico**: Duplica capacidad cuando loadFactor > 0.75
2. **Encadenamiento eficiente**: Inserción al inicio de la lista (O(1))
3. **Contador de tamaño**: Evita recalcular tamaño constantemente