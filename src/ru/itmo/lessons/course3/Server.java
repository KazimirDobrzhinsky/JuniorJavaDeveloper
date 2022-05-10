package ru.itmo.lessons.course3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private final int port;
    private final ConcurrentHashMap<Integer, Connection> clients = new ConcurrentHashMap<>();
    private final ArrayBlockingQueue<Message> inputMessages = new ArrayBlockingQueue<>(10);

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started...");
        Thread outputThread = new ServerSendThread(this);
        outputThread.start();
        while (true) {
            Socket inputSocket = serverSocket.accept();
            Connection connection = new Connection(inputSocket);
            Thread inputThread = new ServerReceiveThread(this, connection);
            inputThread.start();
        }
    }

    public Server(int port) {
        this.port = port;
    }

    public void addClient(int clientName, Connection connection) {
        this.clients.put(clientName, connection);
    }

    public ArrayBlockingQueue<Message> getInputMessages() {
        return inputMessages;
    }

    public void addMessage(Message message) {
        this.inputMessages.add(message);
    }

    private class ServerReceiveThread extends Thread {
        private final Server server;
        private final Connection connection;
        private Integer serverIDForThisConnection;


        public ServerReceiveThread(Server server, Connection connection) {
            this.server = server;
            this.connection = connection;
        }

        @Override
        public void run() {
            try {
                Message input = this.connection.readMessage();
                System.out.println("Получено сообщение: " + input);
                this.serverIDForThisConnection = input.hashCode();
                input.setServerId(this.serverIDForThisConnection);
                this.server.addClient(this.serverIDForThisConnection, this.connection);
                this.server.addMessage(input);
                while (true) {
                    input = this.connection.readMessage();
                    System.out.println("Получено сообщение: " + input);
                    input.setServerId(this.serverIDForThisConnection);
                    this.server.addMessage(input);
                }
            } catch (SocketException e) {
                System.out.println("Клиент отключился. ID: " + this.serverIDForThisConnection);
                this.server.clients.values().remove(this.connection);
                this.interrupt();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private class ServerSendThread extends Thread {
        private final Server server;

        public ServerSendThread(Server server) {
            this.server = server;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (this.server.clients.size() > 1) {
                        Message outputMessage = this.server.getInputMessages().take();
                        for (Map.Entry<Integer, Connection> client : this.server.clients.entrySet()) {
                            if (!client.getKey().equals(outputMessage.getServerId())) {
                                client.getValue().sendMessage(outputMessage);
                            }
                        }
                    }
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port = 8090;
        Server messageServer = new Server(port);
        try {
            messageServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
