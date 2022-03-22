package ru.itmo.lessons.lesson6.homeworkTask03;

import ru.itmo.lessons.lesson6.homeworkTask03.animals.Cat;
import ru.itmo.lessons.lesson6.homeworkTask03.animals.Mouse;

public class Application {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Василий", 80, 25);
        Cat cat2 = new Cat("Васька", 150, 10);

        Mouse[] groupMouse = new Mouse[100];
        Mouse[] groupMouse2 = new Mouse[100];

        for (int i = 0; i < groupMouse.length; i++) {
            groupMouse[i] = new Mouse(70);
        }

        for (int i = 0; i < groupMouse.length; i++) {
            groupMouse2[i] = new Mouse(20);
        }


        for (Mouse mouse : groupMouse) {
                 cat1.catchMouse(mouse);
        }

        for (Mouse mouse : groupMouse2) {
            cat2.catchMouse(mouse);
        }

        cat1.catVsCat(cat2);




    }


}
