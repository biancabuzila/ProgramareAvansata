package lab11.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 8100;
    public static int timeout = 20000;
    private SocialNetwork network = new SocialNetwork();

    public Server() throws IOException {
        try ( ServerSocket serverSocket = new ServerSocket(PORT)) {
            
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket, this).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }

    public SocialNetwork getNetwork() {
        return network;
    }
}
