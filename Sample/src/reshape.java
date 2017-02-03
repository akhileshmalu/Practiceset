import java.util.ArrayList;
/**
 * Created by Akhilesh Maloo on 5/13/17.
 * Reshaping a matrix by input new r & c
 */
public class reshape {

    public static void main(String[] args) {

        //@inputParam nums, r, c
        // return new shaped matrix as per r & c in parameter if fits otherwise original matrix
        int[][] nums = {{1,2,3,4}};
        int r = 2;
        int c = 2;
        int Xrow =nums.length;
        int Xcol =nums[0].length;
        int totalLength = Xrow*Xcol;;

//        int oldCol=0; int oldRow=0;
//        int counter = 0;

        int[][] result = new int[r][c];

        if (totalLength == (r * c)) {
           //  Big O of n*m
            for(int i =0; i<(r*c); i++) {
              result[i/c][i%c]=nums[i/Xcol][i%Xcol];
            }

            // Big(O) of n2
//            for (int i = 0; i < r; i++) {
//                for (int j = 0; j < c; j++) {
//
//                    if(oldCol==nums[0].length) {
//                        oldRow++;
//                        oldCol = 0;
//                    }
//                    result[i][j] = nums[oldRow][oldCol];
//                    oldCol++;
//                }
//
//            }
        }

        // Display of Elements for sake of testing
        for (int i = 0; i < r; i++) {
            System.out.print("{");
            for(int j=0 ; j<c; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println("},");

        }
    }
}
