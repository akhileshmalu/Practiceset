import java.util.Scanner;

/**
 * @author: Akhilesh Maloo
 * @date: 10/2/17.
 */
public class IncreasingArray {

    /**
     *
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {

        int choice = 0;
        for(int i = 1 ; i< nums.length; i++) {
            if(nums[i] < nums[i-1]) { // if next number is greater
                if(choice++ > 0) return false;

                if(i-2 < 0 || nums[i-2] <= nums[i])
                        nums[i-1] = nums[i];
                else
                    nums[i] = nums[i-1];
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int val[] = {3,4,2,3};
        System.out.println(checkPossibility(val));
    }
}
