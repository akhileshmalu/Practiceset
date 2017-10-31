package DynamicPragramming;

import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 10/17/17.
 */
public class MinimumCostPath {

    /** Only direction available to move is right or down
     *
     * @param args
     */
    public static void main(String[] args) {

        int[][] paths = { {1,3,5,8}, {4,2,1,7}, {4,3,2,3} };
        int[][] dp = new int[paths.length][paths[0].length];

        dp[0][0] = paths[0][0];

        //initial uni directions set ; use first loop condition with maximum of m or n
        for(int i = 1; i < dp[0].length; i++) {
            if(i < dp[0].length)
            dp[0][i] = paths[0][i] + dp[0][i-1];
            if(i < dp.length)
                dp[i][0] = paths[i][0] + dp[i-1][0];
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + paths[i][j];
            }
        }

        System.out.println("Minimum path is "+ dp[dp.length-1][dp[0].length-1]);
    }
}
