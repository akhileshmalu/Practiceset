/**
 * @author: Akhilesh Maloo
 * @date: 10/21/17.
 */
public class Finobacci {

    static long[] mem;

    /**
     * driver for memoization table
     *
     * @param n
     * @return
     */
    public static long fibo(int n) {
        // we can further optimize space of mem table by reducing its size to n-2 as we need not to save 0th, 1th value
        long[] mem = new long[n + 1];
        return fibonacciN(mem,n);
    }

    /**
     * Time complexity (n) space (n)
     * calculate fibonacci Nth digit
     *
     * @param mem
     * @param n
     * @return
     */
    public static long fibonacciN(long[] mem, int n) {

        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (mem[n] != 0)
            return mem[n];
        else {
            mem[n] = fibonacciN(mem, n - 1) + fibonacciN(mem, n - 2);
            return mem[n];
        }

    }

    /**
     * Time complexity (n) space (1)
     * Iterative Function
     *
     * @param num
     */
    public static int fibonacci(int num) {
        int a = 0, b = 1, c = 0;
        if (num == 0)
            return a;

        for (int i = 2; i <= num; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    /**
     * Metrix Power used Function
     * Time complexity (n) space (1)
     * Explanation:
     * {
     * {1, 1} = {fn+1, fn}
     * {1, 0} = {fn, fn-1}
     * }
     * <p>
     * If you multiply above metrix n times you will get Fn+1 at (0,0) index
     *
     * @param num
     */
    public static int fibonacciWithMetrics(int num) {

        if (num == 0)
            return 0;

        int[][] F = {{1, 1}, {1, 0}};

        //  below power function will run for Log n times hence time complexity becomes Log n
        powerInLog(F, num-1);

        //  below power function will run for N-1 times hence time complexity becomes n
        // power(F, num-1);

        return F[0][0];
    }


    private static void power(int[][] F, int num) {
        int[][] M = {{1, 1}, {1, 0}};
        for (int i = 2; i <= num; i++) {
            multiply(F, M);
        }
    }

    /**
     * We can use PowerInLog function to reduce time complexity to Log n
     *
     * @param F
     * @param n
     */
    static void powerInLog(int F[][], int n)
    {
        if( n == 0 || n == 1)
            return;
        int M[][] = new int[][]{{1,1},{1,0}};

        powerInLog(F, n/2);
        multiply(F, F);

        if (n%2 != 0)
            multiply(F, M);
    }

    /**
     * helper function to multiply 2 metrics with constant dimentions
     *
     * @param F
     * @param M
     */
    private static void multiply(int[][] F, int[][] M) {

        int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    /**
     *
     * Time complexity in Log n
     * k = (n == even)? n / 2 : (n+1)/2;
     * <p>
     * fib(n) = (n == even)? [2*F(k-1) + F(k)]*F(k)] : F(k)*F(k) + F(k-1)*F(k-1);
     *
     * @param n
     * @return
     */
    public static long fibInLog(int n) {

        // Base cases
        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return (mem[n] = 1);

        // If fib(n) is already computed
        if (mem[n] != 0)
            return mem[n];

        int k = (n & 1) == 1? (n + 1) / 2
                : n / 2;

        // Applyting above formula [Note value
        // n&1 is 1 if n is odd, else 0.
        mem[n] = (n & 1) == 1? (fibInLog(k) * fibInLog(k) +
                fibInLog(k - 1) * fibInLog(k - 1))
                : (2 * fibInLog(k - 1) + fibInLog(k))
                * fibInLog(k);

        return mem[n];

    }

    static int power2(int base, int pow, Integer[] dp) {
        if(pow == 0) return 1;
        if(dp[pow] != null) {
            return dp[pow];
        }
        int res = power2(base, pow/2, dp) * power2(base, pow/2, dp);
        if(pow % 2 == 1) {
            res *= base;
        }
        dp[pow] = res;
        return res;
    }

    static int power2(int base, int pow) {
        int res = 1;
        while(pow > 0) {
            res *= base * base;
            if(pow % 2 == 1) {
                res *= base;
            }
            pow = pow/2;
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 12;
        mem = new long[n+1];
//        System.out.println(fibonacciWithMetrics(n));
        System.out.println(power2(3, 10));
    }


}
