package EgQuintoArbolBalanceado;

class NodoAVL {
    int valor;
    int altura;
    NodoAVL izquierdo;
    NodoAVL derecho;

    public NodoAVL(int valor) {
        this.valor = valor;
        this.altura = 1;
    }
}

public class ArbolAVL {
    private NodoAVL raiz;

    // Obtener altura de un nodo
    private int altura(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    // Obtener factor de equilibrio
    private int factorEquilibrio(NodoAVL nodo) {
        return nodo == null ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    // Actualizar altura
    private void actualizarAltura(NodoAVL nodo) {
        if (nodo != null) {
            nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
        }
    }

    // ROTACIONES

    // Rotación simple a la derecha
    private NodoAVL rotacionDerecha(NodoAVL y) {
        System.out.println("Rotación DERECHA en nodo " + y.valor);

        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    // Rotación simple a la izquierda
    private NodoAVL rotacionIzquierda(NodoAVL x) {
        System.out.println("Rotación IZQUIERDA en nodo " + x.valor);

        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    // Insertar valor
    public void insertar(int valor) {
        System.out.println("\nInsertando: " + valor);
        raiz = insertarRecursivo(raiz, valor);
        System.out.println("Insertado correctamente");
    }

    private NodoAVL insertarRecursivo(NodoAVL nodo, int valor) {
        // 1. Inserción normal BST
        if (nodo == null) {
            return new NodoAVL(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        } else {
            return nodo; // Valores duplicados no permitidos
        }

        // 2. Actualizar altura
        actualizarAltura(nodo);

        // 3. Obtener factor de equilibrio
        int equilibrio = factorEquilibrio(nodo);

        // 4. Verificar si está desbalanceado y aplicar rotaciones
        System.out.println("Nodo " + nodo.valor + " - Factor equilibrio: " + equilibrio);

        // Caso Left Left
        if (equilibrio > 1 && valor < nodo.izquierdo.valor) {
            System.out.println("Caso LEFT-LEFT - Rotación simple derecha");
            return rotacionDerecha(nodo);
        }

        // Caso Right Right
        if (equilibrio < -1 && valor > nodo.derecho.valor) {
            System.out.println("Caso RIGHT-RIGHT - Rotación simple izquierda");
            return rotacionIzquierda(nodo);
        }

        // Caso Left Right
        if (equilibrio > 1 && valor > nodo.izquierdo.valor) {
            System.out.println("Caso LEFT-RIGHT - Rotación izquierda-derecha");
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        // Caso Right Left
        if (equilibrio < -1 && valor < nodo.derecho.valor) {
            System.out.println("Caso RIGHT-LEFT - Rotación derecha-izquierda");
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    // Recorrido in-order para verificar el árbol
    public void inOrder() {
        System.out.print("In-Order: ");
        inOrderRecursivo(raiz);
        System.out.println();
    }

    private void inOrderRecursivo(NodoAVL nodo) {
        if (nodo != null) {
            inOrderRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + "(" + nodo.altura + ") ");
            inOrderRecursivo(nodo.derecho);
        }
    }

    // Mostrar estructura del árbol
    public void mostrarArbol() {
        System.out.println("\nEstructura del árbol:");
        mostrarArbolRecursivo(raiz, 0);
    }

    private void mostrarArbolRecursivo(NodoAVL nodo, int nivel) {
        if (nodo != null) {
            mostrarArbolRecursivo(nodo.derecho, nivel + 1);
            System.out.println("   ".repeat(nivel) + nodo.valor + " (h:" + nodo.altura + ")");
            mostrarArbolRecursivo(nodo.izquierdo, nivel + 1);
        }
    }
}
