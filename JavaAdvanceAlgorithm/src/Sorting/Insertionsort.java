package Sorting;

/**
 * Created by akhi on 9/5/16.
 */
public class Insertionsort {
    public static void main(String[] args) {
        int pos, val;
        int a[] = { 16, 3, 8, 2, 10};
        for (int i = 1 ; i < a.length ; i++)
        { val=a[i];pos=i;
            for (int j=i-1 ; j>=0 ; j--) {
                if (a[j] > val ) {
                    a[pos] = a[j];
                    pos--;
                }
            }
            a[pos]=val;
        }

        for (int i =0;i<a.length;i++)
            System.out.println(a[i]);
    }
}

