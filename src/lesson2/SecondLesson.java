package lesson2;

import java.io.PrintStream;
import java.sql.SQLOutput;

public class SecondLesson {
    public static void main(String[] args) {
        // логические операторы
        // && оператор и
        int x = 50, y = 100, z = 91;
        boolean res = (x % 2 == 0) && (y % 2 == 0) && (z % 2 == 0);
        //              true && true && false
        //              true && false
        //              false
        System.out.println(res); // false
        res = (x < z) && (y > z); // true && true
        System.out.println(res);

        //  || оператор и
        int code = 3333, age = 34;
        res = (code == 2222) || (code == 3333) || (code == 4444);
        System.out.println(res); // true

        res = (code != 3333) || (age < 18);
        //      false || false
        System.out.println(res); // false

        //  ! оператор не - меняет значение на противоположное
        System.out.println(!res); // true

        boolean isActive = false, isConnected = true;
        res = !isActive || !isConnected;
        // true || false => true без проверки второго операнда
        System.out.println(res);

        res = !((code != 3333) || (age < 18));
        // !(false || false) => !(false) => true
        System.out.println(res); // true

        int state = 1;
        if (state == 0) System.out.println("Закрытие приложения");
        else if (state == 1) System.out.println("Открытие приложения");
        else System.out.println("Ошибка статуса");

        int month  = -142;

        if ((month == 12) || (month > 0) && (month <= 2)) System.out.println("Зима");
        else if ((month > 2) && (month <= 5)) System.out.println("Весна");
        else if ((month > 5) && (month <= 8)) System.out.println("Лето");
        else if ((month >8) && (month <= 11)) System.out.println("Осень");
        else System.out.println("Ошибка");

        // сделать по  возрастанию

        month = 5;
        switch (month) {
            case 1:
            case 2:
            case 12:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("Ошибка");
        }

        int sum = 1000, saleCode = 4525;
        switch (saleCode) {
            case 4525:
                System.out.println(sum * 0.7);
                break;
            case 6424:
            case 7012:
                System.out.println(sum * 0.8);
                break;
            case 7647:
            case 9011:
            case 6612:
                System.out.println(sum * 0.9);
                break;
            default:
                System.out.println(sum);
        }

    }
}
