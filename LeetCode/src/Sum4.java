import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by akhi on 6/22/17.
 */
public class Sum4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            int sum = nums[i];
            int[] innerVal = new int[4];
            innerVal[count++] = nums[i];

            for (int j = i + 1; j != i && count < 4; j++) {

                innerVal[count] = nums[j];
                sum += nums[j];
                if (j == nums.length - 1) {
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




    public List<List<Integer>> sum4Four(int[] num, int target) {

        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(num.length<4)return ans;
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++){
            if(num[i]+num[i+1]+num[i+2]+num[i+3]>target)break; //first candidate too large, search finished
            if(num[i]+num[num.length-1]+num[num.length-2]+num[num.length-3]<target)continue; //first candidate too small
            if(i>0&&num[i]==num[i-1])continue; //prevents duplicate result in ans list
            for(int j=i+1; j<num.length-2; j++){
                if(num[i]+num[j]+num[j+1]+num[j+2]>target)break; //second candidate too large
                if(num[i]+num[j]+num[num.length-1]+num[num.length-2]<target)continue; //second candidate too small
                if(j>i+1&&num[j]==num[j-1])continue; //prevents duplicate results in ans list
                int low=j+1, high=num.length-1;
                while(low<high){
                    int sum=num[i]+num[j]+num[low]+num[high];
                    if(sum==target){
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while(low<high&&num[low]==num[low+1])low++; //skipping over duplicate on low
                        while(low<high&&num[high]==num[high-1])high--; //skipping over duplicate on high
                        low++;
                        high--;
                    }
                    //move window
                    else if(sum<target)low++;
                    else high--;
                }
            }
        }
        return ans;

    }


    /**
     * N^3 approach : Fastest Approach possible
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum3(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /*
     * Find all possible distinguished three numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, the three numbers))
     */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                   int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /*
     * Find all possible distinguished two numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
     */
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                 int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }

    public static void main(String[] args) {
        Sum4 sum4 = new Sum4();

        long ms = System.nanoTime();

        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(sum4.sum4Four(nums, 0));
        System.out.println(System.nanoTime()- ms);
    }
}
