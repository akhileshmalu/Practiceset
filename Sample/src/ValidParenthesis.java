import java.util.Stack;

/**
 * Created by akhi on 5/19/17.
 */
public class ValidParenthesis {

    //Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

//    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


    public boolean isValid(String s) {
    Stack<Character> st = new Stack<Character>();
        int start = 0;
        int count = 0;
//        int end = s.length()-1;
        while(start < s.length()) {
            if (s.charAt(start) == '(' || s.charAt(start) == '{' || s.charAt(start) == '[') {
                st.push(s.charAt(start));
                count++;
            } else if (s.charAt(start) == ')' || s.charAt(start) == '}' || s.charAt(start) == ']') {
                int add = s.charAt(start)== ')' ? 1:2;
                if(st.empty() && start < s.length()) return false;
                char ch = st.peek();
                if (ch != (char)(s.charAt(start)-add) ) {
                    return false;
                } else {
                    ch = st.pop();
                    count--;
                }
            }
            start++;
        }
        return count == 0;

    }

    public static void main(String[] args) {
    ValidParenthesis ex =new ValidParenthesis();
        System.out.println(ex.isValid("(){}"));

    }
}
