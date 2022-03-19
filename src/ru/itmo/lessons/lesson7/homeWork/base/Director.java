package ru.itmo.lessons.lesson7.homeWork.base;

import ru.itmo.lessons.lesson7.homeWork.base.School;

public class Director extends Person{

    public Director(String name, int age) {
        super(name, age);
    }

    public void startStudy() {
        System.out.println("Занятия начались");
    }

    public void endStudy() {
        System.out.println("Занятия закончились");
    }

    /*public void declareStart(School school) {
        if (!school.getSchoolDirector().equals(this.name)) {
            throw new IllegalArgumentException("Директор не может объявить начало занятий в чужой школе");
        }
        if (school.getStatusOfWork()) {
            throw new IllegalArgumentException("Занятия уже начались");
        }
        school.setStatusOfWork(true);
    }*/

}
