package ru.itmo.lessons.course2.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class LoadGame implements Command{
    private File file;

    private void setFile(File file) {
        this.file = file;
    }

    @Override
    public void execute(Game currentGame) {
        System.out.println("Введите название для файла с сохранением (без расширения)");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine() + ".bin";
        this.setFile(new File(title));
        try (FileInputStream fileInput = new FileInputStream(this.file);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)){
            currentGame = (Game) objectInput.readObject();
            currentGame.playStage();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Не удалось получить данные из файла " + e.getMessage());
        }
    }
}
