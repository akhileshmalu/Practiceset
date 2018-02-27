import java.util.PriorityQueue;

/**
 * @author: Akhilesh Maloo
 * @date: 1/28/18.
 */
public class SegmentMaxOfMinArr {

    public static int maxOfminOfSize(int[] nums, int x) {

        int max = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        if(x == nums.length) {
            for(int i = 0; i<nums.length; i++)
                mini = Math.min(mini, nums[i]);

            return mini;
        }


        PriorityQueue<Integer> min = new PriorityQueue<>();

        int k = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i < x) {
                min.offer(nums[i]);
            } else {
                max = Math.max(max, min.peek());
                min.remove(nums[k++]);
                min.offer(nums[i]);
            }
        }

        return max;

    }

    public static void main(String[] args) {


        int[] num = {2, 5, 4, 6, 7, 2};
        System.out.println(maxOfminOfSize(num, 6));

    }
}
