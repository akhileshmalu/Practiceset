package Sorting;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by akhi on 9/7/16.
 */


public class Quicksort
{
    /**
     * In case array has many duplicate values then one should use 3 way Quick Sort flavour of QS
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    static int partition (int a[],int start, int end)
    {
        int pivot = a[end];
        int pindex = start;
        for (int i = start; i < end; i++)
        {
            if (a[i] < pivot) {
                int temp = a[pindex];
                a[pindex] = a[i];
                a[i] = temp;
                pindex++;
            }

        }

        int temp  = a[pindex];
        a[pindex] = pivot;
        a[end]    = temp;

        return pindex;

    }

    static void quicksort1(int a[], int start, int end)
    {
        if(start<end)
        {
            int pindex = partition(a,start,end);
            quicksort1(a,start, pindex-1);
            quicksort1(a,pindex+1,end);
        }
    }


    public static void main(String[] args)
    {
        //int a[] = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4, 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4};

        int[] a = {3, 5, 2, 5, 5, 7, 5, 10};

        long ms = System.nanoTime();

        quicksort1(a,0,a.length-1);

        System.out.println(System.nanoTime()-ms);
        //HashSet<Integer> as = new HashSet<>();



        for (int i=0;i<a.length;i++)
        {
            System.out.print(a[i] + " ");
        }

    }
}
