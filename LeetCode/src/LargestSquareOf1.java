import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 1/23/18.
 */
public class LargestSquareOf1 {

    /**
     *  Logic:
     *
     *  1 0 1 0 1 0
     *  0 0 1 1 1 1
     *  0 0 1 1 1 0
     *  1 0 1 1 1 1
     *
     *
     *  Iterative option will target each of cell as bottom right of a sqaure
     *
     *  1 0
     *  0 0
     *
     * 1) In here first 1 considering bottom right corner to decide the square size will yeild the same value
     * as there is no values in matrix
     *
     * 2) will keep iterating =>
     *      2.1) If bottom right is a 1 then compute max possible square i.e. if all above three neighbours are one then
     *      max value of them + 1 (itself) or If one of them is zero , then min value + 1 (itself)
     * 3) Keep a maxCounter to check maximum value which is our answer
     *
     *
     * @param metrix
     * @return
     */
    public static int largestSqaureFinder(int[][] metrix) {

        int[][] dp = new int[metrix.length][metrix[0].length];
        int max = Integer.MIN_VALUE;
        //assign first row value;

        for(int i =0; i<metrix.length; i++) {
            for (int j = 0; j < metrix[0].length; j++) {
                dp[0][i] = metrix[0][i];
                dp[i][0] = metrix[i][0];
            }
        }



        for(int i =1; i<metrix.length; i++) {
            for(int j = 1; j < metrix[0].length; j++) {

                if(metrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }

        }

        for (int[] dp1: dp) {
            for ( int d:dp1) {
                System.out.print(" "+d + " ");
            }
            System.out.println();
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1}
        };


        System.out.println(largestSqaureFinder(mat));
    }
}
