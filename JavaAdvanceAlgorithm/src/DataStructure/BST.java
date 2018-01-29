package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Akhilesh Maloo
 * @date: 1/18/18.
 */
public class BST {

    class Node {
        int data;
        int size;
        int height;
        Node left;
        Node right;

        Node(int v) {
            data = v;
            size = 0;
            height  = -1;
            left = right = null;
        }

        Node() {
            this(0);
        }

        @Override
        public boolean equals(Object that) {
            if (this == that)
                return true;

            if (this.getClass() != that.getClass())
                return false;

            Node tmp = (Node) that;

            return (this.data == tmp.data);
        }
    }

    private Node root;

    private int size(Node node) {
        if (node == null)
            return 0;

        return node.size;
    }

    private int height(Node node) {
        if (node == null)
            return 0;

        return node.height;
    }

    public void put(int val) {
        root = put(root, val);
    }

    public Node put(Node x, int val) {
        if (x == null) {
            return new Node(val);
        }

        if (x.data > val) {
            x.left = put(x.left, val);
        } else if (x.data < val) {
            x.right = put(x.right, val);
        } else {
            x.data = val;
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return x;

    }

    public int get(int key) {
        if (root == null)
            return -1;

        Node curr = root;

        while (curr != null) {
            if (curr.data > key) {
                curr = curr.left;
            } else if (curr.data < key) {
                curr = curr.right;
            } else {
                return curr.data;
            }
        }

        return -1;
    }

    public boolean contains(int key) {
        return get(key) > -1;
    }

    public int findMin() {
        Node curr = root;

        if (curr == null)
            return -1;

        while (curr.left != null)
            curr = curr.left;

        return curr.data;
    }

    public int findMax() {
        Node curr = root;

        if (curr == null)
            return -1;

        while (curr.right != null)
            curr = curr.right;

        return curr.data;
    }


    public int floor(int val) {
        Node curr = floor(root, val);
        if (curr != null)
            return curr.data;

        return -1;
    }

    private Node floor(Node x, int val) {
        if (x == null)
            return null;

        if (x.data == val)
            return x;

        if (x.data > val) {
            return floor(x.left, val);
        }
        Node t = floor(x.right, val);
        if (t != null) return t;
        else return x;
    }

    public int ceil(int val) {
        Node curr = ceil(root, val);
        if (curr != null)
            return curr.data;

        return -1;
    }

    private Node ceil(Node x, int val) {
        if (x == null)
            return null;

        if (x.data == val)
            return x;

        if (x.data < val) {
            return ceil(x.right, val);
        }
        Node t = ceil(x.left, val);
        if (t != null) return t;
        else return x;
    }

    public int rank(int val) {
        if (!contains(val))
            return 0;
        return rank(val, root);

    }

    private int rank(int val, Node node) {
        if(node == null)
            return 0;

        if(node.data == val)
            return size(node.left);

        else if(node.data > val) {
            return rank(val, node.left);
        } else
            return 1 + size(node.left) + rank(val,node.right);

    }

    public Iterable<Integer> inorder() {
        LinkedList<Integer> q = new LinkedList<>();
        inorder(root,q);
        return q;

    }

    private void inorder(Node curr, LinkedList<Integer> q) {
        if(curr == null)
            return;
        inorder(curr.left,q);
        q.push(curr.data);
        inorder(curr.right,q);
    }
}

