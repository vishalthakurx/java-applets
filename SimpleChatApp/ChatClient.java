/*
 * ChatClient.java
 * Author: Vishal Thakur <vishalthakurx@gmail.com>
 * GitHub: @vishalthakurx
 * Description: Simple chat client for the chat server.
 */
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 12345)) {
            new Thread(() -> {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String msg;
                    while ((msg = in.readLine()) != null) System.out.println(msg);
                } catch (IOException e) {}
            }).start();
            try (BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                String line;
                while ((line = user.readLine()) != null) out.println(line);
            }
        }
    }
}
