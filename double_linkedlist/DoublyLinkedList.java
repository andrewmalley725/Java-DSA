package double_linkedlist;

public class DoublyLinkedList {
    int length = 0;
    Node head;
    Node tail;

    class Node {
        int value;
        Node next;
        Node prev;
        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;
    }

    private void printItems() {
        Node temp = head;
        while(temp.next != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.value);
        System.out.println("");
    }

    public void summary() {
        System.out.println("");
        System.out.println("Head: " + head.value);
        System.out.println("Tail: " + tail.value);
        System.out.println("Length: " + length);
        System.out.println("");
        this.printItems();
        System.out.println("");
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            length++;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            length++;
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
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            length++;
        }
    }

    public Node removeLast() {
        if (length == 0) return null;

        if (length == 1) {
            Node temp = head;
            head = null;
            tail = null;
            length--;
            return temp;
        }

        Node temp = tail;
        tail = temp.prev;
        temp.prev = null;
        tail.next = null;
        length--;
        return temp;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        if (length == 1) {
            Node temp = head;
            head = null;
            tail = null;
            length--;
            return temp;
        }

        Node temp = head;
        head.next.prev = null;
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
        else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        before.next = newNode;
        after.prev = newNode;
        newNode.next = after;
        newNode.prev = before;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node temp = get(index);
        temp.prev.next = null;
        temp.next.prev = null;
        temp.prev = null;
        temp.next = null;
        length--;
        return temp;
    }
}
