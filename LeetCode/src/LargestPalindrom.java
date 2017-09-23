import java.util.*;

/**
 * Created by akhi on 6/17/17.
 */
public class LargestPalindrom {
    public long[] maxLimits = new long[]{
        10,100,1000,10000,100000,10000000, 100000000
    };

    public int largestPalindrome(int n) {
        int upperLimit = (int) Math.pow(10,n)-1;
        int lowerLimit = (int) Math.pow(10,n-1);
        int maxPalindrom = 0;

        for(int i = upperLimit ; i > upperLimit/10 ; i--) {
            if(i % 10 == 0) {
                i--;
            }
            for (int j = i ; j > lowerLimit; j--) {
                if(j % 10 == 0) {
                    j--;
                }
                if(isPalindromNum(i*j)) {
                    if(maxPalindrom < i*j) {
                        maxPalindrom = i*j;
                    }
                }
            }
        }
        return maxPalindrom % 1337;
    }

    public boolean isPalindromNum(int x) {
        if(x < 0 || (x!=0 && x%10 == 0)) {
            return false;
        }
        int out = 0;
        while(x > out) {
            out = (10*out)+(x%10);
            x = x/10;
        }
        return x == out || x == out/10;
    }

    public int largestPalindrome2(int n) {
        if (n==1) return 9;

        int max=(int)Math.pow(10, n)-1;

        for (int v=max-1;v>max/10;v--) {
            // palindromic value
            long u=Long.valueOf(v+new StringBuilder().append(v).reverse().toString());
            // compare and check with second product number
            for (long x = max; x*x>=u; x--)
                if (u % x == 0)
                    return (int) (u % 1337);

        }
        return 0;
    }

    // fastest 173 ms
    public int largestPalindrome3(int n) {
        if (n == 1) {
            return 9;
        }

        int high = (int) Math.pow(10, n) - 1;
        int low = (int) Math.pow(10, n - 1);
        for (int i = high; i >= low; i--) {
            long palindrome = PalindromNum(i);
            System.out.print(palindrome+" hi: ");
            int hi = high;
            while (hi % 11 != 0) {
                hi--;
            }
            System.out.println(hi+" j : ");
            for (int j = hi; j >= low; j -= 11) {
                if (palindrome / j > high) {
                    break;
                }
                if (palindrome % j == 0) {
                     System.out.print(j+" ");
                    return (int) (palindrome % 1337);
                }
            }
        }
        return -1;
    }


    public long PalindromNum(int x) {
        long out = x;
        while(x > 0) {
            out = (10*out)+(x%10);
            x = x/10;
        }
        return out;
    }

    public static void main(String[] args) {
        LargestPalindrom palindrom = new LargestPalindrom();
        System.out.println(palindrom.largestPalindrome3(2));


    }
}
