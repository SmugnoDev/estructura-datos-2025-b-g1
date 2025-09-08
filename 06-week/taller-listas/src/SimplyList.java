public class SimplyList {
    Node headNode;

    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if (headNode == null) {
            headNode = newNode;
            return;
        }

        Node auxNode = headNode;
        while (auxNode.nextNode != null) {
            auxNode = headNode.nextNode;
        }
        auxNode.nextNode = newNode;
    }

    public void addToStart(int data) {
        Node newNode = new Node(data);
        newNode.nextNode = headNode;
        headNode = newNode;
    }

    public void insertAnyPosition(int data, int position) {
        Node newNode = new Node(data);

        if (headNode == null && position != 0) {
            System.out.println("No existe lista..");
            return;
        }
        if (position == 0) {
            addToStart(data);
            return;
        }

        Node auxNode = headNode;
        for (int i = 0; auxNode != null && i < (position - 1); i++) {
            auxNode = auxNode.nextNode;
        }

        if (auxNode == null) {
            System.out.println("Posicion Invalida...");
            return;
        }

        newNode.nextNode = auxNode.nextNode;
        auxNode.nextNode = newNode;
    }

    public void deletePosition(int position) {
        if (headNode == null) {
            System.out.println("Lista vacía.");
            return;
        }

        if (position == 0) {
            headNode = headNode.nextNode;
            return;
        }

        Node auxNode = headNode;
        for (int i = 0; auxNode != null && i < position - 1; i++) {
            auxNode = auxNode.nextNode;
        }

        if (auxNode == null || auxNode.nextNode == null) {
            System.out.println("Posición inválida.");
            return;
        }

        auxNode.nextNode = auxNode.nextNode.nextNode;
    }

    public void printList() {
        Node present = headNode;
        while (present != null) {
            System.out.print(present.data + " -> ");
            present = present.nextNode;
        }
        System.out.println("null");
    }
}
