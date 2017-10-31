package Search;

/** Needs Sorted array
 *
 * @author: Akhilesh Maloo
 * @date: 10/1/17.
 */
public class BinarySearch {

    public static int binarySearch(int val[],int start, int end, int key) {

        int left = start;
        int right = end;

        while(left <= right) {

            int mid = left + (right - left) / 2;            // (left + right) / 2;

            if( key < val[mid]) {
                right = mid-1;
            } else if(key > val[mid]) {
                left = mid+1;
            } else {
                return mid;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        int values[] = {1 , 3, 5, 10, 12, 16, 19};

        System.out.println(binarySearch(values, 0 , values.length-1, 19));


    }
}
