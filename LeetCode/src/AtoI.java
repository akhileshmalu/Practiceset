import java.util.HashMap;
import java.util.Map;

/**
 * Created by akhi on 6/9/17.
 */
public class AtoI {
    public Map<Character, Integer> iVal = new HashMap<Character,Integer>() {{
        put('0',0);
        put('1',1);
        put('2',2);
        put('3',3);
        put('4',4);
        put('5',5);
        put('6',6);
        put('7',7);
        put('8',8);
        put('9',9);
    }};

    public int myAtoi(String str) {

        str = str.trim();

        char[] a = str.toCharArray();
        long i = 0, sign = 1;
        int len = a.length;

        for (int j = 0; j< len && iVal.containsKey(a[j]); j++) {

            if(a[0] == '-') {
                sign *= -1;
                continue;
            }

            //            if(a[j] == '-' && j == 0) {
//                sign *= -1;
//            } else if(a[j] == '+' && j == 0) {
//                sign *= 1;
//            } else
            if(iVal.containsKey(a[j])) {
                i = (i*10) + iVal.get(a[j]);

                if(i*sign >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (i*sign <= Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            } else {
//                i = 0;
                break;
            }
        }

        return (int)(i*sign);

    }

    public int atoi(String str) {
        char[] a = str.toCharArray();

        long i = 0, sign = 1;
        int j = 0;
        //str = str.trim();

        int len = a.length;
        if (len > 0) {
            while(a[j] == ' ') {
                j++;
            }
            if (a[j] == '-') {
                sign = -1;
                j++;
            } else if (a[j] == '+') {
                sign = 1;
                j++;
            }
        } else {
            return 0;
        }

        while (j< len && a[j] >= '0' && a[j] <= '9' ) {
            i = (i*10) + (a[j]-'0');
            if(i*sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (i*sign <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            j++;
        }
        return (int)(i*sign);
    }

    public static void main(String[] args) {
        AtoI a = new AtoI();
        System.out.println(a.atoi("     +004500"));
    }
}
