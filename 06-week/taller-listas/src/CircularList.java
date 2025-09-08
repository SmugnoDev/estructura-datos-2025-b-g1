public class CircularList {
    Node headNode;

    public void insert(int data) {
        Node nuevo = new Node(data);
        if (headNode == null) {
            headNode = nuevo;
            headNode.nextNode = headNode;
            return;
        }
        Node auxNode = headNode;
        while (auxNode.nextNode != headNode) {
            auxNode = auxNode.nextNode;
        }
        auxNode.nextNode = nuevo;
        nuevo.nextNode = headNode;
    }

    public void delete(int data) {
        if (headNode == null) return;

        if (headNode.data == data && headNode.nextNode == headNode) {
            headNode = null;
            return;
        }

        Node auxNode = headNode;
        Node previousNode = null;
        do {
            if (auxNode.data == data) {
                if (previousNode != null) {
                    previousNode.nextNode = auxNode.nextNode;
                } else {
                    Node lastNode = headNode;
                    while (lastNode.nextNode != headNode) {
                        lastNode = lastNode.nextNode;
                    }
                    headNode = headNode.nextNode;
                    lastNode.nextNode = headNode;
                }
                return;
            }
            previousNode = auxNode;
            auxNode = auxNode.nextNode;
        } while (auxNode != headNode);
    }

    public void printList() {
        if (headNode == null) return;
        Node auxNode = headNode;
        do {
            System.out.print(auxNode.data + " -> ");
            auxNode = auxNode.nextNode;
        } while (auxNode != headNode);
        System.out.println("(circular)");
    }
}
