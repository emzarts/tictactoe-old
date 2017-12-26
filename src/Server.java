import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server extends Thread {

    private ServerSocket server;
    private int port;
    private Board board;
    private PrintWriter out;
    private PrintWriter out2;
    private BufferedReader in;
    private BufferedReader in2;

    Server(int port) throws IOException{
        this.server = new ServerSocket(port);
        this.port = port;
        this.board = new Board();
    }

    public void run() {
        try {
            Socket client = server.accept();
            this.out =
                    new PrintWriter(client.getOutputStream(), true);
            this.in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            System.out.println("Waiting for player two...");

            Socket client2 = server.accept();
            this.out2 =
                    new PrintWriter(client2.getOutputStream(), true);
            this.in2 = new BufferedReader(
                    new InputStreamReader(client2.getInputStream()));
            System.out.println("Player two connected");

            out.println(Protocol.CONNECTED);
            out2.println(Protocol.CONNECTED);

            String line;
            while ((line = in.readLine()) != null) {
                if (line.equals(Protocol.MOVE_MADE))
                    System.out.println("MOVE_MADE");
                System.out.println(line);
                out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
