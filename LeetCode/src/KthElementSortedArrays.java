import java.util.PriorityQueue;

/**
 * @author: Akhilesh Maloo
 * @date: 2/22/18.
 */
public class KthElementSortedArrays {

    /**
     * clean and easy to understand N2 log n
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                pq.offer(matrix[i][j]);
            }
        }
        int i = 1;
        while(i++ < k) {
            pq.poll();
        }
        return pq.poll();
    }

    /**
     * using merge array options  ; still not the best runtime N 2
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int high = matrix.length;

        if(high == 1)
            return matrix[0][k-1];

        int[] result = merge(matrix[0], matrix[1]);

        int start = 2;
        while(start < high) {
            result = merge(result, matrix[start]);
            start++;
        }

        return result[k-1];
    }

    private int[] merge(int[] leftSubArray, int[] rightSubArray) {

        // CopyOfRange Param: start is inclusive & end is exclusive;
        int[] nums = new int[leftSubArray.length + rightSubArray.length];

        int i = 0;
        int j = 0;
        int index = 0;

        while(i < leftSubArray.length && j < rightSubArray.length) {
            if(leftSubArray[i] <= rightSubArray[j]) {
                nums[index++] = leftSubArray[i++];
            } else {
                nums[index++] = rightSubArray[j++];
            }
        }
        if(i == leftSubArray.length) {
            while(j < rightSubArray.length)
                nums[index++] = rightSubArray[j++];
        } else {
            while(i < leftSubArray.length)
                nums[index++] = leftSubArray[i++];
        }

        return nums;
    }

    /**
     * Good Solution basis on Binary Search : nLogn
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest3(int[][] matrix, int k) {

        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1];

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                count += j + 1;
            }
            if(count < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * Best Solution: Easy to understand : ( Log n ) * (Log n)
     * @param a
     * @param k
     * @return
     */
    public int kthSmallest4(int[][] a, int k) {
        int n = a.length;
        int s = a[0][0]; // the smallest number
        int b = a[n - 1][n - 1]; // the biggest number

        while(s < b) {
            int mid = s + (b - s) / 2;
            int temp = 0;
            for(int i = 0; i < n; i++) {
                //int bsResult = bs(a[i], n, mid);
                temp += bs(a[i], n, mid);
            }
            if(temp < k) {
                s = mid + 1;
            } else {
                b = mid;
            }

        }

        return s;
    }


    private int bs(int row[], int right, int target) {  // the last index of the element that is <= mid  a[pos] <= mid < a[pos + 1]
        int left = 0;
        //int pos = 0;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(row[mid] <= target) {
                //pos = mid;
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }  // return the first number

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int k = 8;
        KthElementSortedArrays kth = new KthElementSortedArrays();

        System.out.println(kth.kthSmallest4(matrix,k));

    }


}

