import java.util.*;
/**
 * @author: Akhilesh Maloo
 * @date: 1/18/18.
 */
public class PrintVerticalBinaryTree {

    Node root;
    TreeMap<Integer, List<Node>> map = new TreeMap<>();

    public void mapInsert(Node node) {
        if(node == null) return;

        if(map.containsKey(node.hDIst)) {

            List<Node> tmp = map.get(node.hDIst);
            tmp.add(node);
            map.put(node.hDIst, tmp);

        } else {

            List<Node> tmp = new ArrayList<>();
            tmp.add(node);
            map.put(node.hDIst,tmp);
        }
    }

    public void displayVerticalBinary() {

        for(List<Node> tmp : map.values()) {
            tmp.forEach(t -> {System.out.println(t.val + " horizontal Dist" + t.hDIst);});
            System.out.println();
        }
    }


    public void printVertical() {

        Node curr = root;

        LinkedList<Node> q = new LinkedList<>();
        q.add(curr);

        mapInsert(curr);

        while(!q.isEmpty()) {

            Node tmp = q.poll();

            if(tmp.left != null) {
                tmp.left.hDIst = tmp.hDIst - 1;
                q.add(tmp.left);
                mapInsert(tmp.left);

            }

            if(tmp.right != null) {
                tmp.right.hDIst = tmp.hDIst + 1;
                q.add(tmp.right);
                mapInsert(tmp.right);
            }
        }

        displayVerticalBinary();
    }


    public static void main(String[] args) {
        PrintVerticalBinaryTree tree = new PrintVerticalBinaryTree();

        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);

        tree.printVertical();


    }
}

class Node {
    int val;
    int hDIst;
    Node left;
    Node right;

    Node() {
        this(0);
    }

    Node(int data) {
        this.val = data;
        left = right = null;
        hDIst = 0;
    }
}