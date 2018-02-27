/**
 * @author: Akhilesh Maloo
 * @date: 2/9/18.
 */
public class NearestPalindromNum {

    /**
     * Time limit Exceeded solution
     * @param n
     * @return
     */
    public String nearestPalindromic(String n) {
        if(n == null)
            return "0";

        long val = Long.parseLong(n);
        long i = 1;
        while(true) {
            if(isPalindrom((val-i)+""))
                return (val-i)+ "";

            if(isPalindrom((val+i)+""))
                return (val+i)+"";

            i++;
        }

    }

    public boolean isPalindrom(String s) {
        if(s.length() == 1)
            return true;

        int i = 0, j = s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }


}
