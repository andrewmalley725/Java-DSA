package linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printItems() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        Node temp = tail;
        temp.next = newNode;
        tail = newNode;
        length = length + 1;
    }

    public Node removeLast() {
        Node temp = head;
        Node pre = head;
        
        if (length == 0) {
            return null;
        }
        else if (temp.next == null) {
            head = null;
            tail = null;
            length = 0;
            return temp;
        }
        else {
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            tail = pre;
            tail.next = null;
            return temp;
        }
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        
        if (length == 0) {
            head = newNode;
            tail = newNode;
            length++;
        }
        else {
            Node temp = head;
            newNode.next = temp;
            head = newNode;
        }
    }

    public Node removeFirst() {
        Node temp = head;
        if (length == 0) {
            return null;
        }
        else if (length == 1) {
            head = null;
            tail = null;
            length = 0;
            return temp;
        }
        else {
            head = temp.next;
            return temp;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }
}
