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
    public void findPairs(MyNode root, int target) {
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        /*
         dfs one pair to find out if there exist a a pair
         */
        System.out.println(dfsOnePair(root, set, target));


        // dfs for all pairs will generate all possible pairs.
//        dfsForAllPairs(root, set, target, result);

    }

    public void dfsForAllPairs(MyNode root, HashSet<Integer> set, int target, List<List<Integer>> result) {

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


    public boolean dfsOnePair(MyNode root, HashSet<Integer> set, int target) {

        if(root == null)
            return false;

        if(set.contains(target - root.data)) {
            return true;
        }

        set.add(root.data);

        return dfsOnePair(root.left, set, target) || dfsOnePair(root.right, set, target);
    }

    public boolean findTarget(MyNode root, int k) {
        return dfs(root, root,  k);
    }

    public boolean dfs(MyNode root,  MyNode cur, int k){
        if(cur == null)return false;
        return search(root, cur, k - cur.data) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    public boolean search(MyNode root, MyNode cur, int value){
        if(root == null)return false;
        return (root.data == value) && (root != cur)
                || (root.data < value) && search(root.right, cur, value)
                || (root.data > value) && search(root.left, cur, value);
    }



    public static void main(String[] args) {


        Sum2BST sum = new Sum2BST();

        MyNode a = new MyNode(5);
        a.left = new MyNode(3);
        //a.right = new Node(6);
        a.left.left = new MyNode(1);
        a.left.right = new MyNode(4);
        a.right = new MyNode(6);
        a.right.right = new MyNode(8);

        sum.findPairs(a, 9);


    }
}
class MyNode {
    int data;
    MyNode left;
    MyNode right;

    MyNode(int d) {
        this.data = d;
        left = right = null;
    }
}