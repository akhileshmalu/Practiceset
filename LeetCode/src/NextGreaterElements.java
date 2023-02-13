import java.util.Stack;

/**
 * @author: Akhilesh Maloo
 * @date: 3/26/18.
 */
public class NextGreaterElements {

    public static void printNextGreaterElem(int[] nums) {

        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);
        for(int i = 1; i<nums.length; i++) {
            while (!st.isEmpty() && nums[i] > st.peek()) {
                System.out.println(st.pop() + " --> " + nums[i]);
            }
            st.push(nums[i]);
        }

        while(!st.isEmpty()) {
            System.out.println(st.pop() + " --> -1 ");
        }
    }

    public static void main(String[] args) {

        int[] val = {13, 11, 7, 5};
        printNextGreaterElem(val);
    }
}
