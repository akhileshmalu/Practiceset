import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: Akhilesh Maloo
 * @date: 10/29/17.
 */
public class LongestValidParentheses {

    /**
     *
     * Best solution as per leetcode time (n) & space(n)
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len < 2)
            return 0;
        int[] counters = new int[len+1];
        int c = 0;
        counters[0] = -1;
        int max = 0;
        int i = 0;
        while(i < len) {
            if ('(' == chars[i]) {
                c = c + 1;
                counters[c] = i;
                i = i +1;
                continue;

            }
            if (c > 0) {
                c = c - 1;
                int m = i - counters[c];
                if(m > max)
                    max = m;
                i = i +1;
                continue;
            }
            counters[0] = i;
            i = i +1;
        }
        return max;

    }

    /**
     * Easy to understand (n) with space 2(n)
     * @param s
     * @return
     */
    public int longestValidParentheses3(String s) {
        boolean valid[] = new boolean[s.length()];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else if (!stack.isEmpty()) {
                valid[stack.pop()] = valid[i] = true;
            }
        }

        return longest(valid);
    }

    /**
     * helper function for above function : to count max consecutive true values in array
     * @param valid
     * @return
     */
    private int longest(boolean[] valid) {
        int max = 0;
        int len = 0;

        for (int i = 0; i < valid.length; i++) {
            if(valid[i]) {
                len++;
            } else {
                len = 0;
            }
            max = Math.max(max, len);
        }

        return max;
    }

    /**
     * Another solution from leet code.
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        Stack<int[]> stack = new Stack<>();
        int result = 0;

        for(int i=0; i<=s.length()-1; i++){
            char c = s.charAt(i);
            if(c=='('){
                int[] a = {i,0};
                stack.push(a);
            }else{
                if(stack.empty()||stack.peek()[1]==1){
                    int[] a = {i,1};
                    stack.push(a);
                }else{
                    stack.pop();
                    int currentLen=0;
                    if(stack.empty()){
                        currentLen = i+1;
                    }else{
                        currentLen = i-stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        LongestValidParentheses lv = new LongestValidParentheses();
        System.out.println(lv.longestValidParentheses2("()(()"));
//        System.out.println(lv.longestValidParentheses3("(()(())"));

    }
}
