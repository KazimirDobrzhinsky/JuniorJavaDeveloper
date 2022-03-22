package ru.itmo.lessons.lesson6.homeworkTask01.base;

public class Climber {
    private final String climberName;
    private final String climberAddress;

    public Climber(String name, String address) {
        if (name == null || name.length() < 4) {
            throw new IllegalArgumentException("Имя не может быть null или менее 3х символов");
        }
        if (address == null || address.length() < 6) {
            throw new IllegalArgumentException("Адресс не может быть null или менее 5ти символов");
        }
        this.climberName= name;
        this.climberAddress = address;
    }
}
