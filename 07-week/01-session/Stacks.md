# Stacks (Pilas)
### Que es un Stack o Pila?
Un **Stack** es una coleccion de datos ordenados de acceso restrictivo en donde el ultimo elemento en ser agregado siempre es el primer elemento en ser consultado o eliminado, esto quiere decir que es una estructura de tipo **LIFO** (*Last in first out*).

Podemos pensar en una pila de platos para lavar, donde no podemos ver otro plato que no sea el que esta de primero o en lo alto de la pila, asi mismo, no podemos agregar o quitar un plato que no sea el que este en lo alto de la pila, por lo general nos referimos al primer elemento en un **Stack** como el *top* o el que esta mas arriba, sin embargo bajo la perspectiva de un **Array** es igual a referirse al ultimo elemento del Array.

### Operaciones Principales en un Stack.
Una de las caracteristicas de los stacks es que solo permite la insercion y la eliminacion en un extremo, extremo que por lo general es llamado ***cima o top***.

| Operacion | Descripcion |
|:--------- |:----------- |
| push ()   | Incerta un elemento en la cima |
| pop ()    | Elimina y retorna el elemento de la cima |
| peek ()   | Consulta el elemento en la cima sin eliminarlo |
| isEmpty ()| Verifica si la pila esta vacia |

---
## Implementacion de Stack con Arrays
