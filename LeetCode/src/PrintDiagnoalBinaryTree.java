import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 2/2/18.
 */
public class PrintDiagnoalBinaryTree {

    TreeMap<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());

    private void insertToMap(Node x) {
        List<Integer> list = null;
        if(map.containsKey(x.hDIst)) {
            list = map.get(x.hDIst);
            list.add(x.val);

        } else {
            list = new ArrayList<>();
            list.add(x.val);
        }
        map.put(x.hDIst, list);
    }

    private void printDiagnoalBT(Node x) {

        LinkedList<Node> q = new LinkedList<>();
        q.offer(x);

        while(!q.isEmpty()) {
            Node tmp = q.poll();

            insertToMap(tmp);

            if(tmp.left != null) {
                tmp.left.hDIst = tmp.hDIst - 1;
                q.offer(tmp.left);
            }
            if(tmp.right != null) {
                tmp.right.hDIst = tmp.hDIst;
                q.offer(tmp.right);
            }
        }
    }

    private void printDiagnoalBT2(Node x) {

        LinkedList<Node> q = new LinkedList<>();

        q.offer(x);

        while(!q.isEmpty()) {

            int size = q.size();

            while(size > 0) {
                Node temp = q.poll();

                while(temp != null) {
                    System.out.print(temp.val + " ");
                    if(temp.left != null)
                        q.add(temp.left);
                    temp = temp.right;
                }
                size--;

            }
            System.out.println();
        }
    }

    public void displayDiagonalBinary() {

        for(List<Integer> tmp : map.values()) {
            tmp.forEach(t -> System.out.print(t + " "));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrintDiagnoalBinaryTree tree = new PrintDiagnoalBinaryTree();

        /* Let us construct the tree shown in above diagram */
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        tree.printDiagnoalBT(root);
        tree.displayDiagonalBinary();
        System.out.println();
        tree.printDiagnoalBT2(root);

    }
}

