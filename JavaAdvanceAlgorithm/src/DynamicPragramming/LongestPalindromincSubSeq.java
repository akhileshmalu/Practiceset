package DynamicPragramming;

/**
 * @author: Akhilesh Maloo
 * @date: 10/17/17.
 */
public class LongestPalindromincSubSeq {

    public static void main(String[] args) {
        String str1 = "agbdba";

        int[][] dp = new int[str1.length()][str1.length()];

        for(int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        for(int i = 2; i <= str1.length() ; i++) {   // length of string from 2 to 6
            for(int j = 0; j < str1.length() - i + 1; j++) {     // start forming word of ith length
                int k = i + j -1;
                if(i == 2 && str1.charAt(j) == str1.charAt(k)) {
                    dp[j][k] = 2;
                } else if(str1.charAt(j) == str1.charAt(k)) {
                    dp[j][k] = dp[j+1][k-1]+2;
                } else {
                    dp[j][k] = Math.max(dp[j][k-1],dp[j+1][k]);
                }

            }
        }

        System.out.println(dp[0][str1.length()-1]);
    }
}
