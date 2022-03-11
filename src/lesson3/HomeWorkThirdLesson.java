package lesson3;

import java.util.Scanner;

public class HomeWorkThirdLesson {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // HomeTask01

        for (int res = 1, n = 1; n <= 55; n += 1, res += 2) {
            System.out.println(res);
        }

        // HomeTask02

        System.out.println("Введите целое положительное число");
        int num = scanner.nextInt();
        int sum = 0;
        if (num > 0) {
            while (num > 0) {
                sum = sum + num % 10;
                num = num / 10;
            }
            System.out.println("Сумма всех цифр равна " + sum);
        } else System.out.println("Ошибка");



        // HomeTask03

        int rand = (int) (Math.random() * (9 - 1 + 1)+1);
        int guess = 0;
        System.out.println("Было загадано число от 1 до 9");
        while (guess != rand) {
            System.out.println("Попробуйте угадать число");
            guess = scanner.nextInt();
            if (guess == 0) {
                System.out.println("Выход из программы");
                break;
            }
            if (guess == rand) {
                System.out.println("Вы угадали");
                break;
            }
            if (guess < rand) {
                System.out.println("Загаданное число больше");
                continue;
            }
            System.out.println("Загаданное число меньше");

        }

        // HomeTask04

        System.out.println("Загадайте число от 2 до 100, на вопросы следует отвечать 0 - НЕТ, 1 - ДА");
        int firstElement = 2, lastElement = 100;
        int mid;
        int reply;
        while (firstElement <= lastElement) {
            mid = (firstElement + lastElement) / 2;
            System.out.println("Число равно - " + mid + "?");
            reply = scanner.nextInt();
            if ((reply != 0) && (reply != 1)) {
                System.out.println("Допускается только ответы 0 или 1, попробуйте заново");
                continue;
            }
            if (reply == 1) {
                System.out.println("Программа угадала");
                break;
            }
            System.out.println("Число больше - " + mid + "?");
            reply = scanner.nextInt();
            if (reply == 1) {
                firstElement = mid;
            } else {
                lastElement = mid;
            }
            mid = (firstElement + lastElement) / 2;
            System.out.println("Число меньше - " + mid + "?");
            reply = scanner.nextInt();
            if (reply == 1) {
                lastElement = mid;
            } else {
                firstElement = mid;
            }
        }


    }
}
