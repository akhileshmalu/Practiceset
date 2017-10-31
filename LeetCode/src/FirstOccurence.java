/**
 * @author: Akhilesh Maloo
 * @date: 10/23/17.
 */
public class FirstOccurence {

    static boolean checkString(String s1, String s2,  int start) {

        for(int j = start, k = 0; k < s2.length(); j++, k++) {
            if(s2.charAt(k) == '*') {
                k++;
                j++;
            }
            if(s1.charAt(j) != s2.charAt(k))
                return false;
        }
        return true;
    }
    static int firstOccurrence(String s, String x) {

        int k = 0;

        for(int i = 0; i < ( s.length() - x.length() + 1); i++) {
            if(checkString(s, x, i))
                return i;
        }
        return -1;

    }

    /**
     * Standard Hacker Rank StdIn StdOut Functions.
     *
     * @param args
     */
    public static void main(String[] args) {

        /*
        int[] p = {1, 3, 2};
        System.out.println(FlowerBloom(p, 1));
        */

        System.out.println(firstOccurrence("xabcdey","ab*d*y"));



    }
}
