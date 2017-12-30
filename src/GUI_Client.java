import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


// TODO win, loss, and tied conditions
// TODO type q for quit

public class GUI_Client extends Application {

    private PrintWriter out;
    private BufferedReader in;
    private Board board;
    private String me;

    @Override
    public void init() {
        //System.out.println("hhhh");
    }

    @Override
    public void start(Stage s) {

        // Set up the button grid representing the tic tac toe board
        GridPane buttons = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button btn = new Button();
                btn.setPrefWidth(100);
                btn.setPrefHeight(100);
                btn.setUserData(new int[] {i, j});
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                    }
                });
                buttons.add(btn, i, j);
            }
        }

        s.setTitle("Tic Tac Toe");

        final Group root = new Group(buttons);

        final Scene scene = new Scene(root, Color.DODGERBLUE);

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
