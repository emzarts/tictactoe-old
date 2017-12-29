import java.util.Arrays;
import java.util.Observable;

public class Board extends Observable {

    private String[][] board = new String[3][3];

    Board() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = "-";
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return (row < board.length && col < board.length && board[row][col] == "-");
    }

    public void makeMove(int row, int col, String s) {
        if (isValidMove(row,col))
            this.board[row][col] = s; //TODO make symbol for player
        //System.out.println(this);
        //this.notifyObservers(); //TODO this does not work
    }

    @Override
    public String toString() {
        return Arrays.toString(board[0]) + "\n" + Arrays.toString(board[1]) + "\n" + Arrays.toString(board[2]);
    }
}
