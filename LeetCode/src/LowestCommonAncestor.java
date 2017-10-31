import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: Akhilesh Maloo
 * @date: 10/29/17.
 */
public class LowestCommonAncestor extends RedBlackTree {


    public Node find(int val) {
        Node curr = root;

        while(curr != null) {

            if(curr.data == val)
                return curr;

            if(curr.data < val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }

        }
        return root;
    }

    public LinkedList<Integer> track(Node n) {

        LinkedList<Integer> st = new LinkedList<>();
        Node curr = root;

        while(curr != n) {
            st.add(curr.data);
            if(curr.data > n.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return st;
    }


    public int lowestCommonAncestors(int l, int m) {

        LinkedList<Integer> st1, st2;

        st1 = track(find(l));
        st2 = track(find(m));
        int a = 0,b = 0, last = 0;

        while(!st1.isEmpty()) {
             a = st1.poll();
             b = st2.poll();

            if(a != b) {
                return last;
            }
            last = a;
        }

        return b;

    }

    public static void main(String[] args) {

       LowestCommonAncestor bst = new LowestCommonAncestor();

        int[] a = {1,2,3,4,5,6,7, 8, 9, 10, 11, 12, 13};

        for(int v : a) {
            bst.insertKey(v);
        }

        System.out.println(bst.lowestCommonAncestors(1,7));

    }

}
