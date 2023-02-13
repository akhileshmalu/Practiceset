import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 8/10/20.
 */
public class MoveZero {

    public void moveZeroes(int[] nums) {
        int counter = 0;
        for(int i=0; i<nums.length-counter; i++) {
            if(nums[i] == 0) {

                int k = 0;
                while((i+k) < nums.length && nums[i+k] == 0) {
                    k++;
                }

                counter = counter + k;
                shiftArray(nums, i,i+k, nums.length-counter);
//                i = i + k-1;

            }
            Arrays.stream(nums).forEach(System.out::print);
            System.out.println();
        }

        for(int j = 0; j < counter; j++) {
            nums[nums.length -1 - j] = 0;
        }

    }

    private void shiftArray(int[] nums, int start, int from, int end) {
        while(start < nums.length && from < nums.length) {
            nums[start++] = nums[from++];
        }

        while(end < nums.length) {
            nums[end++] = Integer.MIN_VALUE;
        }
    }

    public void moveZeroes2(int[] nums) {
        if(nums.length == 0)
            return;
        int insertInd = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[insertInd];
                nums[insertInd] = nums[i];
                nums[i] = temp;
                insertInd++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZero mz = new MoveZero();
//        int[] nums = {0,1,0,3,12};
//        int[] nums = {0,1,0};
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        mz.moveZeroes2(nums);
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
    }
}
