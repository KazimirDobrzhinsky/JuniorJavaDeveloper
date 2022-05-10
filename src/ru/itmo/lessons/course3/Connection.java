package ru.itmo.lessons.course3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {

    private final Socket socket;
    private final ObjectInputStream inputStream;
    private final ObjectOutputStream outputStream;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        inputStream = new ObjectInputStream(this.socket.getInputStream());
    }

    public void sendMessage(Message message) throws IOException {
        message.setDateTime();
        outputStream.writeObject(message);
        outputStream.flush();
    }

    public Message readMessage() throws IOException, ClassNotFoundException {
        return (Message) inputStream.readObject();
    }
}
