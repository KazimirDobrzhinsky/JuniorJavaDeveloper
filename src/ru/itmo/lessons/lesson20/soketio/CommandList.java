package ru.itmo.lessons.lesson20.soketio;

public enum CommandList {
    HELP("help"), COUNT("count"), PING("ping"), EXIT("exit");
    private final String text;

    CommandList(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    static public String getAllText() {
        StringBuilder sb = new StringBuilder();
        for (CommandList cmd: CommandList.values()) {
            sb.append(cmd.getText()).append(" / ");
        }
        return sb.toString();
    }
}
