/**
 * @author: Akhilesh Maloo
 * @date: 1/27/23.
 */

import java.util.TreeSet;

/**
 *
 *
 * input: s = "abcbabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Longest Substring Without Repeating Characters
 * abcabcdb
 * ans: abcd
 *
 * constraints - small alpha
 *
 * [ 0, 0,1,
 *
 */
public class Solution2 {

    public static void longestSubString(String s) {
        // edge cases;

        int start = 0;
        int end = 0;
        int maxLen = 0;
        int maxStart = 0;
        int[] freq = new int[26];

        while(end < s.length()) {
            if(freq[s.charAt(end) - 'a'] > 0) {
                while(freq[s.charAt(end) - 'a'] != 0) {
                    freq[s.charAt(start)-'a']--;
                    start++;
                }
            }

            freq[s.charAt(end) - 'a']++;
            if(maxLen < end-start+1) {
                maxLen = end-start+1;
                maxStart = start;
            }
            end++;
        }
        System.out.println(maxStart);
        System.out.println(maxLen);
        System.out.println(s.substring(maxStart, maxStart + maxLen));

    }

    public static void main(String[] args) {
        Solution2.longestSubString("abcacbedabiglitmn");

        TreeSet<String> set = new TreeSet<>();
    }
}
