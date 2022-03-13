package lesson4;

import java.util.Arrays;

public class FourthLesson {

    public static void main(String[] args) {

        // примитивные типы данных
        // ссылочные типы данных
        /*
        int a = 78; // [78] a
        int b = a; // [78] b
        a = 100;

        Scanner scanner = new Scanner(System.in); // [scanner] scanner
        Scanner in = scanner; // обе переменные к одной области памяти
        */
/*
        int[] ints1 = new int[7]; // 7 - размер массива (кол-во элементов)
        // int ints2[] - тоже возможно
        //System.out.println(ints1); не выдает информацию по массиву - [I@1b28cdfa
        System.out.println(Arrays.toString(ints1));

        int[] ints2 = {6, -9, 56, 12, 0, -44};
        System.out.println(Arrays.toString(ints2));

        ints2 = new int[3];
        System.out.println(Arrays.toString(ints2));

        // ints2 = {34, 78, 12}; - так делать нельзя

        ints2 = new int[] {34, 78, 12};
        System.out.println(Arrays.toString(ints2));

        int len = 10;
        int[] ints3 = new int[len];
        int[] ints4 = new int[len + 5];

        System.out.println(ints4.length); // узнать сколько элементов в массиве

        // доступ к элементам массива

        System.out.println(ints2[2]);

        ints4[4] = 56;
        System.out.println(Arrays.toString(ints4));

        // многомерный массив
        // [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]

        int[][] intsMas = new int[3][4];
        System.out.println(Arrays.deepToString(intsMas));
        // [[0, 0, 0], [0, 0], [0, 0, 0, 0]]

        int[][] intsMas2 = new int[3][];
        System.out.println(Arrays.deepToString(intsMas2));
        intsMas2[0] = new int[3];
        intsMas2[1] = new int[2];
        intsMas2[2] = new int[4];
        System.out.println(Arrays.deepToString(intsMas2));
*/
/*        int[] ints5  = {3, -6, 12, 0, 4};

        // перебор массива
        for (int i = 0; i < ints5.length; i++) {
            ints5[i] *= ints5[i];
        }

        int sum = 0;
        for (int i = 0; i < ints5.length; i++) {
            sum += ints5[i];
        }
        System.out.println(sum);

        // цикл foreach не позволяет изменять элементы массива
        // не предоставляет доступ к индексам
        for (int element: ints5) {
            System.out.println(element);
        }
*/
/*        double[] ints8 = {3.7, -6.2, 12.9, 0.4, 4.1};

        double minElement = ints8[0];

        for (double element: ints8) {
            if (minElement > element) {
                minElement=element;
            }
        }
        System.out.println(minElement);

        double randMas;
        randMas = ints8[(int) (Math.random() * ints8.length)];
        System.out.println(randMas);

        Arrays.sort(ints8);
        System.out.println(Arrays.toString(ints8));

        int element = Arrays.binarySearch(ints8, 1);
        System.out.println(element);
*/
        double[] ints9 = {3.7, -6.2, 12.9, 0.4, 4.1};
        System.out.println(Arrays.toString(ints9));

        // double[] ints10 = ints9; так копировать нельзя - получаются две ссылки на один и тот же массив

        double[] cloneInts9 = ints9.clone();
        System.out.println(Arrays.toString(cloneInts9));

        double[] copyInts9 = Arrays.copyOf(ints9, 5);
        System.out.println(Arrays.toString(copyInts9));

        double[] newDoubles = new double[10];
        System.arraycopy(ints9, 1, newDoubles, 3, 2);
        System.out.println(Arrays.toString(newDoubles));

    }
}
