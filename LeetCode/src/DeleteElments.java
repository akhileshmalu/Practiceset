import java.util.List;
import java.util.Stack;

/**
 * @author: Akhilesh Maloo
 * @date: 3/26/18.
 */
public class DeleteElments {

    public static List<Integer> deleteElmsSmallerthanNext(int[] vals, int k) {

        Stack<Integer> st = new Stack<>();
        st.push(vals[0]);

        for(int i = 1; i<vals.length; i++) {
            while(!st.isEmpty() && vals[i] > st.peek() && k > 0) {
                st.pop();
                k--;
            }
            st.push(vals[i]);
        }

        return st;

    }

    public static void main(String[] args) {
        int[] vals = {23, 45, 11, 77, 18};

        System.out.println(deleteElmsSmallerthanNext(vals, 3));
    }
}
