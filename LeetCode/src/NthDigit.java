import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: Akhilesh Maloo
 * @date: 10/13/17.
 */
public class NthDigit {
    public static int findNthDigit(int n) {
        int counter = 0;

        for(int i = 1; i <= n ; i++) {
            int k = i;
            String reverse = "";
            while(k != 0) {
                reverse += k % 10;
                k /= 10;
            }

            // reverse the digits and add to index Array
            for(int j = reverse.length()-1; j >= 0 ; j--) {
                counter++;
                if(counter == n){
                    System.out.println(i + " and break " + ((reverse.length()-1) - j));
                    return reverse.charAt(j) - '0';}
            }
        }
        return 0;
    }

    public static int findNthDigit2(int n) {

        long digitLength = 9;    // 9 - 1, 90 - 2, 900 - 3, 9000- 4, 9*10^k -k
        long digCounted = 0;     // total digit counted bit wise
        long numCount = 0;       // total number reached
        int j = 1;              // number of digits ; 1,2,3,4..k from above
        while(digCounted < n) {

            digitLength = ((long)Math.pow(10,j-1) * 9);

            if(digCounted + (digitLength * j) > n) break;

            numCount += digitLength;
            digCounted += digitLength * j;
            j++;

        }

        //54 = 9 + {(100 - 9 digits)/ noOfDigit = 45};
         numCount = numCount + ((n - digCounted)/j);

         int remainder = (int) (n-digCounted) % j;

        if(remainder  > 0) {
            numCount++;        // 54 + 1 = 55;
        } else {
            return (int) numCount % 10;
        }

        // yield reverse digits
        int resultDigit = 0;
        while(remainder <= j) {
            resultDigit = (int) (numCount % 10);
            numCount /= 10;
            remainder++;
        }

        return resultDigit;

    }

    public static void main(String[] args) {
        int a = 100;

        System.out.println(findNthDigit2(a));
        System.out.println(findNthDigit(a));

    }
}
