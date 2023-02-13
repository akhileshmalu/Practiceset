package slidingWindow;

/**
 * @author: Akhilesh Maloo
 * @date: 1/28/23.
 */
public class DynamicSizedSlidingWindow {

    /**
     *        computation: calculation to help achieve the criteria
     *      * criteria : what triggers resizing
     *      * return : final output
     *      * windowType = dynamic
     * @return
     */
    public static void slidingWindowTemplate() {
        // define output var
        // define computation helper vars

        // iterate on given DS


            // compute
            // check if criteria is triggered and try to resize the window
                // if returning min of something = keep track of min while resizing (reducing the window)
                // keep resizing till criteria is breached again;

            // if returning max of something, keep of track of max here. essentially it will give result from previous iteration to criteria trigger.

        // return output or produce result from output.
    }

    /**
     * Given an array of positive integers nums and a positive integer target, return the minimal length of a
     * subarray
     *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     *
     *  Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     * https://leetcode.com/problems/minimum-size-subarray-sum/description/
     *
     * computation: sum
     * criteria : >= target (7)
     * return : minSum
     * windowType = dynamic
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for(int winEnd = 0, winStart = 0; winEnd < nums.length; winEnd++) {
            // computation
            sum += nums[winEnd];

            // met criteria -> then try to make it better;
            while(sum >= target) {
                minLen = Math.min(minLen, winEnd - winStart + 1); // fetch result
                sum -= nums[winStart++]; // try to make it better by resizing window
            }
        }

        return minLen == Integer.MAX_VALUE? 0 : minLen;
    }


    /**
     * Longest Repeating Character Replacement
     * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
     *
     * Return the length of the longest substring containing the same letter you can get after performing the above operations.
     *
     * Input: s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace the two 'A's with two 'B's or vice versa.
     *
     * Input: s = "AABABBA", k = 1
     * Output: 4
     * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
     * The substring "BBBB" has the longest repeating letters, which is 4.
     *
     * https://leetcode.com/problems/longest-repeating-character-replacement/
     *
     * computation: same letters string
     * criteria : distinct letter <= k
     * return : longest Length
     * windowType = dynamic with aux DS
     *
     * @param s
     * @param k
     * @return
     */
    public static  int characterReplacement(String s, int k) {
        char[] sa = s.toCharArray();
        int maxLen = Integer.MIN_VALUE;
        int maxCharCount = 0;
        int[] freq = new int[26];
        for(int winEnd = 0, winStart = 0; winEnd < sa.length; winEnd++) {
            //computation
            maxCharCount = Math.max(maxCharCount, ++freq[sa[winEnd] - 'A']);

            //criteria -> cant have more than k+1 distinct chars => total len - highest repeating char = conversion operation chars
            while(winEnd - winStart + 1 - maxCharCount > k) {
//                // NOTE: its kind of optimization to not update maxCharCount since maxlength would only be increased when we extend the winEnd counter.
                // otherwise, in simple way , we should also calculate the max char count from freq array at every loop iteration ; i.e. give us current state of criteria conflict. which would make this as O(26n) but still as linear time complexity
                freq[sa[winStart++] - 'A']--;
            }

            maxLen = Math.max(maxLen, winEnd - winStart + 1);

        }

        return maxLen;

    }


    /**
     * Given a string s, find the length of the longest
     * substring
     *  without repeating characters.
     *
     *  Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * windowType = dynamic
     * computation: freq of chars to work on criteria
     * criteria : without repeating chars
     * return : longest Len
     *
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        char[] sa = s.toCharArray();
        int[] freq = new int[256];
        int maxLen = 0;
        for(int winEnd = 0, winStart = 0; winEnd < sa.length; winEnd++) {
            //computation
            freq[sa[winEnd]]++;

            //criteria match and try to make it better
            while(freq[sa[winEnd]] > 1) {
                freq[sa[winStart++]]--;
            }

            // calculate return val
            maxLen = Math.max(maxLen, winEnd - winStart + 1);
        }

        return maxLen;

    }


    /**
     * Given two strings s and t of lengths m and n respectively, return the minimum window
     * substring
     *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
     *
     * The testcases will be generated such that the answer is unique.
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     *
     * window type: dynamic with DS
     * computation: freq count
     * criteria: all t chars should be available;
     * optimize: if more than criteria , shrink the window
     * return: minWindow (minLen, start of string)
     *
     * A - 1
     * B - 1
     * C - 1
     * count = 3;
     *
     * A - 0, c = 2
     *
     * N -1
     * E, O, D - 0
     * B - 1 = c = 1
     * C - 0 = c = 0
     *
     * A - 0, c = 0,
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {

        int[] freq = new int[128];
        int minLen = Integer.MAX_VALUE;
        int subStrStart = 0;
        int count = 0;

        for(char ch : t.toCharArray()) {
            freq[ch]++;
            count++;
        }
        char[] sa = s.toCharArray();
        for(int winEnd = 0, winStart = 0; winEnd < sa.length; winEnd++) {
            //computation
            freq[sa[winEnd]]--;
            if(freq[sa[winEnd]] >= 0) {
                count--;
            }

            while(count == 0) {
                if(winEnd - winStart + 1 < minLen) {
                    minLen = winEnd - winStart + 1;
                    subStrStart = winStart;
                }

                freq[sa[winStart]]++;
                if(freq[sa[winStart]] > 0) {
                    count++;
                }
                winStart++;
            }
        }

        return s.substring(subStrStart, subStrStart+minLen);
    }

    public static void main(String[] args) {
//        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
//        System.out.println(characterReplacement("AABABBA", 1));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }

}
