import java.util.HashMap;

/**
 * @author: Akhilesh Maloo
 * @date: 5/5/18.
 */
public class LongestConsecutiveNumber {

    public static int longestConsecutive(int[] nums) {
        /*
        HashMap<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        } */

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int[] range = new int[max-min+1];
        for(int i : nums) {
            range[i-min] = 1;
        }

        int i = 0;
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        while(i < range.length) {
            if(range[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
            i++;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));



    }
}
