package double_linkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList(0);
        myList.append(1);
        myList.append(2);
        myList.prepend(-1);
        myList.summary();
    }
}
