/**
 * @author: Akhilesh Maloo
 * @date: 10/21/17.
 */
public class Finobacci {

    /**
     * driver for memoization table
     * @param n
     * @return
     */
    public static long fibo(int n) {
        // we can further optimize space of mem table by reducing its size to n-2 as we need not to save 0th, 1th value
        long[] mem = new long[n+1];
        return fibonacciN(mem,n);
    }

    /**
     * calculate fibonacci Nth digit
     * @param mem
     * @param n
     * @return
     */
    public static long fibonacciN(long[] mem, int n) {

        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else if(mem[n] != 0)
            return mem[n];
        else {
            mem[n] = fibonacciN(mem,n-1) + fibonacciN(mem,n-2);
            return mem[n];
        }

    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibo(n));
    }


}
