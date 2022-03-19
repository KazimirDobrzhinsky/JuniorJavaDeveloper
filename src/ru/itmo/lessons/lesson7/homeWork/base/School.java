package ru.itmo.lessons.lesson7.homeWork.base;

public class School {
    // private boolean statusOfWork;
    private String schoolName;
    private Director schoolDirector;
    private Pupil[] schoolPupils = new Pupil[15];
    private Teacher[] schoolTeachers = new Teacher[5];

    public School(String schoolName, Director schoolDirector) {
        if (schoolName == null || schoolName.length() < 2 || schoolName.startsWith(" ") || schoolName.endsWith(" ")) {
            throw new IllegalArgumentException("Название не может быть null или короче 2х символов или начинатся/заканчиваться пробелом");
        }
        if (schoolDirector == null) {
            throw new IllegalArgumentException("Такого директора не существует");
        }
        this.schoolName = schoolName;
        this.schoolDirector = schoolDirector;
    }

    public void setSchoolPupils(Pupil... schoolPupils) {
        this.schoolPupils = schoolPupils;
    }

    public void setSchoolTeacher(Teacher... schoolTeacher) {
        this.schoolTeachers = schoolTeacher;
    }

    /*public boolean getStatusOfWork() {
        return statusOfWork;
    }

    public String getSchoolDirector() {
        return schoolDirector.name;
    }

    void setStatusOfWork(boolean statusOfWork) {
        this.statusOfWork = statusOfWork;
    }*/

    public void dayAtSchool() {
        schoolDirector.startStudy();
        for (Teacher teacher : schoolTeachers) {
            if (teacher != null) {
                for (Pupil pupil : schoolPupils) {
                    if (pupil != null) {
                        teacher.toTeach(pupil);
                    }
                }
            }

        }
        schoolDirector.endStudy();
    }
}
