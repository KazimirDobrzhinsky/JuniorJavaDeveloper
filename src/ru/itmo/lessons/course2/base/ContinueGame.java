package ru.itmo.lessons.course2.base;

public class ContinueGame implements Command{
    private Game currentGame;

    public ContinueGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    @Override
    public void execute(Game currentGame) {
        currentGame.playStage();
    }
}
