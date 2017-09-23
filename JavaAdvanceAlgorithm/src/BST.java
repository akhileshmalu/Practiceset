import java.util.Stack;

/**
 * @author: Akhilesh Maloo
 * @date: 9/15/17.
 */
public class BST {
    Node root;
    Stack<Integer> st = new Stack();



    public void PrintInOrder(Node node) {
        if (node == null) {
            return;
        }
        PrintInOrder(node.left);
        st.push(node.getKey());
        System.out.println(node.getKey() + " ");
        PrintInOrder(node.right);
    }

    public void PrintPreOrder(Node node) {
        if (node == null) {
            return;
        }
        st.push(node.getKey());
        System.out.println(node.getKey() + " ");
        PrintInOrder(node.left);
        PrintInOrder(node.right);
    }

    public void PrintInOrder() {
        PrintInOrder(root);
    }
    public void PrintPreOrder() {
        PrintPreOrder(root);
    }

    public static void main(String[] args) {
        BST tree = new BST();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);


        tree.PrintInOrder();
        System.out.println(tree.st);
    }
}

class Node {
    private int key;
    Node left;
    Node right;
    Node(int x) {
        key = x;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
