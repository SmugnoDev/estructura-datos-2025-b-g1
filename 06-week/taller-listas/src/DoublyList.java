public class DoublyList {
    DoubleNode headNode;
    DoubleNode tailNode;

    public void addToStart(int data) {
        DoubleNode newDoubleNode = new DoubleNode(data);
        if (headNode == null) {
            headNode = tailNode = newDoubleNode;
        } else {
            newDoubleNode.nextNode = headNode;
            headNode.previousNode = newDoubleNode;
            headNode = newDoubleNode;
        }
    }

    public void addToEnd(int data) {
        DoubleNode newDoubleNode = new DoubleNode(data);
        if (tailNode == null) {
            headNode = tailNode = newDoubleNode;
        } else {
            tailNode.nextNode = newDoubleNode;
            newDoubleNode.previousNode = tailNode;
            tailNode = newDoubleNode;
        }
    }

    public void deleteStart() {
        if (headNode == null) return;
        headNode = headNode.nextNode;
        if (headNode != null) headNode.previousNode = null;
    }

    public void deleteEnd() {
        if (tailNode == null) return;
        tailNode = tailNode.previousNode;
        if (tailNode != null) tailNode.nextNode = null;
    }

    public void printList() {
        DoubleNode auxDoubleNode = headNode;
        while (auxDoubleNode != null) {
            System.out.print(auxDoubleNode.data + " <-> ");
            auxDoubleNode = auxDoubleNode.nextNode;
        }
        System.out.println("null");
    }
}
