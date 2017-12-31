import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Todo add a cancel button
public class GUI_Client extends Application {

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
        final Group root = new Group(board);
        final Scene scene = new Scene(root, 300, 300, Color.WHITE);

        // sets up port screen

        BorderPane spo = new BorderPane();

        TextField txtport = new TextField();
        txtport.setOnAction(e -> {
            try {
                connect("localhost", Integer.parseInt(txtport.getText()), "X", s, scene); // Todo join with port here
            } catch (IOException m) {
                System.out.println("something bad happened");
            }
        });
        txtport.setOnAction(e -> System.out.println("do the thing " + txtport.getText())); // Todo join with port here
        Text st = new Text("Start game on what port? ");
        st.setFont(Font.font("Monospaced", 20));
        st.setFill(Color.GRAY);
        txtport.setStyle("-fx-border-width: 1; -fx-border-color: Gray; -fx-background-color: transparent;");
        VBox form = new VBox(st, txtport);
        spo.setCenter(form);

        TextField txtport2 = new TextField();
        txtport2.setOnAction(e -> {
                    try {
                        connect("localhost", Integer.parseInt(txtport2.getText()), "O", s, scene); // Todo join with port here
                    } catch (IOException m) {
                        System.out.println("something bad happened");
                    }
                });
        BorderPane jpo = new BorderPane();
        Text st2 = new Text("Join game on what port? ");
        st2.setFont(Font.font("Monospaced", 20));
        st2.setFill(Color.GRAY);
        txtport2.setStyle("-fx-border-width: 1; -fx-border-color: Gray; -fx-background-color: transparent;");
        VBox formj = new VBox(st2, txtport2);
        jpo.setCenter(formj);
        final Scene startportscreen = new Scene(spo, 300, 300, Color.WHITE);
        final Scene joinportscreen  = new Scene(jpo, 300, 300, Color.WHITE);

        // Sets up the game initialization page
        Button start = new Button("Start a new game");
        start.setStyle("-fx-text-fill: Gray; -fx-border-width: 1; -fx-background-color: transparent; -fx-font-size: 21; -fx-font-family: Monospaced;");
        start.setPrefSize(300, 150);
        Button join = new Button("Join an existing game");
        join.setStyle("-fx-text-fill: Gray; -fx-border-width: 1; -fx-background-color: transparent; -fx-font-size: 21; -fx-font-family: Monospaced;");
        join.setPrefSize(300, 150);

        start.setOnMouseEntered(e -> start.setStyle("-fx-cursor: hand; -fx-underline: true; -fx-text-fill: Gray; -fx-border-width: 1; -fx-background-color: transparent; -fx-font-size: 21; -fx-font-family: Monospaced;"));
        start.setOnMouseExited(e -> start.setStyle("-fx-text-fill: Gray; -fx-border-width: 1; -fx-background-color: transparent; -fx-font-size: 21; -fx-font-family: Monospaced;"));

        join.setOnMouseEntered(e -> join.setStyle("-fx-cursor: hand; -fx-underline: true; -fx-text-fill: Gray; -fx-border-width: 1; -fx-background-color: transparent; -fx-font-size: 21; -fx-font-family: Monospaced;"));
        join.setOnMouseExited(e -> join.setStyle("-fx-text-fill: Gray; -fx-border-width: 1; -fx-background-color: transparent; -fx-font-size: 21; -fx-font-family: Monospaced;"));

        start.setOnMousePressed(e -> s.setScene(startportscreen));
        join.setOnMousePressed(e -> s.setScene(joinportscreen));

        VBox options = new VBox(start, join);
        Group ls = new Group(options);
        final Scene loginscreen = new Scene(ls, 300, 300, Color.WHITE);

        s.setTitle("Tic Tac Toe");
        s.setScene(loginscreen);
        s.show();
    }

    private static void connect(String host, int port, String s, Stage stage, Scene sc) throws IOException {
        TicTacGUI client = new TicTacGUI(host, port, s, stage, sc);
        client.run();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
