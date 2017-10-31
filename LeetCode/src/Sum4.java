import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by akhi on 6/22/17.
 */
public class Sum4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i< nums.length-1; i++) {
            int count = 0;
            int sum = nums[i];
            int[] innerVal = new int[4];
            innerVal[count++] = nums[i];

            for(int j = i+1; j != i && count < 4; j++) {

                innerVal[count] = nums[j];
                sum += nums[j];
                if (j == nums.length-1) {
                    j = 0;
                }
                count++;
            }
            if (sum == target) {
                result.add(IntStream.of(innerVal).boxed().collect(Collectors.toList()));
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Sum4 sum4 = new Sum4();
        int[] nums = {1, 0, -1, 0, -2, 2};
        sum4.fourSum(nums, 1);
    }
}
