package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.prepend(0);
        myList.removeFirst();
        myList.removeFirst();
        myList.removeFirst();

//        myList.getTail();
//        myList.getLength();
//
        myList.printItems();
    }
}
