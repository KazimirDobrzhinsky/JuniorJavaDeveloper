package ru.itmo.lessons.lesson20.soketio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

interface Command{
    void execute() throws IOException, ClassNotFoundException;

    static Command getCommand(String command, EchoServer server, SimpleMessage input){
        if (command.equalsIgnoreCase(CommandList.COUNT.getText())) {
            return new Count(server);
        }
        if (command.equalsIgnoreCase(CommandList.HELP.getText())) {
            return new Help(server);
        }
        if (command.equalsIgnoreCase(CommandList.EXIT.getText())) {
            return new Exit(server);
        }
        if (command.equalsIgnoreCase(CommandList.PING.getText())) {
            return new Ping(server, input);
        }
        return null;
    }
}

class Count implements Command{
    private EchoServer server;

    public Count(EchoServer server) {
        this.server = server;
    }

    public EchoServer getServer() {
        return server;
    }

    @Override
    public void execute() throws IOException {
        this.getServer().getConnection().sendMessage(SimpleMessage.getMessage("server", "Кол-во подключений - " + this.getServer().getClientNameSet().size()));
    }
}

class Help implements Command{
    private EchoServer server;

    public Help(EchoServer server) {
        this.server = server;
    }

    public EchoServer getServer() {
        return server;
    }

    @Override
    public void execute() throws IOException {
        this.getServer().getConnection().sendMessage(SimpleMessage.getMessage("server", "Перечень доступных команд - " + CommandList.getAllText()));
    }
}

class Ping implements Command{
    private EchoServer server;
    private SimpleMessage input;

    public Ping(EchoServer server, SimpleMessage input) {
        this.server = server;
        this.input = input;
    }

    public EchoServer getServer() {
        return server;
    }

    @Override
    public void execute() throws IOException {
        this.getServer().getConnection().sendMessage(SimpleMessage.getMessage("server", "Пинг (в милисекундах) - " + Duration.between(input.getDateTime(), LocalDateTime.now()).toMillis()));
    }
}

class Exit implements Command{
    private EchoServer server;

    public Exit(EchoServer server) {
        this.server = server;
    }

    @Override
    public void execute()  {
        System.out.println("Клиент отключился");
    }
}



public class EchoServer {


    private int port;
    private Connection connection;
    private HashSet<String> clientNameSet = new HashSet<>();

    public EchoServer(int port){
        this.port = port;
    }

    public Connection getConnection() {
        return connection;
    }

    public HashSet<String> getClientNameSet() {
        return clientNameSet;
    }



    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            while (true){
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                SimpleMessage input = connection.readMessage();
                this.clientNameSet.add(input.getSender());
                printMessage(input);
                Command command = Command.getCommand(input.getText(), this, input);
                if (command != null) {
                    command.execute();
                } else connection.sendMessage(SimpleMessage.getMessage("server", "сообщение получено"));
            }
        }
    }

    private void printMessage(SimpleMessage message){
        System.out.println("получено сообщение: " + message);
    }

    public static void main(String[] args) {
        int port = 8090;
        EchoServer messageServer = new EchoServer(port);
        try {
            messageServer.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
