package lesson5;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkFifthLesson {

    public static void main(String[] args) {

        // HomeTask01

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Введите размер массива");
        int n = scanner.nextInt();
        String[] Arr1 = new String[n];

        String param;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите элемент массива № " + i);
            param = scanner1.nextLine();
            if (param.equals("exit")) {
                System.out.println("Выход из программы");
                System.out.println(Arrays.toString(Arr1));
                return;
            }
            for (int j = 0; j < i; j++) {
               while ((Arr1[j]).equals(param)) {
                   System.out.println("Такое словое уже есть в массиве, введите другое");
                   param = scanner1.nextLine();
                   j = 0;
                   if (param.equals("exit")) {
                       System.out.println("Выход из программы");
                       System.out.println(Arrays.toString(Arr1));
                       return;
                   }
               }
            }
            Arr1[i] = param;
        }
        System.out.println(Arrays.toString(Arr1));

        // HomeTask02


        String word = scanner1.nextLine();
        String firstChar = word.substring(0, 1);
        String otherChars = word.substring(1);

        firstChar = firstChar.toUpperCase();
        otherChars = otherChars.toLowerCase();

        String updatedWord = firstChar + otherChars;

        System.out.println(updatedWord);


        //HomeTask03

        String sentence = "в предложении все слова разной длины";
        String[] sentenceArr = sentence.split(" ");
        int maxIndex = 0;

        for (int i = 0, max = 0; i < sentenceArr.length; i++) {
            if (max < sentenceArr[i].length()) {
                max = sentenceArr[i].length();
                maxIndex = i;
            }
        }

        System.out.println("Самое длинное слово - " + sentenceArr[maxIndex]);


        // HomeTask04

        System.out.println("Введите строку для проверки, является ли она палиндромом");
        StringBuilder sentence2 = new StringBuilder(scanner1.nextLine());
        String palindrom = sentence2.toString();
        String palindromReverse = sentence2.reverse().toString();


        System.out.println(palindrom);
        System.out.println(palindromReverse);

        if (palindrom.equalsIgnoreCase(palindromReverse)) {
            System.out.println("Это палиндром");
        } else System.out.println("Это не палиндром");













    }

}

