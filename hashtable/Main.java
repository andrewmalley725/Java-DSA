package hashtable;

public class Main {
    public static void main(String[] args)  {
        HashTable myHash = new HashTable();
        myHash.set("level", 9000);
        myHash.set("points", 27);
        myHash.set("songs", 100);
        System.out.println(myHash.keys());
        myHash.printTable();
    }

}
