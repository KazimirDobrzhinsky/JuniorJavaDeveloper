package ru.itmo.lessons.course2.base;

public class Exit implements Command{
    @Override
    public void execute(Game currentGame) {
        System.out.println("Выход из игры");
        System.exit(0);
    }
}
