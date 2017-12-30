import java.util.Arrays;

public class Board {

    private String[][] board = new String[3][3];
    private String status = "Tie";

    Board() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = "-";
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return (row < board.length && col < board.length && board[row][col].equals("-"));
    }

    public void makeMove(int row, int col, String s) {
        if (isValidMove(row,col))
            this.board[row][col] = s;
    }

    public String getStatus() {
        /**
         * [00,01,02]
         * [10,11,12]
         * [20,21,22]
         *
         * [00,01,02,10,11,12,20,21,22]
         *
         * [00,11,22]
         * [02,11,20]
         * 5 different possibilities
         *
         */
        return null; // TODO
    }

    @Override
    public String toString() {
        return Arrays.toString(board[0]) + "\n" + Arrays.toString(board[1]) + "\n" + Arrays.toString(board[2]);
    }
}
