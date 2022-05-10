package ru.itmo.lessons.course3;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final int port;
    private final String ip;
    private final Scanner scanner;
    private String clientName;
    private Connection connection;


    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
        this.scanner = new Scanner((System.in));
    }

    private Socket getSocket() throws IOException {
        return new Socket(ip, port);
    }

    public void start() {
        System.out.println("Введите имя");
        this.clientName = scanner.nextLine();
        try {
            this.connection = new Connection(getSocket());
            ClientSendThread outputThread = new ClientSendThread(this, this.getScanner());
            ClientReceiveThread inputThread = new ClientReceiveThread(this);
            inputThread.start();
            outputThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(Message message, Connection connection) throws IOException {
        connection.sendMessage(message);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public String getClientName() {
        return clientName;
    }

    private class ClientReceiveThread extends Thread {
        private final Client client;

        public ClientReceiveThread(Client client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Message inputMessage = this.client.connection.readMessage();
                    System.out.println("Входящее сообщение: " + inputMessage);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClientSendThread extends Thread {
        private final Client client;
        private final Scanner scanner;

        public ClientSendThread(Client client, Scanner scanner) {
            this.client = client;
            this.scanner = scanner;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    String messageText;
                    System.out.println("Введите сообщение");
                    messageText = scanner.nextLine();
                    if (messageText.equals("break")) {
                        new breakCommand().execute(this.client);
                    }
                    this.client.sendMessage(Message.getMessage(this.client.getClientName(), messageText), this.client.connection);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class breakCommand implements Command {
        @Override
        public void execute(Client client) {
            System.out.println("Отключение клиента");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        int port = 8090;
        String ip = "127.0.0.1";

        try {
            new Client(port, ip).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




