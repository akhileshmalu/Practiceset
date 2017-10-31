import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 10/25/17.
 */
public class LengthOfLongestSubString {

    /**
     * Good SOl
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * Better
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        boolean[] rec = new boolean[256];
        int res = 0, start = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(false == rec[c]) {
                rec[c] = true;
            } else {
                res = Math.max(res, i - start);
                while(s.charAt(start) != c) rec[s.charAt(start++)] = false;
                start++;
            }
        }
        res = Math.max(res, s.length() - start);
        return res;
    }

    public static void main(String[] args) {




    }
}
