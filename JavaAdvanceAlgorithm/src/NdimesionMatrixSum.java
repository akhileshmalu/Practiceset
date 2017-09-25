import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 9/21/17.
 */
public class NdimesionMatrixSum {



    public static void main(String[] args) {
        int[][][] matrix = new int[2][3][2];

        int count = 1;

        for(int i=0; i<matrix.length; i++) {
            for(int j = 0; j< matrix[0].length; j++) {
                for(int k=0; k<matrix[0][0].length; k++) {
                    matrix[i][j][k] = count++;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j = 0; j< matrix[0].length; j++) {
                for(int k=0; k<matrix[0][0].length; k++) {
                    sum += matrix[i][j][k];
                    System.out.print(matrix[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Sum is " + sum);

    }

}
