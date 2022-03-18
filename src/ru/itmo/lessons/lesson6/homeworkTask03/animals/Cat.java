package ru.itmo.lessons.lesson6.homeworkTask03.animals;

import ru.itmo.lessons.lesson6.books.Book;

public class Cat {
    private String Name;
    private int Speed;
    private int Weight;
    private Mouse[] catMouse = new Mouse[100];

    public void setName(String name) {
        if (name == null || name.length() < 2 || name.startsWith(" ") || name.endsWith(" "))
            throw new IllegalArgumentException("Имя кота не может быть null или короче 2х символов или начинатся/заканчиваться пробелом");
        this.Name = name;
    }

    public void setSpeed(int speed) {
        if (speed <= 0)
            throw new IllegalArgumentException("Скорость не может быть меньше или равно нулю");
        this.Speed = speed;
    }

    public void setWeight(int weight) {
        if (weight <= 0)
            throw new IllegalArgumentException("Вес не может быть меньше или равно нулю");
        this.Weight = weight;
    }

    public String getName() {
        return Name;
    }

    public int getSpeed() {
        return Speed;
    }

    public int getWeight() {
        return Weight;
    }

    public Cat(String name, int speed, int weight) {
        setName(name);
        setSpeed(speed);
        setWeight(weight);
    }

    public void catchMouse(Cat cat, Mouse mouse) {
        if (cat.getSpeed() > mouse.getMouseSpeed()) {
            for (int i = 0; i < catMouse.length; i++) {
                if (catMouse[i] == null) {
                    catMouse[i] = mouse;
                    return;
                }
            }
        }
    }

    public void fightCat(Cat cat1, Cat cat2) {
        if (cat1.getWeight() > cat2.getWeight()) {
            for (int i = 0; i < cat2.catMouse.length; i++) {
                if (cat1.getSpeed() > cat2.catMouse[i].getMouseSpeed()) {
                    for (int j = 0; j < cat1.catMouse.length; j++) {
                        if (cat1.catMouse[j] == null) {
                            cat1.catMouse[j] = cat2.catMouse[i];
                            return;
                        }
                    }
                }
            }
        }
    }

}
