package ru.itmo.lessons.course2.base;

import java.io.Serializable;
import java.util.Scanner;

public class Game implements Serializable {
    private Stage gameStage;


    void setGameStage(Stage gameStage) {
        this.gameStage = gameStage;
    }


    public Stage getGameStage() {
        return gameStage;
    }

    public void playStage() {
        System.out.println(this.getGameStage().getTitle());
        System.out.println(this.getGameStage().getText());
        if (this.getGameStage().getFirstReply() != null) {
            System.out.println(this.getGameStage().getFirstReply());
            System.out.println(this.getGameStage().getSecondReply());
            System.out.println("3. Выход в меню");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("1")) {
                    this.setGameStage(this.getGameStage().getNextStageFirst());
                    this.playStage();
                    break;
                } else if (answer.equalsIgnoreCase("2")) {
                    this.setGameStage(this.getGameStage().getNextStageSecond());
                    this.playStage();
                    break;
                } else if (answer.equalsIgnoreCase("3")) {
                    Command command = new OpenMenu();
                    command.execute(this);
                    break;
                }
                System.out.println("Некорректный ввод");
            }
        } else if (this.getGameStage().isWin()) {
            System.out.println("Игра завершилась успехом");
        } else {
            System.out.println("Игра завершилась неудачей");
        }

    }
}


