import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TicTacGUI {

    private PrintWriter out;
    private BufferedReader in;
    private Board board;
    private String me;
    private Stage stage;
    private Scene sc;

    public TicTacGUI(String host, int port, String me, Stage stage, Scene sc) throws IOException {
        Socket socket = new Socket(host,port);
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        this.board = new Board();
        this.me = me;
        this.stage = stage;
        this.sc = sc;
    }

    public void run() throws IOException {
        System.out.println("RUN");

        if (in.readLine().equals(Protocol.CONNECTED))
            stage.setScene(sc);
        else System.exit(0);

        final Group root = (Group) sc.getRoot();
        root.setDisable(true);
        if (me.equals("X")) root.setDisable(false);

        GridPane grid = (GridPane) root.getChildren().get(0);
        for (Node n : grid.getChildren()) {
            Button b = (Button) n;
            b.setOnAction(e -> {
                int[] data = (int[]) b.getUserData();
                System.out.println(data[0] + " " + data[1]);
                board.makeMove(data[0], data[1], me);
                b.setText(me);
            });
        }

        /*String line;
        while ((line = in.readLine()) != null) {
            switch(line) {
                case Protocol.MOVE_MADE:
                    String move = in.readLine();
                    String[] l = move.split(" ");
                    String p;
                    if (me.equals("X")) p = "O";
                    else p = "X";
                    board.makeMove(Integer.parseInt(l[0]), Integer.parseInt(l[1]), p);
                    System.out.println("\n" + board);
                    System.in.read(new byte[System.in.available()]); // Clears System.in
                    grid.setDisable(false);
                    break;
                case Protocol.GAME_WON:
                    System.out.println("You won!");
                    System.exit(1);
                    break;
                case Protocol.GAME_LOST:
                    System.out.println("You lost :(");
                    System.exit(1);
                    break;
                case Protocol.GAME_TIED:
                    System.out.println("It was a tie");
                    System.exit(1);
                    break;
            }
        }*/
    }
}
