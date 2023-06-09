package hashtable;

import java.util.ArrayList;

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

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        if (temp == null) return 0;
        while (temp.key != key) {
            temp = temp.next;
        }
        return temp.value;
    }

    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public void printKeys() {
        for (String key : this.keys()) {
            System.out.println(key);
        }
    }
}
