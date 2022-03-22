package ru.itmo.lessons.lesson6.homeworkTask01.base;

public class Mountain {
    private final String mountainName;
    private final String mountainCountry;
    private final int mountainHeight;



    public Mountain(String mountainName, String mountainCountry, int mountainHeight) {
        if (mountainName == null || mountainName.length() < 5)
            throw new IllegalArgumentException("Название не может быть null или менее 4х символов");
        if (mountainCountry == null || mountainCountry.length() < 5)
            throw new IllegalArgumentException("Страна не может быть null или менее 4х символов");
        if (mountainHeight < 100)
            throw new IllegalArgumentException("И это вы называете горой");
        this.mountainName = mountainName;
        this.mountainCountry = mountainCountry;
        this.mountainHeight = mountainHeight;
    }
}
