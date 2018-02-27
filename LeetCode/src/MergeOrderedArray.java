import java.util.Arrays;

/**
 * Fit in small array in bigger array with ordering
 *
 * @author: Akhilesh Maloo
 * @date: 2/13/18.
 */
public class MergeOrderedArray {

    public static int[] mergeArrays(int[] bigger, int[] smaller, int n) {
        if(bigger.length < smaller.length)
            return mergeArrays(smaller, bigger, n);

        if((bigger.length - n) != smaller.length)
            return null;

        int smallTail = smaller.length-1, bigTail = n-1;
        int mergeTail = bigger.length-1;
        while(bigTail >=  0 && smallTail >= 0) {

            if(bigger[bigTail] > smaller[smallTail]) {
                bigger[mergeTail--] = bigger[bigTail--];

            } else {
                bigger[mergeTail--] = smaller[smallTail--];
            }
        }

        while(smallTail >= 0) {
            bigger[mergeTail--] = smaller[smallTail--];
        }

        return bigger;
    }

    public static void main(String[] args) {

        int[] myArray     = new int[]{3, 4, 6, 0, 0, 0};
        int[] alicesArray = new int[]{1, 5, 8};

        int[] mer = mergeArrays(myArray, alicesArray, 3);
        Arrays.stream(mer).forEach(t -> {System.out.print(t + " ");});
    }
}
