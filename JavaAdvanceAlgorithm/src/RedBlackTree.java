/**
 * @link https://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html
 * @author: Robert Sedgewick and Kevin Wayne.
 * Copyright © 2000–2017,
 * Last updated: Fri Oct 20 12:50:46 EDT 2017.
 * @date: 10/29/17.
 */
public class RedBlackTree {

    protected static final boolean RED = true;
    protected static final boolean BLACK = false;

    protected class Node {
        protected int data;
        protected Node left;
        protected Node right;
        protected Boolean color;
        protected int size;

        Node(int key, boolean clr, int sz) {
            data = key;
            color = clr;
            size = sz;
        }
    }

    protected Node root;

    private int size(Node n) {
        if(n == null) return 0;
        return n.size;
    }

    protected int size() {
        return size(root);
    }

    private boolean isEmpty() {
        return root == null;
    }

    public int height() {
        return height(root);
    }


    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public void printPreOrder() {
        preOrder(root);
    }

    private void preOrder(Node n) {

        System.out.println(n.data);

        if(n.left != null)
            preOrder(n.left);

        if(n.right != null)
            preOrder(n.right);

    }

    public void printPostOrder() {
        postOrder(root);
    }

    private void postOrder(Node n) {

        if(n.left != null)
            preOrder(n.left);

        if(n.right != null)
            preOrder(n.right);

        System.out.println(n.data);

    }

    public void printInOrder() {
        inOrder(root);
    }

    private void inOrder(Node n) {

        if(n.left != null)
            inOrder(n.left);

        System.out.println(n.data);

        if(n.right != null)
            inOrder(n.right);

    }

    /**
     * rank starts from 0 as index; ASC
     * @param val
     * @return
     */
    public int rank(int val) {
        return rank(root, val);
    }

    private int rank(Node n, int val) {
        if(n == null) return 0;

        if(n.data > val) {
            return rank(n.left, val);
        } else if(n.data < val) {
            return 1 + size(n.left) + rank(n.right,val);
        } else {
            return size(n.left);
        }
    }

    public void insertKey(int val) {
        root = insert(root, val);
        root.color = BLACK;
    }


    private Node insert(Node n, int val) {

        if(n == null) return new Node(val, RED,1);

        if(val < n.data) {
            n.left = insert(n.left, val);
        } else if(val > n.data){
            n.right = insert(n.right, val);
        } else {
            n.data = val;
        }

        if(isRed(n.right) && !isRed(n.left)) n = rotateLeft(n);
        if(isRed(n.left) && isRed(n.left.left)) n = rotateRight(n);
        if(isRed(n.left) && isRed(n.right)) flipColors(n);

        n.size = size(n.left) + size(n.right) + 1;

        return n;
    }

    public boolean contains(int key) {
        Node curr = root;
        while(curr != null) {
            if(curr.data == key)
                return true;
            else if(curr.data < key) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return false;
    }

    private boolean isRed(Node n) {
        if(n == null) return false;
        return n.color == RED;
    }

    private Node rotateLeft(Node n) {
        Node temp = n.right;
        n.right = temp.left;
        temp.left = n;
        temp.color = n.color;
        n.color = RED;

        return temp;
    }

    private Node rotateRight(Node n) {

        Node temp = n.left;
        n.left = temp.right;
        temp.right = n;

        temp.color = n.color;
        n.color = RED;
        return temp;

    }

    private void flipColors(Node n) {
        n.color = RED;
        n.left.color = BLACK;
        n.right.color = BLACK;
    }


    public static void main(String[] args) {

        RedBlackTree rbt = new RedBlackTree();
        int[] values = {1,3,12,4,7,6};

        for(int val: values) {
            rbt.insertKey(val);
        }


        System.out.println(rbt.root.data);

        System.out.println(rbt.rank(5));


    }



}
