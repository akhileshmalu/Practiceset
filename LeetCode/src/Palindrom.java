import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by akhi on 5/18/17.
 */
public class Palindrom {

    public  Set<Character> map = new HashSet<Character>();

    Palindrom(){
        for(int i = 0 ; i<26 ; i++) {
            map.add((char) (i+'a'));
            map.add((char) (i+'A'));

        }
        for(int i = 48; i<=57; i++) {
            map.add((char) (i));
        }
    }

    public boolean isPalindrome(String s) {
//      s =  s.replaceAll("[^a-zA-Z0-9]+","");
//        s = s.replaceAll("[\\W]","").toLowerCase();

        int start = 0, end = s.length()-1;


        // Method 1:
//        while (start < end) {
//
//            if(s.charAt(start) != s.charAt(end-1)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;

//        Method 2 :
//        if(start >= end || end <= 1) {
//            return true;
//        }
//        if(s.charAt(start) != s.charAt(end-1)) {
//            return false;
//        } else {
//            return isPalindrome(s.substring(start+1,end-1));
//        }

        // Method 3:
        while(start < end ) {
            while(!map.contains(s.charAt(start))) {
                start++;

                if(start == s.length()) {
                    return false;
                }

            }
            while(!map.contains(s.charAt(end))) {
                end--;
                if(end < 0) {
                    return false;
                }
            }

            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

    public static void main(String[] args) {
        Palindrom ex = new Palindrom();
        System.out.println(ex.isPalindrome("a."));

    }

}
