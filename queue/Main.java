package queue;

public class Main {
    public static void main(String[] args) {
        Queue myQueue = new Queue(0);
        myQueue.enqueue(1);
        myQueue.dequeue();
        myQueue.printItems();
    }
}
