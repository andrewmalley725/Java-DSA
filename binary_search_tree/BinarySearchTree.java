package binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    class Node {
        int value;
        Node right;
        Node left;
        Node(int value) {
            this.value = value;
        }
    }
    
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            
            if (newNode.value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }

            else {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;

        if (root == null) return false;

        while (temp != null) {
            if (value > temp.value) {
                temp = temp.right;
            }
            else if (value < temp.value) {
                temp = temp.left;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value > currentNode.value) {
            return rContains(currentNode.right, value);
        }
        else {
            return rContains(currentNode.left, value);
        }
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        else if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    public List<Integer> BFS() {
        Node currNode = root;
        Queue<Node> queue = new LinkedList<>();
        List<Integer> returnList = new ArrayList<>();
        queue.add(currNode);
        while (queue.size() > 0) {
            currNode = queue.remove();
            returnList.add(currNode.value);
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
        }
        return returnList;
    }

    public List<Integer> DFSPreOrder() {
        List<Integer> returnList = new ArrayList<>();

        class Traverse {
            Traverse(Node currNode) {
                returnList.add(currNode.value);
                if (currNode.left != null) {
                    new Traverse(currNode.left);
                }
                if (currNode.right != null) {
                    new Traverse(currNode.right);
                }
            } 
        }
        new Traverse(root);
        return returnList;
    }

    public List<Integer> DFSPostOrder() {
        List<Integer> returnList = new ArrayList<>();

        class Traverse {
            Traverse(Node currNode) {
                
                if (currNode.left != null) {
                    new Traverse(currNode.left);
                }
                if (currNode.right != null) {
                    new Traverse(currNode.right);
                }
                returnList.add(currNode.value);
            } 
        }
        new Traverse(root);
        return returnList;
    }

    public List<Integer> DFSInOrder() {
        List<Integer> returnList = new ArrayList<>();

        class Traverse {
            Traverse(Node currNode) {
                
                if (currNode.left != null) {
                    new Traverse(currNode.left);
                }
                returnList.add(currNode.value);
                if (currNode.right != null) {
                    new Traverse(currNode.right);
                }
                
            } 
        }
        new Traverse(root);
        return returnList;
    }
}
