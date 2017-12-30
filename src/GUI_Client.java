import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GUI_Client extends Application {

    private PrintWriter out;
    private BufferedReader in;
    private Board board;
    private String me;

    @Override
    public void init() {
        // TODO conect GUI to server here...
    }

    @Override
    public void start(Stage s) {

        // Set up the button grid representing the tic tac toe board
        GridPane board = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button btn = new Button();
                btn.setStyle("-fx-border-color: Whitesmoke; -fx-text-fill: Gray; -fx-border-width: 1; -fx-background-color: transparent; -fx-font-size: 80; -fx-font-family: Monospaced;");
                btn.setMaxSize(100, 100);
                btn.setPrefSize(100,100);
                btn.setPadding(new Insets(0));
                btn.setUserData(new int[] {i, j});
                board.add(btn, i, j);
            }
        }

        s.setTitle("Tic Tac Toe");

        final Group root = new Group(board);

        final Scene scene = new Scene(root, Color.WHITE);

        //root.getChildren().add(text1);

        s.setScene(scene);
        s.show();
    }

    private void run() throws IOException {

    }

    private static void connect(String host, int port, String s) throws IOException {
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
