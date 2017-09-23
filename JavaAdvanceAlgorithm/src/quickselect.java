package com.maloo.akhi;

/**
 * Created by akhi on 9/14/16.
 */
public class quickselect {

    public static int quickselect1(int a[], int start, int end, int pos)
    {

        int pivot = a[start];
        int left= start+1;
        int right = end;

        while(true)
        {
            while(left<right && a[left]<pivot)
            {
                left++;
            }
            while(right>left && a[right]>pivot)
            {
                right--;
            }
            if(left>right){
              break;
            }
            else
            {
                int temp;
                temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }


        }

        if ((left-start+1) == pos)
        {
            return a[left];
        }
        else
        {
            if(left > pos)
            {
            return quickselect1(a, start, left, pos);
            }
            else
            {
            return quickselect1(a, left, end, pos);
            }
        }

    }


    public static void main(String[] args)
    {
        int a[] = {10, 4, 2, 7, 6};
        int pos = 3;
        int ele;
        ele = quickselect1(a, 0, a.length - 1, pos);
        System.out.println("Value at " + pos + "th position is:" + ele);
   }

}
