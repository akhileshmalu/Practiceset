package com.maloo.akhi;

/**
 * Created by akhi on 1/12/17.
 */
public class mediansortarray {

    public static void main(String[] args) {
        try{

            //brute force
            int nums1[] = {1,3};
            int nums2[] = {2,4};
            int sumlen = nums1.length+nums2.length;
            int[] result = new int[sumlen];
            int k=0, i=0, j=0;
            double median=0;


            while(i<nums1.length && j<nums2.length) {
                if(nums1[i]<nums2[j]) {
                    result[k]=nums1[i];
                    k++; i++;
                } else {
                    result[k]=nums2[j];
                    k++; j++;
                }

            }
            if(i==nums1.length) {
                while(j<nums2.length) {
                    result[k]=nums2[j];
                    j++;k++;
                }
            }

            if(j==nums2.length) {
                while(i<nums1.length) {
                    result[k]=nums2[i];
                    i++;k++;
                }
            }

            if (sumlen % 2 == 0) {
                int mid = sumlen / 2;
                median = (double)(result[mid - 1] + result[mid])/2;

            } else {
                int mid = (sumlen + 1) / 2;
                median = result[mid - 1];
            }
            for (i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }

            System.out.println(median);
        } catch (Exception E) {
            System.out.println(E.getMessage());
        }

    }
}
