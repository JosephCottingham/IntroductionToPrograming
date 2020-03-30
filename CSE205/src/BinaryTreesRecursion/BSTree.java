public class BSTree<T extends Comparable <T>> implements Tree<T>{
    Node head;
    public void add(T item){
        if (head=null) head = new Node(item);
        else head.add(item);
    }
    public boolean contains(T item){
        Node node = head;
        while (node.data != item) {
            if (node==null) return false;
            else if (node.data < item) node = node.right;
            else if (node.data > item) node = node.left;
        }
        return true;
    }
    public int size(){

    }
    public void inOrderPrint(){

    }
    public String toString(){

    }
    class Node{
        T data;
        Node left;
        Node right;
        public Node(T data){
            this.data = data;
        }
        public void add(T item){
            if (item<data){
                if (left!=null) left.add(item);
                else left = new Node(data);
            } else {
                if (right!=null) right.add(item);
                else right = new Node(data);
            }
        }
    }
}
