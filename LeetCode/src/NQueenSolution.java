import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 2/10/18.
 */
public class NQueenSolution {


    public void solveNQueens(int n) {

        List<List<String>> totalSol = new ArrayList<>();
        List<Integer[]> queens = new ArrayList<>();
        placeQueens(queens, 0, n,totalSol);

    }

    public void print(List<Integer[]> queens, int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < queens.size(); i++) {
            board[queens.get(i)[0]][queens.get(i)[1]] = 'Q';
        }
        queens.forEach(t -> {
            System.out.println(t[0] + " " + t[1]);

        });

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '\0')
                    System.out.print(".");
                else
                    System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void placeQueens(List<Integer[]> nthQueen, int col, int n, List<List<String>> totalSol) {
        if (col == n) {
            totalSol.add(construct(nthQueen, n));
            return;
        }

        int row = 0;
        while (row < n) {
            if (isSafe(nthQueen, row, col)) {
                nthQueen.add(new Integer[]{row, col});
                placeQueens(nthQueen, (col + 1), n, totalSol);
                nthQueen.remove(nthQueen.size() - 1);
            }
            row++;
        }
    }

    public boolean isSafe(List<Integer[]> nthQueen, int row, int col) {

        // avoid recently added queen as this will have same co-ordinates
        for (int i = 0; i < nthQueen.size(); i++) {
            int r = nthQueen.get(i)[0];
            int c = nthQueen.get(i)[1];

            if (r == row || (Math.abs(r - row) == Math.abs(c - col)))
                return false;
        }

        return true;
    }


    /**
     *
     * @param board
     * @param n
     * @return
     */
    private List<String> construct(List<Integer[]> board, int n) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.size(); i++) {
            StringBuilder s = new StringBuilder(new String(new char[n]).replace("\0","."));
            s.setCharAt(board.get(i)[0],'Q');
            System.out.println(s);
            res.add(s.toString());
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        NQueenSolution nq = new NQueenSolution();
        nq.solveNQueens(4);
    }
}
