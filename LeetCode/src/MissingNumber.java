/**
 * @author: Akhilesh Maloo
 * @date: 11/2/17.
 */
public class MissingNumber {

    public static int findMissingNum(int[] num,int start,int end) {

        while((end - start) > 1) {

            int mid = (start + end) / 2;

            // num[mid] used for numbers starting from zero; if numbers are starting from 1 it should be num[mid]-1
            if(mid < num[mid]) {
                end = mid;
            } else {
                start = mid;
            }

        }

        int missing = (num[start] + num[end]) / 2;

        // check if there exist any missing value ; if num starts from 0 then check length-1 else length;
        return ((missing+1) == num.length-1)? -1: missing;
    }

    public static void main(String[] args) {
        int[] num = { 0, 1, 2, 3, 4, 6};

        System.out.println(findMissingNum(num, 0, num.length-1));
    }
}
