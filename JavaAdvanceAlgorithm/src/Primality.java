import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 9/14/17.
 */
public class Primality {

    public static boolean checkResult(int n)  {

        if (n < 2) return false;

        for (int i = 2; i < n; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;

    }

    public static boolean primality(int n) {
        if(n<2) return false;
        for(int i = 3; (i*i) <= n; i = i+2) {
            if(n%i == 0) {
                return false;
            }
        }
        return (n%2 != 0);
    }

    public static boolean isPrime(int n) {

        //corner conditions.

        if(n < 2) return false;
        if(n == 2 || n == 3 ) return true;
        if(n%2 == 0 || n%3 == 0) return false;

        for(int i = 5; (i*i) <= n; i=i+6) {
            if((n%i == 0) || (n % (i+2) == 0)) {
                return false;
            }
        }
        return true;

    }

    /**
     * ALGORITHM takes atleast O(n2) so it is not time efficient at all though it is space efficient
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        // initial 2 & 3 and after that
        int countPrimes = (n > 3)? 2 : (n <= 2)? 0 : 1;

        for(int i = 5; i < n ; i += 2) {
            if(isPrime(i)) {
                countPrimes++;
            }
        }
        return countPrimes;
    }

    /**
     * Find count of prime numbers less than n; Time efficient but not space
     * @param n
     * @return
     */
    public static int countPrimes2(int n) {
        // initial 2 & 3 and after that
        boolean checkedBits[] = new boolean[n];

        //considering all odd numbers upto n will be prime;
        int countPrimes = n/2;

        // for every odd number removing any multiple of odd composite number;
        for(int i = 3; i*i < n; i += 2) {

            // if an odd number was covered in previous composite number ; just ignore the step
            if(checkedBits[i])
                continue;

            // checking all odd composite numbers; add removing that from total odd nums considered as prime
            for(int j= i*i; j< n; j += 2*i) {
                if(!checkedBits[j]) {
                    countPrimes--;
                    checkedBits[j] = true;
                }


            }
        }

        return countPrimes;
    }

    public static void main(String[] args) {

        int n = 1000;
        System.out.println("Number "+ n + " is prime? " + primality(n));
        System.out.println("Total number of prime number less than " + n + "is: " +countPrimes2(n));
    }
}
