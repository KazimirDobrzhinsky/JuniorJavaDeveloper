package ru.itmo.lessons.lesson7.homeWork.base;

import ru.itmo.lessons.lesson7.homeWork.base.Person;
import ru.itmo.lessons.lesson7.homeWork.base.Pupil;

public class Teacher  extends Person {
    private String teachSubject;
    private int teachSubjectLevel;

    public Teacher(String name, int age, String teachSubject, int teachSubjectLevel) {
        super(name, age);
        if (teachSubject == null || teachSubject.length() < 2 || teachSubject.startsWith(" ") || teachSubject.endsWith(" ")) {
            throw new IllegalArgumentException("Название изучаемого предмета не может быть null или короче 2х символов или начинатся/заканчиваться пробелом");
        }
        if (teachSubjectLevel < 30) {
            throw new IllegalArgumentException("Уровень учителя не может быть меньше 30");
        }
        this.teachSubject = teachSubject;
        this.teachSubjectLevel = teachSubjectLevel;
    }

    public void toTeach(Pupil pupil) {
        if (this.teachSubject.equalsIgnoreCase(pupil.getStudySubject())) {
            pupil.setStudySubjectLevel(pupil.getStudySubjectLevel() + (int) (Math.random() * (pupil.getStudySubjectLevel() + 1)));
        }

    }

    public String getTeachSubject() {
        return teachSubject;
    }

    public int getTeachSubjectLevel() {
        return teachSubjectLevel;
    }


}


