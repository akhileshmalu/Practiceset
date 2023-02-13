package Sorting;

/**
 * Red Black Tree for a balanced BST approach
 *
 * @author: Akhilesh Maloo
 * @date: 10/22/17.
 */
public class BinarySearchTree2 {

    private static final Boolean RED = true;
    private static final Boolean BLACK = false;

    Node root;

    class Node {
        Node left, right;
        int data;
        int size;
        boolean color;

        public Node() {
        }

        Node(int k) {
            left = right = null;
            data = k;
        }

        public Node(int data, int size) {
            this.data = data;
            this.size = size;
            left = right = null;
        }

        public Node(int data, int size, boolean color) {
            this.data = data;
            this.size = size;
            this.color = color;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if(root == null)
            return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public void insert(int val) {
        root = insert(root, val);
        root.color = BLACK;
    }

    public Node insert(Node node, int val) {
        if(node == null)
            return new Node(val, 1, RED);
        if(node.data > val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }

        if(!isRed(node.left) && isRed(node.right)) {
            node = rotateLeft(node); // rotate left
        }
        if(isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node); //rotate right
        }
        if(isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        node.size = size(node);
        return node;
    }

    private Node rotateRight(Node node) {

        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;

        node.color = RED;
        temp.color = node.color;

        return temp;
    }

    private Node rotateLeft(Node node) {

        Node x = node.right;
        node.right = x.left;
        x.left = node;

        node.color = RED;
        x.color = node.color;
        return x;
    }

    private void flipColors(Node node) {
        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;
    }

    public boolean isRed(Node node) {
        return node != null && (node.color == RED);
    }

    public boolean contains(int key) {
        return contains(root, key);
    }

    public Node min() {
        return min(root);
    }

    private Node min(Node node) {
        if(node.left == null)
            return node;
        return min(node.left);
    }

    public Node max() {
        return max(root);
    }

    private Node max(Node node) {
        if(node.right == null)
            return node;
        return max(node.right);
    }

    private boolean contains(Node node, int key) {
        if(node == null)
            return false;

        if(node.data == key) {
            return true;
        }

        return (node.data > key)? contains(node.left, key) : contains(node.right, key);
    }

    public void printInOrder(Node node) {
        if(node == null)
            return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {

        int[] a = {3, 2, 10, 8, 6, 5, 7, 12, 15, 13 ,17};
        BinarySearchTree2 bst = new BinarySearchTree2();

        for(int v: a) {
            bst.insert(v);
        }
        bst.printInOrder(bst.root);
     }
}
