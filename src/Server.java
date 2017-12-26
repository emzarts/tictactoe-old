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

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
