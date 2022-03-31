package ru.itmo.lessons.course1;

public enum Zones {
    SWIMPOOL {
        @Override
        public String returnRussianNameOfZone() {
            return "Бассейн";
        }
    },
    GYM{
        @Override
        public String returnRussianNameOfZone() {
            return "Тренажерный зал";
        }
    },
    GROUP {
        @Override
        public String returnRussianNameOfZone() {
            return "Групповые занятия";
        }
    };

    public abstract String returnRussianNameOfZone();
}
