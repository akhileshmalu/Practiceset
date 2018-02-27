package DynamicProgramming;

/**
 * @author: Akhilesh Maloo
 * @date: 2/21/18.
 */
public class SubSet {

    public static boolean isSubSetExistForSum(int[] nums, int sum) {

        boolean[][] dp = new boolean[nums.length + 1][sum+1];

        for (int i = 0; i <= nums.length ; i++)
            dp[i][0] = true;

        for(int i = 1; i <= sum; i++)
            dp[0][i] = false;

        for (int i = 1; i <= nums.length; i++) {

            for (int j = 1; j <= sum; j++) {

                if(j < nums[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];

            }
        }

        return dp[nums.length][sum];

    }


    public static boolean canDivideArray(int[] nums, int n) {
        int sum = 0;

        for (int num : nums)
            sum += num;

        if(sum % n != 0)
            return false;

        return isSubSetExistForSum(nums, sum / n);
    }


    public static void main(String[] args) {
        int[] nums = {1,2,6, 23, 16};

//        System.out.println(isSubSetExistForSum(nums, 0));
        System.out.println(canDivideArray(nums,3));
    }
}
