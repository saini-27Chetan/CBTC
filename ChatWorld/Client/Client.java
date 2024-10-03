package Client;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String hostname = "localhost";
        int port = 8080;
        Socket socket = new Socket(hostname, port);
        System.out.println("[Client] Connected to the server.");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        String messageFromServer, messageToServer;
        
        while (true) {
            System.out.print("[Client] You: ");
            messageToServer = consoleInput.readLine();
            output.println(messageToServer);

            messageFromServer = input.readLine();
            if (messageFromServer == null || messageFromServer.equalsIgnoreCase("exit")) {
                System.out.println("[Client] Server disconnected.");
                break;
            }
            System.out.println("[Client] Server says: " + messageFromServer);
        }
        socket.close();
    }
}
