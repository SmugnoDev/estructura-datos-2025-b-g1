package EgQuintoArbolBalanceado;

public class DemoAVL {
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();

        System.out.println("ÁRBOL AVL - SIMULACIÓN DE ROTACIONES");
        System.out.println("=".repeat(50));

        // Caso 1: Right-Right (Rotación simple izquierda)
        System.out.println("\nCASO 1: RIGHT-RIGHT");
        System.out.println("Insertando: 10, 20, 30");
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.mostrarArbol();

        // Reiniciar árbol
        arbol = new ArbolAVL();

        // Caso 2: Left-Left (Rotación simple derecha)
        System.out.println("\nCASO 2: LEFT-LEFT");
        System.out.println("Insertando: 30, 20, 10");
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(10);
        arbol.mostrarArbol();

        // Reiniciar árbol
        arbol = new ArbolAVL();

        // Caso 3: Left-Right (Rotación doble)
        System.out.println("\nCASO 3: LEFT-RIGHT");
        System.out.println("Insertando: 30, 10, 20");
        arbol.insertar(30);
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.mostrarArbol();

        // Reiniciar árbol
        arbol = new ArbolAVL();

        // Caso 4: Right-Left (Rotación doble)
        System.out.println("\nCASO 4: RIGHT-LEFT");
        System.out.println("Insertando: 10, 30, 20");
        arbol.insertar(10);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.mostrarArbol();

        // Ejemplo más complejo
        System.out.println("\nEJEMPLO COMPLEJO");
        arbol = new ArbolAVL();
        int[] valores = { 50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45 };

        for (int valor : valores) {
            arbol.insertar(valor);
        }

        arbol.mostrarArbol();
        arbol.inOrder();
    }
}
