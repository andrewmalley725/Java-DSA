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
        else if (length == 1) {
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
            length--;
            return temp;
        }
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            Node temp = head;
            newNode.next = temp;
            head = newNode;
        }
        length++;
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
            length--;
            return temp;
        }
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
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
        if (index < 0 || index > length) {
            return false;
        }
        
        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node pre = get(index - 1);
        Node newNode = new Node(value);
        newNode.next = pre.next;
        pre.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        
        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node pre = get(index - 1);
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i =0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasLoop() {
	    Node slow = head;
	    Node fast = head;
	    while (fast != null && fast.next != null) {
	        if (fast.next == slow) return true;
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    return false;
	}

    public void partitionList(int x) {
        if (head == null) {
            return;
        }
        
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;
        
        while (current != null) {
            if (current.value < x) {
                    prev1.next = current;
                    prev1 = current;
                }
                else {
                    prev2.next = current;
                    prev2 = current;
                }
                current = current.next;
            }
        prev2.next = null;
        prev1.next = dummy2.next;
 
        head = dummy1.next;
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        Node temp = head;

        while (temp != null) {
            Node next = temp;
            while (next.next != null) {
                if (next.next.value == temp.value) {
                    next.next = next.next.next;
                }
                else {
                    next = next.next;
                }
            }
            temp = temp.next;
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

    public void summary() {
        this.getHead();
        this.getTail();
        this.getLength();
    }
}
