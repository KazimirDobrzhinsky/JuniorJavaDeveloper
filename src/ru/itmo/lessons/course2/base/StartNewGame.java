package ru.itmo.lessons.course2.base;

public class StartNewGame implements Command{

    @Override
    public void execute(Game currentGame) {
        System.out.println("Для выбора варианта ответа необходимо вводить с клавиатуры 1 или 2");
        currentGame = new Game();
        currentGame.setGameStage(Stage.FOX);
        currentGame.playStage();
    }
}
