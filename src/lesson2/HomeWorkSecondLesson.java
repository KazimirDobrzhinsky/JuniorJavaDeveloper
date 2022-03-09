package lesson2;

public class HomeWorkSecondLesson {
    public static void main(String[] args) {

        // Задача на if:

        int count = 50;

        if ((count > 100) || (count < 0)) System.out.println("Ошибка");
        else if (count >= 90) System.out.println("Отлично");
        else if (count >= 60) System.out.println("Хорошо");
        else if (count >= 40) System.out.println("Удовлетворительно");
        else if (count >= 0) System.out.println("Попробуйте в следующий раз");

        // Задача на switch

        double x = 10, y = 10;
        int z = 9;
        double res;

        switch (z) {
            case 3:
                res = x + y;
                System.out.println(res); // Вывод лучше выводить за пределы switch, чтобы избежать дублирования кода
                break;
            case 5:
                res = x - y;
                System.out.println(res);
                break;
            case 7:
                res = x * y;
                System.out.println(res);
                break;
            case 9:
                res = x / y; // Здесь нужно было проверять деление на ноль
                System.out.println(res);
                break;
            default:
                System.out.println("Ошибка");
        }

        // Задача на Math.random() и if

        int random = (int) (Math.random() * (500 - 10 + 1)+10);
        if ((random > 25) && (random < 200)) System.out.println("Число " + random + " содержится в интервале (25;200)");
        else System.out.println("Число " + random + " не содержится в интервале (25;200)");

        // Задача на if:

        int age = 100;
        int exp = 4;

        if (age > 100) System.out.println("Мы вам перезвоним");
        else if (exp < 5) System.out.println("Вы подходите на должность стажера");
        else System.out.println("Вы подходите на должность разработчика");


        // Задача по решению на уроке

        int month = 1;

        if ((month > 12) || (month <= 0)) System.out.println("Ошибка");
        else if (month > 11) System.out.println("Зима");
        else if (month > 8) System.out.println("Осень");
        else if (month > 5) System.out.println("Лето");
        else if (month > 2) System.out.println("Весна");
        else System.out.println("Зима");


    }
}
