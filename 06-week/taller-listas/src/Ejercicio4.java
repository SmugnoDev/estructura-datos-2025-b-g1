public class Ejercicio4 {
    public static void main(String[] args) {
        DoublyList lista = new DoublyList();
        lista.addToStart(10);
        lista.addToEnd(20);
        lista.addToEnd(30);

        System.out.println("Lista doble:");
        lista.printList();

        lista.deleteStart();
        System.out.println("Después de eliminar inicio:");
        lista.printList();

        lista.deleteEnd();
        System.out.println("Después de eliminar final:");
        lista.printList();
    }
}
