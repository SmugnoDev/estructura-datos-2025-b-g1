public class Ejercicio1 {
    public static void main(String[] args) {
        SimplyList listaSimple = new SimplyList();

        // add nodes to start list
        listaSimple.addToEnd(30);
        listaSimple.addToEnd(20);
        listaSimple.addToEnd(10);

        // print nodes
        listaSimple.printList();
    }
}
