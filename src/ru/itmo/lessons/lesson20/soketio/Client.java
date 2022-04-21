package ru.itmo.lessons.lesson20.soketio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private int port;
    private String ip;
    private Scanner scanner;
    private String name;

    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
    }


    public void start() throws Exception {
        System.out.println("Введите имя");
        this.name = scanner.nextLine();
        String messageText;

        while (true){
            System.out.println("Введите сообщение");
            messageText = scanner.nextLine();
            sendAndPrintMessage(SimpleMessage.getMessage(name, messageText));
        }
    }


    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(getSocket())){ // getSocket Только для того, чтобы посмотреть методы сокета
            connection.sendMessage(message);
            if (message.getText().equalsIgnoreCase(CommandList.EXIT.getText())) {
                System.out.println("Выход из программы");
                System.exit(0);
            }

            SimpleMessage formServer = connection.readMessage();
            System.out.println("ответ от сервера: " + formServer);
        }
    }

    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
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
