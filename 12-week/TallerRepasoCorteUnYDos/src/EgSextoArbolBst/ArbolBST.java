package EgSextoArbolBst;

class NodoBST {
    int valor;
    NodoBST izquierdo;
    NodoBST derecho;

    public NodoBST(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class ArbolBST {
    private NodoBST raiz;

    public ArbolBST() {
        this.raiz = null;
    }

    // INSERTAR
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
        System.out.println("Insertado: " + valor);
    }

    private NodoBST insertarRecursivo(NodoBST nodo, int valor) {
        if (nodo == null) {
            return new NodoBST(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        // Si el valor es igual, no hacemos nada (sin duplicados)

        return nodo;
    }

    // BUSCAR
    public boolean buscar(int valor) {
        boolean encontrado = buscarRecursivo(raiz, valor);
        System.out.println("Búsqueda " + valor + ": " + (encontrado ? "ENCONTRADO" : "NO ENCONTRADO"));
        return encontrado;
    }

    private boolean buscarRecursivo(NodoBST nodo, int valor) {
        if (nodo == null) {
            return false;
        }

        if (valor == nodo.valor) {
            return true;
        }

        return valor < nodo.valor
                ? buscarRecursivo(nodo.izquierdo, valor)
                : buscarRecursivo(nodo.derecho, valor);
    }

    // ELIMINAR
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
        System.out.println("Eliminado: " + valor);
    }

    private NodoBST eliminarRecursivo(NodoBST nodo, int valor) {
        if (nodo == null) {
            System.out.println("No se puede eliminar. Valor no encontrado: " + valor);
            return null;
        }

        // Buscar el nodo a eliminar
        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, valor);
        } else {
            // Nodo encontrado - proceder a eliminar

            // Caso 1: Nodo hoja o con un solo hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Caso 2: Nodo con dos hijos
            // Encontrar el sucesor in-order (mínimo en subárbol derecho)
            nodo.valor = encontrarMinimo(nodo.derecho);

            // Eliminar el sucesor
            nodo.derecho = eliminarRecursivo(nodo.derecho, nodo.valor);
        }

        return nodo;
    }

    // Encontrar el valor mínimo en un subárbol
    private int encontrarMinimo(NodoBST nodo) {
        int minimo = nodo.valor;
        while (nodo.izquierdo != null) {
            minimo = nodo.izquierdo.valor;
            nodo = nodo.izquierdo;
        }
        return minimo;
    }

    // RECORRIDOS
    public void inOrder() {
        System.out.print("In-Order: ");
        inOrderRecursivo(raiz);
        System.out.println();
    }

    private void inOrderRecursivo(NodoBST nodo) {
        if (nodo != null) {
            inOrderRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrderRecursivo(nodo.derecho);
        }
    }

    public void preOrder() {
        System.out.print("Pre-Order: ");
        preOrderRecursivo(raiz);
        System.out.println();
    }

    private void preOrderRecursivo(NodoBST nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrderRecursivo(nodo.izquierdo);
            preOrderRecursivo(nodo.derecho);
        }
    }

    // MOSTRAR ÁRBOL
    public void mostrarArbol() {
        System.out.println("\n🌳 Estructura del BST:");
        mostrarArbolRecursivo(raiz, 0);
        System.out.println();
    }

    private void mostrarArbolRecursivo(NodoBST nodo, int nivel) {
        if (nodo != null) {
            mostrarArbolRecursivo(nodo.derecho, nivel + 1);
            System.out.println("   ".repeat(nivel) + "└── " + nodo.valor);
            mostrarArbolRecursivo(nodo.izquierdo, nivel + 1);
        }
    }

    // OBTENER ALTURA
    public int altura() {
        return alturaRecursivo(raiz);
    }

    private int alturaRecursivo(NodoBST nodo) {
        if (nodo == null)
            return 0;
        return 1 + Math.max(alturaRecursivo(nodo.izquierdo), alturaRecursivo(nodo.derecho));
    }
}