import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server extends Thread {
    ServerSocket server;
    int port;
    Board board;
    PrintWriter out;
    PrintWriter out2;
    BufferedReader in;
    BufferedReader in2;

    Server(int port) throws IOException{
        this.server = new ServerSocket(port);
        this.port = port;
        this.board = new Board();
    }

    public void run() {
        System.out.println("Starting a game on port " + port);
        try {
            Socket client = server.accept();
            this.out =
                    new PrintWriter(client.getOutputStream(), true);
            this.in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            System.out.println("first client connected");

            Socket client2 = server.accept();
            this.out =
                    new PrintWriter(client2.getOutputStream(), true);
            this.in = new BufferedReader(
                    new InputStreamReader(client2.getInputStream()));
            System.out.println("second client connected");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
