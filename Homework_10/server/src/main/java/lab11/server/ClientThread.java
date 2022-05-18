package lab11.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ClientThread extends Thread {

    private Socket socket = null;
    private Server server;
    private Person client;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();

            if (request.equals("stop")) {
                try {
                    socket.close();
                    System.out.println("Server stopped.");
                    System.exit(0);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }

            PrintWriter out = new PrintWriter(socket.getOutputStream());

            if (request.startsWith("register ")) {
                register(request, out);
            } else if (request.startsWith("login ")) {
                login(request, out);
            } else if (request.startsWith("friend ")) {
                friend(request, out);
            } else if (request.equals("exit")) {
                client.setLogged(false);
                server.getNetwork().getPerson(client.getName()).setLogged(false);
            } else {
                out.println("Comanda " + request + " nu exista!");
                out.flush();
            }
            System.out.println("Server received the request " + request + ".");
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

    private void register(String request, PrintWriter out) {
        String raspuns;
        char[] name = new char[20];
        request.getChars(9, request.length(), name, 0);
        if (server.getNetwork().exists(String.valueOf(name))) {
            raspuns = "User " + String.valueOf(name) + " already exists.";
            out.println(raspuns);
            out.flush();
        } else {
            Person person = new Person(String.valueOf(name));
            server.getNetwork().registerPerson(person);
            raspuns = "You have been registered as " + String.valueOf(name) + ". Login to access other commands.";
            out.println(raspuns);
            out.flush();
        }
    }

    private void login(String request, PrintWriter out) {
        String raspuns;
        char[] name = new char[20];
        request.getChars(6, request.length(), name, 0);
        if (server.getNetwork().exists(String.valueOf(name))) {
            if (server.getNetwork().getPerson(String.valueOf(name)).isLogged()) {
                raspuns = "You are already logged in.";
                out.println(raspuns);
                out.flush();
            } else {
                raspuns = "Hello " + String.valueOf(name) + "!";
                out.println(raspuns);
                out.flush();
                server.getNetwork().getPerson(String.valueOf(name)).setLogged(true);
                client.setName(String.valueOf(name));
                client.setLogged(true);
            }
        } else {
            raspuns = "The person with the name " + String.valueOf(name) + " is not registered.";
            out.println(raspuns);
            out.flush();
        }
    }

    public List<String> listOfNames(char[] names) {
        StringBuilder sb = new StringBuilder();
        List<String> nameList = new ArrayList<>();
        for (char c : names) {
            if (c != ' ') {
                sb.append(c);
            } else {
                nameList.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return nameList;
    }

    private void friend(String request, PrintWriter out) {
        String raspuns = "";
        char[] names = new char[100];
        request.getChars(7, request.length(), names, 0);
        List<String> nameList = new ArrayList<>(listOfNames(names));
        for (String name : nameList) {
            if (server.getNetwork().exists(String.valueOf(name))) {
                server.getNetwork().addFriendship(client.getName(), name);
                raspuns = raspuns.concat("You are now friends with " + name + "!\n");
            } else {
                raspuns = raspuns.concat("The person " + name + " does not exist!\n");
            }
        }
        out.print(raspuns);
        out.flush();
    }
}
