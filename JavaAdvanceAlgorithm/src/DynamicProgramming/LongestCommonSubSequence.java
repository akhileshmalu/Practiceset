package DynamicProgramming;

/**
 * @author: Akhilesh Maloo
 * @date: 10/17/17.
 */
public class LongestCommonSubSequence {

    /**
     *  formula : if characters are same (in both string) then 1 + prev substring (diagonal)
     *           else max of overlap (above or left);
     *
     * Given two strings show longest common subSequence
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "abcdaf";
        String str2 = "acbcf";

        int[][] dp = new int[str2.length()+1][str1.length()+1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(str2.charAt(i-1) == str1.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

        System.out.println(dp[str2.length()][str1.length()]);

    }
}
