package ru.itmo.lessons.lesson6.homeworkTask03.animals;

public class Mouse {
    private final int speed;
    private Cat whoCaught;
    private boolean mouseStatusCaught;

    public Mouse(int speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("Скорость не может быть меньше 0");
        }
        this.speed = speed;
        this.mouseStatusCaught = false;
    }

    public boolean getMouseStatusCaught() {
        return mouseStatusCaught;
    }

    void setMouseStatusCaught(boolean mouseStatusCaught) {
        this.mouseStatusCaught = mouseStatusCaught;
    }

    void setWhoCaught(Cat whoCaught) {
        this.whoCaught = whoCaught;
    }

    public Cat getWhoCaught() {
        if (this.whoCaught == null) {
            System.out.println("Мыш свободна");
            return null;
        }
        return this.whoCaught;
    }

    public int getSpeed() {
        return speed;
    }
}
