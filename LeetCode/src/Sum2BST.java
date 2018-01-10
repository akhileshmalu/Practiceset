import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 11/22/17.
 */
public class Sum2BST {

    /**
     *  O(n)
     * @param root
     * @param target
     */
    public void findPairs(Node root, int target) {
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        /*
         dfs one pair to find out if there exist a a pair
         */
        System.out.println(dfsOnePair(root, set, target));


        // dfs for all pairs will generate all possible pairs.
//        dfsForAllPairs(root, set, target, result);

    }

    public void dfsForAllPairs(Node root, HashSet<Integer> set, int target, List<List<Integer>> result) {

        if(root == null)
            return;

        if(set.contains(target - root.data)) {
            System.out.println(root.data + " " + (target - root.data));
            List<Integer> temp = Arrays.asList(root.data, (target - root.data));
            result.add(temp);
        }

        set.add(root.data);

        dfsForAllPairs(root.left, set, target, result);
        dfsForAllPairs(root.right, set, target, result);
    }


    public boolean dfsOnePair(Node root, HashSet<Integer> set, int target) {

        if(root == null)
            return false;

        if(set.contains(target - root.data)) {
            return true;
        }

        set.add(root.data);

        return dfsOnePair(root.left, set, target) || dfsOnePair(root.right, set, target);
    }

    public boolean findTarget(Node root, int k) {
        return dfs(root, root,  k);
    }

    public boolean dfs(Node root,  Node cur, int k){
        if(cur == null)return false;
        return search(root, cur, k - cur.data) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    public boolean search(Node root, Node cur, int value){
        if(root == null)return false;
        return (root.data == value) && (root != cur)
                || (root.data < value) && search(root.right, cur, value)
                || (root.data > value) && search(root.left, cur, value);
    }


    public static void main(String[] args) {


        Sum2BST sum = new Sum2BST();

        Node a = new Node(5);
        a.left = new Node(3);
        //a.right = new Node(6);
        a.left.left = new Node(1);
        a.left.right = new Node(4);
        a.right = new Node(6);
        a.right.right = new Node(8);

        sum.findPairs(a, 9);


    }
}
