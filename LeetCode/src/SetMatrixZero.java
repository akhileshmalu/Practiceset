import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 7/29/20.
 */
public class SetMatrixZero {

    public void setZeroes(int[][] matrix) {
        Set<List<Integer>> indices = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();


        for(int i=0; i< matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0 && (!row.contains(i) || !col.contains(j))) {
//                    insertNeighbours(i, j, indices, matrix.length-1);
                    row.add(i);
                    col.add(j);
//                    indices.add(Arrays.asList(i, j));
                }
            }
        }

//        Iterator<List<Integer>> iterator = indices.iterator();
//        while(iterator.hasNext()) {
//            List<Integer> next = iterator.next();
//            matrix[next.get(0)][next.get(1)] = 0;
//        }

        Iterator<Integer> rowItr = row.iterator();
        while(rowItr.hasNext()) {
            Integer next = rowItr.next();
            for(int j = 0; j < matrix[next].length; j++) {
                matrix[next][j] = 0;
            }
        }

        Iterator<Integer> colItr = col.iterator();
        while(colItr.hasNext()) {
            Integer next = colItr.next();
            for(int j = 0; j < matrix.length; j++) {
                matrix[j][next] = 0;
            }
        }
    }

    private void insertNeighbours(int i, int j, Set<List<Integer>> indices, int length) {
        if(j > 0) {
            indices.add(Arrays.asList(i, j-1)); // up
        }

        if(j < length) {
            indices.add(Arrays.asList(i, j+1)); // down
        }

        if(i > 0) {
            indices.add(Arrays.asList(i-1, j)); // left
        }

        if(i < length) {
            indices.add(Arrays.asList(i+1, j)); // right
        }
    }

    public static void main(String[] args) {
        SetMatrixZero setMatrixZero = new SetMatrixZero();
        int[][] nums = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZero.print2DArray(nums);

        setMatrixZero.setZeroes(nums);
        System.out.println("Post processing");
        setMatrixZero.print2DArray(nums);
    }

    private void print2DArray(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

}
