package ru.itmo.lessons.course2;

import ru.itmo.lessons.course2.base.OpenMenu;

public class App {
    public static void main(String[] args) {
        System.out.println("Текстовый квест - Лисенок");
        (new OpenMenu()).execute(null);
    }

}
