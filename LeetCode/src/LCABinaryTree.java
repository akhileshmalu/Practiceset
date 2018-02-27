import java.util.HashSet;

/**
 * @author: Akhilesh Maloo
 * @date: 2/21/18.
 */
public class LCABinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int v) {
            data = v;
        }
        public String toString() {
            return data+"";
        }
    }

    public void findLCA(Node root, int f, int s) {
        HashSet<Node> mark = new HashSet<>();
        System.out.println(dfs(root, f, s));
    }

    public Node dfs(Node r, int f, int s) {

        if(r == null)
            return null;

        if(r.data == f || r.data == s)
            return r;

        Node left = dfs(r.left, f,s);
        Node right = dfs(r.right, f,s);

        if(left != null && right != null)
            return r;

        return (left != null)? left : right;
    }



    public static void main(String[] args) {
        LCABinaryTree lca = new LCABinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        lca.findLCA(root,2,5);
    }

}
