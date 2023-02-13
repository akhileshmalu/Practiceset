/**
 * @author: Akhilesh Maloo
 * @date: 10/30/17.
 */
public class HighestProduct3Numbers {

    public static int highestProduct3Num(int[] nums) {


        int highestProduct = Math.max(nums[0], nums[1]);
        int lowestProduct = Math.min(nums[0], nums[1]);

        int highestProduct2Num = nums[0] * nums[1];
        int lowestProduct2Num = nums[0] * nums[1];


        int highestProduct3Num = nums[0] * nums[1] * nums[2];


        for(int i = 2; i < nums.length; i++) {

            int current = nums[i];

            highestProduct3Num = Math.max(highestProduct3Num,
                    Math.max(current * highestProduct2Num, current * lowestProduct2Num ));

            highestProduct2Num = Math.max(highestProduct2Num,
                    Math.max(current * highestProduct, current*lowestProduct));

            lowestProduct2Num = Math.min(lowestProduct2Num,
                    Math.min(current * highestProduct, current*lowestProduct));

            highestProduct = Math.max(highestProduct, current);

            lowestProduct = Math.min(lowestProduct, current);

        }

        return highestProduct3Num;

    }

    public static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static int highestProduct2Num(int[] nums) {


        int highestProduct = Math.max(nums[0], nums[1]);
        int lowestProduct = Math.min(nums[0], nums[1]);

        int highestProduct2Num = nums[0] * nums[1];


        for(int i = 2; i < nums.length; i++) {

            int current = nums[i];

            highestProduct2Num = Math.max(highestProduct2Num,
                    Math.max(current * highestProduct, current*lowestProduct));

            highestProduct = Math.max(highestProduct, current);

            lowestProduct = Math.min(lowestProduct, current);

        }

        return highestProduct2Num;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {-10,-10, 1, 3, 2};

        System.out.println(highestProduct3Num(nums));
        System.out.println(maximumProduct(nums));
    }
}
