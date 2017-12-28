
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class PTUI_Client implements Observer {

    private PrintWriter out;
    private BufferedReader in;
    private Board board;

    private PTUI_Client(String host, int port) throws IOException {
        Socket socket = new Socket(host,port);
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        this.board = new Board();
    }

    @Override
    public void update(Observable o, Object obj) {

    }

    private void run() throws IOException {
        this.board.addObserver(this);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        if (in.readLine().equals(Protocol.CONNECTED))
            System.out.println("Connection sucessful\n" + board);
        else System.exit(0);

        Thread t = new Thread() {
            public void run() {
                System.out.println("STARTED");
                String line;
                try {
                    while ((line = input.readLine()) != null) {
                        String[] l = line.split(" ");
                        if (l.length != 2) System.out.println("<row> <col>");
                        //TODO make the move using the board object...
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        };
        t.start();

        String line;
        while ((line = in.readLine()) != null) {
            switch(line) {
                case Protocol.MOVE_MADE:
                    System.out.println("MOVE MADE");
                    break;
                // TODO handle all cases here
            }
        }

    }

    private static void connect(String host, int port) throws IOException {
        System.out.println("Connecting to Tic Tac Toe game on port " + port);
        PTUI_Client client = new PTUI_Client(host, port);
        client.run();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!\nWould you like to:\n\ta) Start a new game\n\tb) Join a game\n\tc) Exit");
        boolean begin = false;
        while (!begin) {
            begin = true;
            String host = "localhost";
            int port = 0;
            switch (sc.nextLine().toLowerCase()) {

                case "a":
                    try {
                        System.out.print("Start a Tic Tac Toe game on what port? ");
                        port = sc.nextInt();
                        Server s = new Server(port);
                        s.start();
                    } catch (InputMismatchException e) {
                        System.out.println("That is not a valid port number");
                        begin = false;
                    } catch (IOException e) {
                        System.out.println("Cannot connect to that port");
                        begin = false;
                    }
                    break;
                case "b":
                    try {
                        System.out.print("Join a Tic Tac Toe game on what port? ");
                        port = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("That is not a valid port number");
                        begin = false;
                    }
                    break;
                case "c":
                    System.exit(0);
                    break;
                default:
                    begin = false;
                    System.out.println("Please type a, b, or c");
                    break;
            }
            try {
                connect(host, port);
            } catch (IOException e) {
                System.out.println("Cannot connect to that port");
                begin = false;
            }
        }
    }
}
