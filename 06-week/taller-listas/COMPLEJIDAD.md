# 📊 Análisis de Complejidad

Este documento analiza la complejidad de las operaciones implementadas en los ejercicios del taller.

---

## 🔹 Lista Simple

- **Insertar inicio** → O(1)
- **Insertar fin** → O(n) (se recorre toda la lista)
- **Insertar en posición** → O(n) (recorrido hasta la posición)
- **Eliminar inicio** → O(1)
- **Eliminar fin** → O(n) (recorrido hasta el último nodo)
- **Eliminar en posición** → O(n)

---

## 🔹 Lista Doblemente Enlazada

- **Insertar inicio** → O(1)
- **Insertar fin** → O(1) (se guarda puntero a cola)
- **Insertar en posición** → O(n)
- **Eliminar inicio** → O(1)
- **Eliminar fin** → O(1) (se guarda puntero a cola)
- **Eliminar en posición** → O(n)

---

## 🔹 Lista Circular

- **Insertar inicio** → O(1)
- **Insertar fin** → O(n) (si no se guarda puntero a cola)
- **Insertar en posición** → O(n)
- **Eliminar inicio** → O(1)
- **Eliminar fin** → O(n)
- **Eliminar en posición** → O(n)

---

## 🔹 Caso práctico (Lista de espera — cola FIFO)

Se implementó con una lista simple optimizada con puntero a la cola:

- **Agregar paciente (enqueue)** → O(1)
- **Atender paciente (dequeue)** → O(1)

---

## 📑 Resumen Global

| Operación         | Lista Simple | Lista Doble | Lista Circular | Caso práctico |
|-------------------|--------------|-------------|----------------|---------------|
| Insertar inicio   | O(1)         | O(1)        | O(1)           | -             |
| Insertar fin      | O(n)         | O(1)        | O(n)           | O(1)          |
| Insertar posición | O(n)         | O(n)        | O(n)           | -             |
| Eliminar inicio   | O(1)         | O(1)        | O(1)           | O(1)          |
| Eliminar fin      | O(n)         | O(1)        | O(n)           | -             |
| Eliminar posición | O(n)         | O(n)        | O(n)           | -             |

---

## ✅ Conclusiones

- Las **listas simples** son fáciles de implementar, pero tienen costo O(n) al insertar o eliminar en posiciones
  internas.
- La **lista doble** optimiza la eliminación en ambos extremos a O(1).
- La **lista circular** es útil para recorridos continuos, aunque no optimiza inserciones en medio.
- El **caso práctico** con cola muestra cómo aplicar listas en escenarios reales con eficiencia O(1).  
