package ru.itmo.lessons.course2.base;

import java.io.*;
import java.util.Scanner;

public class SaveGame implements Command{
    private File file;

    private void setFile(File file) {
        this.file = file;
    }

    @Override
    public void execute(Game currentGame) {
        System.out.println("Введите название для сохраняемого файла (без расширения)");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine() + ".bin";
        this.setFile(new File(title));
        try (FileOutputStream fileOutput = new FileOutputStream(this.file);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
            objectOutput.writeObject(currentGame);
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось использовать файл");
        } catch (IOException e) {
            System.out.println("Не удалось записать данные в файл");
        }
        Command command = new OpenMenu();
        command.execute(currentGame);
    }
}
