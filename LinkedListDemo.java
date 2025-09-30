class Node {
    Integer value;
    Node next;

    Node(Integer value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {

    private Node head;

    public void insertAtHead(Integer value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public Node LinkedListInsert(int index, Integer value) {
        if (index == 0) {
            Node new_head = new Node(value);
            new_head.next = head;
            head = new_head;
            return new_head;
        }

        Node current = head;
        Node previous = null;
        int count = 0;

        while (count < index && current != null) {
            previous = current;
            current = current.next;
            count = count + 1;
        }

        if (count < index) {
        }

        Node new_node = new Node(value);
        new_node.next = previous.next;
        previous.next = new_node;

        return head;
    }

    public Node LinkedListLookUp(int elementNumber) {
        Node current = head;
        int count = 0;

        while (count < elementNumber && current != null) {
            current = current.next;
            count = count + 1;
        }

        return current;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("/\n");
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(50);
        list.insertAtHead(40);
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10);

        // Lista inicial: 10->20->30->40->50->/
        list.printList();

        // Insertar en la posición 3 el valor 71
        list.LinkedListInsert(3, 71);

        // Lista después: 10->20->30->71->40->50->/
        list.printList();
    }
}
