package ru.itmo.lessons.lesson7.homeWork;

import ru.itmo.lessons.lesson7.homeWork.base.Director;
import ru.itmo.lessons.lesson7.homeWork.base.Pupil;
import ru.itmo.lessons.lesson7.homeWork.base.School;
import ru.itmo.lessons.lesson7.homeWork.base.Teacher;

public class Application {

    public static void main(String[] args) {
        Pupil pupil1 = new Pupil("Вася", 18, "Математика", 10);
        Pupil pupil2 = new Pupil("Иван", 18, "Русский язык", 10);
        Pupil pupil3 = new Pupil("Алексей", 18, "Математика", 9);
        Pupil pupil4 = new Pupil("Илья", 18, "Русский язык", 7);

        System.out.println(pupil1.getStudySubject() + " " + pupil1.getStudySubjectLevel());
        System.out.println(pupil2.getStudySubject() + " " + pupil2.getStudySubjectLevel());
        System.out.println(pupil3.getStudySubject() + " " + pupil3.getStudySubjectLevel());
        System.out.println(pupil4.getStudySubject() + " " + pupil4.getStudySubjectLevel());

        Teacher teacher1 = new Teacher("Учитель 1", 80, "Математика", 60);
        Teacher teacher2 = new Teacher("Учитель 2", 80, "Русский язык", 45);

        Director director = new Director("Иван Васильевич Грозный", 491);

        School school = new School("Школа Жизни", director);

        school.setSchoolPupils(pupil1, pupil2, pupil3, pupil4);
        school.setSchoolTeacher(teacher1,teacher2);

        school.dayAtSchool();

        System.out.println(pupil1.getStudySubject() + " " + pupil1.getStudySubjectLevel());
        System.out.println(pupil2.getStudySubject() + " " + pupil2.getStudySubjectLevel());
        System.out.println(pupil3.getStudySubject() + " " + pupil3.getStudySubjectLevel());
        System.out.println(pupil4.getStudySubject() + " " + pupil4.getStudySubjectLevel());
    }




}
