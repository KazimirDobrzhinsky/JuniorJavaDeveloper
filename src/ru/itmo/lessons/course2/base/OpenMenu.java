package ru.itmo.lessons.course2.base;

import java.util.Scanner;

public class OpenMenu implements Command{
    @Override
    public void execute(Game currentGame) {
        if (currentGame == null) {
            System.out.println("Главное меню (для выбора введите число):");
            System.out.println("1. Начать игру");
            System.out.println("2. Загрузить игру");
            System.out.println("3. Выйти");
            Scanner scanner = new Scanner(System.in);
            String reply;
            while (true) {
                reply = scanner.nextLine();
                if (!reply.equalsIgnoreCase("1") && !reply.equalsIgnoreCase("2") && !reply.equalsIgnoreCase("3")) {
                    System.out.println("Некорректный ввод");
                } else {
                    Command command = Command.getInstance(reply,currentGame);
                    command.execute(currentGame);
                    break;
                }
            }
        } else
        {
            System.out.println("Главное меню:");
            System.out.println("1. Продолжить игру");
            System.out.println("2. Сохранить игру");
            System.out.println("3. Зарузить игру");
            System.out.println("4. Начать новую игру");
            System.out.println("5. Выйти");
            Scanner scanner = new Scanner(System.in);
            String reply;
            while (true) {
                reply = scanner.nextLine();
                if (!reply.equalsIgnoreCase("1") && !reply.equalsIgnoreCase("2") && !reply.equalsIgnoreCase("3") && !reply.equalsIgnoreCase("4")&& !reply.equalsIgnoreCase("5")) {
                    System.out.println("Некорректный ввод");
                } else {
                    Command command = Command.getInstance(reply,currentGame);
                    command.execute(currentGame);
                    break;
                }
            }
        }
    }
}
