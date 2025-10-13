# Taller - Implementación Básica de Tabla Hash

## Análisis y Resultados

### Implementación
Se implementó una tabla hash genérica con resolución de colisiones mediante encadenamiento. Las características principales son:

- **Función hash**: `Math.abs(key.hashCode()) % capacity`
- **Factor de carga**: 0.75
- **Redimensionamiento automático** cuando se supera el factor de carga
- **Encadenamiento** para manejar colisiones

### Resultados de los Ejercicios

#### Ejercicio 1 - Diccionario Simple
- Funcionalidad completa para gestionar usuarios y roles
- Operaciones eficientes de inserción, consulta y eliminación
- Interfaz de usuario intuitiva por consola

#### Ejercicio 2 - Contador de Palabras
- Conteo preciso de ocurrencias de palabras
- Manejo de caracteres especiales y normalización a minúsculas
- Eficiente incluso con textos largos

#### Ejercicio 3 - Colisiones Controladas
- Demostración exitosa del manejo de colisiones
- Las claves con mismo hash se almacenan en la misma lista enlazada
- Operaciones mantienen su funcionalidad a pesar de las colisiones

#### Ejercicio 4 - Prueba de Tamaño
- Inserción de 100 elementos en menos de 10ms
- Búsqueda eficiente de todos los elementos
- Eliminación parcial sin afectar rendimiento

### Observaciones
- La tabla hash muestra comportamiento O(1) en promedio para operaciones básicas
- El redimensionamiento mejora el rendimiento al distribuir mejor los elementos
- El encadenamiento maneja eficientemente las colisiones sin degradar el rendimiento