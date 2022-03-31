package ru.itmo.lessons.course1;

import java.time.LocalDate;


public class Client {
    private String name;
    private String surname;
    private LocalDate birthDate;

    public void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя менее 2х символов");
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя менее 2х символов");
        }
        this.surname = surname;
    }

    private void setBirthDate(String birthDateString) {
        LocalDate currentDate = LocalDate.now();
        LocalDate tempBirthDate;
        tempBirthDate = LocalDate.parse(birthDateString);
        if (tempBirthDate.isAfter(currentDate.minusYears(16))) {
            throw new IllegalArgumentException("Возраст клиента не меньше 16 лет");
        }
        this.birthDate = tempBirthDate;
    }

    public Client(String name, String surname, String birthDate) {
        this.setName(name);
        this.setSurname(surname);
        this.setBirthDate(birthDate);
    }

    @Override
    public String toString() {
        return "Клиент: " +
                "Имя - " + name +
                ", Фамилия - " + surname +
                ", Дата рождения = - " + birthDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


}
