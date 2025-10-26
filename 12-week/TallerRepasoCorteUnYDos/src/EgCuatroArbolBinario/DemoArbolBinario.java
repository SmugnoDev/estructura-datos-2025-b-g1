package EgCuatroArbolBinario;

public class DemoArbolBinario {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        System.out.println("ÁRBOL BINARIO - RECORRIDOS");
        System.out.println("=".repeat(40));

        // Insertar valores
        int[] valores = { 50, 30, 70, 20, 40, 60, 80 };

        System.out.println("Insertando valores: ");
        for (int valor : valores) {
            System.out.print(valor + " ");
            arbol.insertar(valor);
        }
        System.out.println("\n");

        // Mostrar recorridos
        arbol.inOrder(); // Debería mostrar: 20 30 40 50 60 70 80
        arbol.preOrder(); // Debería mostrar: 50 30 20 40 70 60 80
        arbol.postOrder(); // Debería mostrar: 20 40 30 60 80 70 50

        // Buscar valores
        System.out.println("\n🔍 Búsquedas:");
        System.out.println("¿Existe 40? " + arbol.buscar(40));
        System.out.println("¿Existe 90? " + arbol.buscar(90));
    }
}
