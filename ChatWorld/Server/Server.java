package Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        @SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("[Server] Waiting for clients to connect...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("[Server] A new client has connected.");
            
            ClientHandler clientHandler = new ClientHandler(clientSocket, clients);
            clients.add(clientHandler);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader input;
    private PrintWriter output;
    private List<ClientHandler> clients;

    public ClientHandler(Socket socket, List<ClientHandler> clients) throws IOException {
        this.clientSocket = socket;
        this.clients = clients;
        this.input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.output = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            String messageFromClient;

            while (true) {
                messageFromClient = input.readLine();
                if (messageFromClient == null || messageFromClient.equalsIgnoreCase("exit")) {
                    System.out.println("[Server] Client disconnected.");
                    break;
                }

                System.out.println("[Server] Client says: " + messageFromClient);
                broadcastMessage(messageFromClient);
            }

            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            clients.remove(this);
        }
    }
    
    private void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            if (client != this) {
                client.output.println("[Broadcast] " + message);
            }
        }
    }
}
