// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Stack & Queue
// Author: Joseph H Cottingham | 1216723703
// Description: Binary Trees & Recursion

public class BSTree<T extends Comparable<T>> implements Tree<T> {
    private Node root = null;
    private int nodeCount = 0;

    public void add(T item) {
        if (root==null){
            root = new Node(item);
        } else {
            root.add(item);
        }
    }

    public boolean contains(T item) {
        return containsRecursion(root, item);
    }

    private boolean containsRecursion(Node n, T item){
        if (((Comparable)item).compareTo((Comparable)n.data)==0){
            return true;
        } else if (((Comparable)item).compareTo((Comparable)n.data)<0) {
            if (n.left != null) return containsRecursion(n.left, item);
        } else if (((Comparable)item).compareTo((Comparable)n.data)>0) {
            if (n.right != null) return containsRecursion(n.right, item);
        }
        return false;
    }

    public int size() {
        return sizeRecursion(root);
    }

    private int sizeRecursion(Node n) {
        if (n == null) return 0;
        return 1 + sizeRecursion(n.left) + sizeRecursion(n.right);
    }

    public void inOrderPrint() {
        printTree(root);
    }

    private void printTree(Node n){
        System.out.println(n.data);
        if (n.right!=null) printTree(n.right);
        if (n.left!=null) printTree(n.left);
    }

    public String toString() {
        if (root==null) return "";
        return toStringRecursion(root);
    }

    private String toStringRecursion(Node n){
        String s = "";
        if (n.left!=null) s += toStringRecursion(n.left);
        s += n.data.toString() + " ";
        if (n.right!=null) s += toStringRecursion(n.right);
        return s;
    }

    class Node<T extends Comparable <T>> {
        public T data;
        public Node left = null;
        public Node right = null;

        public Node(T data) {
            this.data = data;
        }

        public void add(T item) {
            if ((item).compareTo(data) == 0){
                return;
            } else if ((item).compareTo(data)<0) {
                if (left == null) left = new Node(item);
                else left.add(item);
            } else if ((item).compareTo(data)>0) {
                if (right == null) right = new Node(item);
                else right.add(item);
            }
        }
    }
}
