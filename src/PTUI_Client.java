
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class PTUI_Client implements Observer {

    PTUI_Client(String host, int port) {

    }

    @Override
    public void update(Observable o, Object obj) {

    }

    public static void connect(String host, int port) {
        System.out.println("Connecting to server on port " + port);
        PTUI_Client client = new PTUI_Client(host, port);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!\nWould you like to:\n\ta) Start a new game\n\tb) Join a game\n\tc) Exit");
        boolean begin = false;
        while (!begin) {
            begin = true;
            switch (sc.nextLine().toLowerCase()) {

                case "a":
                    try {
                        System.out.println("Start a game on what port? ");
                        int port = sc.nextInt();
                        String host = "localhost";
                        Server s = new Server(port);

                        connect(host, port);
                    } catch (InputMismatchException e) {
                        System.out.println("That is not a valid port number");
                        begin = false;
                    } catch (IOException e) {
                        System.out.println("Cannot connect to that port");
                        begin = false;
                    }
                    // TODO starts a server on that port and waits for the other player
                    break;
                case "b":
                    try {
                        System.out.println("Join a game on what port? ");
                        int portnum = sc.nextInt();
                        String host = "localhost";

                        connect(host, portnum);

                    } catch (InputMismatchException e) {
                        System.out.println("That is not a valid port number");
                        begin = false;
                    }
                    // Todo asks for the port and host to connect to
                    break;
                case "c":
                    System.exit(0);
                    break;
                default:
                    begin = false;
                    System.out.println("Please type a, b, or c");
            }
        }
    }
}
