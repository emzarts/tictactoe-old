import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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
        BorderPane pane = new BorderPane();
        GridPane buttons = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons.add(new Button(), i, j);
            }
        }

        pane.setCenter(buttons);
        Scene sc = new Scene(pane);
        Scene scene1 = new Scene(new HBox(new Text("Port:"), new TextField()));
        s.setScene(scene1);
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
