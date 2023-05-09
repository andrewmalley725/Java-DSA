package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.prepend(0);

        myList.prepend(4);
        myList.insert(2, 5);
        myList.append(3);
        //System.out.println(myList.remove(5).value);
        myList.reverse();
        myList.summary();
        System.out.println("");
        myList.printItems();
        System.out.println("");
        System.out.println(myList.findMiddleNode().value);
        
    }
}
