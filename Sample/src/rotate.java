import java.util.Arrays;

/**
 * Created by akhi on 5/16/17.
 */
public class rotate {

    public void rotateIt(int[] nums, int k) {
        int[] result = new int[nums.length];
        if (k < nums.length) {
            for(int i=0; i<nums.length; i++) {
                result[k] = nums[i];
                k++;
                if(k==nums.length) {
                    k = 0;
                }
            }
            for(int i=0; i<nums.length; i++) {
                nums[i]=result[i];
            }
        }
    }

    public void rotateIt2(int[] nums, int k) {
        int len = nums.length;
        if(k>len){
            k = k%len;
        }
        if(k > 0){
            int[] tmp = new int[k]; // k elemtns will be move to the head
            System.arraycopy(nums,len-k,tmp,0,k); //num[1,2,3,4,5,6,7]       temp[5,6,7]
            System.arraycopy(nums,0,nums,k,len-k); //num[1,2,3,4,5,6,7]       num[1,2,3,1,2,3,4]
            System.arraycopy(tmp, 0, nums,0,k); //temp[5,6,7]       num[5,6,7,1,2,3,4]
        }
    }

    public static void main(String[] args) {

        //Rotate an array of n elements to the right by k steps.
        //For example, with nums = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

        int[] nums = {1,2,3,4,5,6,7};
        int[] nums2 = {1,2,3,4,5,6,7};
        int k = 3;
        rotate ex = new rotate();
        ex.rotateIt(nums,k);

        for (int resultBit : nums) {
            System.out.print(resultBit);
        }
        System.out.println();
        // Short run time of rotateIt2

        ex.rotateIt2(nums2,k);
        for (int resultBit : nums2) {
            System.out.print(resultBit);
        }


    }
}
