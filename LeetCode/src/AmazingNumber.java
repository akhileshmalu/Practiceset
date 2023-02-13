import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author: Akhilesh Maloo
 * @date: 10/23/17.
 */
public class AmazingNumber {

    /*
     *
     *  Logic: in self balancing tree ; we shall keep a count of right sub tree size.
     * @param p
     * @return
     */
    public static int countOfAmazing(int[] p) {

        TreeSet<Integer> ts = new TreeSet<>();

        int count = 0;

        for (int i = 0; i < p.length; i++) {

            // step 1: add item and see size of right sub tree
            ts.add(p[i]);

            // since tailSet includes item itself in set hence -1
            count += ts.tailSet(p[i]).size() - 1;

        }

        return count;
    }


    public static int inversionCount(int[] num) {
        return merge(num, 0, num.length - 1);
    }

    public static int merge(int[] num, int start, int end) {
        int conver = 0;
        if (start < end) {
            int mid = (start + end) / 2;

            conver = merge(num, start, mid);
            conver += merge(num, mid + 1, end);

//            conver += mergeThem(num, start, mid, end);
            conver += mergeThemFor2I(num, start, mid, end);


        }
        return conver;
    }

    public static int mergeThem(int[] num, int start, int middle, int end) {

        int[] leftSubArray = Arrays.copyOfRange(num, start, middle + 1);
        int[] rightSubArray = Arrays.copyOfRange(num, middle + 1, end + 1);

        int conver = 0;
        int i = 0;
        int j = 0;
        // index should be set to start not zero;
        int index = start;

        while (i < leftSubArray.length && j < rightSubArray.length) {
            if (leftSubArray[i] <= rightSubArray[j]) {
                num[index++] = leftSubArray[i++];
            } else {
                num[index++] = rightSubArray[j++];
                conver = conver + leftSubArray.length - i;
            }
        }
        if (i == leftSubArray.length) {
            while (j < rightSubArray.length)
                num[index++] = rightSubArray[j++];
        } else {
            while (i < leftSubArray.length)
                num[index++] = leftSubArray[i++];
        }

        return conver;

    }


    public static int mergeThemFor2I(int[] num, int start, int middle, int end) {

        int[] leftSubArray = Arrays.copyOfRange(num, start, middle + 1);
        int[] rightSubArray = Arrays.copyOfRange(num, middle + 1, end + 1);

        int conver = 0;
        int i = 0;
        int j = 0;
        // index should be set to start not zero;
        int index = start;

        while (i < leftSubArray.length && j < rightSubArray.length) {
            if (leftSubArray[i] < rightSubArray[j]) {
                num[index++] = leftSubArray[i++];
            } else {
                num[index++] = rightSubArray[j++];

                if (leftSubArray[i] > 2 * rightSubArray[j - 1])
                    conver = conver + leftSubArray.length - i - 1;
            }
        }
        if (i == leftSubArray.length) {
            while (j < rightSubArray.length)
                num[index++] = rightSubArray[j++];
            }
        else {
            while (i < leftSubArray.length)
                num[index++] = leftSubArray[i++];
        }

        Arrays.stream(num).forEach(t -> System.out.print(t + " "));
        System.out.println("   " + conver);
        return conver;

    }

    public static void main(String[] args) {

        int[] p = {5, 4, 3, 2, 1};

        System.out.println(countOfAmazing(p));
        System.out.println();
        System.out.println("with Merge Sort " + inversionCount(p));
    }
}
