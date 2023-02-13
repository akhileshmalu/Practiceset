import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 2/27/18.
 */
public class MinWindowString {

    public String minWindow(String s, String t) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0) counter--;
            map[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                if (map[c2] >= 0) counter++;
                map[c2]++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public String minWindow2(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if(sLen < tLen)
            return "";

        int[] schars = new int[128];

        int i = 0, j = tLen-1;
        String subStr = "";
        int minStart = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;

        for(int k = 0; k < tLen; k++) {
            schars[s.charAt(k) - 'A']++;
        }

         do {
            if((j-i+1) >= tLen && tExists(schars.clone(),t)) {
                if((j-i+1) <= minLength) {
                    minLength = (j-i)+1;
                    minStart = i;
                }

                if(i < sLen) {
                    schars[s.charAt(i)-'A']--;
                }
                i++;
            } else {
                j++;
                if(j < sLen){
                    schars[s.charAt(j)-'A']++;
                }

            }
        } while(i <= sLen && j <= sLen);
        return minStart == Integer.MIN_VALUE? "" : s.substring(minStart, minStart + minLength);
    }

    private boolean tExists(int[] arr, String t) {
        for(int i = 0; i < t.length(); i++) {
            if(arr[t.charAt(i)-'A'] <= 0) {
                return false;
            }
            arr[t.charAt(i)-'A']--;
        }
        return true;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            end++;

            while (counter > k) {
                final char c2 = s.charAt(start);
                if (map[c2] == 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            end++;

            while (counter > 2) {
                final char c2 = s.charAt(start);
                if (map[c2] == 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0) counter++;
            map[c1]++;
            end++;

            while (counter > 0) {
                final char c2 = s.charAt(start);
                if (map[c2] > 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstringWithoutRepeat(String s) {



        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0) counter++;
            map[c1]++;
            end++;

            while (counter > 0) {
                final char c2 = s.charAt(start);
                if (map[c2] > 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        for(; i> 0; i--) {
            if(nums[i] > nums[i-1]) {
                int temp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        Arrays.sort(nums, i , nums.length);
    }

    public static void main(String[] args) {
        MinWindowString min = new MinWindowString();

//        int[] nuj = {5,4,2,3,1};
//        min.nextPermutation(nuj);
//        System.out.println();

//        System.out.println(min.minWindow("bbaa", "aba"));
//        System.out.println(min.minWindow2("ADOBECODEBANC", "ABC"));
//        System.out.println(min.minWindow2("a", "a"));
//        System.out.println(min.minWindow2("a", "b"));
        

    }
}
