
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class PTUI_Client implements Observer {

    @Override
    public void update(Observable o, Object obj) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!\nWould you like to:\n\ta) Start a new game\n\tb) Join a game\n\tc) Exit");
        boolean begin = false;
        while (!begin) {
            begin = true;
            switch (sc.nextLine().toLowerCase()) {

                case "a":
                    System.out.println("Choice a");
                    // TODO asks for a port number and host
                    // TODO starts a server on that port and waits for the other player
                    break;
                case "b":
                    System.out.println("Choice b");
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
