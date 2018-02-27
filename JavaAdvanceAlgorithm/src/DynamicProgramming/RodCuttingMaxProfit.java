package DynamicProgramming;

/**
 * @author: Akhilesh Maloo
 * @date: 1/28/18.
 *
 * Mr. Octopus has recently shut down hisfactory and want to sell off his metal rods to a local businessman.
In order to maximize profit, he should sellthe metal of same size and shape. If he sells metal rods of length ,
he receives N x L x metal_price. The remaining smallermetal rods will be thrown away. To cut the metal rods, he needs to pay cost_per_cut for every cut.
What is the maximum amount of money Mr.Octopus can make?
Input Format
First line of input contains cost_per_cut
Second line of input contains metal_price
Third line contains L, the number of rods Mr. Octopus has,followed by L integers in each line representinglength of each rod.
Output Format
Print the result corresponding to the testcase.
Constraints
1 <= metal_price, cost_per_cut <= 1000
1 <= L <= 50
Each element of lenghts will lie in range [1, 10000].
Sample Input#00
1
10
3
26
103
59
Sample Output#00
1770
 */
public class RodCuttingMaxProfit {

    public static int maxProfit(int[] rods, int cost, int price) {

        int maxProfit = Integer.MIN_VALUE;

        int minLenRoad = Integer.MAX_VALUE;

        for(int r: rods)
            minLenRoad = Math.min(minLenRoad, r);

        // if minimum value is more than 50; as per mentioned above
        minLenRoad = Math.min(minLenRoad, 50);

        int[][] dp = new int[rods.length][minLenRoad];

        for(int i = 0; i< rods.length; i++) {
            for(int j = 0; j < minLenRoad; j++) {

                // rod len => j + 1;
                // max profit = Number * Price * Length - cut*Cost
                int n = rods[i] / (j+1);
                int l = (j+1);
                int c = (rods[i] % (j+1) == 0)? n-1 : n;

                dp[i][j] = (n * l * price) - (c * cost);

                if(i != 0) {
                    dp[i][j] += dp[i-1][j];
                }

                maxProfit = Math.max(maxProfit, dp[i][j]);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] r = {26, 103, 59};
        int c = 1;
        int p = 10;

        System.out.println(maxProfit(r,c,p));
    }

}
