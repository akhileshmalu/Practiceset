/**
 * @author: Akhilesh Maloo
 * @date: 11/26/17.
 */
public class MetricMultiply {
    public static void main(String[] args) {
        int a[][] = new int[][]{{1,2},{3,4},{5,6}};
        int b[][] = new int[][]{{1,2,3},{4,5,6}};
        int c[][] = new int[3][3];

        /*

            1   2
            3   4
            5   6


            1   2   3
            4   5   6


         */


        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++)
                    c[i][j] += a[i][k] * b[k][j];

            }
        }

        for(int[] m: c) {
            for (int v: m)
                System.out.print(v+ " ");
            System.out.println();
        }

    }
}

