package lab11.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try ( Socket socket = new Socket(serverAddress, PORT);  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String request, response;
            Scanner scan = new Scanner(System.in);
            while (true) {
                System.out.println("Enter request: ");
                request = scan.nextLine();
                out.println(request);

                if (request.equals("stop")) {
                    System.out.println("Client and server stopped.");
                    break;
                }
                if (request.equals("exit")) {
                    System.out.println("Client exited.");
                    break;
                }
                
                response = in.readLine();
                System.out.println(response);
            }

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
