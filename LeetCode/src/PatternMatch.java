import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Akhilesh Maloo
 * @date: 2/20/18.
 */
public class PatternMatch {
    public static boolean match(String str, String pattern) {

        // 1. create a failure array of pattern string
        int[] failure = new int[pattern.length()];
        failure[0] = 0;
        for (int i = 0, j = 1; j < pattern.length();) {

            if(pattern.charAt(i) == pattern.charAt(j)) {
                failure[j] = i+1;
                i++;
                j++;
            } else {
                int k = i-1;
                while(k >= 0 && pattern.charAt(k) != pattern.charAt(j)) {
                    k--;
                }
                failure[j] = k+1;
                i = (k == -1)? 0 : k;
                j++;
            }
        }

        Arrays.stream(failure).forEach(System.out::print);

        //compare str with pattern string and yeild result

        int i = 0, j = 0;
        while (i < str.length() && j < pattern.length()) {

            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if(j!=0){
                    j = failure[j-1];
                }else{
                    i++;
                }
            }
        }

        return (j == pattern.length());
    }

    public static void main(String[] args) {
        String st = "AAAABACADAB";
        System.out.println(match(st,"ADAB"));
    }
}
