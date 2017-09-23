import java.util.Arrays;
import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 9/20/17.
 */
public class PartitionSum {


    /**
     * @purpose This method ascertain if a group can be divided in k equal sub sets.
     *
     * @analysis       Time O( n * (sum/k) ) where n is size of list.
     * @analysis       Space O(sum/k) where sum is total of all elements
     *
     * @param list Number List
     * @param k number of partition
     * @return boolean
     */
    public static boolean canPartition(List<Integer> list, int k) {

        if (list == null || list.size() == 0)
            return true;

        int sum = 0;

        for (int n : list) sum += n;

        if (sum % k != 0) return false;     // check if equal partition can be made

        sum /= k;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 0; i < list.size(); ++i) {
            for (int j = sum; j >= list.get(i); --j)
                dp[j] = dp[j] || dp[j - list.get(i)];
        }
        return dp[sum];
    }

    public static void main(String[] args) {

        Integer[] a = {2, 1, 4, 5, 3};

        List<Integer> list = Arrays.asList(a);

        System.out.println(canPartition(list,3));
    }
}
