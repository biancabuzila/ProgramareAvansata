package lab11.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {

    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            String stop = "stop";
            if (request.equals(stop)) {
                try {
                    socket.close();
                    System.out.println("Server stopped.");
                    System.exit(0);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns = "Hello " + request + "!";
            out.println(raspuns);
            out.flush();
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
