package stack;

public class Main {
   public static void main(String[] args)  {
        Stack myStack = new Stack (0);
        myStack.push(-1);
        myStack.push(-2);
        myStack.pop();
        myStack.printItems();
    }
}
