public class Ejercicio5 {
    public static void main(String[] args) {
        CircularList lista = new CircularList();
        lista.insert(10);
        lista.insert(20);
        lista.insert(30);

        System.out.println("Lista circular:");
        lista.printList();

        lista.delete(20);
        System.out.println("Después de eliminar 20:");
        lista.printList();
    }
}
