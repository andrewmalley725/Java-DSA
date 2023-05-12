package binary_search_tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(6);
        bst.insert(14);
        bst.insert(2);
        bst.insert(16);
        System.out.println(bst.root.right.right.value + "\n");
        System.out.println(bst.contains(10));
    }
}
