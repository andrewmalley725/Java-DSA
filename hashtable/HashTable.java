package hashtable;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;
        Node(int value, String key) {
            this.value = value;
            this.key = key;
        }
    }
    
    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.print("\n" + i + ": ");
            Node temp = dataMap[i];
            if (temp != null) {
                while (temp.next != null) {
                    System.out.print("{ " + temp.key + " : " + temp.value + " } -> ");
                    temp = temp.next;
                }
                System.out.print("{ " + temp.key + " : " + temp.value + " }");
            }
        }
        System.out.println("");
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyArray = key.toCharArray();
        for (int i = 0; i < keyArray.length; i++){
            int asciival = keyArray[i];
            hash = (hash + asciival * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(value, key);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        }
        else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
}
