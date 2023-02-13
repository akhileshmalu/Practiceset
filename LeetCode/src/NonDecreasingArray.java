import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Akhilesh Maloo
 * @date: 7/11/20.
 */
public class NonDecreasingArray {

    /**
     * 665. Non-decreasing Array
     * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
     We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        if(nums.length == 1)
            return true;
        

        int start=0, end=nums.length-1;
        for(int i = 0; i < nums.length;i++) {
            boolean leftSort = true;
            boolean rightSort = true;

            int maxLeft = Integer.MIN_VALUE, minRight = Integer.MAX_VALUE;

            if(i > start) {
                leftSort = isSorted(nums, start, i-1);
                maxLeft = nums[i-1];
            }
            if(i < end) {
                rightSort = isSorted(nums, i+1, end);
                minRight = nums[i+1];
            }

            if(leftSort && rightSort && maxLeft < minRight) {
                return true;
            }

        }


        return false;
    }

    public boolean checkPossibility2(int[] nums) {
        int indices = 0;

        if(nums.length > 1 && nums[0] > nums[1]) {
            indices++;
            nums[0] = nums[1];
        }

        for(int i = 1; i < nums.length-1 ;i++) {
            if(nums[i] > nums[i+1]) {
                if(indices >= 1) {
                    return false;
                }

                if(nums[i+1] < nums[i-1]) {
                    nums[i+1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
                indices++;

            }
        }
        return true;

    }

    public boolean isSorted(int[] nums, int start, int end) {
        if(start < end) {
            for(int i= start; i< end; i++) {
                if(nums[i] > nums[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        int num[] = {3,4,2,3};
//        System.out.println(nonDecreasingArray.checkPossibility(num));
        System.out.println(nonDecreasingArray.checkPossibility2(num));
    }
}
