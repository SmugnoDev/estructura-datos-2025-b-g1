public class Ejercicio3 {
    public static void main(String[] args) {
        SimplyList lista = new SimplyList();

        lista.addToStart(10);
        lista.addToStart(20);
        lista.addToStart(30);
        lista.addToStart(40);

        System.out.println("Lista original:");
        lista.printList();

        System.out.println("Eliminando elemento 2:");
        lista.deletePosition(2);
        lista.printList();
    }
}
