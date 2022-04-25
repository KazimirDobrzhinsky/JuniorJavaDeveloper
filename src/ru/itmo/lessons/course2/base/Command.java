package ru.itmo.lessons.course2.base;

public interface Command {
    void execute(Game currentGame);

    static Command getInstance(String commandText, Game currentGame) {
        if (commandText.equalsIgnoreCase("1") && (currentGame == null)) {
            return new StartNewGame();
        } else if (commandText.equalsIgnoreCase("2") && (currentGame == null)) {
            return new LoadGame();
        } else if (commandText.equalsIgnoreCase("3") && (currentGame == null))
            return new Exit();
        if (commandText.equalsIgnoreCase("1") && (currentGame != null)) {
            return new ContinueGame(currentGame);
        } else if (commandText.equalsIgnoreCase("2") && (currentGame != null)) {
            return new SaveGame();
        } else if (commandText.equalsIgnoreCase("3") && (currentGame != null))
            return new LoadGame();
        else if (commandText.equalsIgnoreCase("4") && (currentGame != null))
            return new StartNewGame();
        else if (commandText.equalsIgnoreCase("5") && (currentGame != null))
            return new Exit();
        return null;

    }
}
