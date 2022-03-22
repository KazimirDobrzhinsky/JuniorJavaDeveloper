package ru.itmo.lessons.lesson6.homeworkTask03.animals;

import ru.itmo.lessons.lesson6.books.Book;

public class Cat {
    private String name;
    private int speed;
    private int weight;
    private Mouse[] catMouse = new Mouse[100];

    public Cat(String name, int speed, int weight) {
        if (name == null || name.length() < 2 || name.startsWith(" ") || name.endsWith(" "))
            throw new IllegalArgumentException("Название продуктов не может быть null или короче 2х символов или начинатся/заканчиваться пробелом");
        if (speed <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Вес и скорость не могут быть меньше 0");
        }
        this.name = name;
        this.speed = speed;
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void catchMouse(Mouse mouse) {
        if (mouse.getMouseStatusCaught()) {
            System.out.println("Эта мыш уже поймана " + mouse.getWhoCaught().getName());
            return;
        }
        if (mouse.getSpeed() > this.getSpeed()) {
            System.out.println("Мыш убежала");
            return;
        }
        for (int i = 0; i < this.catMouse.length; i++) {
            if (this.catMouse[i] == null) {
                this.catMouse[i] = mouse;
                mouse.setWhoCaught(this);
                mouse.setMouseStatusCaught(true);
                System.out.println("Мыш поймана, теперь у кота " + this.getName()+ " имеется " + (i + 1) + " мышей");
                return;
            }
        }
        System.out.println("Кот уже наловил 100 мышей");
    }

    public void catVsCat(Cat secondCat) {
        if (this.getWeight() < secondCat.getWeight()) {
            System.out.println("Маленький еще");
            return;
        }
        for (int i = 0; i < secondCat.catMouse.length; i++) {
            if (secondCat.catMouse[i] == null) continue;
            secondCat.catMouse[i].setWhoCaught(null);
            secondCat.catMouse[i].setMouseStatusCaught(false);
            this.catchMouse(secondCat.catMouse[i]);
        }

    }

}
