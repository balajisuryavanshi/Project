package com.chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
	private static final int port = 1234;
	private static Set<Socket> clientSockets = Collections.synchronizedSet(new HashSet<>());
	
	public static void main(String[] args) {
		try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                clientSockets.add(socket);
                System.out.println("New client connected: " + socket.getInetAddress());

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                writer.println("Welcome to the chat! Type 'exit' to leave.");

                String message;
                while ((message = reader.readLine()) != null) {
                    if (message.equalsIgnoreCase("exit")) {
                        System.out.println("Client disconnected: " + socket.getInetAddress());
                        break;
                    }
                    System.out.println("Received: " + message);
                    broadcast(message, socket);
                }
            } catch (IOException e) {
                System.out.println("Connection error: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                    clientSockets.remove(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message, Socket sender) {
            synchronized (clientSockets) {
                for (Socket s : clientSockets) {
                    if (s != sender) {
                        try {
                            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                            pw.println("Message: " + message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}