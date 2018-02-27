import java.util.ArrayList;
import java.util.List;

/**
 * Balancing not applied here. Pls use Red Black Tree for a balanced BST approach
 *
 * @author: Akhilesh Maloo
 * @date: 10/22/17.
 */
public class BinarySearchTree {

    Node root;

    class Node {
        Node left, right;
        int data;
        int size;

        Node(int k) {
            left = right = null;
            data = k;
        }
    }

    public int size(Node n) {
        if(n == null) return  0;
        return n.size;
    }

    public int size() {
        return size(root);
    }

    public void insert(int val) {
        if(root == null)
            root = new Node(val);
        else root = insert(root, val);
    }

    public Node insert(Node n, int value) {

        if(n == null) return new Node(value);

        if (value <= n.data) {
                n.left = insert(n.left,value);
        } else {
                n.right = insert(n.right,value);
        }

        n.size = size(n.left) + size(n.right) + 1;



        return n;
    }

    public boolean contains(int val) {

        Node curr = root;

        while(curr != null) {

            if(curr.data == val)
                return true;

            if(curr.data < val) {
                curr  = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return false;
    }

    public void printInOrderTree() {
        printInOrder(root);
    }

    public void printInOrder(Node n) {

        if(n.left != null)
            printInOrder(n.left);

        System.out.println(n.data);

        if(n.right != null)
            printInOrder(n.right);
    }

    public void printPreOrderTree() {
        printPreOrder(root);
    }

    public void printPreOrder(Node n) {

        System.out.println(n.data);

        if(n.left != null)
            printPreOrder(n.left);

        if(n.right != null)
            printPreOrder(n.right);
    }

    public void printPostOrderTree() {
        printPostOrder(root);
    }

    public void printPostOrder(Node n) {

        if(n.left != null)
            printPostOrder(n.left);

        if(n.right != null)
            printPostOrder(n.right);

        System.out.println(n.data);
    }

    public boolean isBalanced(Node n) {

        if(balancedHeight(n) > -1)
            return true;
        else
            return false;
    }

    private int balancedHeight(Node n) {

        if(n == null) return 0;

        int h1 = balancedHeight(n.left);
        int h2 = balancedHeight(n.right);

        if(h1 == -1 || h2 == -1) return -1;
        if(Math.abs(h1-h2) > 1) return -1;

        if(h1 > h2)
            return h1 + 1;
        else
            return  h2 + 1;

    }

    public Node buildBSTfromSortedArray(int[] a, int start, int end) {

        if(start > end) return null;

        int middle = (start + end) / 2;
        Node node  = new Node(a[middle]);

        node.left = buildBSTfromSortedArray(a,start,middle-1);
        node.right = buildBSTfromSortedArray(a,middle+1,end);

        return node;
    }

    public int depth() {
        return depth(root);
    }

    /**
     *
     * @param head
     * @return
     */
    public int depth(Node head) {
        if(head == null)
            return Integer.MAX_VALUE;

        if(head.left == null && head.right == null)
            return 0;

        return  1 + Math.min(depth(head.left), depth(head.right));
    }

    public int findClosest(int ch) {
        List<Node> ancestor = new ArrayList<>();
        return findClosest(root, ch, ancestor);
    }

    /**
     *  Find closest leaf node
     * @param head
     * @param ch
     * @param ancesstor
     * @return
     */
    public int findClosest(Node head, int ch, List<Node> ancesstor) {
        if(head == null)
            return Integer.MAX_VALUE;

        if(head.data == ch) {
            int min = depth(head);

            for (int i = ancesstor.size()-1; i >= 0; i--) {
                min = Math.min(min, depth(ancesstor.get(i)) + ancesstor.size() - i + 1);
            }

            return min;
        }

        ancesstor.add(head);

        return Math.min(findClosest(head.left, ch, ancesstor), findClosest(head.right, ch, ancesstor));
    }

    public static void main(String[] args) {

        int[] a = {3, 2, 10, 8, 6, 5, 7, 12, 15, 13 ,17};
        BinarySearchTree bst = new BinarySearchTree();

        for(int v: a) {
            bst.insert(v);
        }

        /*

                    3
                2      10
                     8    12
                   6         15
                 5   7    13    17
         */

// /        System.out.println(bst.contains(3));

        System.out.println(bst.findClosest(12));

        //Node r = bst.buildBSTfromSortedArray(a,0,a.length-1);


        /*
        bst.root.insert(5);
        bst.root.insert(7);
        bst.root.printInOrder();
        System.out.println(bst.root.contains(7));
        */


     }
}
