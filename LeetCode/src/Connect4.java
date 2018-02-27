/**
 * @author: Akhilesh Maloo
 * @date: 1/22/18.
 */


/**
 * @author: Akhilesh Maloo
 * @date: 1/22/18.
 */
public class Connect4 {

    BoardGame game = new BoardGame();

    public enum BoardStates {
        EMPTY("*"), P1("0"), P2("X");

        private final String stateNames;

        private  BoardStates(String names) {
            this.stateNames = names;
        }

        @Override 
        public String toString() {
            return stateNames;
        }


    }

    public class BoardGame {

        BoardStates[][] board;
        Player player1;
        Player player2;

        class Player {

            private BoardStates playerPiece;
            private int piecesPlayed;
            private int id;

            Player(BoardStates piece, int id) {
                this.playerPiece = piece;
                this.id = id;
                piecesPlayed = 0;
            }

            public void move(int col) {

                int i;

                // ascertain empty spot for column
                for(i = board.length-1; i >= 0 && board[i][col] != BoardStates.EMPTY; i--);

                if(i == -1) {
                    System.out.println("No space on column no: " + col + " Please retry");
                    return;
                }

                board[i][col] = playerPiece;
                piecesPlayed++;
            }

            public boolean hasWon() {

                if(this.piecesPlayed < 4) {
                    return false;
                }

                for(int i = board.length-1; i >= 0; i--) {
                    for(int j = 0; j < board[0].length-4; j++) {

                        try{
                            /**
                             * 			****
                             */
                            if(board[i][j] == this.playerPiece &&
                                    board[i][j+1] == this.playerPiece &&
                                    board[i][j+2] == this.playerPiece &&
                                    board[i][j+3] == this.playerPiece)
                                return true;

                            //check vertical
                            /**
                             * 			*
                             * 			*
                             * 			*
                             * 			*
                             */
                            if(i >= (board.length - 4 + 1) && board[i][j] == this.playerPiece &&
                                    board[i-1][j] == this.playerPiece &&
                                    board[i-2][j] == this.playerPiece &&
                                    board[i-3][j] == this.playerPiece)
                                return true;

                            // check diagonal
                            /**
                             * 			*
                             * 			 *
                             * 			  *
                             * 			   *
                             *
                             */

                            if(i <= (board.length - 4 + 1) && board[i][j] == this.playerPiece &&
                                    board[i+1][j+1] == this.playerPiece &&
                                    board[i+2][j+2] == this.playerPiece &&
                                    board[i+3][j+3] == this.playerPiece)
                                return true;

                            // inverse diagonal
//                            if(i >= 3 && j <= (board[0].length - 4 + 1) &&
//                            		board[i][j] == this.playerPiece &&
//                                    board[i-1][j-1] == this.playerPiece &&
//                                    board[i-2][j-2] == this.playerPiece &&
//                                    board[i-3][j-3] == this.playerPiece)
//                                return true;

                            /**		Diagonal
                             * 			   *
                             * 			  *
                             * 			 *
                             * 			*
                             */
                            if(i >= 3 && board[i][j] == this.playerPiece &&
                                    board[i-1][j+1] == this.playerPiece &&
                                    board[i-2][j+2] == this.playerPiece &&
                                    board[i-3][j+3] == this.playerPiece)
                                return true;



                        } catch (IndexOutOfBoundsException e) {
                            //System.out.println(i + " row & cols: " + j);
                            //return false;
                        }

                    }
                }
                return false;
            }

        }

        public void prepareBoard(int row, int column) {

            if(column < 4 || row < 4) {
                System.out.println("Invalid Board dimensions for game");
                System.exit(0);
                return;
            }

            board = new BoardStates[row][column];
            clearBoard();

            //set up players
            player1 = new Player(BoardStates.P1, 1);
            player2 = new Player(BoardStates.P2, 2);
        }

        /**
         * Clear the board
         */
        private void clearBoard() {
            for (int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++)
                    board[i][j] = BoardStates.EMPTY;
            }
        }

        public void printBoard() {

            System.out.println();

            for (BoardStates[] r: board) {
                for(BoardStates state: r)
                    System.out.print(state.toString());
                System.out.println();
            }
        }

        public Player decideWinner() {
            if(player1.hasWon())
                return player1;

            if(player2.hasWon())
                return player2;

            return null;
        }


    }

    public void launchGame(int rows, int cols, int[] moves)  {


            game.prepareBoard(rows, cols);


            boolean player1move = true;


            BoardGame.Player winner = null;

            for(int i = 0; i<moves.length; i++) {

                if(player1move)
                    game.player1.move(moves[i]);
                else
                    game.player2.move(moves[i]);

                player1move = !player1move;

                game.printBoard();


                winner = game.decideWinner();

                if( winner != null) {
                    System.out.println("Player "+ winner.id +" won! "+ winner.piecesPlayed+" pieces played.");
                    break;
                }


            }

            if(winner == null)
                System.out.println("Draw");

    }


    public static void main(String[] args) {
        Connect4 con = new Connect4();
        int[] moves = {0,0,1,1,2,2,3};
        con.launchGame(6,7,moves);

    }



}

