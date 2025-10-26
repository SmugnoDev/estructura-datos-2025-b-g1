package EgCuatroArbolBinario;

class Nodo {
    int valor;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Método para insertar un valor
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        }

        return actual;
    }

    // RECORRIDOS

    // Recorrido In-Order (Izquierda - Raíz - Derecha)
    public void inOrder() {
        System.out.print("In-Order: ");
        inOrderRecursivo(raiz);
        System.out.println();
    }

    private void inOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            inOrderRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrderRecursivo(nodo.derecho);
        }
    }

    // Recorrido Pre-Order (Raíz - Izquierda - Derecha)
    public void preOrder() {
        System.out.print("Pre-Order: ");
        preOrderRecursivo(raiz);
        System.out.println();
    }

    private void preOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrderRecursivo(nodo.izquierdo);
            preOrderRecursivo(nodo.derecho);
        }
    }

    // Recorrido Post-Order (Izquierda - Derecha - Raíz)
    public void postOrder() {
        System.out.print("Post-Order: ");
        postOrderRecursivo(raiz);
        System.out.println();
    }

    private void postOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            postOrderRecursivo(nodo.izquierdo);
            postOrderRecursivo(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    // Método para buscar un valor
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return false;
        }

        if (valor == actual.valor) {
            return true;
        }

        return valor < actual.valor
                ? buscarRecursivo(actual.izquierdo, valor)
                : buscarRecursivo(actual.derecho, valor);
    }
}
