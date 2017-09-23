package Sorting;

import java.util.Arrays;


/**
 * @file: Advance Sorting
 * @brief: All type of sorting.
 * @Author: Akhilesh Maloo
 * @date: 7/22/2017
 */
public class Sort {

    public void bubble(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            for(int j = nums.length-1; j>i; j--) {
                if(nums[j] < nums[j-1]) {
                    // Swap numbers to bubble out minimum at ith position.
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }

    public void selection(int[] nums) {

        for(int i=0; i< nums.length; i++) {
            int minIndex = linearSearch(i,nums);

            //swap minIndex with ith position
            if (i != minIndex) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    public int linearSearch(int start, int[] values) {
        int minVal = values[start];
        int minIndex = start++;
        // Increased start value to compare rest of array
        while(start < values.length) {
            if(values[start] < minVal) {
                minVal = values[start];
                minIndex = start;
            }
            start++;
        }
        return minIndex;
    }

    public void insertion(int[] nums) {
        for(int i = 1; i< nums.length; i++) {
            for(int j = i-1; j >= 0; j--) {
                // Check if array value is larger then stop shifting values to right.
                if(nums[j] < nums[j+1]) {
                    break;
                }
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
    }

    public void mergeDivide(int[] nums, int start, int end) {
        if(start < end) {
            // Middle point
            int middle = (start + end)/2;

            // Sort first Half
            mergeDivide(nums,start, middle);
            mergeDivide(nums,middle+1, end);

            // Merge both sorted array
            mergeConqour(nums, start, middle, end);
        }
    }

    public int partition(int[] a, int start, int end) {

        int pivot = a[end];
        int firstElem = start;
        int temp = 0;

        for(int i = firstElem; i < end; i++) {
            if(a[i] < pivot) {
                temp = a[firstElem];
                a[firstElem] = a[i];
                a[i] = temp;
                firstElem++;
            }
        }
        temp = a[firstElem];
        a[firstElem] = pivot;
        a[end] = temp;

        return firstElem;
    }

    public void quickSort(int[] a, int start, int end) {
        if(start < end) {
            int partitionIndex = partition(a, start, end);
            quickSort(a, start, partitionIndex-1);
            quickSort(a, partitionIndex, end);
        }
    }

    private void mergeConqour(int[] nums, int start, int middle, int end) {

        // CopyOfRange Param: start is inclusive & end is exclusive;
        int[] leftSubArray = Arrays.copyOfRange(nums, start, middle+1);
        int[] rightSubArray = Arrays.copyOfRange(nums,middle+1, end+1);

        int i = 0;
        int j = 0;
        // index should be set to start not zero;
        int index = start;

        while(i < leftSubArray.length && j < rightSubArray.length) {
            if(leftSubArray[i] <= rightSubArray[j]) {
                nums[index++] = leftSubArray[i++];
            } else {
                nums[index++] = rightSubArray[j++];
            }
        }
        if(i == leftSubArray.length) {
            while(j < rightSubArray.length)
                nums[index++] = rightSubArray[j++];
        } else {
            while(i < leftSubArray.length)
                nums[index++] = leftSubArray[i++];
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int nums[] = { 5,1,3,8,2};
        sort.quickSort(nums,0,nums.length-1);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
