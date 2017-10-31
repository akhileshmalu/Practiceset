import java.util.Stack;

/**
 * @author: Akhilesh Maloo
 * @date: 10/29/17.
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        char[] braces = s.toCharArray();

        for (char c : braces) {
            if (c == '(')
                st.push(c);
            else if (st.peek() == '(') {
                st2.push(st.pop());
                st2.push(c);
            } else {
                if (st2.size() > 1)
                    break;
            }
        }
        return st2.size();

    }

    public static void main(String[] args) {

        System.out.println(longestValidParentheses("(()"));

    }
}
