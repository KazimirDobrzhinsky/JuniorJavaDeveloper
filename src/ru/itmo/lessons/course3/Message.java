package ru.itmo.lessons.course3;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private final String sender;
    private final String text;
    private LocalDateTime dateTime;
    private int serverId;

    public Message(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getServerId() {
        return serverId;
    }

    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public int hashCode() {
        int result = sender.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + dateTime.hashCode();
        result = 31 * result + serverId;
        return result;
    }

    public static Message getMessage(String sender, String text) {
        return new Message(sender, text);
    }
}
