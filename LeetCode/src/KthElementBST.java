import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 10/30/17.
 */
public class KthElementBST extends RedBlackTree{

    private List<Integer> valInArr = new ArrayList<>();

    public  int inOrderTraverse(int k) {

        inOrder(root);

        return valInArr.get(k-1);
    }

    public void inOrder(RedBlackTree.Node n) {


        if(n.left != null)
            inOrder(n.left);

        valInArr.add(n.data);

        if(n.right != null)
            inOrder(n.right);

    }

    /**
     * BFS traversing
     */
    public void printTreeByLevel() {
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {

            Node temp = q.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null) {
                q.add(temp.left);
            }

            if(temp.right != null) {
                q.add(temp.right);
            }

        }
    }

    public void printTreeByDepth() {
        HashSet<Node> visited = new HashSet<>();
        printTreeDepthUtil(root, visited);
    }

    public void printTreeDepthUtil(Node n, HashSet<Node> visited) {

        if(!visited.contains(n)) {
            visited.add(n);

            System.out.print(n.data + " ");

            List<Node> tr = extractNodes(n);
            Iterator itr = tr.iterator();

            while(itr.hasNext()) {
                Node temp = (Node) itr.next();
                if(!visited.contains(temp))
                    printTreeDepthUtil(temp, visited);
            }
        }

    }

    public List<Node> extractNodes(Node n) {
        List<Node> tr = new ArrayList<>();
        if(n.left != null) {
            tr.add(n.left);
        }
        if(n.right != null) {
            tr.add(n.right);
        }
        return tr;
    }


    public static void main(String[] args) {

        int[] nums = {1,3,6,4,7,8,9};

        KthElementBST kbst = new KthElementBST();

        for(int n: nums) {
            kbst.insertKey(n);
        }

        System.out.println("Tree Traversal by Level:");
        kbst.printTreeByLevel();

        System.out.println();
        System.out.println("Tree Traversal by Depth");
        kbst.printTreeByDepth();

        //System.out.println(kbst.inOrderTraverse(3));


    }
}
