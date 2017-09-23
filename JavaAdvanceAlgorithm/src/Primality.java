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

    public static void main(String[] args) {

        int n = 16;
        System.out.println("Number "+ n + " is prime? " + primality(n));
    }
}
