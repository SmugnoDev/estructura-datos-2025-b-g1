package EgSextoArbolBst;

public class DemoBST {
    public static void main(String[] args) {
        ArbolBST bst = new ArbolBST();

        System.out.println("ÁRBOL BST - BÚSQUEDA, INSERCIÓN Y ELIMINACIÓN");
        System.out.println("=".repeat(55));

        // Insertar valores
        System.out.println("\nINSERTANDO VALORES:");
        int[] valores = { 50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45 };
        for (int valor : valores) {
            bst.insertar(valor);
        }

        // Mostrar árbol
        bst.mostrarArbol();
        System.out.println("Altura del árbol: " + bst.altura());

        // Recorridos
        System.out.println("\nRECORRIDOS:");
        bst.inOrder();
        bst.preOrder();

        // Búsquedas
        System.out.println("\nBÚSQUEDAS:");
        bst.buscar(40);
        bst.buscar(90);
        bst.buscar(25);

        // Eliminaciones
        System.out.println("\nELIMINACIONES:");

        // Caso 1: Eliminar hoja
        System.out.println("\nCaso 1 - Eliminar hoja (10):");
        bst.eliminar(10);
        bst.mostrarArbol();
        bst.inOrder();

        // Caso 2: Eliminar nodo con un hijo
        System.out.println("\nCaso 2 - Eliminar nodo con un hijo (20):");
        bst.eliminar(20);
        bst.mostrarArbol();
        bst.inOrder();

        // Caso 3: Eliminar nodo con dos hijos
        System.out.println("\nCaso 3 - Eliminar nodo con dos hijos (30):");
        bst.eliminar(30);
        bst.mostrarArbol();
        bst.inOrder();

        // Caso 4: Eliminar raíz
        System.out.println("\nCaso 4 - Eliminar raíz (50):");
        bst.eliminar(50);
        bst.mostrarArbol();
        bst.inOrder();

        // Búsquedas finales
        System.out.println("\nBÚSQUEDAS FINALES:");
        bst.buscar(40);
        bst.buscar(30);
    }
}
