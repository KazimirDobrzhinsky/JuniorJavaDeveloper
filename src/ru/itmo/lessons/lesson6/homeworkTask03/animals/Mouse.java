package ru.itmo.lessons.lesson6.homeworkTask03.animals;

public class Mouse {
    private int mouseSpeed;

    public void setMouseSpeed(int mouseSpeed) {
        if (mouseSpeed <= 0)
            throw new IllegalArgumentException("Скорость не может быть меньше или равно нулю");
        this.mouseSpeed = mouseSpeed;
    }

    public int getMouseSpeed() {
        return mouseSpeed;
    }
}
