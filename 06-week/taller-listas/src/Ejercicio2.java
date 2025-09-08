public class Ejercicio2 {
    public static void main(String[] args) {
        SimplyList lista = new SimplyList();

        // add nodes to start list
        lista.addToStart(30);
        lista.addToStart(20);
        lista.addToStart(10);

        System.out.println("Lista inicial:");
        lista.printList();

        lista.insertAnyPosition(50, 2);
        System.out.println("Lista después de insertar en posición 2:");
        lista.printList();

    }
}
