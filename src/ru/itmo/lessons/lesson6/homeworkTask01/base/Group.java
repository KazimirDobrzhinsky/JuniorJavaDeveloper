package ru.itmo.lessons.lesson6.homeworkTask01.base;

public class Group {
    private boolean groupStatus;
    private Climber[] climbers;
    private Mountain mountain;

    public Group(Mountain mountain, int climbersAmount) {
        this.groupStatus = true;
        this.mountain = mountain;
        this.climbers = new Climber[climbersAmount];
    }

    public void addClimber(Climber climber) {
        if (this.groupStatus) {
            for (int i = 0; i < this.climbers.length; i++) {
                if (this.climbers[i] == null) {
                    this.climbers[i] = climber;
                    System.out.println("Альпинист добавлен в группу под номером " + i);
                    if (i == this.climbers.length - 1) this.groupStatus = false;
                }
            }

        }
    }

    public void printGroupStatus() {
        System.out.println(this.groupStatus);
    }
}
