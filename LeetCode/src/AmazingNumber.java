import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author: Akhilesh Maloo
 * @date: 10/23/17.
 */
public class AmazingNumber {

    /**
     * // amazing = {rank < index} 4 <> 4 < 0,  1 = 1,1,  2 = 2,2 , 7 <> 7<3;
     * @param p
     * @return
     */
    public static int countOfAmazing(int[] p) {

        TreeSet<Integer> ts = new TreeSet<>();

        ts.addAll(Arrays.stream(p).boxed().collect(Collectors.toList()));

        int count = 0;

        for(int i = 0; i< p.length; i++) {

            //System.out.println(p[i] + " rank is " + (ts.headSet(p[i]).size()+1));
            if((ts.headSet(p[i]).size()) <= i)
                count++;

        }
        System.out.println(count);
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
                num[index++] = rightSubArray[j++];
                conver = conver + middle - i;
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
        int[] p = {4, 1, 2 ,7, 6};
        System.out.println(countOfAmazing(p));
        System.out.println("with Merge Sort" + inversionCount(p));
    }
}
