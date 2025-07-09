/*
 * ChatServer.java
 * Author: Vishal Thakur <vishalthakurx@gmail.com>
 * GitHub: @vishalthakurx
 * Description: Simple multithreaded chat server using sockets.
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<PrintWriter> clients = Collections.synchronizedSet(new HashSet<>());
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Chat server started on port 12345");
            while (true) {
                Socket socket = server.accept();
                new Thread(() -> handleClient(socket)).start();
            }
        }
    }
    static void handleClient(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            clients.add(out);
            String msg;
            while ((msg = in.readLine()) != null) {
                for (PrintWriter client : clients) client.println(msg);
            }
        } catch (IOException e) {} finally {
            clients.removeIf(pw -> pw.checkError());
        }
    }
}
