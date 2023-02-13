package DataStructure;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author: Akhilesh Maloo
 * @date: 1/6/23.
 */
public class BST2{


    class Node {
        int data;
        int size;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            int size = 0;
        }

        public Node(int key, Node left, Node right) {
            this.data = key;
            this.left = left;
            this.right = right;
        }
    }

    Node root;

    BST2() {
        root = null;
    }

    void put(int n) {
        root = put(root, n);
    }

    Node put(Node n, int val) {
        if(n == null) {
            return new Node(val);
        }
        if(n.data > val) {
            n.left = put(n.left, val);
        } else if (n.data < val) {
            n.right = put(n.right, val);
        } else {
            n.data = val;
        }
        n.size = 1 + size(n.left) + size(n.right);
        return n;
    }


    int size(Node n) {
        if(n == null)
            return 0;
        return n.size;
    }

    int get(int val) {
        Node tmp = get(root, val);
        return tmp != null? tmp.data : -1;
    }

    Node get(Node n, int target) {
        while(n != null) {
            if(n.data == target)
                return n;
            if(n.data > target) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return null;
    }

    void remove(int target) {
        root =  remove(root, target);
    }

    int floor(int k) {
        Node n = floor(root, k);
        return n != null? n.data : -1;
    }

    Node floor(Node n, int k) {
        if(n == null)
            return null;
        if(n.data > k) {
            return floor(n.left, k);
        } else if(n.data < k) {
            Node tmp = n;
            tmp = floor(tmp.right, k);
            if(tmp != null) {
                return tmp;
            }
        }
        return n;
    }

    int ceil(int k) {
        Node n = ceil(root, k);
        return n != null? n.data : -1;
    }

    Node ceil(Node n, int k) {
        if(n == null)
            return null;
        if(n.data == k)
            return n;
        if(n.data < k) {
            return ceil(n.right, k);
        } else {
            Node tmp = n;
            tmp = ceil(tmp.left, k);
            if(tmp != null) {
                return tmp;
            }
            return n;
        }
    }

    int rank(int k) {
        return rank(root, k);
    }

    int rank(Node n, int k) {
        if(n == null)
            return 0;
        if(n.data > k) {
            return rank(n.left, k);
        } else if(n.data < k) {
            return 1 + size(n.left) + rank(n.right, k);
        } else {
            return size(n.left);
        }
    }

    Node deleteMin(Node n) {
        if(n.left == null) return n.right;
        n.left = deleteMin(n.left);
        n.size = 1 + size(n.left) + size(n.right);
        return n;
    }

    Node min(Node n) {
        if(n == null)
            return null;
        if(n.left == null) return n;
        return min(n.left);
    }

    Node remove(Node n, int target) {
        if(n == null)
            return null;
        if(n.data > target) {
            n.left = remove(n.left, target);
        } else if(n.data < target) {
            n.right = remove(n.right, target);
        } else {
            //single child nodes
            if(n.right == null) return n.left;
            if(n.left == null) return n.right;
            Node t = n;
            n = min(n.right);
            n.right = deleteMin(t.right);
            n.left = t.left;
        }
        return n;
    }

    Iterable<Integer> inOrder() {
        LinkedList<Integer> q = new LinkedList<>();
        inOrder(root, q);
        return q;
    }

    void inOrder(Node n, LinkedList<Integer> q) {
        if(n == null) return;
        inOrder(n.left, q);
        q.push(n.data);
        inOrder(n.right, q);
    }
}
