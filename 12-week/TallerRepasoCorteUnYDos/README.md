# 🎯 Taller de Estructuras de Datos - Java 21

## 📋 Descripción del Proyecto
Este proyecto contiene la implementación de 7 estructuras de datos fundamentales en Java 21, cada una con ejercicios prácticos y análisis de complejidad algorítmica.

## 🏗️ Estructuras Implementadas

### 1. 📚 Stack (Pila) - Editor de Texto
**Ejercicio**: Implementa una pila que simule el comportamiento de un editor de texto con funciones Deshacer y Rehacer.

**Características**:
- Dos pilas para operaciones Deshacer/Rehacer
- Operaciones O(1) para todas las funciones
- Patrón Command para versión avanzada

**Archivos**:
- `EditorDeTexto.java` - Implementación básica
- `EditorDeTextoAvanzado.java` - Con patrón Command
- `DemoEditorTexto.java` - Demostración

### 2. 🎟️ Queue (Cola) - Sistema de Atención
**Ejercicio**: Diseña un sistema de atención que asigne prioridades usando PriorityQueue.

**Características**:
- PriorityQueue con prioridades ALTA, MEDIA, BAJA
- Ordenamiento automático por prioridad
- Sistema de departamentos especializados

**Archivos**:
- `Ticket.java` - Clase Ticket con prioridades
- `SistemaAtencion.java` - Implementación básica
- `SistemaAtencionAvanzado.java` - Múltiples colas
- `DemoSistemaAtencion.java` - Demostración

### 3. 🔐 HashMap - Gestión de Usuarios
**Ejercicio**: Crea una HashMap que almacene usuarios únicos por su número de identificación.

**Características**:
- Clave única por ID de usuario
- Operaciones O(1) promedio
- Prevención de duplicados

**Archivos**:
- `GestionUsuarios.java` - Implementación completa
- `DemoUsuarios.java` - Demostración
- `UsuariosSimple.java` - Versión simplificada

### 4. 🌳 Binary Tree - Recorridos
**Ejercicio**: Implementa un árbol binario con recorridos en orden, preorden y postorden.

**Características**:
- Tres tipos de recorrido: in-order, pre-order, post-order
- Inserción y búsqueda recursiva
- Visualización de la estructura

**Archivos**:
- `ArbolBinario.java` - Implementación completa
- `DemoArbolBinario.java` - Demostración
- `ArbolSimple.java` - Versión simplificada

### 5. ⚖️ AVL Tree - Rotaciones
**Ejercicio**: Simula inserciones en un árbol AVL e identifica el tipo de rotación realizada.

**Características**:
- Cuatro tipos de rotaciones
- Balance automático del árbol
- Factor de equilibrio

**Archivos**:
- `ArbolAVL.java` - Implementación completa
- `DemoAVL.java` - Demostración con casos
- `AVLSimple.java` - Versión simplificada

### 6. 🔍 BST - Operaciones Completas
**Ejercicio**: Construye un BST e implementa búsqueda, inserción y eliminación.

**Características**:
- Tres casos de eliminación: hoja, un hijo, dos hijos
- Recorridos in-order y pre-order
- Visualización de la estructura

**Archivos**:
- `ArbolBST.java` - Implementación completa
- `DemoBST.java` - Demostración exhaustiva
- `BSTSimple.java` - Versión simplificada

### 7. 🗺️ Graph - Mapa de Ciudades
**Ejercicio**: Modela un grafo que represente un mapa de ciudades y encuentra la ruta más corta.

**Características**:
- Algoritmo Dijkstra
- Reconstrucción de rutas

**Archivos**:
- `MapaCiudades.java` - Con algoritmo de Dijkstra
- `MapaBFS.java` - Con algoritmo BFS
- `DemoMapaCiudades.java` - Demostración

## 📊 Análisis de Complejidad

### Resumen de Complejidades

| Estructura | Operación | Mejor Caso | Caso Promedio | Peor Caso |
|------------|-----------|------------|---------------|-----------|
| **Stack** | push/pop | O(1) | O(1) | O(1) |
| **Queue** | offer/poll | O(log n) | O(log n) | O(log n) |
| **HashMap** | put/get | O(1) | O(1) | O(n) |
| **Binary Tree** | recorrido | O(n) | O(n) | O(n) |
| **AVL Tree** | inserción | O(log n) | O(log n) | O(log n) |
| **BST** | búsqueda | O(1) | O(log n) | O(n) |
| **Graph** | BFS | O(V+E) | O(V+E) | O(V+E) |
| **Graph** | Dijkstra | O((V+E)log V) | O((V+E)log V) | O((V+E)log V) |

### Análisis Detallado

#### 🔍 Búsqueda en BST
- **Complejidad**: O(h) donde h = altura del árbol
- **Balanceado**: O(log n)
- **Degenerado**: O(n)

#### 📥 Inserción en HashMap
- **Complejidad**: O(1) tiempo promedio
- **Colisiones**: Puede degenerar a O(n)
- **Rehashing**: O(n) ocasional

#### 🗺️ Recorrido de Grafo (BFS)
- **Complejidad**: O(V + E)
- **V**: vértices, E: aristas
- **Óptimo** para grafos no ponderados

## 🚀 Cómo Ejecutar

### Requisitos
- Java 21 o superior
- Terminal o IDE compatible

### Compilación y Ejecución

```bash
# Compilar todos los archivos
javac *.java

# Ejecutar demostraciones individuales
java DemoEditorTexto
java DemoSistemaAtencion
java DemoUsuarios
java DemoArbolBinario
java DemoAVL
java DemoBST
java DemoMapaCiudades