import java.util.*;

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


    public String longestPalindrome2(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        Map<Character, List<Integer>> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i<arr.length; i++) {
            List<Integer> indices = map.get(arr[i]);
            if(indices == null) {
                indices = new ArrayList<>();
            }
            indices.add(i);
            map.put(arr[i], indices);
        }

        int maxLength = 0;
        String maxPalindrom = "";
        for(List<Integer> list: map.values()) {
            if(list != null && list.size() > 1) {
                for(int i = 0; i < list.size()-1; i++) {
                    for(int lastStr = list.size()-1; lastStr > 0; lastStr--) {
                        if(palindrom(arr, list.get(i), list.get(lastStr)) && (list.get(lastStr) - list.get(i)) > maxLength) {
                            maxLength = list.get(lastStr) - list.get(i);
                            maxPalindrom = s.substring(list.get(i), list.get(lastStr)+1);
                            break;
                        }
                    }
                    System.out.println(maxPalindrom);

                }
            }
        }

        return maxLength == 0 ? s.charAt(0) + "" :maxPalindrom;
    }

    private boolean palindrom(char[] arr, int start, int end) {
        for(int i = start, j = end; i <= j; i++,j--) {
            if(arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LengthOfLargestPalindromSubStr st = new LengthOfLargestPalindromSubStr();
        String s = "ccc";
        long t = System.currentTimeMillis();
//        System.out.println(st.largestPalindrom3(s));
        System.out.println(st.longestPalindrome2("abacab"));
        System.out.println( " in time : "+ (System.currentTimeMillis() -t ));
    }
}
