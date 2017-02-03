package com.maloo.akhi;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;

/**
 * Created by akhi on 9/7/16.
 */


public class Quicksort
{
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
            int pindex =partition(a,start,end);
            quicksort1(a,start, pindex-1);
            quicksort1(a,pindex+1,end);
        }
      /*else
       {
           return;
       }*/


    }


    public static void main(String[] args)
    {
        int a[] = {10,8,1,4,12};
        quicksort1(a,0,a.length-1);
        for (int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }

    }
}
