import DataStructure.BST;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author: Akhilesh Maloo
 * @date: 1/26/18.
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 *
 * You need to return the number of important reverse pairs in the given array.
 *
 * Example1:
 * Input: [1,3,2,3,1]
 * Output: 2
 *
 * @link https://leetcode.com/problems/reverse-pairs/description/
 *
 *
 */
public class ReversePair {

    BST root;

    public static int reversePairs(int[] nums) {
        if(nums == null)
            return 0;

        if(nums.length < 2)
            return 0;

        int count = 0;

        TreeMap<Long, Integer> ts = new TreeMap<>();

        for(int i = 0; i < nums.length; i++) {
            Long flr = ts.ceilingKey( 2 * (long) nums[i] + 1);

            if(flr != null && flr > (long) nums[i]*2) {
//                for(Integer val : ts.tailMap(flr).values() )
//                    count += val;

                count += ts.tailMap(flr).size();
            }

            ts.put((long) nums[i], ts.getOrDefault((long) nums[i], 0) + 1);
        }

        System.out.println(ts);
        return count;

    }

    public static int inversionCount(int[] num) {
        return merge(num, 0 , num.length-1);
    }

    public static int merge(int[] num, int start, int end){
        int conver = 0;
        if(start < end) {
            int mid = (start + end) / 2;

            conver = merge(num, start, mid);
            conver += merge(num, mid+1, end);

            conver += mergeThem(num, start, mid, end);
        }
        return conver;
    }

    public static int mergeThem(int[] num, int start, int middle, int end) {

        int[] leftSubArray = Arrays.copyOfRange(num, start, middle+1);
        int[] rightSubArray = Arrays.copyOfRange(num,middle+1, end+1);

        int conver = 0;
        int i = 0;
        int j = 0;

        // index should be set to start not zero;
        int index = start;

        while(i < leftSubArray.length && j < rightSubArray.length) {
            if(leftSubArray[i] <= rightSubArray[j]) {
                num[index++] = leftSubArray[i++];
            } else {

                if((long)leftSubArray[i] > 2 * (long)rightSubArray[j])
                    conver = conver + middle - (start + i) + 1;

                num[index++] = rightSubArray[j++];
            }
        }
        if(i == leftSubArray.length) {
            while(j < rightSubArray.length)
                num[index++] = rightSubArray[j++];
        } else {
            while(i < leftSubArray.length)
                num[index++] = leftSubArray[i++];
        }

        return conver;

    }

    public static void main(String[] args) {
        int[] num = {1,3,2,3,1};

        System.out.println(inversionCount(num));
    }
}
