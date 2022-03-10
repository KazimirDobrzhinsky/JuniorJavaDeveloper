package lesson3;

import java.util.Scanner;

public class ThirdLesson {
    public static void main(String[] args) {

        // Пользовательский ввод

        Scanner in = new Scanner(System.in);
        int userNum;
        /* System.out.println("Введите целое число");
        userNum = in.nextInt();
        System.out.println(userNum * userNum);

        while (true) {
            System.out.println("Введите целое число" + " или 0 для выхода из программы");
            userNum = in.nextInt();
            if (userNum == 0) break; // завершает текущий цикл (без выполнения любых последующих действий в цикле)
            if (userNum < 0) continue; // переход на следующуюю итерацию (без выполнения любых последующих действий в цикле)
            System.out.println(userNum * userNum);
        }
        */

        /* while (true) {}; Бесконечный цикл
        while (false) {}; Не будет выполняться

        do {} while (true); Бесконечный цикл
        do {} while (true); Выполнит один раз */

        /*
        do {
            System.out.println("Введите целое число" + " или 0 для выхода из программы");
            userNum = in.nextInt();
            if (userNum < 0) continue;
            System.out.println(userNum * userNum);
        } while (userNum != 0);
        */

        /*int start = 1, end = 12;
        // вывести все четные числа от start до end
        while (start <= end) {
            if (start % 2 == 0) System.out.println(start);
            start += 1;
        }

        /* for (инициализация переменных; условие; обновление значений переменных) {

        }


        for (start = 1, end = 12; start <= end; start += 1) {
            if (start % 2 == 0) System.out.println(start);
        }
        */


        // вывести все неотрицательные элементы последовательности 90 85 80 75 и тд

        /*for (int start = 90; start >= 0; start -= 5) {
            System.out.println(start);
        }
        */

        // вывести первые 10 элементов последовательности 2 4 6 8 10
        /*for (int res = 2, n = 1; n <= 10; n += 1) {
            System.out.println(res);
            res += 2;
        }
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во тарелок");
        int plates = scanner.nextInt();
        System.out.println("Введите кол-во средства");
        double fairy = scanner.nextDouble();

        while ((fairy > 0) && (plates > 0)) {
            plates -= 1;
            fairy -= 0.5;
            System.out.println("Осталось " + (fairy) + " моющего средства после помывки тарелки");
        }
        System.out.println("Осталось " + (plates) + " грязных тарелок и " + (fairy) + " моющего средства");
    }
}
