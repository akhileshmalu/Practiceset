import java.util.Enumeration;
import java.util.Scanner;

/**
 * @author: Akhilesh Maloo
 * @date: 10/11/17.
 */
public class ArrayPairSum {
    enum shirtSize  {s, m , l, xl};

    /**
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
     * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
     *
     * Input: [1,4,3,2]
     *
     * Output: 4
     * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
     *
     *  Note: n is a positive integer, which is in the range of [1, 10000].
     *  All the integers in the array will be in the range of [-10000, 10000]
     *
     * @link https://leetcode.com/problems/array-partition-i/description/
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {

        int[] temp = new int[2*10000 + 1]; // since possible value is -10000 to 10000
        for(int i=0; i < nums.length; i++)
            temp[ nums[i] + 10000 ]++;          // set index from number itself ; no req of sorting
        int sum = 0;
        boolean alternate = true;
        for(int i = 0; i< temp.length; i++) {
            while(temp[i] > 0) {
                if(alternate)
                sum += (i - 10000);

                alternate = !alternate;
                temp[i]--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,4};
        System.out.println(arrayPairSum(nums));

    }
}
