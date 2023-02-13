package DynamicProgramming.DigitDP;

import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 1/29/23.
 */
public class CountDigitsWithKSum {

    /**
     * given a number n, count nos from [1,n] where sum of digits is equals to target
     *
     *
     * @param n
     * @param target
     * @return
     */
    public int countDigitsWithKSum(int n, int target) {
        String num = String.valueOf(n);
        int len = num.length();
        char[] numArr = num.toCharArray();

        int[][][] dp = new int[len+1][2][9 * (len+1)];
        Arrays.stream(dp).forEach(
                dp1 -> Arrays.stream(dp1).forEach(
                        dp2 -> Arrays.fill(dp2, -1))
        );

        return util(numArr, 0, 1, 0, dp, target);
    }

    int util(char[] numArr, int pos, int tight, int sum, int[][][] dp, int target) {
        if(pos == numArr.length) {
            return (sum == target)? 1 : 0;
        }
        if(dp[pos][tight][sum] != -1) {
            return dp[pos][tight][sum];
        }
        int ans = 0;
        if(tight == 1) {
            for(int i = 0; i <= numArr[pos]-'0'; i++) {
                if(i == numArr[pos]-'0') {
                    //tight
                    ans += util(numArr, pos+1, 1, sum + i, dp, target);

                } else {
                    // no tight
                    ans += util(numArr, pos+1, 0, sum + i, dp, target);
                }
            }

        } else {
            for(int i = 0; i <= 9; i++) {
                ans += util(numArr, pos + 1, 0, sum + i, dp, target);
            }
        }
        return dp[pos][tight][sum] = ans;
    }

    int findLen(StringBuilder s) {
        StringBuilder b = new StringBuilder();
        b.append(s.charAt(0));
        int c = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 ||  s.charAt(i) == s.charAt(i-1)) {
                c++;
            } else {
                if(c > 1) {
                    b.append(String.valueOf(c));
                }
                b.append(s.charAt(i));
                c = 1;
            }
        }
        if(c > 1) b.append(c);
        System.out.println(b);
        return b.length();


    }

    public static void main(String[] args) {
        CountDigitsWithKSum s = new CountDigitsWithKSum();
//        System.out.println(s.countDigitsWithKSum(200, 9));
        System.out.println(s.findLen(new StringBuilder("aaa")));


    }
}
