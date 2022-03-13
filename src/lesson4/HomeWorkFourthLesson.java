package lesson4;

import java.util.Arrays;

public class HomeWorkFourthLesson {
    public static void main(String[] args) {

        // HomeTask01

        int n = 7;
        int max, min, sum = 0;
        double average;
        int[] ints1 = new int[n];

        for (int i = 0; i < ints1.length; i++) {
            ints1[i] = (int) (Math.random() * 100 + 1);
        }

        Arrays.sort(ints1);

        min = ints1[0];
        max = ints1[ints1.length - 1];
        for (int element : ints1) {
            sum += element;
        }
        average = (double) sum / ints1.length;

        System.out.println("Максимальное значение - " + max + ", минимальнное значение - " +
                min + ", среднее значение - " + average);

        // HomeTask02

        int first = 2, last = 20;
        int[] ints2 = new int[(last - first) / 2 + 1];

        ints2[0] = first;

        for (int i = 0; i < ints2.length; i++) {
            ints2[i] = 2 + i * 2;
        }

        for (int i = ints2.length - 1; i >= 0; i--) {
            System.out.print(ints2[i] + " ");
        }
        System.out.println("");

        // HomeTask03

        int[] ints3 = new int[11];

        for (int i = 0; i < ints3.length; i++) {
            ints3[i] = (int) (Math.random() * (2 + 1)) - 1;
        }

        System.out.println(Arrays.toString(ints3));

        int amount1 = 0, amountZero = 0, amountMinus1 = 0;

        for (int j : ints3) {
            if (j == 1) {
                amount1 += 1;
                continue;
            }
            if (j == -1) {
                amountMinus1 += 1;
                continue;
            }
            if (j == 0) {
                amountZero += 1;
            }
        }

        if ((amount1 != amountZero) && (amountZero != amountMinus1) && (amount1 != amountMinus1)) {
            if ((amount1 > amountMinus1) && (amount1 > amountZero)) {
                System.out.println("Чаще всего встречается 1");
            } else if ((amountMinus1 > amount1) && (amountMinus1 > amountZero)) {
                System.out.println("Чаще всего встречается -1");
            } else System.out.println("Чаще всего встречается 0");
        }

        // HomeTask04

        int[] ints4 = {3, -6, 12, 0, 4, 78, 21, -4, -6, 43, -59, 11, 34, 78, 13};

        int oddLength = 0, evenLength = 0;

        for (int j : ints4) {
            if ((j % 2) == 0) {
                evenLength++;
            } else oddLength++;
        }

        int[] ints4Even = new int[evenLength], ints4Odd = new int[oddLength];

        for (int i = 0, iEven = 0, iOdd = 0; i < ints4.length; i++) {
            if (ints4[i] % 2 == 0) {
                ints4Even[iEven] = ints4[i];
                iEven++;
            } else {
                ints4Odd[iOdd] = ints4[i];
                iOdd++;
            }
        }

        Arrays.sort(ints4Even);
        Arrays.sort(ints4Odd);

        System.out.println("Массив четных чисел, отсортированый по возрастанию - " + Arrays.toString(ints4Even));
        System.out.println("Массив нечетных чисел, отсортированый по возрастанию - " + Arrays.toString(ints4Odd));

        // HomeTask05

        int[] ints5 = {3, -6, 12, 0, 4, 78, 21, -4, -6, 43, -59, 11, 34, 78, 13};

        int negativeLength = 0;

        for (int j : ints5) {
            if (j < 0) negativeLength++;
        }

        int[] ints5Negative = new int[negativeLength];

        for (int i = 0, iNegative = 0; i < ints5.length; i++) {
            if (ints5[i] < 0) {
                ints5Negative[iNegative] = ints5[i];
                iNegative++;
            }
        }

        System.out.println(Arrays.toString(ints5Negative));


    }


}
