package queue;

public class Queue {
    Node first;
    Node last;
    int length = 0; 

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length++;
    }

    public void printItems() {
        Node temp = first;
        while(temp.next != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.value);
        System.out.println("");
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        if (length == 0) return null;

        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
            length--;
            return temp;
        }

        first = first.next;
        temp.next = null;
        length--;
        return temp;
    }
}
