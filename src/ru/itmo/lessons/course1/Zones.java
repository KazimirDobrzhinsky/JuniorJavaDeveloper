package ru.itmo.lessons.course1;

public enum Zones {
    SWIMPOOL("Бассейн"),
    GYM("Тренажерный зал"),
    GROUP("Групповые занятия");
    private final String russianNameOfZone;

    Zones(String russianNameOfZone) {
        this.russianNameOfZone = russianNameOfZone;
    }

    public String getRussianNameOfZone() {
        return russianNameOfZone;
    }
}




