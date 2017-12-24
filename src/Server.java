import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;
    int port;

    Server(int port) throws IOException{
        this.server = new ServerSocket(port);
        this.port = port;
        this.run();
    }

    void run() {
        System.out.println("Starting a game on port " + port);
        try {
            Socket client = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
