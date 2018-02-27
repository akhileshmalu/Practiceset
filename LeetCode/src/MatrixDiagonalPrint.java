import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author: Akhilesh Maloo
 * @date: 11/5/17.
 */
public class MatrixDiagonalPrint {

    /* Question

        1 2 3 4
        5 6 7 8
        9 A B C

        Sol: 1  5  2  9  6  3  A  7  4  B  8  C
    */

    /**
     * Given an object 2 D array  print elements in diagonal;
     *
     * @param num
     */
    public static void printDig(Object[][] num) {

        if (num == null)
            throw new IllegalArgumentException("Null Values can't be processed");

        int colLength = num[0].length;

        HashSet<Integer> visited = new HashSet<>();

        LinkedList<Integer> q = new LinkedList<>();

        q.add(0);

        while (!q.isEmpty()) {

            Integer t = q.poll();

            System.out.print(num[t / colLength][t % colLength] + " ");

            if (t / colLength < num.length - 1 && !visited.contains(t + colLength)) {
                visited.add(t + colLength);
                q.add(t + colLength);
            }

            if (t % colLength < num[0].length - 1 && !visited.contains(t + 1)) {
                visited.add(t + 1);
                q.add(t + 1);
            }
        }
    }

    public static void findDiagonalOrder(Object[][] matrix) {
        if (matrix.length == 0) return;
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length;
        Object[] arr = new Object[m * n];

        int rSet = 0;
        int cSet = 0;

        for (int i = 0; i < arr.length; i++) {

            arr[i] = matrix[r][c];

            if (r == 0 || c == n - 1) {
                if (r == 0) {
                    rSet++;
                    rSet = Math.min(rSet, m - 1);
                }
                if (c == n - 1) {
                    cSet++;
                    cSet = Math.min(cSet, n - 1);
                }
                r = rSet;
                c = cSet;
            } else {
                r--;
                c++;
            }
//            System.out.println("r index: "+ r + " col index: " + c);
        }
        for (Object i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        Object[][] num = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 'A', 'B', 'C'},
                {'D', 'E', 'F', 'G'}
        };

        printDig(num);
        System.out.println();
        findDiagonalOrder(num);
    }
}
