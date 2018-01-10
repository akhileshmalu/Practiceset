import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 11/2/17.
 */
public class SmallDistancePair {

    public static int smallestDistancePair(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int n: nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int[] values = new int[max-min+1];

        for(int i=0; i<nums.length; i++) {
            for(int j = i+1; j<nums.length; j++) {
                values[Math.abs(nums[i] - nums[j])]++;
            }
        }

//        Arrays.stream(values).forEach(t -> {System.out.print(t + " ");});
//        System.out.println();

        int i = 0;
        while(i < values.length) {
            k -= values[i];
            if(k < 0)
                break;
            i++;
        }

        return i;
    }

    public static int smallestPairDis(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int l = 0, h = nums[n - 1];
        while (l < h) {
            int m = (l + h) / 2;
            int count = 0;
            int left = 0;
            for (int right = 0; right < n; right ++) {
                while (nums[right] - nums[left] > m) left ++;
                count += right - left;
            }
            if (count >= k) h = m;
            else l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] num = {95,29,47,58,80,65,26,7,69,0,1,53,61,46,66,30,78,25,1,62,5,1,78,60,81,100,52,33,9,52,7,74,94,93,47,68,80,81,50,31,9,96,8,8,64,4,40,22,50,93};
        int[] num1 = {95,29,47,58,80,65,26,7,69,0,1,53,61,46,66,30,78,25,1,62,5,1,78,60,81,100,52,33,9,52,7,74,94,93,47,68,80,81,50,31,9,96,8,8,64,4,40,22,50,93};


        long ns = System.nanoTime();
        System.out.println(smallestDistancePair(num, 1142));

        System.out.println(System.nanoTime()- ns);



         ns = System.nanoTime();
        System.out.println(smallestPairDis(num1, 1142));

        System.out.println(System.nanoTime()- ns);
    }
}
