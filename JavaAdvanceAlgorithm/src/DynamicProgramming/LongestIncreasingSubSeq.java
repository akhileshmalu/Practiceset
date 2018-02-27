package DynamicProgramming;

/**
 * @author: Akhilesh Maloo
 * @date: 1/14/18.
 *  {3, 10, 2, 5 , 20} => 3 -> {3, 10, 20}
 *
 */
public class LongestIncreasingSubSeq {

    public static int getLongestIncreasingSubSeq(int[] nums) {

        int[][] dp = new int[nums.length+1][nums.length+1];

//        for(int i = 0; i< nums.length; i++) {
//            dp[0][i] = 1;
//        }

        for(int i = 1; i< nums.length; i++) {
            for(int j = 1; j < nums.length; j++) {

            }
        }

        return 0;
    }

}
