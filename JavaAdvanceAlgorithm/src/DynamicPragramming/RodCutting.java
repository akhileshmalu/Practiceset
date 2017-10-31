package DynamicPragramming;

/**
 * @author: Akhilesh Maloo
 * @date: 10/17/17.
 */
public class RodCutting {

    public static void main(String[] args) {

        int lengthOfRod = 5;

        int[] measure = {1,2,3,4};
        int[] price = {2,5,7,8};


        int[][] dp = new int[measure.length][lengthOfRod+1];

        for(int i = 0; i<= lengthOfRod; i++) {
            dp[0][i] = price[0]*i;
        }

        for(int i = 1; i< measure.length; i++) {
            for (int j = 0; j <= lengthOfRod; j++) {
                if( j < i) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], (dp[i][j-i] + price[i-1]));
                }
            }
        }
         System.out.println(dp[measure.length-1][lengthOfRod]);


    }
}
