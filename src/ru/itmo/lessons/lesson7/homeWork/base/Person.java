package ru.itmo.lessons.lesson7.homeWork.base;

public abstract class Person {
    protected String name;
    protected int age;


    public Person(String name, int age) {
        if (age < 6) {
            throw new IllegalArgumentException("Иди в садик");
        }
        if (name == null || name.length() < 2 || name.startsWith(" ") || name.endsWith(" ")) {
            throw new IllegalArgumentException("Имя не может быть null или короче 2х символов или начинатся/заканчиваться пробелом");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
