package ru.itmo.lessons.lesson6.homeworkTask01;

import ru.itmo.lessons.lesson6.homeworkTask01.base.Climber;
import ru.itmo.lessons.lesson6.homeworkTask01.base.Group;
import ru.itmo.lessons.lesson6.homeworkTask01.base.Mountain;

public class Application {

    public static void main(String[] args) {
        Mountain mountain1 = new Mountain("Эверест", "Непал", 8849);
        Mountain mountain2 = new Mountain("Монблан", "Франция", 4810);
        Mountain mountain3 = new Mountain("Эльбрус", "Россия", 5642);

        Group group1 = new Group(mountain1,3);
        Group group2 = new Group(mountain2,3);
        Group group3 = new Group(mountain3,3);

        Climber climber1 = new Climber("Иван 1", "Улица строителей");
        Climber climber2 = new Climber("Иван 2", "Улица строителей");
        Climber climber3 = new Climber("Иван 3", "Улица строителей");
        Climber climber4 = new Climber("Иван 4", "Улица строителей");
        Climber climber5 = new Climber("Иван 5", "Улица строителей");
        Climber climber6 = new Climber("Иван 6", "Улица строителей");
        Climber climber7 = new Climber("Иван 7", "Улица строителей");

        group1.addClimber(climber1);
        group1.addClimber(climber2);
        group1.addClimber(climber3);

        group2.addClimber(climber4);
        group2.addClimber(climber5);

        group3.addClimber(climber6);
        group3.addClimber(climber7);

        group1.printGroupStatus();
        group2.printGroupStatus();
        group3.printGroupStatus();
    }
}
