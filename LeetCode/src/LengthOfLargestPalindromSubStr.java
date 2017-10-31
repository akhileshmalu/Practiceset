import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 10/26/17.
 */
public class LengthOfLargestPalindromSubStr {

    private int low = 0;
    private int maxLen = 0;
    private char[] c ;

    /**
     * Time analysis (n)^3 : Waste of time
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, s.charAt(0) + "");

        // Building map for char and index position in list.
        HashMap<Character, List<Integer>> links = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {

            if (!links.containsKey(s.charAt(i))) {
                List<Integer> a = new ArrayList<>();
                a.add(i);
                links.put(s.charAt(i), a);
            }
            List<Integer> a = links.get(s.charAt(i));
            a.add(i);
            links.put(s.charAt(i), a);
        }

        int maxLengthPalindrom = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            // removed usage of indexPos function which delivers list of char position accross string
            Iterator itr = links.get(s.charAt(i)).iterator();
            while (itr.hasNext()) {
                int lastIndex = (int) itr.next();
                if (i<lastIndex && isPalindrom(s, i, lastIndex)) {
                    maxLengthPalindrom = Math.max(maxLengthPalindrom, lastIndex - i);
                    map.put(lastIndex - i, s.substring(i, lastIndex + 1));
                }
            }

        }

        return map.get(maxLengthPalindrom);

    }

    public boolean isPalindrom(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public List<Integer> indexPos(String s, int start, char firstChar) {
        List<Integer> ind = new ArrayList<Integer>();
        for (int i = s.length() - 1; i > start; i--) {
            if (s.charAt(i) == firstChar) {
                ind.add(i);
            }
        }
        return ind;
    }

    /**
     * Time analysis (n)^2
     *
     * @param s
     * @return
     */
    public String longPalindromStr2(String s) {

        if (s.length() == 1) return s;

        String largestPalin = s.charAt(0) + "";
        int maxLength = 0;

        for (int i = 1; i < s.length(); i++) {

            // checking on even string palindrom
            int low = i - 1;
            int high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {

                if (maxLength < high - low + 1) {
                    maxLength = high - low + 1;
                    largestPalin = s.substring(low, high + 1);
                }

                low--;
                high++;
            }

            // checking on odd string palindrom
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (maxLength < high - low + 1) {
                    maxLength = high - low + 1;
                    largestPalin = s.substring(low, high + 1);
                }
                low--;
                high++;
            }
        }
        return largestPalin;
    }

    /**
     * Fastest Solution
     * @param s
     * @return
     */
    public  String largestPalindrom3(String s) {

        if (s.length() <= 2) return s;

        c = s.toCharArray();

        for(int i = 0; i< c.length-1; i++) {
            i = getNextIndex(i);
        }

        return s.substring(low, maxLen+low);

    }

    /**
     *
     * @param i
     * @return
     */
    public  int getNextIndex(int i) {
        int left = i, right = i;

        while(right + 1 < c.length && c[right] == c[right+1]) {
            right++;
        }
        int new_right = right;
        while(left >= 0 && right < c.length && (c[left] == c[right])) {
            left--;
            right++;
        }
        if(maxLen < right-left - 1) {
            maxLen = right-left-1;
            low = left+1;
        }
        return new_right;
    }


    public static void main(String[] args) {
        LengthOfLargestPalindromSubStr st = new LengthOfLargestPalindromSubStr();
        String s = "ccc";
        long t = System.currentTimeMillis();
        System.out.println(st.largestPalindrom3(s));
        System.out.println( " in time : "+ (System.currentTimeMillis() -t ));
    }
}
