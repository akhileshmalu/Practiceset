package DynamicProgramming;

/**
 * @author: Akhilesh Maloo
 * @date: 2/26/18.
 */
public class RegexMatching {

    public static boolean match(char[] text, char[] pattern) {

        boolean[][] dp = new boolean[text.length+1][pattern.length+1];

        dp[0][0] = true;

        //set for empty text
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }

        //set initial matrix for dp pattern
        for (int i = 1; i < dp[0].length; i++) {

            // if there exist a * to handle ; ex: a*b*c* can match to an empty string having 0 counter of all
            if(pattern[i-1] == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }


        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(text[i-1] == pattern[j-1] || pattern[j-1] == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(pattern[j-1] == '*') {
                    // *  - zero count of character hence check string before 2 step
                                // * - 1+ count so check if previous character is match or any match char
                    dp[i][j] = dp[i][j-2] ||
                            ((text[i-1] == pattern[j-2] || pattern[j-2] == '.')? dp[i-1][j] : false);

                } else
                    dp[i][j] = false;
            }
        }

        /*
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        */

        return dp[text.length][pattern.length];


    }

    public static void main(String[] args) {
        String text = "aaa";
        String pattern = "a*";


        System.out.println(match(text.toCharArray(), pattern.toCharArray()));

    }
}
