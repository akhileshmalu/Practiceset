package DynamicProgramming;

/**
 * @author: Akhilesh Maloo
 * @date: 2/22/18.
 */
public class LongestCommonSubString {

    /**
     * formula : if characters are same (in both string) then 1 + prev substring (diagonal)
     *           else 0;
     *
     *
     * @param first
     * @param sec
     * @return
     */
    public static int longestCommonSuString(String first, String sec) {

        int maxLength = Integer.MIN_VALUE;

        int[][] dp = new int[first.length()+1][sec.length()+1];

        for (int i = 0; i <= first.length(); i++) {
            for (int j = 0; j <= sec.length() ; j++) {

                //first empty string
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if(first.charAt(i-1) == sec.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = 0;

                maxLength = Math.max(maxLength, dp[i][j]);

            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        /*
        Longest common substring :  ABCDCF - ZBCDF = BCD
        Longest common sub sequence : ABCDCF - ZBCDF = BCDF
         */

        String first = "ABCDCF", sec = "ZBCDF";

        System.out.println(longestCommonSuString(first, sec));
    }
}
