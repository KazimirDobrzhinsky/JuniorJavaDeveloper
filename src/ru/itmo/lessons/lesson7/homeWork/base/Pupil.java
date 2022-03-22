package ru.itmo.lessons.lesson7.homeWork.base;

public class Pupil extends Person {
    private String studySubject;
    private int studySubjectLevel;

    public Pupil(String name, int age, String studySubject, int studySubjectLevel) {
        super(name, age);
        if (studySubject == null || studySubject.length() < 2 || studySubject.startsWith(" ") || studySubject.endsWith(" ")) {
            throw new IllegalArgumentException("Название изучаемого предмета не может быть null или короче 2х символов или начинатся/заканчиваться пробелом");
        }
        if (studySubjectLevel < 0 || studySubjectLevel > 18) {
            throw new IllegalArgumentException("Начальный уровень ученика не может быть меньше 0 или больше 18");
        }
        this.studySubject = studySubject;
        this.studySubjectLevel = studySubjectLevel;
    }

    public void toStudy(Teacher teacher) {
        if (this.studySubject.equalsIgnoreCase(teacher.getTeachSubject())) {
            this.studySubjectLevel += (int) (Math.random()*(teacher.getTeachSubjectLevel()+1));
        }

    }

    public String getStudySubject() {
        return studySubject;
    }

    public int getStudySubjectLevel() {
        return studySubjectLevel;
    }

    void setStudySubjectLevel(int studySubjectLevel) {
        this.studySubjectLevel = studySubjectLevel;
    }
}